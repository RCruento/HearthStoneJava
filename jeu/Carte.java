package jeu;

public class Carte implements ICarte{
    private String nom;
    private int mana;
    private boolean serviteur;
    private int PS;
    private int PA;
    private String capaciteSer;
    private String capaciteSor;
    private boolean reveille = false ;
    private boolean provocation = false;
    private IJoueur propietaire;

    //Constructor
    //Serviteur
    public Carte( String nom, int mana, int PA, int PS, String capaciteSer ){
        this.setNom(nom);
        this.setMana(mana);
        this.serviteur = true;
        this.setPattaque(PA);
        this.setPsante(PS);
        this.setCapaciteSer(capaciteSer);
    }

    //Magique
    public Carte( String nom, int mana, String capacite ){
        this.setNom(nom);
        this.setMana(mana);
        this.serviteur = false;
        this.setCapacite(capacite);
    }


    //Getter & Setter
    public String getNom(){
        return this.nom;
    }

    @Override
    public IJoueur getProprietaire() {
        return null;
    }

    public int getMana(){
        return this.mana;
    }
    public boolean getServiteur(){
        return this.serviteur;
    }
    public int getPsante(){
        return this.PS;
    }
    public int getPattaque(){
        return this.PA;
    }
    public  String getCapaciteSor(){
        return this.capaciteSor;
    }
    public String getCapaciteSer(){
        return this.capaciteSer;
    }
    public boolean getReveille(){
        return this.reveille;
    }
    public boolean getPovocation (){return this.provocation;}

    public void setNom(String nom){
        if (this.nom == null && nom != null){
            this.nom = nom;
        }else{
            System.out.println("Erreur saisie veuillez corriger !");
            System.exit(1);
        }
    }
    public void setMana(int mana){
        this.mana = mana;
    }
    public void setPsante(int Psante){
        this.PS = Psante;
    }
    public void setPattaque(int Pattaque){
        this.PA= Pattaque;
    }
    public void setCapacite(String capacite){
        this.capaciteSor = capacite;
    }
    public void setCapaciteSer(String capaciteSer) {
        this.capaciteSer = capaciteSer;
    }
    public void setServiteur(boolean serv){this.serviteur=serv;}
    public void setReveille(boolean reveille){this.reveille=reveille;}
    public void setProvocation(boolean provoc){this.provocation = provoc;}

    //Methods
    public boolean disparait(){
        if(this.PS == 0){
            return true;
        }else{
            return false;
        }
    }

    public void executerActiion(Carte cible) {

    }

    public void    executerAction(Carte cible){}
    public void    executerEffetDebutMiseEnJeu(Carte cible){}
    public void    executerEffetDebutTour(Carte cible){}
    public void    executerEffetDisparition(Carte cible){}
    public void    executerEffetFinTour(Carte cible){}

    @Override
    public int getCout() {
        return 0;
    }
}
