package calculator;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

class Calculation{
	static PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
	float number;
	char op;
	Calculation(){
		p.println("Enter the values and operations !!!");
	}
    Calculation(float n,char o){
    	this.number = n;
    	this.op = o;
    }
    float calculate(float a,float b,char c){
    	switch(c) {
    	case '+':
    		return a+b;
    	case '-':
    		return a-b;
    	case '*':
    		return a*b;
    	case '/':
    		return a/b;
    	default:
    		return 0;
    	}
    }
}