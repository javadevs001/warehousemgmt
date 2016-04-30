package be.atc.warehousemgmt.config;//package be.demo.note.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.util.Locale;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/2016
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private static final String TILES = "/WEB-INF/tiles/tiles.xml";
    private static final String VIEWS = "/WEB-INF/views/**/views.xml";

    private static final String RESOURCES_HANDLER = "/resources/";
    private static final String RESOURCES_LOCATION = RESOURCES_HANDLER + "**";
    private static final String MESSAGE_SOURCE = "classpath:i18n/messages";

    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
        requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
        requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
        requestMappingHandlerMapping.setInterceptors(new Object[]{getLocalChangeInterceptor()});
        return requestMappingHandlerMapping;
    }

    @Bean
    public TilesViewResolver configureTilesViewResolver() {
        return new TilesViewResolver();
    }

    @Bean
    public TilesConfigurer configureTilesConfigurer() {
        TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(TILES, VIEWS);
        return configurer;
    }

    @Bean(name = "messageSource")
    public MessageSource configureMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_SOURCE);
        messageSource.setCacheSeconds(5);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
        validator.setValidationMessageSource(configureMessageSource());
        return validator;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(RESOURCES_HANDLER).addResourceLocations(RESOURCES_LOCATION);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public LocaleChangeInterceptor getLocalChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lg");
        return localeChangeInterceptor;
    }

    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("fr"));
        return resolver;
    }

    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver getCommonsMultipartResolver() {
        return new CommonsMultipartResolver();
    }

}