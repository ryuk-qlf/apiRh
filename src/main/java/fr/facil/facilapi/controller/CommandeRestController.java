package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Affaire;
import fr.facil.facilapi.collections.Commande;
import fr.facil.facilapi.repository.AffaireRepository;
import fr.facil.facilapi.repository.CommandeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/commande")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommandeRestController {

    @Autowired
    private CommandeRepository cmdRepo;

    @Autowired
    private AffaireRepository affRepo;

    @GetMapping(value = "/")
    public List<Commande> getAllCommandes() {
        return cmdRepo.findAll();
    }

    @GetMapping(value = "/{commandeId}")
    public Commande getCommandeById(@PathVariable String commandeId) {
        return cmdRepo.findCommandeById(commandeId);
    }

    @GetMapping(value = "/numero/{numero}")
    public Commande getOneByNumero(@PathVariable String numero){

        return cmdRepo.findCommandeByNumero(numero);
    }



   @GetMapping(value = "/fini")
   public List<Commande> getOneSoon(){

        List<Commande> soonCommande = new ArrayList<>();

        for (Commande cmd: this.cmdRepo.findAll()){

            Date dateCmd = null;

            try{
                dateCmd = new SimpleDateFormat("yyyyMMdd").parse(cmd.getDate_fin_commande());
            }catch(Exception e){
                e.printStackTrace();
            }

            Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

            logger.info(String.valueOf(dateCmd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));
            logger.info(String.valueOf(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()));

            if (ChronoUnit.DAYS.between(dateCmd.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) < 15){
                soonCommande.add(cmd);
            }

        }



        return soonCommande;
   }

    @PostMapping(value = "/create")
    public Commande addCommande(@RequestBody Commande cmd) {
        return cmdRepo.save(cmd);
    }

    @DeleteMapping(value = "/delete/{cmdId}")
    public void deleteCommande(@PathVariable String cmdId) {
        cmdRepo.deleteById(cmdId);
    }

    @PutMapping(value = "/update/{cmdId}")
    public Commande updateCommande(@PathVariable String cmdId, @RequestBody Commande cmd) {

        cmd.setId(cmdId);

        return cmdRepo.save(cmd);
    }

}
