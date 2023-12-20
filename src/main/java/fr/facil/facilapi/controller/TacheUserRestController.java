package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.TacheUser;
import fr.facil.facilapi.repository.TacheUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tacheuser")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TacheUserRestController {

    @Autowired
    private TacheUserRepository tur;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping(value = "/")
    public List<TacheUser> getAllTache() {
        return tur.findAll();
    }

    @GetMapping(value = "/{tacheUId}")
    public TacheUser getTacheUserById(@PathVariable String tacheUId){
        return tur.findTacheUserById(tacheUId);
    }

    @PostMapping(value = "/create")
    public TacheUser addTacheUser(@RequestBody TacheUser tu){
        return tur.save(tu);
    }

    @DeleteMapping(value = "/delete/{tacheUId}")
    public void deleteTacheUser(@PathVariable String tacheUId){
        tur.deleteById(tacheUId);
    }

    @PutMapping(value = "/update/{tacheUId}")
    public TacheUser updateTacheUser(@PathVariable String tacheUId, @RequestBody TacheUser tu){
        tu.setId(tacheUId);

        return tur.save(tu);
    }


}
