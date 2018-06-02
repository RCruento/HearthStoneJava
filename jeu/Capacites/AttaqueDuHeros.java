package jeu.Capacites;

import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;

public class AttaqueDuHeros extends Capacite {
    private int degat;

    public AttaqueDuHeros(String nom, String description, int degat) {
        super(nom, description);
        this.degat = degat;
    }


    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        Plateau plateau = Plateau.getInstance();
        if(cible == null){
            throw new HearthstoneException("Aucun Heros cible (null)");
        }
        if(cible instanceof Heros){
            for (ICarte carte: plateau.getAdversaire(plateau.getJoueurCourant()).getJeu()) {
                if(((Serviteur)carte).getCapacite().getNom().equals("Provocation")){
                    throw  new HearthstoneException("Personnage avec Provocation sur le plateau");
                }
            }
            plateau.getAdversaire(plateau.getJoueurCourant()).getHeros().blesserHero(this.degat);
            super.setServis(true);
            if(plateau.getAdversaire(plateau.getJoueurCourant()).getHeros().mort()){
                plateau.gagnerPartie(plateau.getAdversaire(plateau.getJoueurCourant()));
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
