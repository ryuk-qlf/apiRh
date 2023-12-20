package fr.facil.facilapi.service;

import fr.facil.facilapi.collections.BL;
import fr.facil.facilapi.supplement.Last;
import fr.facil.facilapi.supplement.Name;
import fr.facil.facilapi.type.State_bl;

import java.util.List;

public interface blService {

    List<BL> findAll();
    
    BL getById(String id);

    List<BL> message();


    BL getByNum(String blNum);

    BL addBL(BL bl);

    void deleteBL(String blId);

    BL updateBL(String blId, BL bl);

    BL updateStatBL(String blId, State_bl st);

    Last getLastBl();
}
