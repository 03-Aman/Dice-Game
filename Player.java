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
        score += points;
    }

    public void drawShape(int shapeSize) {
        System.out.println("Drawing shape of size: " + shapeSize);
        facadeSheet.addShape(shapeSize);
    }

    public void checkCompletedRowsAndColumns() {
        int points = facadeSheet.checkForCompletedRowsOrColumns();
        if (points > 0) {
            addPoints(points);
            System.out.println("You earned " + points + " points!");
        }
    }
}
