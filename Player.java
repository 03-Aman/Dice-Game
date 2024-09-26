public class Player {
    private int score;
    private FacadeSheet facadeSheet;
    private AbilityTrack abilityTrack;

    public Player() {
        this.score = 0;
        this.facadeSheet = new FacadeSheet();
        this.abilityTrack = new AbilityTrack();
    }

    public int getScore() {
        return score;
    }

    public void addPoints(int points) {
        score += points; // Add points to the player's total score
        System.out.println("Player scored " + points + " points! Total: " + score);
    }

    public void drawShape(int shapeSize) {
        System.out.println("Drawing shape of size: " + shapeSize);
        facadeSheet.addShape(shapeSize); // Add the shape to the grid
    }

    public void checkCompletedRowsAndColumns() {
        int points = facadeSheet.checkForCompletedRowsOrColumns(); // Check if any rows or columns are completed
        if (points > 0) {
            addPoints(points); // Add points to the player's score
        }
    }
}
