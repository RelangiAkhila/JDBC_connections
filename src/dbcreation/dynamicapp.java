package dbcreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class dynamicapp {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "akhila";
	private static Connection conn;
	private static PreparedStatement pmst;

	public static void main(String[] args) {
		int choice = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("Choose your Choice:");
			displayMenu();
			choice = Integer.parseInt(sc.next());
			switch (choice) {
			case 1:
				createdatabase();
				break;
			case 2:
				dropdatabase();
				break;
			case 3:
				datainsert();
				break;
			case 4:
				deleteby();
				break;
			case 5:
				updatedata();
				break;
			case 6:
				getby();
				break;
			case 7:
				fetchall();
				break;
			case 8:
				Login();
				break;
			case 9:
				System.exit(0);
			default:
				System.out.println("Invalid option");
				break;
			}
		} while (choice > 0);
	}

	private static void Login() {
		// TODO Auto-generated method stub
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name:");
			String url="jdbc:mysql://localhost:3306/"+sc.next();
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Enter Table name");
			String sql="select * from "+sc.next()+" where login_name=?&&login_email=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("Enter Username:");
			pmst.setString(1,sc.next());
			System.out.println("Enter useremail");
			pmst.setString(2, sc.next());
			ResultSet rs=pmst.executeQuery();
			if(rs.next()) {
				System.out.println("Login successfully");
			}
			else {
				System.out.println("invalid credentials");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	private static void fetchall() {
		// TODO Auto-generated method stub
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name:");
			String url="jdbc:mysql://localhost:3306/"+sc.next();
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Enter table name:");
			String sql="select * from "+sc.next();
			pmst=conn.prepareStatement(sql);
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				System.out.println("Order id:"+rs.getInt("order_id"));
				System.out.println("Order name:"+rs.getString("order_name"));
				System.out.println("order pincode:"+rs.getInt("order_pincode"));
				System.out.println("order address:"+rs.getString("order_address"));
				System.out.println();
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void getby() {
		// TODO Auto-generated method stub
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter Database name:");
			String url="jdbc:mysql://localhost:3306/"+sc.next();
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Enter Table name");
			String sql="select * from "+sc.next()+" where order_id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("Enter Order id:");
			pmst.setInt(1, sc.nextInt());
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				System.out.println("Ordern id:"+rs.getInt("order_id"));
				System.out.println("Order name:"+rs.getString("order_name"));
				System.out.println("order pincode:"+rs.getInt("order_pincode"));
				System.out.println("order address:"+rs.getString("order_address"));
				System.out.println();
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void updatedata() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name");
			String url = "jdbc:mysql://localhost:3306/" + sc.next();
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table Name");
			String sql = "update "+sc.next()+" set order_name=?,order_pincode=?,order_address=? where order_id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter Order Name:");
			pmst.setString(1, sc.next());
			System.out.println("Enter Order pincode:");
			pmst.setInt(2, sc.nextInt());
			System.out.println("Enter Order Address:");
			pmst.setString(3, sc.next());
			System.out.println("Enter Order Id:");
			pmst.setLong(4, sc.nextLong());
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Data updated");
			} else {
				System.out.println("Data not updated");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void deleteby() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name");
			String url = "jdbc:mysql://localhost:3306/" + sc.next();
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table Name");
			String sql = "delete from "+sc.next() +" where order_id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter Order Id:");
			pmst.setLong(1, sc.nextLong());
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Data deleted");
			} else {
				System.out.println("Data not deleted");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void datainsert() {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName(driver);
			System.out.println("Enter database name");
			String url = "jdbc:mysql://localhost:3306/" + sc.next();
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter table Name");
			String sql = "insert into " + sc.next()
					+ "(order_id,order_name,order_pincode,order_address)values(?,?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("Enter Order Id:");
			pmst.setLong(1, sc.nextLong());
			System.out.println("Enter Order Name:");
			pmst.setString(2, sc.next());
			System.out.println("Enter Order pincode:");
			pmst.setInt(3, sc.nextInt());
			System.out.println("Enter Order Address:");
			pmst.setString(4, sc.next());
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Data Inserted");
			} else {
				System.out.println("Data not Inserted");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void dropdatabase() {

		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database Name");
			Scanner sc = new Scanner(System.in);
			String sql = "drop database " + sc.nextLine();
			pmst = conn.prepareStatement(sql);
			int i =pmst.executeUpdate();
			if (i==0) {
				System.out.println("Database deleted");
			} else {
				System.out.println("Database not deleted");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private static void createdatabase() {
		// TODO Auto-generated method stub
		try {
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3306/";
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Enter Database Name");
			Scanner sc = new Scanner(System.in);
			String sql = "create database " +sc.nextLine();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i > 0) {
				System.out.println("Database created");
			} else {
				System.out.println("Database not created");
			}
			pmst.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void displayMenu() {
		// TODO Auto-generated method stub
		System.out.println("\t1.Create database");
		System.out.println("\t2.Drop database");
		System.out.println("\t3.Data Insertion");
		System.out.println("\t4.Delete by");
		System.out.println("\t5.Update data");
		System.out.println("\t6.Get by ");
		System.out.println("\t7.Get All");
		System.out.println("\t8.Login");
		System.out.println("\t9.EXIT");
	}

}
