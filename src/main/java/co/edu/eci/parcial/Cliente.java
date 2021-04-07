package co.edu.eci.parcial;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class Cliente {

    public JSONObject metodo(String ciudad) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest
                .get("http://api.openweathermap.org/data/2.5/weather?q="+ciudad+"&APPID=32dcb808d4f4f1620401713d37e73e3a")
                .asJson();
        return response.getBody().getObject();
    }
}
