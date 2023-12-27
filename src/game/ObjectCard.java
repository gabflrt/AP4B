package game;

class ObjectCard extends Card {
    private int strengthBonus;
    private String classeCondition;

    ObjectCard() {
        super();
        this.strengthBonus = 0;
        this.classeCondition = "";
    }

    ObjectCard(String name, String description, String image, int strengthBonus, String classeCondition) {
        super(name, description, image);
        this.strengthBonus = strengthBonus;
        this.classeCondition = classeCondition;
    }

    /**
     * Getter for the strength bonus of an object
     * 
     * @return the strength bonus of an object
     */
    int getStrengthBonus() {
        return this.strengthBonus;
    }

    /**
     * Setter for the strength bonus of an object
     * 
     * @param strengthBonus the strength bonus of an object
     */
    void setStrengthBonus(int strengthBonus) {
        this.strengthBonus = strengthBonus;
    }

    /**
     * Getter for the class condition of an object
     * 
     * @return the class condition of an object
     */
    String getClasseCondition() {
        return this.classeCondition;
    }

}
