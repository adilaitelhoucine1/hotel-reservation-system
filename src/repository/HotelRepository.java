package src.repository;

import src.domain.Hotel;

import java.util.List;
import java.util.ArrayList;

public class HotelRepository {
    List<Hotel> Hotels = new ArrayList<Hotel>();


    public void save(Hotel hotel) {
        Hotels.add(hotel);
    }

    public Hotel FindById(String id) {
        for (Hotel hotel : Hotels) {
            if (hotel.getHotelId().equals(id)) {
                return hotel;
            }
        }
        return null;
    }

    public List<Hotel> getAllHotels() {
        return Hotels;
    }

    public void removeHotel(Hotel hotel){
        Hotels.remove(hotel);
    }


}
