package javaFx;

import connectivity.connectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionController {

    @FXML
    private TableView<TransactionDetails> tableTransactions;

    @FXML
    private TableColumn<TransactionDetails, String> tbTCDate;

    @FXML
    private TableColumn<TransactionDetails, String> tbTCEmail;

    @FXML
    private TableColumn<TransactionDetails, String> tbTProductsDetails;

    @FXML
    private TableColumn<TransactionDetails, String> tbPTotPrice;

    private ObservableList<TransactionDetails> data;

    @FXML
    void btnLoadTransDetails(MouseEvent event) {

        connectivity.connectionClass connectionClass = new connectionClass();
        Connection connection = connectionClass.getConnection();
        data= FXCollections.observableArrayList();

        try {
            Statement statement = connection.createStatement();

            ResultSet loadTransactions = statement.executeQuery("select * from transactions");
            while (loadTransactions.next()) {
                //get string from db,whichever way
                data.add(new TransactionDetails(loadTransactions.getString(1), loadTransactions.getString(2), loadTransactions.getString(3), loadTransactions.getString(4)));
            }

        } catch (SQLException e) {
            System.out.println("Error");
        }

        tbTCDate.setCellValueFactory(new PropertyValueFactory<>("traDate"));
        tbTCEmail.setCellValueFactory(new PropertyValueFactory<>("cusEmail"));
        tbTProductsDetails.setCellValueFactory(new PropertyValueFactory<>("transaction"));
        tbPTotPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        tableTransactions.setItems(null);
        tableTransactions.setItems(data);


    }



    @FXML
    void btnBackToHome(MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

            Node node = (Node) mouseEvent.getSource();

            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
