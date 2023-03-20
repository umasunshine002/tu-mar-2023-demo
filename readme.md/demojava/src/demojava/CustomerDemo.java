package demojava;

import java.sql.*;
import java.util.*;

public class CustomerDemo {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int option = 0;
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CustomerDB","root","umadevi02");
			do {
				switch(option) {
				case 1:update(connection);
						break;
				case 2:updateMultiple(connection);
						break;
				case 3:Display(connection);
						break;
				case 4:DisplayAll(connection);
						break;
				default:System.out.println("Enter valid input");
				}
				System.out.println("Enter choice");
				System.out.println("1.Update\n2.UpdateAll\n3.Read\n4.ReadAll\n");
				option = sc.nextInt();
				}while(option<=4);
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void update(Connection connection)throws SQLException {
		
		System.out.println("Enter Customer ID for updation");
		int customerid = sc.nextInt();
		System.out.println("Enter Customer Name");
		String customername = sc.next();
		System.out.println("Enter Customer Mobile Number");
		String customermobile = sc.next();
		System.out.println("Enter mail ID");
		String customermail = sc.next();
		System.out.println("Enter number of items purchased");
		int customeritems = sc.nextInt();
	
		String sql1 = "UPDATE Customer SET cname=?,mobile=?,mail=?,itemspurchased=? WHERE id=?";
		PreparedStatement ps1 = connection.prepareStatement(sql1);
		ps1.setInt(5,customerid);
		ps1.setString(1,customername);
		ps1.setString(2, customermobile);
		ps1.setString(3,customermail);
		ps1.setInt(4,customeritems);
		ps1.executeUpdate();
		System.out.println("Updated Successfully!");	
	}
	private static void updateMultiple(Connection connection) throws SQLException{
		
		String s1 = "UPDATE Customer SET cname=?,mobile=?,mail=?,itemspurchased=? WHERE id = ?";
		PreparedStatement ps2 = connection.prepareStatement(s1);
		List<Customer> updatedlist = new ArrayList<>();
	      System.out.println("Enter Number of Updations:");
	      int n=sc.nextInt();
	      while(n!=0) {
	    	  System.out.println("Enter Customer ID");
	    	  int value=sc.nextInt();
	    	  System.out.println("Enter values for updation");
	    	  String cname = sc.next();
	    	  String cmobile= sc.next();
	    	  String cmail = sc.next();
	    	  int citemspurchased = sc.nextInt();
		      updatedlist.add(new Customer(value,cname,cmobile,cmail,citemspurchased));
		      n -= 1;
	      }
	      for (Customer i : updatedlist) {
	    	  ps2.setInt(5,i.getId());
	  		  ps2.setString(1,i.getName());
	  		  ps2.setString(2, i.getMobile());
	  		  ps2.setString(3,i.getMail());
	  		  ps2.setInt(4,i.getItemspurchased());
	  		  ps2.executeUpdate();
		}
	}
	private static void Display(Connection connection)throws SQLException{
		System.out.println("Enter Employee ID to retrieve");
		int rid= sc.nextInt();
		String sql2="SELECT * FROM Customer WHERE id=?";
		PreparedStatement st = connection.prepareStatement(sql2);
		st.setInt(1,rid);
		ResultSet res = st.executeQuery();
		while(res.next()) 
			System.out.println(res.getInt(1)+"|"+res.getString(2)+"|"+res.getString(3)+"|"+res.getString(4)+"|"+res.getInt(5));	
	}

	private static void DisplayAll(Connection connection) throws SQLException {
		 String s6 = "SELECT * FROM Customer";
	       Statement s = connection.createStatement();
	       ResultSet rs = s.executeQuery(s6);
	      ArrayList<Customer> u = new ArrayList<>();
	      while (rs.next()) {
	        int id = rs.getInt("id");
	        String name = rs.getString("cname");
	        String mobile = rs.getString("mobile");
	        String email = rs.getString("mail");
	        int itemspurchased = rs.getInt("itemspurchased");
	        u.add(new Customer(id,name,mobile,email,itemspurchased));
	      }
	      for (Customer i : u) {
	        System.out.println(i.getId() + " | " + i.getName() + " | " + i.getMobile()+" | "+i.getMail()+" | "+i.getItemspurchased());
	      }
		
	}
}
