import java.util.Scanner;


class Main {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int a = 0; a < 3; a++) {
            for(int b = 0; b < 3; b++) {
                board[a][b] = ' ';
            }
        }
        int moves = 0;
        boolean gone = false;
        printBoard(board);
        continueGame(board, gone, moves);
    }

    public static void printBoard(char[][] board) {
        System.out.println("---------");
        for(int a = 0; a < 3; a++) {
            System.out.print("| ");
            for(int b = 0; b < 3; b++) {
                System.out.print(board[a][b] + " "); 

            }
            System.out.println("|");
        }
        System.out.println("---------");

    }

    public static void checkWinner(char[][] board, boolean gone, int moves) {
        if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && (board[0][0] == 'X' || board[0][0] == 'O')){
            chooseWinner(board[0][0]);
            return;
        } else if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && (board[1][0] == 'X' || board[1][0] == 'O')) {
            chooseWinner(board[1][0]);
            return;
        } else if(board[2][0] == board[2][1] && board[2][0] == board[2][2] && (board[2][0] == 'X' || board[2][0] == 'O')) {
            chooseWinner(board[2][0]);
            return;
        } else if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            chooseWinner(board[0][0]);
            return;
        } else if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && (board[0][1] == 'X' || board[0][1] == 'O')) { 
            chooseWinner(board[0][1]);
            return;
        } else if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && (board[0][2] == 'X' || board[0][2] == 'O')) { 
            chooseWinner(board[0][2]);
            return;
        } else if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && (board[0][0] == 'X' || board[0][0] == 'O')) {
            chooseWinner(board[0][0]);
            return;
        } else if(board[2][0] == board[1][1] && board[2][0] == board[0][2] && (board[2][0] == 'X' || board[2][0] == 'O')) { 
            chooseWinner(board[2][0]);
            return;
        } else if(moves == 9){
            System.out.println("Draw");
            return;
        }
        continueGame(board, gone, moves);
    }

    public static void chooseWinner(char a) {
        if(a == 'X') {
            System.out.println("X wins");
        } else {
            System.out.println("O wins");
        }
    }
    
    public static void continueGame(char[][] board, boolean gone, int moves) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        try {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (x > 2 || x < 0 || y > 2 || y < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
                continueGame(board, gone, moves);
                return;
            } 
            if (board[x][y] == 'X' || board[x][y] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continueGame(board, gone, moves);
                return;
            }  
            if (gone) {
                board[x][y] = 'O';
                gone = false;   
            } else {
                board[x][y] = 'X';
                gone = true;
            }
            System.out.println(board[x][y]);
            moves++;
            printBoard(board);
            checkWinner(board, gone, moves);
            return;
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            continueGame(board, gone, moves);
            return;
        }
    }
}
