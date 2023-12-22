public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame(); // Creating a new game
        boolean gameOver = false; // Tells when the game is over
        game.drawDungeonCard(game.getPlayerWithHighestScore());

        while (!gameOver) { // Game loop for the game
            for (int i = 0; i < game.getNbPlayers(); i++) { // This loop will make every player plays one turn.
                // Appelle la fonctionn pioche carte
            }
        }

    }

}