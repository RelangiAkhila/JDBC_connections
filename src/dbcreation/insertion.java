package dbcreation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/Databasex";
	private static final String username="root";
	private static final String password="akhila";
	private static Connection conn;
	private static PreparedStatement pmst;

public static void main(String[] args) {
	try {
		Scanner sc=new Scanner(System.in);
		Class.forName(driver);
		conn =DriverManager.getConnection(url,username,password);
		
		String query="insert into Login(login_id,login_name,login_email) values(?,?,?)";
		//String query="update table1 set city=valluru where id=1;"
	    pmst=conn.prepareStatement(query);
	    System.out.println("Enter Login id:");
	    pmst.setString(1,sc.nextLine());
	    System.out.println("Enter Login name:");
	    pmst.setString(2, sc.nextLine());
	    System.out.println("Enter Login email");
	    pmst.setString(3,sc.nextLine());
		int i=pmst.executeUpdate();
		if(i>0) {
			System.out.println("Data inserted");
		}
		else {
			System.out.println("Data not inserted");
		}
		pmst.close();
		conn.close();
		sc.close();
		
	}
		
 catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

}
}
