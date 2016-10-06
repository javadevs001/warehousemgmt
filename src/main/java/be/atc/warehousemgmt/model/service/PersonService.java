package be.atc.warehousemgmt.model.service;


import be.atc.warehousemgmt.model.entity.Person;

import java.util.List;
import java.util.Optional;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public interface PersonService {

    Person savePerson(Person person);

    List<Person> getAllSuppliers();
    List<Person> getAllCustomers();

    boolean exists(Long personId);

    Person findPersonById(Long personId);

    Optional<Person> findByCompanyName(String companyName);

    boolean personExist(Long personId);

    Optional<Person> findByEmail(String email);

    void delete(Person supplier);

}
