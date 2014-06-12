package siteParis;

import java.util.LinkedList;
import java.util.Random;

public class Joueur {

	/** 
	 * @uml.property name="faitParis"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" inverse="parJoueur:siteParis.Pari"
	 */
	private LinkedList<Pari> faitParis;
	/** 
	 * @uml.property name="nom"
	 */
	private String nom;

	/**
	 * @uml.property  name="prenom"
	 */
	private String prenom;
	/**
	 * @uml.property  name="pseudo"
	 */
	private String pseudo;
	/**
	 * @uml.property  name="password"
	 */
	private String password;
	/**
	 * @uml.property  name="soldeEnJetons"
	 */
	private long soldeEnJetons;
	/**
	 * @uml.property  name="miseEnJetons"
	 */
	private long miseEnJetons;
		
	/**
	*/
	public Joueur(String nom, String prenom, String pseudo)	throws JoueurException 
   {

		// le nom de joueur
		if (!verifierString(nom , 1 , false , new char [] {'-'})) throw new JoueurException();
				
		// le prénom de joueur
		if (!verifierString(prenom , 1 , false , new char [] {'-'})) throw new JoueurException();		
		
		// le pseudo de joueur
		if (!verifierString(pseudo , 4 , true , new char [] {})) throw new JoueurException();

		this.nom=nom;
		this.prenom=prenom;
		this.pseudo=pseudo;
      this.password=creerPassword(pseudo);
		this.soldeEnJetons=0;
		this.miseEnJetons=0;
		this.faitParis = new LinkedList<Pari>();
		
		// vérifier le password du joueur
      if (!verifierString(password , 8 , true , new char [] {})) throw new JoueurException();
	}		
	
	/**
	 * Permet de savoir quel est le nombre de jetons total misé par le joueur.
	 */
	public long getMise(){
		return this.miseEnJetons;
	}

					
	/**
	 * Permet de savoir le solde du joueur.
	 */
	public long getSolde(){
		return this.soldeEnJetons;
	}

							
	/**
	 * Permet de connaitre le nom du joueur.
	 */
	public String getNom(){
		return this.nom;	
	}

								
	/**
	 * Permet de connaitre le prénom du joueur.
	 */
	public String getPrenom(){
	return this.prenom;	
	}


									
	/**
	 * Permet de connaitre le pseudo du joueur.
	 */
	public String getPseudo(){
	return this.pseudo;	
	}
	

	/**
	 * Permet du connaitre le mot de passe du joueur.
	 */
	public String getPassword(){
		return this.password;	
	}
																						
	/**
	 * Rend une chaîne de caractères representant le joueur.
	 */
	public LinkedList<String> toList(){
		LinkedList<String> r = new LinkedList<String>();
		r.add(" Nom: " + this.nom);
		r.add(" Prénom: " + this.prenom);
		r.add(" Pseudo: " + this.pseudo); 
		r.add(" Disponible: " + this.soldeEnJetons);
		r.add(" En cours: " + this.miseEnJetons);
		return r;
	}


													
	/**
	 * Rend une liste des paris fait par ce joueur
	 */
	public LinkedList<Pari> getPariMise(){
		return this.faitParis;
	}

	/**
	 * Ajouter un objet Pari à la liste des paris fait par ce Joueur
	 */
	public void addPari(Pari p){
		this.faitParis.add(p);
	}


	/**
	 * Solder pour ce Joueur avec l'indice du gain
	 *
	 * @param gain		l'indice du gain de ce pari (= la somme des jetons misés pour cette compétition/la somme des jetons misés sur le vainqueur
	 * @param mise 	la somme des jetons ce que ce joueur mise sur le vainqueur
	 */
	public void solderVainqueur(float gain , long mise){
		
      // Si gain != 0, c'est-à-dire, il y a au moins 1 joueur qui mise sur le vainqueur
		if (gain !=0)	this.soldeEnJetons = this.soldeEnJetons + (long)(gain*mise);
		
      // Si gain = 0, c'est-à-dire aucun joueur n'a trouvé le bon compétiteur	
		else	this.soldeEnJetons = this.soldeEnJetons + mise;
		
		this.miseEnJetons = this.miseEnJetons - mise;
	}
	
