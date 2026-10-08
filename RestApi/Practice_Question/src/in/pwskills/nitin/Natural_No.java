package in.pwskills.nitin;

import java.util.Scanner;

public class Natural_No {
	Scanner sc=new Scanner(System.in);
	
	public void star_pattern() {
		System.out.println("Enter the number till then we have to make a pattern");
		int x=sc.nextInt();
		for(int a=1;a<=x;a++) {
			for(int i=1;i<=a;i++) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
}
