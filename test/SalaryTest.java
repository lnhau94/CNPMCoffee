package Main.test;

import Main.Admin.SalaryCalculate.Controller.Employee;
import Main.Entity.DataAccess.DAO;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class SalaryTest {
    public int getDataSalary(String ComboBoxMonth, String empID) throws SQLException {
        DAO sqlEMP = new DAO();
        int month ;
        if(ComboBoxMonth==null){
            month = Month("May");
        }else {
            month = Month(ComboBoxMonth);
        }
        int tmp = 0;
        ResultSet emp = sqlEMP.executeQuery("(SELECT Employee.EmployeeID,Employee.EmployeeName,\n" +
                "WorkPosition.WorkPositionName,WorkType.WorkTypeName,PositionType.SalaryPerHour\n" +
                "FROM Employee,WorkPosition,WorkType,PositionType\n" +
                "WHERE Employee.WorkPositionID=WorkPosition.WorkPositionID \n" +
                "\t\tAND Employee.WorkTypeID = WorkType.WorkTypeID \n" +
                "\t\tAND Employee.WorkPositionID=PositionType.WorkPositionID \n" +
                "\t\tAND Employee.WorkTypeID =PositionType.WorkTypeID)\n");
        while (emp.next()){
            tmp  = 1;
            String employeeID = emp.getString(1);
            String employeeName = emp.getString(2);
            String employeePosition = emp.getString(4);
            String employeeType = emp.getString(3);
            int    employeeSalaryPerHour = emp.getInt(5);
            int    date = CountDate(employeeID,month);
            int    hour = CountHour(employeeID,month);
            int salary;
            if(employeeType.equals("Parttime")){
                salary = employeeSalaryPerHour*hour;
            }else {
                salary = employeeSalaryPerHour*8*date;
            }
            Employee newEmployee = new Employee(employeeID,employeeName,employeePosition,employeeType,employeeSalaryPerHour,date,hour,salary);
        }
        return tmp;
    }
    public static int Month(String x){
        int tmp;
        switch (x){
            case "Jan":
                tmp=1;
                break;
            case "Feb":
                tmp=2;
                break;
            case "Mar":
                tmp =3;
                break;
            case "Apr":
                tmp=4;
                break;
            case "May":
                tmp=5;
                break;
            case "Jun":
                tmp=6;
                break;
            case "Jul":
                tmp=7;
                break;
            case "Aug":
                tmp=8;
                break;
            case "Sep":
                tmp=9;
                break;
            case "Oct":
                tmp=10;
                break;
            case "Nov":
                tmp=11;
                break;
            case "Dec" :
                tmp=12;
                break;
            default:
                tmp=1;
                break;
        }
        return  tmp;
    }
    public int CountDate(String empID, int month) throws  SQLException{
        DAO sqlCountDate = new DAO();
        ResultSet date = sqlCountDate.executeQuery("SELECT COUNT(DailyDate) FROM DailyWork\n" +
                "WHERE DATEPART(MONTH,DailyDate)='"+month+"' AND EmployeeID='"+empID+"';");
        int kq = 0;
        while (date.next()){
            kq = date.getInt(1);
        }
        return kq;
    }
    public int CountHour(String empID, int month) throws  SQLException{
        DAO sqlCountHour = new DAO();
        ResultSet hour = sqlCountHour.executeQuery("SELECT SUM(WorkingHour) FROM DailyWork\n" +
                "WHERE DATEPART(MONTH,DailyDate)='"+month+"' AND EmployeeID='"+empID+"';");
        int kq = 0;
        while (hour.next()){
            kq = hour.getInt(1);
        }
        return kq;
    }

//    @Test
//    public void test1() throws SQLException {
//        assertNotSame(0,getDataSalary("",""));
//    }
//    @Test
//    public void test2() throws SQLException {
//        assertNotSame(0,getDataSalary("","EMP0001"));
//    }
//    @Test
//    public void test3() throws SQLException {
//        assertNotSame(0,getDataSalary("May","EMP0001"));
//    }
//    @Test
//    public void test4() throws SQLException {
//        assertNotSame(0,getDataSalary("May",""));
//    }
    @Test
    public void testCountDate1() throws SQLException {
        assertEquals(0,CountDate("0",0));
    }
    @Test
    public void testCountDate2() throws SQLException {
        assertNotSame(0,CountDate("EMP0001",11));
    }
}
