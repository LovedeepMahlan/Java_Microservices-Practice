package corejava;

import java.util.ArrayList;

public class Generics_BackWardComparability {
	/* JDK 18 */
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList();
		al.add("Lovedeep");
		System.out.println(methodone(al));
	}
	public static ArrayList methodone(ArrayList al) {
		al.add(23);
		return al;
	}
}