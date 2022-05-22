package U8U9Examen2021;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDetailsModel {
    public static void insertOrderDetails(OrderDetails od) throws SQLException {
        Connection connection = BBDDConnection.getConnection();
        String consultaSQL = "INSERT INTO orderdetails VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(consultaSQL);
        ps.setString(1,String.valueOf(od.getOrderNumber()));
        ps.setString(2,od.getProductCode());
        ps.setString(3,String.valueOf(od.getQuantityOrdered()));
        ps.setString(4,String.valueOf(od.getPriceEach()));
        ps.setString(5,String.valueOf(od.getOrderLineNumber()));

        ps.execute();
    }

}
