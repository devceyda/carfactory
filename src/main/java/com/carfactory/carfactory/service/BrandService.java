package com.carfactory.carfactory.service;

import java.util.HashMap;
import java.util.List;

import com.carfactory.carfactory.entity.Brand;
import com.carfactory.carfactory.entity.BrandRich;

public interface BrandService {

    List<Brand> getAllBrand();

    HashMap<String, Integer> getNumberOfBrands();

    HashMap<String, BrandRich> getPriceListOfBrand();

}
