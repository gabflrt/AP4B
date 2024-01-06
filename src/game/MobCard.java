package game;

import javafx.scene.image.ImageView;

public class MobCard extends Card {
    private int strength; // Strength of the mob
    private int nbLevelEarned; // Number of level earned when the mob is defeated
    private int NbTreasureCardToDraw; // Number of treasure card to draw
    private String WhatLosingArmor; // Which piece of armor the player will lose
    private int HowManyLosingLevel; // How many level the player will lose
    private String img;

    MobCard() {
        super();
        this.strength = 0;
        this.nbLevelEarned = 0;
        this.NbTreasureCardToDraw = 0;
        this.WhatLosingArmor = "";
        this.HowManyLosingLevel = 0;
    }

    MobCard(String name, String description, String image, int strength, int nbLevelEarned, int NbTreasureCardToDraw,
            String WhatLosingArmor, int HowManyLosingLevel) {
        super(name, description, image);
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
    public int getStrength() {
        return this.strength;
    }

    public int getNbLevelEarned() {
        return this.nbLevelEarned;
    }

    int getNbTreasureCardToDraw() {
        return this.NbTreasureCardToDraw;
    }

    public int getHowManyLosingLevel() {
        return this.HowManyLosingLevel;
    }

    String getWhatLosingArmor() {
        return this.WhatLosingArmor;
    }

    void looseFight(Player player) {
        switch (this.WhatLosingArmor) {
            case "Outil":
                player.setOutil(new ObjectCard("", "", "file:src/img/default", 0, "outil"));
                break;
            case "Materiel":
                player.setMateriel(new ObjectCard("", "", "file:src/img/default", 0,
                        "materiel"));
                break;
            case "Equipement":
                player.setEquipement(new ObjectCard("", "", "file:src/img/default", 0,
                        "equipement"));
                break;
            case "Aide":
                player.setAide(new ObjectCard("", "", "file:src/img/default", 0, "aide"));
                break;
            default:
                break;
        }
        player.setLevel(player.getLevel() - this.HowManyLosingLevel);
    }
}
