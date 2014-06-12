   package siteParis;


   import java.util.LinkedList;
   import java.util.List;


/**
 * 
 * @author Bernard Prou et Julien Mallet
 * <br><br>
 * La classe qui contient toutes les m�thodes "M�tier" de la gestion du site de paris. 
 * <br><br>
 * Dans toutes les m�thodes :
 * <ul>
 * <li>un param�tre de type <code>String</code> est invalide si il n'est pas instanci�.</li>
 *  <li>pour la validit� d'un password de gestionnaire et d'un password de joueur :
 * <ul>
 * <li>       lettres et chiffres sont les seuls caract�res autoris�s </li>
 * <li>       il doit avoir une longueur d'au moins 8 caract�res </li>
 * </ul></li>       
 * <li>pour la validit� d'un pseudo de joueur  :
 * <ul>
 * <li>        lettres et chiffres sont les seuls caract�res autoris�s  </li>
 * <li>       il doit avoir une longueur d'au moins 4 caract�res</li>
 * </ul></li>       
 * <li>pour la validit� d'un pr�nom de joueur et d'un nom de joueur :
 *  <ul>
 *  <li>       lettres et tiret sont les seuls caract�res autoris�s  </li>
 *  <li>      il  doit avoir une longueur d'au moins 1 caract�re </li>
 * </ul></li>
 * <li>pour la validit� d'une comp�tition  :       
 *  <ul>
 *  <li>       lettres, chiffres, point, trait d'union et soulign� sont les seuls caract�res autoris�s </li>
 *  <li>      elle  doit avoir une longueur d'au moins 4 caract�res</li>
 * </ul></li>       
 * <li>pour la validit� d'un comp�titeur  :       
 *  <ul>
 *  <li>       lettres, chiffres, trait d'union et soulign� sont les seuls caract�res autoris�s </li>
 *  <li>      il doit avoir une longueur d'au moins 4 caract�res.</li>
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
    * @throws MetierException  lev�e 
    * si le <code>passwordGestionnaire</code>  est invalide 
    */
      public SiteDeParisMetier(String passwordGestionnaire) throws MetierException {
      
         this.passwordGestionnaire = passwordGestionnaire;
      
      // V�rifier la validit� du password du gestionnaire
         validitePasswordGestionnaire(passwordGestionnaire);
      
         this.competitions = new LinkedList<Competition>();
         this.competiteurs = new LinkedList<Competiteur>();
         this.joueurs = new LinkedList<Joueur>();
         this.paris = new LinkedList<Pari>();
      }
   
   
   
   
   
   // Les m�thodes du gestionnaire (avec mot de passe gestionnaire)
   
   
   
   /**
    * inscrire un joueur. 
    * 
    * @param nom   le nom du joueur 
    * @param prenom   le pr�nom du joueur   
    * @param pseudo   le pseudo du joueur  
    * @param passwordGestionnaire  le password du gestionnaire du site  
    * 
    * @throws MetierException   lev�e  
    * si le <code>passwordGestionnaire</code> propos� est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect.
    * @throws JoueurExistantException   lev�e si un joueur existe avec les m�mes noms et pr�noms ou le m�me pseudo.
    * @throws JoueurException lev�e si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
    * 
    * @return le mot de passe (d�termin� par le site) du nouveau joueur inscrit.
    */
      public String inscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurExistantException, JoueurException {
         
         //v�rifier la validit� du password du gestionnaire
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
    * @param prenom   le pr�nom du joueur   
    * @param pseudo   le pseudo du joueur  
    * @param passwordGestionnaire  le password du gestionnaire du site  
    * 
    * @throws MetierException
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect.
    * @throws JoueurInexistantException   lev�e si il n'y a pas de joueur  avec le m�me <code>nom</code>, <code>prenom</code>  et <code>pseudo</code>.
    * @throws JoueurException lev�e 
    * si le joueur a des paris en cours,
    * si <code>nom</code>, <code>prenom</code>, <code>pseudo</code> sont invalides.
    * 
    * @return le nombre de jetons � rembourser  au joueur qui vient d'�tre d�sinscrit.
    * 
    */
      public long desinscrireJoueur(String nom, String prenom, String pseudo, String passwordGestionnaire) throws MetierException, JoueurInexistantException, JoueurException {
   		
			//v�rifier la validit� du password du gestionnaire
         validitePasswordGestionnaire(passwordGestionnaire);
         
   		//v�rifier que le nom, le pr�nom et le pseudo du joueur
         verifierJoueur(nom , prenom , pseudo);      
			
			//v�rifier que il existe un joueur avec les m�mes noms et pr�noms ou le m�me pseudo
         Joueur j = verifierJoueurExistant(nom , prenom , pseudo);
         
			//v�rifier que le joueur n'a pas des paris en cours
			verifierJoueurPasEnCours(j);
			
			//
			long nombreEnJetons = j.getSolde();
						
			//Enl�ver l'objet Joueur dans la liste des joueurs
			this.joueurs.remove(j);
			
			return nombreEnJetons;
      }
   
      
   
   /**
    * ajouter une comp�tition.  
    * 
    * @param competition le nom de la comp�tition
    * @param dateCloture   la date � partir de laquelle il ne sera plus possible de miser  
    * @param competiteurs   les noms des diff�rents comp�titeurs de la comp�tition 
    * @param passwordGestionnaire  le password du gestionnaire du site 
    * 
    * @throws MetierException lev�e si le tableau des
    * comp�titeurs n'est pas instanci�, si le
    * <code>passwordGestionnaire</code> est invalide, si le
    * <code>passwordGestionnaire</code> est incorrect.
    * @throws CompetitionExistanteException lev�e si une comp�tition existe avec le m�me nom. 
    * @throws CompetitionException lev�e si le nom de la
    * comp�tition ou des comp�titeurs sont invalides, si il y a
    * moins de 2 comp�titeurs, si deux comp�titeurs ont le m�me
    * nom, si la date de cl�ture n'est pas instanci�e ou est
    * d�pass�e.
    */
      public void ajouterCompetition(String competition, DateFrancaise dateCloture, String [] competiteurs, String passwordGestionnaire) throws MetierException, 		CompetitionExistanteException, CompetitionException  {
      
      // v�rification (passwordGestionnaire, nom de la comp�tition, comp�titeurs, date
		
         validitePasswordGestionnaire(passwordGestionnaire);
      
         verifierCompetition(competition);
      
         verifierCompetiteurs(competiteurs);
      
         verifierDate(dateCloture);
      
         verifierCompetitionInexistante(competition);
      
      
      // Cr�er un nouvel objet comp�tition avec le nom fourni et les objets des comp�titeurs
         Competition ci = new Competition(competition , dateCloture);
      	
      	ci.ajouterCompetiteur(competiteurs);     
			 
		// Ajouter cette comp�tition � la liste des comp�titions dans le SiteDeParisMetier
         this.competitions.add(ci);
      
			LinkedList <Competiteur> ce = ci.getCompetiteurs();
			
		/* Ajouter les comp�titeurs de la comp�tition � la liste des comp�titeurs dans le SiteDeParisMetier
       * D'abord, on v�rifie que le comp�titeur n'est pas dans la liste de SiteDeParisMetier avant de l'ajouter
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
    * solder une comp�tition vainqueur (comp�tition avec vainqueur).  
    * 
    * Chaque joueur ayant mis� sur cette comp�tition
    * en choisissant ce comp�titeur est cr�dit� d'un nombre de
    * jetons �gal � :
    * 
    * (le montant de sa mise * la somme des
    * jetons mis�s pour cette comp�tition) / la somme des jetons
    * mis�s sur ce comp�titeur.
    *
    * Si aucun joueur n'a trouv� le
    * bon comp�titeur, des jetons sont cr�dit�s aux joueurs ayant
    * mis� sur cette comp�tition (conform�ment au montant de
    * leurs mises). La comp�tition est "supprim�e" si il ne reste
    * plus de mises suite � ce solde.
    * 
    * @param competition   le nom de la comp�tition  
    * @param vainqueur   le nom du vainqueur de la comp�tition 
    * @param passwordGestionnaire  le password du gestionnaire du site 
    * 
    * @throws MetierException   lev�e 
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect.
    * @throws CompetitionInexistanteException   lev�e si il n'existe pas de comp�tition de m�me nom.
    * @throws CompetitionException lev�e 
    * si le nom de la comp�tition ou du vainqueur est invalide, 
    * si il n'existe pas de comp�titeur du nom du vainqueur dans la comp�tition,
    * si la date de cl�ture de la comp�tition est dans le futur.
    * 
    */	
      public void solderVainqueur(String competition, String vainqueur, String passwordGestionnaire) throws MetierException,  CompetitionInexistanteException, CompetitionException  {
      
         // v�rifier la validit� du password du gestionnaire
         validitePasswordGestionnaire(passwordGestionnaire);
      
         // v�rifier que la comp�tition existe d�ja.
         Competition c = verifierCompetitionExistante(competition);
						
         // V�rifier que la date de cl�ture n'est pas dans le futur
         verifierDateEstPasse(c.getDate());
                  
         // V�rifier que le nom du vainqueur envisage est valide et existe dans la comp�tition
         verifierCompetiteur(vainqueur , c);
   		
   		c.solderUneCompetition(vainqueur);
                        
         // On enl�ve cette comp�tition de la liste des comp�titions dans la class SiteDeParisMetier
   		this.competitions.remove(c);
     }
   
   
   
   /**
    * cr�diter le compte en jetons d'un joueur du site de paris.
    * 
    * @param nom   le nom du joueur 
    * @param prenom   le pr�nom du joueur   
    * @param pseudo   le pseudo du joueur  
    * @param sommeEnJetons   la somme en jetons � cr�diter  
    * @param passwordGestionnaire  le password du gestionnaire du site  
    * 
    * @throws MetierException   lev�e 
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect,
    * si la somme en jetons est n�gative.
    * @throws JoueurException lev�e  
    * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides.
    * @throws JoueurInexistantException   lev�e si il n'y a pas de joueur  avec les m�mes nom,  pr�nom et pseudo.
    */
      public void crediterJoueur(String nom, String prenom, String pseudo, long sommeEnJetons, String passwordGestionnaire) throws MetierException, JoueurException, JoueurInexistantException {
      
			validitePasswordGestionnaire(passwordGestionnaire);
			
			verifierSommeEnJetonsPositive(sommeEnJetons);
			
			verifierJoueur(nom, prenom, pseudo);
			
			Joueur j = verifierJoueurExistant(nom, prenom, pseudo);
			
			j.crediterUnJoueur(sommeEnJetons);
		
      }
   
   
   /**
    * d�biter le compte en jetons d'un joueur du site de paris.
    * 
    * @param nom   le nom du joueur 
    * @param prenom   le pr�nom du joueur   
    * @param pseudo   le pseudo du joueur  
    * @param sommeEnJetons   la somme en jetons � d�biter  
    * @param passwordGestionnaire  le password du gestionnaire du site  
    * 
    * @throws MetierException   lev�e 
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect,
    * si la somme en jetons est n�gative.
    * @throws JoueurException lev�e  
    * si <code>nom</code>, <code>prenom</code>,  <code>pseudo</code> sont invalides 
    * si le compte en jetons du joueur est insuffisant (il deviendrait n�gatif).
    * @throws JoueurInexistantException   lev�e si il n'y a pas de joueur  avec les m�mes nom,  pr�nom et pseudo.
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
   
    * @throws MetierException   lev�e  
    * si le <code>passwordGestionnaire</code>  est invalide,
    * si le <code>passwordGestionnaire</code> est incorrect.
    * 
    * @return une liste de liste dont les �l�ments (de type <code>String</code>) repr�sentent un joueur avec dans l'ordre : 
    *  <ul>
    *  <li>       le nom du joueur  </li>
    *  <li>       le pr�nom du joueur </li>
    *  <li>       le pseudo du joueur  </li>
    *  <li>       son compte en jetons restant disponibles </li>
    *  <li>       le total de jetons engag�s dans ses mises en cours. </li>
    *  </ul>
    */
      public LinkedList <LinkedList <String>> consulterJoueurs(String passwordGestionnaire) throws MetierException {
 			
			// V�rifier la validit� du password du gestionnaire
			validitePasswordGestionnaire(passwordGestionnaire);  
			
			// Ajouter la liste de chaque joueur dans la liste de liste dont �l�ments repr�sentent un joueur
	      LinkedList <LinkedList <String>> listeJoueurs = new LinkedList <LinkedList <String>>();
			
         for (Joueur j:this.joueurs){
				listeJoueurs.add(j.toList());
			}
			
			return listeJoueurs;
      }
   
   
   
   
   
   
   
   
   // Les m�thodes avec mot de passe utilisateur
   
   
   
   /**
    * miserVainqueur  (parier sur une comp�tition, en d�signant un vainqueur).
    * Le compte du joueur est d�bit� du nombre de jetons mis�s.
    * 
    * @param pseudo   le pseudo du joueur  
    * @param passwordJoueur  le password du joueur  
    * @param miseEnJetons   la somme en jetons � miser  
    * @param competition   le nom de la comp�tition  relative au pari effectu�
    * @param vainqueurEnvisage   le nom du comp�titeur  sur lequel le joueur mise comme �tant le  vainqueur de la comp�tition  
    * 
    * @throws MetierException lev�e si la somme en jetons est n�gative.
    * @throws JoueurInexistantException lev�e si il n'y a pas de
    * joueur avec les m�mes pseudos et password.
    * @throws CompetitionInexistanteException   lev�e si il n'existe pas de comp�tition de m�me nom. 
    * @throws CompetitionException lev�e 
    * si <code>competition</code> ou <code>vainqueurEnvisage</code> sont invalides,
    * si il n'existe pas un comp�titeur de  nom <code>vainqueurEnvisage</code> dans la comp�tition,
    * si la comp�tition n'est plus ouverte (la date de cl�ture est dans le pass�).
    * @throws JoueurException   lev�e 
    * si <code>pseudo</code> ou <code>password</code> sont invalides, 
    * si le <code>compteEnJetons</code> du joueur est insuffisant (il deviendrait n�gatif).
    */
      public void miserVainqueur(String pseudo, String passwordJoueur, long miseEnJetons, String competition, String vainqueurEnvisage) throws MetierException, JoueurInexistantException, CompetitionInexistanteException, CompetitionException, JoueurException  {
      
         	// v�rifier la validit� du password associ� � le pseudo du joueur.
            validitePasswordJoueur(pseudo , passwordJoueur);
         
         	// v�rifier que le nom de la comp�tition est valide
            verifierCompetition(competition);
         
         	// v�rifier que la comp�tition existe d�ja
            Competition c = verifierCompetitionExistante(competition);
         
         	// V�rifier que la date de cl�ture est instanci�e et n'est pas d�pass�
            verifierDate(c.getDate());
               
         	// V�rifier que le comp�titeur de nom vainqueurEnvisage est valide et existe dans la comp�tition
            verifierCompetiteur(vainqueurEnvisage , c);
      
            Joueur j0 = null;
         
            for (Joueur j:this.joueurs) 
               if (j.getPseudo().equals(pseudo))   j0 = j;
         
         	// V�rifier que la somme en jetons n'est pas n�gative
            verifierSommeEnJetonsPositive(miseEnJetons);
				
         	// V�rifier que le compte du joueur est suffisant 
            verifierCompteSuffisant(j0, miseEnJetons);
            
            Pari p = j0.miserVainqueur(c, vainqueurEnvisage, miseEnJetons);
            
				// Ajouter le nouveau objet Pari � la liste des paris de la comp�tition
            c.addPari(p);
				               
	         // Ajouter le nouveau objet Pari � la liste des paris en cours dans le SiteDeParisMetier
            this.paris.add(p);
         
      }
   
   
    
   
   // Les m�thodes sans mot de passe
   
   
   /**
    * conna�tre les comp�titions en cours.
    * 
    * @return une liste de liste dont les �l�ments (de type <code>String</code>) repr�sentent une comp�tition avec dans l'ordre : 
    *  <ul>
    *  <li>       le nom de la comp�tition,  </li>
    *  <li>       la date de cl�ture de la comp�tition. </li>
    *  </ul>
    */
	 
	 
      public LinkedList <LinkedList <String>> consulterCompetitions(){
         
			// Ajouter la liste de chaque comp�tition dans la liste de liste dont �l�ments repr�sentent une comp�tition
	      LinkedList <LinkedList <String>> listeCompetitions = new LinkedList <LinkedList <String>>();
			
         for (Competition ci:this.competitions){
				listeCompetitions.add(ci.toList());
			}
			
			return listeCompetitions;
      } 
		
		
		
   
   /**
    * conna�tre  la liste des noms des comp�titeurs d'une comp�tition.  
    * 
    * @param competition   le nom de la comp�tition  
    * 
    * @throws CompetitionException   lev�e  
    * si le nom de la comp�tition est invalide.
    * @throws CompetitionInexistanteException   lev�e si il n'existe pas de comp�tition de m�me nom. 
    * 
    * @return la liste des comp�titeurs de la  comp�tition.
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
    * v�rifier la validit� du password du gestionnaire.
    * 
    * @param passwordGestionnaire   le password du gestionnaire � v�rifier
    * 
    * @throws MetierException   lev�e 
    * si le <code>passwordGestionnaire</code> est invalide,  
    * si le <code>passwordGestionnaire</code> � v�rifier n'est pas correct.
    */
      protected void validitePasswordGestionnaire(String passwordGestionnaire) throws MetierException {
      
      	if (!verifierString(passwordGestionnaire , 8 , true , new char [] {})) throw new MetierException();
						
			if (!passwordGestionnaire.equals(this.passwordGestionnaire)) throw new MetierException();
      }
		
		
   
   /**
    * v�rifier la validit� du password associ� � son pseudo.
    * 
    * @param pseudo   le pseudo du joueur
    * @param passwordJoueur   le password du joueur � v�rifier
    * 
    * @throws JoueurException   lev�e  si le <code>pseudo</code> ou le <code>passwordJoueur</code> sont invalides. 
    * @throws JoueurInexistantException   lev�e  si le <code>passwordJoueur</code> et le <code>pseudo</code> ne correspondent pas.
    */
      protected void validitePasswordJoueur(String pseudo, String passwordJoueur) throws JoueurException, JoueurInexistantException {
      
      // v�rifier le pseudo du joueur est valide
      	if (!verifierString(pseudo , 4 , true , new char [] {})) throw new JoueurException();
               
      // v�rifier le password du joueur est valide
      	if (!verifierString(passwordJoueur , 8 , true , new char [] {})) throw new JoueurException();
      
		// v�rifier qu'il y a un joueur avec ce pseudo
			boolean trouve = false;
         Joueur j0 = null;
         
			for (Joueur j:this.joueurs){
            if (pseudo.equals(j.getPseudo())){
					trouve = true;
               j0 = j;
            }
         }
			if (!trouve) throw new JoueurInexistantException();
		
		// v�rifier que le pseudo et le passwordJoueur correspondent
         if (!passwordJoueur.equals(j0.getPassword())) throw new JoueurInexistantException();
                           
      }  
   
	
	
   /**
    * v�rifier que le nom du comp�titeur est valide et qu'il existe un comp�titeur de ce nom dans la comp�tition.
    * 
    * @param nomCompetiteur   le nom du comp�titeur
    * @param ci   				l'objet de la comp�tition
    * 
    * @throws CompetitionException lev�e si le nom du comp�titeur est invalide 
    * ou il n'existe pas de comp�titeur de ce nom dans la comp�tition. 
    */
      public void verifierCompetiteur(String nomCompetiteur, Competition ci) throws CompetitionException{
      
      // v�rifier la validit� du nom du comp�titeur
      	if (!verifierString(nomCompetiteur , 4 , true , new char [] {'-' , '_'})) throw new CompetitionException();
                   
      // v�rifier l'existence du comp�titeur dans la comp�tition
         boolean trouve = false;
         for (Competiteur ce : ci.getCompetiteurs()){
            if (nomCompetiteur.equals(ce.getNom()))	trouve = true;
         }
      
         if (!trouve) throw new CompetitionException();
      }
   	
		
		
   /**
    * v�rifier que la somme en jetons n'est pas n�gative
    * 
    * @param sommeEnJetons   la somme en jetons
    * 
    * @throws MetierException   lev�e 
    * si la somme en jetons est n�gative
    */
      public void verifierSommeEnJetonsPositive(long sommeEnJetons) throws MetierException{
         if (sommeEnJetons < 0) throw new MetierException();
      }
   		
			
						
   /**
    * v�rifier que le compte du joueur est suffisant pour miser sur une comp�tition
    * 
    * @param j   					l'objet Joueur
    * @param miseEnJetons   	la somme en jetons � miser
    * 
    * @throws JoueurException   lev�e 
    * si la somme en jetons est inf�rieur que la somme en jetons � mise
    */
      public void verifierCompteSuffisant(Joueur j , long miseEnJetons) throws JoueurException{
         long sommeEnJetons = j.getSolde();
			if (sommeEnJetons < miseEnJetons) throw new JoueurException(); 
      }
   
   /**
    * v�rifier que la comp�tition existe d�ja ou elle n'existe pas.
    * 
    * @param nomCompetition   le nom de la comp�tition
    * 
    * @return null
    * s'il n'existe pas de competition de m�me nom 
    * @return l'objet Competition
    * si la comp�tition de m�me nom existe
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
    * v�rifier que la comp�tition existe d�ja.
    * 
    * @param nomCompetition   le nom de la comp�tition
    * 
    * @throws CompetitionInexistanteException   lev�e 
    * s'il n'existe pas de competition de m�me nom 
    */
      public Competition verifierCompetitionExistante(String nomCompetition) throws CompetitionInexistanteException{
      
   		Competition c = verifierCompetitionExOuInex(nomCompetition);      
			if (c == null) throw new CompetitionInexistanteException();
			return c;
      }
   
	
	
   /**
    * v�rifier que la comp�tition n'existe pas.
    * 
    * @param nomCompetition   le nom de la comp�tition
    * 
    * @throws CompetitionExistanteException   lev�e 
    * si une comp�tition existe d�ja avec le m�me nom
    */
      public void verifierCompetitionInexistante(String nomCompetition) throws CompetitionExistanteException{
      
         Competition c = verifierCompetitionExOuInex(nomCompetition);      
			if (c != null) throw new CompetitionExistanteException();
      }
   
   
	
   /**
    * v�rifier que le nom de la comp�tition est valide.
    * 
    * @param nomCompetition   le nom de la comp�tition
    * 
    * @throws CompetitionException lev�e si le nom de la comp�tition est invalide 
    */
      public void verifierCompetition(String nomCompetition) throws CompetitionException{
      
      	if (!verifierString(nomCompetition , 4 , true , new char [] {'-' , '_' , '.'})) throw new CompetitionException();
      }
   
	
	
   /**
    * v�rifier qu'il y a au moins de 2 comp�titeurs 
    * et que la liste des noms des comp�titeurs est valide et que les comp�titeurs n'ont pas le m�me nom.
    * 
    * @param competiteurs   la liste des noms des comp�titeurs
    * 
    * @throws CompetitionException   lev�e 
    * si il y a moins de 2 comp�titeurs
    * si le nom d'un (ou plusieurs) des comp�titeurs est invalide
    * si les comp�titeurs ont le m�me nom
	 *
	 * @throws MetierException   lev�e
	 * si le tableau des nom des comp�titeurs est invalide (non instanci�)
    */
      public void verifierCompetiteurs(String [] competiteurs) throws CompetitionException, MetierException{
      
   		// verifier que le tableau des comp�titeurs est instanci�
			if (competiteurs == null) throw new MetierException();
			  		
			// v�rifier qu'il y a au moins de 2 comp�titeurs
			if (competiteurs.length < 2) throw new CompetitionException();
      
      	// v�rifier que tous des noms des comp�titeurs sont valides
      	for (int j=0 ; j < competiteurs.length ; j++){
      		if (!verifierString(competiteurs[j] , 4 , true , new char [] {'-' , '_'})) throw new CompetitionException();
      	}
               
         // v�rifier qu'ils n'ont pas le m�me nom
         for (int j=0 ; j < competiteurs.length ; j++){
            for (int i=0 ; i < competiteurs.length ; i++){
               if (i != j) {
                  if (competiteurs[i].equals(competiteurs[j])) throw new CompetitionException();
               }
            }
         }
      }
      
		
		
   /**
    * v�rifier qu'il n'y a d'autre joueur avec les m�mes nom et pr�nom ou le m�me pseudo.
    * 
    * @param nom     le nom du joueur
    * @param prenom  le pr�nom du joueur
    * @param pseudo  le pseudo du joueur
    * 
    * @throws JoueurExistanteException   lev�e 
    * si un joueur existe avec les m�mes nom et pr�nom ou le m�me pseudo
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
    * v�rifier qu'il existe un joueur avec les m�mes nom et pr�nom ou le m�me pseudo.
    * 
    * @param nom     le nom du joueur
    * @param prenom  le pr�nom du joueur
    * @param pseudo  le pseudo du joueur
    * 
    * @throws JoueurInexistanteException   lev�e 
    * si il n'y a pas de joueur avec les m�mes nom, pr�nom et pseudo
    * @return l'objet Joueur avec avec les m�mes nom, pr�nom et pseudo.
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
    * v�rifier que le nom, le pr�nom et le pseudo du joueur sont valides.
    * 
    * @param nom     le nom du joueur
    * @param prenom  le pr�nom du joueur
    * @param pseudo  le pseudo du joueur   
    * 
    * @throws JoueurException lev�e si le nom, le pr�nom ou le pseudo du joueur sont invalides. 
    */
      public void verifierJoueur(String nom, String prenom, String pseudo) throws JoueurException{
      
      	if (!verifierString(nom , 1 , false , new char [] {'-'})) throw new JoueurException();
         
         if (!verifierString(prenom , 1 , false , new char [] {'-'})) throw new JoueurException();
         
         if (!verifierString(pseudo , 4 , true , new char [] {})) throw new JoueurException();
         
      }
		
		   
	

   
   /**
    * v�rifier que la date de cl�ture est correcte
    * 
    * @param date   la date de cl�ture
    * 
    * @throws CompetitionException   lev�e 
    * si la date est d�pass�e
    * si la date n'est pas instanci�e
    */
      public void verifierDate(DateFrancaise date) throws CompetitionException{
      // v�rifier que la date est instanci�e
         if (date == null) throw new CompetitionException();
      
      // v�rifier que la date n'est pas d�pass�e
         if (date.estDansLePasse()) throw new CompetitionException();
      }
   
	
	
   /**
    * v�rifier que la date de cl�ture est d�pass�
    * 
    * @param date   la date de cl�ture
    * 
    * @throws CompetitionException   lev�e 
    * si la date est dans le futur
    * si la date n'est pas instanci�e
    */
      public void verifierDateEstPasse(DateFrancaise date) throws CompetitionException{
      // v�rifier que la date est instanci�e
         if (date == null) throw new CompetitionException();
      
      // v�rifier que la date est d�pass�e    
         if (!date.estDansLePasse()) throw new CompetitionException();
      }
		
		
   
   /**
    * v�rifier qu'un param�tre de type <code>String</code> est valide, qu'il est instanci�,
    * qu'il a une longueur d'au moins la longueur minimale et qu'il a les caract�res corrects
    * 
    * @param str	   		le param�tre de type String, comme pseudo, password, nom, pr�nom, etc
    * @param minLongueur	la longueur minimale souhait�e du param�tre String
    * @param chiffre			le drapeau permet de connaitre si les chiffres sont des caract�res autoris�s ou non dans le param�tre String
    * @param caracteres		le tableau des caract�res (sauf les lettres et les chiffres) qui peuvent �tre autoris�s dans le param�tre String
    *
    * @returns true 
    * si le String str est instanci� et s'il est plus long que la longueur minimale 
    * et s'il a seulement les seuls caract�res permis
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
           
			   /* si k = caracteres.length, c'est-�-dire <code>c</code>est diff�rent de 
             * tous les caract�res fournis dans <code>caracteres</code> */
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
    * v�rifier que le joueur n'a pas des paris en cours.
    * 
    * @param nom     le nom du joueur
    * @param prenom  le pr�nom du joueur
    * @param pseudo  le pseudo du joueur   
    * 
    * @throws JoueurException lev�e si le joueur a des paris en cours. 
    */
      public void verifierJoueurPasEnCours(Joueur j) throws JoueurException{
   		if (j.getMise() > 0) throw new JoueurException();
      }
     
   }


