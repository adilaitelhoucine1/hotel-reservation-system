package src.service;

import src.domain.Client;
import src.domain.Hotel;
import src.domain.Reservation;
import src.repository.HotelRepository;
import src.repository.ReservationRepository;

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
}
