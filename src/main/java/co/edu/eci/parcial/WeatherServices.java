package co.edu.eci.parcial;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase de servicios para consultar la información del clima de una ciudad
 * @author Federico Barrios Meneses
 */
@Service
public class WeatherServices {
    
    @Autowired
    private WeatherClient client;
    
    @Autowired
    private WeatherCache cache;
    
    /**
     * Examina la caché de la aplicación, si la petición que se necesita ya está
     * almacenada la retorna desde la caché, si no realiza ordena una petición 
     * unirest a una API externa
     * @param city ciudad que se quiere consultar
     * @return información del clima de la ciudad
     * @throws UnirestException lanza una excepción si la petició falló
     */
    public synchronized String getCityWeather(String city) throws UnirestException {
        if (!cache.isTheCitySaved(city) || System.currentTimeMillis() - 
                cache.getTime(city) == 300000) {
            JSONObject data = client.getCityWeather(city);
            cache.addCityWeather(city, data);
            return data.toString();
        } else {
            return cache.getCityWeather(city).toString();
        }
    }
}
