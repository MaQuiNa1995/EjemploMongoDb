/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.mongodbmascota.json;

/**
 * @Autor cmunoz
 * @Fecha 07-dic-2016
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

    private int a_campeon;

    public Stats() {
        super();
    }

    public Stats(String vida, String regvida, String mana, String regmana, String ataque, String veloataque, String armadura, String resismagica, String velomov, int a_campeon) {
        this.vida = vida;
        this.regvida = regvida;
        this.mana = mana;
        this.regmana = regmana;
        this.ataque = ataque;
        this.veloataque = veloataque;
        this.armadura = armadura;
        this.resismagica = resismagica;
        this.velomov = velomov;
        this.a_campeon = a_campeon;
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

    public int getA_campeon() {
        return a_campeon;
    }

    public void setA_campeon(int a_campeon) {
        this.a_campeon = a_campeon;
    }

}
