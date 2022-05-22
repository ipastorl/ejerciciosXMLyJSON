package U9.Entregable2122;

import U9.transacciones.ConnectionDataBase;
import U9.transacciones.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeModel {

    /**
     * Método para insertar empleados en la tabla employees
     * @param employee
     * @throws SQLException
     */
    public static void insertEmployee(Employee employee) throws SQLException {
        Connection connection = ConnectionDataBase.getConnection();
        String sentenciaSql = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSql);

        preparedStatement.setInt(1, employee.getEmployeeNumber());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getFirstName());
        preparedStatement.setString(4, employee.getExtension());
        preparedStatement.setString(5, employee.getEmail());
        preparedStatement.setString(6, employee.getOfficeCode());
        preparedStatement.setInt(7, employee.getReportsTo());
        preparedStatement.setString(8, employee.getJobTitle());

        preparedStatement.execute();
    }

}
