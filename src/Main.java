import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        XOBoard board = new XOBoard();
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        String status = "None";
        while(!status.equals("X") && !status.equals("O") && !status.equals("Draw")) {
            status = input(board, scanner1, scanner2);
            System.out.println("current status is: " + status);
            if(status.equals("X")) System.out.println("status confirm as X");
        }

        scanner1.close();
        scanner2.close();


        System.out.println("Done!");
        System.out.println("Status is: " + board.status());

    }

    public static String input(XOBoard board, Scanner scanner1, Scanner scanner2) {
        int i , j;
        System.out.println("enter index i:");
        i = scanner1.nextInt();

        System.out.println("enter index j:");
        j = scanner1.nextInt();

        System.out.println("enter 'X' or 'O' char:");
        char c = scanner2.next().charAt(0);

        boolean b = board.put(i, j, c);
        if(!b) {
            System.out.println("invalid place or character");
            input(board, scanner1, scanner2);
        }
        board.display();
        return board.status();
    }
}
