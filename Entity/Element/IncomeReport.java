package Main.Entity.Element;

import java.sql.Date;

public class IncomeReport extends Report{

    private String supplier;

    public IncomeReport(String reportId, Date orderDate, String employeeIdCreate, String employeeIdConfirm, String supplier) {
        super(reportId, orderDate, employeeIdCreate, employeeIdConfirm);
        this.supplier = supplier;
    }

    public IncomeReport() {
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
