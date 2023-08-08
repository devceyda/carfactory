package com.carfactory.carfactory.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carfactory.carfactory.entity.Brand;
import com.carfactory.carfactory.repository.Repository;
import com.carfactory.carfactory.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

    private List<Brand> allBrands;
    private Brand brand;
    Repository repository = new Repository();

    @Override
    public List<Brand> getAllBrand() {

        String query = "uspGetBrand";
        allBrands = new ArrayList<>();

        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            ResultSet rs = cb.executeQuery();
            while (rs.next()) {
                brand = new Brand();
                brand.setBrandID(rs.getInt("BrandID"));
                brand.setBrand(rs.getString("Brand"));
                allBrands.add(brand);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return allBrands;
    }
}
