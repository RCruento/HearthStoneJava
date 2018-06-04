package jeu.Heros;

import jeu.Capacites.ICapacite;

import java.util.Objects;

/**
 * Classe Heros representant le Heros avec lequel le joueur joue
 * @author  Rayan KOUSSA
 * @version 0.1
 */
public class Heros  {

    private  String heros;
    private int sante = 15;
    private ICapacite pouvoir;

    public Heros(String heros, ICapacite pouvoir) {

        this.heros = heros;
        this.setPouvoir(pouvoir);
    }

    // Getter & Setter
    public String getNomHeros() {
        return this.heros;
    }

    public void setHeros(String heros) {
        this.heros = heros;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int healt) {
        this.sante = healt;
    }

    public ICapacite getPouvoir() {
        return this.pouvoir;
    }

    public void setPouvoir(ICapacite pouvoir) {
        this.pouvoir = pouvoir;
    }

    //Methods

    /**
     * Le Heros subit les degats d'une attaque
     * @param degat
     */
    public void blesserHero(int degat){
        this.sante = this.sante - degat;
    }

    /**
     * Verifie si le Heros a 0 point de vie et donc mort
     * @return true si le heros est mort, false sinon
     */
    public boolean mort(){
        if(this.sante <= 0){
            return true;
        }
        return false;
    }

    /**
     * Retourne les parametre de la classe Heros en chaine de caractères
     * @return String(chaine de caractère)
     */
    @Override
    public String toString() {
        return "Heros{" + heros +
                ", Santé : " + sante +
                ", Pouvoir : " + pouvoir +
                '}';
    }

    /**
     * Vérifie si un heros = un autre heros
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heros)) return false;
        Heros heros1 = (Heros) o;
        return  Objects.equals(heros, heros1.heros) &&
                Objects.equals(pouvoir, heros1.pouvoir);
    }

}
