import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private int nbPlayers;
    ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Deck> hands = new ArrayList<>();
    private ArrayList<Deck> placedCards = new ArrayList<>();
    private DrawPile drawPileDungeon = new DrawPile();
    private DrawPile drawPileTreasure = new DrawPile();
    private DiscardPile discardPileDungeon = new DiscardPile();
    private DiscardPile discardPileTreasure = new DiscardPile();

    /**
     * Constructor of the game
     */
    public Game() {
        this.nbPlayers = 0; // We initialize the number of players to 0
    }

    /**
     * Constructor of the game
     * 
     * @param nbPlayers the number of players
     */
    public Game(int nbPlayers) {
        this.nbPlayers = nbPlayers; // We initialize the number of players to the number of players given in
                                    // parameter
    }

    /**
     * Setter for the number of players that will play
     *
     * @param nb the number of players that will play
     */
    public void setNbPlayers(int nb) {
        this.nbPlayers = nb;
    }

    /**
     * Getter that return the number of players
     *
     * @return the number of players
     */
    public int getNbPlayers() {
        return this.nbPlayers;
    }

    /**
     * Setter that will set the ArrayList players, which contains every player in a
     * game.
     *
     * @param players the ArrayList of players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Getter that will return the ArrayList containing all the players in a game.
     *
     * @return the ArrayList containing all the players in a game.
     */
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    /**
     * This method will initialize the game.
     * When we want to start a new game, this method will be called and initialize
     * all the things that we need.
     * So we will create all the new players.
     */
    public void initializeGame() {
        howMuchPlayers();
        for (int i = 0; i < nbPlayers; i++) {
            Player player = new Player();
            player.askName();
            this.players.add(player);
        }
        this.drawPileDungeon.generateDungeonPile();
        this.drawPileTreasure.generateTreasurePile();

        for (int i = 0; i < nbPlayers; i++) {
            Deck hand = new Deck();
            hand.initializeDeck(this.drawPileDungeon, this.drawPileTreasure);
            this.hands.add(hand);
        }

        for (int i = 0; i < nbPlayers; i++) {
            Deck placedCard = new Deck();
            this.placedCards.add(placedCard);
        }

        System.out.println(this.hands.get(0).getCardPile().size());

    }

    /**
     * This method will simply ask how many people wants to play the game.
     * It should be called during the initialization of the game.
     * We also check that the number of players is correct (between 2 and 8).
     *
     * @return int, the number of players
     */
    public int howMuchPlayers() {
        Scanner scanneur = new Scanner(System.in); // Create a Scanner object
        System.out.println("How many people will play?"); // Asks how many people will play
        if (scanneur.hasNextInt()) { // Check that the value is an integer
            int nbPlayers = scanneur.nextInt(); // Read user input
            this.setNbPlayers(nbPlayers); // Set the correct amount of players
        } else {
            System.out.println("Please, just write a number.");
            howMuchPlayers();
        }
        if (nbPlayers < 3 || nbPlayers > 6) { // Check that the number of players is between 3 and 6.
            System.out.println("Please write a number between 3 and 6.");
            howMuchPlayers();
        }
        return nbPlayers;
    }
}
