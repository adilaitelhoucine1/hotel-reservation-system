import java.util.UUID;
public class Client {
     private UUID id;
     private String fullname;
     private String email;
     private String password;

     public Client(String fullname, String email,String password){
        this.id=UUID.randomUUID();
        this.fullname=fullname;
        this.email=email;
        this.password=password;
     }
      public UUID getID(){
        return this.id;
      }
      public String getFullName(){
        return this.fullname;
      }
      public String getEmail(){
        return this.email;
      }
      public String getPassword(){
        return this.password;
      }
}
