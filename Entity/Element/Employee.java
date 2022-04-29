package Main.Entity.Element;

public class Employee {
    private String EmployeeID;
    private String EmployeeName;
    private int EmployeePhone;
    private int EmployeePosition;
    private int EmployeeWorkType;

    public Employee(String employeeID, String employeeName, int employeePhone, int employeePosition, int employeeWorkType) {
        EmployeeID = employeeID;
        EmployeeName = employeeName;
        EmployeePhone = employeePhone;
        EmployeePosition = employeePosition;
        EmployeeWorkType = employeeWorkType;
    }

    public Employee() {
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public int getEmployeePhone() {
        return EmployeePhone;
    }

    public void setEmployeePhone(int employeePhone) {
        EmployeePhone = employeePhone;
    }

    public int getEmployeePosition() {
        return EmployeePosition;
    }

    public void setEmployeePosition(int employeePosition) {
        EmployeePosition = employeePosition;
    }

    public int getEmployeeWorkType() {
        return EmployeeWorkType;
    }

    public void setEmployeeWorkType(int employeeWorkType) {
        EmployeeWorkType = employeeWorkType;
    }
}
