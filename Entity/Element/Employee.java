package Main.Entity.Element;
//[EmployeeID] as ('EMP' + right(replicate('0', 4) + cast(ID as varchar(4)), 4)) persisted not null,
//        EmployeeName nvarchar(30) not null,
//        EmployeePhone varchar(12) not null,
//        WorkPositionID varchar(5) not null,
//        WorkTypeID varchar(5) not null
public class Employee {
    private String EmployeeID;
    private String EmployName;
    private int EmployPhone;
    private int WorkPositionID;
    private int WorkTypeID;

    public Employee(String employeeID, String employName, int employPhone, int workPositionID, int workTypeID) {
        EmployeeID = employeeID;
        EmployName = employName;
        EmployPhone = employPhone;
        WorkPositionID = workPositionID;
        WorkTypeID = workTypeID;
    }

    public Employee() {

    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployName() {
        return EmployName;
    }

    public void setEmployName(String employName) {
        EmployName = employName;
    }

    public int getEmployPhone() {
        return EmployPhone;
    }

    public void setEmployPhone(int employPhone) {
        EmployPhone = employPhone;
    }

    public int getWorkPositionID() {
        return WorkPositionID;
    }

    public void setWorkPositionID(int workPositionID) {
        WorkPositionID = workPositionID;
    }

    public int getWorkTypeID() {
        return WorkTypeID;
    }

    public void setWorkTypeID(int workTypeID) {
        WorkTypeID = workTypeID;
    }
}
