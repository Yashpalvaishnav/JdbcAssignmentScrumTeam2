package com.te.accounts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankDataBase {

	private static final double balance = 0;
	String url = "jdbc:mysql://localhost:3306/new_yash";
	String user = "root";
	String pwd = "yash";
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	PreparedStatement p = null;
	
	public BankDataBase() {
		// TODO Auto-generated constructor stub
	}


	public void Insert() {

		try {
			for (;;) {
				System.out.println("enter the Account number");
				int id = sc.nextInt();
				System.out.println("Enter the name");
				String name = sc.next();
				sc.nextLine();
				System.out.println("enter the Account balancer");
				double Balance=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the address");
				String address = sc.nextLine();
				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection(url, user, pwd);

				String query = "insert into bank values(?,?,?,?)";
				p = con.prepareStatement(query);
				p.setInt(1, id);
				p.setString(2, name);
				p.setDouble(3, Balance);
				p.setString(4, address);
				int result = p.executeUpdate();
				if (result != 0) {
					System.out.println("no of rows effecteed" + result);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void withdrawl() throws SQLException {
		
		System.out.println("enter the id");
		int id=sc.nextInt();
		System.out.println("enter the amount");
		double amount=sc.nextDouble();
		con = DriverManager.getConnection(url, user, pwd);
		if(amount>0) {
			String query1 = "update bank  set Balance=Balance - ? where Id=?"; 
		
		p = con.prepareStatement(query1);
		
		p.setDouble(1, amount);
		p.setInt(2, id);
		int result = p.executeUpdate();
		if (result != 0) {
			System.out.println("updated" + result);
		
		}	
	}
	
		
		
	}
	public void remainingbalance() {
		System.out.println("enter the account number u wanna see balance");
		int id=sc.nextInt();
		String query3="select Balance from bank where id=?";
		
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			p=con.prepareStatement(query3);
			p.setInt(1, id);
			ResultSet result=p.executeQuery();
			if(result.next()) {
			System.out.println("the balance is:"+result.getDouble("Balance"));
				}else {
					System.out.println("the account number is wrong");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
				p.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}	
		
		
		
