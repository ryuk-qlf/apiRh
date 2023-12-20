package fr.facil.facilapi.controller;


import fr.facil.facilapi.collections.Ressource_Humaine;
import fr.facil.facilapi.collections.User;
import fr.facil.facilapi.collections.jourTravail;
import fr.facil.facilapi.repository.JourDeTravailRepository;
import fr.facil.facilapi.repository.UserRepository;
import fr.facil.facilapi.service.JourDeTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/jdt")
public class JourDeTravailController {

    @Autowired
    private JourDeTravailRepository jourTravailRepo ;
    @Autowired
    private JourDeTravailService jourDeTravailService ;
    @Autowired
    private UserRepository userRepository ;



    public JourDeTravailController() {
    }


    @GetMapping(value = "/")
    public List<jourTravail> getJoursDetravail() {
        return  this.jourDeTravailService.findAll();
    }

    @GetMapping(value = "/{IdJourTravail}")
    public jourTravail getJourTravail(@PathVariable Integer IdJourTravail) {
        return this.jourDeTravailService.findByOne(IdJourTravail);
    }

    @GetMapping(value = "/findByRh")
    public jourTravail findjourtravailByRh(@RequestBody Ressource_Humaine rh){
        return this.jourDeTravailService.findjourtravailByRh(rh);
    }
    @PostMapping(value = "/putDemiJourneePresence")
    public void putDemiJourneePresence(@RequestBody String username, @RequestBody boolean matin, @RequestBody boolean apresMidi,@RequestBody jourTravail jTravail){
            if(this.getJourTravail(jTravail.getId()) == null){
             createJTravail(jTravail);
            }
            //jTravail=this.jourDeTravailService.findjourTravailByList((List<jourTravail>) this.getJourTravail(jTravail.getId()));
            jTravail.setPresenceMatin(matin);
            jTravail.setPresenceApresMidi(apresMidi);
            User user= this.userRepository.findUserByUsername(username);
            user.addjTravail(jTravail);
    }

    @GetMapping(value="/createJTravail")
    public jourTravail createJTravail(@RequestBody  jourTravail jTravail) {
       return this.jourTravailRepo.save(jTravail);
    }

    @PutMapping(value = "/chercherNbJours")
    public int [] obtenirJourTravail(Date uneDate )
    {

        return new int[0];
    }

    @GetMapping(value = "/getJourDeTravailBy/{username}/{Date}")
   public int[][] getJourDeTravailParUsernameEtParDate(@PathVariable  String username, @PathVariable Date uneDate){
        int[][] monTableauDeMatricePresence= new int[6][5];
        initArrayWithZero(monTableauDeMatricePresence);
       List<jourTravail> joursDeTravail  =   this.userRepository.findUserByUsername(username).getJoursDeTravail();
        joursDeTravail.forEach((jT)->{if(jT.getMois()+1==uneDate.getMonth())
            for (int i = 0; i < monTableauDeMatricePresence.length; i++) {
                for (int j = 0; j < monTableauDeMatricePresence[i].length; j++) {
                monTableauDeMatricePresence[i][j]=1;
                }
            }});

        return monTableauDeMatricePresence;
    }
    public void initArrayWithZero(int tab[][]){
        for (int i=0 ; i<tab.length ; i++){
            for(int j=0 ; j<tab[i].length ; j++){
                tab[i][j]=0 ;
            }
        }
    }
}

