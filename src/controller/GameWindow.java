package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

import game.*;

public class GameWindow {

    @FXML
    private Button player1_1;

    @FXML
    private Button player1_2;

    @FXML
    private Button player1_3;

    @FXML
    private Button player1_4;

    @FXML
    private Button player1_5;

    @FXML
    private Button player2_1;

    @FXML
    private Button player2_2;

    @FXML
    private Button player2_3;

    @FXML
    private Button player2_4;

    @FXML
    private Button player2_5;

    @FXML
    private Button player3_1;

    @FXML
    private Button player3_2;

    @FXML
    private Button player3_3;

    @FXML
    private Button player3_4;

    @FXML
    private Button player3_5;

    @FXML
    private Button player4_1;

    @FXML
    private Button player4_2;

    @FXML
    private Button player4_3;

    @FXML
    private Button player4_4;

    @FXML
    private Button player4_5;

    @FXML
    public Button test;

    private Map<String, Button> buttonMap = new HashMap<>();

    @FXML
    void test(ActionEvent event) {

    }

    @FXML
    void initialize() {
        buttonMap.put("player1_1", player1_1);
        buttonMap.put("player1_2", player1_2);
        buttonMap.put("player1_3", player1_3);
        buttonMap.put("player1_4", player1_4);
        buttonMap.put("player1_5", player1_5);
        buttonMap.put("player2_1", player2_1);
        buttonMap.put("player2_2", player2_2);
        buttonMap.put("player2_3", player2_3);
        buttonMap.put("player2_4", player2_4);
        buttonMap.put("player2_5", player2_5);
        buttonMap.put("player3_1", player3_1);
        buttonMap.put("player3_2", player3_2);
        buttonMap.put("player3_3", player3_3);
        buttonMap.put("player3_4", player3_4);
        buttonMap.put("player3_5", player3_5);
        buttonMap.put("player4_1", player4_1);
        buttonMap.put("player4_2", player4_2);
        buttonMap.put("player4_3", player4_3);
        buttonMap.put("player4_4", player4_4);
        buttonMap.put("player4_5", player4_5);

        Game jeu = new Game();
        jeu.initializeGame(4, "player1Name", "player2Name", "player3Name", "player4Name"); // Creating a new game

        String elem = "player";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < jeu.getHands().get(i).getCardPile().size(); j++) {
                System.out.println(jeu.getHands().get(i).getCardPile().get(j).getImage());
                elem = "player" + (i + 1) + "_" + (j + 1);
                System.out.println(elem);
                Button button = buttonMap.get(elem);
                ImageView image = new ImageView("file:src/img/defaut.jpg");
                image.setFitHeight(120);
                image.setFitWidth(67);
                button.setGraphic(image);
                button.setPrefSize(80, 80);
                button.setGraphic(image);
            }

        }

        ImageView imageTest = new ImageView("file:src/img/defaut.jpg");
        imageTest.setFitHeight(120);
        imageTest.setFitWidth(67);
        test.setPrefSize(80, 80);
        test.setGraphic(imageTest);

    }

    @FXML
    void player1_1(ActionEvent event) {

    }

    @FXML
    void player1_2(ActionEvent event) {

    }

    @FXML
    void player1_3(ActionEvent event) {

    }

    @FXML
    void player1_4(ActionEvent event) {

    }

    @FXML
    void player1_5(ActionEvent event) {

    }

    @FXML
    void player2_1(ActionEvent event) {

    }

    @FXML
    void player2_2(ActionEvent event) {

    }

    @FXML
    void player2_3(ActionEvent event) {

    }

    @FXML
    void player2_4(ActionEvent event) {

    }

    @FXML
    void player2_5(ActionEvent event) {

    }

    @FXML
    void player3_1(ActionEvent event) {

    }

    @FXML
    void player3_2(ActionEvent event) {

    }

    @FXML
    void player3_3(ActionEvent event) {

    }

    @FXML
    void player3_4(ActionEvent event) {

    }

    @FXML
    void player3_5(ActionEvent event) {

    }

    @FXML
    void player4_1(ActionEvent event) {

    }

    @FXML
    void player4_2(ActionEvent event) {

    }

    @FXML
    void player4_3(ActionEvent event) {

    }

    @FXML
    void player4_4(ActionEvent event) {

    }

    @FXML
    void player4_5(ActionEvent event) {

    }

}
