package src.repository;
import src.domain.Reservation;

import java.util.*;
public class ReservationRepository {
    private List<Reservation> Reservations = new ArrayList<Reservation>();

    public void Save(Reservation reservation){
        Reservations.add(reservation);
    }

    public void remove(Reservation reservation){
        Reservations.remove(reservation);
    }
    public List<Reservation> findByClientId(UUID clientId) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : Reservations) {
            if (r.getClientId().equals(clientId)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<Reservation> findByHotelId(String hotelId) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : Reservations) {
            if (r.getHotelId().equals(hotelId)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<Reservation> getAllreservations() {
        return Reservations;
    }

    public Reservation getReservation(UUID reservationId){
       // remove spaces/newlines
        for (Reservation r : Reservations) {
            if (r.getId().equals(reservationId)) { // also trim stored IDs just in case
                return r;
            }
        }
        return null;
    }


}
