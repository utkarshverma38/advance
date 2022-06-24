package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCRUDUpdate {
	public static void main(String[] args) throws Exception {
		testselect();
	}
	private static void testselect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hp","root","root");
		
		Statement stmt =conn.createStatement();
		
		int i= stmt.executeUpdate("UPDATE marksheet set rollno = 1012 where id =12");
		System.out.println(i+"Record(s)Updated");

		conn.close();
		stmt.close();
	}

	}

