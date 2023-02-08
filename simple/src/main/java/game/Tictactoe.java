package game;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
class Game{
	PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
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
	            p.print(arr[k][j] + "|");
	         }
	         p.println("\n");
		}
	}
}
public class Tictactoe {
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		Game g = new Game();
		int[] pos = {00,01,02,10,11,12,20,21,22};
		g.p.println("Enter the dimention ");
		int d = s.nextInt();
		char [][] arr = new char[d][d];
		char x = 0;
		int i = 0;
		int p1 = 0;
		int p2 =0;
		boolean b =false;
		g.p.println("Player 1 uses Symbol 'X' ");
		g.p.println("Player 2 uses Symbol 'O' ");
	    while(i<9){
				if(i%2==0){
					g.p.println("1st Player's turn!!");
					g.p.println("Enter the position to place");	
					p1 = s.nextInt();
					p2 = pos[p1-1];
					if(arr[p2/10][p2%10]==0) {
					      arr[p2/10][p2%10] = 'X';
                          x = 'X';
					}
					else
						g.p.println("Already placed position Enter anyother position!!!");	
				}
				else {
					g.p.println("2nd Player's turn!!");
					g.p.println("Enter the position to place");	
					p1 = s.nextInt();
					p2 = pos[p1-1];
					if(arr[p2/10][p2%10]==0) {
						arr[p2/10][p2%10] = 'O';
						x = 'O';
					}
					else
						g.p.println("Already placed position Enter anyother position!!!");	
			    }
				if(g.horizontal(x,p2,arr)|| g.vertical(x, p2,arr)) {
				b = true;
				}
				else if((p2/10 == 0 && p2%10 == 0 )||(p2/10 == d-1 && p2%10 == d-1)) {
			    b = g.side(x,p2,arr);
				}
			    else if((p2/10 == 0 && p2%10 == d-1)||(p2/10 == d-1 && p2%10 == 0 )) {
			    b = g.side1(x,p2,arr);
			    }
				if(b) {
					if(x == 'X') {
					g.p.println("!!! Player 1 Wins the Game !!!\n");
					}
					else {
					g.p.println("!!! Player 2 Wins the Game !!!\n");
					}
					g.printArray(arr);
					break;
				}
				i++;
				if(i==9) {
					g.p.println("!!! The Game is TIE !!!\n");
					g.printArray(arr);
				}
	     }
	}
}
