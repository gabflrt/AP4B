package game;

class MaledictionCard extends Card {
    private String WhatLosingArmor; // Which piece of armor the player will lose
    private int HowManyLosingLevel; // How many level the player will lose
    private int HowManyUpgrademob; // How many strength the mob will gain

    MaledictionCard() { // Default constructor
        super();
        this.WhatLosingArmor = "";
        this.HowManyLosingLevel = 0;
        this.HowManyUpgrademob = 0;
    }

    MaledictionCard(String name, String description, String image, String WhatLosingArmor, int HowManyLosingLevel,
            int HowManyUpgrademob) { // Constructor with parameters
        super(name, description, image);
        this.WhatLosingArmor = WhatLosingArmor;
        this.HowManyLosingLevel = HowManyLosingLevel;
        this.HowManyUpgrademob = HowManyUpgrademob;
    }

    void applyMaledictionPlayer(Player player) { // Method that will apply the malediction to the player

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

    void applyMaledictionMob(MobCard mob) { // Method that will apply the malediction to the mob
        mob.setStrength(mob.getStrength() + this.HowManyUpgrademob);
    }

}
