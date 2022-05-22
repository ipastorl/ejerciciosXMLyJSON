package U9.PerSiDeCas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentsModel {

    public static void insertPayment(Payments pay) throws SQLException {
        Connection connection = BBDDConnection.getConnection();
        String consultaSQL = "INSER INTO payments VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(consultaSQL);

        ps.setString(1,String.valueOf(pay.getCustomerNumber()));
        ps.setString(2,pay.getCheckNumber());
        ps.setString(3,pay.getPaymentDate());
        ps.setString(4,String.valueOf(pay.getAmount()));

        ps.execute();
    }

}
