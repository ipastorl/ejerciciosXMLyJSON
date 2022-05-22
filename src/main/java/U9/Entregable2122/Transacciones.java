package U9.Entregable2122;

import U9.transacciones.ConnectionDataBase;
import U9.transacciones.Employee;
import U9.transacciones.EmployeeModel;
import U9.transacciones.Office;
import U9.transacciones.OfficeModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Insertar un nuevo empleado (employee) y dos clientes que estén asociados a este nuevo empleado.
 *
 * Insertar una nueva oficina en Tokyo y trasladar todos los empleados de Tokyo a la nueva oficina.
 */
public class Transacciones {
    public static void main(String[] args) {
        Connection connection = ConnectionDataBase.getConnection();
        Office of = new Office(
                "13",
                "Tokio",
                "+01 696 663344",
                "calle la línea",
                "41",
                "",
                "Japan",
                "08555",
                "center");
        Employee em = new Employee(
                16569,
                "Sainz",
                "Manuel",
                "x8000",
                "juanjjjnandez@classicmodelcars.com",
                "10",
                1002,
                "VP Sales");
        Customer cli1= new Customer(
                93398,
                15666,
                "Alonso",
                "Gonzalez",
                "Grau",
                "652228445",
                "calle olvido",
                "12",
                "morrinya",
                "",
                "03+630",
                "España",
                13.10);
        Customer cli2 = new Customer(
                93399,
                15666,
                "Alberto",
                "Gonzalez",
                "Grau",
                "6525528445",
                "calle olvido2",
                "123",
                "morrinydda",
                "",
                "03+630d",
                "España",
                13.33);
        try{
            connection.setAutoCommit(false);

            OfficeModel.insertOffice(of);
            System.out.println("Insertada oficina");

            EmployeeModel.insertEmployee(em);
            System.out.println("Insertado empleado");

            CustomerModel.insertCustomer(cli1);
            System.out.println("Insertado cliente");

            CustomerModel.insertCustomer(cli2);
            System.out.println("Insertado cliente");

            connection.commit();

            // comprobar la insercción de oficina
            String consultaSQL1 = "SELECT * FROM `offices` WHERE officeCode= ?";
            PreparedStatement ps1 = connection.prepareStatement(consultaSQL1);
            ps1.setString(1,of.getOfficeCode());
            ResultSet resultSet1 = ps1.executeQuery();


            while (resultSet1.next()){
                System.out.println(resultSet1.getString(1) + ", "
                                + resultSet1.getString(2) + ", "
                       + resultSet1.getString(3) + ", "
                       + resultSet1.getString(4) + ", "
                       + resultSet1.getString(5) + ", "
                       + resultSet1.getString(6));
            }

        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException sqlException1) {
                sqlException1.printStackTrace();
            }
        }
    }
}
