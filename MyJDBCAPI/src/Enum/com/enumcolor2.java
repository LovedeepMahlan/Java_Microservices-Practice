package Enum.com;
enum ecolor2{
	Blue,Red{
	public void info() {
		System.out.println("Red is Signature of Danger");
	}
	},Green;
	public void info() {
		System.out.println("Universal Colour");
	}
}
public class enumcolor2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ecolor2[] ec=ecolor2.values();
		for(ecolor2 ecol:ec) {
			ecol.info();
		}
	}

}
