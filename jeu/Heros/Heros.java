package jeu.Heros;
import jeu.Capacite.Capacite;

public class Heros {
    private  String heros;
    private int pSante;
    private Capacite pouvoir;
    private  boolean putilise;


    public Heros(String nom){
        this.heros = nom;
        if(nom.equals("Jaina")){
            this.pouvoir = new Capacite("Boule de feu", "inflige 1 point de dégât au personnage ciblé.\n");
        }else if (nom.equals("Rexxar")) {
            this.pouvoir = new Capacite("Tir assuré", "Inflige 2 points de dégâts au héros adverse.\n");

        }
        this.putilise = false;
        this.pSante = 15;
    }

    // Getter & Setter
    public String getNomHeros(){
        return this.heros;
    }
    public int getpSante(){
        return this.pSante;
    }
    public Capacite getPouvoir(){
        return this.pouvoir;
    }
    public boolean getPUtilise(){
        return this.putilise;
    }

    public String toString(){
        return "Heros : "+this.heros+" Santé : "+this.pSante+" Mana : "+this.pMana+" Capacité : "+this.pouvoir.toString();
    }

}
