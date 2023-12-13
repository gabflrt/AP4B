public class ObjectCard extends Card {
    private int strengthBonus;

    ObjectCard() {
        super();
        this.strengthBonus = 0;
    }

    ObjectCard(String name, String description, int strengthBonus) {
        super(name, description);
        this.strengthBonus = strengthBonus;
    }

    /**
     * Getter for the strength bonus of an object
     * @return the strength bonus of an object
     */
    public int getStrengthBonus() {
        return this.strengthBonus;
    }

    /**
     * Setter for the strength bonus of an object
     * @param strengthBonus the strength bonus of an object
     */
    public void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

}
