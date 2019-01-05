package javaFx;

import connectivity.connectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UpdateProfileController implements Initializable {

    @FXML
    private Label lbPError;

    @FXML
    private TableView<UserDetails> tableUser;

    @FXML
    private TableColumn<UserDetails, String> tbCName;

    @FXML
    private TableColumn<UserDetails, String> tbCEmail;

    @FXML
    private TableColumn<UserDetails, String> tbCPassword;

    @FXML
    private TableColumn<UserDetails, String> tbCAddess;

    @FXML
    private TextField tfUpdateName;

    @FXML
    private TextField tfUpdateEmail;

    @FXML
    private TextField tfUpdateAddress;

    @FXML
    private PasswordField tfUpdatePassword;

    private String cEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void getUserEmail1(String email){
        cEmail = email;
    }


    @FXML
    void btnLoadUserDetails(MouseEvent event) {

        String mail = cEmail;

        connectivity.connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();

        ObservableList<UserDetails> data = FXCollections.observableArrayList();


        try {
            Statement statement = connection.createStatement();

            ResultSet resultSetUpdate = statement.executeQuery("select * from user_registration WHERE user_email = '"+mail+"'");
            while (resultSetUpdate.next()) {
                //get string from db,whichever way
                data.add(new UserDetails(resultSetUpdate.getString(1), resultSetUpdate.getString(2), resultSetUpdate.getString(3), resultSetUpdate.getString(4)));
            }

        } catch (SQLException e) {
            lbPError.setText("Error");
        }

        tbCName.setCellValueFactory(new PropertyValueFactory<>("cName"));
        tbCEmail.setCellValueFactory(new PropertyValueFactory<>("cEmail"));
        tbCPassword.setCellValueFactory(new PropertyValueFactory<>("cPassword"));
        tbCAddess.setCellValueFactory(new PropertyValueFactory<>("cAddress"));

        tableUser.setItems(null);
        tableUser.setItems(data);


    }

    @FXML
    void btnUpdate(MouseEvent event) throws SQLException {

        connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();

        if (blankValidate() && passwordValidate()) {
            String uName, uEmai, uPassword, uAddress;
            uName = tfUpdateName.getText();
            uEmai = tfUpdateEmail.getText();
            uPassword = tfUpdatePassword.getText();
            uAddress = tfUpdateAddress.getText();

            String sql = "UPDATE user_registration SET user_name='" + uName + "', user_email = '" + uEmai + "' " +
                    ", user_password = '" + uPassword + "', user_address = '" + uAddress + "'";

            Statement statement = connection.prepareStatement(sql);
            statement.execute(sql);

            lbPError.setText("Updated");
        }
    }

    @FXML
    private void btnBackToHome(MouseEvent mouseEvent) {
        try {

            FXMLLoader cLoader = new FXMLLoader(getClass().getResource("customer.fxml"));

            Parent root = cLoader.load();

            CustomerController customerController = cLoader.getController();
            customerController.getUserEmail(cEmail);

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));


        } catch (IOException error) {
            error.printStackTrace();
        }
    }

    private Boolean blankValidate() {
        Boolean result = false;

        String cEmail, cName, cPassword,cAddress;

        cName = tfUpdateName.getText();
        cPassword = tfUpdatePassword.getText();
        cEmail = tfUpdateEmail.getText();
        cAddress = tfUpdateAddress.getText();

        if (cName.isEmpty() || cPassword.isEmpty() || cEmail.isEmpty() || cAddress.isEmpty()) {
            lbPError.setText("Updating Failed, Please enter all the details");
        } else {
            result = true;
        }
        return result;
    }

    private Boolean passwordValidate() {
        Boolean result = false;
        int uPassword;
        uPassword = tfUpdatePassword.getText().length();
        if (uPassword<8) {
            lbPError.setText("Updating Failed,password must be eight characters or more");
        } else {
            result = true;
        }
        return result;
    }

}
