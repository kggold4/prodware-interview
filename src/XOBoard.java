public class XOBoard implements board {

    private String[][] mat;
    private static int default_size = 3, n;

    /**
     * default constructor
     * the board size will be 3*3
     */
    public XOBoard() {
        this.n = default_size;
        this.mat = new String[n][n];
    }

    /**
     * constructor
     * by giver size n - board size will be n*n
     */
    public XOBoard(int n) {
        this.n = n;
        this.mat = new String[n][n];
    }

    /**
     * putting a char c on the board on the coordinates i and j
     * if the place is invalid or full return false
     * @param i
     * @param j
     * @param c
     * @return
     */
    @Override
    public boolean put(int i, int j, char c) {
        if(i + 1 > this.n || j + 1 > this.n ) return false;
        else if(this.mat[i][j] != null) return false;
        else if(c != 'X' && c != 'O') return false;
        else {
            this.mat[i][j] = c + "";
            return true;
        }
    }

    /**
     * return the status of the game
     * return X if x is win, O if o is win
     * Draw the is ended and no one win and None if the game do not ended yet
     * @return
     */
    @Override
    public String status() {

        int counterX = 0, counterO = 0;

        // checking horizontal
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.n; j++) {

                if(this.mat[i][j] == null) continue;

                if(this.mat[i][j].equals("X")) counterX++;
                else if(this.mat[i][j].equals("O")) counterO++;

                if(counterX == this.n) return "X";
                else if(counterO == this.n) return "O";
            }
            counterX = 0;
            counterO = 0;
        }

        counterX = 0;
        counterO = 0;

        // checking vertical
        for(int j = 0; j < this.n; j++) {
            for(int i = 0; i < this.n; i++) {
                if(this.mat[i][j] == null) continue;

                if(mat[i][j].equals("X")) counterX++;
                else if(mat[i][j].equals("O")) counterO++;

                if(counterX == this.n) return "X";
                else if(counterO == this.n) return "O";
            }
            counterX = 0;
            counterO = 0;
        }

        counterX = 0;
        counterO = 0;

        // checking diagonal top-left to bottom-right
        for(int i = 0; i < this.n; i++) {
            if(this.mat[i][i] == null) continue;

            if(this.mat[i][i].equals("X")) counterX++;
            else if(this.mat[i][i].equals("O")) counterO++;

            if(counterX == this.n) return "X";
            else if(counterO == this.n) return "O";
        }

        counterX = 0;
        counterO = 0;

        // checking diagonal top-left to bottom-right
        for(int i = 0; i < this.n; i++) {
            if(this.mat[i][this.n - i - 1] == null) continue;

            if(this.mat[i][this.n - i - 1].equals("X")) counterX++;
            else if(this.mat[i][this.n - i - 1].equals("O")) counterO++;

            if(counterX == this.n) return "X";
            else if(counterO == this.n) return "O";
        }

        return "None";
    }

    /**
     * print the board to the console
     */
    @Override
    public void display() {
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.n; j++) {
                if(j == 0) System.out.print("| ");
                if(this.mat[i][j] == null) System.out.print("  | ");
                else System.out.print(this.mat[i][j] + " | ");
            }
            System.out.println();
            for(int k = 0; k < this.n; k++) {
                System.out.print("____");
            }
            System.out.println();
        }
    }
}
