package src.service;

import src.domain.Client;
import src.repository.ClientRepository;

import java.util.Scanner;
public class AuthService {
    private  ClientRepository clientRepository = new ClientRepository();
    private Client loggedInClient;

    public void register(Scanner sc) {

        System.out.println("Entrer votre Nom");
        String userName = sc.nextLine();
        System.out.println("Entrer votre email");
        String email = sc.nextLine();
        System.out.println("Entrer votre mot de passe");
        String password = sc.nextLine();
        if (!isValidEmail(email)) {
            System.out.println(" Format d'email invalide. Exemple: Youcode@java.com");
            return;
        }
        loggedInClient = new Client(userName, email, password);
        if (clientRepository.findByEmail(loggedInClient.getEmail()) != null) {
            System.out.println("Cet email deja existe");
            return;
        } else {
            clientRepository.save(loggedInClient);
        }

    }

    public void login(Scanner sc) {
        System.out.println("Entrer Votre email");
        String email = sc.nextLine();
        System.out.println("Entrer Votre Mots de passe");
        String password = sc.nextLine();
        Client foundClient = clientRepository.findByEmail(email);
        if (foundClient == null) {
            System.out.println("Aucun utilisateur avec cet email");
        } else {
            if (!foundClient.getPassword().equals(password)) {
                System.out.println("Le mot de passe in incorrect");
            } else {
                loggedInClient = foundClient;
                System.out.println("Bienvenue " + foundClient.getFullName());
            }
        }

    }

public  void logout(){
        loggedInClient=null;
}
    public Client getLoggedInClient() {
        return loggedInClient;
    }



    public void addAdminAccount(String email, String password) {
        Client admin = new Client("Admin", email, password);
        clientRepository.save(admin);
    }


    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}
