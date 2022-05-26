package ExamenU8U92122.ejercicio4;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * Crear una clase Transacciones que usando clases modelo o no (es indiferente) realice la siguiente transacción:
 *
 * insertarLineaProducto() que inserte los datos de una línea de producto nueva (productLine)
 * y al menos dos productos asociados (products) a dicha línea de productos nueva.
 */
public class Transacciones {
    private static final Connection CONNECTION = BBDDConnection.getConnection();
    public static void main(String[] args) throws SQLException {
        insertarLineaProducto();
        System.out.println("================== Insertado linea producto ===================");
        CONNECTION.close();
        System.out.println("================== Conexión cerrada ===================");
    }

    private static void insertarLineaProducto() {

        // product line patinete
        ProductLines pl = new ProductLines();
        pl.setProductLine("Patinetes");
        pl.setTextDescription("Patinetes voladores");

        // producto 1
        Product product = new Product();
        product.setProductCode("33319");
        product.setProductName("Alvia50");
        product.setProductLine("Patinetes");
        product.setProductScale("1:10");
        product.setProductVendor("Vendedor Uno");
        product.setProductDescription("del bueno");
        product.setQuantityInStock(10);
        product.setBuyPrice(1100.00);
        product.setMSRP(100.00);
        // producto 2
        Product product2 = new Product();
        product2.setProductCode("33321");
        product2.setProductName("Uta500");
        product2.setProductLine("Patinetes");
        product2.setProductScale("1:10");
        product2.setProductVendor("Vendedor Dos");
        product2.setProductDescription("Muy bueno");
        product2.setQuantityInStock(10);
        product2.setBuyPrice(1100.00);
        product2.setMSRP(100.00);


        try{
            CONNECTION.setAutoCommit(false);
            ProductlinesModel.insertarProductLine(pl);
            ProductModel.insertProduct(product);
            System.out.println("Insertado primer producto");
            ProductModel.insertProduct(product2);
            System.out.println("Insertado segundo producto");

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
