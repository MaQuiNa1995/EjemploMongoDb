package es.cic.cmunoz.backend.repository;

import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version 1.1.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:es/cic/cmunoz/backend/applicationContext.xml"}
)
public class ConectorTest {

    /**
     * Objeto de la clase a probar
     */
    @Autowired
    private ConectorImpl sut;

    /**
     * Método que se inicia cada vez que hacemos un test
     */
    @Before
    public void setUp() {

    }

    /**
     * Testeo del metodo prepararClienteTest
     */
    @Ignore
    @Test
    public void prepararClienteTest() {

        MongoDatabase baseDeDatos = sut.prepararCliente();

        assertNotNull(baseDeDatos);
    }

    /**
     * Testeo del metodo prepararClienteDeprecado
     */
    @Ignore
    @Test
    public void prepararClienteDeprecadoTest() {

        @SuppressWarnings("deprecation")
        DB baseDeDatos = sut.prepararClienteDeprecado();

        assertNotNull(baseDeDatos);
    }

    /**
     * Testeo del metodo guardarObjetoPredefinido
     */
    @Ignore
    @Test
    public void guardarObjetoPredefinidoTest() {
        boolean exito = sut.guardarObjetoPredefinido("coleccionTest");
        assertTrue(exito);
    }

    /**
     * Testeo del metodo verNombresBasesDatos
     */
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
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
    @Ignore
    @Test
    public void guardarJsonTest() {

        boolean exito = sut.guardarJson();
        assertTrue(exito);
    }

    @Ignore
    @Test
    public void ejecutarTest() {
        sut.guardadoUnMillon();
    }

    @Ignore
    @Test
    public void selectIds() {
        sut.selectIds();
    }

    @Ignore
    @Test
    public void selectCups() {
        sut.selectCups();
    }
    
    @Test
    public void selectFecha() {
        sut.selectFechas();
    }
}
