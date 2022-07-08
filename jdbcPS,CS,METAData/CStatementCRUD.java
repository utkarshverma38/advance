package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CStatementCRUD {
 public static void main(String[] args) throws Exception {
	testCallable();
	testdelete();
}

private static void testdelete() throws Exception {
	 Class.forName("com.mysql.jdbc.Driver");
	 
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
	 
	 CallableStatement cal = conn.prepareCall("{CALL delete(?)}");
	 
	 cal.registerOutParameter(1,Types.INTEGER);
	 
	 cal.executeUpdate();
	 
	 int delete = cal.getInt(1);
	 
	 System.out.println("Inserted");
}

private static void testCallable() throws Exception {
	Class.forName("com.mysql.jdbc.Driver");
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
	
	CallableStatement cal = conn.prepareCall("{CALL mark(?)}");
	
	cal.registerOutParameter(1,Types.INTEGER);
	cal.execute();
	System.out.println("Employee Count +"+cal .getInt(1));
	 }
}
