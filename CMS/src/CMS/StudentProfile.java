package CMS;

import java.util.Scanner;

public class StudentProfile 
{
	static int Adm_no=0;

	public StudentProfile(int adm_no) {
		super();
		Adm_no = adm_no;
	}
	static void display()
	{
		StudentDBoperation so=new StudentDBoperation();
		student st=so.studentDetails();
		System.out.println("Welcome "+st.getName());
		Scanner sc=new Scanner(System.in);
		int n;
		do
		{
			System.out.println("1:VIEW PROFILE\n2:VIEW MARKLIST\n3:EXIT\nPLEASE ENTER THE OPTION:");
			n=sc.nextInt();
			switch(n)
			{
			case 1:
				viewProfile();
				break;
			case 2:
				viewMark();
				break;
				default:
					System.out.println("EXITING");
					break;
			}
		}
		while(n!=3);
		
	}
	static void viewProfile()
	{
		StudentDBoperation so=new StudentDBoperation();
		student st=so.studentDetails();
		System.out.println("Name: "+st.getName());
		System.out.println("Admission Number:"+st.getAdm_no());
		System.out.println("DOB:"+st.getDob());
		System.out.println("Email:"+st.getEmail());
		System.out.println("Gaurdian_Name:"+st.getGuardian_name());
	}
	static void viewMark()
	{
		StudentDBoperation so=new StudentDBoperation();
		Marklist m=so.mark();
		System.out.println("Malayalam_1:"+m.getMalayalam_1());
		System.out.println("Malayalam_2:"+m.getMalayalam_2());
		System.out.println("English:"+m.getEnglish());
		System.out.println("Hindi:"+m.getHindi());
		System.out.println("Chemistry:"+m.getChemistry());
		System.out.println("Biology:"+m.getBiology());
		System.out.println("Physics:"+m.getPhysics());
		System.out.println("CS:"+m.getCS());
		System.out.println("SS:"+m.getSS());
		System.out.println("Maths:"+m.getMaths());
		
	}
}
