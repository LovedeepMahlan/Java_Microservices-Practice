package Enum.com;
enum Result_Type{
	PASS,FAIL,ABSENT
}
class ResultType{
	public static final String PASS="pass";
	public static final String ABSENT="absent";
	public static final String FAIL="fail";
}
public class enumsitch {
	public static void main(String[] args) {
		//by class we can write any string in case
		String result=ResultType.PASS;
		switch(result) {
		case("pass")->System.out.println("pass");
		case("fail")->System.out.println("fail");
		case("absent")->System.out.println("absent");
		case("notig")->System.out.println("notig");
		default->System.out.println("sorry no output");
		}
		//by enum we can pass only enum constant
		Result_Type rs=Result_Type.PASS;
		switch(rs) {
		case PASS->System.out.println("Pass");
		case FAIL->System.out.println("fail");
		case ABSENT->System.out.println("absent");
		default->System.out.println("sorry no output");
		}
	}


}
