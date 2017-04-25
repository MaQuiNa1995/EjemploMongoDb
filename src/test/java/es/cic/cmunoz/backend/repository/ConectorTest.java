package es.cic.cmunoz.backend.repository;

import es.cic.cmunoz.backend.repository.ConectorImpl;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @version 1.1.1
 */
public class ConectorTest {

    /**
     * Objeto de la clase a probar
     */
    private ConectorImpl sut;

    /**
     * Constructor genérico
     */
    public ConectorTest() {
        super();
    }

    /**
     * Método que se inicia cada vez que hacemos un test
     */
    @Before
    public void setUp() {
        sut = new ConectorImpl();
    }

    /**
     * Testeo del metodo prepararClienteTest
     */
    @Test
    public void prepararClienteTest() {

        MongoDatabase baseDeDatos = sut.prepararCliente();

        assertNotNull(baseDeDatos);
    }

    /**
     * Testeo del metodo prepararClienteDeprecado
     */
    @Test
    public void prepararClienteDeprecadoTest() {

        @SuppressWarnings("deprecation")
        DB baseDeDatos = sut.prepararClienteDeprecado();

        assertNotNull(baseDeDatos);
    }

    /**
     * Testeo del metodo guardarObjetoPredefinido
     */
    @Test
    public void guardarObjetoPredefinidoTest() {
        boolean exito = sut.guardarObjetoPredefinido("coleccionTest");
        assertTrue(exito);
    }

    /**
     * Testeo del metodo verNombresBasesDatos
     */
    @Test
    public void verNombresbasesDatosTest() {

        int contador = 0;
        for (String nombreBasesDatos : sut.verNombresBasesDatos()) {
            assertNotNull(nombreBasesDatos);
            contador++;
        }

        assertTrue(0 < contador);
    }

    /**
     * Testeo del metodo guardarObjetoPredefinido
     */
    @Test
    public void verColeccionesBaseDatosTest() {
        /**
         * Lo hago para que no esté vacía por si en la base de datos no hay
         * ningun valor al hacer el test
         */
        sut.guardarObjetoPredefinido("coleccionTest");
        @SuppressWarnings("deprecation")
        Set<String> nombreColeccionSacada = sut.verColeccionesBaseDatos();

        for (String nombreSacado : nombreColeccionSacada) {
            assertNotNull(nombreSacado);
        }

        assertFalse(nombreColeccionSacada.isEmpty());
    }

    /**
     * Testeo del metodo eliminarColeccion
     */
    @Test
    @SuppressWarnings("deprecation")
    public void eliminarColeccionTest() {
        /**
         * Lo hago para que no esté vacía por si en la base de datos no hay
         * ningun valor al hacer el test
         */
        sut.guardarObjetoPredefinido("coleccionTestLimpiar");
        boolean exito = sut.eliminarColeccion("coleccionTestLimpiar");

        assertTrue(exito);
    }

    /**
     * Testeo del metodo existeColeccion
     */
    @Test
    @SuppressWarnings("deprecation")
    public void existeColeccionTest() {
        /**
         * Lo hago para que no esté vacía por si en la base de datos no hay
         * ningun valor al hacer el test
         */
        boolean exito = sut.guardarObjetoPredefinido("pruebaUno");
        assertTrue(exito);
        boolean existe = sut.existeColeccion("pruebaUno");
        assertTrue(existe);
        existe = sut.eliminarColeccion("pruebaUno");
        assertTrue(existe);
        existe = sut.existeColeccion("pruebaUno");
        assertFalse(existe);
    }

    /**
     * Testeo del metodo verColeccionDeprecado
     */
    @Test
    @SuppressWarnings("deprecation")
    public void verColeccionDeprecadoTest() {

        String coleccion = "pruebaNueva";

        sut.guardarObjetoPredefinido(coleccion);
        List<DBObject> listaDatos = sut.verColeccionDeprecado(coleccion);

        assertNotNull(listaDatos);
        assertFalse(listaDatos.isEmpty());

        for (DBObject objetoSacado : listaDatos) {
            assertNotNull(objetoSacado);
        }
    }

    /**
     * Testeo del metodo anadirCampo
     */
    @Test
    public void anadirCampoTest() {
        String nombreColeccion = "pruebaUpdate";

        sut.guardarObjetoPredefinido(nombreColeccion);

        @SuppressWarnings("deprecation")
        boolean exito = sut.anadirCampo(nombreColeccion, "rol", "Apoyo", "Gratis", "Si");
        assertTrue(exito);
    }

    /**
     * Testeo del metodo deleteRegistroContenidoEnLista
     */
    @Test
    @SuppressWarnings("deprecation")
    public void deleteRegistroListaTest() {
        String nombreColeccion = "pruebaDelete";

        boolean exito = sut.guardarObjetoPredefinido(nombreColeccion);
        assertTrue(exito);

        exito = sut.anadirCampo(nombreColeccion, "rol", "Apoyo", "Gratis", "Si");
        assertTrue(exito);

        exito = sut.guardarObjetoPredefinido(nombreColeccion);
        assertTrue(exito);

        List<String> listaBorrar = new ArrayList<>();
        listaBorrar.add("Si");
        listaBorrar.add("Puede");

        exito = sut.deleteRegistroContenidoEnLista(nombreColeccion, "Gratis", listaBorrar);
        assertTrue(exito);
    }

    /**
     * Testeo del metodo guardarJson
     */
    @Test
    public void guardarJsonTest() {

        boolean exito = sut.guardarJson();
        assertTrue(exito);
    }

}
