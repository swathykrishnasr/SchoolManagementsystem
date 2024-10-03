package CMS;

import java.util.Scanner;

public class Admin
{
	static void display()
	{
		System.out.println("********ADMIN********");
		Scanner sc=new Scanner(System.in);
		int n;
		do
		{
			System.out.println("1:VIEW ALL STUDENT\n2:VIEW ALL STAFF\n3: LOGOUT\nPLEASE ENTER THE OPTION");
			n=sc.nextInt();
			switch(n)
			{
			case 1:
				AdminOperation.viewStudent();
				break;
			case 2:
				AdminOperation.viewStaff();
				break;
				default:
					System.out.println("LOGOUTING");
					break;
			}
			
		}
		while(n!=3);
		
	}
}
