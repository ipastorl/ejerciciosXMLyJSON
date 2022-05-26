package ExamenU8U92122.ejercicio4;

import U8U9Examen2021.BBDDConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductModel {

    public static void insertProduct(Product p) throws SQLException {
        Connection connection = BBDDConnection.getConnection();
        String consultaSQL = "INSERT INTO products VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(consultaSQL);

        ps.setString(1,p.getProductCode());
        ps.setString(2,p.getProductName());
        ps.setString(3,p.getProductLine());
        ps.setString(4,p.getProductScale());
        ps.setString(5,p.getProductVendor());
        ps.setString(6,p.getProductDescription());
        ps.setString(7,String.valueOf(p.getQuantityInStock()));
        ps.setString(8,String.valueOf(p.getBuyPrice()));
        ps.setString(9,String.valueOf(p.getMSRP()));

        ps.execute();
    }

}
