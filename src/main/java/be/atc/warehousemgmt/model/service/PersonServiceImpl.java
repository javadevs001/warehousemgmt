package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.person.Person;
import be.atc.warehousemgmt.model.entity.person.PersonType;
import be.atc.warehousemgmt.model.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Inject
    private PersonRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Person> getAllSuppliers() {
        return personRepository.findAllByType(PersonType.SUPPLIER);
    }

    @Override
    public Person getPersonById(Long personId) {
        return personRepository.findOne(personId);
    }
}
