package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Affaire;
import fr.facil.facilapi.collections.Devis;
import fr.facil.facilapi.repository.DevisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/devis")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DevisRestController {

    @Autowired
    private DevisRepository repository;

    @GetMapping("")
    public List<Devis> getDevis() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Devis getDevisById(@PathVariable String id) {
        return repository.findDevisById(id);
    }

    @GetMapping("/num/{num}")
    public Devis getDevisByNum(@PathVariable String num) {
        return repository.findDevisByNum(num);
    }

    @GetMapping("/{id}/affaires")
    public List<Devis> getDevisByIdAffaire(@PathVariable String id) {

        List<Devis> devisList = repository.findAll();
        List<Devis> devisListA = new ArrayList<>();

        for (Devis devis : devisList){
            assert devis.getAffaire() != null;
            if (devis.getAffaire().getId().equalsIgnoreCase(id)){
                devisListA.add(devis);
            }
        }

        return devisListA;
    }

    @PostMapping("")
    public Devis createDevis(@RequestBody Devis devis){
        return repository.save(devis);
    }

    @DeleteMapping("/{id}")
    public Devis deleteDevis(@PathVariable String id){
        Devis devis = repository.findDevisById(id);

        devis.setActive(false);

        return repository.save(devis);
    }

    @PatchMapping("/affaire/{id}")
    public Devis addAffaireDevis(@PathVariable String id, @RequestBody Affaire affaire){
        Devis devis = repository.findDevisById(id);

        devis.setAffaire(affaire);

        return repository.save(devis);
    }

}
