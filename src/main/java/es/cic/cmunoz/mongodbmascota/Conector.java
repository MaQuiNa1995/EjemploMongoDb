/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * @Autor cmunoz
 * @Fecha 18-abr-2017
 */
public final class Conector {

    private static final Logger LOG = Logger.getLogger(Conector.class.getName());

    private static final String URLBBDD = "localhost";
    private static final int PUERTOBBDD = 27017;
//    private static final String USUARIO = "usuario";
//    private static final String CONTRASENNA = "contrasenna";
    private static final String BASEDATOS_NOMBRE = "PRUEBA";

    // TODO JAVADOC
    public Conector() {
        super();
    }

    // TODO JAVADOC
    public MongoDatabase prepararCliente() {
        LOG.info("Intentando conectar a base de datos...");
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {
            MongoDatabase conexion = conexionBaseDatos(mongoClient);
            LOG.log(Level.INFO, "Conexion con la base de datos exitosa");
            return conexion;
        }
    }

    private MongoDatabase conexionBaseDatos(MongoClient cliente) {
        return cliente.getDatabase(BASEDATOS_NOMBRE);
    }

    // TODO JAVADOC y quitar deprecados
    public MongoCollection<Document> buscarCrearColeccion(String nombreColeccion) {

        MongoDatabase baseDatos = prepararCliente();
        LOG.info("Conexión Exitosa A La Base De Datos");

        LOG.log(Level.INFO, "Creando La Coleccion {0} Si No Existia", nombreColeccion);

        MongoCollection<Document> coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

        return coleccionEncontrada;

    }

    // TODO JAVADOC y quitar deprecado
    public boolean guardarObjetoPredefinido(String nombreColeccion) {
        
        boolean exito=false;
        
        try {
            
            MongoCollection<Document> coleccionGuardar = buscarCrearColeccion(nombreColeccion);

            Document objetoGuardar = new Document();
            objetoGuardar.put("nombre", "Janna");
            objetoGuardar.put("rol", "Apoyo");
            objetoGuardar.put("maestria", 7);

            coleccionGuardar.insertOne(objetoGuardar);

            exito = true;
            
        } catch (Exception e) {
            // TODO mejor explicado
            LOG.log(Level.WARNING, "Excepcion Al Insertar Razón: {0}", e.getMessage());
            System.exit(1);
        } finally {
            return exito;
        }
    }

    // ----------------------- Metodos Pregunta StackOverflow -----------------------
    // https://es.stackoverflow.com/q/63832/32964
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
//            boolean auth = baseDatosDeprecada.authenticate(USUARIO, CONTRASENNA);
//
//            if (auth) {
//                LOG.log(Level.INFO, "Conexión Exitosa");
//            } else {
//                LOG.log(Level.INFO, "Conexión Fallida");
//            }
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

//            boolean auth = baseDatos.authenticate(USUARIO, CONTRASENNA);
//
//            if (auth) {
//                LOG.log(Level.INFO, "Conexión Exitosa");
//            } else {
//                LOG.log(Level.INFO, "Conexión Fallida");
//            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Conectarse A La Base De Datos: {0}", e.getMessage());
            System.exit(1);
        }
    }
}
