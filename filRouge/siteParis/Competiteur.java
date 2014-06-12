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
	 * @param nom				le nom du compétiteur
 	 * @param competition 	l'objet Competition où le compétiteur participe
	 */
	public Competiteur(String nom, Competition competition) throws CompetitionException{
         
			// Vérifier la validité du nom du compétiteur
         if (nom == null) throw new CompetitionException();	
         
         if (nom.length() < 4) throw new CompetitionException();	

			for (int i=0 ; i < nom.length() ; i++){
				char c = nom.charAt(i);
				if (!Character.isLetterOrDigit(c) && c!='-' && c!='_' ) throw new CompetitionException();
			}

			// Vérifier la validité de l'objet Competition
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
	 * Permet d'avoir le nom du compétiteur
	 */
	public java.lang.String getNom(){
		return this.nom;	
	}
	
	/**
	 * Rend une chaîne de caractères representant le compétiteur.
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
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (non instancié)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (non instancié)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Competiteur ce = new Competiteur(new String("Lyon Lyon"), c);
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (avec espace)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (avec espace)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Competiteur ce = new Competiteur(new String("Lyo"), c);
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (moins de 4 caractères)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (moins de 4 caractères)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				Competiteur ce = new Competiteur(new String("Lyon*"), c);
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (caractère *)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un compétiteur avec un nom du compétiteur invalide (caractère *)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
         
         try {
				Competiteur ce = new Competiteur(new String("Lyon"), null);
				System.out.println("créer un compétiteur avec la compétition invalide (non instanciée)  n'a pas levé l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("créer un compétiteur avec la compétition invalide (non instanciée)  n'a pas levé l'exception CompetitionException mais " + e.getClass().getName());
			}
      
         System.out.println("");
         
         // créer un compétiteur de manière correct
         try {
				Competiteur ce = new Competiteur(new String("Lyon"), c);
			}
			catch (Exception e) {
				System.out.println("\n créer un compétiteur de manière correct a levé une exception ");
				e.printStackTrace();
			} 
     
	      // Test toString() et getCompetition()
   		Competiteur ce = new Competiteur(new String("Lyon"), c);      
			System.out.println("Le compétiteur : " + ce.toString() + " de la compétition: " + ce.getCompetition().toList());
      }
      catch (Exception e) {
          System.out.println("\n Exception imprévue : " + e) ;
      }
   }
}
