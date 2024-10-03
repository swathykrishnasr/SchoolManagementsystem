package CMS;

import java.util.Scanner;

public class TeacherProfile
{
	static int id=0;

	public TeacherProfile(int id) {
		super();
		this.id = id;
	}
	static void display()
	{
	 DBoperation o=new DBoperation();
	 STAFF sf=o.teacher_details(id);
	 System.out.println("WELCOME "+sf.getT_name());
	 System.out.println("DOB:"+sf.getDob());
	 System.out.println("Email:"+sf.getEmail());
	 Scanner sc=new Scanner(System.in);
	 int n;
	 do
	 {
		 System.out.println("1:ADD STUDENT\n2:VIEW ALL STUDENT\n3:VIEW STUDENT BY ID\n4:ADD MARKLIST\n5:EXIT");
		 n=sc.nextInt();
		switch(n)
		{
		 case 1:
			 TeachersDBoperation.addStudents();
			 break;
		 case 2:
			TeachersDBoperation.viewAll();
			 break;
		 case 3:
			 System.out.println("Enter the id:");
			 displayStudent(sc.nextInt());
			 break;
		 case 4:
			 TeachersDBoperation.addMark();
			 break;
		 default:
			 System.out.println("EXITING");
			 break;
				 
		}
	 }
	 while(n!=5);
	}
static void displayStudent(int n)
{
	
	
	TeachersDBoperation o=new TeachersDBoperation();
	student st=o.viewbyId(n);
	System.out.println("Name:"+st.getName());
	System.out.println("DOB:"+st.getDob());
	System.out.println("Adm_no:"+st.getAdm_no());
	System.out.println("Email:"+st.getEmail());
	System.out.println("Gaurdian_name:"+st.getGuardian_name());
	System.out.println("Role:"+st.getRole());
}


	
	
}
