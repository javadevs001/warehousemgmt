package be.atc.warehousemgmt.web.controller;

import be.atc.warehousemgmt.model.service.DeliveryService;
import be.atc.warehousemgmt.web.controller.bean.DeliveryBean;
import org.omg.CORBA.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Wéry Lionel on 25/08/2016.
 */


@RequestMapping(value = "/HomeDeliveryController/")
@Controller

public class HomeDeliveryController {

    @RequestMapping (value = "getHomeDeliveryView" , method= RequestMethod.GET)

                    public String getHomeDeliveryView()
                    {return "HomeDelivery";}

      }

