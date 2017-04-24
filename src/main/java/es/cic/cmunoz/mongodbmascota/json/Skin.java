/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota.json;

/**
 * @autor cmunoz
 * @Fecha 18-nov-2016
 */
public class Skin {

    private String nombre;
    private String imagen;
    private int costeRP;
    private int a_campeon;

    public Skin() {
        super();
    }

    public Skin(String nombre, String imagen, int costeRP, int a_campeon) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.costeRP = costeRP;
        this.a_campeon = a_campeon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCosteRP() {
        return costeRP;
    }

    public void setCosteRP(int costeRP) {
        this.costeRP = costeRP;
    }

    public int getA_campeon() {
        return a_campeon;
    }

    public void setA_campeon(int a_campeon) {
        this.a_campeon = a_campeon;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Imagen: " + imagen + ", CosteRP: " + costeRP + ", a_campeon: " + a_campeon;
    }

}
