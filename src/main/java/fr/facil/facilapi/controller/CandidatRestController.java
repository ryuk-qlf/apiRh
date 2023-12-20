package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Candidat;
import fr.facil.facilapi.repository.CandidatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidat")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CandidatRestController {

    @Autowired
    private CandidatRepository CandidatRepository;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping(value= "/")
    public List<Candidat> getAllCandidat(){
        return CandidatRepository.findAll();
    }

    @GetMapping(value= "/{blId}")
    public Candidat getCandidatById(@PathVariable String blId){
        return CandidatRepository.findCandidatById(blId);
    }

    @PostMapping(value = "/create")
    public Candidat addCandidat(@RequestBody Candidat cand) {
        return CandidatRepository.save(cand);
    }

    @DeleteMapping(value = "/delete/{CandidatId}")
    public void deleteCandidat(@PathVariable String CandidatId) {
        CandidatRepository.deleteById(CandidatId);
    }

    @PutMapping(value = "/update/{CandidatId}")
    public Candidat updateCandidat(@PathVariable String CandidatId, @RequestBody Candidat cand) {

        cand.setId(CandidatId);

        return CandidatRepository.save(cand);
    }

    /*@PostMapping(value = "/updateState/{blId}")
    public BL updateStatBl(@PathVariable String blId, @RequestBody State_bl st) {

        BL bl = blRepository.findBlById(blId);

        bl.setId(blId);
        bl.setEtat(st);

        return blRepository.save(bl);
    }*/

}
