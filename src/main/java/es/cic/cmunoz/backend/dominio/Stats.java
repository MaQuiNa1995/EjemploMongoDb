package es.cic.cmunoz.backend.dominio;

/**
 * @version 1.0
 */
public class Stats {

    private String vida;
    private String regvida;
    private String mana;
    private String regmana;
    private String ataque;
    private String veloataque;
    private String armadura;
    private String resismagica;
    private String velomov;

    private int aCampeon;

    public Stats() {
        super();
    }

    public Stats(String vida, String regvida, String mana, String regmana, String ataque, String veloataque, String armadura, String resismagica, String velomov, int aCampeon) {
        this.vida = vida;
        this.regvida = regvida;
        this.mana = mana;
        this.regmana = regmana;
        this.ataque = ataque;
        this.veloataque = veloataque;
        this.armadura = armadura;
        this.resismagica = resismagica;
        this.velomov = velomov;
        this.aCampeon = aCampeon;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public String getRegvida() {
        return regvida;
    }

    public void setRegvida(String regvida) {
        this.regvida = regvida;
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public String getRegmana() {
        return regmana;
    }

    public void setRegmana(String regmana) {
        this.regmana = regmana;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getVeloataque() {
        return veloataque;
    }

    public void setVeloataque(String veloataque) {
        this.veloataque = veloataque;
    }

    public String getArmadura() {
        return armadura;
    }

    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }

    public String getResismagica() {
        return resismagica;
    }

    public void setResismagica(String resismagica) {
        this.resismagica = resismagica;
    }

    public String getVelomov() {
        return velomov;
    }

    public void setVelomov(String velomov) {
        this.velomov = velomov;
    }

    public int getACampeon() {
        return aCampeon;
    }

    public void setACampeon(int aCampeon) {
        this.aCampeon = aCampeon;
    }

}
