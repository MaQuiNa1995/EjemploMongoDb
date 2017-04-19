/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.cic.cmunoz.mongodbmascota;

/**
 * @Autor cmunoz
 * @Fecha 18-abr-2017
 */
public class Main {

    public static void main(String[] args) {
        Conector conector = new Conector();
        conector.prepararCliente();
//        conector.buscarCrearColeccion("mycol");
//        conector.guardarObjetoPredefinido("mycol");
        conector.verColeccionDeprecado();
        conector.cerrarConexiones();
    }

}
