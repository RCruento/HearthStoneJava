package jeu.Capacites.CapacitesJaina;

import jeu.Capacites.InvocationDeServiteur;
import jeu.Capacites.Provocation;
import jeu.Carte.Serviteur;
import jeu.Plateau.Plateau;

/**
 * Classe ImageMiroir, permet d'invoquer des serviteurs
 * Hérite d'InvocationDeServiteur
 * @author Rayan KOUSSA
 * @version 0.1
 * @see InvocationDeServiteur
 */

public final class ImageMiroir extends InvocationDeServiteur {
    public ImageMiroir() {
        super("Image miroir", "Invoque 2 Serviteur de Jaina 0/2 avec provocation", new Serviteur( Plateau.getInstance().getJoueurCourant(),"Serviteur de Jaina", 0, 0,2, new Provocation()), 2);
    }
}
