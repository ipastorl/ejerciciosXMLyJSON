package U9.transacciones;

import java.sql.Connection;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {
        Connection connection = ConnectionDataBase.getConnection();

        try{
            // evitar no romper la lógica de negocio, con el autocommit a false, no se insertará nada,
            // si no se ha terminado el bloque de código try entero,
            // pero no se puede olvidar después hacer el connection.commit
            connection.setAutoCommit(false);

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
            connection.commit();



        } catch (SQLException sqlException) {
            System.err.println(sqlException.getMessage());
            try {
                if (connection != null) {
                    System.out.println(
                            "Dejamos la BD en estado consistente. Ya se pueden hacer otros commits consistentemente.");

                    // si en la transacción ha ocurrido un error, vuelve al estado anterior (borra) las insercciones
                    // pendientes de commit que han quedado
                    connection.rollback();
                }
            } catch (SQLException throwables) {
                System.out.println("Error en el rollback.");
                throwables.printStackTrace();
            }
        }
    }
}
