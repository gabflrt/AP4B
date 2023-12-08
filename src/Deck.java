import java.util.ArrayList;

public class Deck extends CardPile {
    /**
     * This method will give the 2 cards that a deck must have at the beginning of
     * the game.
     *
     * @param drawPile the draw pile from which we will draw the 12 cards
     * @return an ArrayList with 2 cards.
     */
    public ArrayList<Card> initializeDeck(DrawPile drawPileDungeon, DrawPile drawPileTreasure) {
        for (int i = 0; i < 2; i++) {
            this.getCardPile().add(drawPileDungeon.pickCardPile());
        }
        for (int i = 0; i < 2; i++) {
            this.getCardPile().add(drawPileTreasure.pickCardPile());
        }
        return this.getCardPile();
    }

}
