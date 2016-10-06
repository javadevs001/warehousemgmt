package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.box.Box;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Maximilien on 18/09/16.
 */
public interface BoxRepository extends JpaRepository<Box, Long> {

}
