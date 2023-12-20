package fr.facil.facilapi.implementation;

import fr.facil.facilapi.collections.Affaire;
import fr.facil.facilapi.collections.Avoir;
import fr.facil.facilapi.repository.AffaireRepository;
import fr.facil.facilapi.repository.AvoirRepository;
import fr.facil.facilapi.service.avoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class avoirServiceImpl implements avoirService {

    @Autowired
    private AffaireRepository affaireRepository;

    @Autowired
    private AvoirRepository repository;

    /**
     * Il renvoie une liste de tous les avoirs.
     *
     * @return Une liste d'objets Avoir.
     */
    @Override
    public List<Avoir> findAll() {
        return this.repository.findAll();
    }

    /**
     * Trouve un Avoir par le numéro de sa Facture
     *
     * @param numero le numéro de fabrication
     * @return Avoir
     */
    @Override
    public Avoir findOneByFacture_Numero(String numero) {
        return this.repository.findAvoirByFacture_Numero(numero);
    }



    /**
     * Il crée un nouvel objet Avoir et l'enregistre dans la base de données.
     *
     * @param avoir L'objet à créer.
     * @return La méthode repository.save() renvoie l'entité enregistrée.
     */
    @Override
    public Avoir createOne(Avoir avoir) {
        return this.repository.save(avoir);
    }

    /**
     * Cette fonction retourne une liste de tous les avoirs qui ont un client dont le nom est passé en paramètre
     *
     * @param name Le nom du client
     * @return Une liste d'Avoirs
     */
    @Override
    public List<Avoir> findAllByClientName(String name) {



        List<Avoir> avoirList = this.repository.findAll();
        List<Avoir> avoirListClient = this.repository.findAll();

        for (Avoir avoir: avoirList){

            Affaire affaire = affaireRepository.findAffaireById(avoir.getFacture().getAffaire().toString());

            if (affaire.getClient().getName().equalsIgnoreCase(name)){
                avoirListClient.add(avoir);
            }

        }

        return avoirListClient;
    }
}



