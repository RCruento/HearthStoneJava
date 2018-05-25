package jeu.Interface;

import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;

public abstract class Interface {
    private Interface suivant = null;


    public Interface(Interface suivant) {
        this.suivant = suivant;
    }

    public Interface getSuivant() {
        return suivant;
    }

    public abstract boolean saitInteragir(String choix);

    public abstract void executerRequete(IPlateau p) throws HearthstoneException;

    public abstract String getDescription();

    public void interagir(String choix, IPlateau p) throws HearthstoneException {
        if (saitInteragir(choix))
            executerRequete(p);
        else if (suivant != null) {
            try {
                suivant.interagir(choix, p);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else
            throw new HearthstoneException("Pas d'interaction pour " + choix);
    }
}

