package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.Relance;

import java.util.List;

public interface relanceService {




    public List<Relance> findAll();


    public Relance findOneById(String id);


    public Relance createOne(Relance relance);

}
