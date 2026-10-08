package Enum.com;
enum Student{
	PASS,FAIL,ABSENT
}
class Stud{
	public static final String PASS="Pass";
	public static final String FAIL="fail";
	public static final String ABSENT="absent";

}
public class Class_Enum {
	public static void main(String[] args) {
		System.out.println(Stud.PASS);
		System.out.println(Stud.FAIL);
		System.out.println(Stud.ABSENT);
		System.out.println(Student.PASS);
		System.err.println(Student.FAIL);
		System.out.println(Student.ABSENT);
	}
}
