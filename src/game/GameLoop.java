package game;



public class GameLoop {
    public void startGame(){
        Game game = new Game();
        game.initializeGame(4, "aziz", "gab", "napoleon", "supertimcraft"); // Creating a new game
        boolean gameOver = false; // Tells when the game is over
        game.drawDungeonCard(0);

        while (!gameOver) { // Game loop for the game
            for (int i = 0; i < game.getNbPlayers(); i++) { // This loop will make every player plays one turn.
                game.drawDungeonCard(i);
                if(game.checkIfPlayerWin(i)){
                    gameOver = true;
                }
            }
        }
    }
}
