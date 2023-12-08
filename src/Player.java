import java.util.Scanner;

public class Player {
    private String name;
    private int level, strength;
    private String race, classe;
    private Boolean sex;
    private String helmet, chestplate, legging, boots;

    Player() {
        this.name = "";
        this.level = 0;
        this.strength = 0;
        this.race = "";
        this.classe = "";
        this.sex = true;
        this.helmet = "";
        this.chestplate = "";
        this.legging = "";
        this.boots = "";
    }
//aziz
    Player(String name) {
        this.name = name;
        this.level = 0;
        this.strength = 0;
        this.race = "";
        this.classe = "";
        this.sex = true;
        this.helmet = "";
        this.chestplate = "";
        this.legging = "";
        this.boots = "";
    }

    public String getName() {
        return name;
    }

    public void setPlayer(String player) {
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

    public void setHelmet(String helmet) {this.helmet = helmet;}

    public void setChestplate(String chestplate) {this.chestplate = chestplate;}

    public void setLegging(String legging) {this.legging = legging;}

    public void setBoots(String boots) {this.boots = boots;}

    /**
     * Method that will ask the player which username he wants.
     * Then, the player will have a username attribute according to what he wrote.
     *
     * @return the username of the player
     */
    public String askName() {
        Scanner scanneur = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter username");
        this.name = scanneur.nextLine(); // Read user input
        return ("Username is: " + this.name); // Output user input
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
                ", helmet='" + helmet + '\'' +
                ", chestplate='" + chestplate + '\'' +
                ", legging='" + legging + '\'' +
                ", boots='" + boots + '\'' +
                '}';
    }

    public void drawTreasureCard() {
        // TODO later
    }
}
