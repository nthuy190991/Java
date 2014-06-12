   package siteParis;


   import java.util.LinkedList;
   import java.util.List;


/**
 * 
 * @author Bernard Prou et Julien Mallet
 * <br><br>
 * La classe qui contient toutes les méthodes "Métier" de la gestion du site de paris. 
 * <br><br>
 * Dans toutes les méthodes :
 * <ul>
 * <li>un paramètre de type <code>String</code> est invalide si il n'est pas instancié.</li>
 *  <li>pour la validité d'un password de gestionnaire et d'un password de joueur :
 * <ul>
 * <li>       lettres et chiffres sont les seuls caractères autorisés </li>
 * <li>       il doit avoir une longueur d'au moins 8 caractères </li>
 * </ul></li>       
 * <li>pour la validité d'un pseudo de joueur  :
 * <ul>
 * <li>        lettres et chiffres sont les seuls caractères autorisés  </li>
 * <li>       il doit avoir une longueur d'au moins 4 caractères</li>
 * </ul></li>       
 * <li>pour la validité d'un prénom de joueur et d'un nom de joueur :
 *  <ul>
 *  <li>       lettres et tiret sont les seuls caractères autorisés  </li>
 *  <li>      il  doit avoir une longueur d'au moins 1 caractère </li>
 * </ul></li>
 * <li>pour la validité d'une compétition  :       
 *  <ul>
 *  <li>       lettres, chiffres, point, trait d'union et souligné sont les seuls caractères autorisés </li>
 *  <li>      elle  doit avoir une longueur d'au moins 4 caractères</li>
 * </ul></li>       
 * <li>pour la validité d'un compétiteur  :       
 *  <ul>
 *  <li>       lettres, chiffres, trait d'union et souligné sont les seuls caractères autorisés </li>
 *  <li>      il doit avoir une longueur d'au moins 4 caractères.</li>
 * </ul></li></ul>
 */

   public class SiteDeParisMetier {
   
   
   /**
    * @uml.property  name="date"
    * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" inverse="siteDeParisMetier:siteParis.DateFrancaise"
    */
      private List<DateFrancaise> date;
   /** 
    * @uml.property name="joueurs"
    * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="siteDeParisMetier:siteParis.Joueur"
    */
      private LinkedList<Joueur> joueurs;
   /**
    * @uml.property  name="competitions"
    * @uml.associationEnd  multiplicity="(0 -1)" ordering="true" inverse="siteDeParisMetier:siteParis.Competition"
    */
      private LinkedList<Competition> competitions;
   /** 
    * @uml.property name="competiteurs"
    * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="siteDeParisMetier:siteParis.Competiteur"
    */
      private LinkedList<Competiteur> competiteurs;
   /** 
    * @uml.property name="paris"
    * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="siteDeParisMetier:siteParis.Pari"
    */
      private LinkedList<Pari> paris;
   /**
    * @uml.property  name="passwordGestionnaire"
    */
      private String passwordGestionnaire;
   
   
   /**
    * constructeur de <code>SiteDeParisMetier</code>. 
    * 
    * @param passwordGestionnaire   le password du gestionnaire.   
    * 
    * @throws MetierException  levée 
    * si le <code>passwordGestionnaire</code>  est invalide 
    */
      public SiteDeParisMetier(String passwordGestionnaire) throws MetierException {
      
         this.passwordGestionnaire = passwordGestionnaire;
      
      // Vérifier la validité du password du gestionnaire
         validitePasswordGestionnaire(passwordGestionnaire);
      
         this.competitions = new LinkedList<Competition>();
         this.competiteurs = new LinkedList<Competiteur>();
         this.joueurs = new LinkedList<Joueur>();
         this.paris = new LinkedList<Pari>();
      }
   
   
   
   
   
   // Les méthodes du gestionnaire (avec mot de passe gestionnaire)
   
   
   
   /**
    * inscrire un joueur. 
    * 
    * @param nom   le nom du joueur 
    * @param prenom   le prénom du joueur   
    * @param pseudo   le pseudo du joueur  
    * @param passwordGestionnaire  le password du gestionnaire du site  
    * 
    * @throws MetierException   levée  
    * si le <code>passwordGestionnaire</code> proposé est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect.
    * @throws JoueurExistantException   levée si un joueur existe avec les mêmes noms et prénoms ou le même pseudo.
    * @throws JoueurException levée si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
    * 
    * @return le mot de passe (déterminé par le site) du nouveau joueur inscrit.
    */
      public String inscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurExistantException, JoueurException {
         
         //vérifier la validité du password du gestionnaire
         validitePasswordGestionnaire(passwordGestionnaire);
         
         
         verifierJoueurInexistant(nom , prenom , pseudo);
         
         verifierJoueur(nom , prenom , pseudo);
         
         Joueur j = new Joueur(nom , prenom , pseudo);
         
         this.joueurs.add(j);
         
         return j.getPassword();
      }
   
 /**
    * supprimer un joueur. 
    * 
    * @param nom   le nom du joueur 
    * @param prenom   le prénom du joueur   
    * @param pseudo   le pseudo du joueur  
    * @param passwordGestionnaire  le password du gestionnaire du site  
    * 
    * @throws MetierException
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect.
    * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec le même <code>nom</code>, <code>prenom</code>  et <code>pseudo</code>.
    * @throws JoueurException levée 
    * si le joueur a des paris en cours,
    * si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
    * 
    * @return le nombre de jetons à rembourser  au joueur qui vient d'être désinscrit.
    * 
    */
      public long desinscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurInexistantException, JoueurException {
   		
			//vérifier la validité du password du gestionnaire
         validitePasswordGestionnaire(passwordGestionnaire);
         
   		//vérifier que le nom, le prénom et le pseudo du joueur
         verifierJoueur(nom , prenom , pseudo);      
			
			//vérifier que il existe un joueur avec les mêmes noms et prénoms ou le même pseudo
         Joueur j = verifierJoueurExistant(nom , prenom , pseudo);
         
			//vérifier que le joueur n'a pas des paris en cours
			verifierJoueurPasEnCours(j);
			
			//
			long nombreEnJetons = j.getSolde();
						
			//Enlèver l'objet Joueur dans la liste des joueurs
			this.joueurs.remove(j);
			
			return nombreEnJetons;
      }
   
      
   
   /**
    * ajouter une compétition.  
    * 
    * @param competition le nom de la compétition
    * @param dateCloture   la date à partir de laquelle il ne sera plus possible de miser  
    * @param competiteurs   les noms des différents compétiteurs de la compétition 
    * @param passwordGestionnaire  le password du gestionnaire du site 
    * 
    * @throws MetierException levée si le tableau des
    * compétiteurs n'est pas instancié, si le
    * <code>passwordGestionnaire</code> est invalide, si le
    * <code>passwordGestionnaire</code> est incorrect.
    * @throws CompetitionExistanteException levée si une compétition existe avec le même nom. 
    * @throws CompetitionException levée si le nom de la
    * compétition ou des compétiteurs sont invalides, si il y a
    * moins de 2 compétiteurs, si deux compétiteurs ont le même
    * nom, si la date de clôture n'est pas instanciée ou est
    * dépassée.
    */
      public void ajouterCompetition(String competition, DateFrancaise dateCloture, String [] competiteurs, String passwordGestionnaire) throws MetierException, 		CompetitionExistanteException, CompetitionException  {
      
      // vérification (passwordGestionnaire, nom de la compétition, compétiteurs, date
		
         validitePasswordGestionnaire(passwordGestionnaire);
      
         verifierCompetition(competition);
      
         verifierCompetiteurs(competiteurs);
      
         verifierDate(dateCloture);
      
         verifierCompetitionInexistante(competition);
      
      
      // Créer un nouvel objet compétition avec le nom fourni et les objets des compétiteurs
         Competition ci = new Competition(competition , dateCloture);
      	
      	ci.ajouterCompetiteur(competiteurs);     
			 
		// Ajouter cette compétition à la liste des compétitions dans le SiteDeParisMetier
         this.competitions.add(ci);
      
			LinkedList <Competiteur> ce = ci.getCompetiteurs();
			
		/* Ajouter les compétiteurs de la compétition à la liste des compétiteurs dans le SiteDeParisMetier
       * D'abord, on vérifie que le compétiteur n'est pas dans la liste de SiteDeParisMetier avant de l'ajouter
       */
         for (int j=0 ; j < ce.size() ; j++){
            Competiteur a = ce.get(j);
            for (Competiteur f:this.competiteurs){
               if (!f.getNom().equals(a.getNom())){
                  this.competiteurs.add(a);
               }
            }
         }  
      }
   
	
	
   /**
    * solder une compétition vainqueur (compétition avec vainqueur).  
    * 
    * Chaque joueur ayant misé sur cette compétition
    * en choisissant ce compétiteur est crédité d'un nombre de
    * jetons égal à :
    * 
    * (le montant de sa mise * la somme des
    * jetons misés pour cette compétition) / la somme des jetons
    * misés sur ce compétiteur.
    *
    * Si aucun joueur n'a trouvé le
    * bon compétiteur, des jetons sont crédités aux joueurs ayant
    * misé sur cette compétition (conformément au montant de
    * leurs mises). La compétition est "supprimée" si il ne reste
    * plus de mises suite à ce solde.
    * 
    * @param competition   le nom de la compétition  
    * @param vainqueur   le nom du vainqueur de la compétition 
    * @param passwordGestionnaire  le password du gestionnaire du site 
    * 
    * @throws MetierException   levée 
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect.
    * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom.
    * @throws CompetitionException levée 
    * si le nom de la compétition ou du vainqueur est invalide, 
    * si il n'existe pas de compétiteur du nom du vainqueur dans la compétition,
    * si la date de clôture de la compétition est dans le futur.
    * 
    */	
      public void solderVainqueur(String competition, String vainqueur, String passwordGestionnaire) throws MetierException,  CompetitionInexistanteException, CompetitionException  {
      
         // vérifier la validité du password du gestionnaire
         validitePasswordGestionnaire(passwordGestionnaire);
      
         // vérifier que la compétition existe déja.
         Competition c = verifierCompetitionExistante(competition);
						
         // Vérifier que la date de clôture n'est pas dans le futur
         verifierDateEstPasse(c.getDate());
                  
         // Vérifier que le nom du vainqueur envisage est valide et existe dans la compétition
         verifierCompetiteur(vainqueur , c);
   		
   		c.solderUneCompetition(vainqueur);
                        
         // On enlève cette compétition de la liste des compétitions dans la class SiteDeParisMetier
   		this.competitions.remove(c);
     }
   
   
   
   /**
    * créditer le compte en jetons d'un joueur du site de paris.
    * 
    * @param nom   le nom du joueur 
    * @param prenom   le prénom du joueur   
    * @param pseudo   le pseudo du joueur  
    * @param sommeEnJetons   la somme en jetons à créditer  
    * @param passwordGestionnaire  le password du gestionnaire du site  
    * 
    * @throws MetierException   levée 
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect,
    * si la somme en jetons est négative.
    * @throws JoueurException levée  
    * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides.
    * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec les mêmes nom,  prénom et pseudo.
    */
      public void crediterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws MetierException, JoueurException, JoueurInexistantException {
      
			validitePasswordGestionnaire(passwordGestionnaire);
			
			verifierSommeEnJetonsPositive(sommeEnJetons);
			
			verifierJoueur(nom, prenom, pseudo);
			
			Joueur j = verifierJoueurExistant(nom, prenom, pseudo);
			
			j.crediterUnJoueur(sommeEnJetons);
		
      }
   
   
   /**
    * débiter le compte en jetons d'un joueur du site de paris.
    * 
    * @param nom   le nom du joueur 
    * @param prenom   le prénom du joueur   
    * @param pseudo   le pseudo du joueur  
    * @param sommeEnJetons   la somme en jetons à débiter  
    * @param passwordGestionnaire  le password du gestionnaire du site  
    * 
    * @throws MetierException   levée 
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect,
    * si la somme en jetons est négative.
    * @throws JoueurException levée  
    * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides 
    * si le compte en jetons du joueur est insuffisant (il deviendrait négatif).
    * @throws JoueurInexistantException   levée si il n'y a pas de joueur  avec les mêmes nom,  prénom et pseudo.
    * 
    */
   
      public void debiterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws  MetierException, JoueurInexistantException, JoueurException {
      	
			validitePasswordGestionnaire(passwordGestionnaire);
			
			verifierSommeEnJetonsPositive(sommeEnJetons);
			
			verifierJoueur(nom, prenom, pseudo);
			
			Joueur j = verifierJoueurExistant(nom, prenom, pseudo);
			
			verifierCompteSuffisant(j, sommeEnJetons);
			
			j.debiterUnJoueur(sommeEnJetons);
      }
   
   
   
   /** 
    * consulter les  joueurs.
    * 
    * @param passwordGestionnaire  le password du gestionnaire du site de paris 
   
    * @throws MetierException   levée  
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect.
    * 
    * @return une liste de liste dont les éléments (de type <code>String</code>) représentent un joueur avec dans l'ordre : 
    *  <ul>
    *  <li>       le nom du joueur  </li>
    *  <li>       le prénom du joueur </li>
    *  <li>       le pseudo du joueur  </li>
    *  <li>       son compte en jetons restant disponibles </li>
    *  <li>       le total de jetons engagés dans ses mises en cours. </li>
    *  </ul>
    */
      public LinkedList <LinkedList <String>> consulterJoueurs(String passwordGestionnaire) throws MetierException {
 			
			// Vérifier la validité du password du gestionnaire
			validitePasswordGestionnaire(passwordGestionnaire);  
			
			// Ajouter la liste de chaque joueur dans la liste de liste dont éléments représentent un joueur
	      LinkedList <LinkedList <String>> listeJoueurs = new LinkedList <LinkedList <String>>();
			
         for (Joueur j:this.joueurs){
				listeJoueurs.add(j.toList());
			}
			
			return listeJoueurs;
      }
   
   
   
   
   
   
   
   
   // Les méthodes avec mot de passe utilisateur
   
   
   
   /**
    * miserVainqueur  (parier sur une compétition, en désignant un vainqueur).
    * Le compte du joueur est débité du nombre de jetons misés.
    * 
    * @param pseudo   le pseudo du joueur  
    * @param passwordJoueur  le password du joueur  
    * @param miseEnJetons   la somme en jetons à miser  
    * @param competition   le nom de la compétition  relative au pari effectué
    * @param vainqueurEnvisage   le nom du compétiteur  sur lequel le joueur mise comme étant le  vainqueur de la compétition  
    * 
    * @throws MetierException levée si la somme en jetons est négative.
    * @throws JoueurInexistantException levée si il n'y a pas de
    * joueur avec les mêmes pseudos et password.
    * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom. 
    * @throws CompetitionException levée 
    * si <code>competition</code> ou <code>vainqueurEnvisage</code> sont invalides,
    * si il n'existe pas un compétiteur de  nom <code>vainqueurEnvisage</code> dans la compétition,
    * si la compétition n'est plus ouverte (la date de clôture est dans le passé).
    * @throws JoueurException   levée 
    * si <code>pseudo</code> ou <code>password</code> sont invalides, 
    * si le <code>compteEnJetons</code> du joueur est insuffisant (il deviendrait négatif).
    */
      public void miserVainqueur(String pseudo, String passwordJoueur, long miseEnJetons, String competition, String vainqueurEnvisage) throws MetierException, JoueurInexistantException, CompetitionInexistanteException, CompetitionException, JoueurException  {
      
         	// vérifier la validité du password associé à le pseudo du joueur.
            validitePasswordJoueur(pseudo , passwordJoueur);
         
         	// vérifier que le nom de la compétition est valide
            verifierCompetition(competition);
         
         	// vérifier que la compétition existe déja
            Competition c = verifierCompetitionExistante(competition);
         
         	// Vérifier que la date de clôture est instanciée et n'est pas dépassé
            verifierDate(c.getDate());
               
         	// Vérifier que le compétiteur de nom vainqueurEnvisage est valide et existe dans la compétition
            verifierCompetiteur(vainqueurEnvisage , c);
      
            Joueur j0 = null;
         
            for (Joueur j:this.joueurs) 
               if (j.getPseudo().equals(pseudo))   j0 = j;
         
         	// Vérifier que la somme en jetons n'est pas négative
            verifierSommeEnJetonsPositive(miseEnJetons);
				
         	// Vérifier que le compte du joueur est suffisant 
            verifierCompteSuffisant(j0, miseEnJetons);
            
            Pari p = j0.miserVainqueur(c, vainqueurEnvisage, miseEnJetons);
            
				// Ajouter le nouveau objet Pari à la liste des paris de la compétition
            c.addPari(p);
				               
	         // Ajouter le nouveau objet Pari à la liste des paris en cours dans le SiteDeParisMetier
            this.paris.add(p);
         
      }
   
   
    
   
   // Les méthodes sans mot de passe
   
   
   /**
    * connaître les compétitions en cours.
    * 
    * @return une liste de liste dont les éléments (de type <code>String</code>) représentent une compétition avec dans l'ordre : 
    *  <ul>
    *  <li>       le nom de la compétition,  </li>
    *  <li>       la date de clôture de la compétition. </li>
    *  </ul>
    */
	 
	 
      public LinkedList <LinkedList <String>> consulterCompetitions(){
         
			// Ajouter la liste de chaque compétition dans la liste de liste dont éléments représentent une compétition
	      LinkedList <LinkedList <String>> listeCompetitions = new LinkedList <LinkedList <String>>();
			
         for (Competition ci:this.competitions){
				listeCompetitions.add(ci.toList());
			}
			
			return listeCompetitions;
      } 
		
		
		
   
   /**
    * connaître  la liste des noms des compétiteurs d'une compétition.  
    * 
    * @param competition   le nom de la compétition  
    * 
    * @throws CompetitionException   levée  
    * si le nom de la compétition est invalide.
    * @throws CompetitionInexistanteException   levée si il n'existe pas de compétition de même nom. 
    * 
    * @return la liste des compétiteurs de la  compétition.
    */
	 
	 
      public LinkedList <String> consulterCompetiteurs(String competition) throws CompetitionException, CompetitionInexistanteException{
         
			
			verifierCompetition(competition);
			
			Competition c = verifierCompetitionExistante(competition);
			
			LinkedList <String> listeCompetiteurs = new LinkedList <String> ();
			
   		for (Competiteur ce:c.getCompetiteurs()){
				listeCompetiteurs.add(ce.toString());
			}
			return listeCompetiteurs;
      }
		
		
   
   /**
    * vérifier la validité du password du gestionnaire.
    * 
    * @param passwordGestionnaire   le password du gestionnaire à vérifier
    * 
    * @throws MetierException   levée 
    * si le <code>passwordGestionnaire</code> est invalide,  
    * si le <code>passwordGestionnaire</code> à vérifier n'est pas correct.
    */
      protected void validitePasswordGestionnaire(String passwordGestionnaire) throws MetierException {
      
      	if (!verifierString(passwordGestionnaire , 8 , true , new char [] {})) throw new MetierException();
						
			if (!passwordGestionnaire.equals(this.passwordGestionnaire)) throw new MetierException();
      }
		
		
   
   /**
    * vérifier la validité du password associé à son pseudo.
    * 
    * @param pseudo   le pseudo du joueur
    * @param passwordJoueur   le password du joueur à vérifier
    * 
    * @throws JoueurException   levée  si le <code>pseudo</code> ou le <code>passwordJoueur</code> sont invalides. 
    * @throws JoueurInexistantException   levée  si le <code>passwordJoueur</code> et le <code>pseudo</code> ne correspondent pas.
    */
      protected void validitePasswordJoueur(String pseudo, String passwordJoueur) throws JoueurException, JoueurInexistantException {
      
      // vérifier le pseudo du joueur est valide
      	if (!verifierString(pseudo , 4 , true , new char [] {})) throw new JoueurException();
               
      // vérifier le password du joueur est valide
      	if (!verifierString(passwordJoueur , 8 , true , new char [] {})) throw new JoueurException();
      
		// vérifier qu'il y a un joueur avec ce pseudo
			boolean trouve = false;
         Joueur j0 = null;
         
			for (Joueur j:this.joueurs){
            if (pseudo.equals(j.getPseudo())){
					trouve = true;
               j0 = j;
            }
         }
			if (!trouve) throw new JoueurInexistantException();
		
		// vérifier que le pseudo et le passwordJoueur correspondent
         if (!passwordJoueur.equals(j0.getPassword())) throw new JoueurInexistantException();
                           
      }  
   
	
	
   /**
    * vérifier que le nom du compétiteur est valide et qu'il existe un compétiteur de ce nom dans la compétition.
    * 
    * @param nomCompetiteur   le nom du compétiteur
    * @param ci   				l'objet de la compétition
    * 
    * @throws CompetitionException levée si le nom du compétiteur est invalide 
    * ou il n'existe pas de compétiteur de ce nom dans la compétition. 
    */
      public void verifierCompetiteur(String nomCompetiteur, Competition ci) throws CompetitionException{
      
      // vérifier la validité du nom du compétiteur
      	if (!verifierString(nomCompetiteur , 4 , true , new char [] {'-' , '_'})) throw new CompetitionException();
                   
      // vérifier l'existence du compétiteur dans la compétition
         boolean trouve = false;
         for (Competiteur ce : ci.getCompetiteurs()){
            if (nomCompetiteur.equals(ce.getNom()))	trouve = true;
         }
      
         if (!trouve) throw new CompetitionException();
      }
   	
		
		
   /**
    * vérifier que la somme en jetons n'est pas négative
    * 
    * @param sommeEnJetons   la somme en jetons
    * 
    * @throws MetierException   levée 
    * si la somme en jetons est négative
    */
      public void verifierSommeEnJetonsPositive(long sommeEnJetons) throws MetierException{
         if (sommeEnJetons < 0) throw new MetierException();
      }
   		
			
						
   /**
    * vérifier que le compte du joueur est suffisant pour miser sur une compétition
    * 
    * @param j   					l'objet Joueur
    * @param miseEnJetons   	la somme en jetons à miser
    * 
    * @throws JoueurException   levée 
    * si la somme en jetons est inférieur que la somme en jetons à mise
    */
      public void verifierCompteSuffisant(Joueur j , long miseEnJetons) throws JoueurException{
         long sommeEnJetons = j.getSolde();
			if (sommeEnJetons < miseEnJetons) throw new JoueurException(); 
      }
   
   /**
    * vérifier que la compétition existe déja ou elle n'existe pas.
    * 
    * @param nomCompetition   le nom de la compétition
    * 
    * @return null
    * s'il n'existe pas de competition de même nom 
    * @return l'objet Competition
    * si la compétition de même nom existe
    */
		public Competition verifierCompetitionExOuInex(String nomCompetition){
	
			Competition c = null;
			
         for (Competition ci:this.competitions){
            if (ci.getNom().equals(nomCompetition)){
					c = ci; 
				}
 		   }
			
			return c;
		}



   /**
    * vérifier que la compétition existe déja.
    * 
    * @param nomCompetition   le nom de la compétition
    * 
    * @throws CompetitionInexistanteException   levée 
    * s'il n'existe pas de competition de même nom 
    */
      public Competition verifierCompetitionExistante(String nomCompetition) throws CompetitionInexistanteException{
      
   		Competition c = verifierCompetitionExOuInex(nomCompetition);      
			if (c == null) throw new CompetitionInexistanteException();
			return c;
      }
   
	
	
   /**
    * vérifier que la compétition n'existe pas.
    * 
    * @param nomCompetition   le nom de la compétition
    * 
    * @throws CompetitionExistanteException   levée 
    * si une compétition existe déja avec le même nom
    */
      public void verifierCompetitionInexistante(String nomCompetition) throws CompetitionExistanteException{
      
         Competition c = verifierCompetitionExOuInex(nomCompetition);      
			if (c != null) throw new CompetitionExistanteException();
      }
   
   
	
   /**
    * vérifier que le nom de la compétition est valide.
    * 
    * @param nomCompetition   le nom de la compétition
    * 
    * @throws CompetitionException levée si le nom de la compétition est invalide 
    */
      public void verifierCompetition(String nomCompetition) throws CompetitionException{
      
      	if (!verifierString(nomCompetition , 4 , true , new char [] {'-' , '_' , '.'})) throw new CompetitionException();
      }
   
	
	
   /**
    * vérifier qu'il y a au moins de 2 compétiteurs 
    * et que la liste des noms des compétiteurs est valide et que les compétiteurs n'ont pas le même nom.
    * 
    * @param competiteurs   la liste des noms des compétiteurs
    * 
    * @throws CompetitionException   levée 
    * si il y a moins de 2 compétiteurs
    * si le nom d'un (ou plusieurs) des compétiteurs est invalide
    * si les compétiteurs ont le même nom
	 *
	 * @throws MetierException   levée
	 * si le tableau des nom des compétiteurs est invalide (non instancié)
    */
      public void verifierCompetiteurs(String [] competiteurs) throws CompetitionException, MetierException{
      
   		// verifier que le tableau des compétiteurs est instancié
			if (competiteurs == null) throw new MetierException();
			  		
			// vérifier qu'il y a au moins de 2 compétiteurs
			if (competiteurs.length < 2) throw new CompetitionException();
      
      	// vérifier que tous des noms des compétiteurs sont valides
      	for (int j=0 ; j < competiteurs.length ; j++){
      		if (!verifierString(competiteurs[j] , 4 , true , new char [] {'-' , '_'})) throw new CompetitionException();
      	}
               
         // vérifier qu'ils n'ont pas le même nom
         for (int j=0 ; j < competiteurs.length ; j++){
            for (int i=0 ; i < competiteurs.length ; i++){
               if (i != j) {
                  if (competiteurs[i].equals(competiteurs[j])) throw new CompetitionException();
               }
            }
         }
      }
      
		
		
   /**
    * vérifier qu'il n'y a d'autre joueur avec les mêmes nom et prénom ou le même pseudo.
    * 
    * @param nom     le nom du joueur
    * @param prenom  le prénom du joueur
    * @param pseudo  le pseudo du joueur
    * 
    * @throws JoueurExistanteException   levée 
    * si un joueur existe avec les mêmes nom et prénom ou le même pseudo
    * @return le mot de passe du nouveau joueur inscrit.
    */
      public void verifierJoueurInexistant(String nom, String prenom, String pseudo) throws JoueurExistantException{
      
         boolean trouve = false;
         for (Joueur j:this.joueurs){
            if (((j.getNom().equals(nom))&&(j.getPrenom().equals(prenom)))||(j.getPseudo().equals(pseudo)))	trouve = true; 
         }
      
         if (trouve) throw new JoueurExistantException();
      }
   
	
	
   /**
    * vérifier qu'il existe un joueur avec les mêmes nom et prénom ou le même pseudo.
    * 
    * @param nom     le nom du joueur
    * @param prenom  le prénom du joueur
    * @param pseudo  le pseudo du joueur
    * 
    * @throws JoueurInexistanteException   levée 
    * si il n'y a pas de joueur avec les mêmes nom, prénom et pseudo
    * @return l'objet Joueur avec avec les mêmes nom, prénom et pseudo.
    */
      public Joueur verifierJoueurExistant(String nom, String prenom, String pseudo) throws JoueurInexistantException{
      
         boolean trouve = false;
			Joueur j0 = null;
         for (Joueur j:this.joueurs){
            if ((j.getNom().equals(nom))&&(j.getPrenom().equals(prenom))&&(j.getPseudo().equals(pseudo))){	
					trouve = true; 
					j0 = j;
				}
         }
      
         if (!trouve) throw new JoueurInexistantException();
			return j0;
      }



   /**
    * vérifier que le nom, le prénom et le pseudo du joueur sont valides.
    * 
    * @param nom     le nom du joueur
    * @param prenom  le prénom du joueur
    * @param pseudo  le pseudo du joueur   
    * 
    * @throws JoueurException levée si le nom, le prénom ou le pseudo du joueur sont invalides. 
    */
      public void verifierJoueur(String nom, String prenom, String pseudo) throws JoueurException{
      
      	if (!verifierString(nom , 1 , false , new char [] {'-'})) throw new JoueurException();
         
         if (!verifierString(prenom , 1 , false , new char [] {'-'})) throw new JoueurException();
         
         if (!verifierString(pseudo , 4 , true , new char [] {})) throw new JoueurException();
         
      }
		
		   
	

   
   /**
    * vérifier que la date de clôture est correcte
    * 
    * @param date   la date de clôture
    * 
    * @throws CompetitionException   levée 
    * si la date est dépassée
    * si la date n'est pas instanciée
    */
      public void verifierDate(DateFrancaise date) throws CompetitionException{
      // vérifier que la date est instanciée
         if (date == null) throw new CompetitionException();
      
      // vérifier que la date n'est pas dépassée
         if (date.estDansLePasse()) throw new CompetitionException();
      }
   
	
	
   /**
    * vérifier que la date de clôture est dépassé
    * 
    * @param date   la date de clôture
    * 
    * @throws CompetitionException   levée 
    * si la date est dans le futur
    * si la date n'est pas instanciée
    */
      public void verifierDateEstPasse(DateFrancaise date) throws CompetitionException{
      // vérifier que la date est instanciée
         if (date == null) throw new CompetitionException();
      
      // vérifier que la date est dépassée    
         if (!date.estDansLePasse()) throw new CompetitionException();
      }
		
		
   
   /**
    * vérifier qu'un paramètre de type <code>String</code> est valide, qu'il est instancié,
    * qu'il a une longueur d'au moins la longueur minimale et qu'il a les caractères corrects
    * 
    * @param str	   		le paramètre de type String, comme pseudo, password, nom, prénom, etc
    * @param minLongueur	la longueur minimale souhaitée du paramètre String
    * @param chiffre			le drapeau permet de connaitre si les chiffres sont des caractères autorisés ou non dans le paramètre String
    * @param caracteres		le tableau des caractères (sauf les lettres et les chiffres) qui peuvent être autorisés dans le paramètre String
    *
    * @returns true 
    * si le String str est instancié et s'il est plus long que la longueur minimale 
    * et s'il a seulement les seuls caractères permis
    *
    * @returns false
    * sinon
    */
      public boolean verifierString(String str , int minLongueur , boolean chiffre , char [] caracteres){
      
         if (str == null) return false;
			
         if (str.length() < minLongueur) return false;
      	
         for (int i=0 ; i < str.length() ; i++){
            char c = str.charAt(i);
         
            int k = 0;
            if (chiffre){
               for (int j=0 ; j<caracteres.length ; j++){
                  if (c!=caracteres[j]) k++;
               }
            
               if (!Character.isLetterOrDigit(c) && k==caracteres.length) return false;
           
			   /* si k = caracteres.length, c'est-à-dire <code>c</code>est différent de 
             * tous les caractères fournis dans <code>caracteres</code> */
            }
            else{
               for (int j=0 ; j<caracteres.length ; j++){
                  if (c!=caracteres[j]) k++;
               }
            
               if (!Character.isLetter(c) && k==caracteres.length) return false;
            }
         }
      
         return true;
      }
   
	
	
	 /**
    * vérifier que le joueur n'a pas des paris en cours.
    * 
    * @param nom     le nom du joueur
    * @param prenom  le prénom du joueur
    * @param pseudo  le pseudo du joueur   
    * 
    * @throws JoueurException levée si le joueur a des paris en cours. 
    */
      public void verifierJoueurPasEnCours(Joueur j) throws JoueurException{
   		if (j.getMise() > 0) throw new JoueurException();
      }
     
   }


