public class MaledictionCard extends Card {
    private String WhatLosingArmor; // Which piece of armor the player will lose
    private int HowManyLosingLevel; // How many level the player will lose
    private int HowManyUpgrademob; // How many strength the mob will gain

    MaledictionCard() { // Default constructor
        super();
        this.WhatLosingArmor = "";
        this.HowManyLosingLevel = 0;
        this.HowManyUpgrademob = 0;
    }

    MaledictionCard(String name, String description, String WhatLosingArmor, int HowManyLosingLevel, int HowManyUpgrademob) { // Constructor with parameters
        super(name, description);
        this.WhatLosingArmor = WhatLosingArmor;
        this.HowManyLosingLevel = HowManyLosingLevel;
        this.HowManyUpgrademob = HowManyUpgrademob;
    }

    public void applyMalediction(Player player) { // Method that will apply the malediction to the player

        switch (this.WhatLosingArmor) {
            case "Casque":
                player.setHelmet();
                break;
            case "Plastron":
                player.setChestplate();
                break;
            case "Pantalon":
                player.setLegging();
                break;
            case "Bottes":
                player.setBoots();
                break;
            default:
                break;
        }
        player.setLevel(player.getLevel() - this.HowManyLosingLevel);
    }

    public void applyMalediction(MobCard mob) { // Method that will apply the malediction to the mob
        mob.setStrength(mob.getStrength() + this.HowManyUpgrademob);
    }

}
