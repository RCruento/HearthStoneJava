package jeu.Interface;

import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;


/**
 * Classe InterfaceFinirTour permet au joueur de pouvoir finir son tour en la choisissant
 * Hérite d'Interface
 * @author Rayan KOUSSA
 * @version 0.1
 * @see Interface
 */
public class InterfaceFinirTour extends Interface{
    public InterfaceFinirTour(Interface suivant) {
        super(suivant);
    }

    /**
     * Permet de verifier si le choix est correcte
     * @param choix pour finir le tour
     * @return true si correcte, false sinon
     */
    @Override
    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    /**
     * Permet de lancer le Choix de finir le tour
     * @param p
     */
    @Override
    public void executerRequete(IPlateau p) {
        try {
            p.finirTour(p.getJoueurCourant());
        } catch (HearthstoneException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Permet d'afficher le choix
     * @return "Finir le tour"
     */
    @Override
    public String getDescription() {
        return "Finir tour";
    }
}
