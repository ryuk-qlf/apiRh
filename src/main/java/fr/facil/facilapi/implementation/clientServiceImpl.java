package fr.facil.facilapi.implementation;

import fr.facil.facilapi.collections.Client;
import fr.facil.facilapi.repository.ClientRepository;
import fr.facil.facilapi.service.clientService;
import fr.facil.facilapi.supplement.Managers;
import fr.facil.facilapi.supplement.rAchat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clientServiceImpl implements clientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public List<Client> getallClients() {
        return repository.findAll();
    }

    @Override
    public Client getClientById(String id) {
        return repository.findClientsById(id);
    }

    @Override
    public Client getClientByName(String name) {
        return repository.findClientsByName(name);
    }

    @Override
    public Client addClient(Client client) {
        return repository.save(client);
    }

    @Override
    public void deleteClient(String id) {
        repository.deleteById(id);
    }

    @Override
    public Client updateClient(String id, Client client) {
        client.setId(id);

        return repository.save(client);
    }

    @Override
    public Client addManagers(String id, Managers manager) {
        Client monClient = repository.findClientsById(id);

        monClient.getManagers().add(manager);

        return repository.save(monClient);
    }

    @Override
    public Client addAchat(String id, rAchat achat) {
        Client monClient = repository.findClientsByName(id);

        monClient.getAchat().add(achat);

        return repository.save(monClient);
    }
}
