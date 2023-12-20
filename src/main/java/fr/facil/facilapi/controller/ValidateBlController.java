package fr.facil.facilapi.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import fr.facil.facilapi.collections.ValidateBl;
import fr.facil.facilapi.repository.ValidateBlRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/validatebl")
public class ValidateBlController {

    @Autowired
    private ValidateBlRepository validateBlRepository;

    @GetMapping("/")
    public List<ValidateBl> findAll() {
        return validateBlRepository.findAll();
    }

    @GetMapping("/{id}")
    public ValidateBl findById(String id) {
        return validateBlRepository.findValidateBlById(id);
    }

    @PutMapping("/")
    public ValidateBl addValidateBl(@RequestBody ValidateBl validateBl) {
        return validateBlRepository.save(validateBl);
    }

    @PostMapping("/update")
    public ValidateBl updateValidateBl(@RequestBody ValidateBl validateBl) {
        return validateBlRepository.save(validateBl);
    }

    @DeleteMapping("/")
    public ValidateBl deleteValidateBl(@RequestBody ValidateBl validateBl) {

        ValidateBl validateBl1 = validateBlRepository.findValidateBlById(validateBl.getId());

        validateBl1.setActive(false);

        return validateBlRepository.save(validateBl1);
    }

    @GetMapping("/bl/{id}")
    public ValidateBl findByBl(@PathVariable String id) {
        ObjectId blId = new ObjectId(id);
        return validateBlRepository.findValidateBlByBl(blId);
    }

    @GetMapping("/affaire/{id}")
    public ValidateBl findByAffaire(@PathVariable String id) {

        //String to ObjectId
        ObjectId affaireId = new ObjectId(id);

        for(ValidateBl validateBl : validateBlRepository.findValidateBlByAffaire(affaireId)){
            List<ValidateBl> listValidateBl = validateBlRepository.findValidateBlByAffaire(affaireId);
            if (validateBl.isActive()) {
                return validateBl;
            }else if ((!listValidateBl.get(listValidateBl.size()-1).isActive())){
                return listValidateBl.get(listValidateBl.size()-1);
            }
        }

        return null;
    }

    @GetMapping("/commande/{id}")
    public ValidateBl findByCommande(@PathVariable String id) {
        ObjectId commandeId = new ObjectId(id);
        for(ValidateBl validateBl : validateBlRepository.findValidateBlByCommande(commandeId)){
            if (validateBl.isActive())
                return validateBl;
        }

        return null;
    }

    @GetMapping("/status/{status}")
    public List<ValidateBl> findByStatus(@PathVariable String status) {
        return validateBlRepository.findValidateBlByStatus(status);
    }

    @GetMapping("/active/{active}")
    public List<ValidateBl> findByActive(@PathVariable boolean active) {
        return validateBlRepository.findValidateBlByActive(active);
    }

    @GetMapping("/active/{active}/status/{status}")
    public List<ValidateBl> findByActiveAndStatus(@PathVariable boolean active,@PathVariable String status) {
        return validateBlRepository.findValidateBlByActiveAndStatus(active, status);
    }

    @GetMapping("/start/{start}/end/{end}")
    public List<ValidateBl> findByDateDebutAndDateFin(@PathVariable String start,@PathVariable String end) {

        List<ValidateBl> validateBlList = new ArrayList<>();

        for (ValidateBl validateBl : validateBlRepository.findAll()) {

            //change string format (YYYYMMDD) to date
            String dateCreate = validateBl.getDateCreated();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            try {
                Date dateCreated = sdf.parse(dateCreate);

                Date dateDebutR = sdf.parse(start);
                Date dateFinR = sdf.parse(end);

                if (dateCreated.after(dateDebutR) && dateCreated.before(dateFinR)) {
                    validateBlList.add(validateBl);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return validateBlList;
    }

    @GetMapping("/start/{start}/end/{end}/affaire/{affaire}")
    public List<ValidateBl> findByDateDebutAndDateFinAndAffaire(@PathVariable String start,@PathVariable String end,@PathVariable String affaire) {
        ObjectId affaireId = new ObjectId(affaire);

        List<ValidateBl> validateBlList = new ArrayList<>();

        for (ValidateBl validateBl : validateBlRepository.findValidateBlByAffaire(new ObjectId(affaire))) {

            //change string format (YYYYMMDD) to date
            String dateCreate = validateBl.getDateCreated();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            try {
                Date dateCreated = sdf.parse(dateCreate);

                Date dateDebutR = sdf.parse(start);
                Date dateFinR = sdf.parse(end);

                if (dateCreated.after(dateDebutR) && dateCreated.before(dateFinR)) {
                    if (validateBl.getAffaire().equals(affaireId)) {
                        validateBlList.add(validateBl);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return validateBlList;
    }

}
