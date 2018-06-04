package jeu.Interface;

import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;

/**
 * Classe InterfaceQuitterLeJeu permet au joueur quitter le jeu en la choisissant
 * Hérite d'Interface
 * @author Rayan KOUSSA
 * @version 0.1
 * @see Interface
 */
public class InterfaceQuitterLeJeu extends Interface{

    public InterfaceQuitterLeJeu(Interface suivant) {
        super(suivant);
    }

    /**
     * Permet de verifier si le choix est correcte
     * @param choix pour finir le tour
     * @return true si correcte, false sinon
     */
    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    /**
     * Permet d'executer le choix finir tour
     * @param p plateau
     * @throws HearthstoneException
     */
    public void executerRequete(IPlateau p)throws HearthstoneException{
        System.out.println(p.getJoueurCourant().getPseudo()+ " a décidé de quitter la partie");
        System.out.println(p.getAdversaire(p.getJoueurCourant()).getPseudo()+ " a gagné la partie");
        System.exit(0);

    }

    /**
     * Permet d'afficher le choix
     * @return "Quitter la partie"
     */
    @Override
    public String getDescription() {
        return "Quitter la partie";
    }
}
