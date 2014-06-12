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
				
		// le pr�nom de joueur
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
		
		// v�rifier le password du joueur
      if (!verifierString(password , 8 , true , new char [] {})) throw new JoueurException();
	}		
	
	/**
	 * Permet de savoir quel est le nombre de jetons total mis� par le joueur.
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
	 * Permet de connaitre le pr�nom du joueur.
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
	 * Rend une cha�ne de caract�res representant le joueur.
	 */
	public LinkedList<String> toList(){
		LinkedList<String> r = new LinkedList<String>();
		r.add(" Nom: " + this.nom);
		r.add(" Pr�nom: " + this.prenom);
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
	 * Ajouter un objet Pari � la liste des paris fait par ce Joueur
	 */
	public void addPari(Pari p){
		this.faitParis.add(p);
	}


	/**
	 * Solder pour ce Joueur avec l'indice du gain
	 *
	 * @param gain		l'indice du gain de ce pari (= la somme des jetons mis�s pour cette comp�tition/la somme des jetons mis�s sur le vainqueur
	 * @param mise 	la somme des jetons ce que ce joueur mise sur le vainqueur
	 */
	public void solderVainqueur(float gain , long mise){
		
      // Si gain != 0, c'est-�-dire, il y a au moins 1 joueur qui mise sur le vainqueur
		if (gain !=0)	this.soldeEnJetons = this.soldeEnJetons + (long)(gain*mise);
		
      // Si gain = 0, c'est-�-dire aucun joueur n'a trouv� le bon comp�titeur	
		else	this.soldeEnJetons = this.soldeEnJetons + mise;
		
		this.miseEnJetons = this.miseEnJetons - mise;
	}
	
   /**
	 * Diminuer le compte mise en jetons de ce Joueur car il ne mise pas sur le vainqueur
	 *
	 * @param mise 	la somme des jetons ce que ce joueur mise sur le comp�titeur
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
    * v�rifier que un param�tre de type <code>String</code> est valide et qu'il est instanci�
    * et qu'il a une longueur d'au moins de la longueur minimale et qu'il a les caract�res correctes
    * 
    * @param str	   		le param�tre de type String, comme pseudo, password, nom, pr�nom, etc
    * @param minLongueur	la longueur minimale souhait� de le param�tre String
    * @param chiffre			le chapeau permet de connaitre les chiffres sont les caract�res autoris�s dans le param�tre String ou pas
    * @param caracteres		le tableau des caract�res (sauf les lettres et les chiffres) peuvent �tre autoris� dans le param�tre String
    *
    * @returns true 
    * si le String str est instanci� et s'il a plus que la longueur minimale 
    * et s'il juste a les seuls caract�res permets
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
           
		      /* si k = caracteres.length, c'est-�-dire <code>c</code>est diff�rent avec 
             * toute caract�res fournies dans <code>caracteres</code> */
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
	 * Cr�er le mot de passe du joueur 
	 *
	 * @param pseudo		Le pseudo du joueur
    *
    * Returns password = pseudo (au moins de 4 caract�res) + un String d'un num�ro al�atoire positif (au moins de 4 chiffres)
	 */
	public String creerPassword(String pseudo){
		String password;
      
      Random rand = new Random(); 
      int numero = rand.nextInt(1000000) + 1000; 
      password = pseudo + numero;
            
		// On v�rifie le password du joueur est valide, sinon on cr�e le password encore une fois
      if (!verifierString(password , 8 , true , new char [] {})) creerPassword(pseudo);
		return password;
	}
	
   /**
	 * Cr�diter le joueur 
	 *
	 * @param sommeEnJetons		La somme en jetons pour cr�diter le joueur
    *
	 */
   public void crediterUnJoueur(long sommeEnJetons){
		this.soldeEnJetons = this.soldeEnJetons + sommeEnJetons;
	}
	
   /**
	 * D�biter le joueur 
	 *
	 * @param sommeEnJetons		La somme en jetons pour d�biter le joueur
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
            System.out.println("cr�er un joueur avec un nom invalide (non instanci�) n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un nom invalide (non instanci�) n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("", "abcde" , "fafdgi");
            System.out.println("cr�er un joueur avec un nom invalide (moins de 1 caract�re) n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un nom invalide (moins de 1 caract�re) n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("faf.gd", "abcde" , "fafdgi");
            System.out.println("cr�er un joueur avec un nom invalide (avec '.') n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un nom invalide (avec '.') n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

         try{
            Joueur j = new Joueur("fafgd4", "abcde" , "fafdgi");
            System.out.println("cr�er un joueur avec un nom invalide (avec '4') n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un nom invalide (avec '4') n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
         
         // Si le pr�nom de joueur invalide
         try{
            Joueur j = new Joueur("abcde", null , "fafdgi");
            System.out.println("cr�er un joueur avec un pr�nom invalide (non instanci�) n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un pr�nom invalide (non instanci�) n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("abcde", "", "fafdgi");
            System.out.println("cr�er un joueur avec un pr�nom invalide (moins de 1 caract�re) n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un pr�nom invalide (moins de 1 caract�re) n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("fafgd", "abc.de" , "fafdgi");
            System.out.println("cr�er un joueur avec un pr�nom invalide (avec '.') n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un pr�nom invalide (avec '.') n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

         try{
            Joueur j = new Joueur("fafgd", "abcd4e" , "fafdgi");
            System.out.println("cr�er un joueur avec un pr�nom invalide (avec '4') n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un pr�nom invalide (avec '4') n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

         // Si le pseudo de joueur invalide
         try{
            Joueur j = new Joueur("abcde", "fafdgi", null);
            System.out.println("cr�er un joueur avec un pseudo invalide (non instanci�) n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un pseudo invalide (non instanci�) n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("abcde", "fafdgi", "abc");
            System.out.println("cr�er un joueur avec un pseudo invalide (moins de 4 caract�re) n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un pseudo invalide (moins de 4 caract�re) n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
         
         try{
            Joueur j = new Joueur("fafgd", "abcde" , "faf-dgi");
            System.out.println("cr�er un joueur avec un pseudo invalide (avec '-') n'a pas lev� l'exception JoueurException ");
         }
        	catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un joueur avec un pseudo invalide (avec '-') n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			// Cr�er un joueur de mani�re correcte
         try {
				 Joueur j = new Joueur("abfcd", "abcde" , "fafdgi");
			}
			catch (Exception e) {
				System.out.println("\n cr�er un joueur de mani�re correct a lev� une exception ");
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
         System.out.println("Son compte en jetons, apr�s �tre cr�dit� 30 et �tre d�bit� 10: ");
         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
         
         // Cr�er une comp�tition que le joueur va miser
         DateFrancaise dateCloture = new DateFrancaise(4, 6, 2012, 15, 00);
         Competition c = new Competition("HorseRace", dateCloture);
          
         // Test miserVainqueur()    
         System.out.println("\nTest miserVainqueur: ");
         Pari p = j.miserVainqueur(c, "Cheval-n2", 10);
   		System.out.println("Son compte en jetons, apr�s miser 10 sur le comp�titeur 'Cheval-n2': ");
         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
     
	      // Test solderVainqueur() (cas le joueur gagne)
			try{
	         System.out.println("\nTest solderVainqueur: ");
	         j.solderVainqueur((float) 3/ (float) 2 , 10);
	         System.out.println("Son compte en jetons, apr�s �tre sold� car le comp�titeur 'Cheval-n2' est le vainqueur: ");
	         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
	  		}    
			catch (Exception e) {
				System.out.println("\n Exception impr�vue : " + e);
			}
			
         // Test solderVainqueur() (cas le joueur ne gagne pas)
			try{
	         System.out.println("\nEnsuite, le joueur mise � une autre fois, 10 jetons sur 'Cheval-n1', mais ce n'est pas le vainqueur");
	         Pari p1 = j.miserVainqueur(c, "Cheval-n1", 10);
	         j.diminuerMiseEnJetons(10);
	         System.out.println("Son compte en jetons, apr�s avoir perdu la comp�tition: ");
	         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
         }    
			catch (Exception e) {
				System.out.println("\n Exception impr�vue : " + e);
			}
			
         // Test solderVainqueur() (cas personne ne gagne)
			try{
	         System.out.println("\nEnfin, le joueur mise � une autre fois, 10 jetons sur 'Cheval-n3'");
	         Pari p2 = j.miserVainqueur(c, "Cheval-n1", 10);
	         j.solderVainqueur(0, 10);
	         System.out.println("Mais personne ne mise sur le vainqueur, son compte en jetons: ");
	         System.out.println("Solde: " + j.getSolde() + ", Mise: " + j.getMise());
         }    
			catch (Exception e) {
				System.out.println("\n Exception impr�vue : " + e);
			}
      }
      catch (Exception e) {
         System.out.println("\n Exception impr�vue : " + e) ;
      }
   }
	
	
}