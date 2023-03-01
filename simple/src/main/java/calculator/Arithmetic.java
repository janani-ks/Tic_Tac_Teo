package calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Arithmetic {
	static LinkedList<Float> valuelist = new LinkedList<Float>();
	static LinkedList<Character> operationlist = new LinkedList<Character>();
	static float f = 0;
	static char cal;
	static boolean empty() {
		boolean b = true;
		if(operationlist.isEmpty()) 
			b = false;
		return b;
	}
	static char check(char op) {
		if(op == '+' || op == '-')
			return 1;
		else
			return 2;
	}
	static boolean store1() {
		Scanner scan = new Scanner(System.in);
		try {
		Calculation.p.println("Enter the value ");
		float n = scan.nextFloat();
		f = n;
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	static boolean store2() {
		Scanner scan = new Scanner(System.in);
		try {
		Calculation.p.println("Enter the operation ");
		char o = scan.next().charAt(0);
		if(o == '+' || o == '-' ||o == '/' ||o == '*'|| o=='=') {
			cal = o;
			return true;
		}
		else
			throw new InvalidOperationException("operation is not valid to calculate");
		}
		catch(Exception e) {
			return false;
		}
	}
	public static void main(String[] arg) {
		float ans = 0;
		Calculation obj = new Calculation();
		ArrayList<Calculation> arr = new ArrayList<Calculation>();
		while(1>0) {
			if(store1()) {
				while(1>0){
					if(store2()) {
						arr.add(new Calculation(f,cal));
					    break;
					}
					else {
						continue;
					}
				}
				if( cal == '=')
				     break;
			}
			else 
				continue;
		}
		valuelist.add(arr.get(0).number);
		for(int j=1;j<arr.size();j++) {
			int i = j-1;
			if(arr.get(i).op == '+' || arr.get(i).op == '-'|| arr.get(i).op == '/'|| arr.get(i).op == '*') {
				while(empty() && check(arr.get(i).op) <= check(operationlist.peekLast())) {
					float a = valuelist.peekLast();
					valuelist.removeLast();
					ans = obj.calculate(valuelist.peekLast(),a,operationlist.peekLast());
					valuelist.removeLast();
					operationlist.removeLast();
					valuelist.addLast(ans);
					}
					operationlist.addLast(arr.get(i).op);
					valuelist.addLast(arr.get(j).number);
			}
		}
		while(empty()) {
			float value = valuelist.peekLast();
			valuelist.removeLast();
			ans = obj.calculate(valuelist.peekLast(),value,operationlist.peekLast());
			valuelist.removeLast();
			operationlist.removeLast();
			valuelist.addLast(ans);
		}
		Calculation.p.println("The Total is = "+ans);
	}
}
