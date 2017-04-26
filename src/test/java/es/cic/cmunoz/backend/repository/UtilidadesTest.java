package es.cic.cmunoz.backend.repository;

import es.cic.cmunoz.backend.util.Utilidades;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilidadesTest {

    private Utilidades sut;

    public UtilidadesTest() {
        super();
    }

    @Before
    public void setUp() {
        sut = new Utilidades();
    }

//    @Test
//    public void generarIdTest() {
//        Map<String, Integer> mapaIds = sut.generarId();
//
//        for (String objSacado : mapaIds.keySet()) {
//            assertNotNull(objSacado);
//        }
//        
//        assertEquals(1000000, mapaIds.size());
//    }
//
//    @Test
//    public void generaCupsTest() {
//        Map<String, String> mapaIds = sut.generarCups();
//
//        assertEquals(1000000, mapaIds.size());
//    }
//
//    @Test
//    public void generarFechasTest() {
//        Map<String, String> mapaIds = sut.generarFechas();
//
//        assertEquals(1000000, mapaIds.size());
//    }
//
//    @Test
//    public void generarCampoValoresTest() {
//        Map<String, Integer> mapaIds = sut.generarMagnitud();
//
//        assertEquals(1000000, mapaIds.size());
//    }
//
//    @Test
//    public void generarFlagTest() {
//        Map<String, Integer> mapaIds = sut.generarFlags();
//
//        assertEquals(1000000, mapaIds.size());
//    }
}
