package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.DocumentPosition;
import fr.facil.facilapi.exceptions.DocumentPositionNotFoundException;
import fr.facil.facilapi.repository.DocumentPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/document/position")
@CrossOrigin(origins = "*", maxAge = 3000)
public class DocumentPositionController {

    @Autowired
    private DocumentPositionRepository repository;

    @GetMapping("/")
    public List<DocumentPosition> getDocumentPosition(){
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public DocumentPosition getDocumentPositionById(@PathVariable String id){
        DocumentPosition documentPosition = this.repository.findDocumentPositionById(id);

        if(documentPosition==null) throw new DocumentPositionNotFoundException("Le document avec l'id " + id + " est INTROUVABLE");

        return documentPosition;
    }

    @GetMapping("/client/{client}")
    public List<DocumentPosition> getDocumentPositionByClient(@PathVariable String client){
        List<DocumentPosition> documentPosition = this.repository.findDocumentPositionByClient_Name(client);

        if(documentPosition==null) throw new DocumentPositionNotFoundException("Les documents avec le nom " + client + " sont INTROUVABLES");

        return documentPosition;
    }

    @GetMapping("/type/{type}")
    public List<DocumentPosition> getDocumentPositionByType(@PathVariable String type){
        List<DocumentPosition> documentPosition = this.repository.findDocumentPositionByType(type);

        if(documentPosition==null) throw new DocumentPositionNotFoundException("Les documents avec le type " + type + " sont INTROUVABLES");

        return documentPosition;
    }

    @GetMapping("/{client}/{type}")
    public DocumentPosition getDocumentPositionByClient_NameAndType(@PathVariable String client, @PathVariable String type){
        DocumentPosition documentPosition = this.repository.findDocumentPositionByTypeAndClient_Name(type, client);

        if(documentPosition==null) throw new DocumentPositionNotFoundException("Le document avec le nom " + client + " et le type "+ type +" est INTROUVABLE");

        return documentPosition;
    }

    @PutMapping("/")
    public DocumentPosition addDocumentPosition(@RequestBody DocumentPosition dp){
        return this.repository.save(dp);
    }

    @PatchMapping("/")
    public  DocumentPosition updateDocumentPosition(@RequestBody DocumentPosition dp){
        return this.repository.save(dp);
    }

}
