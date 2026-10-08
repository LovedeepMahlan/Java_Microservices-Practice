package Annotations;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) 	
@interface BANK{
	String name() default "ICICI bank";
	String Branch() default "MG ROAD";
	String Phone() default "23988-34589";
}
@BANK(Branch="BTM LAYOUT",Phone="34954-76874")
class Account{
	String accNo;
	String acctype;
	String accName;
	Account(String accNo,String acctype,String accName){
		this.accName=accName;
		this.accNo=accNo;
		this.acctype=acctype;
	}
	public void getDetails() {
		System.out.println("AccName :: "+accName);
		System.out.println("AccNO   :: "+accNo);
		System.out.println("AccType :: "+acctype);
	}
}

public class CustomAnnotation {
	public static void main(String[] args) {
		Account account=new Account("348657263","Savings","Lovedeep");
		Class c=account.getClass();
		BANK bank=(BANK)c.getAnnotation(BANK.class);
		System.out.println("BankName :: "+bank.name());
		System.out.println("BranchName :: "+bank.Branch());
		System.out.println("PhoneNo :: "+bank.Phone());
		account.getDetails();
	}
}
