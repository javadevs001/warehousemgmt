package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.person.Person;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */
public interface PersonService {

    List<Person> getAllSuppliers();

    Person getPersonById(Long personId);

}
