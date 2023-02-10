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
	boolean side1(char c,int x,int y,char[][] arr) {
			for(int i=0;i<x;i++) {
				if(arr[i][Math.abs(arr.length-i-1)]!=c) {
					return false;
				}
			}
			for(int i=x+1;i<arr.length;i++) {
				if(arr[i][Math.abs(arr.length-i-1)]!=c) {
					return false;
				}
			}
		return true;
	}
	boolean side(char c,int x,int y,char[][] arr) {
			for(int i=0;i<x;i++) {
				if(arr[i][i]!=c) {
					return false;
				}
			}
			for(int i=x+1;i<arr.length;i++) {
				if(arr[i][i]!=c) {
					return false;
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
	static Tac g = new Tac();
	static int u =0;
	static int v =0;
	static int p1 = 0;
	static char x = 0;
	static  boolean b =false;
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
	static boolean check1(int d,char[][] arr) {
		    if(g.horizontal(x,u,v,arr)|| g.vertical(x, u,v,arr)) {
			return true;
			}
			else if((u == v )||(u+v == (d-1) )){
		    if(g.side(x,u,v,arr) && u == v) {
		    	return true;
		    }
		    else if(g.side1(x,u,v,arr)) {
		    	return true;
		    }
			}
		    return false;
	}
	public static void main(String[] arg) {
		Tac.p.println("Enter the dimention for TIC-TAC-TEO Game !!");
		int d = s.nextInt();
		Tac.p.println("         GAME STARTED.....HAVE FUN !!!\n");
		int [] pos = new int[d*d];
		char [][] arr = new char[d][d];
		int k=0;
		int i = 0;
		for(i=0;i<d;i++) {
			for(int j=0;j<d;j++) {
				pos[k++] = i*10+j;
			}
		}
		Tac.p.println("Player 1 uses Symbol = 'X' ");
		Tac.p.println("Player 2 uses Symbol = 'O' \n");
		i=0;
	    while(i<d*d){
	    	    check(i);
				Tac.p.println("Enter the position like 1,2,3...");	
				store(pos);
				if(arr[u][v]==0) {
					arr[u][v] = x;
				}
				else {
					Tac.p.println("Already placed position Enter anyother position !!!");
					store(pos);
					arr[u][v] = x;
				}
				b = check1(d,arr);
				g.printArray(arr);
				if(b) {
					if(x == 'X') {
					Tac.p.println("!!! Player 1 Wins the Game !!!\n");
					}
					else {
					Tac.p.println("!!! Player 2 Wins the Game !!!\n");
					}
					break;
				}
				i++;
				if(i==d*d) {
					Tac.p.println("!!! The Game is TIE !!!\n");
				}
	     }
	     Tac.p.println("-----------THANKS FOR PLAYING-----------");
	}
}
