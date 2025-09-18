package src;

import src.domain.Client;
import src.repository.HotelRepository;
import src.repository.ReservationRepository;
import src.service.AuthService;
import src.service.HotelService;
import src.service.ReservationService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HotelRepository hotelRepository = new HotelRepository();
        ReservationRepository reservationRepository = new ReservationRepository();

        AuthService authService = new AuthService();
        HotelService hotelService = new HotelService(hotelRepository);
        ReservationService reservationService = new ReservationService(hotelRepository, reservationRepository);
        authService.addAdminAccount("admin@java", "admin123");
        boolean running = true;


        while (running) {


            Client currentUser = authService.getLoggedInClient();

            System.out.println("\n=== Hotel Reservation System ===");

            if (currentUser == null) {

                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1 -> authService.register(sc);
                    case 2 -> authService.login(sc);
                    case 0 -> running = false;
                    default -> System.out.println(" Invalid choice!");
                }

            } else {
                // Logged-in menu
                System.out.println("Logged in as: " + currentUser.getFullName());


                if (currentUser.getEmail().equals("admin@java") && currentUser.getPassword().equals("admin123")) {

                    // Admin menu
                    System.out.println("1. Create Hotel");
                    System.out.println("2. List Hotels");
                    System.out.println("3. Logout");
                    System.out.println("0. Exit");
                    System.out.print("Choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1 -> hotelService.createHotel(sc, currentUser);
                        case 2 -> hotelService.listHotels();
                        case 3 -> authService.logout();
                        case 0 -> running = false;
                        default -> System.out.println("Invalid choice!");
                    }

                } else {
                    //  Client Menu
                    System.out.println("1. List Hotels");
                    System.out.println("2. Book Room");
                    System.out.println("3. Cancel Reservation");
                    System.out.println("4. Reservation History");
                    System.out.println("5. Logout");
                    System.out.println("0. Exit");
                    System.out.print("Choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1 -> hotelService.listHotels();
                        case 2 -> reservationService.bookRoom(sc, currentUser);
                        case 3 -> reservationService.cancelReservation(sc, currentUser);
                        case 4 -> reservationService.showHistory(currentUser);
                        case 5 -> authService.logout();
                        case 0 -> running = false;
                        default -> System.out.println(" Invalid choice!");
                    }

                }
            }
        }

        sc.close();
    }
}
