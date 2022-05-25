package Examen2021Again.ejercicio4;

public class OrderDetails {
    private Integer orderNumber;
    private String productCode;
    private Integer quantityOrdered;
    private Double priceEach;
    private Integer orderLineNumber;

    public OrderDetails(Integer orderNumber, String productCode, Integer quantityOrdered, Double priceEach, Integer orderLineNumber) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetails() {
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderNumber=" + orderNumber +
                ", productCode='" + productCode + '\'' +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }
}
