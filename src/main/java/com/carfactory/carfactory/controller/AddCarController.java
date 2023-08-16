package com.carfactory.carfactory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.carfactory.carfactory.entity.Brand;
import com.carfactory.carfactory.entity.Car;
import com.carfactory.carfactory.entity.CarRich;
import com.carfactory.carfactory.entity.Color;
import com.carfactory.carfactory.service.BrandService;
import com.carfactory.carfactory.service.CarService;
import com.carfactory.carfactory.service.ColorService;

@Controller
public class AddCarController {

    private BrandService brandService;
    private ColorService colorService;
    private CarService carService;

    public AddCarController(BrandService brandService, ColorService colorService, CarService carService) {
        this.brandService = brandService;
        this.colorService = colorService;
        this.carService = carService;
    }

    @GetMapping("/Cars/addCar")
    public String addCarForm(Model model) {
        CarRich car = new CarRich();
        model.addAttribute("car", car);
        return "AddCar";
    }

    @PostMapping("/Cars/addCar")
    public String addCar(@ModelAttribute("car") Car car) {
        carService.addCar(car);
        return "redirect:/Cars";
    }

    @ModelAttribute("colors")
    public List<Color> getColors() {
        return colorService.getAllColor();
    }

    @ModelAttribute("brands")
    public List<Brand> getBrands() {
        return brandService.getAllBrand();
    }
}