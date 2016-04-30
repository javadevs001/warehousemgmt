package be.atc.warehousemgmt.security;


import be.atc.warehousemgmt.config.Constants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;


/**
 * @author aidoumhaidi
 * @since 08/01/2016
 */

@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {
    @Override
    public String getCurrentAuditor() {
        String userName = SecurityUtils.getCurrentUserLogin();
        return (userName != null ? userName : Constants.SYSTEM_ACCOUNT);
    }
}
