package be.atc.warehousemgmt.model.service;


import be.atc.warehousemgmt.model.entity.Person;

import java.util.List;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public interface PersonService {

    Person savePerson(Person person);

    List<Person> getAllSuppliers();

    boolean exists(Long personId);

    Person findPersonById(Long personId);

}
