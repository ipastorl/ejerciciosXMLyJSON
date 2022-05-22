package U9.Entregable2122;

import U9.transacciones.ConnectionDataBase;
import U9.transacciones.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerModel {
    /**
     * Método para insertar oficinas en la tabla offices
     * @param customer
     * @throws SQLException
     */
    public static void insertCustomer(Customer customer) throws SQLException {
        Connection connection = ConnectionDataBase.getConnection();
        String sentenciaSql = "INSERT INTO customers VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSql);

        preparedStatement.setInt(1, customer.getCustomerNumber());
        preparedStatement.setInt(12, customer.getSalesRepEmployeeNumber());
        preparedStatement.setString(2, customer.getCustomerName());
        preparedStatement.setString(3, customer.getContactLastName());
        preparedStatement.setString(4, customer.getContactFirstName());
        preparedStatement.setString(5, customer.getPhone());
        preparedStatement.setString(6, customer.getAddressLine1());
        preparedStatement.setString(7, customer.getAddressLine1());
        preparedStatement.setString(8, customer.getCity());
        preparedStatement.setString(9, customer.getState());
        preparedStatement.setString(10, customer.getPostalCode());
        preparedStatement.setString(11, customer.getCountry());
        preparedStatement.setDouble(13,customer.getCreditLimit());

        preparedStatement.execute();
    }
}
