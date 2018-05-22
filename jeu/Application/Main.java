Heros Jaina = new Heros("Jaina", new BouleDeFeu());
        Joueur Ray = new Joueur("Rayan", Jaina);
        Heros Rexxar = new Heros("Rexxar", new BouleDeFeu());
        IJoueur Demos = new Joueur("Demos", Rexxar);
        Plateau plateau = new Plateau(Ray, Demos);

        //Carte propre a Jaina
        ICarte CSoJ1 = new Sort(Ray, "Choc de flamme", 7, new ChocDeFlamme());
        ICarte CSoJ2 = new Sort(Ray, "Eclaire de givre", 2, new EclaireDeGivre());
        ICarte CSoJ3 = new Sort(Ray, "Intelligence des Arcanes", 2, new IntelligenceDesArcanes());
        ICarte CSoJ4 = new Sort(Ray,"Image mirroir", 1, new Miroir());
        ICarte CSoJ5 = new Sort(Ray, "Explosion pyrotechnique", 10, new ExplosionPyrotechnique());
        plateau.getPlayer1().getDeck().add(CSoJ1);
        plateau.getPlayer1().getDeck().add(CSoJ2);
        plateau.getPlayer1().getDeck().add(CSoJ3);
        plateau.getPlayer1().getDeck().add(CSoJ4);
        plateau.getPlayer1().getDeck().add(CSoJ5);



        //Carte Propre a Rexxar
        ICarte CSeR = new Serviteur(Demos,"Busard affamé", 5, 3, 2, new BrusardAffame());
        ICarte CSoR1 = new Sort(Demos, "Tir des Arcane", 1, new TirDesArcanes());
        ICarte CSoR2 = new Sort(Demos, "Marque du chasseur", 1, new MarqueDuChasseur());
        ICarte CSoR3 = new Sort(Demos,"Lâchez les chiens", 3, new Chiens());
        ICarte CSoR5 = new Sort(Demos, "Ordre de tuer", 3, new OrdreDeTuer());
        plateau.getPlayer2().getDeck().add(CSeR);
        plateau.getPlayer2().getDeck().add(CSoR1);
        plateau.getPlayer2().getDeck().add(CSoR2);
        plateau.getPlayer2().getDeck().add(CSoR3);
        plateau.getPlayer2().getDeck().add(CSoR5);

        //Carte Communes
        Carte CSo1= new Sort(Demos, "Charge", 1, new Charge());
        Carte CSo2 = new Sort(Demos, "Attaque mentale", 2, new AttaqueMentale());
        Carte CSe1 = new Serviteur(Demos, "Chasse-marée murloc", 2,2,1, new CriDeGuerre());
        Carte CSe2 = new Serviteur(Demos, "Champion de Hurlevent", 7,6,6, new BonusDeHurlevent());
        Carte CSe3 = new Serviteur(Demos, "Chef de raid", 3,2,2,new BonusDuChefDeRaid());
        Carte CSe4 = new Serviteur(Demos, "Garde de Baie-du-butin", 5,5,4, new Provocation());
        Carte CSe5 = new Serviteur(Demos,"La missilière téméraire", 6, 5, 2, new jeu.Capacites.Charge());
        Carte CSe6 = new Serviteur(Demos,"L'ogre-magi", 4, 4, 4, new jeu.Capacites.Provocation());
        Carte CSe7 = new Serviteur(Demos,"Archimage", 6, 4, 7, new jeu.Capacites.Provocation());
        Carte CSe8 = new Serviteur(Demos,"L'ogre-magi", 4, 4, 4, new Provocation());
                //Ajouter au joueur 1
        plateau.getPlayer1().getDeck().add(CSo1);
        plateau.getPlayer1().getDeck().add(CSo2);
        plateau.getPlayer1().getDeck().add(CSe1);
        plateau.getPlayer1().getDeck().add(CSe2);
        plateau.getPlayer1().getDeck().add(CSe3);
        plateau.getPlayer1().getDeck().add(CSe4);
        plateau.getPlayer1().getDeck().add(CSe5);
        plateau.getPlayer1().getDeck().add(CSe6);
        plateau.getPlayer1().getDeck().add(CSe7);
        plateau.getPlayer1().getDeck().add(CSe8);
                //Ajouter au joueur 2
        plateau.getPlayer2().getDeck().add(CSe1);
        plateau.getPlayer2().getDeck().add(CSe2);
        plateau.getPlayer2().getDeck().add(CSe1);
        plateau.getPlayer2().getDeck().add(CSe2);
        plateau.getPlayer2().getDeck().add(CSe3);
        plateau.getPlayer2().getDeck().add(CSe4);
        plateau.getPlayer2().getDeck().add(CSe5);
        plateau.getPlayer2().getDeck().add(CSe6);
        plateau.getPlayer2().getDeck().add(CSe7);
        plateau.getPlayer2().getDeck().add(CSe8);
