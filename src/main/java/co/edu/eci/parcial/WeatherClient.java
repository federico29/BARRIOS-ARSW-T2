package co.edu.eci.parcial;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * Cliente unirest que realiza una petición al api del clima
 * @author Federico Barrios Meneses
 */
@Service
public class WeatherClient {

    /**
     * Método que realiza una petición get a una API externa que tiene información
     * del clima de varias ciudades del mundo
     * @param ciudad ciudad que se quiere consultar
     * @return información del clima de la ciudad
     * @throws UnirestException lanza una excepción si la petición falla
     */
    public JSONObject getCityWeather(String ciudad) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest
                .get("http://api.openweathermap.org/data/2.5/weather?q="+ciudad+"&APPID=32dcb808d4f4f1620401713d37e73e3a&units=metric")
                .asJson();
        return response.getBody().getObject();
    }
}
