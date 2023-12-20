package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.Avoir;

import java.util.List;

public interface avoirService {

    List<Avoir> findAll();

    Avoir findOneByFacture_Numero(String numero);

    Avoir createOne(Avoir avoir);

    List<Avoir> findAllByClientName(String name);
}
