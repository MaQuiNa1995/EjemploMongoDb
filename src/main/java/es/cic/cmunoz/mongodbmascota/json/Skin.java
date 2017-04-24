package es.cic.cmunoz.mongodbmascota.json;

/**
 * @autor cmunoz
 * @version 1.0
 */
public class Skin {

    private String nombre;
    private String imagen;
    private int costeRP;
    private int aCampeon;

    public Skin() {
        super();
    }

    public Skin(String nombre, String imagen, int costeRP, int aCampeon) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.costeRP = costeRP;
        this.aCampeon = aCampeon;
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

    public int getACampeon() {
        return aCampeon;
    }

    public void setACampeon(int aCampeon) {
        this.aCampeon = aCampeon;
    }

}
