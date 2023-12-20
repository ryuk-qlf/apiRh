package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Calendar;
import fr.facil.facilapi.service.calendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/calendar")
@CrossOrigin(origins = "*", maxAge = 3600)
public class calendarRestController {

    @Autowired
    private calendarService service;


    @GetMapping("/")
    public List<Calendar> getAll(){
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Calendar getById(@PathVariable String id){
        return this.service.findById(id);
    }

    @GetMapping("/{prenom}/{nom}")
    public List<Calendar> getAllByUsername(@PathVariable String prenom, @PathVariable String nom){
        return this.service.findAllByUsername(prenom, nom);
    }



    @PutMapping("/")
    public Calendar createOne(@RequestBody Calendar cal){
        return this.service.createOne(cal);
    }

    @PutMapping("/send")
    public void sendOne(@RequestBody Calendar cal) throws IOException, ParseException {
        this.service.sendOne(cal);
    }

    @PatchMapping("/{id}")
    public Calendar updateOne(@RequestBody Calendar cal,@PathVariable String id){
        return this.service.updateOne(cal, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable String id){
        this.service.deleteOne(id);
    }


}
