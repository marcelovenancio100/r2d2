package br.com.swagger.repositories;

import br.com.swagger.entities.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

    public Employee findBy_id(ObjectId _id);
}
