package com.example.controller;

import com.example.entity.Weather;
import com.example.service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
public class WeatherController
{
    private WeatherService weatherService;

    @GetMapping
    public Weather getWeather(@RequestParam String city)
    {
        return weatherService.getWeather(city);
    }


}
