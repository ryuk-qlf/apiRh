package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Client;
import fr.facil.facilapi.repository.ClientRepository;
import fr.facil.facilapi.supplement.Achat;
import fr.facil.facilapi.supplement.Managers;
import fr.facil.facilapi.supplement.rAchat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClientRestController {

    @Autowired
    private ClientRepository clientRepository;



    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping(value = "/")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping(value = "/{clientId}")
    public Client getClientById(@PathVariable String ClientId) {
        return clientRepository.findClientsById(ClientId);
    }

    @GetMapping(value = "/find/{clientName}")
    public Client getClientByName(@PathVariable String clientName){
        return clientRepository.findClientsByName(clientName);
    }

    @GetMapping("/managers/{firstname}/{lastname}")
    public Managers getManagerByName(@PathVariable String firstname, @PathVariable String lastname){
        for (Client client:
             this.clientRepository.findAll()) {
            for (Managers manager: client.getManagers()){
                if (manager.getPrenom().equalsIgnoreCase(firstname) && manager.getNom().equalsIgnoreCase(lastname)){
                    return manager;
                }
            }
        }
        return  new Managers(null,null,null,null,null,null,false);
    }

    @GetMapping("/achat/{firstname}/{lastname}")
    public rAchat getAchatByName(@PathVariable String firstname, @PathVariable String lastname){
        for (Client client:
             this.clientRepository.findAll()) {
            for (rAchat achat: client.getAchat()){
                if (achat.getPrenom().equalsIgnoreCase(firstname) && achat.getNom().equalsIgnoreCase(lastname)){
                    return achat;
                }
            }
        }
        return  new rAchat(null,null,null,null,false);
    }

    @PostMapping(value = "/create")
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping(value = "/delete/{clientId}")
    public void deleteClient(@PathVariable String clientId) {
        clientRepository.deleteById(clientId);
    }

    @PutMapping(value = "/update/{clientId}")
    public Client updateClient(@PathVariable String clientId, @RequestBody Client client) {

        client.setId(clientId);

        return clientRepository.save(client);
    }

    @PutMapping(value = "/add/managers/{clientId}")
    public Client addManagers(@PathVariable String clientId, @RequestBody Managers managers){
        Client monClient = clientRepository.findClientsById(clientId);

        monClient.getManagers().add(managers);

        return clientRepository.save(monClient);
    }

    @PutMapping(value = "/add/achat/{clientId}")
    public Client addAchats(@PathVariable String clientId, @RequestBody rAchat achat){
        Client monClient = clientRepository.findClientsByName(clientId);

        monClient.getAchat().add(achat);

        return clientRepository.save(monClient);
    }

}
