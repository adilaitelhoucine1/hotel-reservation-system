package src.service;

import src.domain.Client;
import src.domain.Hotel;
import src.domain.Reservation;
import src.repository.HotelRepository;
import src.repository.ReservationRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservationService {

    private ReservationRepository  reservationRepository=new ReservationRepository();
    private HotelRepository hotelRepository= new HotelRepository() ;
    private Hotel hotel;
    private Reservation reservation;


    public ReservationService(HotelRepository hotelRepository, ReservationRepository reservationRepository) {
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
    }
    public void bookRoom(Scanner sc, Client currentUser){
        System.out.println("Entrer ID de hotel");
        String hotelId=sc.nextLine();
        System.out.println("Entrer ID nombre de nuits");
        int nb_nights=sc.nextInt();
        hotel =hotelRepository.FindById(hotelId);
        if(hotel!=null){
            reservation=new Reservation(hotelId,currentUser.getID(),nb_nights);
            reservationRepository.Save(reservation);
            hotel.setavAilableRooms(hotel.getAvailableRooms()-1);
        }else{
            System.out.println("Aucune chambre a reserve");
        }

    }

   public void  cancelReservation(Scanner sc, Client currentUser){
       System.out.println("Entrer Id de reservaion ");
       String reservationId=sc.nextLine();
       reservation=reservationRepository.getReservation(reservationId);
       if(!reservation.getClientId().equals(currentUser.getID())){
           System.out.println("c est pas votre reservation");
       }else{
           reservationRepository.remove(reservation);
           hotel =hotelRepository.FindById(reservation.getHotelId());
           hotel.setavAilableRooms(hotel.getAvailableRooms()+1);
       }
    }

    public void showHistory(Client currentUser) {
        List<Reservation> reservations = reservationRepository.getAllreservations();

        System.out.println("\n=== Historique des Réservations ===");

        for (Reservation r : reservations) {
            // Optionally filter only the logged-in user's reservations
            if (!r.getClientId().equals(currentUser.getID())) {
                continue;
            }

            Hotel hotel = hotelRepository.FindById(r.getHotelId());
            String hotelName = (hotel != null) ? hotel.getName() : "Unknown Hotel";

            String clientName = currentUser.getFullName();

            System.out.println("---------------------------------------------------");
            System.out.println("Reservation ID : " + r.getId());
            System.out.println("Client         : " + clientName);
            System.out.println("Hotel          : " + hotelName);
            System.out.println("Nuits          : " + r.getNights());
            System.out.println("Date           : " + r.getTimestamp());
        }
    }

}
