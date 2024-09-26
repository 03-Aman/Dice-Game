import java.util.Random;

public class Dice {
    private String[] faces = {"Red", "Blue", "Green", "Yellow", "Purple", "White"};
    private String[] results;

    public Dice() {
        this.results = new String[5];
    }

    public void roll() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            results[i] = faces[rand.nextInt(faces.length)];
        }
    }

    public void displayResults() {
        System.out.println("Dice results:");
        for (String result : results) {
            System.out.print(result + " ");
        }
        System.out.println();
    }

    public String[] getResults() {
        return results;
    }
}
