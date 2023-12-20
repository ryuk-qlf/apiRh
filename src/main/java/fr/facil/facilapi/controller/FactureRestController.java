package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Facture;
import fr.facil.facilapi.collections.Log;
import fr.facil.facilapi.repository.FactureRepository;
import fr.facil.facilapi.supplement.Last;
import fr.facil.facilapi.supplement.returnObject;
import fr.facil.facilapi.type.paiement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/factures")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FactureRestController {

    @Autowired
    private FactureRepository FactureRepository;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping(value = "/")
    public List<Facture> getAllFactures() {
        return FactureRepository.findAll();
    }

    @GetMapping(value = "/{FactureID}")
    public Facture getFactureById(@PathVariable String FactureID) {
        return FactureRepository.findFactureById(FactureID);
    }

    @GetMapping(value = "/numero/{numero}")
    public Facture getFactureByNumero(@PathVariable String numero){
        return FactureRepository.findFactureByNumero(numero);
    }

    @GetMapping(value = "/facture/allinmonth/{month}/{year}")
    public List<Facture> getFacturesAllInMonth(@PathVariable int month, @PathVariable int year){
        List<Facture> mesFactures = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        for (Facture uneFacture : FactureRepository.findAll()){
            Date dateOneMonth = null;
            Date dateLastMonth = null;

            Date dateFacture = null;

            try{
                dateFacture = new SimpleDateFormat("yyyyMMdd").parse(uneFacture.getDateCreated());

                c.set(year, month-1, 1);

                dateOneMonth = c.getTime();

                c.set(year, month, 0);

                dateLastMonth = c.getTime();
                if (dateFacture.after(dateOneMonth) && dateFacture.before(dateLastMonth)){
                    mesFactures.add(uneFacture);
                }


            }catch(Exception e){
                e.printStackTrace();
            }


        }

        return mesFactures;
    }



    @PostMapping(value = "/create")
    public Facture addFacture(@RequestBody Facture facture) {
        return FactureRepository.save(facture);
    }

    @DeleteMapping(value = "/delete/{factureId}")
    public void deleteFacture(@PathVariable String factureId) {
        FactureRepository.deleteById(factureId);
    }

    @PutMapping(value = "/update/{factureId}")
    public Facture updateFacture(@PathVariable String factureId, @RequestBody Facture facture) {

        facture.setId(factureId);

        return FactureRepository.save(facture);
    }

    @PatchMapping(value = "/add/log/{factureNumero}")
    public Facture addLog(@PathVariable String factureNumero, @RequestBody Log log){

        Facture uneFacture = FactureRepository.findFactureByNumero(factureNumero);

        uneFacture.getLogs().add(log);

        return FactureRepository.save(uneFacture);
    }

    @PatchMapping(value = "/status/update/{status}/{factureNumero}")
    public Facture updateStatus(@PathVariable String status, @PathVariable String factureNumero){

        Facture uneFacture = FactureRepository.findFactureByNumero(factureNumero);

        uneFacture.setPaiement(paiement.valueOf(status));
        uneFacture.setActive(false);

        return FactureRepository.save(uneFacture);

    }

    @GetMapping(value = "/last")
    public Last getLastFacture(){

        List<Facture> factures = this.FactureRepository.findAll();
        List<Integer> inte = new ArrayList<Integer>();

        for (Facture facture: factures){
            inte.add(Integer.valueOf(facture.getNumero()));
        }

        if (factures.isEmpty()){
            return new Last(1);
        }

        return new Last(Collections.max(inte) +1);

    }

    @GetMapping("/payment")
    public List<Facture> getFacturePayement() throws ParseException {
        List<Facture> factures = this.FactureRepository.findAll();
        List<Facture> facturesFilter = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        for (Facture fact: factures){
            if (fact.isActive()){

                Date date = dateFormat.parse(fact.getDateEcheance());
                Date dateNow = new Date();
                if (dateNow.before(date)){
                    if (fact.getPaiement() == paiement.SEND){
                        facturesFilter.add(fact);
                    }
                }
            }
        }

        return facturesFilter;
    }

    @GetMapping("/echu")
    public List<Facture> getFactureE() throws ParseException {
        List<Facture> factures = this.FactureRepository.findAll();
        List<Facture> facturesFilter = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        for (Facture fact: factures){
            if (fact.isActive()){

                Date date = dateFormat.parse(fact.getDateEcheance());
                Date dateNow = new Date();
                if (dateNow.after(date)){
                    if (fact.getPaiement() == paiement.SEND){
                        facturesFilter.add(fact);
                    }
                }
            }
        }

        return facturesFilter;
    }

    @PatchMapping(value = "/devis/{numero}")
    public Facture setAvoir(@PathVariable String numero){

        Facture uneFacture = FactureRepository.findFactureByNumero(numero);

        uneFacture.setActive(false);
        uneFacture.setPaiement(paiement.AVOIR);

        return FactureRepository.save(uneFacture);
    }

    @GetMapping(value = "/client/{nameClient}")
    public returnObject getFactureInClient(@PathVariable String nameClient) throws ParseException {

        double montant = 0.00;

        Date dateNow = new Date();

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        for(Facture facture: this.FactureRepository.findAll()){


            if (facture.getCommande().getClient().getName().equalsIgnoreCase(nameClient)){
                if (facture.getPaiement() == paiement.WAITTING){
                    Date dateFacture = dateFormat.parse(facture.getDateCreated());

                    if (dateFacture.getMonth() == dateNow.getMonth()){

                        montant += facture.getMontant();

                    }
                }
            }


        }


        return new returnObject(montant);
    }
}
