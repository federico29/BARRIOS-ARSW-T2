package co.edu.eci.parcial;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServices {
    
    @Autowired
    private WeatherClient client;
    
    @Autowired
    private WeatherCache cache;
    
    public String getCityWeather(String city) throws UnirestException {
        if (!cache.isTheCitySaved(city)) {
            JSONObject data = client.getCityWeather(city);
            cache.addCityWeather(city, data);
            return data.toString();
        } else {
            return cache.getCityWeather(city).toString();
        }
    }
}
