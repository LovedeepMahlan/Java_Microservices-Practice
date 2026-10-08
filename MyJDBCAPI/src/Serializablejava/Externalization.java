package Serializablejava;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Dog7 implements Externalizable
{
//instance variable
    String s;
    int i;
    int j;
//parameterized constructor
    Dog7(String s,int i, int j){
        this.s = s;
        this.i = i;
        this.j = j;
    }
    public Dog7()
    {
//To avoid InvalidClassException during "DeSerialization"
        System.out.println("Dog constructor called...");
    }
//Serialization
    public void writeExternal(ObjectOutput oo) throws IOException
    {
        System.out.println("Serializing the required fields of the Object");
        oo.writeObject(s);
        oo.writeInt(i);
    }
//DeSerialization
    public void readExternal(ObjectInput in)   throws IOException,ClassNotFoundException

    {
        System.out.println("DeSerializing the required fields of the Object");
        s = (String)in.readObject();
        i = in.readInt();
    }
}
public class Externalization
{
    public static void main(String[] args) throws Exception{
        Dog7 d1 = new Dog7("bruno",10,15);
        System.out.println("Dog Object :: "+d1.s+"...."+d1.i+"...."+d1.j);
        System.out.println("Serialization started....");
        new ObjectOutputStream(
        new FileOutputStream("Dog.ser")).writeObject(d1);

        System.out.println("Serialization ended....");

        System.out.println("DeSerialziation Started...");
        Dog7 d2 = (Dog7)new ObjectInputStream(
        new FileInputStream("Dog.ser")).readObject();
        System.out.println("DeSerialziation ended...");
        System.out.println("Dog Object :: "+d2.s+"...."+d2.i+"...."+d2.j);
    }
}