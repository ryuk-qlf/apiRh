package fr.facil.facilapi.collections;

import fr.facil.facilapi.supplement.Competence;
import fr.facil.facilapi.supplement.Experience;
import fr.facil.facilapi.supplement.Formation;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Candidat")
public class Candidat {

    @Id
    String id;

    String Nom;
    String Prenom;
    String Adresse;
    String Num_telephone;
    Boolean Disponible;
    List<Formation> Formations;
    List<Experience> Experiences;
    List<Competence> Comptences;
    CV cv;

    public Candidat(String nom, String prenom, String adresse, String num_telephone, Boolean disponible,
                    List<Formation> formations, List<Experience> experiences, List<Competence> comptences, CV cv) {
        Nom = nom;
        Prenom = prenom;
        Adresse = adresse;
        Num_telephone = num_telephone;
        Disponible = disponible;
        Formations = formations;
        Experiences = experiences;
        Comptences = comptences;
        this.cv = cv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public String getNum_telephone() {
        return Num_telephone;
    }

    public void setNum_telephone(String num_telephone) {
        Num_telephone = num_telephone;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }

    public List<Formation> getFormations() {
        return Formations;
    }

    public void setFormations(List<Formation> formations) {
        Formations = formations;
    }

    public List<Experience> getExperiences() {
        return Experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        Experiences = experiences;
    }

    public List<Competence> getComptences() {
        return Comptences;
    }

    public void setComptences(List<Competence> comptences) {
        Comptences = comptences;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }
}
