package fr.facil.facilapi.collections;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employee")
public class Employee {

    @Id
    private String id;

    private String url;

    private String civilite;
    private String nom;
    private String prenom;
    private String numeroSecuriteSociale;
    private String dateNaissance;
    private int age;
    private String departementNaissance;
    private String paysNaissance;

    // Adresse
    private String voie;
    private String numeroHabitation;
    private String complementAdresse;
    private String codePostal;
    private String ville;
    private String paysResidence;

    private String numeroTelephone;
    private String email;

    // Si étranger
    private String nationalite;
    private String typeTitre;
    private String observationTitre;
    private String numeroCarteTitre;
    private String numeroEtranger;
    private String paysDelivrance;
    private String dateDebutValiditeTitre;
    private String dateFinValiditeTitre;

    // Personne à prévenir
    private String nomPrenomContact;
    private String numeroTelephoneContact;
    private String dateDemarrageContrat;
    private int nombreHeuresSemaine;
    private String intitulePoste;
    private String statut;
    private String etablissementRattachement;
    private String typeContrat;
    private String diplomes;
    private String positionCoefficient;
    private String client;
    private String sitePrestation;
    private String regionPrestation;
    private String dateDebut;
    private String dateFinEstimative;
    private String intituleMission;
    private String descriptifMission;
    private String cni;
    private String vital;
    private String attestationDomicile;
    private String titreSejour;
    private String recepisse;
    public Employee( String url, String civilite, String nom, String prenom, String numeroSecuriteSociale, String dateNaissance, int age, String departementNaissance, String paysNaissance, String voie, String numeroHabitation, String complementAdresse, String codePostal, String ville, String paysResidence, String numeroTelephone, String email, String nationalite, String typeTitre, String observationTitre, String numeroCarteTitre, String numeroEtranger, String paysDelivrance, String dateDebutValiditeTitre, String dateFinValiditeTitre, String nomPrenomContact, String numeroTelephoneContact, String dateDemarrageContrat, int nombreHeuresSemaine, String intitulePoste, String statut, String etablissementRattachement, String typeContrat, String diplomes, String positionCoefficient, String client, String sitePrestation, String regionPrestation, String dateDebut, String dateFinEstimative, String intituleMission, String descriptifMission) {
        this.url = url;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.numeroSecuriteSociale = numeroSecuriteSociale;
        this.dateNaissance = dateNaissance;
        this.age = age;
        this.departementNaissance = departementNaissance;
        this.paysNaissance = paysNaissance;
        this.voie = voie;
        this.numeroHabitation = numeroHabitation;
        this.complementAdresse = complementAdresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.paysResidence = paysResidence;
        this.numeroTelephone = numeroTelephone;
        this.email = email;
        this.nationalite = nationalite;
        this.typeTitre = typeTitre;
        this.observationTitre = observationTitre;
        this.numeroCarteTitre = numeroCarteTitre;
        this.numeroEtranger = numeroEtranger;
        this.paysDelivrance = paysDelivrance;
        this.dateDebutValiditeTitre = dateDebutValiditeTitre;
        this.dateFinValiditeTitre = dateFinValiditeTitre;
        this.nomPrenomContact = nomPrenomContact;
        this.numeroTelephoneContact = numeroTelephoneContact;
        this.dateDemarrageContrat = dateDemarrageContrat;
        this.nombreHeuresSemaine = nombreHeuresSemaine;
        this.intitulePoste = intitulePoste;
        this.statut = statut;
        this.etablissementRattachement = etablissementRattachement;
        this.typeContrat = typeContrat;
        this.diplomes = diplomes;
        this.positionCoefficient = positionCoefficient;
        this.client = client;
        this.sitePrestation = sitePrestation;
        this.regionPrestation = regionPrestation;
        this.dateDebut = dateDebut;
        this.dateFinEstimative = dateFinEstimative;
        this.intituleMission = intituleMission;
        this.descriptifMission = descriptifMission;
        this.cni = cni;
        this.vital = vital;
        this.attestationDomicile = attestationDomicile;
        this.titreSejour = titreSejour;
        this.recepisse = recepisse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroSecuriteSociale() {
        return numeroSecuriteSociale;
    }

    public void setNumeroSecuriteSociale(String numeroSecuriteSociale) {
        this.numeroSecuriteSociale = numeroSecuriteSociale;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartementNaissance() {
        return departementNaissance;
    }

    public void setDepartementNaissance(String departementNaissance) {
        this.departementNaissance = departementNaissance;
    }

    public String getPaysNaissance() {
        return paysNaissance;
    }

    public void setPaysNaissance(String paysNaissance) {
        this.paysNaissance = paysNaissance;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getNumeroHabitation() {
        return numeroHabitation;
    }

    public void setNumeroHabitation(String numeroHabitation) {
        this.numeroHabitation = numeroHabitation;
    }

    public String getComplementAdresse() {
        return complementAdresse;
    }

    public void setComplementAdresse(String complementAdresse) {
        this.complementAdresse = complementAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPaysResidence() {
        return paysResidence;
    }

    public void setPaysResidence(String paysResidence) {
        this.paysResidence = paysResidence;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getTypeTitre() {
        return typeTitre;
    }

    public void setTypeTitre(String typeTitre) {
        this.typeTitre = typeTitre;
    }

    public String getObservationTitre() {
        return observationTitre;
    }

    public void setObservationTitre(String observationTitre) {
        this.observationTitre = observationTitre;
    }

    public String getNumeroCarteTitre() {
        return numeroCarteTitre;
    }

    public void setNumeroCarteTitre(String numeroCarteTitre) {
        this.numeroCarteTitre = numeroCarteTitre;
    }

    public String getNumeroEtranger() {
        return numeroEtranger;
    }

    public void setNumeroEtranger(String numeroEtranger) {
        this.numeroEtranger = numeroEtranger;
    }

    public String getPaysDelivrance() {
        return paysDelivrance;
    }

    public void setPaysDelivrance(String paysDelivrance) {
        this.paysDelivrance = paysDelivrance;
    }

    public String getDateDebutValiditeTitre() {
        return dateDebutValiditeTitre;
    }

    public void setDateDebutValiditeTitre(String dateDebutValiditeTitre) {
        this.dateDebutValiditeTitre = dateDebutValiditeTitre;
    }

    public String getDateFinValiditeTitre() {
        return dateFinValiditeTitre;
    }

    public void setDateFinValiditeTitre(String dateFinValiditeTitre) {
        this.dateFinValiditeTitre = dateFinValiditeTitre;
    }

    public String getNomPrenomContact() {
        return nomPrenomContact;
    }

    public void setNomPrenomContact(String nomPrenomContact) {
        this.nomPrenomContact = nomPrenomContact;
    }

    public String getNumeroTelephoneContact() {
        return numeroTelephoneContact;
    }

    public void setNumeroTelephoneContact(String numeroTelephoneContact) {
        this.numeroTelephoneContact = numeroTelephoneContact;
    }

    public String getDateDemarrageContrat() {
        return dateDemarrageContrat;
    }

    public void setDateDemarrageContrat(String dateDemarrageContrat) {
        this.dateDemarrageContrat = dateDemarrageContrat;
    }

    public int getNombreHeuresSemaine() {
        return nombreHeuresSemaine;
    }

    public void setNombreHeuresSemaine(int nombreHeuresSemaine) {
        this.nombreHeuresSemaine = nombreHeuresSemaine;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getEtablissementRattachement() {
        return etablissementRattachement;
    }

    public void setEtablissementRattachement(String etablissementRattachement) {
        this.etablissementRattachement = etablissementRattachement;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public String getDiplomes() {
        return diplomes;
    }

    public void setDiplomes(String diplomes) {
        this.diplomes = diplomes;
    }

    public String getPositionCoefficient() {
        return positionCoefficient;
    }

    public void setPositionCoefficient(String positionCoefficient) {
        this.positionCoefficient = positionCoefficient;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getSitePrestation() {
        return sitePrestation;
    }

    public void setSitePrestation(String sitePrestation) {
        this.sitePrestation = sitePrestation;
    }

    public String getRegionPrestation() {
        return regionPrestation;
    }

    public void setRegionPrestation(String regionPrestation) {
        this.regionPrestation = regionPrestation;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFinEstimative() {
        return dateFinEstimative;
    }

    public void setDateFinEstimative(String dateFinEstimative) {
        this.dateFinEstimative = dateFinEstimative;
    }

    public String getIntituleMission() {
        return intituleMission;
    }

    public void setIntituleMission(String intituleMission) {
        this.intituleMission = intituleMission;
    }

    public String getDescriptifMission() {
        return descriptifMission;
    }

    public void setDescriptifMission(String descriptifMission) {
        this.descriptifMission = descriptifMission;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getVital() {
        return vital;
    }

    public void setVital(String vital) {
        this.vital = vital;
    }

    public String getAttestationDomicile() {
        return attestationDomicile;
    }

    public void setAttestationDomicile(String attestationDomicile) {
        this.attestationDomicile = attestationDomicile;
    }

    public String getTitreSejour() {
        return titreSejour;
    }

    public void setTitreSejour(String titreSejour) {
        this.titreSejour = titreSejour;
    }

    public String getRecepisse() {
        return recepisse;
    }

    public void setRecepisse(String recepisse) {
        this.recepisse = recepisse;
    }
}
