package jeu.Heros;

import jeu.Capacites.ICapacite;

import java.util.Objects;

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

    public void blesserHero(int degat){
        this.setSante(this.sante - degat);
    }

    public boolean mort(){
        if(this.sante <= 0){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Heros{" + heros +
                ", Santé : " + sante +
                ", Pouvoir : " + pouvoir +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heros)) return false;
        Heros heros1 = (Heros) o;
        return  Objects.equals(heros, heros1.heros) &&
                Objects.equals(pouvoir, heros1.pouvoir);
    }

}
