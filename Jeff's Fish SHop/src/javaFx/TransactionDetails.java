package javaFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TransactionDetails {

    private final StringProperty traDate;
    private final StringProperty cusEmail;
    private final StringProperty transaction;
    private final StringProperty totalPrice;


    public TransactionDetails(String traDate,String cusEmail, String transaction, String totalPrice) {
        this.traDate = new SimpleStringProperty(traDate);
        this.cusEmail = new SimpleStringProperty(cusEmail);
        this.transaction = new SimpleStringProperty(transaction);
        this.totalPrice = new SimpleStringProperty(totalPrice);
    }

    //Getters And Setters
    public String getCusEmail() {
        return cusEmail.get();
    }

    public StringProperty cusEmailProperty() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail.set(cusEmail);
    }

    public String getTransaction() {
        return transaction.get();
    }

    public StringProperty transactionProperty() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction.set(transaction);
    }

    public String getTotalPrice() {
        return totalPrice.get();
    }

    public StringProperty totalPriceProperty() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public String getTraDate() {
        return traDate.get();
    }

    public StringProperty traDateProperty() {
        return traDate;
    }

    public void setTraDate(String traDate) {
        this.traDate.set(traDate);
    }
}
