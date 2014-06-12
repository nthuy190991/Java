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
	 * @param competition 	l'objet Competition o� ce joueur veut miser
	 * @param vainqueurEnvisage	le nom du comp�titeur, sur qui le joueur veut miser
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
	 * Permet d'avoir le nom du comp�titeur 
	 */
	public String getVainqueurEnvisage(){
		return this.vainqueurEnvisage;	
	}

	/**
	 * Permet d'avoir la somme en jetons mis�e
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
    * Rend une cha�ne de caract�res repr�sentant le pari.
    */
   public String toString(){
      String r = "\n [Joueur: " + this.getJoueur().getPseudo() + ", Mise en jetons: " + this.getMiseEnJetons() + ", Comp�tition: " + this.getCompetition().getNom() + ", Comp�titeur: " + this.getVainqueurEnvisage() + "]";
     	return r;
   }
	
	public static void main(String [] args){
   
      // Test Constructor
      try {
         System.out.println("Test Constructor");
         DateFrancaise dateCloture = new DateFrancaise(4, 6, 2012, 15, 00);
         Competition c = new Competition("HorseRace", dateCloture);
         
			Joueur j = new Joueur("abfcd", "abcde" , "fafdgi"); 
			
			// cr�er un pari avec l'objet Joueur invalide
			try {
				Pari p = new Pari(null, 10, c, "Cheval-n1");
				System.out.println("cr�er un pari avec l'objet Joueur invalide (non instanci�)  n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un pari avec l'objet Joueur invalide (non instanci�)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			// cr�er un pari avec si la somme en jetons est n�gative
			try {
				Pari p = new Pari(j, -10, c, "Cheval-n1");
				System.out.println("cr�er un pari avec si la somme en jetons est n�gative n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un pari avec si la somme en jetons est n�gative n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
			// cr�er un pari avec l'objet Competition invalide
			try {
				Pari p = new Pari(j, 10, null, "Cheval-n1");
				System.out.println("cr�er un pari avec l'objet Competition invalide (non instanci�)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un pari avec l'objet Competition invalide (non instanci�)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			// cr�er un pari avec le nom du vainqueur invalide
			try {
				Pari p = new Pari(j, 10, c, null);
				System.out.println("cr�er un pari avec le nom du vainqueur invalide (non instanci�)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un pari avec le nom du vainqueur invalide (non instanci�)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Pari p = new Pari(j, 10, c, new String("Lyon Lyon"));
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (avec espace)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (avec espace)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Pari p = new Pari(j, 10, c, new String("Lyo"));
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Pari p = new Pari(j, 10, c, new String("Lyon*"));
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (caract�re *)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (caract�re *)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
         
         // cr�er un pari de mani�re correct
   		try {
				Pari p = new Pari(j, 10, c, new String("Lyon"));			
			}
			catch (Exception e) {
				System.out.println("\n cr�er un pari de maniere correcte a lev� une exception ");
				e.printStackTrace();
			}     
			
   
         // Test toString()
			Pari p = new Pari(j, 10, c, new String("Lyon"));
         System.out.println("\nLes informations de ce pari : " + p.toString());
      }
      catch (Exception e) {
          System.out.println("\n Exception impr�vue : " + e) ;
      }
   }
}
