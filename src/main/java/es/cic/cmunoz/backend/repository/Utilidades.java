/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.backend.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @version 1.0
 */
public class Utilidades {

    public Utilidades() {
        super();
    }

    /**
     * ------------------ Generadores de Mapas -------------------------
     */
    
    /**
     *
     * @return
     */
    public Map<String, String> generarCups() {

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

    /**
     *
     * @return
     */
    public Map<String, Integer> generarId() {

        Map<String, Integer> mapaIds = new HashMap<>();

        for (int i = 1; i < 1000001; i++) {
            mapaIds.put("Id", i);
        }

        return mapaIds;
    }

    /**
     *
     * @return
     */
    public Map<String, String> generarFechas() {

        final String ANNO = "2016";
        final int arraymeses[] = generarDiasMeses();

        int registrosCompletados = 0;

        Map<String, String> mapaFechas = new HashMap<>();

        do {

            int contadorMeses = 1;

            for (int mes : arraymeses) {

                for (int dia = 1; dia < mes + 1; dia++) {

                    StringBuilder fechaCompleta = new StringBuilder();

                    fechaCompleta.append(ANNO);
                    fechaCompleta.append(formatearDiaMes(contadorMeses));
                    fechaCompleta.append(formatearDiaMes(dia));

                    mapaFechas.put("fecha", fechaCompleta.toString());
                    if (registrosCompletados<1000000) {
                        registrosCompletados++;
                    } else{
                        return mapaFechas;
                    }

                }
                contadorMeses++;
            }

        } while (registrosCompletados < 1000000);

        return mapaFechas;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> generarCampoValores() {

        Map<String, Integer> mapaFechas = new HashMap<>();

        for (int i = 0; i < 25; i++) {
            mapaFechas.put("valores", 1678);
        }

        return mapaFechas;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> generarFlags() {

        Map<String, Integer> mapaFechas = new HashMap<>();

        for (int i = 0; i < 25; i++) {
            Random rand = new Random();
            int numAleatorio = rand.nextInt(1);

            mapaFechas.put("flag", numAleatorio);
        }

        return mapaFechas;
    }

    /**
     * ------------------------- Utilitarios ----------------------------
     */
    private int[] generarDiasMeses() {

        final int ENERO = 31;
        final int MARZO = 31;
        final int MAYO = 31;
        final int JULIO = 31;
        final int AGOSTO = 31;
        final int OCTUBRE = 31;
        final int DICIEMBRE = 31;

        final int ABRIL = 30;
        final int JUNIO = 30;
        final int SEPTIEMBRE = 30;
        final int NOVIEMBRE = 30;

        final int FEBRERO = 28;

        int arrayMeses[] = {
            ENERO, FEBRERO, MARZO,
            ABRIL, MAYO, JUNIO,
            JULIO, AGOSTO, SEPTIEMBRE,
            OCTUBRE, NOVIEMBRE, DICIEMBRE
        };

        return arrayMeses;
    }

    private String formatearDiaMes(int diaMes) {
        StringBuilder sb = new StringBuilder();
        if (diaMes < 10) {
            sb.append("0");
        }
        String diaMesFormateado = sb.append(diaMes).toString();

        return diaMesFormateado;
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

}
