package es.cic.cmunoz.mongodbmascota.basedatos;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import es.cic.cmunoz.mongodbmascota.json.Campeon;
import es.cic.cmunoz.mongodbmascota.json.Habilidad;
import es.cic.cmunoz.mongodbmascota.json.Pasiva;
import es.cic.cmunoz.mongodbmascota.json.Skin;
import es.cic.cmunoz.mongodbmascota.json.Stats;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 * Clase ConectorImpl tiene métodos para conectarse y manipular una base de
 * datos hecha en mongoDb con el driver 3.4.2
 *
 * <p>
 * Fecha 18-abr-2017
 * <p>
 *
 * @version 1.0
 */
public final class ConectorImpl implements Conector {

    /**
     * Logger generico de la clase
     */
    private static final Logger LOG = Logger.getLogger(ConectorImpl.class.getName());

    /**
     * Constantes de la clase: URLBBDD: Direccion Base De Datos PUERTOBBDD:
     * Puerto Base De Datos BASEDATOS_NOMBRE: Nombre Base De Datos
     */
    private static final String URLBBDD = "localhost";
    private static final int PUERTOBBDD = 27017;
    private static final String BASEDATOS_NOMBRE = "pruebaJson";

    /**
     * Constructor genérico de clase
     */
    public ConectorImpl() {
        super();
    }

    /**
     * Método usado para la puesta a punto del cliente para la manipulación de
     * la base de datos
     *
     * @return conexion - objeto que contiene la conexión a la base de datos
     */
    @Override
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
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    @Override
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
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    private DB conexionBaseDatosDeprecado(MongoClient cliente) {

        DB conexionBaseDatos = cliente.getDB(BASEDATOS_NOMBRE);

        return conexionBaseDatos;
    }

    /**
     * Metodo usado para el guardado de un objeto escrito a fuego en el codigo
     *
     * @param nombreColeccion String que contiene el nombre de la colección
     * @return exito - Variable de control para indicar el exito de la operación
     */
    @Override
    public boolean guardarObjetoPredefinido(String nombreColeccion) {

        boolean exito = false;

        try {

            /**
             * Creacion del objeto mongoClient para la puesta a punto de la
             * conexión con la base de datos
             */
            try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

                /**
                 * llamada al metodo conexionBaseDatos(String) para recibir la
                 * conexión con la base de datos
                 */
                MongoDatabase conexion;
                conexion = conexionBaseDatos(mongoClient);
                LOG.log(Level.INFO, "Conexion con la base de datos exitosa");

                /**
                 * Busqueda de la coleccion donde queremos guardar el objeto
                 * anterior
                 */
                MongoCollection<Document> coleccionGuardar;
                coleccionGuardar = conexion.getCollection(nombreColeccion);

                LOG.log(Level.FINE, "Numero de colecciones en el documento: {0}", coleccionGuardar.count());

                /**
                 * Creación del objeto donde se guardará las clave/valor que
                 * queramos
                 */
                Document objetoGuardar = new Document();
                objetoGuardar.put("nombre", "Janna");
                objetoGuardar.put("rol", "Apoyo");
                objetoGuardar.put("maestria", 7);

                /**
                 * Guardado del objeto en la colección
                 */
                coleccionGuardar.insertOne(objetoGuardar);

                exito = true;
            }
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
    @Override
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
    @Override
    public List<String> verNombresBasesDatos() {

        List<String> listaConvertida;

        /**
         * Preparación del cliente de la base de datos
         */
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

            /**
             * Guardado de la lista de nombres de la base de datos
             */
            MongoIterable<String> listaNombresBaseDatos = mongoClient.listDatabaseNames();

            /**
             * Creación De Una Lista para convertir el MongoIterable así no da
             * excepción porque la conexión esté cerrada
             */
            listaConvertida = new ArrayList<>();

            /**
             * Sacamos cada valor y lo seteamos a la lista creada anteriormente
             */
            for (String nombreScado : listaNombresBaseDatos) {
                listaConvertida.add(nombreScado);
            }

            /**
             * Retorno de la lista
             */
            return listaConvertida;
        }

    }

