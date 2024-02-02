package Demo;

import java.util.Scanner;

import p.*;

public class Details {

	public Details() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the nuame");
		String name=s.nextLine();
		System.out.println("enter the branch");
		String bran=s.nextLine();
		branch b=new branch();
		boolean k= b.verify(bran);
		if(k) {
			System.out.println(" enter the roll number");
			String rollno=s.nextLine();
			if(rollno.length()==10) {
				rollno r=new rollno();
				 boolean z=r.verify(bran,rollno.substring(6,8));
				System.out.println("Student name:"+name);
				System.out.println("roll no:"+rollno);
				
				
			}
		}
	}

}
