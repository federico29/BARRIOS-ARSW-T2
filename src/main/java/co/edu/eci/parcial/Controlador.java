package co.edu.eci.parcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/path")
public class Controlador {

    @Autowired
    private Cliente cliente;

    @RequestMapping(value = "/{ciudad}", method = RequestMethod.GET)
    public ResponseEntity<?> get(@PathVariable("ciudad") String ciudad) {
        try {
            return new ResponseEntity<>(cliente.metodo(ciudad).toString(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}