package fr.facil.facilapi.repository;

import fr.facil.facilapi.collections.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    Employee findEmployeeById(String id);

    Employee findEmployeeByUrl(String url);
}
