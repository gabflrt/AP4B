import java.util.Scanner;

public class Player {
    private String player;
    private int level, strength;
    private String race, classe;
    private Boolean sex;

    Player() {
        this.player = "";
        this.level = 0;
        this.strength = 0;
        this.race = "";
        this.classe = "";
        this.sex = true;
    }

    Player(String name) {
        this.player = name;
        this.level = 0;
        this.strength = 0;
        this.race = "";
        this.classe = "";
        this.sex = true;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
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

    /**
     * Method that will ask the player which username he wants.
     * Then, the player will have a username attribute according to what he wrote.
     *
     * @return the username of the player
     */
    public String askName() {
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        System.out.println("Enter username");

        this.player = myObj.nextLine(); // Read user input
        return ("Username is: " + this.player); // Output user input
    }

    @Override
    public String toString() {
        return "Player{" +
                "player='" + player + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", race='" + race + '\'' +
                ", classe='" + classe + '\'' +
                ", sex=" + sex +
                '}';
    }
}
