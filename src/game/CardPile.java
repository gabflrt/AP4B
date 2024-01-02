package game;

import java.util.ArrayList;
import java.util.Collections;

public class CardPile {
    /**
     * The ArrayList of cards that will be use for the discardPile, the drawPile and
     * the decks
     */
    private ArrayList<Card> cardPile = new ArrayList<>(150);

    /**
     * The constructor of the cardPile
     */

    CardPile() {
        this.cardPile = new ArrayList<>();
    }

    /**
     * Method especially for debugging because it will be overwritten in the
     * subclasses
     * 
     * @return
     */
    public String toString() {
        System.out.println(this.cardPile.size());
        for (int i = 0; i < this.cardPile.size(); i++) {
            System.out.println(String.valueOf(cardPile.get(i)));
        }
        return "";
    }

    /**
     * The getter of the cardPile to allow us to get the arraylist in the other
     * files
     * 
     * @return
     */
    public ArrayList<Card> getCardPile() {
        return cardPile;
    }

    /**
     * The setter of the cardPile to allow us to modify the array list in the other
     * files
     * 
     * @param cardPile
     */
    void setCardPile(ArrayList<Card> cardPile) {
        this.cardPile = cardPile;
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
        Card drawncard = new Card();
        if (this.cardPile.isEmpty()) {
            System.out.println("Error: the pile is empty!");
        } else {
            Collections.shuffle(this.getCardPile());
            drawncard = this.getCardPile().get(0);
            this.getCardPile().remove(0);
        }
        return drawncard;
    }

    public boolean isEmpty() {
        return this.cardPile.isEmpty();
    }
}
