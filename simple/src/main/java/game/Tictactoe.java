package game;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
class Tac{
	static PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
	boolean horizontal(char c,int x,int y,char[][] arr) {
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
	boolean vertical(char c,int x,int y,char[][] arr) {
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
	boolean side(char c,int x,int y,char[][] arr) {
		if(y==arr.length-1) {
			for(int i=y;i>=0;i--) {
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
	boolean side1(char c,int x,int y,char[][] arr) {
		int j = 1;
		if(y==arr.length-1) {
			for(int i=y-1;i>=0;i--) {
				if(arr[j++][i]!=c) {
					return false;
				}
			}
		}
		else {
			for(int i=x-1;i>=0;i--) {
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
public class Tic {
	static Scanner s = new Scanner(System.in);
	static int u =0;
	static int v =0;
	static int p1 = 0;
	static char x = 0;
	static void check(int i) {
		if(i%2==0){
		    Tac.p.println("1st Player's turn!!");
			x = 'X';
		}
		else {
			Tac.p.println("2nd Player's turn!!");
			x = 'O';
		}
	}
	static void store(int[] pos) {
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
	}
	public static void main(String[] arg) {
		Tac g = new Tac();
		Tac.p.println("Enter the dimention ");
		int d = s.nextInt();
		int [] pos = new int[d*d];
		char [][] arr = new char[d][d];
		int k=0;
		int i = 0;
		boolean b =false;
		for(i=0;i<d;i++) {
			for(int j=0;j<d;j++) {
				pos[k++] = i*10+j;
			}
		}
		Tac.p.println("Player 1 uses Symbol 'X' ");
		Tac.p.println("Player 2 uses Symbol 'O' ");
		i=0;
	    while(i<d*d){
	    	    check(i);
				Tac.p.println("Enter the position to place");	
				store(pos);
				if(arr[u][v]==0) {
					arr[u][v] = x;
				}
				else {
					Tac.p.println("Already placed position Enter anyother position!!!");
					store(pos);
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
					Tac.p.println("!!! Player 1 Wins the Game !!!\n");
					}
					else {
					Tac.p.println("!!! Player 2 Wins the Game !!!\n");
					}
					g.printArray(arr);
					break;
				}
				i++;
				if(i==d*d) {
					Tac.p.println("!!! The Game is TIE !!!\n");
					g.printArray(arr);
				}
	     }
	}
}
