package U8U9Examen2021;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderModel {
    public static void insertOrder(Order order) throws SQLException {
        Connection connection = BBDDConnection.getConnection();
        String sentenciaSQL = "INSERT INTO orders VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sentenciaSQL);

        ps.setString(1,String.valueOf(order.getOrderNumber()));
        ps.setString(2,String.valueOf(order.getOrderDate()));
        ps.setString(3,String.valueOf(order.getRequiredDate()));
        ps.setString(4,String.valueOf(order.getShippedDate()));
        ps.setString(5, order.getStatus());
        ps.setString(6, order.getComments());
        ps.setString(7, String.valueOf(order.getCustomerNumber()));

        ps.execute();
    }
}
