public class MobCard extends Card {
    private int strength; // Strength of the mob
    private int nbLevelEarned; // Number of level earned when the mob is defeated
    private int NbTreasureCardToDraw; // Number of treasure card to draw
    private String WhatLosingArmor; // Which piece of armor the player will lose
    private int HowManyLosingLevel; // How many level the player will lose
    MobCard(){
        super();
        this.strength = 0;
        this.nbLevelEarned = 0;
        this.NbTreasureCardToDraw = 0;
        this.WhatLosingArmor = "";
        this.HowManyLosingLevel = 0;
    }

    MobCard(String name, String description, int strength , int nbLevelEarned, int NbTreasureCardToDraw, String WhatLosingArmor, int HowManyLosingLevel){
        super(name, description);
        this.strength = strength;
        this.nbLevelEarned = nbLevelEarned;
        this.NbTreasureCardToDraw = NbTreasureCardToDraw;
        this.WhatLosingArmor = WhatLosingArmor;
        this.HowManyLosingLevel = HowManyLosingLevel;
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

    public void win(Player player) {
        player.setLevel(player.getLevel() + this.nbLevelEarned);
        for (int i = 0; i < this.NbTreasureCardToDraw; i++) {
            player.drawTreasureCard();
        }
    }

    public void loose(Player player) {
        switch (this.WhatLosingArmor) {
            case "Casque":
                player.setHelmet("");
                break;
            case "Plastron":
                player.setChestplate("");
                break;
            case "Pantalon":
                player.setLegging("");
                break;
            case "Bottes":
                player.setBoots("");
                break;
            default:
                break;
        }
        player.setLevel(player.getLevel() - this.HowManyLosingLevel);
    }
}
