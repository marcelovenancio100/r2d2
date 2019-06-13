package br.com.swagger.controllers;

import br.com.swagger.entities.Employee;
import br.com.swagger.repositories.EmployeeRepository;
import io.swagger.annotations.*;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Api(value="Sistema de Gestão de Trabalhadores", description="Operações referentes ao trabalhador no Sistema de Gestão de Trabalhadores")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    @ApiOperation(value = "Retorna uma lista de trabalhadores disponíveis", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista recuperada com sucesso"),
            @ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
            @ApiResponse(code = 403, message = "O recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    @ApiOperation(value = "Retorna um trabalhador a partir do id", response = Employee.class)
    public Employee getEmployee(@ApiParam(value = "Id do trabalhador para recuperação do objeto", required = true) @PathVariable("id") ObjectId id) {
        return employeeRepository.findBy_id(id);
    }

    @PostMapping("/employees")
    @ApiOperation(value = "Cria um trabalhador", response = Employee.class)
    public Employee createEmployee(@ApiParam(value = "Objeto do trabalhador para persistência", required = true) @Valid @RequestBody Employee employee) {
        employee.set_id(ObjectId.get());
        employeeRepository.save(employee);
        return employee;
    }

    @PutMapping("/employees/{id}")
    @ApiOperation(value = "Atualiza um trabalhador")
    public void updateEmployee(@ApiParam(value = "Id do trabalhador para atualização do objeto", required = true) @PathVariable("id") ObjectId id, @ApiParam(value = "Objeto do trabalhador para atualização", required = true) @Valid @RequestBody Employee employee) {
        employee.set_id(id);
        employeeRepository.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    @ApiOperation(value = "Exclui um trabalhador a partir do id")
    public void deleteEmployee(@ApiParam(value = "Id do trabalhador para exclusão do objeto", required = true) @PathVariable ObjectId id) {
        employeeRepository.delete(employeeRepository.findBy_id(id));
    }
}
