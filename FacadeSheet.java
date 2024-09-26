public class FacadeSheet {
    private char[][] grid;

    public FacadeSheet() {
        this.grid = new char[6][6]; // Example size, can be changed
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void addShape(int shapeSize) {
        // Add shape to the facade following the drawing rules
        // For simplicity, just fill a column or row
        for (int i = 0; i < shapeSize; i++) {
            grid[i][0] = 'X'; // Simplified example: add to column 0
        }
        displayGrid();
    }

    public int checkForCompletedRowsOrColumns() {
        int points = 0;

        // Check rows
        for (int i = 0; i < grid.length; i++) {
            boolean rowComplete = true;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    rowComplete = false;
                    break;
                }
            }
            if (rowComplete) {
                points += 1; // 1 point for completing a row
            }
        }

        // Check columns
        for (int i = 0; i < grid[0].length; i++) {
            boolean colComplete = true;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == ' ') {
                    colComplete = false;
                    break;
                }
            }
            if (colComplete) {
                points += 2; // 2 points for completing a column
            }
        }

        return points;
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
