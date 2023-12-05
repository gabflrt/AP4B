/**
 * The Card class represents a card with a name and description.
 */
public class Card {
    private String name;
    private String description;

    /**
     * Constructs an empty Card object.
     */
    public Card() {
        this.name = "";
        this.description = "";
    }

    /**
     * Constructs a Card object with the given name and description.
     * 
     * @param name        the name of the card
     * @param description the description of the card
     */
    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Constructs a Card object by copying the values from another Card object.
     * 
     * @param card the card to be copied
     */
    public Card(Card card) {
        this.name = card.name;
        this.description = card.description;
    }

    /**
     * Returns the name of the card.
     * 
     * @return the name of the card
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the description of the card.
     * 
     * @return the description of the card
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the name of the card.
     * 
     * @param name the name of the card
     * @return the updated Card object
     */
    public Card setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the description of the card.
     * 
     * @param description the description of the card
     * @return the updated Card object
     */
    public Card setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Returns a string representation of the card.
     * 
     * @return a string representation of the card
     */
    public String toString() {
        String output = "";
        output += "Name: " + this.name + "\n";
        output += "Description: " + this.description + "\n";
        return output;
    }
}
