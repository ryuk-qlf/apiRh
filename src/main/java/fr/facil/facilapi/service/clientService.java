package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.Client;
import fr.facil.facilapi.supplement.Managers;
import fr.facil.facilapi.supplement.rAchat;

import java.util.List;

public interface clientService {

    List<Client> getallClients();

    Client getClientById(String id);

    Client getClientByName(String name);

    Client addClient(Client client);

    void deleteClient(String id);

    Client updateClient(String id, Client client);

    Client addManagers(String id, Managers manager);

    Client addAchat(String id, rAchat achat);
}
