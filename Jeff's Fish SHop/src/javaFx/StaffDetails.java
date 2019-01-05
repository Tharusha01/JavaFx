package javaFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StaffDetails {
    private final StringProperty sId;
    private final StringProperty sName;
    private final StringProperty sEmail;
    private final StringProperty sPassword;


    public StaffDetails(String sId, String sName, String sEmail, String sPassword) {
        this.sId = new SimpleStringProperty(sId);
        this.sName = new SimpleStringProperty(sName);
        this.sEmail = new SimpleStringProperty(sEmail);
        this.sPassword = new SimpleStringProperty(sPassword);

    }

    //Getters And Setters
    public String getsId() {
        return sId.get();
    }

    public StringProperty sIdProperty() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId.set(sId);
    }

    public String getsName() {
        return sName.get();
    }

    public StringProperty sNameProperty() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName.set(sName);
    }

    public String getsEmail() {
        return sEmail.get();
    }

    public StringProperty sEmailProperty() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail.set(sEmail);
    }

    public String getsPassword() {
        return sPassword.get();
    }

    public StringProperty sPasswordProperty() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword.set(sPassword);
    }
}
