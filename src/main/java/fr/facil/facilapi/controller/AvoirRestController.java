package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Avoir;
import fr.facil.facilapi.repository.AvoirRepository;
import fr.facil.facilapi.service.avoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avoirs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AvoirRestController {

    @Autowired
    private avoirService Service;

    @Autowired
    private AvoirRepository repository;

    @GetMapping(value = "/")
    public List<Avoir> getAllAvoir() {
        return this.Service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Avoir getAvoirById(@PathVariable String id) {
        return this.repository.findAvoirById(id);
    }

    @GetMapping(value = "/facture/{numero}")
    public Avoir getAvoirByFactureNumero(@PathVariable String numero){
        return this.Service.findOneByFacture_Numero(numero);
    }

    @PostMapping(value = "/")
    public Avoir createAvoir(@RequestBody Avoir avoir){
        return this.Service.createOne(avoir);
    }

    @GetMapping(value = "/client/{name}")
    public List<Avoir> getAvoirsByClientName(@PathVariable String name){
        return this.Service.findAllByClientName(name);
    }

}
