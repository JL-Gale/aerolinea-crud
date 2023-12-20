package com.test.igu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Button cancelarButton;

    @FXML
    private ImageView tirraImg;

    @FXML
    private ImageView avionImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File tirraFile = new File("imagenes/pngwing.com.png");
        Image tierraImage = new Image(tirraFile.toURI().toString());
        tirraImg.setImage(tierraImage);

        File avionFile = new File("imagenes/klipartz.com.png");
        Image avionImage = new Image(avionFile.toURI().toString());
        avionImg.setImage(avionImage);
    }
    public void cancelarButtOnOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelarButton.getScene().getWindow();
        stage.close();
    }
}