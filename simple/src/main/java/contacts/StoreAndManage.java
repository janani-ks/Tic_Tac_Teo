package contacts;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

class StoreAndManage{
	static PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
	String name;
	long number;
	String email;
	StoreAndManage(String n,long n1,String e){
		this.name = n;
		this.number = n1;
		this.email = e;
	}
}