package br.com.swagger.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
@ApiModel(description = "Todos os detalhes sobre o trabalhador")
public class Employee {

    @Id
    @ApiModelProperty(notes = "Id")
    private ObjectId _id;
    @ApiModelProperty(notes = "Nome do trabalhador")
    private String firstname;
    @ApiModelProperty(notes = "Sobrenome do trabalhador")
    private String lastname;
    @ApiModelProperty(notes = "Email do trabalhador")
    private String email;

    public Employee() {}

    public Employee(ObjectId _id, String firstname, String lastname, String email) {
        this._id = _id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstname, employee.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname);
    }
}
