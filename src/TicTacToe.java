import java.util.Scanner;


public class TicTacToe {

	static String[][] board = {{" "," "," "},{" "," "," "},{" "," "," "}};
	static int moveCount = 0;
	static int player = 1;
	private static Scanner in;
	
	public static void main(String[]args){
		in = new Scanner(System.in);
		
		while(!checkWin()){
			printBoard();
			moveCount++;
			if(player == 1){
				System.out.print("Player 1: ");
				int input = in.nextInt();
				if(placeX(input)){
					player = 2;
					continue;
				}
				else {
					System.out.println("Already something there");
				}
			}
			else if(player == 2){
				System.out.print("Player 2: ");
				int input = in.nextInt();
				if(placeO(input)){
					player = 1;
					continue;
				}
				else {
					System.out.println("Already something there");
				}
			}
			
		}
	}
	
	public static void printBoard(){
		System.out.print(board[0][0]);
		System.out.print(" |");
		System.out.print(board[1][0]);
		System.out.print(" |");
		System.out.println(board[2][0]);
		System.out.println("--------");
		System.out.print(board[0][1]);
		System.out.print(" |");
		System.out.print(board[1][1]);
		System.out.print(" |");
		System.out.println(board[2][1]);
		System.out.println("--------");
		System.out.print(board[0][2]);
		System.out.print(" |");
		System.out.print(board[1][2]);
		System.out.print(" |");
		System.out.println(board[2][2]);
		
	}
	
	public static boolean checkWin(){
		if(moveCount >=5){
			return false;
		}
		else {
			return false;
		}
	}

	public static boolean placeX(int in){
		if(in > 9 || in < 1) {
			return false;
		}
		if(in == 1){
			if(board[0][0].equals(" ")){
				board[0][0] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 2){
			if(board[1][0].equals(" ")){
				board[1][0] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 3){
			if(board[2][0].equals(" ")){
				board[2][0] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 4){
			if(board[0][1].equals(" ")){
				board[0][1] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 5){
			if(board[1][1].equals(" ")){
				board[1][1] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 6){
			if(board[2][1].equals(" ")){
				board[2][1] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 7){
			if(board[0][2].equals(" ")){
				board[0][2] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 8){
			if(board[1][2].equals(" ")){
				board[1][2] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 9){
			if(board[2][2].equals(" ")){
				board[2][2] = "X";
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean placeO(int in){
		if(in > 9 || in < 1) {
			return false;
		}
		if(in == 1){
			if(board[0][0].equals(" ")){
				board[0][0] = "0";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 2){
			if(board[1][0].equals(" ")){
				board[1][0] = "O";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 3){
			if(board[2][0].equals(" ")){
				board[2][0] = "O";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 4){
			if(board[0][1].equals(" ")){
				board[0][1] = "O";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 5){
			if(board[1][1].equals(" ")){
				board[1][1] = "O";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 6){
			if(board[2][1].equals(" ")){
				board[2][1] = "O";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 7){
			if(board[0][2].equals(" ")){
				board[0][2] = "O";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 8){
			if(board[1][2].equals(" ")){
				board[1][2] = "O";
				return true;
			}
			else {
				return false;
			}
		}
		if(in == 9){
			if(board[2][2].equals(" ")){
				board[2][2] = "O";
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
}

