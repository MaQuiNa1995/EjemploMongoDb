package es.cic.cmunoz.mongodbmascota.json;

/**
 * @autor cmunoz
 * @version 1.0
 */
public class Pasiva {

    private String nombre;
    private String descripcion;
    private String enfriamiento;
    private int aCampeon;
    
    public Pasiva() {
        super();
    }
    
    public Pasiva(String nombre, String descripcion, String enfriamiento, int aCampeon) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.enfriamiento = enfriamiento;
        this.aCampeon = aCampeon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEnfriamiento() {
        return enfriamiento;
    }

    public void setEnfriamiento(String enfriamiento) {
        this.enfriamiento = enfriamiento;
    }

    public int getACampeon() {
        return aCampeon;
    }

    public void setACampeon(int aCampeon) {
        this.aCampeon = aCampeon;
    }
}
