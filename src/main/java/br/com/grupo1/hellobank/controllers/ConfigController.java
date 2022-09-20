package br.com.grupo1.hellobank.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class ConfigController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public RedirectView swaggerUi() {
        return new RedirectView("/swagger-ui/index.html");
    }
}