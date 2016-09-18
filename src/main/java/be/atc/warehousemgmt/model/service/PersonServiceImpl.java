package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.PersonType;
import be.atc.warehousemgmt.model.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllSuppliers() {
        return personRepository.findAllByPersonType(PersonType.Supplier);
    }
    @Override
    public List<Person> getAllCustomers() {return personRepository.findAllByPersonType(PersonType.Customer);}
    @Override
    public boolean exists(Long personId) {
        return personRepository.exists(personId);
    }

    @Override
    public Person findPersonById(Long personId) {
        return personRepository.findOne(personId);
    }

}
