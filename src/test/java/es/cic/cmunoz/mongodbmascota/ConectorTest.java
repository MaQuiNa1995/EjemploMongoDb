/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota;

import com.mongodb.DB;
import com.mongodb.client.MongoDatabase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cmunoz
 */
public class ConectorTest {

    Conector sut;

    public ConectorTest() {
        super();
    }

    @Before
    public void setUp() {
        sut = new Conector();
    }

    @Test
    public void prepararClienteTest() {

        MongoDatabase baseDeDatos = sut.prepararCliente();

        assertNotNull(baseDeDatos);
    }
    @Test
    public void prepararClienteDeprecadoTest() {

        @SuppressWarnings("deprecation")
        DB baseDeDatos = sut.prepararClienteDeprecado();

        assertNotNull(baseDeDatos);
    }
    
    @Test
    public void guardarObjetoPredefinidoTest() {
        boolean exito = sut.guardarObjetoPredefinido("coleccionTest");
        assertTrue(exito);
    }

//    @Test
//    public void Test() {
//        
//    }
//
//    @Test
//    public void Test() {
//        
//    }
}
