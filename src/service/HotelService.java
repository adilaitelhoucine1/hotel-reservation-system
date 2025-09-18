package src.service;

import src.domain.Client;
import src.domain.Hotel;
import src.repository.HotelRepository;
import src.service.AuthService;
import java.util.List;
import java.util.Scanner;

public class HotelService {
    private HotelRepository  hotelRepository= new HotelRepository() ;
    private Hotel hotel;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }




    public void listHotels(){
        List<Hotel> hotels=hotelRepository.getAllHotels();
        System.out.println("\n=== Liste des Hôtels ===");
        System.out.printf("%-10s %-20s %-30s %-10s %-5s%n", "ID", "Nom", "Adresse", "Chambres", "Note");
        System.out.println("---------------------------------------------------------------------------");

        if (hotels.isEmpty()) {
            System.out.println("Aucun hôtel disponible.");
        } else {
            for (Hotel hotel : hotels) {
                System.out.printf("%-10s %-20s %-30s %-10s %-5s%n",
                        hotel.getHotelId(),
                        hotel.getName(),
                        hotel.getAdresse(),
                        hotel.getAvailableRooms(),
                        hotel.getRating());
            }



        }
    }

    public void createHotel(Scanner sc, Client currentUser){

        System.out.println(currentUser.getFullName());

        System.out.println("\n=== Création d'un nouvel Hôtel ===");

        System.out.print("Entrer l'ID de l'hôtel : ");
        String hotelId = sc.nextLine();

        System.out.print("Entrer le nom de l'hôtel : ");
        String name = sc.nextLine();

        System.out.print("Entrer l'adresse de l'hôtel : ");
        String address = sc.nextLine();

        System.out.print("Entrer le nombre de chambres disponibles : ");
        int availableRooms = sc.nextInt();

        System.out.print("Entrer la note de l'hôtel : ");
        Double rating = sc.nextDouble();
        hotel = new Hotel(hotelId,name,address,availableRooms,rating);
        hotelRepository.save(hotel);
        System.out.println("Hotel cree avec succes");
    }
}
