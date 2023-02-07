package game;
import java.util.Scanner;
import java.util.logging.Logger;
class Game{
	Logger l1 = Logger.getLogger("com.api.jar");
	boolean horizontal(char c,int p,char[][] arr) {
		int x = p/10;
		int y = p%10;
		for(int i=0;i<x;i++) {
			if(arr[i][y]!=c) {
				return false;
			}
		}
		for(int j=x+1;j<arr.length;j++) {
			if(arr[j][y]!=c) {
				return false;
			}
		}
		return true;
	}
	boolean vertical(char c,int p,char[][] arr) {
		int x = p/10;
		int y = p%10;
		for(int i=0;i<y;i++) {
			if(arr[x][i]!=c) {
				return false;
			}
		}
		for(int j=y+1;j<arr.length;j++) {
			if(arr[x][j]!=c) {
				return false;
			}
		}
		return true;
	}
	boolean side(char c,int p,char[][] arr) {
		if(p%10==arr.length-1) {
			for(int i=p%10;i>=0;i--) {
				if(arr[i][i]!=c) {
					return false;
				}
			}
		}
		else {
			for(int i=0;i<=arr.length-1;i++) {
				if(arr[i][i]!=c) {
					return false;
				}
			}
		}
		return true;
	}
	boolean side1(char c,int p,char[][] arr) {
		if(p%10==arr.length-1) {
			int j = 1;
			for(int i=p%10-1;i>=0;i--) {
				if(arr[j++][i]!=c) {
					return false;
				}
			}
		}
		else {
			int j = 1;
			for(int i=p/10-1;i>=0;i--) {
				if(arr[i][j++]!=c) {
					return false;
				}
			}
		}
		return true;
	}
	void printArray(char[][] arr) {
		for (int k = 0; k <arr.length; k++) { 
	         for (int j = 0; j < arr[k].length; j++) { 
	            System.out.print(arr[k][j] + "|");
	         }
	         l1.info("\n");
		}
	}
}
public class Tictactoe {
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		Game g = new Game();
		g.l1.info("Enter the dimention ");
		int d = s.nextInt();
		char [][] arr = new char[d][d];
		char x = 0;
		int i = 0;
		int p = 0;
		boolean b =false;
		g.l1.info("Player 1 uses Symbol 'X' ");
		g.l1.info("Player 2 uses Symbol 'O' ");
	    while(i<9){
				if(i%2==0){
					g.l1.info("1st Player turn!!");
					g.l1.info("Enter the position to place");	
					p = s.nextInt();
					if(arr[p/10][p%10]==0) {
					      arr[p/10][p%10] = 'X';
                          x = 'X';
					}
					else
						g.l1.info("Already placed position Enter anyother position!!!");	
				}
				else {
					g.l1.info("2nd Player turn!!");
					g.l1.info("Enter the position to place");	
					p = s.nextInt();
					if(arr[p/10][p%10]==0) {
						arr[p/10][p%10] = 'O';
						x = 'O';
					}
					else
						g.l1.info("Already placed position Enter anyother position!!!");	
			    }
				if(g.horizontal(x,p,arr)|| g.vertical(x, p,arr)){
				b = true;
				}
				else if((p/10 == 0 && p%10 == 0 )||(p/10 == d-1 && p%10 == d-1)){
			        b = g.side(x,p,arr);
				}
			        else if((p/10 == 0 && p%10 == d-1)||(p/10 == d-1 && p%10 == 0 )) {
			        b = g.side1(x,p,arr);
			        }
				if(b) {
					if(x == 'X'){
					g.l1.info("!!! Player 1 Wins the Game !!!\n");
					}
					else {
					g.l1.info("!!! Player 2 Wins the Game !!!\n");
					}
					g.printArray(arr);
					break;
				}
				i++;
				if(i==9) {
					g.l1.info("!!! The Game is TIE !!!\n");
					g.printArray(arr);
				}
	     }
	}
}
