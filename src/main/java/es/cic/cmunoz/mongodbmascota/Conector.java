/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
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

    private MongoClient mongoClient;
    private MongoDatabase mongoDataBase;

    private static final Logger LOG = Logger.getLogger(Conector.class.getName());

    private static final String URLBBDD = "localhost";
    private static final int PUERTOBBDD = 27017;
    private static final String USUARIO = "usuario";
    private static final String CONTRASENNA = "contrasenna";
    private static final String BASEDATOS_NOMBRE = "PRUEBA";

    // TODO JAVADOC
    public Conector() {
        super();
    }

    // TODO JAVADOC
    public void prepararCliente() {

        LOG.info("Intentando conectar a base de datos...");
        mongoClient = new MongoClient(URLBBDD, PUERTOBBDD);

        mongoDataBase = conexionBaseDatos(mongoClient);
        
        LOG.log(Level.INFO, "Conexion con la base de datos exitosa");

    }

    private MongoDatabase conexionBaseDatos(MongoClient cliente) {
        return cliente.getDatabase(BASEDATOS_NOMBRE);
    }

    // TODO JAVADOC y quitar deprecados
    public MongoCollection<Document> buscarCrearColeccion(String nombreColeccion) {

        LOG.info("Conexión Exitosa A La Base De Datos");

        LOG.log(Level.INFO, "Creando La Coleccion {0} Si No Existia", nombreColeccion);

        MongoCollection<Document> coleccionEncontrada = mongoDataBase.getCollection(nombreColeccion);

        return coleccionEncontrada;

    }

    // TODO JAVADOC y quitar deprecado
    public boolean guardarObjetoPredefinido(String nombreColeccion) {

        boolean exito = false;

        MongoCollection<Document> coleccionGuardar;
        coleccionGuardar = mongoDataBase.getCollection(nombreColeccion);

        Document objetoGuardar = new Document();
        objetoGuardar.put("nombre", "Nautilus");
        objetoGuardar.put("rol", "Tanque");
        objetoGuardar.put("maestria", 6);

        coleccionGuardar.insertOne(objetoGuardar);

        exito = true;

        return exito;

    }

    @Deprecated
    public void verColeccionDeprecado() {

        try {

            DB db = mongoClient.getDB(BASEDATOS_NOMBRE);
            System.out.println("Connect to database successfully");

            DBCollection coll = db.getCollection("mycol");
            System.out.println("Collection mycol selected successfully");

            try (DBCursor cursor = coll.find()) {
                int i = 1;

                while (cursor.hasNext()) {
                    System.out.println("Inserted Document: " + i);
                    System.out.println(cursor.next());
                    i++;
                }
            }

        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void cerrarConexiones() {
        mongoClient.close();
        
    }

// ----------------------- Metodos Pregunta StackOverflow -----------------------
// https://es.stackoverflow.com/q/63832/32964
    /**
     * Método simple para la conexión de una base de datos. Hace uso de metodos
     * deprecados
     */
    @Deprecated
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
