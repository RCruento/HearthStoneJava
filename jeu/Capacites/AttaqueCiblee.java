package jeu.Capacites;

import jeu.Carte.ICarte;
import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Exception.HearthstoneException;
import jeu.Heros.Heros;
import jeu.Plateau.Plateau;

public class AttaqueCiblee extends Capacite{
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
            for (ICarte carte: Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()) {
                if(((Serviteur)carte).getProvocation()){
                    throw  new HearthstoneException("Personnage avec Provocation sur le plateau");
                }
            }
            Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getHeros().blesserHero(this.degat);
            super.setServis(true);
            if(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getHeros().mort()){
                Plateau.getInstance().gagnerPartie(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()));
            }
        }
        if(cible instanceof Serviteur){
            if(Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().contains(cible)){
                if(((Serviteur) cible).getProvocation()){
                    ((Serviteur) cible).blesserServiteur(this.degat);
                }
                for (ICarte carte: Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu()) {
                    if(((Serviteur)carte).getProvocation()){
                        throw  new HearthstoneException("Personnage avec Provocation sur le plateau");
                    }
                }
                super.setServis(true);
                if(((Serviteur) Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getCarteEnJeu((((Serviteur) cible).getNomCarte()))).disparait()){
                    Plateau.getInstance().getAdversaire(Plateau.getInstance().getJoueurCourant()).getJeu().remove(cible);
                }
            }
        }

    }

    public void executerEffetDebutTour() {

    }

    public void executeEffetDisparition(Object cible)  {

    }

    public void executerEffetFinTor()  {

    }

    public void executeEffetMiseEnjeu(Object cible)  {

    }

}
