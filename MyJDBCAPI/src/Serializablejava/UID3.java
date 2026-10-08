package Serializablejava;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class UID3 {
	public static void main(String[] args) throws Exception{
		System.out.println("De-Serialization started");
		UID d2=(UID)new ObjectInputStream(
				new FileInputStream("Dog.ser")).readObject();
		System.out.println("Og Object :: "+d2.a+"--"+d2.b);
		System.out.println("De-Serialization ended");
	}
}