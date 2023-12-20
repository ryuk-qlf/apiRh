package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.*;

import java.text.ParseException;
import java.util.List;

public interface affaireService {

    List<Affaire> findAll();

    Affaire findOneById(String id);

    List<Ressource_Humaine> findAllCollab();

    List<Affaire> findAllByClient_Name(String name);

    Affaire findOneByCollab_Id(String id);

    List<Affaire> findAllByRh(Ressource_Humaine rh);

    List<Affaire> findAllByRh_Id(String id);

    Affaire findOneByReference(String ref);

    Affaire findOneByCommande(Commande commande);

    List<Affaire> findAllByCollabName(String lastName, String firstName);

    List<Affaire> updateAllDayOfCollab(String lastName, String firstName, Ressource_Humaine rs);

    List<Affaire> findAllHaveNotCommandePlus() throws ParseException;

    List<Affaire> findAllHaveNotCommandePlusPlus() throws ParseException;

    Facture findOneByNameFacture(String nameFacture);

    BL findOneByNameBl(String nameBl);

    List<Affaire> findAllHaveNotCommande() throws ParseException;

    List<Affaire> findAllCommandeActive();

    List<BL> findAllBlInAffaire(String id);

    List<BL> findAllBlInAllAffaire();
    List<Facture> findAllFactureInAffaire(String id);

    List<Facture> findAllFactureInAllFacture();

    Affaire createOne(Affaire affaire);

    void deleteOne(String id);

    Affaire updateOne(String id, Affaire affaire);

    Affaire addRelance(String id,Relance relance);

    Affaire addFacture(String id, Facture facture);

    Affaire addBl(String id, BL bl);

    Affaire addNote(String affaireId, Note note);

    void deleteNote(String affaireId, int noteNumber);

    Note modifyNote(String affaireId, int noteNumber, Note note);

    List<Note> getNote(String affaireId);

    Facture updateFacture(String status, String factureNumero);

    Affaire reset(String num);

    BL updateBl(String blNumero, BL bl);

    Commande getCommandeByIdRh(String idRh);

    List<Affaire> findAllCmdNotPay();

    List<Affaire> findAllWithBl();
}
