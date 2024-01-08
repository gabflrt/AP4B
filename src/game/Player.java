package game;

import java.util.Scanner;

public class Player {
    private String name;
    private int level, strength;
    private String race, classe;
    private Boolean sex;
    private String outilName, materielName, aideName, equipementName;

    private int outilBonus, materielBonus, aideBonus, equipementBonus;

    Player() {
        this.name = "";
        this.level = 1;
        this.strength = 1;
        this.race = "";
        this.classe = "";
        this.sex = true;
        this.outilName = "";
        this.materielName = "";
        this.aideName = "";
        this.equipementName = "";
        this.outilBonus = 0;
        this.materielBonus = 0;
        this.aideBonus = 0;
        this.equipementBonus = 0;

    }

    Player(String name) {
        this.name = name;
        this.level = 1;
        this.strength = 1;
        this.race = "";
        this.classe = "";
        this.sex = true;
        this.outilName = "";
        this.materielName = "";
        this.aideName = "";
        this.equipementName = "";
        this.outilBonus = 0;
        this.materielBonus = 0;
        this.aideBonus = 0;
        this.equipementBonus = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String player) {
        this.name = player;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getTotalStrength() {
        return this.strength + this.outilBonus + this.materielBonus + this.aideBonus + this.equipementBonus;
    }

    public void setOutil(ObjectCard outil) {
        this.outilName = outil.getName();
        this.outilBonus = outil.getStrenghtBonus();
    }

    public void setMateriel(ObjectCard materiel) {
        this.materielName = materiel.getName();
        this.materielBonus = materiel.getStrenghtBonus();
    }

    public void setAide(ObjectCard aide) {
        this.aideName = aide.getName();
        this.aideBonus = aide.getStrenghtBonus();
    }

    public void setEquipement(ObjectCard equipement) {
        this.equipementName = equipement.getName();
        this.equipementBonus = equipement.getStrenghtBonus();
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getClasse() {
        return this.classe;
    }

    /**
     * Method that will ask the player which username he wants.
     * Then, the player will have a username attribute according to what he wrote.
     *
     * @return the username of the player
     */
    String askName() {
        Scanner scanneur = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter username");
        this.name = scanneur.nextLine(); // Read user input
        return ("Username is: " + this.name); // Output user input
    }

    /**
     * This method check if a player can use an object card according to his class.
     * 
     * @return true if the player can use the object, false otherwise
     */
    boolean canUseObject(ObjectCard objectCard) {

        return true;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", race='" + race + '\'' +
                ", classe='" + classe + '\'' +
                ", sex=" + sex +
                ", outil='" + outilName + '\'' +
                ", materiel='" + materielName + '\'' +
                ", aide='" + aideName + '\'' +
                ", equipement='" + equipementName + '\'' +
                '}';
    }

}
