package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private Button player2_1;

    @FXML
    private Button player2_2;

    @FXML
    private Button player2_3;

    @FXML
    private Button player2_4;

    @FXML
    private Button player3_1;

    @FXML
    private Button player3_2;

    @FXML
    private Button player3_3;

    @FXML
    private Button player3_4;

    @FXML
    private Button player4_1;

    @FXML
    private Button player4_2;

    @FXML
    private Button player4_3;

    @FXML
    private Button player4_4;

    @FXML
    private Button placed1_1;

    @FXML
    private Button placed1_2;

    @FXML
    private Button placed1_3;

    @FXML
    private Button placed1_4;

    @FXML
    private Button placed2_1;

    @FXML
    private Button placed2_2;

    @FXML
    private Button placed2_3;

    @FXML
    private Button placed2_4;

    @FXML
    private Button placed3_1;

    @FXML
    private Button placed3_2;

    @FXML
    private Button placed3_3;

    @FXML
    private Button placed3_4;

    @FXML
    private Button placed4_1;

    @FXML
    private Button placed4_2;

    @FXML
    private Button placed4_3;

    @FXML
    private Button placed4_4;

    @FXML
    private Button DiscardDungeon;

    @FXML
    private Button DiscardTreasure;

    @FXML
    private Button DrawDungeon;

    @FXML
    private Button DrawTreasure;

    @FXML
    private Label text;

    @FXML
    private Label Player1Level;

    @FXML
    private Label Player2Level;

    @FXML
    private Label Player3Level;

    @FXML
    private Label Player4Level;

    @FXML
    private Label Player1Strenght;

    @FXML
    private Label Player2Strenght;

    @FXML
    private Label Player3Strenght;

    @FXML
    private Label Player4Strenght;

    private game.Game jeu;
    private int i = 0; // Position du joueur dans le jeu
    private int nbCardsToDraw = 0; // Nombre de cartes à piocher
    private game.Card clickedCard;
    private boolean canDrawTreasure, canPlaceCard = false;
    private boolean canDrawDungeon = true;

    private Map<String, Button> buttonMap = new HashMap<>();

    private String player1Name;
    private String player2Name;
    private String player3Name;
    private String player4Name;

    protected void startGame(String p1, String p2, String p3, String p4) {
        this.player1Name = p1;
        this.player2Name = p2;
        this.player3Name = p3;
        this.player4Name = p4;
        this.jeu = new game.Game();
        this.jeu.initializeGame(4, this.player1Name, this.player2Name, this.player3Name, this.player4Name);
        update(this.jeu);
    }

    void update(game.Game jeu) {
        String elem = "player";
        int cardHeight = 150;
        int cardWidth = 120;
        int cardHeightDraw = 100;
        int cardWidthDraw = 80;
        for (int i = 0; i < 4; i++) {
            int j = 0;
            for (j = 0; j < jeu.getHands().get(i).getCardPile().size(); j++) {
                System.out.println(jeu.getHands().get(i).getCardPile().get(j).getImage());
                elem = "player" + (i + 1) + "_" + (j + 1);
                Button button = buttonMap.get(elem);
                System.out.println("aziz1 " + jeu.getHands().get(i).getCardPile().get(j).getName());
                System.out.println("AZIZ " + jeu.getHands().get(i).getCardPile().get(j).getImage());
                ImageView image = new ImageView(jeu.getHands().get(i).getCardPile().get(j).getImage());
                image.setFitHeight(cardHeight);
                image.setFitWidth(cardWidth);
                button.setGraphic(image);
                button.setPrefSize(0, 0);
                button.setGraphic(image);
                if (this.i == i)
                    button.setStyle("-fx-background-color: #ff0000;");
                else
                    button.setStyle("-fx-background-color: #ffffff;");

            }
            for (int k = j; k < 4; k++) {
                elem = "player" + (i + 1) + "_" + (k + 1);
                Button button = buttonMap.get(elem);
                ImageView image = new ImageView("file:src/img/default.png");
                image.setFitHeight(cardHeight);
                image.setFitWidth(cardWidth);
                button.setGraphic(image);
                button.setPrefSize(0, 0);
                button.setGraphic(image);
            }

            for (j = 0; j < jeu.getPlacedCards().get(i).getCardPile().size(); j++) {
                System.out.println(jeu.getPlacedCards().get(i).getCardPile().get(j).getImage());
                elem = "placed" + (i + 1) + "_" + (j + 1);
                System.out.println(elem);
                Button button = buttonMap.get(elem);
                ImageView image2 = new ImageView(jeu.getPlacedCards().get(i).getCardPile().get(j).getImage());
                image2.setFitHeight(cardHeight);
                image2.setFitWidth(cardWidth);
                button.setGraphic(image2);
                button.setPrefSize(0, 0);
                button.setGraphic(image2);
            }

            for (int k = j; k < 4; k++) {
                elem = "placed" + (i + 1) + "_" + (k + 1);
                Button button = buttonMap.get(elem);
                ImageView image2 = new ImageView("file:src/img/default.png");
                image2.setFitHeight(cardHeight);
                image2.setFitWidth(cardWidth);
                button.setGraphic(image2);
                button.setPrefSize(0, 0);
                button.setGraphic(image2);
            }
        }

        Button buttonDrawDungeon = DrawDungeon;
        ImageView imageDrawDungeon = new ImageView("file:src/img/donjon.png");
        if (!jeu.getDrawPileDungeon().isEmpty()) {
            imageDrawDungeon = new ImageView("file:src/img/donjon.png");
        }
        imageDrawDungeon.setFitHeight(cardHeightDraw);
        imageDrawDungeon.setFitWidth(cardWidthDraw);
        buttonDrawDungeon.setGraphic(imageDrawDungeon);
        buttonDrawDungeon.setPrefSize(0, 0);
        buttonDrawDungeon.setGraphic(imageDrawDungeon);

        /*
         * Button buttonDiscardDungeon = DiscardDungeon;
         * ImageView imageDiscardDungeon = new ImageView("file:src/img/donjon.png");
         * if (!jeu.getDiscardPileDungeon().isEmpty()) {
         * imageDiscardDungeon = new ImageView("file:src/img/donjon.png");
         * }
         * imageDiscardDungeon.setFitHeight(cardHeight);
         * imageDiscardDungeon.setFitWidth(cardWidth);
         * buttonDiscardDungeon.setGraphic(imageDiscardDungeon);
         * buttonDiscardDungeon.setPrefSize(0, 0);
         * buttonDiscardDungeon.setGraphic(imageDiscardDungeon);
         * 
         */

        Button buttonDrawTreasure = DrawTreasure;
        ImageView imageDrawTreasure = new ImageView("file:src/img/tresor.png");
        if (!jeu.getDrawPileTreasure().isEmpty()) {
            imageDrawTreasure = new ImageView("file:src/img/tresor.png");
        }
        imageDrawTreasure.setFitHeight(cardHeightDraw);
        imageDrawTreasure.setFitWidth(cardWidthDraw);
        buttonDrawTreasure.setGraphic(imageDrawTreasure);
        buttonDrawTreasure.setPrefSize(0, 0);
        buttonDrawTreasure.setGraphic(imageDrawTreasure);

        /*
         * Button buttonDiscardTreasure = DiscardTreasure;
         * ImageView imageDiscardTreasure = new ImageView("file:src/img/tresor.png");
         * if (!jeu.getDiscardPileTreasure().isEmpty()) {
         * imageDiscardTreasure = new ImageView("file:src/img/tresor.png");
         * }
         * imageDiscardTreasure.setFitHeight(cardHeight);
         * imageDiscardTreasure.setFitWidth(cardWidth);
         * buttonDiscardTreasure.setGraphic(imageDiscardTreasure);
         * buttonDiscardTreasure.setPrefSize(0, 0);
         * buttonDiscardTreasure.setGraphic(imageDiscardTreasure);
         */

    }

    @FXML
    void initialize() {
        buttonMap.put("player1_1", player1_1);
        buttonMap.put("player1_2", player1_2);
        buttonMap.put("player1_3", player1_3);
        buttonMap.put("player1_4", player1_4);

        buttonMap.put("player2_1", player2_1);
        buttonMap.put("player2_2", player2_2);
        buttonMap.put("player2_3", player2_3);
        buttonMap.put("player2_4", player2_4);

        buttonMap.put("player3_1", player3_1);
        buttonMap.put("player3_2", player3_2);
        buttonMap.put("player3_3", player3_3);
        buttonMap.put("player3_4", player3_4);

        buttonMap.put("player4_1", player4_1);
        buttonMap.put("player4_2", player4_2);
        buttonMap.put("player4_3", player4_3);
        buttonMap.put("player4_4", player4_4);

        buttonMap.put("placed1_1", placed1_1);
        buttonMap.put("placed1_2", placed1_2);
        buttonMap.put("placed1_3", placed1_3);
        buttonMap.put("placed1_4", placed1_4);

        buttonMap.put("placed2_1", placed2_1);
        buttonMap.put("placed2_2", placed2_2);
        buttonMap.put("placed2_3", placed2_3);
        buttonMap.put("placed2_4", placed2_4);

        buttonMap.put("placed3_1", placed3_1);
        buttonMap.put("placed3_2", placed3_2);
        buttonMap.put("placed3_3", placed3_3);
        buttonMap.put("placed3_4", placed3_4);

        buttonMap.put("placed4_1", placed4_1);
        buttonMap.put("placed4_2", placed4_2);
        buttonMap.put("placed4_3", placed4_3);
        buttonMap.put("placed4_4", placed4_4);

    }

    @FXML
    void DiscardDungeon(ActionEvent event) {

    }

    @FXML
    void DiscardTreasure(ActionEvent event) {

    }

    @FXML
    void DrawDungeon(ActionEvent event) {
        /*
         * jeu.drawDungeonCard(this.i);
         * this.clickedCard = jeu.getDrawPileDungeon().pickCardPile();
         * System.out.println(this.clickedCard.getName());
         * this.i = this.i + 1;
         * if (this.i == jeu.getNbPlayers()) {
         * this.i = 0;
         * }
         */
        refreshStats();
        if (this.canDrawDungeon && !this.canPlaceCard) {
            this.jeu.getPlayers().get(this.i).setStrength(10); // C'est pour les tests, à enlever à la fin
            this.nbCardsToDraw = jeu.drawDungeonCard(this.i);
            System.out.println(this.nbCardsToDraw);
            text.setText("Tu peux piocher " + this.nbCardsToDraw + " cartes.");
            // this.i = this.i + 1;
            if (this.nbCardsToDraw == 0) {
                this.i = this.i + 1;
                if (this.i == jeu.getNbPlayers()) {
                    this.i = 0;
                }
            } else {
                this.canDrawTreasure = true;
                this.canDrawDungeon = false;
            }
            update(jeu);
        } else {
            text.setText("Tu ne peux pas piocher de carte donjon.");
        }

        // this.canDrawTreasure = false;
    }

    @FXML
    void DrawTreasure(ActionEvent event) {
        if (this.canDrawTreasure && !this.canPlaceCard) {
            if (this.nbCardsToDraw == 1) {
                this.clickedCard = jeu.drawTreasureCard(this.i);
                text.setText(
                        "Tu ne peux plus piocher de cartes. \nC'est au prochain joueur de piocher une carte donjon");
                /*
                 * this.i = this.i + 1;
                 * if (this.i == jeu.getNbPlayers()) {
                 * this.i = 0;
                 * }
                 */
                this.nbCardsToDraw = 0;
                this.canDrawTreasure = false;
                this.canDrawDungeon = true;
                this.canPlaceCard = true;
            } else if (this.nbCardsToDraw > 1) {
                jeu.drawTreasureCard(this.i);
                this.nbCardsToDraw = this.nbCardsToDraw - 1;
                text.setText("Tu peux encore piocher " + this.nbCardsToDraw + " cartes.");
                this.canPlaceCard = true;
            } else {
                text.setText("Tu ne peux plus piocher de cartes.");
                this.canPlaceCard = false;
            }
            update(jeu);
        } else {
            text.setText("Tu ne peux pas piocher de carte trésor.");
        }

        /*
         * for (int j = 0; j < nbCardsToDraw; j++) {
         * jeu.drawTreasureCard(this.i - 1);
         * }
         */

        // jeu.drawTreasureCard(0);
        // ImageView image = new
        // ImageView(jeu.getHands().get(0).getCardPile().get(4).getImage());
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

    void placed(int deck_position) {
        if (this.canPlaceCard) {
            this.jeu.placeCard(this.i, deck_position, this.clickedCard);
            this.canPlaceCard = false;
            if (this.nbCardsToDraw == 0) {
                this.i = this.i + 1;
                if (this.i == jeu.getNbPlayers()) {
                    this.i = 0;
                }
                this.canDrawDungeon = true;
            }
            update(jeu);

        } else {
            text.setText("Tu ne peux pas placer de carte.");
        }
    }

    @FXML
    void placed1_1(ActionEvent event) {
        System.out.println("AZIZ");
        System.out.println(jeu.getNbPlayers());
        // if (this.canPlaceCard) {
        // this.jeu.placeCard(this.i, 0, this.clickedCard);
        // update(jeu);
        // this.canPlaceCard = false;
        // if (this.nbCardsToDraw == 0) {
        // this.i = this.i + 1;
        // if (this.i == jeu.getNbPlayers()) {
        // this.i = 0;
        // }
        // this.canDrawDungeon = true;
        // }
        // } else {
        // text.setText("Tu ne peux pas placer de carte.");
        // }
        placed(0);
    }

    @FXML
    void placed1_2(ActionEvent event) {
        System.out.println("AZIZ");
        System.out.println(jeu.getNbPlayers());
        // if (this.canPlaceCard) {
        // this.jeu.placeCard(this.i, 1, this.clickedCard);
        // update(jeu);
        // this.canPlaceCard = false;
        // if (this.nbCardsToDraw == 0) {
        // this.i = this.i + 1;
        // if (this.i == jeu.getNbPlayers()) {
        // this.i = 0;
        // }
        // this.canDrawDungeon = true;
        // }
        // } else {
        // text.setText("Tu ne peux pas placer de carte.");
        // }
        placed(1);

    }

    @FXML
    void placed1_3(ActionEvent event) {
        placed(2);

    }

    @FXML
    void placed1_4(ActionEvent event) {
        placed(3);

    }

    @FXML
    void placed2_1(ActionEvent event) {
        // System.out.println(jeu.getNbPlayers());
        // if (this.canPlaceCard) {
        // this.jeu.placeCard(this.i, 0, this.clickedCard);
        // update(jeu);
        // this.canPlaceCard = false;
        // if (this.nbCardsToDraw == 0) {
        // this.i = this.i + 1;
        // if (this.i == jeu.getNbPlayers()) {
        // this.i = 0;
        // }
        // this.canDrawDungeon = true;
        // }
        // } else {
        // text.setText("Tu ne peux pas placer de carte.");
        // }
        placed(0);

    }

    @FXML
    void placed2_2(ActionEvent event) {
        placed(1);

    }

    @FXML
    void placed2_3(ActionEvent event) {
        placed(2);

    }

    @FXML
    void placed2_4(ActionEvent event) {
        placed(3);

    }

    @FXML
    void placed3_1(ActionEvent event) {
        // System.out.println(jeu.getNbPlayers());
        // if (this.canPlaceCard) {
        // this.jeu.placeCard(this.i, 0, this.clickedCard);
        // update(jeu);
        // this.canPlaceCard = false;
        // if (this.nbCardsToDraw == 0) {
        // this.i = this.i + 1;
        // if (this.i == jeu.getNbPlayers()) {
        // this.i = 0;
        // }
        // this.canDrawDungeon = true;
        // }
        // } else {
        // text.setText("Tu ne peux pas placer de carte.");
        // }
        placed(0);
    }

    @FXML
    void placed3_2(ActionEvent event) {
        placed(1);

    }

    @FXML
    void placed3_3(ActionEvent event) {
        placed(2);

    }

    @FXML
    void placed3_4(ActionEvent event) {
        placed(3);

    }

    @FXML
    void placed4_1(ActionEvent event) {
        // System.out.println("placed4_1");
        // if (this.canPlaceCard) {
        // this.jeu.placeCard(this.i, 0, this.clickedCard);
        // update(jeu);
        // this.canPlaceCard = false;
        // if (this.nbCardsToDraw == 0) {
        // this.i = this.i + 1;
        // if (this.i == jeu.getNbPlayers()) {
        // this.i = 0;
        // }
        // this.canDrawDungeon = true;
        // }
        // } else {
        // text.setText("Tu ne peux pas placer de carte.");
        // }
        placed(0);

    }

    @FXML
    void placed4_2(ActionEvent event) {
        placed(1);

    }

    @FXML
    void placed4_3(ActionEvent event) {
        // System.out.println("placed4_3");
        // if (this.canPlaceCard) {
        // this.jeu.placeCard(this.i, 2, this.clickedCard);
        // update(jeu);
        // this.canPlaceCard = false;
        // if (this.nbCardsToDraw == 0) {
        // this.i = this.i + 1;
        // if (this.i == jeu.getNbPlayers()) {
        // this.i = 0;
        // }
        // this.canDrawDungeon = true;
        // }
        // } else {
        // text.setText("Tu ne peux pas placer de carte.");
        // }

        placed(2);
    }

    @FXML
    void placed4_4(ActionEvent event) {
        placed(3);
    }

    @FXML
    void refreshStats() {
        Player1Level.setText("Niveau : " + jeu.getPlayers().get(0).getLevel());
        Player2Level.setText("Niveau : " + jeu.getPlayers().get(1).getLevel());
        Player3Level.setText("Niveau : " + jeu.getPlayers().get(2).getLevel());
        Player4Level.setText("Niveau : " + jeu.getPlayers().get(3).getLevel());

        Player1Strenght.setText("Intelligence : " + jeu.getPlayers().get(0).getStrength());
        Player2Strenght.setText("Intelligence : " + jeu.getPlayers().get(1).getStrength());
        Player3Strenght.setText("Intelligence : " + jeu.getPlayers().get(2).getStrength());
        Player4Strenght.setText("Intelligence : " + jeu.getPlayers().get(3).getStrength());
    }

}
