import java.io.IOException;
import java.sql.SQLOutput;
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
            System.out.println(this.hands.get(i));
        }

        for (int i = 0; i < nbPlayers; i++) {
            Deck placedCard = new Deck();
            this.placedCards.add(placedCard);
            placeCard(i); // Ask the player if he wants to place a card from his hand to his deck with the method placeCard
            System.out.println(this.placedCards.get(i));


        }

        String playerWhoStart = this.players.get(bestThrowDice()).getName();
        System.out.println("\n" + playerWhoStart  + " commence la partie.\n");

    }

    /**
     * This method will throw a dice.
     * It will return a number between 1 and 6.
     *
     * @return int, the number of the dice
     */
    public int throwDice() {
        int dice = (int) (Math.random() * 6) + 1;
        return dice;
    }

    /**
     * This method will make every player throw a dice.
     * The player with the highest score will be the first to play.
     *
     * @return int, the number of the player that will start the game
     */
    public int bestThrowDice() {
        int highestScore = 0;
        int playerWithHighestScore = -1;
        System.out.println("Lancement des dés pour déterminer qui commence la partie.");
        System.out.println("");
        for (int i = 0; i < this.nbPlayers; i++) {
            int diceResult = throwDice();

            System.out.println(this.players.get(i).getName() + " a obtenu " + diceResult +".");
            if (diceResult > highestScore) {
                highestScore = diceResult;
                playerWithHighestScore = i;
            }
        }
        return playerWithHighestScore;
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
        System.out.println("Combien de joueurs dans la partie (entre 3 et 6) ?"); // Asks how many people will play
        if (scanneur.hasNextInt()) { // Check that the value is an integer
            int nbPlayers = scanneur.nextInt(); // Read user input
            this.setNbPlayers(nbPlayers); // Set the correct amount of players
        } else {
            System.out.println("Ecrivez un nombre.");
            howMuchPlayers();
        }
        if (nbPlayers < 3 || nbPlayers > 6) { // Check that the number of players is between 3 and 6.
            System.out.println("Ecrivez un nombre entre 3 et 6.");
            howMuchPlayers();
        }
        return nbPlayers;
    }

    /**
     * This method will make a player fight a monster.
     * It will take the strength of the player and the strength of the monster.
     * If the player has more strength than the monster, he wins.
     * If the player wins, he will gain a level and a treasure.
     * If the player loses, just do nothing.
     *
     * @param player the player that will fight the monster (place in the ArrayList
     *               of players)
     * @param mob    the monster that the player will fight
     */
    public void fightMob(int player, MobCard mob) {
        this.players.get(0).setStrength(3);
        System.out.println(this.players.get(player).getName() + " passe le final de " + mob.getName() + ".");
        System.out.println("Vous avez " + this.players.get(player).getStrength() + " d'intelligence.");
        System.out.println("L'UV nécessite " + mob.getStrength() + " d'intelligence.");
        System.out.println("");

        if (this.players.get(player).getStrength() > mob.getStrength()) {
            this.players.get(player).setLevel(this.players.get(player).getLevel() + mob.getNbLevelEarned());
            for (int i = 0; i < mob.getNbTreasureCardToDraw(); i++) {
                drawTreasureCard(this.players.get(player));
            }
            System.out.println("Succès !");
            System.out.println("Après délibération, le jury de l'UV " + mob.getName() + " vous attribue l'UV.");
            System.out.println("Note ECTS : A");

        } else {
            int defaite = throwDice();
            System.out.println("Echec... Mais vous avez une chance de vous rattraper au jury.");
            if (defaite > 4){
                System.out.println("Passage au jury réussi !");
                System.out.println("Après délibération, le jury de l'UV " + mob.getName() + " vous attribue l'UV.");
                System.out.println("Note ECTS : E");
            } else {
                System.out.println("Passage au jury raté !");
                this.players.get(player).setLevel(this.players.get(player).getLevel() - mob.getHowManyLosingLevel());
                switch (mob.getWhatLosingArmor()){
                    case "Casque":
                        this.players.get(player).setHelmet("");
                        break;
                    case "Plastron":
                        this.players.get(player).setChestplate("");
                        break;
                    case "Pantalon":
                        this.players.get(player).setLegging("");
                        break;
                    case "Bottes":
                        this.players.get(player).setBoots("");
                        break;
                    default:
                        break;
                }
                System.out.println("Après délibération, le jury de l'UV " + mob.getName() + " ne vous attribue pas l'UV.");
                System.out.println("Note ECTS : F");
            }

        }
    }

    public void drawDungeonCard(int player) {
        Card card = this.drawPileDungeon.pickCardPile();
        if (card.getClass().getName().equals("MobCard")) {
            fightMob(player, (MobCard) card);
        } else if (card.getClass().getName().equals("MaledictionCard")) {
            ((MaledictionCard) card).applyMaledictionPlayer(this.getPlayers().get(player));
        } else {
            this.hands.get(player).getCardPile().add(card);
            System.out.println("Une autre carte a été piochée.");
        }
    }

    public void drawTreasureCard(Player player) {
        // TODO later
    }

    /**
     * This method allows a player to place a card from his hand into his deck.
     * If a player has cards, it will ask the player which card he wants to place,
     * and then, it will place it.
     * If the player doesn't have any card in his hand, it will tell him that he
     * can't place a card.
     * If the player has a card in his hand, it will ask him which card he wants to
     * place.
     *
     * @param player the player that will place a card
     *               (place in the ArrayList of players)
     */
    public void placeCard(int player) {
        if (this.hands.get(player).getCardPile().isEmpty()) {
            System.out.println("Vous n'avez pas de carte en main, vous ne pouvez pas en placer.");
        } else {
            System.out.println("Voici votre main :");
            System.out.println(this.hands.get(player));
            System.out.println("Quelle carte voulez-vous placer ? (1 à 12)");
            Scanner myObj = new Scanner(System.in); // Create a Scanner object
            int choice = myObj.nextInt();
            if (choice > 0 && choice < 13) {
                if (choice <= this.hands.get(player).getCardPile().size()) {
                    this.placedCards.get(player).getCardPile().add(this.hands.get(player).getCardPile().get(choice - 1));
                    this.hands.get(player).getCardPile().remove(choice - 1);
                } else {
                    System.out.println("Vous n'avez pas cette carte en main.");
                }
            } else {
                System.out.println("Vous n'avez pas cette carte en main.");
            }
        }
    }
}
