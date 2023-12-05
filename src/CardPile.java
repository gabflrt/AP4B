import java.util.ArrayList;

public class CardPile {
    /**
     * The ArrayList of cards that will be use for the discardPile, the drawPile and
     * the decks
     */
    private ArrayList<Card> cardPile = new ArrayList<>(150);

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
    public void setCardPile(ArrayList<Card> cardPile) {
        this.cardPile = cardPile;
    }
}
