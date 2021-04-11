public class XOBoard implements board {

    private char[][] mat;
    private static int default_size = 3;

    /**
     * default constructor
     * the board size will be 3*3
     */
    public XOBoard() {
        this.mat = new char[default_size][default_size];
    }

    /**
     * constructor
     * by given size n and m - the board size will be n*m
     */
    public XOBoard(int n, int m) {
        this.mat = new char[n][m];
    }

    /**
     * constructor
     * by giver size n - board size will be n*n
     */
    public XOBoard(int n) {
        this.mat = new char[n][n];
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
        if(i > this.mat.length || j > this.mat[0].length || this.mat[i][j] != ' ') {
            return false;
        } else {
            this.mat[i][j] = c;
            return true;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String status() {

        int counterX = 0, counterO = 0;

        // checking horizontal
        for(int i = 0; i < this.mat.length; i++) {
            for(int j = 0; j < this.mat[i].length; j++) {

                if(mat[i][j] == 'X') counterX++;
                else if(mat[i][j] == 'O') counterO++;

                if(counterX == this.mat.length) return "X";
                else if(counterO == this.mat.length) return "O";

            }
            counterX = 0;
            counterO = 0;
        }

        counterX = 0;
        counterO = 0;

        // checking vertical
        for(int j = 0; j < this.mat[0].length; j++) {
            for(int i = 0; i < this.mat.length; i++) {

                if(mat[i][j] == 'X') counterX++;
                else if(mat[i][j] == 'O') counterO++;

                if(counterX == this.mat.length) return "X";
                else if(counterO == this.mat.length) return "O";

            }
            counterX = 0;
            counterO = 0;
        }

        counterX = 0;
        counterO = 0;

        // checking diagonal top-left to bottom-right
        for(int i = 0; i < this.mat.length; i++) {
            for(int j = 0; i < this.mat[0].length; j++) {

                if(this.mat[i][j] == 'X' && i == j) counterX++;
                else if(this.mat[i][j] == 'O' && i == j) counterO++;


            }
        }
        // checking diagonal bottom-left to top-right
        return null;
    }

    @Override
    public void display() {
        for(int i = 0; i < this.mat.length; i++) {
            for(int j = 0; j < this.mat[i].length; j++) {
                if(this.mat[i][j] == ' ') System.out.print(' ');
                else System.out.print(this.mat[i][j]);
            }
            System.out.println("\n");
        }
    }
}
