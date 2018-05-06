package jeu;
import java.util.ArrayList;

public class Heros {
    private  String heros;
    private int pSante;
    private int pMana;
    private Capacite pouvoir;
    private  boolean putilise;
    private ArrayList<Integer> stockMana;


    public Heros(String nom){
        this.heros = nom;
        if(nom.equals("Jaina")){
            this.pouvoir = new Capacite("Boule de feu", "inflige 1 point de dégât au personnage ciblé.\n");
        }else if (nom.equals("Rexxar")) {
            this.pouvoir = new Capacite("Tir assuré", "Inflige 2 points de dégâts au héros adverse.\n");

        }
        this.putilise = false;
        this.pSante = 15;
        this.pMana = 0;
    }

    // Getter & Setter
    public String getNomHeros(){
        return this.heros;
    }
    public int getpSante(){
        return this.pSante;
    }
    public int getpMana(){
        return this.pMana;
    }
    public Capacite getPouvoir(){
        return this.pouvoir;
    }
    public boolean getPUtilise(){
        return this.putilise;
    }

    public void addMana() throws HearthstoneException {
        if (this.stockMana.size() <15) {
            this.stockMana.add(1);
        }else{
            throw new HearthstoneException("Vous n'avez droit qu'a 15 cartes maximum");
        }
    }
    public void delMana(int i) throws HearthstoneException {
        if (i <= this.stockMana.size()){
            this.stockMana.remove(i);
        }else{
            throw new HearthstoneException("Erreur veuillez corriger !");
        }
    }

    public String toString(){
        return getNomHeros()+""+getpMana()+""+getPouvoir()+""+getpSante();
    }

}
