/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota.basedatos;

/**
 * @version 1.0
 */
public class ConectorJuacho {

    public ConectorJuacho() {

    }

    private boolean generarCups() {

        boolean exito = false;

        final String PRINCIPIOCUPS = "ES002770000000";
        final String FINCUPS = "10F";
        for (int i = 0; i < 1000000; i++) {
            StringBuilder sb = new StringBuilder(PRINCIPIOCUPS);
            sb.append(i);
            sb.append(FINCUPS);
        }

        exito = true;

        return true;
    }
    private String annadirCeros(String sinCeros){
        
        // TODO Añadir tantos ceros como length falte para conseguir que sea  000 000 000
        String ConCeros="";
        
        return ConCeros;
    }

//    private boolean generarId() {
//
//        boolean exito = false;
//        StringBuilder
//        “ES0027700000000000000010F
//        ” 
//        
//        exito = true;
//
//        return true;
//    }
}
