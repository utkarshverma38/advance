package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCRUD {

	public static void main(String[] args)throws Exception {
		testselect();
	}
	private static void testselect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from marksheet");
		
		while(rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(2));
			System.out.print(" "+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.println("\t"+rs.getString(7));
		}
		conn.close();
		stmt.close();
		rs.close();
	}
}
