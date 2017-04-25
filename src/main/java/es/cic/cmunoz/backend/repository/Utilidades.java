/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.backend.repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 */
public class Utilidades {

    public Utilidades() {
        super();
    }

    private Map<String, String> generarCups() {

        final String PRINCIPIOCUPS = "ES00277000000000";
        final String FINCUPS = "0F";

        Map<String, String> mapaCups = new HashMap<>();

        for (int i = 1; i < 1000001; i++) {
            String cadenaConvertida = annadirCeros(String.valueOf(i));

            StringBuilder sb = new StringBuilder(PRINCIPIOCUPS);
            sb.append(cadenaConvertida);
            sb.append(FINCUPS);

        }

        return mapaCups;
    }

    private String annadirCeros(String cadenaSinCeros) {

        StringBuilder sb = new StringBuilder();

        int cerosAgregar = 7 - cadenaSinCeros.length();

        if (cerosAgregar != 0) {
            for (int i = 0; i < cerosAgregar; i++) {
                sb.append("0");
            }
        }

        String cadenaConvertida = sb.append(cadenaSinCeros).toString();

        return cadenaConvertida;
    }

    private Map<String, Integer> generarId() {

        Map<String, Integer> mapaIds = new HashMap<>();

        for (int i = 1; i < 1000001; i++) {
            mapaIds.put("Id", i);
        }

        return mapaIds;
    }
}
