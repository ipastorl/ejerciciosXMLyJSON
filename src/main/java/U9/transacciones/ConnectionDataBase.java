/**
 * Una conexión para la BBDD classicmodels
 */
package U9.transacciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {
    private static Connection connection = null;

    /**
     *
     * @return Connection
     */
    public static Connection getConnection(){
        try{
            if (connection == null){
                connection = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels?user=programacion&password=programacion"
                        + "&userUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetime=false&serverTimezone=UTC");
                System.out.println("Connection successful");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    public static void close(){
        try{
            if (connection != null) connection.close();
        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
        }
    }
}
