package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import game.*;

public class MainMenu {
    @FXML
    private TextField player1;

    @FXML
    private TextField player2;

    @FXML
    private TextField player3;

    @FXML
    private TextField player4;

    // private String player1Name;

    // protected static String getPlayer1Name() {
    // return player1Name;
    // }

    @FXML
    void BoutonValidate(ActionEvent event) {
        Stage mainWindow = (Stage) player1.getScene().getWindow();
        String player1Name = player1.getText();
        String player2Name = player2.getText();
        String player3Name = player3.getText();
        String player4Name = player4.getText();
        System.out.println(player1Name);
        System.out.println(player2Name);
        System.out.println(player3Name);
        System.out.println(player4Name);

        mainWindow.close();
        Parent gamew;
        try {
            gamew = FXMLLoader.load(getClass().getResource("/view/GameWindow.fxml"));
            Scene scene = new Scene(gamew);
            Stage gameWindow = new Stage();
            gameWindow.setTitle("Munchkin UTBM");
            gameWindow.setScene(scene);
            gameWindow.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
