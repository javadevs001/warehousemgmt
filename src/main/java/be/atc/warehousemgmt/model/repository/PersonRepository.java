package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

   /// List<Person> findAllByPersonType(PersonType supplier);
    List<Person> findAllByPersonType(PersonType customer);

}
