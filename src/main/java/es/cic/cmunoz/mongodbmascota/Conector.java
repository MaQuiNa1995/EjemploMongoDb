/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota;

import com.mongodb.BasicDBObject;
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
 *
 * Clase Conector tiene métodos para conectarse y manipular una base de datos
 * hecha en mongoDb con el driver 3.4.2
 *
 * @Autor cmunoz
 * @Fecha 18-abr-2017
 * @Version 1.1
 */
public final class Conector {

    /**
     * Logger generico de la clase
     */
    private static final Logger LOG = Logger.getLogger(Conector.class.getName());

    /**
     * Constantes de la clase: URLBBDD: Direccion Base De Datos PUERTOBBDD:
     * Puerto Base De Datos BASEDATOS_NOMBRE: Nombre Base De Datos
     */
    private static final String URLBBDD = "localhost";
    private static final int PUERTOBBDD = 27017;
//    private static final String USUARIO = "usuario";
//    private static final String CONTRASENNA = "contrasenna";
    private static final String BASEDATOS_NOMBRE = "PRUEBA";

    /**
     * Constructor genérico de clase
     */
    public Conector() {
        super();
    }

    /**
     * Método usado para la puesta a punto del cliente para la manipulación de
     * la base de datos
     *
     * @return conexion - objeto que contiene la conexión a la base de datos
     */
    public MongoDatabase prepararCliente() {

        LOG.log(Level.FINE, "Preparando cliente para la conexión a la base de datos");

        /**
         * Creacion del objeto mongoClient para la puesta a punto de la conexión
         * con la base de datos
         */
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

            /**
             * llamada al metodo conexionBaseDatos(String) para recibir la
             * conexión con la base de datos
             */
            MongoDatabase conexion = conexionBaseDatos(mongoClient);
            LOG.log(Level.INFO, "Conexion con la base de datos exitosa");

            /**
             * Retornamos la conexión
             */
            return conexion;
        }

    }

    /**
     * Método usado para la conexión con la base de datos
     *
     * @param cliente es el objeto que lleva la configuración de la base de
     * datos
     * @return conexionBaseDatos - es el objeto usado para retornar la conexión
     */
    private MongoDatabase conexionBaseDatos(MongoClient cliente) {

        MongoDatabase conexionBaseDatos = cliente.getDatabase(BASEDATOS_NOMBRE);

        return conexionBaseDatos;
    }

    /**
     * Método usado para la puesta a punto del cliente para la manipulación de
     * la base de datos
     *
     * @return conexion - objeto que contiene la conexión a la base de datos
     * @deprecated
     */
    @Deprecated
    public DB prepararClienteDeprecado() {

        LOG.log(Level.FINE, "Preparando cliente deprecado para la conexión a la base de datos");

        /**
         * Creacion del objeto mongoClient para la puesta a punto de la conexión
         * con la base de datos
         */
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

            /**
             * llamada al metodo conexionBaseDatosDeprecado(String) para recibir
             * la conexión con la base de datos
             */
            DB conexion = conexionBaseDatosDeprecado(mongoClient);
            LOG.log(Level.INFO, "Conexion deprecada con la base de datos exitosa");

            /**
             * Retornamos la conexión
             */
            return conexion;
        }

    }

    /**
     * Método usado para la conexión con la base de datos
     *
     * @param cliente es el objeto que lleva la configuración de la base de
     * datos
     * @return conexionBaseDatos - es el objeto usado para retornar la conexión
     * @deprecated
     */
    @Deprecated
    private DB conexionBaseDatosDeprecado(MongoClient cliente) {

        DB conexionBaseDatos = cliente.getDB(BASEDATOS_NOMBRE);

        return conexionBaseDatos;
    }

    /**
     * Metodo usado para la recuperacion de los valoresde una coleccion en forma
     * de coleccion
     *
     * @param nombreColeccion String que contiene el nombre de la colección a
     * buscar
     * @return coleccionEncontrada - Collection que contiene la coleccion
     * encontrada
     */
    private MongoCollection<Document> buscarColeccion(String nombreColeccion) {

        /**
         * Preparación del cliente para la manipulacion de la base de datos
         */
        MongoDatabase baseDatos = prepararCliente();

        LOG.log(Level.FINE, "Creando La Coleccion {0} Si No Existia", nombreColeccion);

        /**
         * Guardado de la coleccion en una variable
         */
        MongoCollection<Document> coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

        /**
         * retorno de la coleccion
         */
        return coleccionEncontrada;

    }

    /**
     * Metodo usado para el guardado de un objeto escrito a fuego en el codigo
     *
     * @param nombreColeccion String que contiene el nombre de la colección
     * @return exito - Variable de control para indicar el exito de la operación
     */
    public boolean guardarObjetoPredefinido(String nombreColeccion) {

        boolean exito = false;

        try {
            /**
             * Creación del objeto donde se guardará las clave/valor que
             * queramos
             */
            Document objetoGuardar = new Document();
            objetoGuardar.put("nombre", "Janna");
            objetoGuardar.put("rol", "Apoyo");
            objetoGuardar.put("maestria", 7);

            /**
             * Busqueda de la coleccion donde queremos guardar el objeto
             * anterior
             */
            MongoCollection<Document> coleccionGuardar = buscarColeccion(nombreColeccion);

            /**
             * Guardado del objeto en la colección
             */
            coleccionGuardar.insertOne(objetoGuardar);

            exito = true;

        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Insertar El Objeto Predefinido Razón: {0}", e.getMessage());
        }

        return exito;

    }

    /**
     * Metodo usado para borrar una base de dato entera
     *
     * @return exito - Variable de control para indicar el exito de la operación
     */
    public boolean borrarBaseDatos() {
        boolean exito = false;

        try {
            /**
             * preparación de la conexion a la base de datos
             */
            MongoDatabase baseDeDatos = prepararCliente();
            /**
             * borrado de la base de datos
             */
            baseDeDatos.drop();

            exito = true;
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Borrar Base De Datos Razón: {0}", e.getMessage());
        }

        return exito;
    }

    /**
     * Metodo usado para la obtención de los nombres de la base de datos en
     * forma de lista
     *
     * @return listaNombresBaseDatos - lista de los nombres de las bases de
     * datos
     */
    public MongoIterable<String> verNombresBasesDatos() {
        /**
         * Preparación del cliente de la base de datos
         */
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

            /**
             * Guardado de la lista de nombres de la base de datos
             */
            MongoIterable<String> listaNombresBaseDatos = mongoClient.listDatabaseNames();

            /**
             * Retorno de la lista
             */
            return listaNombresBaseDatos;
        }

    }

    /**
     * Método usado para la recuperación en forma de SET de las colecciones de
     * la base de datos
     *
     * @return mapaColecciones - Set de los nombres de las bases de datos
     * @deprecated
     */
    @Deprecated
    public Set<String> verColeccionesBaseDatos() {

        /**
         * Preparación del cliente para la manipulación de la base de de datos
         */
        DB baseDatos = prepararClienteDeprecado();

        /**
         * Guardado de los nombres de colecciones de la base de datos
         */
        Set<String> mapaColecciones = baseDatos.getCollectionNames();

        /**
         * retorno del objeto SET anterior
         */
        return mapaColecciones;
    }

    /**
     * Método usado para el borrado de los registros de una colección
     *
     * @param nombreColeccion nombre de la coleccion a limpiar
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated
     */
    @Deprecated
    public boolean limpiarColeccion(String nombreColeccion) {
        boolean exito = false;

        try {

            /**
             * Preparación del cliente para la manipulación de la base de datos
             */
            DB baseDatos = prepararClienteDeprecado();

            /**
             * Busqueda de la coleccion a limpiar
             */
            DBCollection coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

            /**
             * Limpiado de la coleccion
             */
            coleccionEncontrada.find().remove();

            exito = true;
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Limpiar La Coleccion Razon: {0}", e.getMessage());
            exito = false;
        }
        return exito;

    }

    /**
     * Método usado para la eliminación de una colección
     *
     * @param nombreColeccion nombre de la coleccion a borrar
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated
     */
    @Deprecated
    public boolean eliminarColeccion(String nombreColeccion) {

        boolean exito = false;

        try {

            /**
             * Preparación del cliente para la manipulación de la base de datos
             */
            DB baseDatos = prepararClienteDeprecado();

            /**
             * Busqueda de la coleccion a borrar
             */
            DBCollection coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

            /**
             * borrado de la coleccion
             */
            coleccionEncontrada.drop();

            exito = true;
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Dropear La Coleccion Razon: {0}", e.getMessage());
            exito = false;
        }
        return exito;
    }

    /**
     * Método usado para comprobar la existencia de una coleccion
     *
     * @param coleccionBuscar nombre de la coleccion a borrar
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated
     */
    @Deprecated
    public boolean existeColeccion(String coleccionBuscar) {

        /**
         * Preparación del cliente para la manipulación de la base de datos
         */
        DB baseDatos = prepararClienteDeprecado();

        /**
         * guardado en un booleano la existencia dela colección
         */
        boolean exito = baseDatos.collectionExists(coleccionBuscar);

        return exito;

    }

    /**
     * Método que imprime en pantalla elcontenido de una colección
     *
     * @param coleccionBuscar nombre de la coleccion a consultar
     * @deprecated
     */
    @Deprecated
    public void verColeccionDeprecado(String coleccionBuscar) {

        try {
            /**
             * Preparación del cliente para la manipulación de la base de datos
             */
            DB baseDatos = prepararClienteDeprecado();

            /**
             * Busqueda de la coleccion
             */
            DBCollection coleccionEncontrada = baseDatos.getCollection(coleccionBuscar);

            /**
             * Creación del cursor que recorrerá la consulta
             */
            try (DBCursor cursor = coleccionEncontrada.find()) {

                /**
                 * Impresión en pantalla de los registros de la colección
                 */
                System.out.print("Datos De La Coleccion: ");
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Recuperar Datos La Coleccion, Razon: {0}", e.getMessage());
        }
    }

    /**
     * Método usado para el update de un registro de una colección buscando por
     * clave y valor agregando un nuevo registro
     *
     * @param nombreColeccion String que contiene el nombre de una colección
     * @param buscarClave String que contiene la clave de la cual buscar el
     * objeto que queremos updatear
     * @param buscarValor String que contiene el valor de la cual buscar el
     * objeto que queremos updatear
     * @param claveNueva String que contiene la clave nueva
     * @param valorNuevo String que contiene el valor nuevo
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated
     */
    @Deprecated
    public boolean updateRegistro(String nombreColeccion, String buscarClave, String buscarValor, String claveNueva, String valorNuevo) {

        boolean exito = false;

        /**
         * Preparación del cliente para la manipulación de la base de datos
         */
        DB baseDatos = prepararClienteDeprecado();

        /**
         * Busqueda de la coleccion
         */
        DBCollection coleccionEncontrada;
        coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

        /**
         * Creación de un objeto para la preparación para la inserción de un
         * nuevo campo
         */
        BasicDBObject nuevoCampo;
        nuevoCampo = new BasicDBObject();
        nuevoCampo.append(
                "$set",
                new BasicDBObject().append(claveNueva, valorNuevo)
        );

        /**
         * Busca el/los registro/s con la clave y valor indicadas
         */
        BasicDBObject campoFusionar = new BasicDBObject();
        campoFusionar.append(buscarClave, buscarValor);

        /**
         * Realización de la actualización
         */
        coleccionEncontrada.updateMulti(campoFusionar, nuevoCampo);

        return exito;
    }

    /**
     * Método para la eliminación de registros que sean igual a algún elemento
     * de la lista que pasamos como parametro
     *
     * @param nombreColeccion Nombre de la colección en la que hacer el delete
     * @param claveBuscar Clave del registro de la que buscar
     * @param lista Lista de valores de los cuales queremos borrar todos los que
     * encuentre
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated
     */
    @Deprecated
    public boolean deleteRegistroContenidoEnLista(String nombreColeccion,
            String claveBuscar, List<String> lista) {

        boolean exito = false;

        try {
            /**
             * Preparación del cliente para la manipulación de la base de datos
             */
            DB baseDatos = prepararClienteDeprecado();

            /**
             * Busqueda de la coleccion
             */
            DBCollection coleccionEncontrada;
            coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

            /**
             * Busca el/los registro/s con la clave y valor indicadas
             */
            BasicDBObject query = new BasicDBObject();
            query.put(claveBuscar, new BasicDBObject("$in", lista));

            /**
             * eliminación del registro que encontró la query anterior
             */
            coleccionEncontrada.remove(query);
        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Hacer Remove, Razon: {0}", e.getMessage());
        }

        return exito;
    }

    /**
     * Método usado para el borrado de registros con una determinada condición
     *
     * @param nombreColeccion Nombre de la colección en la que hacer el delete
     * @param claveBuscar Clave del registro de la que buscar
     * @param valorBuscar Valor del registro de la que buscar
     * @param condicion String de la condición son iguales a bash "$gt" (greater
     * than)
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated
     */
    @Deprecated
    public boolean deleteRegistroCondicion(String nombreColeccion, String claveBuscar,
            String valorBuscar, String condicion) {

        boolean exito = false;

        try {

            /**
             * Preparación del cliente para la manipulación de la base de datos
             */
            DB baseDatos = prepararClienteDeprecado();

            /**
             * Busqueda de la coleccion
             */
            DBCollection coleccionEncontrada;
            coleccionEncontrada = baseDatos.getCollection(nombreColeccion);
            /**
             * Busca el/los registro/s con la clave y valor indicadas
             */

            BasicDBObject query = new BasicDBObject();
            query.put(claveBuscar, new BasicDBObject(condicion, valorBuscar));

            /**
             * eliminación del registro que encontró la query anterior
             */
            coleccionEncontrada.remove(query);

            exito = true;

        } catch (Exception e) {
            LOG.log(Level.WARNING, "Excepcion Al Hacer Remove, Razon: {0}", e.getMessage());
        }

        return exito;
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

            LOG.log(
                    Level.INFO, "Conectando a Base De Datos: {0}...",
                    baseDatosDeprecada.getName()
            );

            // metodo authenticate no existe
//            boolean auth = baseDatosDeprecada.authenticate(USUARIO, CONTRASENNA);
//
//            if (auth) {
//                LOG.log(Level.INFO, "Conexión Exitosa");
//            } else {
//                LOG.log(Level.INFO, "Conexión Fallida");
//            }
        } catch (Exception e) {
            LOG.log(
                    Level.WARNING, "Excepcion Al Conectarse A La Base De Datos: {0}",
                    e.getMessage()
            );
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
