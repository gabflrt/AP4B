package game;

class MobCard extends Card {
    private int strength; // Strength of the mob
    private int nbLevelEarned; // Number of level earned when the mob is defeated
    private int NbTreasureCardToDraw; // Number of treasure card to draw
    private String WhatLosingArmor; // Which piece of armor the player will lose
    private int HowManyLosingLevel; // How many level the player will lose

    MobCard() {
        super();
        this.strength = 0;
        this.nbLevelEarned = 0;
        this.NbTreasureCardToDraw = 0;
        this.WhatLosingArmor = "";
        this.HowManyLosingLevel = 0;
    }

    MobCard(String name, String description, int strength, int nbLevelEarned, int NbTreasureCardToDraw,
            String WhatLosingArmor, int HowManyLosingLevel) {
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
    void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Getter for the strength of a mob
     *
     * @return the strength of a mob
     */
    int getStrength() {
        return this.strength;
    }

    int getNbLevelEarned() {
        return this.nbLevelEarned;
    }

    int getNbTreasureCardToDraw() {
        return this.NbTreasureCardToDraw;
    }

    int getHowManyLosingLevel() {
        return this.HowManyLosingLevel;
    }

    String getWhatLosingArmor() {
        return this.WhatLosingArmor;
    }

    void looseFight(Player player) {
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
