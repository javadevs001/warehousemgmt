package be.atc.warehousemgmt.security;

import be.atc.warehousemgmt.model.entity.Role;
import be.atc.warehousemgmt.model.entity.User;
import be.atc.warehousemgmt.model.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/2016
 **/

@Service
public class SecurityService implements UserDetailsService {

    @Inject
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        User user = userService.getUserByEmailAddress(emailAddress);
        if (user == null) return null;
        List<GrantedAuthority> grantedAuthorities = buildUserAuthority(user.getRoles());
        return buildUserForAuthentication(user, grantedAuthorities);
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        for (Role role : roles) {
            setAuths.add(new SimpleGrantedAuthority(role.getRoleName().name()));
        }
        return new ArrayList<GrantedAuthority>(setAuths);
    }

}