    /**
     * Método usado para la recuperación en forma de SET de las colecciones de
     * la base de datos
     *
     * @return mapaColecciones - Set de los nombres de las bases de datos
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    @Override
    public Set<String> verColeccionesBaseDatos() {

        /**
         * Creacion del objeto mongoClient para la puesta a punto de la conexión
         * con la base de datos
         */
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

            /**
             * llamada al metodo conexionBaseDatosDeprecado(String) para recibir
             * la conexión con la base de datos
             */
            DB baseDatos = conexionBaseDatosDeprecado(mongoClient);

            /**
             * Guardado de los nombres de colecciones de la base de datos
             */
            Set<String> mapaColecciones = baseDatos.getCollectionNames();

            /**
             * retorno del objeto SET anterior
             */
            return mapaColecciones;
        }
    }

    /**
     * Método usado para el borrado de los registros de una colección
     *
     * @param nombreColeccion nombre de la coleccion a limpiar
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    @Override
    public boolean eliminarColeccion(String nombreColeccion) {
        boolean exito = false;
        /**
         * Creacion del objeto mongoClient para la puesta a punto de la conexión
         * con la base de datos
         */
        try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {
            try {

                /**
                 * llamada al metodo conexionBaseDatosDeprecado(String) para
                 * recibir la conexión con la base de datos
                 */
                DB baseDatos = conexionBaseDatosDeprecado(mongoClient);

                /**
                 * Busqueda de la coleccion a limpiar
                 */
                DBCollection coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

                /**
                 * Limpiado/borrado de la coleccion
                 */
                coleccionEncontrada.drop();

                exito = true;

            } catch (Exception e) {
                LOG.log(Level.WARNING, "Excepcion Al Limpiar La Coleccion Razon: {0}", e.getMessage());
            }
            return exito;
        }
    }

    /**
     * Método usado para comprobar la existencia de una coleccion
     *
     * @param coleccionBuscar nombre de la coleccion a borrar
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    @Override
    public boolean existeColeccion(String coleccionBuscar) {

        boolean exito = false;

        try {

            try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {
                /**
                 * llamada al metodo conexionBaseDatosDeprecado(String) para
                 * recibir la conexión con la base de datos
                 */
                DB baseDatos = conexionBaseDatosDeprecado(mongoClient);

                /**
                 * Busqueda de la coleccion a limpiar
                 */
                Set<String> listaNombresColecciones = baseDatos.getCollectionNames();

                for (String coleccionSacada : listaNombresColecciones) {
                    if (coleccionSacada.equalsIgnoreCase(coleccionBuscar)) {
                        exito = true;
                        break;
                    }
                }

                return exito;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            LOG.log(Level.WARNING, "Excepcion Al Comprobar Si Existe La Coleccion Razon: {0}", e.getMessage());
        }

        return exito;

    }

    /**
     * Método que imprime en pantalla el contenido de una colección
     *
     * @param coleccionBuscar nombre de la coleccion a consultar
     * @return listaInfoColeccion - lista que tiene el contenido de una colección
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    @Override
    public List<DBObject> verColeccionDeprecado(String coleccionBuscar) {
        List<DBObject> listaInfoColeccion = null;

        boolean exito = false;

        try {

            /**
             * Creación de la lista donde guardamos la información de la
             * colección
             */
            listaInfoColeccion = new ArrayList<>();

            try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

                /**
                 * llamada al metodo conexionBaseDatosDeprecado(String) para
                 * recibir la conexión con la base de datos
                 */
                DB baseDatos = conexionBaseDatosDeprecado(mongoClient);

                /**
                 * Busqueda de la coleccion
                 */
                DBCollection coleccionEncontrada = baseDatos.getCollection(coleccionBuscar);

                /**
                 * Creación del cursor que recorrerá la consulta
                 */
                try (DBCursor cursor = coleccionEncontrada.find()) {

                    /**
                     * añadido de los objetos que encontramos gracias al cursor
                     * a la lista a retornar
                     */
                    while (cursor.hasNext()) {
                        listaInfoColeccion.add(cursor.next());
                    }
                }
                /**
                 * Seteamos una variable booleana para controlar el exito de la
                 * operación
                 */
                exito = true;
            }

        } catch (Exception e) {
            exito = false;
            LOG.log(Level.WARNING, "Excepcion Al Recuperar Datos La Coleccion, Razon: {0}", e.getMessage());
        } finally {
            /**
             * Si hay excepción seteamos exito a false y la lista a null para
             * que no de falsos positivos en otro caso, no hará nada, y
             * devolverá normalmente la lista con los valores sacados
             */
            if (!exito) {
                listaInfoColeccion = null;
            }
        }

        return listaInfoColeccion;
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
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    @Override
    public boolean anadirCampo(String nombreColeccion, String buscarClave,
            String buscarValor, String claveNueva, String valorNuevo) {

        boolean exito = false;
        try {
            try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {
                /**
                 * llamada al metodo conexionBaseDatosDeprecado(String) para
                 * recibir la conexión con la base de datos
                 */
                DB baseDatos = conexionBaseDatosDeprecado(mongoClient);

                /**
                 * Busqueda de la coleccion
                 */
                DBCollection coleccionEncontrada;
                coleccionEncontrada = baseDatos.getCollection(nombreColeccion);

                /**
                 * Creación de un objeto para la preparación para la inserción
                 * de un nuevo campo
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
                exito = true;
            }
        } catch (Exception e) {

            LOG.log(Level.WARNING, "Excepcion Al Recuperar Datos La Coleccion, Razon: {0}", e.getMessage());
        }

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
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    @Override
    public boolean deleteRegistroContenidoEnLista(String nombreColeccion,
            String claveBuscar, List<String> lista) {

        boolean exito = false;

        try {
            try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {
                /**
                 * llamada al metodo conexionBaseDatosDeprecado(String) para
                 * recibir la conexión con la base de datos
                 */
                DB baseDatos = conexionBaseDatosDeprecado(mongoClient);

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
                exito = true;
            }
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
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    @Override
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

    /**
     * Metodo usado para la lectura de un archivo Json y la inserccion de los
     * valores leidos en la base de datos
     *
     * @return exito - Variable de control para indicar el exito de la operación
     */
    @Override
    public boolean guardarJson() {

        /**
         * Variable para indicar el éxito de la operación
         */
        boolean exito = false;

        try {

            /**
             * -----------------Campeones----------------
             *
             * Seteo de variables que usaremos
             */
            String nombreColeccion = "campeones";
            String archivo = "C:/Users/cmunoz/Desktop/campeones.json";

            /**
             * Objeto para parsear Json
             */
            JsonParser parser = new JsonParser();

            /**
             * Try con recursos para el objeto FileReader
             */
            try (FileReader fr = new FileReader(archivo)) {

                /**
                 * Objeto donde se guardan los datos obtenido del Json
                 */
                JsonElement datos = parser.parse(fr);

                /**
                 * Objeto necesario para el parseo a objeto java
                 */
                final Gson gson = new Gson();

                /**
                 * Parseo a objeto java desde json y guardado en un array
                 */
                Campeon[] listaCampeones = gson.fromJson(datos, Campeon[].class);

                /**
                 * Try con recursos para el objeto Mongoclient parala conexion a
                 * la base de datos
                 */
                try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

                    /**
                     * Conexion a base de datos
                     */
                    MongoDatabase conexion;
                    conexion = conexionBaseDatos(mongoClient);

                    /**
                     * Creacion del documento que tendrá la información de los
                     * objetos para su guardado en base de datos
                     */
                    MongoCollection<Document> coleccionGuardar;
                    coleccionGuardar = conexion.getCollection(nombreColeccion);

                    /**
                     * Lectura de la lista
                     */
                    for (Campeon hero : listaCampeones) {
                        /**
                         * Preparacion de los datos para su guardado en BBDD
                         */
                        Document objetoGuardar = new Document();
                        objetoGuardar.put("Id Campeon", hero.getId());
                        objetoGuardar.put("Mote", hero.getMote());
                        objetoGuardar.put("Nombre", hero.getNombre());
                        objetoGuardar.put("Rol", hero.getRol());
                        objetoGuardar.put("Lore", hero.getLore());
                        objetoGuardar.put("Coste", hero.getCoste());
                        coleccionGuardar.insertOne(objetoGuardar);
                    }
                }
            }

            String archivo2 = "C:/Users/cmunoz/Desktop/habilidades.json";
            nombreColeccion = "habilidades";
            /**
             * -----------------Habilidades----------------
             */
            try (FileReader fr = new FileReader(archivo2)) {

                JsonElement datos = parser.parse(fr);

                final Gson gson = new Gson();
                Habilidad[] heroes = gson.fromJson(datos, Habilidad[].class);

                try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

                    MongoDatabase conexion;
                    conexion = conexionBaseDatos(mongoClient);

                    MongoCollection<Document> coleccionGuardar;
                    coleccionGuardar = conexion.getCollection(nombreColeccion);

                    for (Habilidad hero : heroes) {
                        Document objetoGuardar = new Document();
                        objetoGuardar.put("Nombre", hero.getNombre());
                        objetoGuardar.put("Descripcion Corta", hero.getDescripcioncorta());
                        objetoGuardar.put("Descripcion Larga", hero.getDescripcionlarga());
                        objetoGuardar.put("Tecla", hero.getTecla());
                        if (hero.getCoste() != null) {
                            objetoGuardar.put("Coste", hero.getCoste());
                        }
                        if (hero.getEnfriamiento() != null) {
                            objetoGuardar.put("Enfriamiento", hero.getEnfriamiento());
                        }
                        objetoGuardar.put("Id Campeon", hero.getACampeon());
                        coleccionGuardar.insertOne(objetoGuardar);
                    }
                }
            }

            /**
             * -----------------Pasivas----------------
             */
            String archivo3 = "C:/Users/cmunoz/Desktop/pasivas.json";
            nombreColeccion = "pasivas";

            try (FileReader fr = new FileReader(archivo3)) {

                JsonElement datos = parser.parse(fr);

                final Gson gson = new Gson();
                Pasiva[] heroes = gson.fromJson(datos, Pasiva[].class);

                try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

                    MongoDatabase conexion;
                    conexion = conexionBaseDatos(mongoClient);

                    MongoCollection<Document> coleccionGuardar;
                    coleccionGuardar = conexion.getCollection(nombreColeccion);

                    for (Pasiva hero : heroes) {
                        Document objetoGuardar = new Document();
                        objetoGuardar.put("Id Campeon", hero.getACampeon());
                        objetoGuardar.put("Nombre", hero.getNombre());
                        objetoGuardar.put("Descripcion", hero.getDescripcion());
                        if (hero.getEnfriamiento() != null) {
                            objetoGuardar.put("Enfriamiento", hero.getEnfriamiento());
                        }
                        coleccionGuardar.insertOne(objetoGuardar);
                    }
                }
            }
            /**
             * -----------------Skins----------------
             */

            String archivo4 = "C:/Users/cmunoz/Desktop/skins.json";
            nombreColeccion = "skins";

            try (FileReader fr = new FileReader(archivo4)) {

                JsonElement datos = parser.parse(fr);

                final Gson gson = new Gson();
                Skin[] heroes = gson.fromJson(datos, Skin[].class);

                try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

                    MongoDatabase conexion;
                    conexion = conexionBaseDatos(mongoClient);

                    MongoCollection<Document> coleccionGuardar;
                    coleccionGuardar = conexion.getCollection(nombreColeccion);

                    for (Skin hero : heroes) {
                        Document objetoGuardar = new Document();
                        objetoGuardar.put("Id Campeon", hero.getACampeon());
                        objetoGuardar.put("Nombre", hero.getNombre());
                        objetoGuardar.put("Imagen", hero.getImagen());
                        if (hero.getCosteRP() != 0) {
                            objetoGuardar.put("Coste RP", hero.getCosteRP());
                        }
                        coleccionGuardar.insertOne(objetoGuardar);
                    }
                }
            }
            /**
             * -----------------Stats----------------
             */
            String archivo5 = "C:/Users/cmunoz/Desktop/stats.json";
            nombreColeccion = "stats";

            try (FileReader fr = new FileReader(archivo5)) {

                JsonElement datos = parser.parse(fr);

                final Gson gson = new Gson();
                Stats[] heroes = gson.fromJson(datos, Stats[].class);

                try (MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD)) {

                    MongoDatabase conexion;
                    conexion = conexionBaseDatos(mongoClient);

                    MongoCollection<Document> coleccionGuardar;
                    coleccionGuardar = conexion.getCollection(nombreColeccion);

                    for (Stats hero : heroes) {
                        Document objetoGuardar = new Document();
                        objetoGuardar.put("Id Campeon", hero.getACampeon());

                        objetoGuardar.put("Vida", hero.getVida());
                        objetoGuardar.put("Regeneracion De Vida", hero.getRegvida());

                        if (hero.getMana() != null) {
                            objetoGuardar.put("Mana", hero.getMana());
                            objetoGuardar.put("Regeneración De Mana", hero.getRegmana());
                        }

                        objetoGuardar.put("Ataque", hero.getAtaque());
                        objetoGuardar.put("Velocidad De Ataque", hero.getVeloataque());

                        objetoGuardar.put("Armadura", hero.getArmadura());
                        objetoGuardar.put("Resistencia Magica", hero.getResismagica());

                        objetoGuardar.put("Velocidad De Movimiento", hero.getVelomov());

                        coleccionGuardar.insertOne(objetoGuardar);
                    }
                }
            }
            /**
             * ponemos a true para indicar el exito de la operación
             */
            exito = true;

        } catch (Exception e) {
            /**
             * Captura de excepciones en un log
             */
            LOG.log(Level.WARNING, "Excepcion Al Leer Json, Razon: {0}", e.getMessage());
        }

        /**
         * Retorno de un booleano
         */
        return exito;

    }

