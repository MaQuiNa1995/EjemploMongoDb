/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.cic.cmunoz.backend.dominio;

import org.springframework.data.annotation.Id;

/**
 * @autor cmunoz
 * @version 1.0
 */
public class Curvas {

    @Id
    private String id;
    private int idCurva;
    private String cups;
    private  int magnitud;
    private  String fecha;
    private  String valores;
    private  String flag;

    public Curvas() {
        
    }

    public Curvas(int idCurva, String cups, int magnitud, String fecha, String valores, String flag) {
        this.idCurva = idCurva;
        this.cups = cups;
        this.magnitud = magnitud;
        this.fecha = fecha;
        this.valores = valores;
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdCurva() {
        return idCurva;
    }

    public void setIdCurva(int idCurva) {
        this.idCurva = idCurva;
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
