package fr.facil.facilapi;

import fr.facil.facilapi.collections.Affaire;
import fr.facil.facilapi.collections.Client;
import fr.facil.facilapi.service.affaireService;
import fr.facil.facilapi.service.clientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class FacilapiApplicationTests {

    @Autowired
    private affaireService serviceAffaire;

    @Autowired
    private clientService serviceClient;

    @Test
    void contextLoads() {
        System.out.println("coucou");
    }

    @Test
    public void getAllClient(){

        List<Client> clientList = serviceClient.getallClients();

        System.out.println(clientList.toString());
    }

}
