package siteParis;

import java.util.LinkedList;

public class Competition {

	/** 
	 * @uml.property name="aCompetiteurs"
	 * @uml.associationEnd multiplicity="(2 -1)" ordering="true" inverse="deCompetition:siteParis.Competiteur"
	 */
	private LinkedList<Competiteur> aCompetiteurs;
	/**
	 * @uml.property  name="aParis"
	 * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" inverse="appartientCompetition:siteParis.Pari"
	 */
	private LinkedList<Pari> aParis;
	/** 
	 * @uml.property name="dateCloture"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="competition:siteParis.DateFrancaise"
	 */
	private DateFrancaise dateCloture = null;
	/**
	 * @uml.property  name="nom"
	 */
	private String nom;
		
		/**
		 *On verifie que le nom de la competition est correct avant de la creer
		 */
		public Competition(String nom, DateFrancaise dateCloture) throws CompetitionException
      {
			
			if (nom == null) throw new CompetitionException();	
         
         if (nom.length() < 4) throw new CompetitionException();	

			for (int i=0 ; i < nom.length() ; i++){
				char c = nom.charAt(i);
				if (!Character.isLetterOrDigit(c) && c!='-' && c!='_' && c!='.' ) throw new CompetitionException();
			}

         if (dateCloture == null) throw new CompetitionException();	

 			this.nom=nom;
			this.dateCloture = dateCloture;
			this.aCompetiteurs = new LinkedList<Competiteur>();
			this.aParis = new LinkedList<Pari>();
		}
			
			
      /**
		 * Permet de connaitre le nom de la compétition
		 */
		public String getNom(){
			return this.nom;
		}
      
         
		/**
		 * Permet de connaitre la date de clôture de la compétition
		 */
		public DateFrancaise getDate(){
			return this.dateCloture;
		}
					
		/**
		 * Permet de connaitre la liste de compétiteurs de la compétition
		 */
		public LinkedList<Competiteur> getCompetiteurs(){
			return this.aCompetiteurs;
		}
		
		/**
		 * Permet d'ajouter un compétiteur à la liste des compétiteurs de la compétition
		 */
	
		public void addCompetiteur(Competiteur c){
			this.aCompetiteurs.add(c);
		}


   	/**
   	 * Rend une chaîne de caractères representant la compétition.
   	 */
   	public LinkedList<String> toList(){
   		LinkedList<String> r = new LinkedList<String>();
   		r.add(" Nom: " + this.nom);
   		r.add(" Date de clôture: " + this.dateCloture);
   		return r;
   	}

							
		/**
		 * Permet d'avoir la liste des paris de la compétitions
		 */
		public LinkedList<Pari> getParisDeLaCompetition(){
			return this.aParis;
		}


		/**
		 * Permet d'ajouter un objet Pari à la liste des paris de cette compétition
		 */
	
		public void addPari(Pari p){
			this.aParis.add(p);
		
		
		}
		
