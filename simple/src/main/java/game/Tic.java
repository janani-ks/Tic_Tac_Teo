package game;
import java.util.Scanner;

public class Tic {
	static Tac obj = new Tac();
	static int hindex =0;
	static int vindex =0;
	static char turn = 0;
	static  boolean b =false;
	static void check(int i) {
		if(i%2==0){
		    Tac.p.println("1st Player's turn!!");
			turn = 'X';
		}
		else {
			Tac.p.println("2nd Player's turn!!");
			turn = 'O';
		}
	}
	static boolean store(int[] pos) {
		Scanner scan = new Scanner(System.in);
		try {
		int p1 = scan.nextInt();
		if(pos[p1-1] <=9) {
			hindex = 0;
			vindex = pos[p1-1];
		}
		else
		{
			hindex = pos[p1-1]/10;
			vindex = pos[p1-1]%10;
		}
		}
		catch(Exception e){
			Tac.p.println("Enter the correct position:");
			return false;
		}
		return true;
	}
	static boolean check1(int d,char[][] arr) {
		    if(obj.horizontal(turn,hindex,vindex,arr)|| obj.vertical(turn, hindex,vindex,arr)) {
			return true;
			}
			else if((hindex == vindex )||(hindex+vindex == (d-1) )){
		    if(obj.side(turn,hindex,arr)&& (hindex==vindex)) {
		    	return true;
		    }
		    else if(obj.side1(turn,hindex,arr)) {
		    	b = true;
		    	return true;
		    }
			}
		    return false;
	}
	public static void main(String[] arg) {
		Tac.p.println("Enter the dimention for TIC-TAC-TEO Game !!");
		Scanner scan = new Scanner(System.in);
		int dimention = 0;
		int k = 0;
		int ite = 0;
		try {
		dimention = scan.nextInt();
		}
		catch(Exception e) {
			main(null);
		}
		Tac.p.println("         GAME STARTED.....HAVE FUN !!!\n");
		int [] pos = new int[dimention*dimention];
		char [][] arr = new char[dimention][dimention];
		for(ite=0;ite<dimention;ite++) {
			for(int j=0;j<dimention;j++) {
				pos[k++] = ite*10+j;
			}
		}
		
		Tac.p.println("Player 1 uses Symbol = 'X' ");
		Tac.p.println("Player 2 uses Symbol = 'O' \n");
		ite=0;
	    while(ite<dimention*dimention){
	    	    check(ite);
				Tac.p.println("Enter the position like 1,2,3...");	
				boolean m = store(pos);
				if(m) {
				if(arr[hindex][vindex]==0) {
					arr[hindex][vindex] = turn;
				}
				else {
					Tac.p.println("Already placed position Enter anyother position !!!");
					m = store(pos);
					if(m) {
					arr[hindex][vindex] = turn;
					}
					else {
						continue;
					}
				}
				}
				else
				{
					continue;
				}
				b = check1(dimention,arr);
				obj.printArray(arr);
				if(b) {
					if(turn == 'X') {
					Tac.p.println("!!! Player 1 Wins the Game !!!\n");
					}
					else {
					Tac.p.println("!!! Player 2 Wins the Game !!!\n");
					}
					break;
				}
				ite++;
				if(ite==dimention*dimention) {
					Tac.p.println("!!! The Game is TIE !!!\n");
				}
	     }
	     Tac.p.println("-----------THANKS FOR PLAYING-----------");
		}
	}
