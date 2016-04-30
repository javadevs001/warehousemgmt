package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.User;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/16.
 **/

public interface UserService {
    User getUserByEmailAddress(String email);
}
