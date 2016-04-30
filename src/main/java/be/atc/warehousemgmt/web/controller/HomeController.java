package be.atc.warehousemgmt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author ahmed idoumhaidi
 * @since 24/04/16
 */

@RequestMapping(value = "/HomeController/")
@Controller
public class HomeController {

    @RequestMapping(value = "getHomeView", method = RequestMethod.GET)
    public String getHomeView() {
        return "homeView";
    }

}
