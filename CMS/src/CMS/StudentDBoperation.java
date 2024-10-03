package CMS;

import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDBoperation 
{
	static student studentDetails()
	{
		student st=new student();
		try 
		{
		Statement stmt=DBconnection.createstmt();
		String sql="select * from students where Adm_no="+StudentProfile.Adm_no;
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			st.setName(rs.getString("Name"));
			st.setAdm_no(rs.getInt("Adm_no"));
			st.setEmail(rs.getString("email"));
			st.setGuardian_name(rs.getString("Guardian_name"));
			st.setDob(rs.getString("dob"));
			
		}
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		return st;
	}
	static Marklist mark()
	{
		Marklist m=new Marklist();
		try
		{
		Statement stmt=DBconnection.createstmt();	
		String sql="select * from marklist where Adm_no="+StudentProfile.Adm_no;
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			m.setBiology(rs.getString("Biology"));
			m.setChemistry(rs.getString("Chemistry"));
			m.setCS(rs.getString("CS"));
			m.setEnglish(rs.getString("English"));
			m.setHindi(rs.getString("Hindi"));
			m.setMalayalam_1(rs.getString("Malayalam_1"));
			m.setMalayalam_2(rs.getString("Malayalam_2"));
			m.setMaths(rs.getString("Maths"));
			m.setPhysics(rs.getString("Physics"));
			m.setSS(rs.getString("SS"));
		}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return m;
	}
}
