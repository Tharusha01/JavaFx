package javaFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EnquiryDetails {
    private final StringProperty cuEEmail;
    private final StringProperty cuEMessage;


    public EnquiryDetails(String cuEEmail, String cuEMessage) {
        this.cuEEmail = new SimpleStringProperty(cuEEmail);
        this.cuEMessage = new SimpleStringProperty(cuEMessage);
    }

    //Getters And Setters
    public String getCuEEmail() {
        return cuEEmail.get();
    }

    public StringProperty cuEEmailProperty() {
        return cuEEmail;
    }

    public void setCuEEmail(String cuEEmail) {
        this.cuEEmail.set(cuEEmail);
    }

    public String getCuEMessage() {
        return cuEMessage.get();
    }

    public StringProperty cuEMessageProperty() {
        return cuEMessage;
    }

    public void setCuEMessage(String cuEMessage) {
        this.cuEMessage.set(cuEMessage);
    }
}
