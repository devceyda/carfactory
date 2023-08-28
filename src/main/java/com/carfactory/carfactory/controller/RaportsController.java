package com.carfactory.carfactory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carfactory.carfactory.entity.CarRich;
import com.carfactory.carfactory.service.BrandService;
import com.carfactory.carfactory.service.CarService;
import com.carfactory.carfactory.service.ColorService;

@Controller
public class RaportsController {

    private BrandService brandService;
    private ColorService colorService;
    private CarService carService;

  

    public RaportsController(BrandService brandService, ColorService colorService, CarService carService) {
        this.brandService = brandService;
        this.colorService = colorService;
        this.carService = carService;
    }

    @GetMapping("/Raport")
    public String getRaports() {
        return "Raport";
    }

    @RequestMapping(value = "/CarRaport", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public HashMap<String, Integer> getCarData() {

      return carService.getRaports();
    }

    @RequestMapping(value = "/ColorRaport", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public HashMap<String, Integer> getColorData() {

      return colorService.getNumberOfColors();
    }

    @RequestMapping(value = "/BrandRaport", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
    @ResponseBody
    public HashMap<String, Integer> getBrandData() {

      return brandService.getNumberOfBrands();
    }


}
