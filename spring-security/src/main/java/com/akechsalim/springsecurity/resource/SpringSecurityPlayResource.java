package com.akechsalim.springsecurity.resource;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityPlayResource {

    @GetMapping
    public CsrfToken retrieveCSRFToken(HttpServletRequest request){
        return(CsrfToken) request.getAttribute("_csrf");

    }

}


