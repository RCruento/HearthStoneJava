package jeu.Deck;

import jeu.Capacite.ICapacite;
import jeu.Carte.Carte;
import jeu.Carte.Serviteur;
import jeu.Carte.Sort;
import jeu.Heros.Heros;
import jeu.Carte.ICarte;
import jeu.Joueur.IJoueur;

import java.util.ArrayList;

public class Deck {
    private IJoueur owner;
    private Heros heros;
    private int NbCarte = 15;
    private ArrayList<ICarte> carte;
    //constructor



    public Deck(Heros heros)
    {
        this.setProrio(heros);
        this.carte=new ArrayList<ICarte>();
        if(heros.getNomHeros().equals("Jaina") ){
            Carte CSoJ1 = new Sort(owner,"Choc de flamme", 7 , "Attaque massive");
            Carte CSoJ2 = new Sort(owner,"Eclaire de givre", 2, "Attaque du givre");
            Carte CSoJ3 = new Sort(owner,"Intelligence des arcanes", 2, "Pioche 2 cartes");
            Carte CSoJ4 = new Sort(owner,"Image mirroir", 1, "Image mirroir");
            Carte CSoJ5 = new Sort(owner,"Explosion pyrotechnique", 10, "Explosion pyrotechnique");
            this.addCarte(CSoJ1);
            this.addCarte(CSoJ2);
            this.addCarte(CSoJ3);
            this.addCarte(CSoJ4);
            this.addCarte(CSoJ5);
        }
        if (heros.getNomHeros().equals("Rexxar")) {
                Carte CSeR = new Serviteur(owner,"Busard affamé", 5, 3, 2);
                Carte CSoR1 = new Sort(owner,"Marque du chasseur", 1, "Marque du chasseur");
                Carte CSoR2 = new Sort(owner,"Tir des arcanes", 1, "Tir des arcanes");
                Carte CSoR3 = new Sort(owner,"Lâchez les chiens", 3, "Invoque des chiens");
                Carte CSoR4 = new Sort(owner,"Ordre de tuer", 3, "Ordre de tuer");
                this.addCarte(CSeR);
                this.addCarte(CSoR1);
                this.addCarte(CSoR2);
                this.addCarte(CSoR3);
                this.addCarte(CSoR4);
        }
        Carte CSe1 = new Serviteur(owner,"Chasseur-marée murloc", 2, 2, 1, "Cri de guerre");
        Carte CSe2 = new Serviteur(owner,"Champion de Hurlevent", 7, 6,6, "Bonus de Hurlevent");
        Carte CSe3 = new Serviteur(owner,"Chef de raid",3,2,2, "Bonus de chef de raid");
        Carte CSe4 = new Serviteur(owner,"Garde de Baie-du-butin", 5, 5, 4, "Provocation");
        Carte CSe5 = new Serviteur(owner,"La missilière téméraire", 6, 5, 2, "Charge");
        Carte CSe6 = new Serviteur(owner,"L'ogre-magi", 4, 4, 4, "Provocation");
        Carte CSe7 = new Serviteur(owner,"Archimage", 6, 4, 7, "Provocation");
        Carte CSe8 = new Serviteur(owner,"Gnôme lépreux", 1, 1, 1, "Attaque du lépreux");
        Carte CSe9 = new Serviteur(owner,"L'ogre-magi", 4, 4, 4, "Provocation");
        Carte CSo1 = new Serviteur(owner,"Charge", 1, "Charge");
        // Carte CSo2 = new Carte("Attaque mentale", 2, "Attaque mentale");
        this.addCarte(CSe1);
        this.addCarte(CSe2);
        this.addCarte(CSe3);
        this.addCarte(CSe4);
        this.addCarte(CSe5);
        this.addCarte(CSe6);
        this.addCarte(CSe7);
        this.addCarte(CSe8);
        this.addCarte(CSe9);
        this.addCarte(CSo1);
        //this.addCarte(CSo2);
    }




    //methodes
    public void addCarte(Carte a)   {
        if (this.carte.size() < NbCarte) {
            this.carte.add(a);
        }else{
            System.out.println("Vous n'avez droit qu'a 15 cartes maximum");
            System.exit(1);
        }
    }
    public void delCarte(int i)  {
        if (i <= this.carte.size()){
            this.carte.remove(i);
        }else{

        }
    }
    //getters setters
    public void setProrio(Heros proprio) {
        if (proprio != null){
            this.heros = proprio;
        }else{
            throw new IllegalArgumentException("Erreur saisie veuillez corriger !");
        }
    }
    public Heros getProprio() {
        return this.heros;
    }
    public ICarte getCarte(int x) {
        if (x >= 0 && x <= this.carte.size()){
            return this.carte.get(x);
        }
        return null;
    }
    public String toString()
    {
        String res="carte {"+"\n";
        for(int i=0;i<this.carte.size();i++)
        {
            res+=i+" - "+this.getCarte(i).toString()+"\n";

        }
        return res+="}";
    }
}
