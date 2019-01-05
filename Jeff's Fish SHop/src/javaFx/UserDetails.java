package javaFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserDetails {
    private final StringProperty cName;
    private final StringProperty cEmail;
    private final StringProperty cPassword;
    private final StringProperty cAddress;

    public UserDetails(String cName, String cEmail, String cPassword, String cAddress) {
        this.cName = new SimpleStringProperty(cName);
        this.cEmail = new SimpleStringProperty(cEmail);
        this.cPassword = new SimpleStringProperty(cPassword);
        this.cAddress = new SimpleStringProperty(cAddress);
    }

    //Getters And Setters
    public String getcName() {
        return cName.get();
    }

    public StringProperty cNameProperty() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName.set(cName);
    }

    public String getcEmail() {
        return cEmail.get();
    }

    public StringProperty cEmailProperty() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail.set(cEmail);
    }

    public String getcPassword() {
        return cPassword.get();
    }

    public StringProperty cPasswordProperty() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword.set(cPassword);
    }

    public String getcAddress() {
        return cAddress.get();
    }

    public StringProperty cAddressProperty() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress.set(cAddress);
    }
}
