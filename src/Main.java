package src;

import src.domain.Client;
import src.service.AuthService;
import src.service.HotelService;
import src.service.ReservationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize services
        AuthService authService = new AuthService();
        HotelService hotelService = new HotelService();
        ReservationService reservationService = new ReservationService();

        boolean running = true;

        while (running) {
            Client currentUser = authService.getLoggedInClient();

            System.out.println("\n=== Hotel Reservation System ===");

            if (currentUser == null) {
                // Guest menu
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> authService.register(sc);
                    case 2 -> authService.login(sc);
                    case 0 -> running = false;
                    default -> System.out.println("❌ Invalid choice!");
                }

            } else {
                // Logged-in menu
                System.out.println("Logged in as: " +/* currentUser.getFullName()*/ "adil");
                System.out.println("1. List Hotels");
                System.out.println("2. Create Hotel");
                System.out.println("3. Book Room");
                System.out.println("4. Cancel Reservation");
                System.out.println("5. Reservation History");
                System.out.println("6. Logout");
                System.out.println("0. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

//                switch (choice) {
//                    case 1 -> hotelService.listHotels();
//                    case 2 -> hotelService.createHotel(sc);
//                    case 3 -> reservationService.bookRoom(sc, currentUser);
//                    case 4 -> reservationService.cancelReservation(sc, currentUser);
//                    case 5 -> reservationService.showHistory(currentUser);
//                    case 6 -> authService.logout();
//                    case 0 -> running = false;
//                    default -> System.out.println("❌ Invalid choice!");
//                }
            }
        }

        System.out.println("👋 Goodbye!");
        sc.close();
    }
}
