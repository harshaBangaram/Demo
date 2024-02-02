package Demo;

import java.util.Scanner;

public class Demo1 {

	public Demo1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("enter branch to be printed");	
		String branch=s.nextLine();
switch(branch) {
case "cse":
	System.out.println("given branch is cse");
	break;
case "ece":
	System.out.println("given branch is ece");
	break;
case "eee":
	System.out.println("given branch is eee");
	break;
case "it":
	System.out.println("given branch is it");
	break;
case "mechanical":
	System.out.println("given branch is mechanical");
	break;
	default:
		System.out.println("given branch is wrong");
		if(branch!=s.nextLine()) {
			System.out.println("enter the another branch :");
			
			int br=s.nextInt();
			switch(br){
			case "civil":
				System.out.println("given branch is civil");
				break;
			case "A&ml":
				System.out.println("given branch is A&ml");
				break;
			case "general cse":
				System.out.println("given branch is general cse");
				break;
			case "auto mobile engineering":
				System.out.println("given branch is auto mobile engineering");
				break;
				default:
					System.out.println("given branch is invalid");
					break;
			}
			}
		break;	
			}
	System.out.println("........................................................................");	
//we writing connstructor here
StringBuffer st=new StringBuffer();
st.append("switches ");

System.out.println(st.toString());
st.append(" are ");

System.out.println(" append value :"+st.toString());
st.append("too ");

System.out.println(st.toString());
st.append(" complicated.");

System.out.println(st.toString());
System.out.println("....................................");



	}

}
