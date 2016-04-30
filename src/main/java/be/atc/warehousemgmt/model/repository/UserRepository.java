package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/2016
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
