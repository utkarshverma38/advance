package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

public class PStatementCRUD {
    
	public static void main(String[] args)throws Exception {
			testSelect();
			testAdd();
			testDelete();
			testUpdate();
			 
}

	private static void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		 
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		  
		  
		 
		 PreparedStatement ps = conn.prepareStatement("Update marksheet set id=12 where id=13 ");
		 
		  
		 int i = ps.executeUpdate();
		 
		 System.out.println(i+"Record(s)Updated");
	}

	private static void testDelete() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		 
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		  
		  
		 PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = 12 ");
		 
 	 
		 int i = ps.executeUpdate();
		 
		 System.out.println(i+"Record(s)Updated");
		 
	}

	private static void testAdd() throws Exception {
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		  
		 int id=12;
		 int Rollno=1012;
		 String fname="Kartik";
		 String lname ="Soni";
		 int physics =40;
		 int chemistry=33;
		 int maths  =45;
		 
		 PreparedStatement ps = conn.prepareStatement("Insert into marksheet values (?,?,?,?,?,?,?)");
		 
		 ps.setInt(1, id);
		 ps.setInt(2, Rollno);
		 ps.setString(3, fname);
		 ps.setString(4, lname);
		 ps.setInt(5, physics);
		 ps.setInt(6, chemistry);
		 ps.setInt(7, maths);
		 
		 int i = ps.executeUpdate();
		 
		 System.out.println(i+"Record(s)Updated");
	}

	private static void testSelect() throws Exception  {
		 Class.forName("com.mysql.jdbc.Driver");
		 
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		 
		 PreparedStatement ps = conn.prepareStatement("SELECT * FROM MARKSHEET");
		 
		 ResultSet rs = ps.executeQuery();
		 
		 while(rs.next()) {
			 System.out.print(rs.getString(1));
			 System.out.print("\t"+rs.getString(2));
			 System.out.print("\t"+rs.getString(3));
			 System.out.print("\t"+rs.getString(4));
			 System.out.print("\t"+rs.getString(5));
			 System.out.print("\t"+rs.getString(6));
			 System.out.println("\t"+rs.getString(7));
			  

			  
		 
	 }
		  rs.close();
	}
}

	 