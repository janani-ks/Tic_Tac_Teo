package game;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
class Game{
	PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
	boolean horizontal(char c,int u,int v,char[][] arr) {
		int x = u;
		int y = v;
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
	boolean vertical(char c,int u,int v,char[][] arr) {
		int x = u;
		int y = v;
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
	boolean side(char c,int u,int v,char[][] arr) {
		if(v==arr.length-1) {
			for(int i=v;i>=0;i--) {
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
	boolean side1(char c,int u,int v,char[][] arr) {
		if(v==arr.length-1) {
			int j = 1;
			for(int i=v-1;i>=0;i--) {
				if(arr[j++][i]!=c) {
					return false;
				}
			}
		}
		else {
			int j = 1;
			for(int i=u-1;i>=0;i--) {
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
		g.p.println("Enter the dimention ");
		int d = s.nextInt();
		int [] pos = new int[d*d];
		int k=0;
		for(int i=0;i<d;i++) {
			for(int j=0;j<d;j++) {
				pos[k++] = i*10+j;
			}
		}
		char [][] arr = new char[d][d];
		char x = 0;
		int i = 0;
		int p1 = 0;
		int u =0;
		int v =0;
		boolean b =false;
		g.p.println("Player 1 uses Symbol 'X' ");
		g.p.println("Player 2 uses Symbol 'O' ");
	    while(i<d*d){
				if(i%2==0){
					g.p.println("1st Player's turn!!");
					g.p.println("Enter the position to place");	
					p1 = s.nextInt();
					if(pos[p1-1] <=9) {
						u = 0;
						v = pos[p1-1];
					}
					else
					{
						u = pos[p1-1]/10;
						v = pos[p1-1]%10;
					}
					if(arr[u][v]==0) {
					      arr[u][v] = 'X';
                          x = 'X';
					}
					else
						g.p.println("Already placed position Enter anyother position!!!");	
				}
				else {
					g.p.println("2nd Player's turn!!");
					g.p.println("Enter the position to place");	
					p1 = s.nextInt();
					if(pos[p1-1]<=9) {
						u = 0;
						v = pos[p1-1];
					}
					else
					{
						u = pos[p1-1]/10;
						v = pos[p1-1]%10;
					}
					if(arr[u][v]==0) {
						arr[u][v] = 'O';
						x = 'O';
					}
					else
						g.p.println("Already placed position Enter anyother position!!!");	
			    }
				if(g.horizontal(x,u,v,arr)|| g.vertical(x, u,v,arr)) {
				b = true;
				}
				else if((u == 0 && v == 0 )||(u == d-1 && v == d-1)) {
			    b = g.side(x,u,v,arr);
				}
			    else if((u == 0 && v == d-1)||(u == d-1 && v == 0 )) {
			    b = g.side1(x,u,v,arr);
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
				if(i==d*d) {
					g.p.println("!!! The Game is TIE !!!\n");
					g.printArray(arr);
				}
	     }
	}
}
