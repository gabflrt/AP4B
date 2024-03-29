/**
 * The Card class represents a card with a name and description.
 */

package game;

import java.awt.*;

public class Card {
    private String name;
    private String description;
    private String image;

    /**
     * Constructs an empty Card object.
     */
    public Card() {
        this.name = "";
        this.description = "";
        this.image = "file:src/img/default.png";
    }

    /**
     * Constructs a Card object with the given name and description.
     * 
     * @param name        the name of the card
     * @param description the description of the card
     */
    Card(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;

    }

    /**
     * Constructs a Card object by copying the values from another Card object.
     * 
     * @param card the card to be copied
     */
    Card(Card card) {
        this.name = card.name;
        this.description = card.description;
        this.image = card.image;
    }

    /**
     * Returns the image of the card.
     * 
     * @return the image of the card
     */

    public String getImage() {
        return this.image;
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
    String getDescription() {
        return this.description;
    }

    /**
     * Sets the name of the card.
     * 
     * @param name the name of the card
     * @return the updated Card object
     */
    Card setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the description of the card.
     * 
     * @param description the description of the card
     * @return the updated Card object
     */
    Card setDescription(String description) {
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
        output += "Image: " + this.image + "\n";
        return output;
    }
}
