import java.util.ArrayList;
import java.util.Scanner;

public class Deck extends CardPile {
    /**
     * This method will give the 2 cards that a deck must have at the beginning of
     * the game.
     *
     * @param drawPileDungeon  the draw pile of the dungeon
     * @param drawPileTreasure the draw pile of the treasure
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

    /**
     * This method is a toString method that will print the deck of the player.
     *
     * @return a string with the deck of the player.
     */
    public String toString() {
        System.out.println("The deck of the player is : ");
        for (int i = 0; i < this.getCardPile().size(); i++) {
            System.out.println(this.getCardPile().get(i));
        }
        return "";
    }
}
