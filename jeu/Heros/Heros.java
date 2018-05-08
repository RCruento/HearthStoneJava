package jeu.Heros;
import jeu.Capacite.BouleDeFeu;
import jeu.Capacite.ICapacite;
import jeu.Joueur.Joueur;

import java.util.Objects;

public class Heros  {
    private  String personnage;
    private int healt = 15;
    private ICapacite pouvoir;

    public Heros(String heros, ICapacite pouvoir) {

        this.personnage = heros;
        this.pouvoir = pouvoir;
    }

    // Getter & Setter
    public String getPersonage() {
        return this.personnage;
    }

    public void setHeros(String heros) {
        this.personnage = heros;
    }

    public int getHealt() {
        return healt;
    }

    public void setHealt(int healt) {
        this.healt = healt;
    }

    public ICapacite getPouvoir() {
        return pouvoir;
    }

    public void setPouvoir(BouleDeFeu pouvoir) {
        this.pouvoir = pouvoir;
    }

    //Methods

    @Override
    public String toString() {
        return "Heros{" +
                "heros='" + personnage + '\'' +
                ", healt=" + healt +
                ", pouvoir=" + pouvoir +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heros)) return false;
        Heros heros1 = (Heros) o;
        return healt == heros1.healt &&
                Objects.equals(personnage, heros1.personnage) &&
                Objects.equals(pouvoir, heros1.pouvoir);
    }

}
