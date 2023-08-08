package com.carfactory.carfactory.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.carfactory.carfactory.entity.Color;
import com.carfactory.carfactory.repository.Repository;
import com.carfactory.carfactory.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {
    private List<Color> allColors;
    private Color color;
    Repository repository = new Repository();

    @Override
    public List<Color> getAllColor() {
        allColors = new ArrayList<>();
        String query = "uspGetColor";

        try {
            Connection conn = repository.getConnection();
            CallableStatement cb = conn.prepareCall(query);
            ResultSet rs = cb.executeQuery();
            while (rs.next()) {
                color = new Color();
                color.setColorID(rs.getInt("ColorID"));
                color.setColor(rs.getString("Color"));
                allColors.add(color);

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return allColors;
    }

}
