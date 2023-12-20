package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Relance;
import fr.facil.facilapi.service.relanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relance")
@CrossOrigin(origins = "*", maxAge = 3600)
public class relanceRestController {


    @Autowired
    private relanceService Service;

    @GetMapping(value = "/")
    public List<Relance> findAll(){
        return this.Service.findAll();
    }

    @PostMapping(value = "/")
    public Relance createOne(@RequestBody Relance relance){
        return this.Service.createOne(relance);
    }


}
