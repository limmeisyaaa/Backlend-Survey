package id.com.service.mh.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "customer_cost")
public class CustomerCost {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String costId;
    private String operationalCostName;
    private Double operationalCostAmount;
    @ManyToOne
    @JoinColumn(name = "trx_id")
    private Transaction transaction;

    public CustomerCost() {
    }

    public String getCostId() {

        return costId;
    }

    public void setCostId(String costId) {
        this.costId = costId;
    }

    public String getOperationalCostName() {
        return operationalCostName;
    }

    public void setOperationalCostName(String operationalCostName) {
        this.operationalCostName = operationalCostName;
    }

    public Double getOperationalCostAmount() {
        return operationalCostAmount;
    }

    public void setOperationalCostAmount(Double operationalCostAmount) {
        this.operationalCostAmount = operationalCostAmount;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}