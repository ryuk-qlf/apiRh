package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Yousign_document;
import fr.facil.facilapi.repository.YousignDocRepository;
import fr.facil.facilapi.supplement.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/yousign")
@CrossOrigin(origins = "*", maxAge = 3600)
public class YousignDocRestController {

    @Autowired
    private YousignDocRepository YousignRep;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping(value = "/")
    public List<Yousign_document> getAllYousign() {
        return YousignRep.findAll();
    }

    @GetMapping(value = "/{yousignId}")
    public Yousign_document getYousigneById(@PathVariable String yousignId) {
        return YousignRep.findYousign_documentById(yousignId);
    }

    @GetMapping(value = "/{type}/{num}")
    public Yousign_document findYousign_documentByTypeAndNum(@PathVariable String type, @PathVariable String num) {
        return YousignRep.findYousign_documentByTypeAndNum(type, num);
    }

    @PostMapping(value = "/create")
    public Yousign_document addYousign(@RequestBody Yousign_document document) {
        return YousignRep.save(document);
    }

    @DeleteMapping(value = "/delete/{YousignId}")
    public void deleteYoousign(@PathVariable String YousignId) {

        YousignRep.deleteById(YousignId);
    }

    @PutMapping(value = "/update/{YousignId}")
    public Yousign_document updateAffaire(@PathVariable String YousignId, @RequestBody Yousign_document document) {

        document.setId(YousignId);

        Yousign_document doc = YousignRep.findYousign_documentById(YousignId);

        document.setId_file(doc.getId_file());

        return YousignRep.save(document);
    }

    @PutMapping(value="/update/active/{yousignId}")
    public Yousign_document updateYousign(@PathVariable String yousignId){

        Yousign_document doc = YousignRep.findYousign_documentById(yousignId);

        doc.setActive(false);

        return YousignRep.save(doc);
    }

    @PostMapping(value="/add/comment/{id}/{message}")
    public Yousign_document updateComment(@PathVariable String id/*, @RequestBody Comment comment*/, @PathVariable String message){
        Yousign_document doc = YousignRep.findYousign_documentById(id);
        doc.setComment(message.replace('_', ' '));
        doc.setActive(false);

        return YousignRep.save(doc);
    }

}
