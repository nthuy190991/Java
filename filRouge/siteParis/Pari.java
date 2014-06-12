package siteParis;

import java.util.LinkedList;
public class Pari {

	/** 
	 * @uml.property name="parJoueur"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="faitParis:siteParis.Joueur"
	 */
	private Joueur parJoueur = null;
	/**
	 * @uml.property  name="appartientCompetition"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="aParis:siteParis.Competition"
	 */
	private Competition appartientCompetition = null;
	/**
	 * @uml.property  name="miseEnJetons"
	 */
	private long miseEnJetons;
	
	/**
	 * @uml.property  name="vainqueurEnvisage"
	 */
	private String vainqueurEnvisage;
						
						 
	/**
	 * constructeur de <code>Pari</code>. 
    * 
    * @param joueur   l'objet Joueur qui fait ce pari
	 * @param miseEnJetons	la somme en jetons ce que ce joueur veut miser
	 * @param competition 	l'objet Competition où ce joueur veut miser
	 * @param vainqueurEnvisage	le nom du compétiteur, sur qui le joueur veut miser
	 */
	 public Pari(Joueur joueur, long miseEnJetons, Competition competition, String vainqueurEnvisage) throws MetierException, CompetitionException, JoueurException {
		
		if (joueur == null) throw new JoueurException();
		
		if (competition == null) throw new CompetitionException();
		
		if (miseEnJetons < 0) throw new MetierException();
		
		if (vainqueurEnvisage == null) throw new CompetitionException();	
      if (vainqueurEnvisage.length() < 4) throw new CompetitionException();	
		for (int i=0 ; i < vainqueurEnvisage.length() ; i++){
			char c = vainqueurEnvisage.charAt(i);
			if (!Character.isLetterOrDigit(c) && c!='-' && c!='_') throw new CompetitionException();
		}
		
		this.parJoueur = joueur;
		this.miseEnJetons = miseEnJetons;
		this.appartientCompetition = competition;
		this.vainqueurEnvisage = vainqueurEnvisage;
	}

			
	/**
	 * permet d'avoir l'objet Competition de ce pari
	 */
	public Competition getCompetition(){
		return this.appartientCompetition;
	}
				
	/**
	 * Permet d'avoir le nom du compétiteur 
	 */
	public String getVainqueurEnvisage(){
		return this.vainqueurEnvisage;	
	}

	/**
	 * Permet d'avoir la somme en jetons misée
	 */
	public long getMiseEnJetons(){
		return this.miseEnJetons;
	}
				
	/**
	 * Permet d'avoir l'objet Joueur qui fait ce pari
	 */
	public Joueur getJoueur(){
		return this.parJoueur;
	}
	
   /**
    * Rend une chaîne de caractères représentant le pari.
    */
   public String toString(){
      String r = "\n [Joueur: " + this.getJoueur().getPseudo() + ", Mise en jetons: " + this.getMiseEnJetons() + ", Compétition: " + this.getCompetition().getNom() + ", Compétiteur: " + this.getVainqueurEnvisage() + "]";
     	return r;
   }
	
	public static void main(String [] args){
   
      // Test Constructor
      try {
         System.out.println("Test Constructor");
         DateFrancaise dateCloture = new DateFrancaise(4, 6, 2012, 15, 00);
         Competition c = new Competition("HorseRace", dateCloture);
         
			Joueur j = new Joueur("abfcd", "abcde" , "fafdgi"); 
			
			// créer un pari avec l'objet Joueur invalide
			try {
				Pari p = new Pari(null, 10, c, "Cheval-n1");
				System.out.println("créer un pari avec l'objet Joueur invalide (non instancié)  n'a pas levé l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("créer un pari avec l'objet Joueur invalide (non instancié)  n'a pas levé l'exception JoueurException mais " + e.getClass().getName());
			}
			
			// créer un pari avec si la somme en jetons est négative
			try {
				Pari p = new Pari(j, -10, c, "Cheval-n1");
				System.out.println("créer un pari avec si la somme en jetons est négative n'a pas levé l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("créer un pari avec si la somme en jetons est négative n'a pas levé l'exception MetierException mais " + e.getClass().getName());
			}
			
			// créer un pari avec l'objet Competition invalide
			try {
				Pari p = new Pari(j, 10, null, "Cheval-n1");
				System.out.println("créer un pari avec l'objet Competition invalide (non instancié)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un pari avec l'objet Competition invalide (non instancié)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}

			// créer un pari avec le nom du vainqueur invalide
			try {
				Pari p = new Pari(j, 10, c, null);
				System.out.println("créer un pari avec le nom du vainqueur invalide (non instancié)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un pari avec le nom du vainqueur invalide (non instancié)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Pari p = new Pari(j, 10, c, new String("Lyon Lyon"));
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (avec espace)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (avec espace)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Pari p = new Pari(j, 10, c, new String("Lyo"));
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (moins de 4 caractères)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (moins de 4 caractères)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Pari p = new Pari(j, 10, c, new String("Lyon*"));
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (caractère *)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (caractère *)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
         
         // créer un pari de manière correct
   		try {
				Pari p = new Pari(j, 10, c, new String("Lyon"));			
			}
			catch (Exception e) {
				System.out.println("\n créer un pari de maniere correcte a levé une exception ");
				e.printStackTrace();
			}     
			
   
         // Test toString()
			Pari p = new Pari(j, 10, c, new String("Lyon"));
         System.out.println("\nLes informations de ce pari : " + p.toString());
      }
      catch (Exception e) {
          System.out.println("\n Exception imprévue : " + e) ;
      }
   }
}
