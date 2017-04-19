/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
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
    private static final String USUARIO = "usuario";
    private static final String CONTRASENNA = "contrasenna";

    public Conector() {
        super();
//        conectarBaseDatosConAutentificacion();
//        crearColeccion("tropas");
        
    }
    
    public MongoDatabase conectarBaseDatos(String nombreBaseDatos){
        LOG.info("Intentando conectar a base de datos...");
        try(MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)){
            MongoDatabase baseDatos = mongoClient.getDatabase(nombreBaseDatos);
            LOG.log(Level.INFO, "Conexion con la base de datos: {0} exitosa", baseDatos.getName());
            return baseDatos;
        }
    }

    /**
     * Método simple para la conexión de una base de datos. Hace uso de metodos
     * deprecados
     */
    public void conectarBaseDatosDeprecado() {
        try {

            MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD);

            DB baseDatosDeprecada = mongoClient.getDB("prueba");

            LOG.log(Level.INFO, "Conectando a Base De Datos: {0}...", baseDatosDeprecada.getName());

            // metodo authenticate no existe
            boolean auth = baseDatosDeprecada.authenticate(USUARIO, CONTRASENNA);

            if (auth) {
                LOG.log(Level.INFO, "Conexión Exitosa");
            } else {
                LOG.log(Level.INFO, "Conexión Fallida");
            }

        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Conectarse A La Base De Datos: {0}", e.getMessage());
            System.exit(1);
        }
    }

    /**
     * Método simple para la conexión de una base de datos
     */
    public void conectarBaseDatosConAutentificacion() {

        try {

            MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD);

            MongoDatabase baseDatos = mongoClient.getDatabase("prueba");

            LOG.log(Level.INFO, "Conectando a Base De Datos: {0}...", baseDatos.getName());

            boolean auth = baseDatos.authenticate(USUARIO, CONTRASENNA);

            if (auth) {
                LOG.log(Level.INFO, "Conexión Exitosa");
            } else {
                LOG.log(Level.INFO, "Conexión Fallida");
            }

        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Conectarse A La Base De Datos: {0}", e.getMessage());
            System.exit(1);
        }
    }

}
