package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Autorisation_BL;
import fr.facil.facilapi.collections.BL;
import fr.facil.facilapi.repository.AutorisationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorisation_bl")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AutorisationRestController {

    @Autowired
    private AutorisationRepository autorRep;


    @GetMapping(value = "/")
    public List<Autorisation_BL> getAllAutorisations() {
        return autorRep.findAll();
    }

    @GetMapping(value = "/{autoId}")
    public Autorisation_BL getAutorisationById(@PathVariable String autoId) {
        return autorRep.getAutorisationById(autoId);
    }

    @GetMapping(value = "/getbybl")
    public Autorisation_BL getAutorisationByBl(@RequestBody BL objetc) {

        return autorRep.getAutorisationByBL(objetc);
    }

    @PostMapping(value = "/create")
    public Autorisation_BL addAutorisation(@RequestBody Autorisation_BL autor) {
        return autorRep.save(autor);
    }

    @DeleteMapping(value = "/delete/{autorId}")
    public void deleteAutorisation(@PathVariable String autorId) {
        autorRep.deleteById(autorId);
    }

    @PutMapping(value = "/update/{autorId}")
    public Autorisation_BL updateAutorisation(@PathVariable String autorId, @RequestBody Autorisation_BL autor) {

        autor.setId(autorId);

        return autorRep.save(autor);
    }

}
