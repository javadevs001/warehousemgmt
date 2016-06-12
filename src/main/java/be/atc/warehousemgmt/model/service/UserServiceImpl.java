package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.User;
import be.atc.warehousemgmt.model.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/16
 */

@Service
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Inject
    private UserRepository userRepository;

    @Override
    public User getUserByEmailAddress(String email) {
        return userRepository.findByEmail(email);
    }

    @Scheduled(cron = "0 57 17 1/1 * ?") /* Utiliser le site http://www.cronmaker.com/ pour générer vos CRON */
    private void synchroTest() {
        logger.debug("Ceci est un test de synchro automatique ... ");
    }
}
