package com.carfactory.carfactory.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.carfactory.carfactory.entity.Brand;
import com.carfactory.carfactory.entity.Car;
import com.carfactory.carfactory.entity.CarRich;
import com.carfactory.carfactory.entity.Color;
import com.carfactory.carfactory.service.BrandService;
import com.carfactory.carfactory.service.CarService;
import com.carfactory.carfactory.service.ColorService;

@Controller
public class FactoryController {

    private BrandService brandService;
    private ColorService colorService;
    private CarService carService;

    public FactoryController(BrandService brandService, ColorService colorService, CarService carService) {
        this.brandService = brandService;
        this.colorService = colorService;
        this.carService = carService;
    }

    @GetMapping("/Cars")
    public String listCars(Model model) {
        model.addAttribute("Cars", carService.getAllCar());
        CarRich car = new CarRich();
        model.addAttribute("searchedCar", car);
        System.out.println(car.getPrice());
        System.out.println(car.getBrandID());
        return "Cars";
    }

    @ModelAttribute("colors")
    public List<Color> getColors() {
        return colorService.getAllColor();
    }

    @ModelAttribute("brands")
    public List<Brand> getBrands() {
        return brandService.getAllBrand();
    }

    @GetMapping("/Cars/update/{id}")
    public String updateCardForm(@PathVariable Integer id, Model model) {
        model.addAttribute("Car", carService.getCarByID(id));
        return "UpdateCar";
    }

    @PostMapping("/Cars/{id}")
    public String updateCar(@PathVariable Integer id,
            @ModelAttribute("Car") Car car,
            Model model) {
        // int CarID =Integer.parseInt(id);
        // get student from database by id
        Car existingCar = carService.getCarByID(id);
        existingCar.setCarID(id);
        existingCar.setColorID(car.getColorID());
        existingCar.setBrandID(car.getBrandID());
        existingCar.setModel(car.getModel());
        existingCar.setPrice(car.getPrice());
        existingCar.setGearType(car.getGearType());
        existingCar.setFuelType(car.getFuelType());
        existingCar.setIsRefurbished(car.getIsRefurbished());
        existingCar.setReleaseDate(car.getReleaseDate());

        // save updated student object
        carService.updateCar(existingCar);
        return "redirect:/Cars";
    }

    @GetMapping("/Cars/{id}")
    public String deleteCar(@PathVariable Integer id) {
        carService.deleteCarByID(id);
        return "redirect:/Cars";
    }

    // @PostMapping("/Cars")
    // public void SearchCar(
    // @RequestParam(name = "searchByBrand") Integer BrandID,
    // @RequestParam(name = "searchByModel") String Model,
    // @RequestParam(name = "searchByColor") Integer ColorID,
    // @RequestParam(name = "searchByPrice") Long Price,
    // @RequestParam(name = "searchByGearType") String GearType,
    // @RequestParam(name = "searchByFuelType") String FuelType,
    // @RequestParam(name = "searchByReleaseDate") Date ReleaseDate,
    // @RequestParam(name = "searchByIsRefurbished") Boolean IsRefurbished) {

    // if(BrandID != null){
    // System.out.println("succesful");
    // }

    // }

    @PostMapping( "/Cars" )
    public String SearchCar(@ModelAttribute("searchedCar") Car searchedCar) {
        System.out.println(searchedCar.getBrandID());
        return "redirect:/Cars";
    }

}
