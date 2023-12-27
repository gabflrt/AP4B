package game;

import java.util.Collections;

class DrawPile extends CardPile {

    void generateDungeonPile() {
        if (this.getCardPile().isEmpty()) {
            for (int i = 0; i < 23; i++) {
                this.getCardPile().add(new MobCard("MTA", "Maths", "file:src/img/UE/MTA.png", 1, 1, 1, "", 0));
            }
            for (int i = 0; i < 24; i++) {
                this.getCardPile().add(new MobCard("AP4A", "Info", "file:src/img/UE/AP4A.png", 6, 2, 2, "Chestplate", 1));
            }

            for (int i = 0; i < 24; i++) {
                this.getCardPile().add(new MobCard("WE4A", "Info", "file:src/img/UE/WE4A.png", 4, 1, 1, "Chestplate", 2));
            }

            for (int i = 0; i < 24; i++) {
                this.getCardPile().add(new MobCard("PS28", "Energie", "file:src/img/UE/PS28.png", 3, 1, 1, "Chestplate", 0));
            }

        } else {
            System.out.println("The draw pile has already been generated.");
        }
    }

    void generateTreasurePile() {
        if (this.getCardPile().isEmpty()) {
            for (int i = 0; i < 38; i++) {
                this.getCardPile().add(new ObjectCard("Couteau", "Aie", "file:src/img/UE/PS28.png", 2, ""));
            }
            for (int i = 0; i < 39; i++) {
                this.getCardPile().add(new ObjectCard("Casque", "C'est un casque", "file:src/img/UE/PS28.png", 3, "Elf"));
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
    Card pickCardPile() {
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
