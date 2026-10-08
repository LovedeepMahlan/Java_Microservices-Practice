package Serializablejava;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class UID2 {

	public static void main(String[] args)throws Exception{
		// TODO Autou-generated method stub
		UID uid=new UID();
		System.out.println("----Serialization strted------");
		new ObjectOutputStream(new FileOutputStream("Dog.ser")).writeObject(uid);
		System.out.println("----Serialization ended----");
	}

}
