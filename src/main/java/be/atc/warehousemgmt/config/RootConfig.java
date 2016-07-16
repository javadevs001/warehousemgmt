package be.atc.warehousemgmt.config;


import be.atc.warehousemgmt.util.AppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/2016
 */

@Configuration
@EnableWebSecurity
@EnableScheduling
@ComponentScan(basePackages = {
        "be.atc.warehousemgmt"
})
@Import({
        DatabaseConfig.class,
        WebMvcConfig.class,
})
@ImportResource(value = "classpath:spring-security-context.xml")
public class RootConfig {

    @Autowired
    public ApplicationContext applicationContext;

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("config/DEV/warehousemgmt.properties"));
        return ppc;
    }

    @PostConstruct
    public void postConstruct() {
        AppContext.setApplicationContext(this.applicationContext);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}