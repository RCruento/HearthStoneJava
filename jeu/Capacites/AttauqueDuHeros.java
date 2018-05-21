package jeu.Capacites;

import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;

public  abstract class AttauqueDuHeros extends Capacite {
    private int degat;

    public AttauqueDuHeros(String nom, String description, int degat) {
        super(nom, description);
        this.degat = degat;
    }


    @Override
    public void executerAction(Object cible) throws HearthstoneException {
        if(cible == null){
            throw new HearthstoneException("Aucun Heros cible (null)");
        }
        if(cible instanceof Heros){
            Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getHeros().blesserHero(this.degat);
            if(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getHeros().mort()){
                Plateau.getInstance().gagnerPartie(Plateau.getInstance().getJoueurCourant());
            }
        }else{
            throw new HearthstoneException("Tu dois obligatoirement cibler un Hero");
        }

    }

    @Override
    public void executerEffetDebutTour() throws HearthstoneException {

    }

    @Override
    public void executeEffetDisparition(Object cible) throws HearthstoneException {

    }

    @Override
    public void executerEffetFinTor() throws HearthstoneException {

    }

    @Override
    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {

    }

}
