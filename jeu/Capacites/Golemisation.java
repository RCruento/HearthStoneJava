package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.Plateau;

/**
 * Classe Golemisation, classe qui hérite d'Invocation de Serviteur
 * @author Rayan KOUSSA
 * @version 0.1
 * @see InvocationDeServiteur
 */
public class Golemisation extends InvocationDeServiteur {
    public Golemisation() throws HearthstoneException {
        super("Aucune", null, new Serviteur(Plateau.getInstance().getJoueurCourant(), "Golem endomagé",2,1), 1);
    }
}
