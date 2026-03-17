package com.example.service;


import com.example.entity.Weather;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService
{
        @Value("${weather.api.key}")
        private String apiKey;

        @Value("${weather.api.url}")
        private String apiurl;

        public Weather getWeather(String city)
        {
            String url = apiurl + "?q=" + city + "&appid=" + apiKey + "&units=metric";

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            try
            {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode json = mapper.readTree(response);

                Weather dto = new Weather();
                dto.setCityName(json.get("name").asText());
                dto.setTemperature(json.get("main").get("temp").asDouble());
                dto.setHumidity(json.get("main").get("humidity").asInt());
                dto.setWindSpeed(json.get("wind").get("speed").asDouble());
                dto.setDescription(json.get("weather").get(0).get("description").asText());
                return dto;
            }
            catch (Exception ex)
            {
                throw new IllegalStateException("Failed to parse weather API response", ex);
            }
        }

}
