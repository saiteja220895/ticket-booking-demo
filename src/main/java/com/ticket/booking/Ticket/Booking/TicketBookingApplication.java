package com.ticket.booking.Ticket.Booking;

import com.ticket.booking.Ticket.Booking.Entity.User;
import com.ticket.booking.Ticket.Booking.Service.UserBookingService;
import com.ticket.booking.Ticket.Booking.Util.UserServiceUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

@SpringBootApplication
public class TicketBookingApplication {

	public static void main(String[] args) {
		System.out.println("Running train booking system");
		Scanner scanner = new Scanner(System.in);
		int option=0;
		UserBookingService userBookingService;
		try {
			userBookingService = new UserBookingService();
		}
		catch (IOException ex){
			System.out.println("There is something wrong");
			return;
		}
		while(option != 7){
			System.out.println("Choose option");
			System.out.println("1. Sign Up");
			System.out.println("2. Login");
			System.out.println("3. Fetch Bookings");
			System.out.println("4. Search trains");
			System.out.println("5. Book a seat");
			System.out.println("6. cancel my booking");
			System.out.println("7. Exit the app");
			option = scanner.nextInt();
			switch (option){


				case 2:
					System.out.println("Enter the username to login");
					String nameToLogin = scanner.next();
					System.out.println("Enter the password to Login");
					String passwordLogin = scanner.next();
					User userToLogin = new User(nameToLogin, passwordLogin,
							UserServiceUtil.hashPassword(passwordLogin),
							new ArrayList<>(), UUID.randomUUID().toString());
					try {
						userBookingService = new UserBookingService(userToLogin);
					}catch (IOException ex){
						return;
					}
					break;

				case 3:
					System.out.println("Fetching your bookings");
					userBookingService.fetchBooking();
					break;


			}
		}
	}

}
