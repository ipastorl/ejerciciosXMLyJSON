package Examen2021Again.ejercicio3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Crear una clase llamada consultas (siempre con PreparedStatements) que implemente la siguiente función:
 *
 * List<Office> MostrarOficinas() que devuelve una lista de oficina que se obtiene de la base de datos
 * y que será utilizada para mostrar toda esa información en formato JSON por pantalla.
 */
public class Consultas {
    public static void main(String[] args) {
        // obtener de la base de datos ClassicModels una lista de oficinas
        List<Office> oficinas = mostrarOficinas();
        // mostrar por pantalla en formato json
        System.out.println(new Gson().toJson(oficinas));

        // Otra forma de hacerlo
        Gson g = new Gson();
        Type listType = new TypeToken<ArrayList<Office>>() {}.getType();
        System.out.println(g.toJson(oficinas,listType));

    }

    private static List<Office> mostrarOficinas() {
        // crear la lista que devolveremos commo retorno, una vez rellenada
        List<Office> oficinas = new ArrayList<>();
        // Consulta en MySQL
        String consultaOficinas = "SELECT * FROM offices;";

        try{
            // abrir conexión con la BBDD classicModels
            Connection connection = BBDDConnection.getConnection();
            // Crear un PreparedStatment con el contenido de la consulta como parámetro
            PreparedStatement ps = connection.prepareStatement(consultaOficinas);
            // Arrojar los resultados de la consulta en un conjunto (Resulset)
            ResultSet resultSet = ps.executeQuery();
            // recorrer el conjunto
            while (resultSet.next()) {
                // Rellenar los parámetros del objeto Office of con las columnas (columIndex) de la BBDD
                Office of = new Office(resultSet.getString(1)
                        , resultSet.getString(2)
                        , resultSet.getString(3)
                        , resultSet.getString(4)
                        , resultSet.getString(5)
                        , resultSet.getString(6)
                        , resultSet.getString(7)
                        , resultSet.getString(8)
                        , resultSet.getString(9));
                // Se añade a la lista de oficinas
                oficinas.add(of);
                ////// ¡ IMPORTANTE CERRAR LA CONEXIÓN !!!! //////
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return oficinas;
    }
}
