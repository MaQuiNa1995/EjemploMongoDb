/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota.json;

/**
 * @autor cmunoz
 * @version 1.0
 */
public class Campeon {

    private int id;
    private String mote;
    private String nombre;
    private String rol;
    private String lore;
    private String coste;

    public Campeon() {
        super();
    }

    public Campeon(int id, String mote, String nombre, String rol, String lore, String coste) {
        this.id = id;
        this.mote = mote;
        this.nombre = nombre;
        this.rol = rol;
        this.lore = lore;
        this.coste = coste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoste() {
        return coste;
    }

    public void setCoste(String coste) {
        this.coste = coste;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String Rol) {
        this.rol = Rol;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

}
