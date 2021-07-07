package com.te.accounts;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter ur choice");
		System.out.println("1.Insert data for bank register\n2.Like to Withdrawl amount\n 3.Check the balance");
		int a = sc.nextInt();

		switch (a) {
		case 1:
			new BankDataBase().Insert();
			break;
		case 2:
			try {
				new BankDataBase().withdrawl();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			new BankDataBase().remainingbalance();
			break;
		default:
			System.exit(a);
		}

	}

}
