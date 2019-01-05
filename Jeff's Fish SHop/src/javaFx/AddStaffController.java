package javaFx;

import connectivity.connectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddStaffController {

    @FXML
    private Label lbPError;

    @FXML
    private TableView<StaffDetails> tableStaff;

    @FXML
    private TableColumn<StaffDetails, String> tbSId;

    @FXML
    private TableColumn<StaffDetails, String> tbSName;

    @FXML
    private TableColumn<StaffDetails, String> tbSEmail;

    @FXML
    private TableColumn<StaffDetails, String> tbSPassword;

    @FXML
    private TextField tfNewSName;

    @FXML
    private TextField tfNewSEmail;

    @FXML
    private PasswordField tfNewSPassword;

    private String sName, sEmail, sPassword;

    private ObservableList<StaffDetails> data;

    @FXML
    void btnAddStaff(javafx.scene.input.MouseEvent mouseEvent) throws SQLException {

        connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();

        if (blankValidate() && passwordValidate()) {
            sName = tfNewSName.getText();
            sEmail = tfNewSEmail.getText();
            sPassword = tfNewSPassword.getText();

            Statement statement = connection.createStatement();

            int status = statement.executeUpdate("INSERT INTO staff_registration (staff_name,staff_email,staff_password)" +
                    " values('" + sName + "','" + sEmail + "','" + sPassword + "')");

            if (status > 0) {
                lbPError.setText("Updated");
            }
        }
    }

    @FXML
    void btnLoadStaffDetails(javafx.scene.input.MouseEvent mouseEvent) {

        connectivity.connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();
        data= FXCollections.observableArrayList();

        try {
            Statement statement = connection.createStatement();

            ResultSet loadStaff = statement.executeQuery("select * from staff_registration");
            while (loadStaff.next()) {
                //get string from db,whichever way
                data.add(new StaffDetails(loadStaff.getString(1), loadStaff.getString(2), loadStaff.getString(3), loadStaff.getString(4)));
            }

        } catch (SQLException e) {
            System.out.println("Error");
        }

        tbSId.setCellValueFactory(new PropertyValueFactory<>("sId"));
        tbSName.setCellValueFactory(new PropertyValueFactory<>("sName"));
        tbSEmail.setCellValueFactory(new PropertyValueFactory<>("sEmail"));
        tbSPassword.setCellValueFactory(new PropertyValueFactory<>("sPassword"));

        tableStaff.setItems(null);
        tableStaff.setItems(data);


    }


    @FXML
    void btnBackToHome(javafx.scene.input.MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Boolean blankValidate() {
        Boolean result = false;

        //String email, name, password,address;

        sName = tfNewSName.getText().toString();
        sEmail = tfNewSEmail.getText().toString();
        sPassword = tfNewSPassword.getText().toString();

        if (sName.isEmpty() || sEmail.isEmpty() || sPassword.isEmpty()) {
            lbPError.setText("Updating Failed, Please enter all the details");
        } else {
            result = true;
        }
        return result;
    }

    private Boolean passwordValidate() {
        Boolean result = false;
        int uPassword;
        uPassword = tfNewSPassword.getText().length();
        if (uPassword<8) {
            lbPError.setText("Registration Failed,password must be eight characters or more");        } else {
            result = true;
        }
        return result;
    }
}
