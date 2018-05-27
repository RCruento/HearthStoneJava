package jeu.Interface;

import jeu.Carte.ICarte;
import jeu.Exception.HearthstoneException;
import jeu.Plateau.IPlateau;

import java.util.Scanner;

public class InterfaceUtiliserCarteEnJeu extends Interface {
    public InterfaceUtiliserCarteEnJeu(Interface suivant) {
        super(suivant);
    }

    @Override
    public boolean saitInteragir(String choix) {
        return getDescription().equals(choix);
    }

    @Override
    public void executerRequete(IPlateau p) throws HearthstoneException {
        boolean trouve = false;
        boolean trouveCarte = false;
        boolean trouveCible = false;
        String nomCible;

        Scanner sc = new Scanner(System.in);
        System.out.println("Quel Serviteur veux-tu utiliser ?");
        String nomCarte = sc.nextLine();

        while(!trouveCarte && !trouveCible){
            for(ICarte carteS : p.getJoueurCourant().getJeu()){
                if(carteS.getNomCarte().contains(nomCarte)){
                    trouveCarte = true;
                    System.out.println("Quel est la cible ?");
                    nomCible = sc.nextLine();
                    if(p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros().contains(nomCible)){
                        trouveCible = true;
                        p.getJoueurCourant().utiliserCarte(carteS, p.getAdversaire(p.getJoueurCourant()).getHeros().getNomHeros());
                        break;
                    }else{
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
            if(!trouveCarte && !trouveCible){
                System.out.println("Quel Serviteur veux-tu utiliser ?");
                nomCarte = sc.nextLine();
                System.out.println("Quel est la cible ?");
                nomCible = sc.nextLine();
            }

        }
    }

    @Override
    public String getDescription() {
        return "Utiliser carte en jeux";
    }
}