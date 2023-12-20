package fr.facil.facilapi.implementation;

import fr.facil.facilapi.collections.Ressource_Humaine;
import fr.facil.facilapi.collections.jourTravail;
import fr.facil.facilapi.repository.JourDeTravailRepository;
import fr.facil.facilapi.service.JourDeTravailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourDeTravailServiceImpl implements JourDeTravailService {


    @Autowired
    private JourDeTravailRepository jdRepo;

    @Override
    public List<jourTravail> findAll() {
        return this.jdRepo.findAll();
    }

    /**
     *
     * @param id
     * @return jourTravail
     */
    @Override
    public jourTravail findByOne(Integer id) {
        return this.jdRepo.findJourTravailById(id);
    }


    /**
     *
     * @param rh
     * @return jourTravail
     */
    @Override
    public jourTravail findjourtravailByRh(Ressource_Humaine rh) {
        return this.jdRepo.findJourTravailByRh(rh);
    }

    /**
     *
     * @param listeJDeTravail
     * @param jourDeT
     * @return
     */
    @Override
    public jourTravail findjourTravailByList(List<jourTravail> listeJDeTravail,jourTravail jourDeT) {
        for(jourTravail jDeTravail:  listeJDeTravail){
            if(jDeTravail.equals(jourDeT)){
                return jDeTravail;
            }
        }
        return null ;
    }


}
