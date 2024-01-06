package game;

public class ObjectCard extends Card {
    private int strengthBonus;
    private String typeOfObject;

    ObjectCard() {
        super();
        this.strengthBonus = 0;
        this.typeOfObject = "";
    }

    ObjectCard(String name, String description, String image, int strengthBonus, String typeOfObject) {
        super(name, description, image);
        this.strengthBonus = strengthBonus;
        this.typeOfObject = typeOfObject;
    }

    /**
     * Getter for the strength bonus of an object
     *
     * @return the strength bonus of an object
     */
   public int getStrenghtBonus() {
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
    public String getTypeOfObject() {
        return this.typeOfObject;
    }

}
