package game;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

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