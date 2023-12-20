package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.DocumentF;
import fr.facil.facilapi.repository.DocumentFRepository;
import fr.facil.facilapi.service.DocumentFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/documentf")
public class DocumentFRestController {

    @Autowired
    private DocumentFService service;

    @Autowired
    private DocumentFRepository repository;


    @GetMapping("/")
    public List<DocumentF> findAll(){
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public DocumentF findById(@PathVariable String id){
        return this.service.findById(id);
    }

    @GetMapping("/title/{title}")
    public DocumentF findByTitle(@PathVariable String title){
        return this.service.findByTitle(title);
    }

    @GetMapping("/type/{type}")
    public List<DocumentF> findByType(@PathVariable String type){
        return this.service.findByType(type);
    }

    @PostMapping("/")
    public DocumentF add(@RequestBody DocumentF doc){
        return this.service.add(doc);
    }

    @DeleteMapping("/")
    public DocumentF remove(@RequestBody DocumentF doc){
        return this.service.remove(doc);
    }
}
