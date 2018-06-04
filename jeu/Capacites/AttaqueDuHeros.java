package jeu.Capacites;

import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;

/**
 * Classe AttaqueDuHeros permet d'attaquer le heros directement. Hérite de Capacité
 * @author  Rayan KOUSSA
 * @version 0.1
 * @see Capacite
 */
public class AttaqueDuHeros extends Capacite {
    private int degat;

    public AttaqueDuHeros(String nom, String description, int degat) {
        super(nom, description);
        this.degat = degat;
    }


    /**
     * Permet d'attaquer le Heros directement sauf si un serviteur adverse y a provocation sur le plateau
     * @param cible le Heros
     * @throws HearthstoneException
     */
    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        Plateau plateau = Plateau.getInstance();
        if(cible == null){
            throw new HearthstoneException("Aucun Heros cible (null)");
        }
        if(cible instanceof Heros){
            if(!getServis()) {
                for (ICarte carte : plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()) {
                    if (((Serviteur) carte).getCapacite().getNom().equals("Provocation")) {
                        throw new HearthstoneException("Personnage avec Provocation sur le plateau");
                    }
                }
                plateau.getAdversaire(plateau.getJoueurCourant()).getHeros().blesserHero(this.degat);
                super.setServis(true);
                if (plateau.getAdversaire(plateau.getJoueurCourant()).getHeros().mort()) {
                    plateau.gagnerPartie(plateau.getAdversaire(plateau.getJoueurCourant()));
                }
            }
        }else{
            throw new HearthstoneException("Tu dois obligatoirement cibler un Hero");
        }

    }

    @Override
    public void executerEffetDebutTour() {

    }

    @Override
    public void executeEffetDisparition(Object cible){

    }

    @Override
    public void executerEffetFinTour() {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) {

    }

}
