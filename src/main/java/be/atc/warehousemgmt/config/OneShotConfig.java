package be.atc.warehousemgmt.config;

import be.atc.warehousemgmt.util.AppContext;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.InputStreamResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @author aidoumhaidi
 * @since 22/02/2016
 */

@Configuration
@ComponentScan(basePackages = {
        "be.atc.warehousemgmt.model",
        "be.atc.warehousemgmt.security",
        "be.atc.warehousemgmt.logic"
})
@Import({
        DatabaseConfig.class
})
public class OneShotConfig {

    private static void setEnv(String environment) {
        Map<String, String> newEnv = new HashMap<String, String>(System.getenv());

        newEnv.put("env", environment);

        try {
            Class<?> processEnvironmentClass = Class.forName("java.lang.ProcessEnvironment");

            Field theEnvironmentField = processEnvironmentClass.getDeclaredField("theEnvironment");
            theEnvironmentField.setAccessible(true);
            Map<String, String> env = (Map<String, String>) theEnvironmentField.get(null);
            env.putAll(newEnv);

            Field theCaseInsensitiveEnvironmentField = processEnvironmentClass.getDeclaredField("theCaseInsensitiveEnvironment");
            theCaseInsensitiveEnvironmentField.setAccessible(true);
            Map<String, String> cienv = (Map<String, String>) theCaseInsensitiveEnvironmentField.get(null);
            cienv.putAll(newEnv);
        } catch (NoSuchFieldException e) {
            try {
                Class<?>[] classes = Collections.class.getDeclaredClasses();
                Map<String, String> env = System.getenv();
                for (Class<?> cl : classes)
                    if ("java.util.Collections$UnmodifiableMap".equals(cl.getName())) {
                        Field field = cl.getDeclaredField("m");
                        field.setAccessible(true);
                        Object obj = field.get(env);
                        Map<String, String> map = (Map<String, String>) obj;
                        map.clear();
                        map.putAll(newEnv);
                    }
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        } catch (Exception e1) {
            throw new RuntimeException(e1);
        }
    }

    public static AbstractApplicationContext initApplicationContextFromEnvironment(String environment) {
        setEnv(environment);
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(OneShotConfig.class);
        AppContext.setApplicationContext(context);
        return context;
    }

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() throws FileNotFoundException {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        /* TODO CHANGE */
        ppc.setLocation(new InputStreamResource(new FileInputStream(new File("/Users/mikelcromphoudt/IdeaProjects/warehousemgmt/src/main/resources/" + "config/" + System.getenv("env") + "/warehousemgmt.properties"))));
        return ppc;
    }
}