   /**
	 * Diminuer le compte mise en jetons de ce Joueur car il ne mise pas sur le vainqueur
	 *
	 * @param mise 	la somme des jetons ce que ce joueur mise sur le compétiteur
	 */
	public void diminuerMiseEnJetons(long mise){
		
  		this.miseEnJetons = this.miseEnJetons - mise;
	}

   
   /**
	 * Miser sur un vainqueur
	 *
	 * @param mise 	la somme des jetons a miser sur le vainqueur
	 */
	public Pari miserVainqueur(Competition c, String vainqueurEnvisage, long mise) throws MetierException, CompetitionException, JoueurException {
      this.soldeEnJetons = this.soldeEnJetons - mise;
      this.miseEnJetons = this.miseEnJetons + mise;
		
		Pari p = new Pari(this , mise , c , vainqueurEnvisage);
		
		this.addPari(p);
		return p;
   }
   
	/**
    * vérifier que un paramètre de type <code>String</code> est valide et qu'il est instancié
    * et qu'il a une longueur d'au moins de la longueur minimale et qu'il a les caractères correctes
    * 
    * @param str	   		le paramètre de type String, comme pseudo, password, nom, prénom, etc
    * @param minLongueur	la longueur minimale souhaité de le paramètre String
    * @param chiffre			le chapeau permet de connaitre les chiffres sont les caractères autorisés dans le paramètre String ou pas
    * @param caracteres		le tableau des caractères (sauf les lettres et les chiffres) peuvent être autorisé dans le paramètre String
    *
    * @returns true 
    * si le String str est instancié et s'il a plus que la longueur minimale 
    * et s'il juste a les seuls caractères permets
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
           
		      /* si k = caracteres.length, c'est-à-dire <code>c</code>est différent avec 
             * toute caractères fournies dans <code>caracteres</code> */
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
	 * Créer le mot de passe du joueur 
	 *
	 * @param pseudo		Le pseudo du joueur
    *
    * Returns password = pseudo (au moins de 4 caractères) + un String d'un numéro aléatoire positif (au moins de 4 chiffres)
	 */
	public String creerPassword(String pseudo){
		String password;
      
      Random rand = new Random(); 
      int numero = rand.nextInt(1000000) + 1000; 
      password = pseudo + numero;
            
		// On vérifie le password du joueur est valide, sinon on crée le password encore une fois
      if (!verifierString(password , 8 , true , new char [] {})) creerPassword(pseudo);
		return password;
	}
	
   /**
	 * Créditer le joueur 
	 *
	 * @param sommeEnJetons		La somme en jetons pour créditer le joueur
    *
	 */
   public void crediterUnJoueur(long sommeEnJetons){
		this.soldeEnJetons = this.soldeEnJetons + sommeEnJetons;
	}
	
   /**
	 * Débiter le joueur 
	 *
	 * @param sommeEnJetons		La somme en jetons pour débiter le joueur
    *
	 */
	public void debiterUnJoueur(long sommeEnJetons){
		this.soldeEnJetons = this.soldeEnJetons - sommeEnJetons;
	}
	
