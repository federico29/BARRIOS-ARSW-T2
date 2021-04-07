package co.edu.eci.parcial;

import java.util.HashMap;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Cache que almacena las peticiones realizadas, un dato almacenado por más de
 * cinco minutos no tiene validez
 * @author Federico Barrios Meneses
 */
@Service
public class WeatherCache {
    private final HashMap<String, DataAndTime> cache = new HashMap<>();
    
    /**
     * Indica si la ciudad ya fue consultada
     * @param city ciudad a consultar
     * @return true si ya fue consultada
     */
    public boolean isTheCitySaved(String city) {
        return cache.containsKey(city);
    }
    
    /**
     * Agrega a la caché un nuevo registro de una ciudad
     * @param city ciudad a agregar
     * @param data información de la ciudad
     */
    public void addCityWeather(String city, JSONObject data) {
        cache.put(city, new DataAndTime(data));
    }
    
    /**
     * Devuelve la información climática de la ciudad indicada
     * @param city ciudad
     * @return la información del clima de la ciudad
     */
    public JSONObject getCityWeather(String city) {
        return cache.get(city).getData();
    }
    
    /**
     * Devuelve el tiempo en milisegundos en que se almacenó un registro
     * @param city ciudad 
     * @return tiempo en milisegundos en que se almacenó un registro
     */
    public Long getTime(String city) {
        return cache.get(city).getTime();
    }
}
