package id.com.service.mh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_income")
public class CustomerIncome {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String customerIncomeId;
    private Double customerSalary;
    private Double customerBusinessTurnover;
    private Double othersIncome;

    public CustomerIncome() {
    }

    public String getCustomerIncomeId() {
        return customerIncomeId;
    }

    public void setCustomerIncomeId(String customerIncomeId) {
        this.customerIncomeId = customerIncomeId;
    }

    public Double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(Double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public Double getCustomerBusinessTurnover() {
        return customerBusinessTurnover;
    }

    public void setCustomerBusinessTurnover(Double customerBusinessTurnover) {
        this.customerBusinessTurnover = customerBusinessTurnover;
    }

    public Double getOthersIncome() {
        return othersIncome;
    }

    public void setOthersIncome(Double othersIncome) {
        this.othersIncome = othersIncome;
    }
}
