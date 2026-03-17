package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Weather {
    private String cityName;
    private double temperature;
    private int humidity;
    private double windSpeed;
    private String description;
}
