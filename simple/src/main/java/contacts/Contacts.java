package contacts;
import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {
	static Scanner s = new Scanner(System.in);
	static Scanner s1 = new Scanner(System.in);
	static Scanner s2 = new Scanner(System.in);
	static ArrayList<StoreAndManage> list = new ArrayList<StoreAndManage>();
	static String name;
	static long number;
	static String email;
	static int count=1;
	static int c;
	static boolean b;
	static int choice;
	static long number1;
	static void add() {
		StoreAndManage.p.println("Enter Person "+count+" Details!!");
		StoreAndManage.p.print("Enter Name = ");
		name = s.nextLine();
		while(numstore()==false) ;
		StoreAndManage.p.print("Enter Email Address = ");
		email = s2.nextLine();	
		list.add(new StoreAndManage(name,number1,email));
		count++;
	}
    static StoreAndManage searchByName(String n) {
    	c =0;
    	b = true;
    	for(StoreAndManage i: list) {
			if(i.name.equals(n)) {
				b = false;
				return i;
			}
			c++;
		}
    	return null;
    }
    static StoreAndManage searchByNumber(long n) {
    	c =0;
    	b = true;
    	for(StoreAndManage i: list) {
			if(i.number == n) {
				b = false;
				return i;
			}
			c++;
		}
    	return null;
    }
    static StoreAndManage searchByEmail(String n) {
    	c =0;
    	b = true;
    	for(StoreAndManage i: list) {
			if(i.email.equals(n)) {
				b = false;
				return i;
			}
			c++;
		}
    	return null;
    }
    static boolean numstore() {
    	Scanner scan = new Scanner(System.in);
    	try {
        StoreAndManage.p.print("Enter Contact Number = ");
    	long n1 = scan.nextLong();
    	if(n1<=9999999999l && n1>999999999) {
    		number1 = n1;
        	return true;
    	}
    	else {
    	return false;
    	}
    	}
    	catch(Exception e) {
    	return false;
    	}
    }
    static void store() {
    	StoreAndManage.p.println("Enter the Choice like 1,2,3..7 What You Want !!\n1. Add Details \n2. Delete by Name \n3. Delete By Number\n4. Delete By Email\n5. Search By Name\n6. Search By Number\n7. Search By Email" );
		choice = s1.nextInt();
		StoreAndManage k = null;
		switch(choice) {
		      case 1:
		    	  add();
		    	  break;
		      case 2:
		    	  StoreAndManage.p.println("Enter the Name");
		    	  String n = s.nextLine();
		    	  b = true;
		  		  for(int i=0;i<list.size();i++) {
		    			if(list.get(i).name.equals(n)) {
		    				list.remove(i);
		    				b = false;
		    			}
		    	  }
		    	  break;
		      case 3:
		    	  while(numstore()==false) ;
		    	  b = true;
		      	  for(int i=0;i<list.size();i++) {
		    			if(list.get(i).number == number1) {
		    				list.remove(i);
		    				b = false;
		    			}
		    	  }
		      	  break;
		      case 4:
		    	  StoreAndManage.p.println("Enter the Email Address");
		    	  String n3 = s2.nextLine();
		    	  b = true;
		      	  for(int i=0;i<list.size();i++) {
		    			if(list.get(i).email.equals(n3)) {
		    				list.remove(i);
		    				b = false;
		    			}
		      	  }
		    	  break;
		      case 5:
		    	  StoreAndManage.p.println("Enter the Name");
		    	  String n4 = s.nextLine();
		    	  k = searchByName(n4);
		    	  break;
		      case 6:
		    	  while(numstore()==false) ;
		    	  k = searchByNumber(number1);
		    	  break;
		      case 7:
		    	  StoreAndManage.p.println("Enter the Email Adress");
		    	  String n6 = s2.nextLine();
		    	  k = searchByEmail(n6);
		    	  break;
		      default:
		    	  StoreAndManage.p.println("Enter the Correct Choice !!");
		    	  break;
		    	 
		}
		if(b && (choice>=2 &&choice<=7)) {
	      	  StoreAndManage.p.println("There is no Details of the person");
	    }
		else if(b==false && choice>=5 &&choice<=7) {
			StoreAndManage.p.println("The index of the searched person is "+c);
			StoreAndManage.p.println("Name = "+k.name);
			StoreAndManage.p.println("Number = "+k.number);
			StoreAndManage.p.println("Email Address = "+k.email);
		}
    }
	public static void main(String[] arg) {
		add();
		char str;
		do{
			store();
			StoreAndManage.p.println("Do you want to do anyother operation Y/N (or) y/n");
			str = s1.next().charAt(0);
		}while(str == 'Y'||str == 'y');
		if(list.isEmpty()) {
			StoreAndManage.p.println("There is no Details, List is empty");
		}
		else {
		int j=1;
		for(StoreAndManage i:list) {
			StoreAndManage.p.println("Person "+(j++)+" Details !!");
			StoreAndManage.p.println("Name = "+i.name);
			StoreAndManage.p.println("Number = "+i.number);
			StoreAndManage.p.println("Email Address = "+i.email);
			StoreAndManage.p.println("\n");
		}
		}
		
	}
}
