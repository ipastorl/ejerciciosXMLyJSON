package U9.transacciones;

import java.sql.Connection;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {
        Connection connection = ConnectionDataBase.getConnection();

        try{
            OfficeModel.insertOffice(
                    new Office(
                            "15",
                            "Bilbo",
                            "696 663344",
                            "calle la línea",
                            "s//n",
                            "",
                            "España",
                            "08555",
                            "norte"
                    )
            );
            System.out.println("Insertada oficina");

            EmployeeModel.insertEmployee(
                    new Employee(
                            1627,
                            "Hernandez",
                            "Juan",
                            "x8000",
                            "juanhernandez@classicmodelcars.com",
                            "1",
                            1102, // 1102
                            "Sales Rep"));
            System.out.println("Insertado empleado");

            // no olvidar hacer commit si no está el auto-commit
            //connection.commit();



        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
            try {
                if (connection != null) {
                    System.out.println(
                            "Dejamos la BD en estado consistente. Ya se pueden hacer otros commits consistentemente.");
                    connection.rollback();
                }
            } catch (SQLException throwables) {
                System.out.println("Error en el rollback.");
                throwables.printStackTrace();
            }
        }
    }
}
