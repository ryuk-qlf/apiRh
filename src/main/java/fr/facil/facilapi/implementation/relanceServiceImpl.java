package fr.facil.facilapi.implementation;

import fr.facil.facilapi.collections.Relance;
import fr.facil.facilapi.repository.relanceRepository;
import fr.facil.facilapi.service.relanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class relanceServiceImpl implements relanceService {

    @Autowired
    private relanceRepository Repo;


    @Override
    public List<Relance> findAll() {
        return Repo.findAll();
    }

    @Override
    public Relance findOneById(String id) {
        return Repo.findOneById(id);
    }

    @Override
    public Relance createOne(Relance relance) {
        return Repo.save(relance);
    }

}
