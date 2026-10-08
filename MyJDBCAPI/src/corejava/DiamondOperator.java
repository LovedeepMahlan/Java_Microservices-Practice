package corejava;
class Test<T>{
	T obj;
	Test(T obj){
		this.obj=obj;
	}
	public T getObj() {
		return obj;
	}
	public void processing() {
		System.out.println("Processing get Started");
	}
}
public class DiamondOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test<String> t1=new Test<>("Lovedeep") {
			@Override
			public void processing() {
				System.out.println("name is ::"+getObj());
			}
		};
		t1.processing();
	}

}
