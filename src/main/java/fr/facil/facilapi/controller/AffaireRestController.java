package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.*;
import fr.facil.facilapi.repository.AffaireRepository;
import fr.facil.facilapi.service.affaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/affaires")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AffaireRestController {

    @Autowired
    private AffaireRepository affaireRepository;
    @Autowired
    private affaireService Service;


    @CrossOrigin(origins = {"http://localhost:8100", "http://localhost:8080"})
    @GetMapping(value = "/")
    public List<Affaire> getAllAffaires() {
        return this.Service.findAll();
    }

    @GetMapping(value = "/{affaireId}")
    public Affaire getAffaireById(@PathVariable String affaireId) {
        return this.Service.findOneById(affaireId);
    }
    
    @GetMapping(value = "/findallcollab")
    public List<Ressource_Humaine> getAllCollab() {
        return this.Service.findAllCollab();
    }

    @GetMapping(value = "/findbyclient/{name}")
    public List<Affaire> getAffaireByClient_Name(@PathVariable String name) {
        return this.Service.findAllByClient_Name(name);
    }

    @GetMapping(value = "/findbycollabactive/{id}")
    public Affaire getAffaireByClient_Id(@PathVariable String id) {
        return this.Service.findOneByCollab_Id(id);
    }

    @GetMapping(value = "/findbycollab")
    public List<Affaire> getAffairesByRh(@RequestBody Ressource_Humaine rh) {
        return this.Service.findAllByRh(rh);
    }

    @GetMapping(value = "/findbyid/{id}")
    public List<Affaire> getAffairesByRh_Id(@PathVariable String id) {
        return this.Service.findAllByRh_Id(id);
    }

    @GetMapping(value = "/ref/{affaireRef}")
    public Affaire getAffaireByRef(@PathVariable String affaireRef) {
        return this.Service.findOneByReference(affaireRef);
    }

    @GetMapping(value = "/commande/")
    public Affaire getAffaireByCommande(@RequestBody Commande commande){
        return this.Service.findOneByCommande(commande);
    }

    @GetMapping(value = "/commande/not/plus")
    public List<Affaire> getAllNotCommandePlus() throws ParseException {
        return this.Service.findAllHaveNotCommandePlus();
    }

    @GetMapping(value = "/commande/not")
    public List<Affaire> getAllNotCommande() throws ParseException {
        return this.Service.findAllHaveNotCommande();
    }

    @GetMapping(value = "/commande/not/plus/plus")
    public List<Affaire> getAllNotCommandePlusPlus() throws ParseException {
        return this.Service.findAllHaveNotCommandePlusPlus();
    }

    @GetMapping(value = "/commande/last")
    public List<Affaire> getAllCommandeActive(){
        return this.Service.findAllCommandeActive();
    }

    @GetMapping(value = "/bl/{id}")
    public List<BL> getAllBl(@PathVariable String id){
        return this.Service.findAllBlInAffaire(id);
    }

    @GetMapping(value = "/facture/{id}")
    public List<Facture> getAllFacture(@PathVariable String id){
        return this.Service.findAllFactureInAffaire(id);
    }

    @GetMapping(value = "/facture/all")
    public List<Facture> getAllFactureInAllAffaire(){
        return this.Service.findAllFactureInAllFacture();
    }

    @GetMapping(value = "/bl/all")
    public List<BL> getAllBlInAllAffaire(){
        return this.Service.findAllBlInAllAffaire();
    }

    @GetMapping(value = "/facture/get/{name}")
    public Facture getAffaireByFactureName(@PathVariable String name){
        return this.Service.findOneByNameFacture(name);
    }

    @GetMapping(value = "/bl/get/{name}")
    public BL getAffaireByBlName(@PathVariable String name){
        return this.Service.findOneByNameBl(name);
    }

    @PostMapping(value = "/create")
    public Affaire addAffaire(@RequestBody Affaire affaire) {
        return affaireRepository.save(affaire);
    }

    @DeleteMapping(value = "/delete/{affaireId}")
    public void deleteAffaire(@PathVariable String affaireId) {
        this.Service.deleteOne(affaireId);
    }

    @PutMapping(value = "/update/{affaireId}")
    public Affaire updateAffaire(@PathVariable String affaireId, @RequestBody Affaire affaire) {
        return this.Service.updateOne(affaireId, affaire);
    }

    @PutMapping(value = "/relance/add/{id}")
    public Affaire addRelance(@PathVariable String id, @RequestBody Relance relance){
        return this.Service.addRelance(id, relance);
    }

    @PutMapping(value = "/facture/add/{id}")
    public Affaire addFacture(@PathVariable String id, @RequestBody Facture facture){
        return this.Service.addFacture(id, facture);
    }

    @PatchMapping(value = "/facture/status/update/{status}/{factureNumero}")
    public Facture updateFacture(@PathVariable String status, @PathVariable String factureNumero){
        return this.Service.updateFacture(status, factureNumero);
    }

    @PutMapping(value = "/bl/add/{id}")
    public Affaire addBl(@PathVariable String id, @RequestBody BL bl){
        return this.Service.addBl(id, bl);
    }

    @PatchMapping(value = "/bl/status/update/change/{blNumero}")
    public BL updateBl(@PathVariable String blNumero, @RequestBody BL bl){
        return this.Service.updateBl(blNumero, bl);
    }


    @PutMapping(value="/addHour/{lastName}/{firstName}")
    public List<Affaire> addHour(@PathVariable String lastName, @PathVariable String firstName, @RequestBody Ressource_Humaine rs){
        return this.Service.updateAllDayOfCollab(lastName, firstName, rs);
    }

    @GetMapping(value="/note/{affaireId}")
    public List<Note> getNote(@PathVariable String affaireId){
        return this.Service.getNote(affaireId);
    }

    @PostMapping(value="/addNote/{affaireId}")
    public Affaire addNote(@PathVariable String affaireId, @RequestBody Note note){
        return this.Service.addNote(affaireId, note);
    }

    @DeleteMapping(value="/deleteNote/{affaireId}/{noteNumber}")
    public void deleteNote(@PathVariable String affaireId, @PathVariable int noteNumber){
        this.Service.deleteNote(affaireId, noteNumber);
    }

    @PatchMapping(value= "/modifyNote/{affaireId}/{noteNumber}")
    public Note modifyNote(@PathVariable String affaireId, @PathVariable int noteNumber, @RequestBody Note note){
        return this.Service.modifyNote(affaireId, noteNumber, note);
    }

    @PatchMapping(value = "/reset/{num}")
    public Affaire resetAffaire(@PathVariable String num){
        return this.Service.reset(num);
    }

    @GetMapping("/commande/{idRh}")
    public Commande getCommandeByIdRh(@PathVariable String idRh){
        return this.Service.getCommandeByIdRh(idRh);
    }

    @PatchMapping("/avoir/add/{id}")
    public Affaire addAvoir(@RequestBody Avoir avoir, @PathVariable String id){

        Affaire uneAffaire = affaireRepository.findAffaireById(id);

        uneAffaire.getAvoirList().add(avoir);

        return affaireRepository.save(uneAffaire);
    }

    @PatchMapping("/collaborateur/add/{id}")
    public Affaire addCollaborateurInAffaire(@PathVariable String id, @RequestBody Ressource_Humaine ressource){

        Affaire affaire = this.affaireRepository.findAffaireById(id);

        affaire.getRh().add(ressource);

        return this.affaireRepository.save(affaire);
    }

    @PatchMapping("/collaborateur/delete/{id}")
    public Affaire deleteCollaborateurInAffaire(@PathVariable String id, @RequestBody Ressource_Humaine ressource){

        Affaire affaire = this.affaireRepository.findAffaireById(id);

        affaire.getRh().remove(ressource);

        return this.affaireRepository.save(affaire);
    }

    @GetMapping("/cmdnotpay")
    public List<Affaire> getAllCmdNotPay() {
        return this.Service.findAllCmdNotPay();
    }

    @GetMapping("/withbl")
    public List<Affaire> getAllWithBl() {
        return this.Service.findAllWithBl();
    }
}
