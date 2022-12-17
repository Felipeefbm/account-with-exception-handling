package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinesException;

public class Program {

	public static void main(String[] args) {
		
		
			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter account data ");
			
			System.out.print("Number: ");
			int number = sc.nextInt();
			
			System.out.print("holder: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Initial Balance: ");
			double balance = sc.nextDouble();
			
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, name, balance, withdrawLimit);
			
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			
			try {
				account.withdraw(amount);
				System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
			}
			catch(BusinesException e) {
				System.out.println(e.getMessage());
			}
			
		
		sc.close();
	}

}
