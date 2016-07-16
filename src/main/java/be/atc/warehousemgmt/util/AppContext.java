package be.atc.warehousemgmt.util;

import org.springframework.context.ApplicationContext;

/**
 * @author aidoumhaidi
 * @since 11/04/16
 */

public class AppContext {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        AppContext.applicationContext = applicationContext;
    }
}
