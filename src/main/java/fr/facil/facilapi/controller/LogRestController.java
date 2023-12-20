package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Log;
import fr.facil.facilapi.repository.LogRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LogRestController {

    @Autowired
    private LogRepository LogRep;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping(value = "/")
    public List<Log> getAllLog() {
        return LogRep.findAll();
    }

    @GetMapping(value = "/{logId}")
    public Log getLogById(@PathVariable String logId) {
        return LogRep.findLogById(logId);
    }

    @GetMapping(value = "/{type}/{num}")
    public List<Log> getLogsByTypeandNum(@PathVariable String type, @PathVariable String num){
        return LogRep.findLogsByTypeAndNumeroBl(type, num);
    }

    @GetMapping(value = "/message/{message}")
    public List<Log> getLogsByMessage(@PathVariable String message){
        return LogRep.findLogsByMessage(message);
    }



    @PostMapping(value = "/create")
    public Log addLog(@RequestBody Log log) {
        return LogRep.save(log);
    }

    @DeleteMapping(value = "/delete/{logId}")
    public void deleteLog(@PathVariable String logId) {
        LogRep.deleteById(logId);
    }




    @PutMapping(value = "/change/status/{logId}")
    public Log changeState(@PathVariable String logId){

        Log log = LogRep.findLogById(logId);

        log.setActive(false);

        return LogRep.save(log);
    }

}