		/**
		 * Permet d'ajouter une nouvelle compétition
		 */
		 public void ajouterCompetiteur(String [] competiteurs) throws CompetitionException{
		 
		 	// Créer une LinkedList des compétiteurs avec les noms fournis
         LinkedList<Competiteur> ce = new LinkedList<Competiteur>();
      	
   		// Créer les nouveaux compétiteurs et les ajouter à la liste des compétiteurs     
			for (int j=0 ; j < competiteurs.length ; j++){
            Competiteur a = new Competiteur(competiteurs[j], this);
            ce.add(a);		 
         }

      	// Ajouter ces compétiteurs à la liste des compétiteurs de la compétition
         for (int j=0 ; j < ce.size() ; j++){
            Competiteur a = ce.get(j);
            this.addCompetiteur(a);
         }

		 }
		
		
      /**
		 * Solder les joueurs qui ont miser sur le vainqueur dans la compétition
		 */
		public void solderUneCompetition(String vainqueur){
         
         long sommeTotale = 0;		//la somme des jetons misés pour cette compétition
   		long sommeMise = 0;			//la somme des jetons misés sur ce compétiteur
         float gain = 0;				//l'indice du gain_indice = sommeTotale / sommeMise
            
   		// Calculer les sommes des jetons misés et l'indice du gain de ce pari      
   		for (Pari p:this.aParis){
    			sommeTotale = sommeTotale + p.getMiseEnJetons();
            if (p.getVainqueurEnvisage().equals(vainqueur)) {
               sommeMise = sommeMise + p.getMiseEnJetons();
            }
         }
      				
         if (sommeMise != 0) 
            gain =((float)sommeTotale / (float)sommeMise);
   				
         // Solder pour le joueur gagné (gain != 0, c'est-à-dire il y a au moins un joueur à misé sur le vainqueur)
       	if (gain != 0){      	
   	      for (Pari p:this.aParis){
   	        	if (p.getVainqueurEnvisage().equals(vainqueur)) {
   	            // Solder pour les joueurs gagnés
                  Joueur j = p.getJoueur();
                  j.solderVainqueur(gain , p.getMiseEnJetons());
   	         }
               else {
                  // Pour les les joueurs non gagnés
                  Joueur j = p.getJoueur();
   	           	j.diminuerMiseEnJetons(p.getMiseEnJetons());
               }
   	      }
	      }
				
		   // gain = 0, c'est-à-dire personne n'a misé sur le vainqueur
		   else{
		      for (Pari p:this.aParis){
	           	Joueur j = p.getJoueur();		
	        		j.solderVainqueur(0 , p.getMiseEnJetons());
	        	}
	      }
      }
      
		
      public static void main(String [] args){
         try {
            
            DateFrancaise.setDate(1, 1, 2010);

            //Test Constructor
            System.out.println("Test Constructor");

            try {
				Competition c = new Competition(null, new DateFrancaise(4, 8, 2011));
				System.out.println("créer une compétition avec un nom invalide (non instancié) n'a pas levé l'exception CompetitionException ");
   			}
   			catch (CompetitionException e) { }
   			catch (Exception e) { 
   				System.out.println("créer une compétition avec un nom invalide (non instancié)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
   			}
   
   			try {
   				Competition c = new Competition("Championnat DeFrance2014", new DateFrancaise(27, 6, 2013, 20, 00));
   				System.out.println("créer une compétition avec un nom invalide (avec espace) n'a pas levé l'exception CompetitionException ");
   			}
   			catch (CompetitionException e) { }
   			catch (Exception e) { 
   				System.out.println("créer une compétition avec un nom invalide (avec espace)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
   			}
   
   			try {
   				Competition c = new Competition("finale|RG2012", new DateFrancaise(4, 8, 2011));
   				System.out.println("créer une compétition avec un nom invalide (caractere |) n'a pas levé l'exception CompetitionException ");
   			}
   			catch (CompetitionException e) { }
   			catch (Exception e) { 
   				System.out.println("créer une compétition avec un nom invalide (caractere |)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
   			}
   
   			try {
   				Competition c = new Competition("RGA", new DateFrancaise(4, 8, 2011));
   				System.out.println("créer une compétition avec un nom invalide (moins de 4 caractères) n'a pas levé l'exception CompetitionException ");
   			}
   			catch (CompetitionException e) { }
   			catch (Exception e) { 
   				System.out.println("créer une compétition avec un nom invalide (moins de 4 caractères)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
   			}
   
   			try {
   				Competition c = new Competition("finaleRG2032", null);
   				System.out.println("créer une compétition avec une date invalide (non instanciée) n'a pas levé l'exception CompetitionException ");
   			}
   			catch (CompetitionException e) { }
   			catch (Exception e) { 
   				System.out.println("créer une compétition avec une date invalide (non instanciée) n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
   			}

            //Créer une nouvelle compétition de manière correct
            DateFrancaise dateCloture = new DateFrancaise(4, 6, 2012, 15, 00);
            Competition c = new Competition("HorseRace", dateCloture);
            System.out.println("\nCréer une compétition : " + c.toList());
            System.out.println("Les compétiteurs : " + c.getCompetiteurs().toString());
            System.out.println("Les paris en cours : " + c.getParisDeLaCompetition().toString());

            Joueur j1 = new Joueur("Abcdd","Abcdd","Joueur1");
            Joueur j2 = new Joueur("Abcde","Abcde","Joueur2");
            Joueur j3 = new Joueur("Abcdf","Abcdf","Joueur3");
            
            j1.crediterUnJoueur(50);
            j2.crediterUnJoueur(50);
            j3.crediterUnJoueur(50);
            
            System.out.println("\nLes joueurs qui vont participer la compétition HorseRace:");
            System.out.println(j1.toList());
            System.out.println(j2.toList());
            System.out.println(j3.toList());
            
            // Créer les nouveaux compétiteur
            Competiteur ce1 = new Competiteur("Cheval-n1", c);
            Competiteur ce2 = new Competiteur("Cheval-n2", c);
            Competiteur ce3 = new Competiteur("Cheval-n3", c);
            // Test addCompetiteur()
            c.addCompetiteur(ce1);
            c.addCompetiteur(ce2);
            c.addCompetiteur(ce3);
            System.out.println("\nLes compétiteurs (après les ajouter à la compétition): " + c.getCompetiteurs().toString());

            Pari p1 = j1.miserVainqueur(c, "Cheval-n1", 10);
            Pari p2 = j2.miserVainqueur(c, "Cheval-n2", 10);
            Pari p3 = j3.miserVainqueur(c, "Cheval-n1", 10);
            // Test addPari()
            c.addPari(p1);
            c.addPari(p2);
            c.addPari(p3);
            System.out.println("\nLes paris de la compétition (après les joueurs misent): " + c.getParisDeLaCompetition());

            
                        
            
            c.solderUneCompetition("Cheval-n1");
            System.out.println("\nLes comptes des joueurs après solder la compétition HorseRace (Cheval-n1 est le vainqueur):");
            System.out.println(j1.toList());
            System.out.println(j2.toList());
            System.out.println(j3.toList());
         }   
         catch (Exception e) {
               System.out.println("\n Exception imprévue : " + e) ;
         }

      }
							

}
