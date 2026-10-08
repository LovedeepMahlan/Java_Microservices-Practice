package Enum.com;
enum Result{
	PASS,FAIL,ABSENT;
	public void methodone() {
		System.out.println("Type");
	}
	public static void main(String[] args) {
		System.out.println("Inside an enum");
	}
}
public class ResultType2 {
public static void main(String[] args) {
	Result[] result=Result.values();
	for(Result res:result) {
		System.out.println(res+"....."+res.ordinal());
		res.methodone();
	}
}


}
