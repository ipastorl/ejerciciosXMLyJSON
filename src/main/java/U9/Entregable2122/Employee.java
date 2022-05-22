package U9.Entregable2122;

/**
 * Clase empleado con los atributos como final,
 * con Getters, sin Setters
 */
public class Employee {

    private final Integer employeeNumber;
    private final String lastName;
    private final String firstName;
    private final String extension;
    private final String email;
    private final String officeCode;
    private final Integer reportsTo;
    private final String jobTitle;

    public Employee(
            Integer employeeNumber,
            String lastName,
            String firstName,
            String extension,
            String email,
            String officeCode,
            Integer reportsTo,
            String jobTitle) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeNumber=" + employeeNumber +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", extension='" + extension + '\'' +
                ", email='" + email + '\'' +
                ", officeCode='" + officeCode + '\'' +
                ", reportsTo=" + reportsTo +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getExtension() {
        return extension;
    }

    public String getEmail() {
        return email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public Integer getReportsTo() {
        return reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
