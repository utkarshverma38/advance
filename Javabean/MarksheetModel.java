package Javabean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

  

public class MarksheetModel {
	
	public int nextPk()throws Exception{
		int pk=0;
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		
		
		
		PreparedStatement ps = conn.prepareStatement("Select max(id) from tab");
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			pk =rs.getInt(1);
		}
		return pk + 1;
		 
		
	}
	

	public void Add(MarksheetBean bean) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.com.rays.rb.app");
		System.out.println(rb.getString("Driver"));
		
		Class.forName(rb.getString("Driver"));
		 
		 Connection conn = DriverManager.getConnection(rb.getString("url"),rb.getString("user"),rb.getString("password"));
		 
		conn.setAutoCommit(false);
		
		PreparedStatement ps =conn.prepareStatement("Insert into tab values(?,?,?,?,?,?)");
		
	
		
		ps.setInt(1,nextPk());
		ps.setString(2,bean.getFname());
		ps.setString(3,bean.getLname());
		ps.setInt(4,bean.getPhysics());
		ps.setInt(5,bean.getChemistry());
		ps.setInt(6,bean.getMaths());
		
		ps.executeUpdate();
		
		conn.commit();
		conn.close();
		ps.close();
		 
	}

	public void Update(MarksheetBean b) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("Update mark set fname = ? ,lname = ?, physics = ?, chemistry = ? , maths = ? where Rollno= ?");
		
		
		
		ps.setString(1,b.getFname());
		ps.setString(2,b.getLname());
		ps.setInt(3,b.getPhysics());
		ps.setInt(4,b.getChemistry());
		ps.setInt(5,b.getMaths());
		ps.setInt(6,b.getRollno()); 
		 
		
		ps.executeUpdate();
		
		conn.commit();
		ps.close();
		conn.close();
	
	}

	public void Delete(MarksheetBean c) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("Delete from mark where Rollno= ?");
		
		
		ps.setInt(1,c.getRollno()); 
 
		
		 
		
		ps.executeUpdate();
		
		conn.commit();
		ps.close();
		conn.close();
}
	
	public List <MarksheetBean> get(MarksheetBean a) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hp","root","root");
		
		
		PreparedStatement ps = conn.prepareStatement(" SELECT * from mark where Rollno= ?");
		
		ps.setInt(1,a.getRollno());
		
		 ResultSet rs = ps.executeQuery();
		 
		 ArrayList<MarksheetBean>list = new ArrayList<MarksheetBean>();
		
		 while (rs.next()) {
	
			 MarksheetBean mb = new MarksheetBean();
	    mb.setRollno(rs.getInt(1));	 
		mb.setFname(rs.getString(2));
		mb.setLname(rs.getString(3));
		mb.setPhysics(rs.getInt(4));
		mb.setChemistry(rs.getInt(5));
		mb.setMaths(rs.getInt(6));
		 
		 
		 }
		
		ps.close();
		conn.close();
		
		return list;
}
	public List<MarksheetBean> search() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hp", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("select * from Mark");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		while (rs.next()) {

			MarksheetBean bean1 = new MarksheetBean();
			
			bean1.setRollno(rs.getInt(1));
			bean1.setFname(rs.getString(2));
			bean1.setLname(rs.getString(3));
			bean1.setPhysics(rs.getInt(4));
			bean1.setChemistry(rs.getInt(5));
			bean1.setMaths(rs.getInt(6));
			list.add(bean1);
		}
		return list;
	}
	public List<MarksheetBean> getMeritList() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hp", "root", "root");
		
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("select *, ((physics + chemistry + maths)/3) as percentage from Mark where (physics > 40 AND chemistry > 40 AND Maths > 40) order by (physics + chemistry + maths) desc");
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		while (rs.next()) {

			MarksheetBean bean1 = new MarksheetBean();
			
			bean1.setRollno(rs.getInt(1));
			bean1.setFname(rs.getString(2));
			bean1.setLname(rs.getString(3));
			bean1.setPhysics(rs.getInt(4));
			bean1.setChemistry(rs.getInt(5));
			bean1.setMaths(rs.getInt(6));
			list.add(bean1);
		}
		return list;
	}
}