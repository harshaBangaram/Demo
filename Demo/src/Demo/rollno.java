package Demo;

public class rollno {


		// TODO Auto-generated constructor stub
		boolean z=false;
		 String branch =null;
		
	 public boolean verify(String bran,String code) {
			switch(code) {
			case "05":branch="cse";
				break;
			case "02": branch="ece";
				break;
			case "04":branch="eee";
				break;
			case "01":branch="mechanical";
				break;
			case "03":branch="civil";
				break;
			default:
				break;
			}
			if(branch!=null) {
				if(bran.equals(branch)) {
					z=true;
				}
			}
			return z;
			}
	
		
	}


