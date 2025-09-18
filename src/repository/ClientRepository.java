package src.repository;

import src.domain.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private static List<Client> Clients = new ArrayList<Client>();


    public void save(Client client) {
        Clients.add(client);
    }

    public Client findByEmail(String email) {
        for (Client c : Clients) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    public List<Client> GetAllClients() {
        return Clients;

    }


}
