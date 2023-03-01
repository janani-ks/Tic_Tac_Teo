package textfile;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class ReadFile {
	public static void main(String [] args) throws FileNotFoundException {
		PrintStream p=new PrintStream((new FileOutputStream(FileDescriptor.out)));
		final String path = "\\Users\\Janani S\\Documents\\word.txt";
		File f = new File(path);
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		Scanner s = new Scanner(f);
		while(s.hasNextLine()) {
			String w = s.next();
			if(h.containsKey(w)) {
				int c = h.get(w)+1;
				h.put(w, c);
			}
			else
				h.put(w, 1);
		}
		s.close();
		List<Map.Entry<String, Integer>> list = new ArrayList<>(h.entrySet());
		Collections.sort(list , new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				return e1.getValue()-e2.getValue();
			}
		});
		p.println("Keys         Values");
		for (Entry<String, Integer> j: list) {
			p.println(j.getKey()+"     -     "+j.getValue());
	    }
	}
}
