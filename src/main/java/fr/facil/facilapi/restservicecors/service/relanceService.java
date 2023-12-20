package fr.facil.facilapi.restservicecors.service;

import fr.facil.facilapi.collections.Relance;

import java.util.List;

public interface relanceService {

    List<Relance> findAll();
    Relance findOneById(String id);

    Relance createOne(Relance relance);

}