//
//// -------------------------------------------------------- Metodos Pregunta StackOverflow ---------------------------------------------------
//// https://es.stackoverflow.com/q/63832/32964
//    /**
//     * Método simple para la conexión de una base de datos. Hace uso de metodos
//     * deprecados
//     */
//    @Deprecated
//    public void conectarBaseDatosDeprecado() {
//        try {
//
//            MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD);
//
//            DB baseDatosDeprecada = mongoClient.getDB(BASEDATOS_NOMBRE);
//
//            LOG.log(
//                    Level.INFO, "Conectando a Base De Datos: {0}...",
//                    baseDatosDeprecada.getName()
//            );
//
//            // metodo authenticate no existe
////            boolean auth = baseDatosDeprecada.authenticate(USUARIO, CONTRASENNA);
////
////            if (auth) {
////                LOG.log(Level.INFO, "Conexión Exitosa");
////            } else {
////                LOG.log(Level.INFO, "Conexión Fallida");
////            }
//        } catch (Exception e) {
//            LOG.log(
//                    Level.WARNING, "Excepcion Al Conectarse A La Base De Datos: {0}",
//                    e.getMessage()
//            );
//        }
//    }
//
//    /**
//     * Método simple para la conexión de una base de datos
//     */
//    public void conectarBaseDatosConAutentificacion() {
//
//        try {
//
//            MongoClient mongoClient = new MongoClient(URLBBDD, PUERTOBBDD);
//
//            MongoDatabase baseDatos = mongoClient.getDatabase("prueba");
//
//            LOG.log(Level.INFO, "Conectando a Base De Datos: {0}...", baseDatos.getName());
//
////            boolean auth = baseDatos.authenticate(USUARIO, CONTRASENNA);
////
////            if (auth) {
////                LOG.log(Level.INFO, "Conexión Exitosa");
////            } else {
////                LOG.log(Level.INFO, "Conexión Fallida");
////            }
//        } catch (Exception e) {
//            LOG.log(Level.WARNING, "Excepcion Al Conectarse A La Base De Datos: {0}", e.getMessage());
//
//        }
//    }
//        /**
//     * Metodo usado para la recuperacion de los valores de una coleccion en
//     * forma de coleccion
//     *
//     * @param nombreColeccion String que contiene el nombre de la colección a
//     * buscar
//     * @return coleccionEncontrada - Collection que contiene la coleccion
//     * encontrada
//     */
//    private MongoCollection<Document> buscarColeccion(String nombreColeccion) {
//
//        /**
//         * Preparación del cliente para la manipulacion de la base de datos
//         */
//        MongoDatabase baseDatos = prepararCliente();
//
//        LOG.log(Level.FINE, "Creando La Coleccion {0} Si No Existia", nombreColeccion);
//
//        /**
//         * Guardado de la coleccion en una variable
//         */
//        MongoCollection<Document> coleccionEncontrada = baseDatos.getCollection(nombreColeccion);
//
//        /**
//         * retorno de la coleccion
//         */
//        return coleccionEncontrada;
//
//    }
}
