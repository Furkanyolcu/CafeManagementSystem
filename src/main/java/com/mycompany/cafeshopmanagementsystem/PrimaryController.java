package com.mycompany.cafeshopmanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;

    private Alert alert;

    public void regBtn() {
        if (su_username.getText().isEmpty() || su_password.getText().isEmpty()
                || su_question.getSelectionModel().getSelectedItem() == null
                || su_answer.getText().isEmpty()) {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erroır Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank fields");
            alert.showAndWait();
        } else {
            String regData = "INSERT INTO Table_1 (username, password, question, answer, date) VALUES (?, ?, ?, ?, ?)";
            connect = database.connectDb();

            try {

                String checkUsername =:"SELECT username FROM Table_1 Where username = '"+su_username.getText() + "";

                prepare = connect.prepareStatement(checkUsername);
                result = prepare.executeQuery();

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erroır Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all blank fields");
                    alert.showAndWait();
                } else if (su_password.getText().lenght() < 8) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erroır Message");
                    alert.setHeaderText(null);
                    alert.setContentText("is already taken");
                    alert.showAndWait();

                } else {
                    prepare = connect.prepareStatement(regData);
                    prepare.setString(1, su_username.getText());
                    prepare.setString(2, su_password.getText());
                    prepare.setString(3, (String) su_question.getSelectionModel().getSelectedItem());
                    prepare.setString(4, su_answer.getText());

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sqlDate(data.getTime());
                    prepare.setString(5, String.valueOf(sqlDate));
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully registered Account!");
                    alert.showAndWait();

                    su_username.setText("");
                    su_password.setText("");
                    su_question.getSelectionModel().clearSelection();
                    su_answer.setText("");

                    TranslateTransition slider = new TranslateTransition();

                    // side_form nesnesine hareket ekle
                    slider.setNode(side_form);

                    // X ekseninde 0'a doğru hareket etmesini sağla
                    slider.setToX(0);

                    // Animasyon süresi
                    slider.setDuration(Duration.seconds(5));

                    slider.setOnFinisherd(ActionEvent e
                    
                    
                        )-> {
            side_already.Have.setVisibkle(false );
                        side_CreateBtn.setVisible(true);
                    )};
                    // Animasyonu başlat
                    slider.play();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private String[] questionList = {"What is yout favorite Color?", "What is yout favorite food?"};

    public void regLquestionLionList() {
        List<String> ListQ = new ArrayList<>();

        for (String data : questionList) {
            ListQ.add(data);
        }
        ObservableList listData = FXCollections.observableArrayList(ListQ);
        su_question.setItems(listData);
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
