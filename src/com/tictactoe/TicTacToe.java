package com.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
       board = new char[3][3];
        currentPlayer = 'X';
        intializeboard();
    }

    private void intializeboard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] =' ';
            }
        }
    }

    private void printBoard() {
        System.out.println("-----------");
        for (int row = 0; row < 3; row++) {
            System.out.print("|");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col] + " |");
            }
            System.out.println();
        }
        System.out.println("-----------");

    }

    private boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Invalid move! Please try again");
            return false;
        }
        board[row][col] = currentPlayer;
        return true;

    }

    private boolean checkForWin() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
                return true;
            }
            if (board[0][row] == currentPlayer && board[1][row] == currentPlayer && board[2][row+1] == currentPlayer) {
                return true;
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        if (board[2][0] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        return false;
    }
    private boolean checkForDraw(){
        for(int row=0;row<3;row++){
            for(int col=0;col<3;col++){
                if(board[row][col]==' '){
                    return false;
                }
            }
        }
        return true;

    }
    private void switchPlayer(){
        currentPlayer=(currentPlayer=='X')?'O':'X';
    }
   public void Play(){
        Scanner scanner=new Scanner(System.in);
        System.out.println(" Welcome to TicTacToe Game");
        do{
        printBoard();
        System.out.println("plyer"+currentPlayer+" 's turn");
        System.out.println("Enter only 0,1 and 2 for Row and Coloumn");
        System.out.print("Enter ROW NO : ");
        int row=scanner.nextInt();
        System.out.print("Enter COLOUMN NO: ");
        int col=scanner.nextInt();
        if(makeMove(row,col)){
            if(checkForWin()){
                printBoard();
                System.out.println("player with "+currentPlayer+"  wins the game");
                break;
                }
            else if(checkForDraw()){
                System.out.println("its a draw ");
                break;
            }
            else {
                switchPlayer();
            }
            }
        }
        while(true);
    scanner.close();

    }

}
