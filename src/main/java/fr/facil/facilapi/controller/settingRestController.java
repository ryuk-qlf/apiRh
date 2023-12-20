package fr.facil.facilapi.controller;

import fr.facil.facilapi.repository.settingRepository;
import fr.facil.facilapi.supplement.Setting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LoggingInitializationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setting")
@CrossOrigin(origins = "*", maxAge = 3600)
public class settingRestController {

    @Autowired
    private settingRepository settingRepository;

    Logger logger = LoggerFactory.getLogger(LoggingInitializationContext.class);

    @GetMapping("/")
    public List<Setting> getAllSettings(){
        return settingRepository.findAll();
    }

    @PostMapping("/add")
    public void addSetting(@RequestBody Setting setting){
        settingRepository.save(setting);
    }

    @PutMapping("/update/{settingId}")
    public void updateSetting(@RequestBody Setting setting, @PathVariable String settingId){

        Setting mySetting = settingRepository.findSettingById(settingId);

        if (mySetting != null){
            setting.setId(mySetting.getId());
        }

        settingRepository.save(setting);

    }

}
