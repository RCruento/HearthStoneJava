package jeu.Capacites;

import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;

public abstract class AttaqueCiblee extends Capacite{
    int degat;


    public AttaqueCiblee(String nom, String description,  int degat) {
        super(nom, description);
        this.degat= degat;
    }

    public void executerAction(Object cible) throws HearthstoneException {
        if (cible == null){
            throw new IllegalArgumentException("Cible nulle");
        }
        if(cible instanceof Sort){
            throw new HearthstoneException("Cibler un sort est impossible");
        }
        if (cible instanceof Plateau){
            throw new HearthstoneException("Cibler le platau??????");
        }
        if(cible instanceof Heros){
            Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getHeros().setHealt(((Heros) cible).getHealt()-this.degat);
            super.setServis(true);
            if(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getHeros().mort()){
                Plateau.getInstance().gagnerPartie(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()));
            }
        }
        if(cible instanceof Serviteur){
            if(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().contains(cible)){
                ((Serviteur) Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getCarteEnJeu(((Serviteur) cible).getNomCarte())).
                        setSante(((Serviteur) Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getCarteEnJeu(((Serviteur) cible).getNomCarte())).getSante()-1);
                super.setServis(true);
                if(((Serviteur) Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getCarteEnJeu((((Serviteur) cible).getNomCarte()))).disparait()){
                    Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(cible);
                }
            }
            if((Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getCarteEnJeu(((Serviteur) cible).getNomCarte())).disparait()){
                Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(cible);
            }
        }

    }

    public void executerEffetDebutTour() throws HearthstoneException {

    }

    public void executeEffetDisparition(Object cible) throws HearthstoneException {

    }

    public void executerEffetFinTor() throws HearthstoneException {

    }

    public void executeEffetMiseEnjeu(Object cible) throws HearthstoneException {

    }

}
