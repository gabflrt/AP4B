package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
        Game game = new Game();
        game.initializeGame(4, player1Name, player2Name, player3Name, player4Name); // Creating a new game

    }
}
