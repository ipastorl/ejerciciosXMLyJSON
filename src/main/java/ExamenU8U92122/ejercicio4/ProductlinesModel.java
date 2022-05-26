package ExamenU8U92122.ejercicio4;

import U9.PerSiDeCas.BBDDConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductlinesModel {
    public static void insertarProductLine(ProductLines pl) throws SQLException {
        Connection connection = BBDDConnection.getConnection();
        String consultSQL = "INSERT INTO productlines VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(consultSQL);

        ps.setString(1,pl.getProductLine());
        ps.setString(2,pl.getTextDescription());
        ps.setString(3, pl.getHtmlDescription());
        ps.setString(4,pl.getImage());

        ps.execute();
    }
}
