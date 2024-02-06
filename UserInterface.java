import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Allows user to purchase and keep track of tickets.
 */
public class UserInterface {
	//If user wants standing ticket or on-field ticket
	private static boolean standing = false;
	//If user wants backstage ticket
	private static boolean backstage = false;
	//Name of event
	private static String name = "";
	//Contains all purchased tickets
	private static ArrayList<Ticket> tickets = null;
	
	public static void main(String[] args) {
		tickets = new ArrayList<Ticket>();
		Scanner sc = new Scanner(System.in);
		
		buyTicket(sc);
		while(true) {
			System.out.println("To purchase another ticket, enter 1.");
			System.out.println("To see all of your purchased tickets, enter 2.");
			System.out.println("To exit, enter anything else.");
			int t = 0;
			try {
				t = sc.nextInt();
			}
			catch(Exception e){
				System.out.println("Thank you for using the Ticket Booking System!");
				break;
			}
			if(t == 1) {
				buyTicket(sc);
			}
			else if(t==2) {
				for(int i = 0;i<tickets.size();i++) {
					int pos = i + 1;
					System.out.println("Ticket #" + pos + ":");
					tickets.get(i).getTicket();
				}
			}
			else {
				System.out.println("Thank you for using the Ticket Booking System!");
				break;
			}
		}
		sc.close();
	}
	
	/*
	 * Handles purchase of tickets
	 */
	public static void buyTicket(Scanner sc) {
		//Theater, concert, or sports ticket
		String ticketType;
		//Type of ticket
		int type = 0;
		//Stores venue
		String venue = "";
		//Stores row of seat
		char row = '|';
		//Stores seat number
		int seat = 0;
		//Stores full seat
		String sectionRow = "";
		
		System.out.print("Please enter which ticket type you want: ");
		ticketType = sc.nextLine();
		while(true) {
			if(ticketType.toUpperCase().equals("THEATER")) {
				type = 1;
				break;
			}
			else if (ticketType.toUpperCase().equals("CONCERT")) {
				type = 2;
				break;
			}
			else if (ticketType.toUpperCase().equals("SPORTS")) {
				type = 3;
				break;
			}
			else {
				System.out.println("Valid ticket types include Theater, Concert, and Sports.");
				ticketType = sc.nextLine();
			}
		}
		System.out.print("Please enter the venue name: ");
		while(venue.equals("")) {
			venue = sc.nextLine();
		}
		System.out.print("Do you want a standing ticket? (y/n): ");
		char temp = sc.next().charAt(0);
		while(true) {
			if(temp == 'y') {
				standing = true;
				break;
			}
			else if(temp == 'n') {
				standing = false;
				break;
			}
			else {
				System.out.print("Please input y or n: ");
				temp = sc.next().charAt(0);
			}
		}
		if(!standing) {
			System.out.print("Please enter the row of the ticket you would like to purchase: ");
			row = sc.next().charAt(0);
			while(true) {
				if (row < 65 || row > 122 || (row > 90 && row < 97)) {
					System.out.print("Please enter a letter: ");
					row = sc.next().charAt(0);
					break;
				}
				else {
					break;
				}
			}
			System.out.print("Please enter the seat number of the ticket you would like to purchase: ");
			while(true) {
				try {
					seat = sc.nextInt();
					if(seat < 1 || seat > 9) {
						throw new Exception();
					}
					break;
				}
				catch(InputMismatchException e) {
					System.out.print("Please enter an integer value: ");
					sc.next();
				}
				catch(Exception e) {
					System.out.print("Please enter a value between 1 and 9: ");
				}
			}
			sectionRow = String.valueOf(row) + String.valueOf(seat);
		}
		if(type != 3) {
			System.out.print("Please input if your ticket is backstage (y/n): ");
			temp = sc.next().charAt(0);
			while(true) {
				if(temp == 'y') {
					backstage = true;
					break;
				}
				else if(temp == 'n') {
					backstage = false;
					break;
				}
				else {
					System.out.print("Please input y or n: ");
					temp = sc.next().charAt(0);
				}
			}
		}
		System.out.print("Please input the name of the event: ");
		while(name.equals("")) {
			name = sc.nextLine();
		}
		if(standing) {
			if(type == 1) {
				Ticket ticket = new Theater(venue,standing,backstage,name);
				ticket.adjustPrice();
				System.out.println("Final ticket price: " + ticket.getPrice());
				System.out.print("Would you like to purchase this ticket? (y/n): ");
				temp = sc.next().charAt(0);
				while(true) {
					if(temp == 'y') {
						tickets.add(ticket);
						break;
					}
					else if(temp == 'n') {
						break;
					}
					else {
						System.out.print("Please input y or n: ");
						temp = sc.next().charAt(0);
					}
				}
			}
			else if(type == 2) {
				Ticket ticket = new Concert(venue,standing,backstage,name);
				ticket.adjustPrice();
				System.out.println("Final ticket price: " + ticket.getPrice());
				System.out.print("Would you like to purchase this ticket? (y/n): ");
				temp = sc.next().charAt(0);
				while(true) {
					if(temp == 'y') {
						tickets.add(ticket);
						break;
					}
					else if(temp == 'n') {
						break;
					}
					else {
						System.out.print("Please input y or n: ");
						temp = sc.next().charAt(0);
					}
				}
			}
			else {
				Ticket ticket = new Sports(venue,standing,name);
				ticket.adjustPrice();
				System.out.println("Final ticket price: " + ticket.getPrice());
				System.out.print("Would you like to purchase this ticket? (y/n): ");
				temp = sc.next().charAt(0);
				while(true) {
					if(temp == 'y') {
						tickets.add(ticket);
						break;
					}
					else if(temp == 'n') {
						break;
					}
					else {
						System.out.print("Please input y or n: ");
						temp = sc.next().charAt(0);
					}
				}
			}
		}
		else {
			if(type == 1) {
				Ticket ticket = new Theater(venue,row,seat,sectionRow,standing,backstage,name);
				ticket.adjustPrice();
				System.out.println("Final ticket price: " + ticket.getPrice());
				System.out.print("Would you like to purchase this ticket? (y/n): ");
				temp = sc.next().charAt(0);
				while(true) {
					if(temp == 'y') {
						tickets.add(ticket);
						break;
					}
					else if(temp == 'n') {
						break;
					}
					else {
						System.out.print("Please input y or n: ");
						temp = sc.next().charAt(0);
					}
				}
			}
			else if(type == 2) {
				Ticket ticket = new Concert(venue,row,seat,sectionRow,standing,backstage,name);
				ticket.adjustPrice();
				System.out.println("Final ticket price: " + ticket.getPrice());
				System.out.print("Would you like to purchase this ticket? (y/n): ");
				temp = sc.next().charAt(0);
				while(true) {
					if(temp == 'y') {
						tickets.add(ticket);
						break;
					}
					else if(temp == 'n') {
						break;
					}
					else {
						System.out.print("Please input y or n: ");
						temp = sc.next().charAt(0);
					}
				}
			}
			else {
				Ticket ticket = new Sports(venue,row,seat,sectionRow,standing,name);
				ticket.adjustPrice();
				System.out.println("Final ticket price: " + ticket.getPrice());
				System.out.print("Would you like to purchase this ticket? (y/n): ");
				temp = sc.next().charAt(0);
				while(true) {
					if(temp == 'y') {
						tickets.add(ticket);
						break;
					}
					else if(temp == 'n') {
						break;
					}
					else {
						System.out.print("Please input y or n: ");
						temp = sc.next().charAt(0);
					}
				}
			}
		}
	}
}
