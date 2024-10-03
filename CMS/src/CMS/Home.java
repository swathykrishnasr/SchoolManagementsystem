package CMS;

import java.util.Scanner;

public class Home
{
	static void mainMenu()
	{
		Scanner sc=new Scanner(System.in);
		int n;
		do
		{
			System.out.println("1.CREATE ACCOUNT\n2.LOGIN\n3.EXIT\nPLEASE ENTER THE OPTION:-");
			n=sc.nextInt();
			switch(n)
			{
			case 1:
				DBoperation.addTeachers();
				break;
			case 2:
				login();
				break;
			default :
				System.out.println("EXITING");
				break;
			
			}
			
		}
		while(n!=3);
		// Loop until the user selects option 3 (Exit)
	}
	static void login()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("USERNAME:");
		String email=sc.next();
		System.out.println("PASSWORD:");
		String password=sc.next();
		DBoperation.checklogin(email,password);// Check login  for teachers
		TeachersDBoperation.checkStudentlogin(email,password);// Check login  for students
	}
	public static void main(String[] args)
	{
		mainMenu();
	}
}
