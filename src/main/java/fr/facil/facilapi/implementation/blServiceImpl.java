package fr.facil.facilapi.implementation;

import fr.facil.facilapi.collections.BL;
import fr.facil.facilapi.repository.BLRepository;
import fr.facil.facilapi.service.blService;
import fr.facil.facilapi.supplement.Last;
import fr.facil.facilapi.supplement.Name;
import fr.facil.facilapi.type.State_bl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class blServiceImpl implements blService {

    @Autowired
    private BLRepository repository;

    /**
     * > Cette fonction renvoie une liste de tous les BL de la base de données
     * 
     * @return Une liste d'objets BL.
     */
    @Override
    public List<BL> findAll() {
        return this.repository.findAll();
    }

    /**
     * > Cette fonction renvoie un objet BL de la base de données par son identifiant
     *
     * @param id L'identifiant du BL que vous souhaitez obtenir.
     * @return Un objet BL
     */
    @Override
    public BL getById(String id) {
        return this.repository.findBlById(id);
    }

    /**
     * Il renvoie une liste des BL qui sont dans l'état "attente_validation".
     * 
     * @return Une liste de BL
     */
    @Override
    public List<BL> message() {

        List<BL> listBL = new ArrayList<>();

        for (BL bl: this.repository.findAll()){
            if (bl.isActive()){
                if (bl.getEtat().equals(State_bl.attente_validation)){
                    listBL.add(bl);
                }
            }
        }
        return null;
    }

    /**
     * > Cette fonction retourne un objet BL par son numéro
     * 
     * @param blNum Le numéro du BL à récupérer.
     * @return Un objet BL
     */
    @Override
    public BL getByNum(String blNum) {
        return this.repository.findBLByNum(blNum);
    }

    /**
     * > Cette fonction ajoute un nouveau BL à la base de données
     * 
     * @param bl L'objet BL que vous souhaitez ajouter à la base de données.
     * @return L'objet BL qui a été enregistré.
     */
    @Override
    public BL addBL(BL bl) {
        return this.repository.save(bl);
    }

    /**
     * > Cette fonction supprime une logique métier par son id
     * 
     * @param blId ID de la logique métier à supprimer.
     */
    @Override
    public void deleteBL(String blId) {
        this.repository.deleteById(blId);
    }

    /**
     * > Cette fonction met à jour un BL avec l'ID donné avec le BL donné
     * 
     * @param blId L'identifiant du BL à mettre à jour.
     * @param bl L'objet BL qui est mis à jour.
     * @return L'objet BL mis à jour.
     */
    @Override
    public BL updateBL(String blId, BL bl) {
        BL update = this.repository.findBlById(blId);

        update.setId(blId);
        update.setEtat(bl.getEtat());
        update.setActive(bl.isActive());

        return this.repository.save(update);
    }

    /**
     * > Cette fonction met à jour l'état d'un BL
     * 
     * @param blId l'id du BL à mettre à jour
     * @param st le nouvel état du BL
     * @return Le BL mis à jour
     */
    @Override
    public BL updateStatBL(String blId, State_bl st) {
        BL bl = this.repository.findBlById(blId);

        bl.setId(blId);
        bl.setEtat(st);

        return this.repository.save(bl);
    }

    /**
     * Il renvoie le dernier numéro BL
     * 
     * @return Le dernier numéro BL
     */
    @Override
    public Last getLastBl() {
        List<BL> bls = this.repository.findAll();
        List<Integer> inte = new ArrayList<>();

        for (BL bl: bls){
            inte.add(Integer.valueOf(bl.getNum()));
        }

        return new Last(Collections.max(inte) + 1);
    }


}
