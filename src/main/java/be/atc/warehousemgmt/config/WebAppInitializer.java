package be.atc.warehousemgmt.config;


import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author ahmed idoumhaidi
 * @since 24/04/2016
 */

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(RootConfig.class.getName());
        servletContext.addListener(new ContextLoaderListener(context));

        initCharacterEncodingFilter(servletContext);
        setDefaultHTMLEscape(servletContext);
        initSecurityFilter(servletContext);
        initLogBack();

        DispatcherServlet servlet = new DispatcherServlet();
        // no explicit configuration reference here: everything is configured in the root container for simplicity
        servlet.setContextConfigLocation("");

        ServletRegistration.Dynamic appServlet = servletContext.addServlet("appServlet", servlet);
        appServlet.setLoadOnStartup(1);
        appServlet.setAsyncSupported(true);

        Set<String> mappingConflicts = appServlet.addMapping("/");
        if (!mappingConflicts.isEmpty()) {
            throw new IllegalStateException("'appServlet' cannot be mapped to '/'");
        }
    }

    public void initCharacterEncodingFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
    }

    public void initLogBack() {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator jc = new JoranConfigurator();
        jc.setContext(loggerContext);
        loggerContext.reset();
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("logback.xml");
            if (is == null) {
                System.out.println("Logback xml file not found");
            } else {
                jc.doConfigure(is);
            }
        } catch (JoranException ex) {
            System.out.println("Logback contextInitialized error");
            StatusPrinter.print(loggerContext);
            ex.printStackTrace();
        }
    }

    public void setDefaultHTMLEscape(ServletContext servletContext) {
        servletContext.setInitParameter("defaultHtmlEscape", "true");
    }

    public void initSecurityFilter(ServletContext servletContext) {
        FilterRegistration.Dynamic securityFilter = servletContext.addFilter("securityFilter", new DelegatingFilterProxy("springSecurityFilterChain"));
        securityFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}