package Annotations;

import java.lang.annotation.*;
@Target(value = {ElementType.TYPE,
ElementType.FIELD,
ElementType.CONSTRUCTOR,
ElementType.METHOD}
)
@interface Peristance{
	
}
@Peristance
class Employee{
	@Peristance
	String name;
	@Peristance
	Employee(String name){
		this.name=name;
	}
}
public class Targetnnotation {
	public static void main(String[] args) {
		Employee e=new Employee("Sonia");
	}
}
