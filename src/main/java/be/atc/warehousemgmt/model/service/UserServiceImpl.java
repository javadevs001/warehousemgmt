package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.User;
import be.atc.warehousemgmt.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/16
 */

@Service
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public User getUserByEmailAddress(String email) {
        return userRepository.findByEmail(email);
    }
}
