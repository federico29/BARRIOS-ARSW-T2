package co.edu.eci.parcial;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de la aplicación, crea los endpoints que atenderán las peticiones
 * @author Federico Barrios Meneses
 */
@RestController
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    private WeatherServices service;

    /**
     * Petición get que se realiza a los servicios, devuelve la información del 
     * clima de una ciudad
     * @param ciudad ciudad que se consulta
     * @return información del clima de la ciudad
     */
    @RequestMapping(value = "/{ciudad}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable("ciudad") String ciudad) {
        try {
            return new ResponseEntity<>(service.getCityWeather(ciudad), HttpStatus.ACCEPTED);
        } catch (UnirestException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}