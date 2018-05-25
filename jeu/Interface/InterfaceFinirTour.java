package jeu.Interface;

import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;

public class InterfaceFinirTour extends Interface{
    public InterfaceFinirTour(Interface suivant) {
        super(suivant);
    }

    @Override
    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    @Override
    public void executerRequete(IPlateau p) {
        try {
            p.finirTour(p.getJoueurCourant());
        } catch (HearthstoneException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getDescription() {
        return "Finir tour";
    }
}
