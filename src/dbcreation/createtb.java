package dbcreation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class createtb {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/Databasex";
	private static final String username="root";
	private static final String password="akhila";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName(driver);
			conn =DriverManager.getConnection(url,username,password);
			System.out.println("Enter Table Name:");
			//String query="create database Akhila"; //static way
			String query="create table "+sc.next()+"(id int PRIMARY KEY,name varchar(255),city varchar(255))";
		    pmst=conn.prepareStatement(query);
			int i=pmst.executeUpdate();
			if(i==0) {
				System.out.println("Table created");
			}
			else {
				System.out.println("Table not Created");
			}
			pmst.close();
			conn.close();
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		
			//System.out.println(e);
		}
	}

}
