/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.cic.cmunoz.backend.dominio;

/**
 * @autor cmunoz
 * @version 1.0
 */
public class Curvas {

    private int id;
    private String cups;
    private  int magnitud;
    private  String fecha;
    private  String valores;
    private  String flag;

    public Curvas() {
        
    }

    public Curvas(int id, String cups, int magnitud, String fecha, String valores, String flag) {
        this.id = id;
        this.cups = cups;
        this.magnitud = magnitud;
        this.fecha = fecha;
        this.valores = valores;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCups() {
        return cups;
    }

    public void setCups(String cups) {
        this.cups = cups;
    }

    public int getMagnitud() {
        return magnitud;
    }

    public void setMagnitud(int magnitud) {
        this.magnitud = magnitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValores() {
        return valores;
    }

    public void setValores(String valores) {
        this.valores = valores;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
    
    
    
}
