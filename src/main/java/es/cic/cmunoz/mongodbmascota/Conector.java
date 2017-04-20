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
import com.mongodb.client.MongoIterable;
import java.util.List;
import java.util.Set;
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

    @Deprecated
    public DB prepararClienteDeprecado() {

        LOG.info("Intentando conectar a base de datos...");
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

            DB conexion = conexionBaseDatosDeprecado(mongoClient);
            LOG.log(Level.INFO, "Conexion con la base de datos exitosa");

            return conexion;
        }

    }

    @Deprecated
    private DB conexionBaseDatosDeprecado(MongoClient cliente) {
        return cliente.getDB(BASEDATOS_NOMBRE);
    }

    // TODO JAVADOC y quitar deprecados
    private MongoCollection<Document> buscarCrearColeccion(String nombreColeccion) {

        MongoDatabase baseDatos = prepararCliente();
        LOG.info("Conexión Exitosa A La Base De Datos");

        LOG.log(Level.INFO, "Creando La Coleccion {0} Si No Existia", nombreColeccion);

        MongoCollection<Document> coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

        return coleccionEncontrada;

    }

    // TODO JAVADOC y quitar deprecado
    public boolean guardarObjetoPredefinido(String nombreColeccion) {

        boolean exito = false;

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
            exito = false;
        }

        return exito;

    }

    public boolean borrarBaseDatos() {
        boolean exito = false;

        try {
            MongoDatabase a = prepararCliente();
            a.drop();
        } catch (Exception e) {
            // TODO mejor explicado
            LOG.log(Level.WARNING, "Excepcion Al Insertar Razón: {0}", e.getMessage());
            exito = false;
        }

        return exito;
    }

    public MongoIterable<String> verNombresBasesDatos() {
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

            MongoIterable<String> listaNombresBaseDatos = mongoClient.listDatabaseNames();

            return listaNombresBaseDatos;
        }

    }

    @Deprecated
    public Set<String> verColeccionesBaseDatos() {

        DB baseDatos = prepararClienteDeprecado();

        Set<String> mapaColecciones = baseDatos.getCollectionNames();

        return mapaColecciones;
    }

    @Deprecated
    public boolean actualizarCampo() {
        boolean exito = false;

        return exito;
    }

    @Deprecated
    public boolean eliminarColeccion(String nombreColeccion) {

        boolean exito = false;

        try {

            DB baseDatos = prepararClienteDeprecado();

            DBCollection coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

            coleccionEncontrada.drop();

        } catch (Exception e) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return exito;
    }

    @Deprecated
    public boolean existeColeccion(String coleccionBuscar) {

        DB baseDatos = prepararClienteDeprecado();

        return baseDatos.collectionExists(coleccionBuscar);

    }

    @Deprecated
    public void verColeccionDeprecado(String coleccionBuscar) {

        try {
            DB baseDatos = prepararClienteDeprecado();
            System.out.println("Connect to database successfully");

            DBCollection coleccionEncontrada = baseDatos.getCollection(coleccionBuscar);

            System.out.println("Collection mycol selected successfully");

            try (DBCursor cursor = coleccionEncontrada.find()) {
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

            DB baseDatosDeprecada = mongoClient.getDB(BASEDATOS_NOMBRE);

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
