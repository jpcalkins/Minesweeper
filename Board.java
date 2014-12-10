import java.util.*;
import java.io.*;

public class Board{
	public static int win = 0;
	public static int lose = 0;
	
	public static void main(String[] args){

		int[][] board = fillBombs();
		Scanner scan = new Scanner(System.in);
		printBoard(board);
		
		//This loop is for playing the game in the command line
		while( win == 0 && lose == 0){
			System.out.println("Row: ");
			int r = scan.nextInt();
			System.out.println("Col: ");
			int c = scan.nextInt();
			move(board, r, c);
			printBoard(board);
		}
		if(lose == 1){
			System.out.println("Fail!!!");
		}
		
	}
	//Takes care of randomly placing bombs
	public static int[][] fillBombs(){
		int[][] board = new int[13][13];
		for(int i=1; i<=10; i++){
			for(int j=1; j<=10; j++){
				board[i][j] = 0;
			}
		}
		for (int b=0; b<11; b++){
			int row = ((int)(Math.random() * 10) + 1);
			int col = ((int)(Math.random() * 10) + 1);
			board[row][col] = -1;
		}
		return fillHints(board);
	}

	//Prints the 2D array board in the command line for testing
	public static void printBoard(int[][] board){
		int[][] print = board;
		for(int i=1; i<12; i++){
			for (int j=1; j<12; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	//Handles the behavior of what a square represents
	public static String move(int[][] board, int r, int c){
		if(board[r][c] == -1){
			return "Bomb!";
		} else{
			return Integer.toString(board[r][c]);
		}
	}
	//Fills the board with the numbers to represent adjacent bombs
	public static int[][] fillHints(int[][] board){
		int count = 0;
		for (int r=1; r<=11; r++){
			for (int c=1; c<=11; c++){
				if(board[r][c] == -1) c++;

				for(int j=-1; j<=1; j++){
					for(int k=-1; k<=1; k++){
						if(board[r+j][c+k] == -1){
							count++;
						}	
					}
				}
				board[r][c] = count;
				count = 0;
			}
		}
		//printBoard(board);
		return board;
	}

}