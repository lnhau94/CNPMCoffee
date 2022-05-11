package Main.Admin.SalaryCalculate.Controller;

public class MonthOfYear {
    private  String monthName;
    private  int monthID;

    public MonthOfYear(String monthName, int monthID) {
        this.monthName = monthName;
        this.monthID = monthID;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getMonthID() {
        return monthID;
    }

    public void setMonthID(int monthID) {
        this.monthID = monthID;
    }
}

