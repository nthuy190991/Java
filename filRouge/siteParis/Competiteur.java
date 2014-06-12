package siteParis;

import java.util.LinkedList;


public class Competiteur {

	/** 
	 * @uml.property name="deCompetition"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="aCompetiteurs:siteParis.Competition"
	 */
	private siteParis.Competition deCompetition = null;
	/**
	 * @uml.property  name="nom"
	 */
	private String nom;
		
	/**
	 * constructeur de <code>Competiteur</code>. 
    * 	 
	 * @param nom				le nom du comp�titeur
 	 * @param competition 	l'objet Competition o� le comp�titeur participe
	 */
	public Competiteur(String nom, Competition competition) throws CompetitionException{
         
			// V�rifier la validit� du nom du comp�titeur
         if (nom == null) throw new CompetitionException();	
         
         if (nom.length() < 4) throw new CompetitionException();	

			for (int i=0 ; i < nom.length() ; i++){
				char c = nom.charAt(i);
				if (!Character.isLetterOrDigit(c) && c!='-' && c!='_' ) throw new CompetitionException();
			}

			// V�rifier la validit� de l'objet Competition
         if (competition == null) throw new CompetitionException();	      
		
      this.nom = nom;
		this.deCompetition = competition;
	}

			
	/**
	 * Permet d'avoir l'objet Competition
	 */
	public Competition getCompetition(){
		return this.deCompetition;
	}

	/**
	 * Permet d'avoir le nom du comp�titeur
	 */
	public java.lang.String getNom(){
		return this.nom;	
	}
	
	/**
	 * Rend une cha�ne de caract�res representant le comp�titeur.
	 */
	public String toString(){
		return this.nom;
	}
       
   public static void main(String [] args){
   
      // Test Constructor
      try {
         System.out.println("Test Constructor");
         DateFrancaise dateCloture = new DateFrancaise(4, 6, 2012, 15, 00);
         Competition c = new Competition("HorseRace", dateCloture);
            
         try {
				Competiteur ce = new Competiteur(null, c);
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (non instanci�)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (non instanci�)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Competiteur ce = new Competiteur(new String("Lyon Lyon"), c);
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (avec espace)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (avec espace)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Competiteur ce = new Competiteur(new String("Lyo"), c);
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Competiteur ce = new Competiteur(new String("Lyon*"), c);
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (caract�re *)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un comp�titeur avec un nom du comp�titeur invalide (caract�re *)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
         
         try {
				Competiteur ce = new Competiteur(new String("Lyon"), null);
				System.out.println("cr�er un comp�titeur avec la comp�tition invalide (non instanci�e)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("cr�er un comp�titeur avec la comp�tition invalide (non instanci�e)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
      
         System.out.println("");
         
         // cr�er un comp�titeur de mani�re correct
         try {
				Competiteur ce = new Competiteur(new String("Lyon"), c);
			}
			catch (Exception e) {
				System.out.println("\n cr�er un comp�titeur de mani�re correct a lev� une exception ");
				e.printStackTrace();
			} 
     
	      // Test toString() et getCompetition()
   		Competiteur ce = new Competiteur(new String("Lyon"), c);      
			System.out.println("Le comp�titeur : " + ce.toString() + " de la comp�tition: " + ce.getCompetition().toList());
      }
      catch (Exception e) {
          System.out.println("\n Exception impr�vue : " + e) ;
      }
   }
}
