package jeu;
import com.sun.org.omg.CORBA.ExceptionDescriptionHelper;

import java.util.ArrayList;

public class Deck {
    private Joueur proprio;
    private int NbCarte = 15;
    private ArrayList<ICarte> carte;
    //constructor



    public Deck(Joueur proprio) throws HearthstoneException
    {
        this.setProrio(proprio);
        this.carte=new ArrayList<ICarte>();
        if(proprio.equals("Mage") ){
            Carte CSoJ1 = new Carte("Choc de flamme", 7, "Attaque massive");
            Carte CSoJ2 = new Carte("Eclaire de givre", 2, "Attaque du givre");
            Carte CSoJ3 = new Carte("Intelligence des arcanes", 2, "Pioche 2 cartes");
            Carte CSoJ4 = new Carte("Image mirroir", 1, "Image mirroir");
            Carte CSoJ5 = new Carte("Explosion pyrotechnique", 10, "Explosion pyrotechnique");
            this.addCarte(CSoJ1);
            this.addCarte(CSoJ2);
            this.addCarte(CSoJ3);
            this.addCarte(CSoJ4);
            this.addCarte(CSoJ5);
        }else {
            if (proprio.equals("Chasseur")) {
                Carte CSeR = new Carte("Busard affamé", 5, 3, 2, "Pioche 1 carte");
                Carte CSoR1 = new Carte("Marque du chasseur", 1, "Marque du chasseur");
                Carte CSoR2 = new Carte("Tir des arcanes", 1, "Tir des arcanes");
                Carte CSoR3 = new Carte("Lâchez les chiens", 3, "Invoque des chiens");
                Carte CSoR4 = new Carte("Ordre de tuer", 3, "Ordre de tuer");
                this.addCarte(CSeR);
                this.addCarte(CSoR1);
                this.addCarte(CSoR2);
                this.addCarte(CSoR3);
                this.addCarte(CSoR4);
            } else {
                System.out.println("ERROR !!");
            }
        }
        Carte CSe1 = new Carte("Chasseur-marée murloc", 2, 2, 1, "Cri de guerre");
        Carte CSe2 = new Carte("Champion de Hurlevent", 7, 6,6, "Bonus de Hurlevent");
        Carte CSe3 = new Carte("Chef de raid",3,2,2, "Bonus de chef de raid");
        Carte CSe4 = new Carte("Garde de Baie-du-butin", 5, 5, 4, "Provocation");
        Carte CSe5 = new Carte("La missilière téméraire", 6, 5, 2, "Charge");
        Carte CSe6 = new Carte("L'ogre-magi", 4, 4, 4, "Provocation");
        Carte CSe7 = new Carte("Archimage", 6, 4, 7, "Provocation");
        Carte CSe8 = new Carte("Gnôme lépreux", 1, 1, 1, "Attaque du lépreux");
        Carte CSe9 = new Carte("L'ogre-magi", 4, 4, 4, "Provocation");
        Carte CSo1 = new Carte("Charge", 1, "Charge");
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
    public void addCarte(Carte a) throws HearthstoneException {
        if (this.carte.size() < NbCarte) {
            this.carte.add(a);
        }else{
            System.out.println("Vous n'avez droit qu'a 15 cartes maximum");
            System.exit(1);
        }
    }
    public void delCarte(int i) throws HearthstoneException {
        if (i <= this.carte.size()){
            this.carte.remove(i);
        }else{
            throw new HearthstoneException("Erreur veuillez corriger !");
        }
    }
    //getters setters
    public void setProrio(Joueur proprio) {
        if (proprio != null){
            this.proprio = proprio;
        }else{
            throw new IllegalArgumentException("Erreur saisie veuillez corriger !");
        }
    }
    public Joueur getProprio() {
        return this.proprio;
    }
    public ICarte getCarte(int x) {
        if (x >= 0 && x <= this.carte.size()){
            return this.carte.get(x);
        }
        return null;
    }
    public String toString()
    {   int nb;
        String res="Deck[nom=  "+getProprio()+"carte={"+"\n";
        for(int i=0;i<this.carte.size();i++)
        {
            res+=i+this.getCarte(i).toString()+"\n";

        }
        return res+="}]";
    }
}
