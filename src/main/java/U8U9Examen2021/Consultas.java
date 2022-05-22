package U8U9Examen2021;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Consultas {
    public static void main(String[] args) {
        System.out.println("prueba");
        mostrarOficinas();
    }
    public static List<Office> mostrarOficinas(){
        List<Office> oficinas = new ArrayList<>();
        Office of = null;
        String consultaOficinas = "SELECT * FROM offices;";
        Gson gson = null;
        try {
            Connection connection = BBDDConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(consultaOficinas);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                of = new Office(rs.getString(1), rs.getString(2), rs.getString(3)
                        , rs.getString(4), rs.getString(5), rs.getString(6)
                        , rs.getString(7), rs.getString(8), rs.getString(9));
                oficinas.add(of);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        System.out.println(oficinas);
 //       System.out.println(gson.toJson(oficinas));
        return oficinas;
    }
}
