package CMS;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class TeachersDBoperation
{
	static void addStudents()
	{
		Scanner sc=new Scanner(System.in);
		student st=new student();
		System.out.println("Enter the Admission Number:");
		st.setAdm_no(sc.nextInt());
		System.out.println("Enter the name:");
		st.setName(sc.next());
		System.out.println("Enter the dob:");
		st.setDob(sc.next());
		System.out.println("Enter the Guardian name:");
		st.setGuardian_name(sc.next());
		System.out.println("Enter the email:");
		st.setEmail(sc.next());
		System.out.println("Enter the role:");
		st.setRole(sc.next());	
		createStudent(st);
	}
	static void createStudent(student st)
	{
		try
	    {
	    	
		   Statement stmt=DBconnection.createstmt();
 		   String sql="insert into students(Adm_no,Name,dob,Guardian_name,email,role,T_id)values('"+st.getAdm_no()+"','"+st.getName()+"','"+st.getDob()+"','"+st.getGuardian_name()+"','"+st.getEmail()+"','"+st.getRole()+"',"+TeacherProfile.id+")";
		   int i= stmt.executeUpdate(sql);
		   int id=0;
		   if(i==1)
		   {
			   System.out.println("INSERTED SUCCESSFULLY");
			   
			   sql="select max(Adm_no) from students";
			   ResultSet rs=stmt.executeQuery(sql);
			   while(rs.next())
			   {
				   id=rs.getInt("max(Adm_no)");
			   }
			 if(id>0)
			 {
				 sql="insert into login (id,username,password,role)values("+id+",'"+st.getEmail()+"','"+st.getDob()+"','"+st.getRole()+"')";
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
	static void checkStudentlogin(String email,String pass)
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
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
	}
	static student viewbyId(int id)
	{
		student st=new student();
	try
	{
		
		Statement stmt=DBconnection.createstmt();
		String sql="select * from students where Adm_no="+id;
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			st.setName(rs.getString("Name"));
			st.setAdm_no(rs.getInt("Adm_no"));
			st.setEmail(rs.getString("email"));
			st.setGuardian_name(rs.getString("Guardian_name"));
			st.setDob(rs.getString("dob"));
			st.setRole(rs.getString("role"));
		}
	} catch (Exception e)
	{
		System.out.println(e);
	}
	return st;
	}
	static void addMark()
	{
		Scanner sc=new Scanner(System.in);
		Marklist m=new Marklist();
		System.out.println("Enter the Admission_no:");
		m.setAdm_no(sc.nextInt());
		System.out.println("Enter the mark of English:");
		m.setEnglish(sc.next());
		System.out.println("Enter the mark of Malayalam_1:");
		m.setMalayalam_1(sc.next());
		System.out.println("Enter the mark of Malayalam_2:");
		m.setMalayalam_2(sc.next());
		System.out.println("Enter the mark of Hindi:");
		m.setHindi(sc.next());
		System.out.println("Enter the mark of SS:");
		m.setSS(sc.next());
		System.out.println("Enter the mark of CS:");
		m.setCS(sc.next());
		System.out.println("Enter the mark of Physics:");
		m.setPhysics(sc.next());
		System.out.println("Enter the mark of Chemistry:");
		m.setChemistry(sc.next());
		System.out.println("Enter the mark of Biology:");
		m.setBiology(sc.next());
		System.out.println("Enter the mark of Maths:");
		m.setMaths(sc.next());
		createMark(m);
	}
	static void createMark(Marklist m)
	{
		try 
		{
		Statement stmt=DBconnection.createstmt();
		String sql="insert into marklist values("+m.getAdm_no()+",'"+m.getEnglish()+"','"+m.getMalayalam_1()+"','"+m.getMalayalam_2()+"','"+m.getHindi()+"','"+m.getSS()+"','"+m.getCS()+"','"+m.getPhysics()+"','"+m.getChemistry()+"','"+m.getBiology()+"','"+m.getMaths()+"')";
		int i=stmt.executeUpdate(sql);
		if(i==1)
		{
			System.out.println("INSERTED SUCCESSFULLY");
		}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
	static void viewAll()
	{
		student st=new student();
		try
		{
			Statement stmt=DBconnection.createstmt();
			String sql="select Adm_no from students where T_id="+TeacherProfile.id;
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				TeacherProfile.displayStudent(rs.getInt("Adm_no"));
			}
			
					
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	 
}
