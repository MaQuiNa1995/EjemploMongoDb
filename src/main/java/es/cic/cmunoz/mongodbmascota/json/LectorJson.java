/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.cic.cmunoz.mongodbmascota.json;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import es.cic.cmunoz.mongodbmascota.basedatos.ConectorImpl;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @autor cmunoz
 */
public class LectorJson {

    public LectorJson() {
        super();
    }
    
    public List<String> leerJson(){
        
        ConectorImpl conector;
        conector = new ConectorImpl();
        
        
        
        return null;
    }
}
