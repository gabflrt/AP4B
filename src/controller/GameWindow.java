package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
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
    private Button placed_mob;

    @FXML
    private Button placed_malediction;

    @FXML
    private Button DrawDungeon;

    @FXML
    private Button DrawTreasure;

    @FXML
    private Button jeter;

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

    @FXML
    private MaledictionCard maledictionCard = new MaledictionCard();

    private game.Game jeu;
    private int i = 0; // Position du joueur dans le jeu
    private int nbCardsToDraw = 0; // Nombre de cartes à piocher
    private game.Card clickedCard;
    private boolean canDrawTreasure, canPlaceCard = false;
    private boolean canDrawDungeon = true;
    private int showCardPile = 0;
    private boolean jetecarte = false;

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

    void update(game.Game jeu) { // Met à jour l'affichage pour faciliter la compréhension pour les joueurs
        String elem = "player";
        int cardHeight = 150;
        int cardWidth = 120;
        int cardHeightDraw = 100;
        int cardWidthDraw = 80;
        for (int i = 0; i < 4; i++) {
            int j = 0;
            for (j = 0; j < jeu.getHands().get(i).getCardPile().size(); j++) {
                elem = "player" + (i + 1) + "_" + (j + 1);
                Button button = buttonMap.get(elem);
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
                if (this.i == i)
                    button.setStyle("-fx-background-color: #ff0000;");
                else
                    button.setStyle("-fx-background-color: #ffffff;");
            }

            for (j = 0; j < jeu.getPlacedCards().get(i).getCardPile().size(); j++) {
                elem = "placed" + (i + 1) + "_" + (j + 1);
                Button button = buttonMap.get(elem);
                ImageView image2 = new ImageView(jeu.getPlacedCards().get(i).getCardPile().get(j).getImage());
                image2.setFitHeight(cardHeight);
                image2.setFitWidth(cardWidth);
                button.setGraphic(image2);
                button.setPrefSize(0, 0);
                button.setGraphic(image2);
                button.setStyle("-fx-background-color: #ffffff;");

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
                if (this.i == i && this.canPlaceCard)
                    button.setStyle("-fx-background-color: #00ff00;");
                else
                    button.setStyle("-fx-background-color: #ffffff;");
            }
        }

        Button buttonDrawDungeon = DrawDungeon;
        ImageView imageDrawDungeon = new ImageView("file:src/img/donjon.png");
        if (!jeu.getDrawPileDungeon().isEmpty()) {
            imageDrawDungeon = new ImageView("file:src/img/donjon.png");
        }
        if (this.showCardPile == 1) {
            imageDrawDungeon = new ImageView(this.clickedCard.getImage());
        }
        imageDrawDungeon.setFitHeight(cardHeightDraw);
        imageDrawDungeon.setFitWidth(cardWidthDraw);
        buttonDrawDungeon.setGraphic(imageDrawDungeon);
        buttonDrawDungeon.setPrefSize(0, 0);
        buttonDrawDungeon.setGraphic(imageDrawDungeon);

        ImageView imagej = new ImageView("file:src/img/jeter.png");
        imagej.setFitHeight(40);
        imagej.setFitWidth(40);
        jeter.setGraphic(imagej);
        if (this.jetecarte) {
            jeter.setStyle("-fx-background-color: #ff0000;");
        } else {
            jeter.setStyle("-fx-background-color: #ffffff;");
        }

        Button buttonDrawTreasure = DrawTreasure;
        ImageView imageDrawTreasure = new ImageView("file:src/img/tresor.png");
        if (!jeu.getDrawPileTreasure().isEmpty()) {
            imageDrawTreasure = new ImageView("file:src/img/tresor.png");
        }
        if (this.showCardPile == 2) {
            imageDrawTreasure = new ImageView(this.clickedCard.getImage());
        }
        imageDrawTreasure.setFitHeight(cardHeightDraw);
        imageDrawTreasure.setFitWidth(cardWidthDraw);
        buttonDrawTreasure.setGraphic(imageDrawTreasure);
        buttonDrawTreasure.setPrefSize(0, 0);
        buttonDrawTreasure.setGraphic(imageDrawTreasure);

    }

    @FXML
    void initialize() { // on initialise l'ensemble des boutons au lancement de la fenêtre
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

        buttonMap.put("placed_mob", placed_mob);
        buttonMap.put("placed_malediction", placed_malediction);
        refreshUE();
        refreshMalediction();

    }

    @FXML
    void jeter() { // Pour jeter une carte
        jetecarte = true;
        text.setText("Choisis une carte à jeter");
        update(jeu);
    }

    @FXML
    void DrawDungeon(ActionEvent event) throws IOException { // Pour piocher une carte donjon et adapter le comportement
                                                             // du jeu en fonction du type de la carte

        if (this.canDrawDungeon && !this.canPlaceCard && !this.jetecarte) {
            this.clickedCard = jeu.drawDungeonCard(this.i);
            this.showCardPile = 1;
            this.nbCardsToDraw = jeu.useDungeonCard(this.i, this.clickedCard, this.maledictionCard);
            if (this.clickedCard instanceof MobCard) {
                Button button_placed_mod = placed_mob;
                ImageView imagePlacedMob = new ImageView(new Image(this.clickedCard.getImage()));
                imagePlacedMob.setFitHeight(100);
                imagePlacedMob.setFitWidth(80);
                button_placed_mod.setGraphic(imagePlacedMob);
                button_placed_mod.setPrefSize(0, 0);
                button_placed_mod.setGraphic(imagePlacedMob);

                int intelligence = jeu.getPlayers().get(this.i).getTotalStrength()
                        - this.maledictionCard.getHowManyUpgrademob();

                if (nbCardsToDraw > 0) {
                    text.setText("Ton intelligence : " + intelligence
                            + "\nIntelligence requise pour l'UE : "
                            + ((MobCard) this.clickedCard).getStrength()
                            + "\nTu gagnes " + ((MobCard) this.clickedCard).getNbLevelEarned()
                            + " niveau(x) \n Tu pioches "
                            + ((MobCard) this.clickedCard).getNbTreasureCardToDraw() + " carte(s) trésor(s)");
                } else {
                    text.setText("Ton intelligence : " + intelligence
                            + "\nIntelligence requise pour l'UE : "
                            + ((MobCard) this.clickedCard).getStrength()
                            + "\nTu perds " + ((MobCard) this.clickedCard).getHowManyLosingLevel()
                            + " niveau(x) \n Tu perds ton "
                            + ((MobCard) this.clickedCard).getWhatLosingArmor());
                    jeu.deleteCardFromPlaced(this.i, ((MobCard) this.clickedCard).getWhatLosingArmor());

                }
                refreshMalediction();
            } else {
                text.setText("Malediction, au joueur suivant");

                refreshUE();
            }

            if (this.nbCardsToDraw == 0) {
                this.i = this.i + 1;
                if (this.i == jeu.getNbPlayers()) {
                    this.i = 0;
                }
            } else {
                this.canDrawTreasure = true;
                this.canDrawDungeon = false;
                if (jeu.checkIfPlayerWin(this.i)) {
                    text.setText("Le joueur " + jeu.getPlayers().get(this.i).getName() + " a gagné !");
                    MainMenu.gameWindow.close();
                    FXMLLoader winloader = new FXMLLoader(getClass().getResource("/view/WinWindow.fxml"));
                    Parent winp = winloader.load();
                    WinWindow wincontroller = winloader.getController();
                    String msg = "Le joueur " + jeu.getPlayers().get(this.i).getName() + " a gagné !";
                    wincontroller.setText(msg);
                    Scene scene = new Scene(winp);
                    Stage winWindow = new Stage();
                    winWindow.setTitle("Munchkin UTBM");
                    winWindow.setScene(scene);
                    winWindow.show();
                }
            }
            update(jeu);
        } else {
            text.setText("Tu ne peux pas piocher de carte donjon.");
        }

    }

    @FXML
    void DrawTreasure(ActionEvent event) { // Pour piocher une carte trésor et adapter le comportement du jeu en
                                           // fonction du type de la carte
        refreshUE();
        refreshMalediction();
        if (this.canDrawTreasure && !this.canPlaceCard && !this.jetecarte) {
            refreshUE();
            if (this.nbCardsToDraw == 1) {
                this.clickedCard = jeu.drawTreasureCard(this.i);
                this.showCardPile = 2;

                text.setText(
                        "Place la carte que tu viens de piocher\nTu ne peux plus piocher de cartes. \nC'est au prochain joueur de piocher une carte donjon");

                this.nbCardsToDraw = 0;
                this.canDrawTreasure = false;
                this.canDrawDungeon = true;
                this.canPlaceCard = true;
            } else if (this.nbCardsToDraw > 1) {
                jeu.drawTreasureCard(this.i);
                this.showCardPile = 2;

                this.nbCardsToDraw = this.nbCardsToDraw - 1;
                text.setText("Place la carte que tu viens de piocher\nPuis tu peux encore piocher " + this.nbCardsToDraw
                        + " cartes.");
                this.canPlaceCard = true;
            } else {
                text.setText("Tu ne peux plus piocher de cartes.");
                this.canPlaceCard = false;
            }
            update(jeu);
        } else {
            text.setText("Tu ne peux pas piocher de carte trésor.");
        }

    }

    void player(int position) {
        if (this.jetecarte) {
            this.jeu.getHands().get(this.i).getCardPile().set(position, new Card());
            this.jetecarte = false;
            this.i = this.i + 1;
            if (this.i == jeu.getNbPlayers()) {
                this.i = 0;
            }
            update(jeu);
        } else if (!this.canPlaceCard) {
            this.clickedCard = this.jeu.getHands().get(this.i).getCardPile().get(position);
            this.jeu.getHands().get(this.i).getCardPile().set(position, new Card());
            this.canPlaceCard = true;
            update(jeu);
        }
    }

    @FXML
    void player1_1(ActionEvent event) {
        player(0);
    }

    @FXML
    void player1_2(ActionEvent event) {
        player(1);

    }

    @FXML
    void player1_3(ActionEvent event) {
        player(2);

    }

    @FXML
    void player1_4(ActionEvent event) {
        player(3);

    }

    @FXML
    void player2_1(ActionEvent event) {
        player(0);
    }

    @FXML
    void player2_2(ActionEvent event) {
        player(1);
    }

    @FXML
    void player2_3(ActionEvent event) {
        player(2);
    }

    @FXML
    void player2_4(ActionEvent event) {
        player(3);
    }

    @FXML
    void player3_1(ActionEvent event) {
        player(0);
    }

    @FXML
    void player3_2(ActionEvent event) {
        player(1);
    }

    @FXML
    void player3_3(ActionEvent event) {
        player(2);
    }

    @FXML
    void player3_4(ActionEvent event) {
        player(3);
    }

    @FXML
    void player4_1(ActionEvent event) {
        player(0);
    }

    @FXML
    void player4_2(ActionEvent event) {
        player(1);
    }

    @FXML
    void player4_3(ActionEvent event) {
        player(2);
    }

    @FXML
    void player4_4(ActionEvent event) {
        player(3);
    }

    @FXML
    void placed_mob(ActionEvent event) {
    }

    @FXML
    void placed_malediction(ActionEvent event) {
    }

    void placed(int deck_position) { // Pour placer une carte dans le jeu en fonction de son type. Si c'est une ue,
                                     // le combat a lieu
        Button button_placed_malediction = placed_malediction;
        Button button_placed_mob = placed_mob;

        if (this.jetecarte) {
            this.jeu.getPlacedCards().get(this.i).getCardPile().set(deck_position, new Card());
            this.jetecarte = false;
            this.canPlaceCard = false;
            this.showCardPile = 0;
            if (this.nbCardsToDraw == 0) {
                this.i = this.i + 1;
                if (this.i == jeu.getNbPlayers()) {
                    this.i = 0;
                }
                this.canDrawDungeon = true;
                refreshStats();
                update(jeu);
            }
        } else if (this.canPlaceCard) {

            if (this.clickedCard instanceof ObjectCard card) {
                this.jeu.placeCard(this.i, deck_position, this.clickedCard);

                switch (card.getTypeOfObject()) {
                    case "Outil" -> this.jeu.getPlayers().get(this.i).setOutil(card);
                    case "Materiel" -> this.jeu.getPlayers().get(this.i).setMateriel(card);
                    case "Aide" -> this.jeu.getPlayers().get(this.i).setAide(card);
                    case "Equipement" -> this.jeu.getPlayers().get(this.i).setEquipement(card);
                }

                refreshUE();

                text.setText("Plus " + card.getStrenghtBonus() + " d'intelligence");

                this.canPlaceCard = false;
                this.showCardPile = 0;
                if (this.nbCardsToDraw == 0) {
                    this.i = this.i + 1;
                    if (this.i == jeu.getNbPlayers()) {
                        this.i = 0;
                    }
                    this.canDrawDungeon = true;
                    refreshStats();
                    update(jeu);
                }

            } else if (this.clickedCard instanceof MaledictionCard) {
                this.maledictionCard = (MaledictionCard) this.clickedCard;

                ImageView imagePlacedMalediction = new ImageView(new Image(this.clickedCard.getImage()));
                imagePlacedMalediction.setFitHeight(100);
                imagePlacedMalediction.setFitWidth(80);
                button_placed_malediction.setGraphic(imagePlacedMalediction);
                button_placed_malediction.setPrefSize(0, 0);
                button_placed_malediction.setGraphic(imagePlacedMalediction);
                text.setText("Au prochain combat, le joueur perdra " + this.maledictionCard.getHowManyUpgrademob()
                        + " d'intelligence");

                refreshUE();
                this.canPlaceCard = false;
                this.showCardPile = 0;
                if (this.nbCardsToDraw == 0) {
                    this.i = this.i + 1;
                    if (this.i == jeu.getNbPlayers()) {
                        this.i = 0;
                    }
                    this.canDrawDungeon = true;
                    refreshStats();
                    update(jeu);
                }

            } else if (this.clickedCard instanceof MobCard) {
                ImageView imagePlacedMob = new ImageView(new Image(this.clickedCard.getImage()));
                imagePlacedMob.setFitHeight(100);
                imagePlacedMob.setFitWidth(80);
                button_placed_mob.setGraphic(imagePlacedMob);
                button_placed_mob.setPrefSize(0, 0);
                button_placed_mob.setGraphic(imagePlacedMob);

                int win = jeu.fightMob(this.i, (MobCard) this.clickedCard, (MaledictionCard) this.maledictionCard);
                int intelligence = jeu.getPlayers().get(this.i).getTotalStrength()
                        - this.maledictionCard.getHowManyUpgrademob();
                if (win > 0) {
                    text.setText("Ton intelligence : " + intelligence
                            + "\nIntelligence requise pour l'UE : "
                            + ((MobCard) this.clickedCard).getStrength()
                            + "\nTu gagnes " + ((MobCard) this.clickedCard).getNbLevelEarned()
                            + " niveau(x) \n Tu pioches "
                            + ((MobCard) this.clickedCard).getNbTreasureCardToDraw() + " carte(s) trésor(s)");
                } else {
                    text.setText("Ton intelligence : " + intelligence
                            + "\nIntelligence requise pour l'UE : "
                            + ((MobCard) this.clickedCard).getStrength()
                            + "\nTu perds " + ((MobCard) this.clickedCard).getHowManyLosingLevel()
                            + " niveau(x) \n Tu perds ton "
                            + ((MobCard) this.clickedCard).getWhatLosingArmor());
                    jeu.deleteCardFromPlaced(this.i, ((MobCard) this.clickedCard).getWhatLosingArmor());

                }
                refreshMalediction();
                this.canDrawDungeon = true;
            }

        }

        else {
            text.setText("Tu ne peux pas placer de carte.");
        }
    }

    @FXML
    void placed1_1(ActionEvent event) {

        placed(0);
    }

    @FXML
    void placed1_2(ActionEvent event) {

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

        placed(0);

    }

    @FXML
    void placed4_2(ActionEvent event) {
        placed(1);

    }

    @FXML
    void placed4_3(ActionEvent event) {

        placed(2);
    }

    @FXML
    void placed4_4(ActionEvent event) {
        placed(3);
    }

    @FXML
    void refreshStats() { // pour rafraichir l'affichage des statistiques des joueurs
        Player1Level.setText("Niveau : " + jeu.getPlayers().get(0).getLevel());
        Player2Level.setText("Niveau : " + jeu.getPlayers().get(1).getLevel());
        Player3Level.setText("Niveau : " + jeu.getPlayers().get(2).getLevel());
        Player4Level.setText("Niveau : " + jeu.getPlayers().get(3).getLevel());

        Player1Strenght.setText("Intelligence : " + jeu.getPlayers().get(0).getTotalStrength());
        Player2Strenght.setText("Intelligence : " + jeu.getPlayers().get(1).getTotalStrength());
        Player3Strenght.setText("Intelligence : " + jeu.getPlayers().get(2).getTotalStrength());
        Player4Strenght.setText("Intelligence : " + jeu.getPlayers().get(3).getTotalStrength());
    }

    @FXML
    void refreshUE() { // pour rafraichir l'affichage de l'emplacement des cartes UE à son état initial
        Button button_placed_mob = placed_mob;
        ImageView imagePlacedMob = new ImageView("file:src/img/ue_default.png");
        imagePlacedMob.setFitHeight(100);
        imagePlacedMob.setFitWidth(80);
        button_placed_mob.setGraphic(imagePlacedMob);
        button_placed_mob.setPrefSize(0, 0);
        button_placed_mob.setGraphic(imagePlacedMob);
    }

    void refreshMalediction() {// pour rafraichir l'affichage de l'emplacement des cartes Malédictions à son
                               // état initial
        Button button_placed_malediction = placed_malediction;
        this.maledictionCard = new MaledictionCard();
        ImageView imagePlacedMalediction = new ImageView("file:src/img/malediction_default.png");
        imagePlacedMalediction.setFitHeight(100);
        imagePlacedMalediction.setFitWidth(80);
        button_placed_malediction.setGraphic(imagePlacedMalediction);
        button_placed_malediction.setPrefSize(0, 0);
        button_placed_malediction.setGraphic(imagePlacedMalediction);
    }

}
