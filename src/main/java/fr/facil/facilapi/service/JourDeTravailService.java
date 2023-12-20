package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.Ressource_Humaine;
import fr.facil.facilapi.collections.jourTravail;

import java.util.List;

public interface JourDeTravailService {

    List<jourTravail> findAll();
    jourTravail findByOne(Integer id);


    jourTravail findjourtravailByRh(Ressource_Humaine rh);
    public jourTravail findjourTravailByList(List<jourTravail> listeJDeTravail,jourTravail jourDeT);
}
