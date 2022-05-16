package U9;


import java.sql.*;

public class Principal {
    public static void main(String[] args) {
        Connection connection = null;

        // Crear una conexion a una base de datos
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/classicmodels?user=programacion&password=programacion");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // tiempo de respuesta 30 secs

            ResultSet rs = statement.executeQuery("SELECT * FROM offices");

            while (rs.next()) {
                System.out.println("name =  " + rs.getString( "city"));
                System.out.println("id = " + rs.getString("state"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


    }
}
