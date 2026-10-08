package Annotations;

import java.util.ArrayList;
import java.util.List;
class Bank2
{
@SuppressWarnings("unchecked")
public ArrayList getCustomers(){
ArrayList al = new ArrayList();

al.add("sachin");
al.add("dhoni");
al.add("dravid");
al.add("kohli");
return al;
}
}
public class SuppressWarn
{
public static void main(String[] args)
{
Bank2 b = new Bank2();
List l = b.getCustomers();
System.out.println(l);
}
}
