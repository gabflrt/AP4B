import java.util.Collections;

public class DrawPile extends CardPile {

    public void generateDungeonPile() {
        if (this.getCardPile().isEmpty()) {
            for (int i = 0; i < 66; i++) {
                this.getCardPile().add(new Card("Monster", "Goblin"));
            }

        } else {
            System.out.println("The draw pile has already been generated.");
        }
    }

    public void generateTreasurePile() {
        if (this.getCardPile().isEmpty()) {
            for (int i = 0; i < 66; i++) {
                this.getCardPile().add(new Card("Monster", "Goblin"));
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
    public Card pickDrawCard() {
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
