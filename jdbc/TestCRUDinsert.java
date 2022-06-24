package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


	public class TestCRUDinsert {
public static void main(String[] args) throws Exception {
	testselect();
}
private static void testselect() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hp","root","root");
	
	Statement stmt =conn.createStatement();
	
	int i= stmt.executeUpdate("insert into marksheet values (12,1012,'kartik','soni',44,56,77)");
	System.out.println(i+"Record(s)Updated");

	conn.close();
	stmt.close();
}

}
