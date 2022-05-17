package U9.transacciones;

import javax.sql.rowset.Predicate;
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
        // Abrir la conexión
        Connection connection = ConnectionDataBase.getConnection();
        // Introducir la sentencia SQL, para cada columna se escribe una '?'
        String sentenciaSql = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?)";
        // Se crea un PreparedStatement para evitar código malicioso en nuestra BBDD
        PreparedStatement preparedStatement = connection.prepareStatement(sentenciaSql);

        // Para cada parámetro '?' se introduce su index y un getter del objeto empleado
        preparedStatement.setInt(1, employee.getEmployeeNumber());
        preparedStatement.setString(2, employee.getLastName());
        preparedStatement.setString(3, employee.getFirstName());
        preparedStatement.setString(4, employee.getExtension());
        preparedStatement.setString(5, employee.getEmail());
        preparedStatement.setString(6, employee.getOfficeCode());
        preparedStatement.setInt(7, employee.getReportsTo());
        preparedStatement.setString(8, employee.getJobTitle());

        // ejecución
        preparedStatement.execute();
    }

}
