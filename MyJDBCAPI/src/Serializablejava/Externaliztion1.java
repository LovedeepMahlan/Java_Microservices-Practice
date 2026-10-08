package Serializablejava;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Externalizable{
	int j;
	String nme;
	int k;
	Dog(String nme,int j, int k){
		this.nme = nme;
		this.k = k;
		this.j = j;
		}
	Dog(){
		
		System.out.println("Dog Consstructor will be called");
	}

	public void writeExternal(ObjectOutput oo) throws IOException
	{
		System.out.println("Serializing the required fields of the Object");
		oo.writeObject(nme);
		oo.writeInt(j);
	}
	public void readExternal(ObjectInput in)

			throws IOException,ClassNotFoundException

			{
			System.out.println("DeSerializing the required fields of the Object");
			nme = (String)in.readObject();
			j = in.readInt();
			}
}
	
public class Externaliztion1{
	public static void main(String[] args)throws Exception {
		Dog d = new Dog("bruno",10,15);
		System.out.println("Dog Object :: "+d.j+"...."+d.k+"...."+d.nme);	
		new ObjectOutputStream(
				new FileOutputStream("Dog.ser")).writeObject(d);
		Dog d1=(Dog)new ObjectInputStream(
				new FileInputStream("Dog.ser")).readObject();

		System.out.println("DeSerialziation ended...");
		System.out.println("Dog1 Object :: "+d1.j+"...."+d1.nme+"...."+d1.k);	}
}