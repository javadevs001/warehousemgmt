package be.atc.warehousemgmt.security;


import be.atc.warehousemgmt.web.controller.rest.JSResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author aidoumhaidi
 * @since 26/04/16
 */

public class AjaxAwareAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    public AjaxAwareAuthenticationEntryPoint(String loginUrl) {
        super(loginUrl);
    }

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {

        boolean isAjax = request.getRequestURI().startsWith("/warehousemgmt/api/secured");

        if (isAjax) {
            response.setStatus(403);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(new ObjectMapper().writeValueAsString(JSResponse.of(false, "expired")));
        } else {
            super.commence(request, response, authException);
        }
    }

}
