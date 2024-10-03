package CMS;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.admin.MiniAdmin;

public class DBoperation
{
	 // Method to add a new teacher to the database
	static void addTeachers()
	{
		
		Scanner sc=new Scanner(System.in);
		STAFF sf=new STAFF();
		System.out.println("Enter your name:");
		sf.setT_name(sc.next());
		System.out.println("Enter your dob:");
		sf.setDob(sc.next());
		System.out.println("Enter your email:");
		sf.setEmail(sc.next());
		System.out.println("Enter your password:");
		sf.setPassword(sc.next());
		System.out.println("Enter your gender:");
		sf.setT_gender(sc.next());
		System.out.println("Enter your course:");
		sf.setCourse(sc.next());
		System.out.println("Enter your role:");
		sf.setRole(sc.next());
		create(sf);// Inserting teacher data into the database
		
	}
	static void create(STAFF sf)
	{
	    try
	    {
	    	
		   Statement stmt=DBconnection.createstmt();
		// SQL query to insert teacher details into the 'teachers' table
 		   String sql="insert into teachers(T_name,T_gender,course,email,password,dob,role)values('"+sf.getT_name()+"','"+sf.getT_gender()+"','"+sf.getCourse()+"','"+sf.getEmail()+"','"+sf.getPassword()+"','"+sf.getDob()+"','"+sf.getRole()+"')";
		   int i= stmt.executeUpdate(sql);
		   int id=0;
		   if(i==1)
		   {
			   System.out.println("INSERTED SUCCESSFULLY");
			// Retrieve the ID of the newly inserted teacher
			   sql="select max(T_id) from teachers";
			   ResultSet rs=stmt.executeQuery(sql);
			   while(rs.next())
			   {
				   id=rs.getInt("max(T_id)");
			   }
			 if(id>0)
			 {
				 sql="insert into login (id,username,password,role)values("+id+",'"+sf.getEmail()+"','"+sf.getPassword()+"','"+sf.getRole()+"')";
				 if(stmt.executeUpdate(sql)==1)
				 {
					 System.out.println("LOGIN SUCESSFULLY");
					 
				 }
			 }
			   
		   }
		   
		   
	    } 
	    catch (Exception e)
	    {

         System.out.println(e);
		}
	    
	}
	// Method to check login
	static void checklogin(String email,String pass)
	{
      int id=0;
      String role="";
     try
     {
    	 Statement stmt=DBconnection.createstmt();
    	 String sql="select id,role from login where password='"+pass+"' and username='"+email+"' ";
    	 ResultSet rs=stmt.executeQuery(sql);
    	 while(rs.next())
    	 {
    		 id=rs.getInt("id");
    		 role=rs.getString("role");
    	
    	 }
    	 if(id>0)
    	 {
    		switch(role)
    		{
    		case "teacher":
    			TeacherProfile tp=new TeacherProfile(id);
    			tp.display();
    			break;
    		case "student":
    			StudentProfile sp=new StudentProfile(id);
    			sp.display();
    			break;
    		case "Admin":
    			Admin.display();
    			break;
    		}
    	 }
    	 else
    	 {
    		 System.out.println("INVALID");
    		 Home.mainMenu();
    	 }
    	 
    	 
	 } 
     catch (Exception e)
     {
    	 System.out.println(e);
		
	 }
	}
	static STAFF teacher_details(int id)
	{
		STAFF sf=new STAFF();
		try
		{
			Statement stmt=DBconnection.createstmt();
			String sql="select * from teachers where T_id="+id;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				sf.setT_name(rs.getString("T_name"));
				sf.setT_gender(rs.getString("T_gender"));
				sf.setDob(rs.getString("dob"));
				sf.setEmail(rs.getString("email"));
			}
			
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return sf;
	}
}
