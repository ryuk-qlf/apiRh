package fr.facil.facilapi.implementation;

import fr.facil.facilapi.collections.NoteDeFrais;
import fr.facil.facilapi.repository.NoteDeFraisRepository;
import fr.facil.facilapi.service.NoteDeFraisService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteDeFraisServiceImpl implements NoteDeFraisService {

    private NoteDeFraisRepository noteDeFraisRepository;


    public List<NoteDeFrais> findAll() {
        return this.noteDeFraisRepository.findAll();
    }
}
