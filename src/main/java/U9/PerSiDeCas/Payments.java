package U9.PerSiDeCas;

import java.time.LocalDate;
import java.time.LocalTime;

public class Payments {
    private Integer customerNumber;
    private String checkNumber;
    private String paymentDate;
    private Double amount;

    public Payments(Integer customerNumber, String checkNumber, String paymentDate, Double amount) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public Payments() {
    }

    @Override
    public String toString() {
        return "Payments{" +
                "customerNumber=" + customerNumber +
                ", checkNumber='" + checkNumber + '\'' +
                ", paymentDate=" + paymentDate +
                ", amount=" + amount +
                '}';
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
