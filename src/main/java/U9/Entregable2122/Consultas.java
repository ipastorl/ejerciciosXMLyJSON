package U9.Entregable2122;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * FiltroPrecio() que muestre por pantalla aquellos productos cuyos buyPrice
 * sean mayores que un precio que se solicita por pantalla al usuario.
 *
 * InfoPagos() que solicita al usuario el número del cliente (customerNumber)
 * y muestra por pantalla el nombre del cliente, el checkNumber,
 * el paymentDate y la cantidad de todos los pagos (payments) que ha realizado.
 *
 * informeCategoria() que solicitará al usuario el nombre de una categoría (productLine)
 * determinada y mostará el nombre de todos los productos de dicha categoría así como
 * las unidades vendidas para cada uno de esos productos y el total de todas esas unidades.
 */
public class Consultas {

    public static void main(String[] args) {
       FiltroPrecio();
       InfoPagos();
       informeCategoria();
    }

    /**
     * muestre por pantalla aquellos productos cuyos buyPrice
     * sean mayores que un precio que se solicita por pantalla al usuario.
     */
    public static void FiltroPrecio() {
        try {
            Connection connection = ConexionDB.getConnection();
            Scanner sc = new Scanner(System.in);
            Double precio = 0.0;
            System.out.println(" Introduzca un precio: ");
            precio = sc.nextDouble();
            String consulta = "SELECT * FROM products WHERE buyPrice>" + precio;
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultset = preparedStatement.executeQuery();
            while (resultset.next()){
                System.out.println(resultset.getString(1) + " "
                        + resultset.getString(2) + " "
                        + resultset.getString("buyPrice"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * solicita al usuario el número del cliente (customerNumber)
     * y muestra por pantalla el nombre del cliente, el checkNumber,
     * el paymentDate y la cantidad de todos los pagos (payments) que ha realizado.
     */
    public static void InfoPagos() {

        try {
            Connection connection = ConexionDB.getConnection();
            Scanner sc = new Scanner(System.in);
            Integer numCliente = 0;
            System.out.println(" Introduzca el número del cliente a buscar : ");
            numCliente = sc.nextInt();
            String consulta = "SELECT * FROM customers JOIN payments ON customers.customerNumber=payments.customerNumber WHERE customers.customerNumber=" + numCliente;

            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultset = preparedStatement.executeQuery();


            while (resultset.next()){
                System.out.println(resultset.getString("customerNumber") + " "
                        + resultset.getString("checkNumber")+ " "
                        + resultset.getString("paymentDate")+ " "
                        + resultset.getString("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * solicitará al usuario el nombre de una categoría (productLine)
     * determinada y mostará el nombre de todos los productos de dicha categoría así como
     * las unidades vendidas para cada uno de esos productos y el total de todas esas unidades.
     */
    public static void informeCategoria() {
        try{
            Connection connection = ConexionDB.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduzca el nombre de una categoría: ");
            String categoria = sc.nextLine();
            String consulta =
                            "SELECT * " +
                            "FROM products JOIN orderdetails " +
                            "ON products.productCode=orderdetails.productCode " +
                            "WHERE products.productLine like '" + categoria + "'; ";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultset = preparedStatement.executeQuery();

            while (resultset.next()){
                System.out.println(resultset.getString("productName")+ " "
                        + resultset.getString("quantityOrdered") + " "
                        + resultset.getString("priceEach"));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


}
