package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.BL;
import fr.facil.facilapi.collections.Facture;
import fr.facil.facilapi.repository.BLRepository;
import fr.facil.facilapi.service.blService;
import fr.facil.facilapi.supplement.Last;
import fr.facil.facilapi.supplement.Name;
import fr.facil.facilapi.type.State_bl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/bl")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BLRestController {

    @Autowired
    private BLRepository blRepository;

    @Autowired
    private blService Service;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping(value= "/")
    public List<BL> getAllBL(){
        return this.Service.findAll();
    }

    @GetMapping(value= "/{blId}")
    public BL getBlById(@PathVariable String blId){
        return this.Service.getById(blId);
    }

    @GetMapping(value = "/message")
    public List<BL> message(){
        return this.Service.message();
    }

    @GetMapping(value= "/num/{blNum}")
    public BL getBlByNum(@PathVariable String blNum){
        return this.Service.getByNum(blNum);
    }

    @PostMapping(value = "/create")
    public BL addBL(@RequestBody BL bl) {
        return this.Service.addBL(bl);
    }

    @DeleteMapping(value = "/delete/{blId}")
    public void deleteBl(@PathVariable String blId) {
        this.Service.deleteBL(blId);
    }

    @PatchMapping(value = "/update/{blId}")
    public BL updateBl(@RequestBody BL bl, @PathVariable String blId) {
        return this.Service.updateBL(blId, bl);
    }

    @PostMapping(value = "/updateState/{blId}")
    public BL updateStatBl(@PathVariable String blId, @RequestBody State_bl st) {

        return this.Service.updateStatBL(blId, st);
    }

    @GetMapping(value = "/last")
    public Last getLastBl(){

        return this.Service.getLastBl();

    }



}
