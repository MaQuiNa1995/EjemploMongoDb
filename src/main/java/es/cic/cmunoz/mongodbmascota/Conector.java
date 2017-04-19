/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Autor cmunoz
 * @Fecha 18-abr-2017
 */
public final class Conector {

    private static final Logger LOG = Logger.getLogger(Conector.class.getName());

    private static final String URLBBDD = "localhost";
    private static final int PUERTOBBDD = 27017;

    public Conector() {
        super();
        conectarBaseDatos("barracon");
        
    }
    
    public MongoDatabase conectarBaseDatos(String nombreBaseDatos){
        LOG.info("Intentando conectar a base de datos...");
        try(MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)){
            MongoDatabase baseDatos = mongoClient.getDatabase(nombreBaseDatos);
            LOG.log(Level.INFO, "Conexion con la base de datos: {0} exitosa", baseDatos.getName());
            return baseDatos;
        }
    }

}
