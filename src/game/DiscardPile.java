package game;

class DiscardPile extends CardPile {
    /**
     * Method that will add a card inside the discard pile.
     *
     * @param card the card that we want to add inside the discard pile.
     */
    void addDiscardPile(Card card) {
        getCardPile().add(card);
    }
}
