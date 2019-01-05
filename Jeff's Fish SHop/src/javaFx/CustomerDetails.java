package javaFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CustomerDetails {

    private final StringProperty cuName;
    private final StringProperty cuEmail;
    private final StringProperty cuAddress;

    public CustomerDetails(String cuName, String cuEmail, String cuAddress) {
        this.cuName = new SimpleStringProperty(cuName);
        this.cuEmail = new SimpleStringProperty(cuEmail);
        this.cuAddress = new SimpleStringProperty(cuAddress);
    }

    //Getters And Setters
    public String getCuName() {
        return cuName.get();
    }

    public StringProperty cuNameProperty() {
        return cuName;
    }

    public void setCuName(String cuName) {
        this.cuName.set(cuName);
    }

    public String getCuEmail() {
        return cuEmail.get();
    }

    public StringProperty cuEmailProperty() {
        return cuEmail;
    }

    public void setCuEmail(String cuEmail) {
        this.cuEmail.set(cuEmail);
    }

    public String getCuAddress() {
        return cuAddress.get();
    }

    public StringProperty cuAddressProperty() {
        return cuAddress;
    }

    public void setCuAddress(String cuAddress) {
        this.cuAddress.set(cuAddress);
    }
}
