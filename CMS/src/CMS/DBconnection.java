package CMS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBconnection
{
	public static Statement stmt=null;
	public static Statement createstmt()
	{
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","root");
		stmt=con.createStatement();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return stmt;
	}
	
}
