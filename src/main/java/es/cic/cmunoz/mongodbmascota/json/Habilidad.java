package es.cic.cmunoz.mongodbmascota.json;

/**
 * @version 1.0
 */
public class Habilidad {
    
    private String nombre;
    private String descripcioncorta;
    private String descripcionlarga;
    private String tecla;
    private String coste;
    private String enfriamiento;
    private int aCampeon;

    public Habilidad() {
        super();
    }

    public Habilidad(String nombre, String descripcioncorta, String descripcionlarga, String tecla, String coste, String enfriamiento, int aCampeon) {
        this.nombre = nombre;
        this.descripcioncorta = descripcioncorta;
        this.descripcionlarga = descripcionlarga;
        this.tecla = tecla;
        this.coste = coste;
        this.enfriamiento = enfriamiento;
        this.aCampeon = aCampeon;
    }

    public String getCoste() {
        return coste;
    }

    public void setCoste(String coste) {
        this.coste = coste;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    public String getDescripcionlarga() {
        return descripcionlarga;
    }

    public void setDescripcionlarga(String descripcionlarga) {
        this.descripcionlarga = descripcionlarga;
    }

    public String getTecla() {
        return tecla;
    }

    public void setTecla(String tecla) {
        this.tecla = tecla;
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