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

        try{
            connection.setAutoCommit(false);

            OfficeModel.insertOffice(
                    new Office(
                            "9",
                            "Tokio",
                            "+01 696 663344",
                            "calle la línea",
                            "41",
                            "",
                            "Japan",
                            "08555",
                            "center"
                    )
            );
            System.out.println("Insertada oficina");

            EmployeeModel.insertEmployee(
                    new Employee(
                            15111,
                            "Sainz",
                            "Manuel",
                            "x8000",
                            "juanjjjnandez@classicmodelcars.com",
                            "9",
                            1076,
                            "Sales Rep"));
            System.out.println("Insertado empleado");

            CustomerModel.insertCustomer(
                    new Customer(
                            9112,
                            15111,
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
                            13.10));
            System.out.println("Insertado cliente");

            CustomerModel.insertCustomer(
                    new Customer(
                            9113,
                            15111,
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
                            13.33));
            System.out.println("Insertado cliente");

            String consulta =
                    "UPDATE `employees` SET `officeCode`='9' WHERE `officeCode`='5'";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.execute();


            connection.commit();



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
