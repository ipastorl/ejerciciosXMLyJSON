package ExamenU8U92122.ejercicio4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDDConnection {
    private static Connection connection = null;

    /**
     * Establece una conexión a la BDD
     * @return Connection
     */
    public static Connection getConnection(){
        try{
            if (connection == null){
                // para conectar con mi configuración Gradle/XAMPP/MySQL (en mi equipo funciona)
                connection = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels?user=programacion&password=programacion"
                        + "&userUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetime=false&serverTimezone=UTC");
                System.out.println("================== Conexión establecida ===================");

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }

    /**
     * Cierra la conexión a la base de datos
     */
    public static void closeConnection(){
        try{
            if (connection != null){
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

