
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author minh
 */
public class caro {
   public static String[][] board;
    private static boolean player = true;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        caro.initBoard(26);
        caro.drawBoard();
        
        String location = null;
        while (true) {    
            System.out.print("Player " + (player? "1" : "2") + ": ");
            location = sc.nextLine(); // A,1 | B,1 | a,1
            switch (location) {
                case "quit":
                    System.exit(0);
                    break;
                default:
                    try {
                        String[] _loca = location.split(",");
                        caro.play(_loca[0].toUpperCase().toCharArray()[0], Integer.parseInt(_loca[1]));
                    } catch (Exception e) {
                        System.out.println("Sai định dạng!");
                    }
                    break;
            }
        }
    }
    public static void drawBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("=======================================================");
    }
    
    public static void initBoard(int grid){
        int m = grid, n = m*2 + 2;
        caro.board = new String[m + 1][n];
        int _char = 65;
        for (int i = 0; i < m + 1; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j % 2 == 0 && j >= 2) {
                        count = count == 10 ? 0 : count;
                        board[i][j] = count+"";
                        count++;
                    } else {
                        board[i][j] = " ";
                    }
                } else {
                    if (j == 0 && i > 0) {
                        board[i][j] = (char)_char+"";
                        _char++;
                    } else {
                        if (j % 2 != 0)
                            board[i][j] = "|";
                        else 
                            board[i][j] = " ";
                    }
                }
            }
        }
    }
    
    public static void play(char row, int col) {
        int _row = (int)row - 65 + 1;
        int _col = col * 2;
        if (board[_row][_col] == " ") {
            board[_row][_col] = player? "X" : "O";
            caro.drawBoard();
            if (youWin(_row, _col, player? "X" : "O")) {
                System.out.println("Player " + (player?"1": "2") + " win!");
            }
            player = !player;
        } else {
            System.out.println("Không hợp lệ!");
        }
    }
    public static boolean youWin(int x, int y, String key){
         return caro.checkY(x, y, key) || caro.checkX(x, y, key) || caro.checkDiagonal(x, y, key);
    }
    //check doc
    public static boolean checkY(int x, int y, String key) {
        int countUp = 0;
        int countLower = 0;
        // Duyệt lên trên
        for (int i = x; i > 0; i--) {
            if (!(board[i][y] == key)) {
                break;
            }
            countUp++;
        }
        
        for (int i = x + 1; i < board.length; i++) {
            if (!(board[i][y] == key)) {
                break;
            }
            countLower++;
        }
        return countUp + countLower == 5;
    }
    //check ngang
    public static boolean checkX(int x, int y, String key){
        int countLeft = 0;
        int countRight = 0;
        // Duyệt trái
        for (int i = y; i > 1; i -= 2) {
            if (!(board[x][i] == key)) {
                break;
            }
            countLeft++;
        }
        
        for (int i = y + 2; i < board[0].length; i += 2) {
            if (!(board[i][y] == key)) {
                break;
            }
            countRight++;
        }
        return countLeft + countRight == 5;
    }
    //check cheo
    public static boolean checkDiagonal(int x, int y, String key){
        int DiagonalUp = 0;
        int DiagonalDow = 0;
        
       for (int i = x; i > 0; i++) {
            if (!(board[i + 1][y + 1] == key)) {
                break;
            }
            DiagonalUp++;
        }
        for (int i = x; i > 0; i++) {
            if (!(board[i + 1][y - 1] == key)) {
                break;
            }
            DiagonalDow++;
        }

        return DiagonalUp + DiagonalDow == 5;
        
    }
    
    
     
}
