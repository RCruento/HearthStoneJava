package jeu.Interface;

import jeu.Carte.ICarte;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;
import java.util.Scanner;

/**
 * Classe InterfaceUtiliserCarteEnJeu permet au joueur d'utiliser une carte en la choisissant
 * Hérite d'Interface
 * @author Rayan KOUSSA
 * @version 0.1
 * @see Interface
 */
public class InterfaceUtiliserCarteEnJeu extends Interface {
    public InterfaceUtiliserCarteEnJeu(Interface suivant) {
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
     * permet d'executer le choix Utiliser une carte
     * @param p plateau
     * @throws HearthstoneException
     */
    @Override
    public void executerRequete(IPlateau p) throws HearthstoneException {
        boolean trouveCarte = false;
        boolean trouveCible = false;

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Serviteur veux-tu utiliser ?");
        String nomCarte = sc.nextLine();

        while (!trouveCarte){
            for (ICarte carteSelectionne : p.getJoueurCourant().getJeu()){
                if(carteSelectionne.getNomCarte().contains(nomCarte)){
                    System.out.println("Selectionnée une cible");
                    String nomCible = sc.nextLine();
                    while (!trouveCible){
                        if (p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros().contains(nomCible)){
                            trouveCible = true;
                            trouveCarte = true;
                            p.getJoueurCourant().utiliserCarte(carteSelectionne,p.getAdversaire(p.getJoueurCourant()).getHeros());
                            //p.getAdversaire(p.getJoueurCourant()).getHeros().blesserHero(((Serviteur)carteSelectionne).getAttaque());

                            break;
                        }
                        for(ICarte carteSCible : p.getAdversaire(p.getJoueurCourant()).getJeu()){
                            if (carteSCible.getNomCarte().contains(nomCible)){
                                trouveCible = true;
                                trouveCarte = true;
                                p.getJoueurCourant().utiliserCarte(carteSelectionne, carteSCible);

                                break;
                            }
                        }
                        if(!trouveCible){
                            System.out.println("L'a choisis n'existe pas retour au menu");
                            trouveCible = true;
                            trouveCarte = true;
                        }
                    }
                }
            }
            if(!trouveCarte){
                System.out.println("Le serviteur choisis n'est pas sur le plateau retour au menu");
                trouveCible = true;
                trouveCarte = true;
            }
        }




        /*while(!trouveCarte && !trouveCible){
            for(ICarte carteS : p.getJoueurCourant().getJeu()){
                if(carteS.getNomCarte().contains(nomCarte)){
                    trouveCarte = true;
                    System.out.println("Quelle est la cible ?");
                    nomCible = sc.nextLine();
                    if(p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros().contains(nomCible)){
                        trouveCible = true;
                        p.getJoueurCourant().utiliserCarte(carteS, p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros());
                        break;
                    }
                    if(){
                        for(ICarte carteScible: p.getAdversaire(p.getJoueurCourant()).getJeu()){
                            if (carteScible.getNomCarte().contains(nomCible)){
                                trouveCible = true;
                                p.getJoueurCourant().utiliserCarte(carteS, carteScible);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
            if(!trouveCarte){
                System.out.println("Le serviteur n'est pas sur le plateau");
                trouveCarte = true;
                trouveCible = true;
            }else{
                if(!trouveCible){
                    System.out.println("Le serviteur ciblé n'est pas sur le plateau");
                    trouveCarte = trouveCible = true;
                }
            }
        }*/
    }

    /**
     * Permet d'afficher le choix
     * @return "Utiliser carte en jeux"
     */
    @Override
    public String getDescription() {
        return "Utiliser carte en jeux";
    }
}
