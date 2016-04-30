package be.atc.warehousemgmt.config;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/2016
 */

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {
        "be.atc.warehousemgmt"
})
@Import({
        DatabaseConfig.class,
        WebMvcConfig.class,
})
@ImportResource(value = "classpath:spring-security-context.xml")
public class RootConfig {

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource("config/DEV/warehousemgmt.properties"));
        return ppc;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}