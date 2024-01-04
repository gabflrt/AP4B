package game;

import java.util.Collections;

public class DrawPile extends CardPile {

    /**
     * The constructor of the drawPile
     */

    DrawPile() {
        super();
    }

    void generateDungeonPile() {
        if (this.getCardPile().isEmpty()) {
            for (int i = 0; i < 23; i++) {
                this.getCardPile().add(new MobCard("MTA", "Maths", "file:src/img/UE/MTA.png", 1, 1, 1, "", 0));
            }
            for (int i = 0; i < 24; i++) {
                this.getCardPile()
                        .add(new MobCard("AP4A", "Info", "file:src/img/UE/AP4A.png", 6, 2, 2, "", 1));
            }

            for (int i = 0; i < 24; i++) {
                this.getCardPile()
                        .add(new MobCard("WE4A", "Info", "file:src/img/UE/WE4A.png", 4, 1, 1, "", 2));
            }

            for (int i = 0; i < 24; i++) {
                this.getCardPile()
                        .add(new MobCard("PS28", "Energie", "file:src/img/UE/PS28.png", 3, 1, 1, "", 0));
            }


        } else {
            System.out.println("The draw pile has already been generated.");
        }
    }

    void generateTreasurePile() {
        if (this.getCardPile().isEmpty()) {

            for (int i = 0; i < 5; i++) {
                this.getCardPile()
                        .add(new ObjectCard("Annale", "" , "file:src/img/Objets/Annale.png", 2, "Outil"));
            }
            for (int i = 0; i < 5; i++) {
                this.getCardPile()
                        .add(new ObjectCard("Boules Quies", "" , "file:src/img/Objets/Boule.png", 1, "Equipement"));
            }
            for (int i = 0; i < 5; i++) {
                this.getCardPile()
                        .add(new ObjectCard("Café", "" , "file:src/img/Objets/Cafe.png", 1, "Equipement"));
            }
            for (int i = 0; i < 5; i++) {
                this.getCardPile()
                        .add(new ObjectCard("Calculatrice", "" , "file:src/img/Objets/Calculatrice.png", 1, "Materiel"));
            }
            for (int i = 0; i < 5; i++) {
                this.getCardPile()
                        .add(new ObjectCard("ChatGPT", "" , "file:src/img/Objets/ChatGPT.png", 2, "Aide"));
            }
            for (int i = 0; i < 5; i++) {
                this.getCardPile()
                        .add(new ObjectCard("Exercices", "" , "file:src/img/Objets/Exercices.png", 1, "Outil"));
            }
            for (int i = 0; i < 5; i++) {
                this.getCardPile()
                        .add(new ObjectCard("Ordinateur", "" , "file:src/img/Objets/Ordinateur.png", 2, "Materiel"));
            }
            for (int i = 0; i < 5; i++) {
                this.getCardPile()
                        .add(new ObjectCard("Prof", "" , "file:src/img/Objets/Prof.png", 2, "Aide"));
            }

        } else {
            System.out.println("The draw pile has already been generated.");
        }
    }

    /**
     * This method will randomly pick a card in the draw card.
     * We use shuffle to mix all the card randomly, and then, we pick the first card
     * of the drawPile and return it.
     * If the drawPile is empty, an error will be written in the console and an
     * empty card will be return.
     * 
     * @return Card drawn
     */
    public Card pickCardPile() {
        if (getCardPile().isEmpty()) {
            System.out.println("Error: the draw pile is empty!");
            return new Card();
        } else {
            Collections.shuffle(this.getCardPile());
            Card drawncard = new Card();
            drawncard = this.getCardPile().get(0);
            this.getCardPile().remove(0);
            return drawncard;
        }
    }
}
