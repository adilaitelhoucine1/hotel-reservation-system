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
        loggedInClient = new Client(userName, email, password);
        if (clientRepository.findByEmail(loggedInClient) != null) {
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
        Client clientTemp = new Client("", email, password);
        Client foundClient = clientRepository.findByEmail(clientTemp);
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

}
