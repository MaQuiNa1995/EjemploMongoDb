package es.cic.cmunoz.mongodbmascota.basedatos;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 */
public interface Conector {

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
     * deprecados que podrían ser eliminados en un futuro No se recomienda el
     * uso de esta funcion ya que usa elementos deprecados que podrían ser
     * eliminados en un futuro
     */
    @Deprecated
    boolean anadirCampo(String nombreColeccion, String buscarClave, String buscarValor, String claveNueva, String valorNuevo);

    /**
     * Metodo usado para borrar una base de dato entera
     *
     * @return exito - Variable de control para indicar el exito de la operación
     */
    boolean borrarBaseDatos();

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
    boolean deleteRegistroCondicion(String nombreColeccion, String claveBuscar, String valorBuscar, String condicion);
    //
    //// ----------------------- Metodos Pregunta StackOverflow -----------------------
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
    boolean deleteRegistroContenidoEnLista(String nombreColeccion, String claveBuscar, List<String> lista);

    /**
     * Método usado para el borrado de los registros de una colección
     *
     * @param nombreColeccion nombre de la coleccion a limpiar
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    boolean eliminarColeccion(String nombreColeccion);

    /**
     * Método usado para comprobar la existencia de una coleccion
     *
     * @param coleccionBuscar nombre de la coleccion a borrar
     * @return exito - Variable de control para indicar el exito de la operación
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    boolean existeColeccion(String coleccionBuscar);

    /**
     * Metodo usado para el guardado de un objeto escrito a fuego en el codigo
     *
     * @param nombreColeccion String que contiene el nombre de la colección
     * @return exito - Variable de control para indicar el exito de la operación
     */
    boolean guardarObjetoPredefinido(String nombreColeccion);

    /**
     * Método usado para la puesta a punto del cliente para la manipulación de
     * la base de datos
     *
     * @return conexion - objeto que contiene la conexión a la base de datos
     */
    MongoDatabase prepararCliente();

    /**
     * Método usado para la puesta a punto del cliente para la manipulación de
     * la base de datos
     *
     * @return conexion - objeto que contiene la conexión a la base de datos
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    DB prepararClienteDeprecado();

    /**
     * Método que imprime en pantalla elcontenido de una colección
     *
     * @param coleccionBuscar nombre de la coleccion a consultar
     * @return listaInfoColeccion - lista que tiene el contenido de una
     * colección
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    List<DBObject> verColeccionDeprecado(String coleccionBuscar);

    /**
     * Método usado para la recuperación en forma de SET de las colecciones de
     * la base de datos
     *
     * @return mapaColecciones - Set de los nombres de las bases de datos
     * @deprecated No se recomienda el uso de esta funcion ya que usa elementos
     * deprecados que podrían ser eliminados en un futuro
     */
    @Deprecated
    Set<String> verColeccionesBaseDatos();

    /**
     * Metodo usado para la obtención de los nombres de la base de datos en
     * forma de lista
     *
     * @return listaNombresBaseDatos - lista de los nombres de las bases de
     * datos
     */
    List<String> verNombresBasesDatos();

    /**
     * Metodo usado para la lectura de un archivo Json y la inserccion de los
     * valores leidos en la base de datos
     *
     * @return exito - Variable de control para indicar el exito de la operación
     */
    boolean guardarJson();
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
