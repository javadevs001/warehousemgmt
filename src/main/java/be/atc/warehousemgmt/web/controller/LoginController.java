package be.atc.warehousemgmt.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author ahmedidoumhaidi
 * @since 24/04/16
 */

@Controller
@RequestMapping(value = "/LoginController/")
public class LoginController {

    @RequestMapping(value = "getLoginView", method = RequestMethod.GET)
    private String getLoginView(Model model,
                                @RequestParam(required = false) boolean error,
                                @RequestParam(required = false) boolean logout,
                                @RequestParam(required = false) boolean unauthorized) {
        model.addAttribute("error", error);
        model.addAttribute("unauthorized", unauthorized);
        model.addAttribute("logout", logout);
        return "loginView";
    }
}
