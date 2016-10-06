package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


/**
 * Created by ahmedidoumhaidi on 12/07/16.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByPersonType(PersonType supplier);

    Optional<Person> findByCompanyName(String companyName);

    Optional<Person> findByEmail (String email);
}
