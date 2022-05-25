package Examen2021Again.ejercicio4;

import U8U9Examen2021.Order;
import U8U9Examen2021.OrderDetails;
import U8U9Examen2021.OrderDetailsModel;
import U8U9Examen2021.OrderModel;
import U8U9Examen2021.Product;
import U8U9Examen2021.ProductModel;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * clase Transacciones ===== usando clases modelo o no (es indiferente) realice la siguiente transacción:
 *
 * insertarPedido() que inserte los datos de un pedido que contenga al menos 2 productos diferentes.
 */
public class Transacciones {
    private static final Connection CONNECTION = BBDDConnection.getConnection();
    public static void main(String[] args) throws SQLException {
        insertarPedido();
        System.out.println("================== Insertado pedido ===================");
        CONNECTION.close();
        System.out.println("================== Conexión cerrada ===================");
    }

    private static void insertarPedido() {

        // producto 1
        U8U9Examen2021.Product product = new U8U9Examen2021.Product();
        product.setProductCode("33308");
        product.setProductName("Alvia50");
        product.setProductLine("Planes");
        product.setProductScale("1:10");
        product.setProductVendor("Vendedor Uno");
        product.setProductDescription("del bueno");
        product.setQuantityInStock(10);
        product.setBuyPrice(1100.00);
        product.setMSRP(100.00);
        // producto 2
        U8U9Examen2021.Product product2 = new Product();
        product2.setProductCode("33309");
        product2.setProductName("Uta500");
        product2.setProductLine("Trains");
        product2.setProductScale("1:10");
        product2.setProductVendor("Vendedor Dos");
        product2.setProductDescription("Muy bueno");
        product2.setQuantityInStock(10);
        product2.setBuyPrice(1100.00);
        product2.setMSRP(100.00);
        // detalle pedido1
        U8U9Examen2021.OrderDetails od = new U8U9Examen2021.OrderDetails();
        od.setOrderNumber(343);
        od.setProductCode("33308");
        od.setQuantityOrdered(3);
        od.setPriceEach(1100.00);
        od.setOrderLineNumber(3);
        // detalle pedido2
        U8U9Examen2021.OrderDetails od2 = new OrderDetails();
        od2.setOrderNumber(343);
        od2.setProductCode("33309");
        od2.setQuantityOrdered(3);
        od2.setPriceEach(1100.00);
        od2.setOrderLineNumber(3);
        // pedido
        U8U9Examen2021.Order order = new Order();
        order.setOrderNumber(343);
        order.setOrderDate("2020/03/03");
        order.setRequiredDate("2021/04/08");
        order.setShippedDate("2022/06/23");
        order.setStatus("Status Quo");
        order.setComments("no comments");
        order.setCustomerNumber(9999);
        try{
            CONNECTION.setAutoCommit(false);

            U8U9Examen2021.ProductModel.insertProduct(product);
            System.out.println("Insertado primer producto");



            OrderModel.insertOrder(order);
            System.out.println("Insertado pedido final");

            U8U9Examen2021.OrderDetailsModel.insertOrderDetails(od);
            System.out.println("Insertado detalles del pedido 1");

            ProductModel.insertProduct(product2);
            System.out.println("Insertado segundo producto");

            OrderDetailsModel.insertOrderDetails(od2);
            System.out.println("Insertado detalles del pedido 2");

            CONNECTION.commit();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            try {
                if(CONNECTION != null){
                    CONNECTION.rollback();
                    System.out.println("================== Rollback realizado ===================");
                    CONNECTION.close();
                    System.out.println("================== Conexión cerrada ===================");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
