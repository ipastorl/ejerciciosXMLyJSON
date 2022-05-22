package U8U9Examen2021;

import com.mysql.cj.result.LocalTimeValueFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * clase Transacciones que usando clases modelo o no (es indiferente) realice la siguiente transacción:
 *
 * insertarPedido() que inserte los datos de un pedido que contenga al menos 2 productos diferentes.
 */
public class Transacciones {
    public static void main(String[] args) {
        Connection connection = BBDDConnection.getConnection();
        // producto 1
        Product product = new Product();
        product.setProductCode("33333");
        product.setProductName("perico");
        product.setProductLine("Planes");
        product.setProductScale("1:10");
        product.setProductVendor("hhh");
        product.setProductDescription("del gueño");
        product.setQuantityInStock(10);
        product.setBuyPrice(1100.00);
        product.setMSRP(100.00);
        // producto 2
        Product product2 = new Product();
        product2.setProductCode("33334");
        product2.setProductName("perico");
        product2.setProductLine("Trains");
        product2.setProductScale("1:10");
        product2.setProductVendor("hhh");
        product2.setProductDescription("del gueño");
        product2.setQuantityInStock(10);
        product2.setBuyPrice(1100.00);
        product2.setMSRP(100.00);
        // detalle pedido1
        OrderDetails od = new OrderDetails();
        od.setOrderNumber(666);
        od.setProductCode("33333");
        od.setQuantityOrdered(3);
        od.setPriceEach(1100.00);
        od.setOrderLineNumber(3);
        // detalle pedido2
        OrderDetails od2 = new OrderDetails();
        od2.setOrderNumber(666);
        od2.setProductCode("33334");
        od2.setQuantityOrdered(3);
        od2.setPriceEach(1100.00);
        od2.setOrderLineNumber(3);
        // pedido
        Order order = new Order();
        order.setOrderNumber(666);
        order.setOrderDate("2020/03/03");
        order.setRequiredDate("2021/04/08");
        order.setShippedDate("2022/06/23");
        order.setStatus("Status Quo");
        order.setComments("puff");
        order.setCustomerNumber(9999);
        try{
            connection.setAutoCommit(false);

            ProductModel.insertProduct(product);
            System.out.println("Insertado primer producto");



            OrderModel.insertOrder(order);
            System.out.println("Insertado pedido final");

            OrderDetailsModel.insertOrderDetails(od);
            System.out.println("Insertado detalles del pedido 1");

            ProductModel.insertProduct(product2);
            System.out.println("Insertado segundo producto");

            OrderDetailsModel.insertOrderDetails(od2);
            System.out.println("Insertado detalles del pedido 2");

            connection.commit();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            try {
                if(connection != null){
                    connection.rollback();
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
