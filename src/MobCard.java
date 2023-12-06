public class MobCard extends Card {
    private int strength;
    MobCard(){
        super();
        this.strength = 0;
    }

    MobCard(String name, String description, int strength){
        super(name, description);
        this.strength = strength;
    }

    /**
     * Setter for the strength of a mob
     *
     * @param strength the strength of a mob
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Getter for the strength of a mob
     *
     * @return the strength of a mob
     */
    public int getStrength() {
        return this.strength;
    }
}
