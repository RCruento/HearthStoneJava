package jeu;
import java.util.ArrayList;

public class Heros extends Joueur {
    private  String nom;
    private int pSante;
    private int pMana;
    private Capacite pouvoir;
    private  boolean putilise;
    private ArrayList<Integer> stockMana;


    public Heros(String nom, Capacite pouvoir, String nomJ, boolean joue) {
        super(nomJ, joue);
        this.nom = nom;
        this.pouvoir = pouvoir;
        this.putilise = false;
        this.pSante = 15;
        this.pMana = 0;
    }

    // Getter & Setter
    public String getNom(){
        return this.nom;
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
        if (this.stockMana.size() < MAX_MANA) {
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


}
