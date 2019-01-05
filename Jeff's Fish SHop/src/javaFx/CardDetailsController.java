package javaFx;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Date;

public class CardDetailsController {

    @FXML
    public DatePicker tfExpireDate;

    @FXML
    private TextField tfCardNumber;

    @FXML
    private TextField tfCardName;

    @FXML
    private PasswordField tfCardCode;

    @FXML
    private Label lbDisplay;

    @FXML
    private void btnPay(MouseEvent mouseEvent) {

        try {
            if(blankValidate()){
                if(cardNumberValidate()){
                String cardName = tfCardName.getText();
                int cardNumber = Integer.parseInt(tfCardNumber.getText());
                int cardCode = Integer.parseInt(tfCardCode.getText());

                lbDisplay.setText("\t\tPayment Succesfull");

            }}
        }catch (Exception error){
            lbDisplay.setText("Enter Number as a Card Number and Security code");
        }
    }

    private Boolean blankValidate(){
        Boolean result = false;

        String cardName, cardNumber, cardCode;

        cardName = tfCardNumber.getText();
        cardNumber = tfCardNumber.getText();
        cardCode = tfCardCode.getText();

        if (cardName.isEmpty() || cardNumber.isEmpty() || cardCode.isEmpty()) {
            lbDisplay.setText("Payment Failed,Please enter all the details");
        } else {
            result = true;
        }
        return result;
    }

    private Boolean cardNumberValidate(){
        Boolean result = false;

        int cardNumber;

        cardNumber = tfCardNumber.getText().length();

        if (cardNumber<16 || cardNumber >= 17) {
            lbDisplay.setText("Payment Failed,Card number must be 16");
        }else{
            result = true;
        }
        return result;
    }
}


