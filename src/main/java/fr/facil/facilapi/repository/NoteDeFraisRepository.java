package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.NoteDeFrais;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface NoteDeFraisRepository extends MongoRepository<NoteDeFrais, String> {
    public default NoteDeFrais findByDate(Date uneDate){
        List<NoteDeFrais> mesNotesDeFrais= this.findAll();
        for (int i=0 ; i<mesNotesDeFrais.size();i++)
        {
            NoteDeFrais uneNoteDF=mesNotesDeFrais.get(i);
            if(uneNoteDF.getPrenom().equals(uneDate)){
                return uneNoteDF ;
            }
        }
    return null ;
    }
    public default List<NoteDeFrais> findByNameAndFirstname(String nom ,String prenom){
        List<NoteDeFrais> mesNotesDeFrais= this.findAll();
        List<NoteDeFrais>  listeRetourNoteDeFrais= new ArrayList<NoteDeFrais>();
        for (int i=0 ; i<mesNotesDeFrais.size();i++)
        {
            NoteDeFrais uneNoteDF=mesNotesDeFrais.get(i);
            if(uneNoteDF.getPrenom().equals(prenom)&& uneNoteDF.getNom().equals(nom)){
                    listeRetourNoteDeFrais.add(uneNoteDF);
            }
        }
        return listeRetourNoteDeFrais ;
    }
}
