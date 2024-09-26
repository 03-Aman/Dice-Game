import java.util.Scanner;

public class Game {
    private Player[] players;
    private Dice dice;
    private int currentPlayer;
    private boolean gameOver;

    public Game(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player();
        }
        dice = new Dice();
        currentPlayer = 0;
        gameOver = false;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            playTurn();
            System.out.println("Do you want to continue the game? (y/n): ");
            String input = scanner.next();
            if (input.equalsIgnoreCase("n")) {
                gameOver = true;
            }
            nextPlayer();
        }
        declareWinner();
        scanner.close();
    }

    private void playTurn() {
        Player player = players[currentPlayer];
        System.out.println("Player " + (currentPlayer + 1) + "'s turn:");
        dice.roll();
        dice.displayResults();

        System.out.println("Select a shape based on the dice rolled and enter its size (1, 2, 3, 4): ");
        Scanner scanner = new Scanner(System.in);
        int shapeSize = scanner.nextInt();

        player.drawShape(shapeSize); // Player draws the shape
        player.checkCompletedRowsAndColumns(); // Check if rows/columns are completed and update score

        if (player.getScore() >= 12) {
            gameOver = true; // End game if any player reaches or exceeds 12 points
        }
    }

    private void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % players.length;
    }

    private void declareWinner() {
        Player winner = players[0];
        for (Player player : players) {
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        System.out.println("The winner is Player " + (currentPlayer + 1) + " with " + winner.getScore() + " points!");
    }
}
