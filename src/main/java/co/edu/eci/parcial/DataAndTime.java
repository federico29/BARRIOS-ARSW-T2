package co.edu.eci.parcial;

import org.json.JSONObject;

/**
 * Esta clase almacena un Objeto JSON y la hora en milisegundos en que se almacena
 * @author Federico Barrios Meneses
 */
public class DataAndTime {
    private JSONObject data;
    private Long time;
    
    /**
     * Constructor
     * @param data Objeto JSON que se va a almacenar
     */
    public DataAndTime(JSONObject data) {
        this.data = data;
        this.time = System.currentTimeMillis();
    }
    
    /**
     * Retorna el objeto JSON almacenado
     * @return objeto JSON almacenado
     */
    public JSONObject getData() {
        return this.data;
    }
    
    /**
     * Retorna la hora en que se almacenó el JSON
     * @return hora en milisegundos en que se almacenó el JSON
     */
    public Long getTime() {
        return this.time;
    }
}
