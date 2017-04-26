/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.backend.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
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
     * @param i
     * @return
     */
    public String generarCups(int i) {

        final String PRINCIPIOCUPS = "ES00277000000000";
        final String FINCUPS = "0F";

        StringBuilder sb = new StringBuilder(PRINCIPIOCUPS);

        String cadenaConvertida = annadirCeros(String.valueOf(i));

        sb.append(cadenaConvertida);
        sb.append(FINCUPS);

        String cupsGenerado = sb.toString();

        return cupsGenerado;
    }

    /**
     *
     * @return
     */
    public List<Integer> generarId() {

        List<Integer> mapaIds = new ArrayList<>();

        for (int i = 1; i < 1000001; i++) {
            mapaIds.add(i);
        }

        return mapaIds;
    }

    /**
     *
     * @return
     */
    public List<String> generarFechas() {

        final String ANNO = "2016";
        final int arraymeses[] = generarDiasMeses();

        int registrosCompletados = 0;

        List<String> mapaFechas = new ArrayList<>();

        do {

            int contadorMeses = 1;

            for (int mes : arraymeses) {

                for (int dia = 1; dia < mes + 1; dia++) {

                    StringBuilder fechaCompleta = new StringBuilder();

                    fechaCompleta.append(ANNO);
                    fechaCompleta.append(formatearDiaMes(contadorMeses));
                    fechaCompleta.append(formatearDiaMes(dia));

                    mapaFechas.add(fechaCompleta.toString());
                    if (registrosCompletados < 1000000) {
                        registrosCompletados++;
                    } else {
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
    public String generarMagnitud() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 24; i++) {
            sb.append("1678;");
        }
        sb.append("1678");

        String magnitudGenerada = sb.toString();

        return magnitudGenerada;

    }

    /**
     *
     * @return
     */
    public String generarFlags() {

        StringBuilder sb = new StringBuilder();
        final int LIMITE=2;
        Random rand = new Random();
        for (int i = 0; i < 24; i++) {
            sb.append(String.valueOf(rand.nextInt(LIMITE)));
            sb.append(";");
        }
        sb.append(String.valueOf(rand.nextInt(LIMITE)));

        String flagGenerada = sb.toString();
        
        return flagGenerada;
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

        final int ARREGLOMESES[] = {
            ENERO, FEBRERO, MARZO,
            ABRIL, MAYO, JUNIO,
            JULIO, AGOSTO, SEPTIEMBRE,
            OCTUBRE, NOVIEMBRE, DICIEMBRE
        };

        return ARREGLOMESES;
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
    
    public long conseguirHora(){
        return Calendar.getInstance().getTimeInMillis();
    }
    public long calcularTiempo(long antes,long despues){
        return despues -antes;
    }

}
