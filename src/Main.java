import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner getSize = new Scanner(System.in);
        System.out.println("Please enter the size of the board:");
        int size = getSize.nextInt();

        XOBoard board = new XOBoard(size);
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        String status = "None";
        while(!status.equals("X") && !status.equals("O") && !status.equals("Draw")) {
            status = input(board, scanner1, scanner2);
        }

        scanner1.close();
        scanner2.close();

        String output = "";
        if(status == "X") {
            output = "X is win";
        } else if(status == "O") {
            output = "O is win";
        } else if(status == "Draw") {
            output = "draw";
        }

        System.out.println("Game result: " + output);

    }

    public static String input(XOBoard board, Scanner scanner1, Scanner scanner2) {
        int i , j;
        System.out.println("Enter index i:");
        i = scanner1.nextInt();

        System.out.println("Enter index j:");
        j = scanner1.nextInt();

        System.out.println("Enter 'X' or 'O' char:");
        char c = scanner2.next().charAt(0);

        boolean b = board.put(i, j, c);
        if(!b) {
            System.out.println("Invalid place or character");
            input(board, scanner1, scanner2);
        }
        board.display();
        return board.status();
    }
}
