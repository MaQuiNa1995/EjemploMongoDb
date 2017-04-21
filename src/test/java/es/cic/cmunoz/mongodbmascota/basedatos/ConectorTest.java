/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota.basedatos;

import es.cic.cmunoz.mongodbmascota.basedatos.ConectorImpl;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmunoz
 */
public class ConectorTest {

    private ConectorImpl sut;

    public ConectorTest() {
        super();
    }

    @Before
    public void setUp() {
        sut = new ConectorImpl();
    }

//    @Test
//    public void prepararClienteTest() {
//
//        MongoDatabase baseDeDatos = sut.prepararCliente();
//
//        assertNotNull(baseDeDatos);
//    }
//
//    @Test
//    public void prepararClienteDeprecadoTest() {
//
//        @SuppressWarnings("deprecation")
//        DB baseDeDatos = sut.prepararClienteDeprecado();
//
//        assertNotNull(baseDeDatos);
//    }
//
//    @Test
//    public void guardarObjetoPredefinidoTest() {
//        boolean exito = sut.guardarObjetoPredefinido("coleccionTest");
//        assertTrue(exito);
//    }
//
//    @Test
//    public void verNombresbasesDatosTest() {
//
//        int contador = 0;
//        for (String nombreBasesDatos : sut.verNombresBasesDatos()) {
//            assertNotNull(nombreBasesDatos);
//            contador++;
//        }
//
//        assertTrue(0 < contador);
//    }
//
//    @Test
//    public void verColeccionesBaseDatosTest() {
//        /**
//         * Lo hago para que no esté vacía por si en la base de datos no hay
//         * ningun valor al hacer el test
//         */
//        sut.guardarObjetoPredefinido("coleccionTest");
//        @SuppressWarnings("deprecation")
//        Set<String> nombreColeccionSacada = sut.verColeccionesBaseDatos();
//
//        for (String nombreSacado : nombreColeccionSacada) {
//            assertNotNull(nombreSacado);
//        }
//
//        assertFalse(nombreColeccionSacada.isEmpty());
//    }
//
//    @Test
//    @SuppressWarnings("deprecation")
//    public void eliminarColeccionTest() {
//        /**
//         * Lo hago para que no esté vacía por si en la base de datos no hay
//         * ningun valor al hacer el test
//         */
//        sut.guardarObjetoPredefinido("coleccionTestLimpiar");
//        boolean exito = sut.eliminarColeccion("coleccionTestLimpiar");
//
//        assertTrue(exito);
//    }
//
//    @Test
//    @SuppressWarnings("deprecation")
//    public void existeColeccionTest() {
//        /**
//         * Lo hago para que no esté vacía por si en la base de datos no hay
//         * ningun valor al hacer el test
//         */
//        boolean exito = sut.guardarObjetoPredefinido("pruebaUno");
//        assertTrue(exito);
//        boolean existe = sut.existeColeccion("pruebaUno");
//        assertTrue(existe);
//        existe = sut.eliminarColeccion("pruebaUno");
//        assertTrue(existe);
//    }
//
//    @Test
//    @SuppressWarnings("deprecation")
//    public void verColeccionDeprecadoTest() {
//
//        String coleccion = "pruebaNueva";
//
//        sut.guardarObjetoPredefinido(coleccion);
//        List<DBObject> listaDatos = sut.verColeccionDeprecado(coleccion);
//
//        assertNotNull(listaDatos);
//        assertFalse(listaDatos.isEmpty());
//
//        for (DBObject objetoSacado : listaDatos) {
//            assertNotNull(objetoSacado);
//        }
//    }
//
//    @Test
//    public void anadirCampoTest() {
//        String nombreColeccion = "pruebaUpdate";
//
//        sut.guardarObjetoPredefinido(nombreColeccion);
//
//        @SuppressWarnings("deprecation")
//        boolean exito = sut.anadirCampo(nombreColeccion, "rol", "Apoyo", "Gratis", "Si");
//        assertTrue(exito);
//    }
//
//    @Test
//    @SuppressWarnings("deprecation")
//    public void deleteRegistroListaTest() {
//        String nombreColeccion = "pruebaDelete";
//
//        boolean exito = sut.guardarObjetoPredefinido(nombreColeccion);
//        assertTrue(exito);
//        
//        exito = sut.anadirCampo(nombreColeccion, "rol", "Apoyo", "Gratis", "Si");
//        assertTrue(exito);
//        
//        exito = sut.guardarObjetoPredefinido(nombreColeccion);
//        assertTrue(exito);
//        
//        
//       List<String> listaBorrar = new ArrayList<>();
//       listaBorrar.add("Si");
//       listaBorrar.add("Puede");
//        
//        exito = sut.deleteRegistroContenidoEnLista(nombreColeccion, "Gratis", listaBorrar);
//        assertTrue(exito);
//    }
    
    @Test
    public void Test() {
        
            boolean exito =sut.guardarObjetoPorJson("league");
            assertTrue(exito);
    }

}
