/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void prepararClienteTest() {

        MongoDatabase baseDeDatos = sut.prepararCliente();

        assertNotNull(baseDeDatos);
    }

    @Test
    public void buscarCrearColeccionTest() {

        MongoCollection<Document> coleccionDevuelta;
        coleccionDevuelta = sut.buscarCrearColeccion("coleccionNueva");

        assertNotNull(coleccionDevuelta);
    }

    @Test
    public void guardarObjetoPredefinidoTest() {
        sut.guardarObjetoPredefinido("coleccionNueva");
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
