package co.edu.eci.parcial;

import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherCache {
    private final HashMap<String, JSONObject> cache = new HashMap<>();
    
    public boolean isTheCitySaved(String city) {
        return cache.containsKey(city);
    }
    
    public void addCityWeather(String city, JSONObject data) {
        cache.put(city, data);
    }
    
    public JSONObject getCityWeather(String city) {
        return cache.get(city);
    }
}
