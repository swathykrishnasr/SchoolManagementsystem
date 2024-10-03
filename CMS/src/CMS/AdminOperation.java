package CMS;

import java.sql.ResultSet;
import java.sql.Statement;

public class AdminOperation 
{
	static void viewStudent()
	{
		student st=new student();
		try 
		{
			Statement stmt=DBconnection.createstmt();
			String sql="select students.Name,students.dob,students.Guardian_name,marklist.English,marklist.Malayalam_1,marklist.Malayalam_2,marklist.Hindi,marklist.SS,marklist.CS,marklist.Physics,marklist.Chemistry,marklist.Biology,marklist.Maths from students inner join marklist on students.Adm_no=marklist.Adm_no";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("Name:"+rs.getString("Name")+" DOB: "+rs.getString("dob")+" Guardian_name:"+rs.getString("Guardian_name"));
				System.out.println("M1:"+rs.getString("English")+" M2: "+rs.getString("Malayalam_1")+" M3: "+rs.getString("Malayalam_2")+" M4: "+rs.getString("Hindi")+" M5: "+rs.getString("SS")+" M6: "+rs.getString("CS")+" M7: "+rs.getString("Physics")+" M8: "+rs.getString("Chemistry")+" M9: "+rs.getString("Biology")+" M10: "+rs.getString("Maths"));
				
				
				
			}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	static void viewStaff()
	{
		STAFF sf=new STAFF();
		try
		{
		Statement stmt=DBconnection.createstmt();
		String sql="select teachers.T_name,teachers.course,teachers.dob,students.Name from teachers inner join students on teachers.T_id=students.T_id";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			System.out.println("Name:"+rs.getString("T_name")+" Course:"+rs.getString("course")+" DOB"+rs.getString("dob")+" Students Name:"+rs.getString("Name"));
		}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
	}
}
