public class FacadeSheet {
    private char[][] grid;

    public FacadeSheet() {
        this.grid = new char[6][6]; // 6x6 grid, adjust size as needed
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' '; // Initialize grid with empty spaces
            }
        }
    }

    public void addShape(int shapeSize) {
        // For simplicity, add a shape starting from the first empty position
        // Example: Add the shape vertically in column 0
        for (int i = 0; i < shapeSize; i++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][0] == ' ') {
                    grid[row][0] = 'X'; // Mark grid with 'X' for simplicity
                    break; // Move to next row for the next part of the shape
                }
            }
        }
        displayGrid(); // Display the grid after adding the shape
    }

    public int checkForCompletedRowsOrColumns() {
        int points = 0;

        // Check completed rows
        for (int i = 0; i < grid.length; i++) {
            boolean rowComplete = true;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') { // If any cell in the row is empty, it's not complete
                    rowComplete = false;
                    break;
                }
            }
            if (rowComplete) {
                points += 1; // Award 1 point for a completed row
                System.out.println("Row " + (i + 1) + " is completed.");
            }
        }

        // Check completed columns
        for (int i = 0; i < grid[0].length; i++) {
            boolean colComplete = true;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == ' ') { // If any cell in the column is empty, it's not complete
                    colComplete = false;
                    break;
                }
            }
            if (colComplete) {
                points += 2; // Award 2 points for a completed column
                System.out.println("Column " + (i + 1) + " is completed.");
            }
        }

        return points; // Return the points earned from completed rows/columns
    }

    public void displayGrid() {
        System.out.println("Current Grid:");
        for (char[] row : grid) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
