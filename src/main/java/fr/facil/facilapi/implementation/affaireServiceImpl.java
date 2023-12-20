package fr.facil.facilapi.implementation;

import com.fasterxml.jackson.annotation.JsonCreator;
import fr.facil.facilapi.collections.*;
import fr.facil.facilapi.repository.AffaireRepository;
import fr.facil.facilapi.service.affaireService;
import fr.facil.facilapi.type.State_bl;
import fr.facil.facilapi.type.paiement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class affaireServiceImpl implements affaireService {

    @Autowired
    private AffaireRepository affaireRepository;

    /**
     *  Cette fonction renvoie une liste de toutes les Affaires de la base de données
     *
     * @return Une liste d'objets Affaire.
     */
    @Override
    public List<Affaire> findAll() {
        return affaireRepository.findAll();
    }


    /**
     *  La fonction `findOneById` est une fonction qui renvoie un objet `Affaire`
     *
     * @param id l'identifiant de l'Affaire à retrouver
     * @return Une liste d'objets Affaire
     */
    @Override
    public Affaire findOneById(String id) {
        return affaireRepository.findAffaireById(id);
    }


    /**
     * Il prend toutes les affaires de la base de données, puis il prend toutes les ressources humaines de chaque affaire,
     * puis il vérifie si l'affaire est en cours, si c'est le cas, il ajoute les ressources humaines à une liste, et
     * renvoie la liste
     *
     * @return A list of Ressource_Humaine
     */
    @Override
    public List<Ressource_Humaine> findAllCollab() {
        List<Affaire> affs = affaireRepository.findAll();
        List<Ressource_Humaine> rh = new ArrayList<>();

        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");


        for (Affaire aff: affs) {
            String date_debut = aff.getDate_debut();
            String date_fin = aff.getDate_fin();

            try {
                date1 = simpleDateFormat.parse(date_debut);
                date2 = simpleDateFormat.parse(date_fin);
                date3 = new Date();

            } catch (ParseException e) {
                e.printStackTrace();
            }
            for (Ressource_Humaine rs: aff.getRh()){
                if (date1.before(date3) && date2.after(date3)) {
                    if (!rh.contains(rs)) {

                        rh.add(rs);

                    }
                }
            }
        }
        return rh;
    }


    /**
     * > Cette fonction renvoie la liste de toutes les affaires d'un client dont le nom est passé en paramètre
     *
     * @param name Le nom du client
     * @return Une liste d'objets Affaire.
     */
    @Override
    public List<Affaire> findAllByClient_Name(String name) {
        return affaireRepository.findAllByClient_Name(name);
    }

    /**
     * Il rend la dernière Affaire active d'un Collaborateur
     *
     * @param id l'identifiant du collaborateur
     * @return Une liste de toutes les affaires actives d'un collaborateur
     */
    @Override
    public Affaire findOneByCollab_Id(String id) {
        List<Affaire> aff = affaireRepository.findAllByRh_Id(id);

        for (Affaire OneAff:
                aff) {
            if (OneAff.isActive()){
                return OneAff;
            }
        }

        return null;
    }

    /**
     * > Cette fonction renvoie une liste de toutes les affaires qui sont affectées à une ressource humaine spécifique
     *
     * @param rh the ressource_humaine object
     * @return Une liste d'objets Affaire
     */
    @Override
    public List<Affaire> findAllByRh(Ressource_Humaine rh) {
        return affaireRepository.findAffairesByRh(rh);
    }

    /**
     * Il renvoie une liste d'objets Affaire qui ont un Rh_Id spécifique.
     *
     * @param id l'identifiant du rh
     * @return Une liste d'objets Affaire.
     */
    @Override
    public List<Affaire> findAllByRh_Id(String id) {
        return affaireRepository.findAllByRh_Id(id);
    }

    /**
     * > Il renvoie un objets Affaire qui à un référence spécifique.
     *
     * @param ref La référence de l'Affaire à trouver.
     * @return An Affaire object
     */
    @Override
    public Affaire findOneByReference(String ref) {
        return affaireRepository.findAffaireByReference(ref);
    }

    /**
     * > Cette fonction retourne l'objet Affaire qui contient l'objet Commande passé en paramètre
     *
     * @param commande l'ordre de rechercher
     * @return L'objet Affaire qui contient l'objet Commande.
     */
    @Override
    public Affaire findOneByCommande(Commande commande) {
        List<Affaire> affaires = affaireRepository.findAll();

        for (Affaire monAffaire : affaires){

            for (Commande maCommande : monAffaire.getCmds()){

                if (maCommande.equals(commande)){
                    return monAffaire;
                }

            }

        }
        return null;
    }

    /**
     * Il prend un prénom et un nom en paramètres, puis il parcourt toutes les affaires et vérifie si le prénom et le nom
     * sont dans la liste des ressources humaines de l'affaire. Si c'est le cas, il ajoute l'affaire à une nouvelle liste
     *
     * @param lastName le nom de famille du collaborateur
     * @param firstName le prénom du collaborateur
     * @return Une liste d'Affaire
     */
    @Override
    public List<Affaire> findAllByCollabName(String lastName, String firstName) {
        List<Affaire> affaires = affaireRepository.findAll();
        List<Affaire> newAffaires = new ArrayList<>();

        for (Affaire uneAffaire: affaires){

            for (Ressource_Humaine rs: uneAffaire.getRh()){

                if (rs.getFirstname().equalsIgnoreCase(firstName) && rs.getLastname().equalsIgnoreCase(lastName)){
                    newAffaires.add(uneAffaire);
                }

            }

        }

        return newAffaires;
    }


    /**
     * Il prend un prénom et un nom en paramètres, et un objet Ressource_Humaine. Il recherche alors dans toutes les
     * Affaires de la base, et si le prénom et le nom correspondent à ceux de l'objet Ressource_Humaine, il remplace
     * l'objet Ressource_Humaine dans l'Affaire par celui passé en paramètre
     *
     * @param lastName le nom de famille du collaborateur à mettre à jour
     * @param firstName le prénom du collaborateur à mettre à jour
     * @param rs l'objet ressource_humaine que l'on souhaite mettre à jour
     * @return Une liste d'Affaire
     */
    @Override
    public List<Affaire> updateAllDayOfCollab(String lastName, String firstName, Ressource_Humaine rs) {

        List<Affaire> affaires = affaireRepository.findAll();
        List<Affaire> newAffaires = new ArrayList<>();

        for (Affaire uneAffaire: affaires){

            for (Ressource_Humaine rsList: uneAffaire.getRh()){

                if (rsList.getFirstname().equalsIgnoreCase(firstName) && rsList.getLastname().equalsIgnoreCase(lastName)){
                    uneAffaire.getRh().remove(rsList);
                    uneAffaire.getRh().add(rs);

                    newAffaires.add(uneAffaire);

                }

            }

        }

        affaireRepository.saveAll(newAffaires);

        return newAffaires;
    }


    /**
     * Il renvoie une liste de toutes les affaires actives qui n'ont pas été commandées au cours des 15 derniers jours.
     *
     * @return Une liste d'objets Affaire
     */
    @Override
    public List<Affaire> findAllHaveNotCommandePlus() throws ParseException {
        List<Affaire> listAffaires = affaireRepository.findAll();

        List<Affaire> listAffairesNotCommande = new ArrayList<>();

        Date dateHere = new Date();

        for(Affaire affaire: listAffaires){

            /*affaire.getCmds().get(affaire.getCmds().size() - 1 ).getDate_fin_commande()*/
            Date dateCmd = null;
            if (!affaire.getCmds().isEmpty() ) {
                try{
                    if(!affaire.getCmds().get(affaire.getCmds().size() - 1).getDate_fin_commande().equalsIgnoreCase(""))
                        dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getCmds().get(affaire.getCmds().size() - 1).getDate_fin_commande());
                    else {
                        dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getDate_debut());
                        dateCmd.setDate(dateCmd.getDate() + 500);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }else{
                dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getDate_debut());
            }

            assert dateCmd != null;
            long diff = dateHere.getTime() - dateCmd.getTime();
            float res = (diff / (1000*60*60*24));

            if(affaire.isActive()) {
                if (res <= 15) {
                    if (affaire.getCmds().isEmpty()) {
                        listAffairesNotCommande.add(affaire);
                    } else if (dateHere.after(dateCmd)) {
                        listAffairesNotCommande.add(affaire);
                    }
                }
            }
        }

        return listAffairesNotCommande;
    }

    @Override
    public List<Affaire> findAllHaveNotCommandePlusPlus() throws ParseException {
        List<Affaire> listAffaires = affaireRepository.findAll();

        List<Affaire> listAffairesNotCommande = new ArrayList<>();

        Date dateHere = new Date();

        for(Affaire affaire: listAffaires){

            /*affaire.getCmds().get(affaire.getCmds().size() - 1 ).getDate_fin_commande()*/
            Date dateCmd = null;
            if (!affaire.getCmds().isEmpty()) {
                try{
                    if(affaire.getCmds().get(affaire.getCmds().size() - 1).getDate_fin_commande() != null)
                        dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getCmds().get(affaire.getCmds().size() - 1).getDate_fin_commande());
                    else {
                        dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getDate_debut());
                        dateCmd.setDate(dateCmd.getDate() + 500);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }else{
                dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getDate_debut());
            }

            assert dateCmd != null;
            long diff = dateHere.getTime() - dateCmd.getTime();
            float res = (diff / (1000*60*60*24));

            if(affaire.isActive()) {
                if (res <= 45) {
                    if (affaire.getCmds().isEmpty()) {
                        listAffairesNotCommande.add(affaire);
                    } else if (dateHere.after(dateCmd)) {
                        listAffairesNotCommande.add(affaire);
                    }
                }
            }
        }

        return listAffairesNotCommande;
    }


    /**
     * Elle renvoie un objet Facture si le nom de la facture est trouvé dans la base de données
     *
     * @param nameFacture le nom du document à rechercher
     * @return Un objet Facture
     */
    @Override
    public Facture findOneByNameFacture(String nameFacture) {
        List<Affaire> allAffaires = this.affaireRepository.findAll();

        for (Affaire uneAffaire : allAffaires){

            for (Facture uneFacture : uneAffaire.getFactureList()){


                if (uneFacture.getDocument().getTitle().equals(nameFacture)){
                    return uneFacture;
                }

            }

        }
        return null;
    }


    /**
     * Elle retourne un objet BL si le nom du BL est égal au nom du BL passé en paramètre
     *
     * @param nameBl le nom du document BL
     * @return Un objet BL
     */
    @Override
    public BL findOneByNameBl(String nameBl) {
        List<Affaire> allAffaires = this.affaireRepository.findAll();

        for (Affaire uneAffaire : allAffaires){

            for (BL unBl : uneAffaire.getBlList()){


                if (unBl.getDoc().getTitle().equals(nameBl)) {
                    return unBl;
                }

            }

        }
        return null;
    }


    /**
     * Il renvoie une liste de toutes les affaires actives qui n'ont pas été commandées depuis plus de 15 jours.
     *
     * @return Une liste des objets Affaire qui n'ont pas été commandés au cours des 15 derniers jours.
     */
    @Override
    public List<Affaire> findAllHaveNotCommande() throws ParseException {

        List<Affaire> listAffaires = affaireRepository.findAll();

        List<Affaire> listAffairesNotCommande = new ArrayList<>();

        Date dateHere = new Date();

        for(Affaire affaire: listAffaires){
            
            Date dateCmd = null;
            if (!affaire.getCmds().isEmpty()) {
                try{
                    if(!affaire.getCmds().get(affaire.getCmds().size() - 1).getDate_fin_commande().equalsIgnoreCase(""))
                        dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getCmds().get(affaire.getCmds().size() - 1).getDate_fin_commande());
                    else {
                        dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getDate_debut());
                        dateCmd.setDate(dateCmd.getDate() + 500);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }else{
                dateCmd = new SimpleDateFormat("yyyyMMdd").parse(affaire.getDate_debut());
            }

            assert dateCmd != null;
            long diff = dateHere.getTime() - dateCmd.getTime();
            float res = (diff / (1000*60*60*24));

            if(affaire.isActive()) {
                if (res > 15) {
                    if (affaire.getCmds().isEmpty()) {
                        listAffairesNotCommande.add(affaire);
                    } else if (dateHere.after(dateCmd)) {
                        listAffairesNotCommande.add(affaire);
                    }
                }
            }
        }

        return listAffairesNotCommande;
    }

    /**
     *
     *
     * @return Une liste d'Affaire
     */
    @Override
    public List<Affaire> findAllCommandeActive() {

        List<Affaire> listAffaire = this.affaireRepository.findAll();
        List<Affaire> listAffaireLastCommande = new ArrayList<>();

        for (Affaire uneAffaire: listAffaire){

            for (Commande uneCommande: uneAffaire.getCmds()){

                if(uneCommande.isActive()){

                    listAffaireLastCommande.add(uneAffaire);

                }

            }

        }


        return listAffaireLastCommande;
    }

    /**
     * Cette fonction retourne une liste des BL qui sont liés à une Affaire spécifique
     *
     * @param id l'id de l'Affaire
     * @return Une liste de BL
     */
    @Override
    public List<BL> findAllBlInAffaire(String id) {

        Affaire uneAffaire = this.affaireRepository.findAffaireById(id);

        return uneAffaire.getBlList();
    }

    /**
     * Il renvoie une liste de tous les BL actifs et non encore facturés
     *
     * @return Une liste de BL
     */
    @Override
    public List<BL> findAllBlInAllAffaire() {

        List<Affaire> affaireList = this.affaireRepository.findAll();
        List<BL> blList = new ArrayList<>();

        for (Affaire uneAffaire : affaireList){

            for (BL unBl: uneAffaire.getBlList()){

                if (unBl.isActive() && !unBl.getComeFacture()){

                    blList.add(unBl);

                }

            }

        }


        return blList;
    }

    /**
     * Cette fonction renvoie une liste de toutes les factures d'un dossier donné
     *
     * @param id l'id de l'Affaire
     * @return Une liste d'objets Facture.
     */
    @Override
    public List<Facture> findAllFactureInAffaire(String id) {
        Affaire uneAffaire = this.affaireRepository.findAffaireById(id);

        return uneAffaire.getFactureList();
    }

    /**
     * Cette fonction renvoie une liste de toutes les factures actives dans la base de données
     *
     * @return Une liste de toutes les factures actives dans la base de données.
     */
    @Override
    public List<Facture> findAllFactureInAllFacture() {


        List<Affaire> affaireList = this.affaireRepository.findAll();
        List<Facture> factureList = new ArrayList<>();

        for (Affaire uneAffaire: affaireList){

            for (Facture uneFacture : uneAffaire.getFactureList()){

                if (uneFacture.isActive()){
                    factureList.add(uneFacture);
                }

            }

        }

        return factureList;
    }


    /**
     * La fonction `createOne` crée une nouvelle `Affaire` dans la base de données
     *
     * @param affaire L'objet à créer.
     * @return L'objet affaire est renvoyé.
     */
    @Override
    public Affaire createOne(Affaire affaire) {
        return affaireRepository.save(affaire);
    }

    /**
     * Il supprime une affaire de la base de données
     *
     * @param id l'id de l'affaire à supprimer
     */
    @Override
    public void deleteOne(String id) {
        affaireRepository.deleteById(id);
    }


    /**
     * Il prend un identifiant et un objet Affaire, définit l'identifiant de l'objet Affaire sur le paramètre id, puis
     * enregistre l'objet Affaire dans la base de données
     *
     * @param id L'identifiant de l'Affaire à mettre à jour.
     * @param affaire L'objet affaire que nous voulons mettre à jour.
     * @return L'affaire mise à jour.
     */
    @Override
    public Affaire updateOne(String id, Affaire affaire) {
        affaire.setId(id);

        return affaireRepository.save(affaire);
    }

    /**
     * Il ajoute une relance à une affaire
     *
     * @param id L'identifiant de l'Affaire auquel ajouter la Relance.
     * @param relance L'objet relance à ajouter à l'affaire.
     * @return L'objet affaire avec la nouvelle relance ajoutée à la liste des relances.
     */
    @Override
    public Affaire addRelance(String id, Relance relance) {

        Affaire affaire = affaireRepository.findAffaireById(id);

        affaire.getRelance().add(relance);

        return affaireRepository.save(affaire);
    }

    /**
     * > La fonction ajoute une facture à une affaire
     *
     * @param id l'identifiant de l'objet Affaire
     * @param facture L'objet de facture à ajouter à l'affaire.
     * @return L'objet affaire avec la nouvelle facture ajoutée à la liste.
     */
    @Override
    public Affaire addFacture(String id, Facture facture) {

        Affaire affaire = affaireRepository.findAffaireById(id);

        affaire.getFactureList().add(facture);

        return affaireRepository.save(affaire);
    }

    /**
     * Il ajoute un BL à une Affaire
     *
     * @param id l'id de l'Affaire
     * @param bl L'objet BL à ajouter à la liste.
     * @return L'objet affaire avec le nouveau bl ajouté à la liste.
     */
    @Override
    public Affaire addBl(String id, BL bl) {

        Affaire affaire = affaireRepository.findAffaireById(id);

        affaire.getBlList().add(bl);

        return affaireRepository.save(affaire);
    }


    /**
     * La fonction ajoute une note à une affaire
     *
     * @param affaireId L'identifiant de l'affaire à laquelle la note est ajoutée.
     * @param note L'objet note que vous souhaitez ajouter à l'affaire.
     * @return La note qui a été ajoutée à l'affaire.
     */
    @Override
    public Affaire addNote(String affaireId, Note note) {
        Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

        logger.info(note.toString());
        logger.info(affaireId);

        Affaire affaire = affaireRepository.findAffaireByReference(affaireId);

        affaire.getNoteList().add(note);

        return affaireRepository.save(affaire);
    }

    /**
     * Il supprime une note d'une affaire.
     *
     * @param affaireId La référence de l'Affaire
     * @param noteNumber Le numéro de la note à supprimer.
     */
    @Override
    public void deleteNote(String affaireId, int noteNumber) {

        Affaire affaire = affaireRepository.findAffaireByReference(affaireId);

        for (Note notes :affaire.getNoteList()){
            if (notes.getNumber() == noteNumber){
                notes.setActive(false);
            }
        }
        affaireRepository.save(affaire);
    }

    /**
     * Il modifie une note dans la base de données.
     *
     * @param affaireId L'identifiant de l'affaire
     * @param noteNumber Le numéro de la note à modifier.
     * @param note l'objet note que vous souhaitez modifier
     * @return La note est renvoyée.
     */
    @Override
    public Note modifyNote(String affaireId, int noteNumber, Note note) {

        Affaire affaire = affaireRepository.findAffaireByReference(affaireId);

        for (Note notes :affaire.getNoteList()){
            if (notes.getNumber() == noteNumber){
                notes.setMessage(note.getMessage());


                notes.setModifyAt(note.getModifyAt());
            }
        }

        affaireRepository.save(affaire);

        return note;
    }

    /**
     * > Cette fonction retourne une liste de notes pour une affaire donnée
     *
     * @param affaireId L'identifiant de l'affaire
     * @return Une liste de notes
     */
    @Override
    public List<Note> getNote(String affaireId) {

        Affaire affaire = affaireRepository.findAffaireByReference(affaireId);

        return affaire.getNoteList();
    }

    /**
     * Il met à jour le statut d'une facture.
     *
     * @param status le statut du paiement
     * @param factureNumero Le numéro de facture
     * @return Facture
     */
    @Override
    public Facture updateFacture(String status, String factureNumero) {

        List<Affaire> affaireList = this.findAll();


        for (Affaire affaire : affaireList) {

            for (Facture facture : affaire.getFactureList()) {
                if (facture.getNumero().equalsIgnoreCase(factureNumero)) {
                    facture.setPaiement(paiement.valueOf(status));
                    facture.setActive(false);

                    affaireRepository.save(affaire);

                    return facture;
                }
            }

        }

        return null;
    }


    /**
     * Il efface la liste des factures et factures d'une Affaire donnée
     *
     * @param num la référence de l'Affaire
     * @return L'objet affaire est renvoyé.
     */
    @Override
    public Affaire reset(String num) {

        Affaire affaire = this.affaireRepository.findAffaireByReference(num);

        affaire.getFactureList().clear();
        affaire.getBlList().clear();

        return affaireRepository.save(affaire);
    }


    @Override
    public BL updateBl(String blNumero, BL bl) {
        List<Affaire> affaireList = this.findAll();


        for (Affaire affaire : affaireList) {

            for (BL bls : affaire.getBlList()) {
                if (bls.getNum().equalsIgnoreCase(blNumero)) {
                    bls.setId(bl.getId());
                    bls.setEtat(bl.getEtat());
                    bls.setActive(bl.isActive());

                    affaireRepository.save(affaire);

                    return bls;
                }
            }

        }

        return null;
    }

    @Override
    public Commande getCommandeByIdRh(String idRh) {

        for (Affaire affaire: this.affaireRepository.findAll()){
            if (affaire.isActive()){
                for (Ressource_Humaine rh : affaire.getRh()){
                    if (rh.isActive()){
                        if (rh.getId().equalsIgnoreCase(idRh)){
                            for (Commande cmd: affaire.getCmds()){
                                if (cmd.isActive()){
                                    return affaire.getCmds().get(affaire.getCmds().toArray().length-1);
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }


    @Override
    public List<Affaire> findAllCmdNotPay() {

        List<Affaire> affaires = new ArrayList<>();

        for(Affaire affaire: this.affaireRepository.findAll()){
            if (affaire.isActive()){
                if(!affaire.getCmds().isEmpty()){

                    Commande cmd = affaire.getCmds().get(affaire.getCmds().toArray().length-1);
                    if (!cmd.getDate_fin_commande().equalsIgnoreCase("")){
                        /* je veux une date avec un changement de format */
                        Date date = null;
                        try {
                            date = new SimpleDateFormat("yyyyMMdd").parse(cmd.getDate_fin_commande());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        if(!cmd.isActive()){
                            affaires.add(affaire);
                        }else if(date.after(new Date()) && cmd.isActive()){
                            affaires.add(affaire);
                        }
                    }

                }
            }
        }
        return affaires;
    }


    @Override
    public List<Affaire> findAllWithBl() {

        List<Affaire> affaires = new ArrayList<>();

        for(Affaire affaire : this.affaireRepository.findAll()){
            if (affaire.isActive()){
                if(affaire.getClient().isType_bl()){
                    affaires.add(affaire);
                }
            }
        }


        return affaires;
    }


}
