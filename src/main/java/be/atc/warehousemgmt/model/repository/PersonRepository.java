package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.person.Person;
import be.atc.warehousemgmt.model.entity.person.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by ahmedidoumhaidi on 19/06/16.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByType(PersonType type);
}
