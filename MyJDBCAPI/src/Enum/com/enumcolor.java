package Enum.com;

enum ecolor {
	RED,GREEN,BLUE;
	public void info() {
		System.out.println("All there are universal color");
	}
}
 public class enumcolor{
	public static void main(String[] args) {
		ecolor[] color=ecolor.values();
		for(ecolor ecol:color) {
			ecol.info();
		}
	}
}
