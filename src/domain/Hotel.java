package src.domain;

public class Hotel {
   private String hotelId;
   private String name;
   private String address;
   private int availableRooms;
   private Double rating;

   public Hotel(String hotelId,String name, String address,int availableRooms ,Double rating ){
    this.hotelId=hotelId;   
    this.name=name;
    this.address=address;
    this.availableRooms=availableRooms;
    this.rating=rating;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
   }
   public String getHotelId(){
         return this.hotelId;
   }
   public String  getName(){
     return this.name;
   }
   public String getAdresse(){
        return this.address;
   } 
   public int getAvailableRooms(){
     return this.availableRooms;
   }
public Double getRating(){
    return this.rating;
}

    public static class AuthService {

    }
}
