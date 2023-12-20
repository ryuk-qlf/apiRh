package fr.facil.facilapi.controller;

import fr.facil.facilapi.collections.Employee;
import fr.facil.facilapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository repo;


    @GetMapping(value = "/")
    public List<Employee> getAll(){
        return this.repo.findAll();
    }


    @GetMapping(value ="/url/{url}")
    public Employee getByUrl(@PathVariable String url){
        return this.repo.findEmployeeByUrl(url);
    }


    @GetMapping(value = "/id/{id}")
    public Employee getByUuid(@PathVariable String id){
        return this.repo.findEmployeeById(id);
    }


    @PutMapping(value = "/")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.repo.save(employee);
    }

    @PostMapping(value = "/")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return this.repo.save(employee);
    }


}
