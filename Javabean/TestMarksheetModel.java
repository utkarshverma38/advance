package Javabean;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {
		 
		add();
		//update();
	    //delete();
		//get();
		//Search();
		//testGetMeritList();
	}
	private static void get() throws Exception {
		
		
		MarksheetBean Bean = new MarksheetBean();
		
		 MarksheetModel mm =  new MarksheetModel();
		Bean.setRollno(1011);	
		 List<MarksheetBean>List = mm.get(Bean);
		 
		 Iterator<MarksheetBean> it = List.iterator();
		 
		 while(it.hasNext()) {
			
			 MarksheetBean mb=(MarksheetBean) it.next();
			 
			 System.out.println(mb.getRollno());
			 System.out.println(mb.getFname());
			 System.out.println(mb.getLname());
			 System.out.println(mb.getPhysics());
			 System.out.println(mb.getChemistry());
			 System.out.println(mb.getMaths());
		 }
		
		
	}
	private static void delete() throws Exception {
		MarksheetBean c = new MarksheetBean();
		 
		 MarksheetModel mm =  new MarksheetModel();
		
		 
		 c.setRollno(1012);
		  
 		
		 mm.Delete(c);
		 
		 System.out.println("Work is Done");
		
	}
	private static void update() throws Exception {
		 MarksheetBean b = new MarksheetBean();
		 
		 MarksheetModel mm =  new MarksheetModel();
		
		 
		 b.setRollno(1012);
		 b.setFname( "ram");
		 b.setLname("Verma");
		 b.setPhysics(85);
		 b.setChemistry(95);
		 b.setMaths(88);
  		
		 mm.Update(b);
		 
		 System.out.println("Work is Done");
		
	}

	private static void add() throws Exception {
		 MarksheetBean bean = new MarksheetBean ();
		
		 MarksheetModel mm= new MarksheetModel();
		 
		  
		 
		 bean.setFname("shayam");
		 bean.setLname("hardiya");
		 bean.setPhysics(66);
		 bean.setChemistry(85);
		 bean.setMaths(75);
		 
         mm.Add(bean);
         
		System.out.println("insert");
	}
	
	private static void Search() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		List<MarksheetBean> list = model.search();
		
		Iterator<MarksheetBean> it = list.iterator();
		
		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			
			System.out.print("\t" + mb.getRollno());
			System.out.print("\t" + mb.getFname());
			System.out.print("\t" + mb.getLname());
			System.out.print("\t" + mb.getPhysics());
			System.out.print("\t" + mb.getChemistry());
			System.out.println("\t" + mb.getMaths());
		}
	}
	private static void testGetMeritList() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		List<MarksheetBean> list = model.getMeritList();
		
		Iterator<MarksheetBean> it = list.iterator();
		
		while (it.hasNext()) {
			MarksheetBean mb = (MarksheetBean) it.next();
			
			System.out.print("\t" + mb.getRollno());
			System.out.print("\t" + mb.getFname());
			System.out.print("\t" + mb.getLname());
			System.out.print("\t" + mb.getPhysics());
			System.out.print("\t" + mb.getChemistry());
			System.out.println("\t" + mb.getMaths());
		}
	}

}
