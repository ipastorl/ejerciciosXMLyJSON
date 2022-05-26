package ExamenU8U92122.ejercicio3;

import Examen2021Again.ejercicio3.BBDDConnection;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Crear una clase llamada Consultas (siempre con PreparedStatements) que implemente la siguiente función:
 *
 * List<Employee> MostrarEmpleados() que requerirá al usuario un código de oficina,
 * y devolverá la lista de empleados de esa oficina. Posteriormente,
 * en el programa principal desde donde se llame a esta función,
 * se utilizará esta lista de empleados para mostrar toda esa información en formato JSON por pantalla
 * (no es necesario que esté formateada correctamente).
 */
public class Consultas {
    public static void main(String[] args) throws SQLException {
        List<Employee> empleados = MostrarEmpleados();

        System.out.println(new Gson().toJson(empleados));
        Connection c = BBDDConnection.getConnection();
        c.close();
    }

    static List<Employee> MostrarEmpleados() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número de oficina: ");
        Integer oficina = sc.nextInt();
        List<Employee> empleados = new ArrayList<>();
        String consulta = "SELECT * FROM employees WHERE `employees`.`officeCode` LIKE ?;";
        try {
            Connection connection = BBDDConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(consulta);

            ps.setString(1,String.valueOf(oficina));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee( resultSet.getInt(1),
                            resultSet.getString(2)
                        , resultSet.getString(3)
                        , resultSet.getString(4)
                        , resultSet.getString(5)
                        , resultSet.getString(6)
                        , resultSet.getInt(7)
                        , resultSet.getString(8));

                empleados.add(employee);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return empleados;
    }
}