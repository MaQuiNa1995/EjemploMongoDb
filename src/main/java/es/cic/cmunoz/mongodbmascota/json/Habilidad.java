package es.cic.cmunoz.mongodbmascota.json;

public class Habilidad {
    
    private String nombre;
    private String descripcioncorta;
    private String descripcionlarga;
    private String tecla;
    private String coste;
    private String enfriamiento;
    private int a_campeon;

    public Habilidad() {
        super();
    }

    public Habilidad(String nombre, String descripcioncorta, String descripcionlarga, String tecla, String coste, String enfriamiento, int a_campeon) {
        this.nombre = nombre;
        this.descripcioncorta = descripcioncorta;
        this.descripcionlarga = descripcionlarga;
        this.tecla = tecla;
        this.coste = coste;
        this.enfriamiento = enfriamiento;
        this.a_campeon = a_campeon;
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

    public int getA_campeon() {
        return a_campeon;
    }

    public void setA_campeon(int a_campeon) {
        this.a_campeon = a_campeon;
    }
}