   /**
	 * Main
	 */
   public static void main(String [] args){
      
      try{
         
         // Test Constructor
         System.out.println("Test Constructor");

         // Si le nom de joueur invalide
         try{
            Joueur j = new Joueur(null, "abcde" , "fafdgi");
            System.out.println("créer un joueur avec un nom invalide (non instancié) n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un nom invalide (non instancié) n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("", "abcde" , "fafdgi");
            System.out.println("créer un joueur avec un nom invalide (moins de 1 caractère) n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un nom invalide (moins de 1 caractère) n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("faf.gd", "abcde" , "fafdgi");
            System.out.println("créer un joueur avec un nom invalide (avec '.') n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un nom invalide (avec '.') n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}

         try{
            Joueur j = new Joueur("fafgd4", "abcde" , "fafdgi");
            System.out.println("créer un joueur avec un nom invalide (avec '4') n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un nom invalide (avec '4') n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}
         
         // Si le prénom de joueur invalide
         try{
            Joueur j = new Joueur("abcde", null , "fafdgi");
            System.out.println("créer un joueur avec un prénom invalide (non instancié) n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un prénom invalide (non instancié) n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("abcde", "", "fafdgi");
            System.out.println("créer un joueur avec un prénom invalide (moins de 1 caractère) n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un prénom invalide (moins de 1 caractère) n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("fafgd", "abc.de" , "fafdgi");
            System.out.println("créer un joueur avec un prénom invalide (avec '.') n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un prénom invalide (avec '.') n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}

         try{
            Joueur j = new Joueur("fafgd", "abcd4e" , "fafdgi");
            System.out.println("créer un joueur avec un prénom invalide (avec '4') n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un prénom invalide (avec '4') n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}

         // Si le pseudo de joueur invalide
         try{
            Joueur j = new Joueur("abcde", "fafdgi", null);
            System.out.println("créer un joueur avec un pseudo invalide (non instancié) n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un pseudo invalide (non instancié) n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("abcde", "fafdgi", "abc");
            System.out.println("créer un joueur avec un pseudo invalide (moins de 4 caractère) n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un pseudo invalide (moins de 4 caractère) n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("fafgd", "abcde" , "faf-dgi");
            System.out.println("créer un joueur avec un pseudo invalide (avec '-') n'a pas levé l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un joueur avec un pseudo invalide (avec '-') n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}

			// Créer un joueur de manière correcte
         try {
				 Joueur j = new Joueur("abfcd", "abcde" , "fafdgi");
			}
			catch (Exception e) {
				System.out.println("\n créer un joueur de manière correct a levé une exception ");
				e.printStackTrace();
			}
			
        	Joueur j = new Joueur("abfcd", "abcde" , "fafdgi");
         
         // Test creerPassword()
         System.out.println("\nTest creerPassword du Joueur " + j.toList());
         System.out.println("Password: " + j.getPassword());
			         
         // Test crediterUnJoueur() et debiterUnJoueur()
         System.out.println("\nTest crediterUnJoueur et debiterUnJoueur");
         j.crediterUnJoueur(30);
   		j.debiterUnJoueur(10);
         System.out.println("Son compte en jetons, après être crédité 30 et être débité 10: ");
         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
         
         // Créer une compétition que le joueur va miser
         DateFrancaise dateCloture = new DateFrancaise(4, 6, 2012, 15, 00);
         Competition c = new Competition("HorseRace", dateCloture);
          
         // Test miserVainqueur()    
         System.out.println("\nTest miserVainqueur: ");
         Pari p = j.miserVainqueur(c, "Cheval-n2", 10);
   		System.out.println("Son compte en jetons, après miser 10 sur le compétiteur 'Cheval-n2': ");
         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
     
	      // Test solderVainqueur() (cas le joueur gagne)
			try{
	         System.out.println("\nTest solderVainqueur: ");
	         j.solderVainqueur((float) 3/ (float) 2 , 10);
	         System.out.println("Son compte en jetons, après être soldé car le compétiteur 'Cheval-n2' est le vainqueur: ");
	         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
	  		}    
			catch (Exception e) {
				System.out.println("\n Exception imprévue : " + e);
			}
			
         // Test solderVainqueur() (cas le joueur ne gagne pas)
			try{
	         System.out.println("\nEnsuite, le joueur mise à une autre fois, 10 jetons sur 'Cheval-n1', mais ce n'est pas le vainqueur");
	         Pari p1 = j.miserVainqueur(c, "Cheval-n1", 10);
	         j.diminuerMiseEnJetons(10);
	         System.out.println("Son compte en jetons, après avoir perdu la compétition: ");
	         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
         }    
			catch (Exception e) {
				System.out.println("\n Exception imprévue : " + e);
			}
			
         // Test solderVainqueur() (cas personne ne gagne)
			try{
	         System.out.println("\nEnfin, le joueur mise à une autre fois, 10 jetons sur 'Cheval-n3'");
	         Pari p2 = j.miserVainqueur(c, "Cheval-n1", 10);
	         j.solderVainqueur(0, 10);
	         System.out.println("Mais personne ne mise sur le vainqueur, son compte en jetons: ");
	         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
         }    
			catch (Exception e) {
				System.out.println("\n Exception imprévue : " + e);
			}
      }
      catch (Exception e) {
         System.out.println("\n Exception imprévue : " + e) ;
      }
   }
	
	
}