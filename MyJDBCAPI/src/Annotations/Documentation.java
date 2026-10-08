package Annotations;

import java.lang.annotation.Documented;

@Documented
@interface Persistable{
	
}
@Persistable
public class Documentation {
	private int sid;
	private String name;
	public Documentation(int sid, String name) {
		// TODO Auto-generated constructor stub
		this.sid=sid;
		this.name=name;
	}
	public void dispdetail() {
		System.out.println(sid+name);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Documentation dc=new Documentation(12, "Lovedeep");
		dc.dispdetail();
	}

}
