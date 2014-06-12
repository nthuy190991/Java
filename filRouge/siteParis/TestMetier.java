package siteParis;

import java.util.LinkedList;


/**
 * 
 * @author prou
 *
 */
public class TestMetier {




	public static void testConstructeurSiteDeParisMetier () {

		System.out.println("\n testConstructeurSiteDeParisMetier");

		SiteDeParisMetier siteDeParisMetier = null;

		// construction incorrecte

		try {
			siteDeParisMetier = new SiteDeParisMetier(null);
			System.out.println("construire un site de paris avec un password gestionnaire invalide (non instanci�) n'a pas lev� l'exception MetierException");
		}
		catch (MetierException e) { }
		catch (Exception e) { 
			System.out.println("construire un site de paris avec un password gestionnaire invalide (non instanci�) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
		}


		try {
			siteDeParisMetier = new SiteDeParisMetier("ax2a3t");
			System.out.println("construire un site de paris avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas lev� l'exception MetierException ");
		}
		catch (MetierException e) { }
		catch (Exception e) { 
			System.out.println("construire un site de paris avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
		}

		try {
			siteDeParisMetier = new SiteDeParisMetier("qsdf452 3e");
			System.out.println("construire un site de paris avec un password gestionnaire invalide (un espace) n'a pas lev� l'exception MetierException ");
		}
		catch (MetierException e) { }
		catch (Exception e) { 
			System.out.println("construire un site de paris avec un password gestionnaire invalide (un espace) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
		}

		try {
			siteDeParisMetier = new SiteDeParisMetier("qsdf-523e");
			System.out.println("construire un site de paris avec un password gestionnaire invalide (un -) n'a pas lev� l'exception MetierException ");
		}
		catch (MetierException e) { }
		catch (Exception e) { 
			System.out.println("construire un site de paris avec un password gestionnaire invalide (un -) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
		}


		// construction correcte d'un site

		try {
			siteDeParisMetier = new SiteDeParisMetier("bmyjp2011");
		}
		catch (Exception e) {
			System.out.println("\n construire un site de paris avec un password gestionnaire valide a lev� une exception ");
			e.printStackTrace();
		}


	}		


	public static void testValiditePasswordGestionnaire () {

		System.out.println("\n testValiditePasswordGestionnaire");

		try {

			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			// demande de  validite avec password incorrect

			try {
				siteDeParisMetier.validitePasswordGestionnaire("ilesSousLeVent");
				System.out.println("validitePasswordGestionnaire avec un password gestionnaire incorrect n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordGestionnaire avec un password gestionnaire incorrect n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			// demande de  validite avec password invalide

			try {
				siteDeParisMetier.validitePasswordGestionnaire(null);
				System.out.println("validitePasswordGestionnaire avec un password gestionnaire invalide (non instanci�) n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordGestionnaire avec un password gestionnaire invalide (non instanci�)  n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.validitePasswordGestionnaire("ax2a3t");
				System.out.println("validitePasswordGestionnaire avec un password gestionnaire invalide (moins de 8 caracteres) n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordGestionnaire avec un password gestionnaire invalide (moins de 8 caracteres)  n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.validitePasswordGestionnaire("qsdf452 3e");
				System.out.println("validitePasswordGestionnaire avec un password gestionnaire invalide (un espace) n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordGestionnaire avec validitePasswordGestionnaire avec un password gestionnaire invalide (un espace)  n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.validitePasswordGestionnaire("qsdf-523e");
				System.out.println("validitePasswordGestionnaire avec un password gestionnaire invalide (un -) n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordGestionnaire avec validitePasswordGestionnaire avec un password gestionnaire invalide (un -)  n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}


		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}


	}		



	public static void testInscrireDesinscrireJoueur () {

		System.out.println("\n testInscrireDesinscrireJoueur");

		try {

			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			// inscription correcte de joueurs 

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), new String("ilesCaimans"));			
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), new String("ilesCaimans"));			
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), new String("ilesCaimans"));


			// inscription incorrecte de joueurs 

			try {
				siteDeParisMetier.inscrireJoueur("Maradona", null, "world1Champ", new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un prenom invalide (non instanci�) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un prenom invalide (non instanci�)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(null, "Diego", "world2Champ", new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un nom invalide (non instanci�) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un nom invalide (non instanci�)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Maradonaa", "Diegoa", null, new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un pseudo invalide (non instanci�) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un pseudo invalide (non instanci�)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Maradonab", "Diegob", "world3Champ", null);
				System.out.println("inscrire un joueur avec un password gestionnaire  invalide (non instanci�) n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un password gestionnaire  invalide (non instanci�) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Duran"), new String(" "), "world4Champ", new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un pr�nom invalide (un seul caract�re : espace) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un pr�nom invalide (un seul caract�re : espace)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Dur an", "Carlos", "world5Champ", new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un nom invalide (Dur an) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un nom invalide (Dur an)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("D'Espagne", "Philippe", "leRoi", new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un nom invalide (un caract�re ') n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un nom invalide (un caract�re ')  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Nobel"), new String("Alfred"), new String("tnt"), new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un pseudo invalide (moins de 4 caract�res) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un pseudo invalide (moins de 4 caract�res)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Nobela", "Alfreda", "tnt.43", new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un pseudo invalide (un caract�re .) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un pseudo invalide (un caract�re .)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Durana", "Robertoa", "worldChampa", "abef");
				System.out.println("inscrire un joueur avec un password gestionnaire  invalide (moins de 8 caract�res) n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un password gestionnaire  invalide (moins de 8 caract�res) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur("Duranb", "Robertob", "worldChampb", "onSaitJamais");
				System.out.println("inscrire un joueur avec un password gestionnaire  incorrect n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un password gestionnaire  incorrect n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), new String("ilesCaimans"));
				System.out.println("inscrire un joueur existant n'a pas lev� l'exception JoueurExistantException");
			}
			catch (JoueurExistantException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur existant  n'a pas lev� l'exception JoueurExistantException mais " + e.getClass().getName());
			}


			try {
				siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), "titi", new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec m�me nom et pr�nom n'a pas lev� l'exception JoueurExistantException");
			}
			catch (JoueurExistantException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec m�me nom et pr�nom   n'a pas lev� l'exception JoueurExistantException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.inscrireJoueur(new String("Martin"), new String("Pierre"), new String("momo"), new String("ilesCaimans"));
				System.out.println("inscrire un joueur avec un pseudo existant n'a pas lev� l'exception JoueurExistantException");
			}
			catch (JoueurExistantException e) { }
			catch (Exception e) { 
				System.out.println("inscrire un joueur avec un pseudo existant  n'a pas lev� l'exception JoueurExistantException mais " + e.getClass().getName());
			}




			// d�sinscription incorrecte de joueurs 

			try {
				siteDeParisMetier.desinscrireJoueur(new String("lolita"), new String("avfrqwxx"), new String("tryui"), new String("ilesCaimans"));
				System.out.println("d�sinscrire un joueur inexistant n'a pas lev� l'exception JoueurInexistantException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("d�sinscrire un joueur inexistant n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.desinscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), "ilesVierges");
				System.out.println("d�sinscrire un joueur avec un  password gestionnaire incorrect n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("d�sinscrire un joueur avec un  password gestionnaire incorrect n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}


			// d�sinscription correcte d'un joueur 
			siteDeParisMetier.desinscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));

			// d�sinscription incorrecte d'un joueur d�ja d�sinscrit
			
			try {
				siteDeParisMetier.desinscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));
				System.out.println("d�sinscrire un joueur d�j� retir� n'a pas lev� l'exception JoueurInexistantException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("d�sinscrire un joueur d�j� retir� n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}

		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}


	}		



	public static void testValiditePasswordJoueur () {

		System.out.println("\n testValiditePasswordJoueur");

		try {

			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			// inscription correcte de joueurs 

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), new String("ilesCaimans"));			
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), new String("ilesCaimans"));			
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), new String("ilesCaimans"));


			// demande de  validite avec joueur inexistant

			try {
				siteDeParisMetier.validitePasswordJoueur("pipot", "pourquoiPas");
				System.out.println("validitePasswordJoueur avec un joueur inexistant (pipot) n'a pas lev� l'exception JoueurInexistantException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordJoueur avec un joueur inexistant (pipot)  n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}

			// demande de  validite avec password invalide

			try {
				siteDeParisMetier.validitePasswordJoueur(null, "unPassword");
				System.out.println("validitePasswordJoueur avec un pseudo invalide (non instanci�) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordJoueur avec un pseudo invalide (non instanci�) n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.validitePasswordJoueur(new String("aure"), null);
				System.out.println("validitePasswordJoueur avec un password  invalide (non instanci�) d'un joueur existant (aure) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordJoueur avec un password invalide (non instanci�) n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}


			try {
				siteDeParisMetier.validitePasswordJoueur(new String("momo"), "az32");
				System.out.println("validitePasswordJoueur avec un password  invalide (moins de 8 caract�res) d'un joueur existant (momo) n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordJoueur avec un password invalide (moins de 8 caract�res) d'un joueur existant (momo)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			// demande de  validite avec password incorrect

			try {
				siteDeParisMetier.validitePasswordJoueur(new String("aure"), "revolution");
				System.out.println("validitePasswordJoueur avec un password  incorrect d'un joueur existant (aure) n'a pas lev� l'exception JoueurInexistantException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("validitePasswordJoueur avec un password incorrect d'un joueur existant (aure)  n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}

			// demande de  validite avec joueur existant et password correct

			try {
				siteDeParisMetier.validitePasswordJoueur(new String("nanard"), new String(passwdBernard));
				siteDeParisMetier.validitePasswordJoueur(new String("zinzin"), new String(passwdSylvain));
			}
			catch (Exception e) { 
				System.out.println("validitePasswordJoueur sur des joueurs existants a  lev� l'exception  " + e.getClass().getName());
			}



		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}


	}		


	public static void testAjouterCompetition () {

		System.out.println("\n testAjouterCompetition");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);


			// ajout incorrect de comp�tition 

			try {
				siteDeParisMetier.ajouterCompetition(new String("finaleRG2055"), new DateFrancaise(4, 8, 2055), new String [] {"Clijsters", "Navratilova"}, null);
				System.out.println("l'ajout d'une comp�tition avec un password gestionnaire invalide (non instanci�)  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un password gestionnaire invalide (non instanci�) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2065", new DateFrancaise(4, 8, 2055), new String [] {"Clijsters", "Navratilova"}, "12aze");
				System.out.println("l'ajout d'une comp�tition avec un password gestionnaire invalide (moins de 8 caract�res)  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un password gestionnaire invalide (moins de 8 caract�res) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2075", new DateFrancaise(4, 8, 2055), new String [] {"Clijsters", "Navratilova"}, "ilesXCaimans");
				System.out.println("l'ajout d'une comp�tition avec un password gestionnaire incorrect  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un password gestionnaire incorrect n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition(null, new DateFrancaise(4, 8, 2011), new String [] {"Clijsters", "Zvonareva"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un nom invalide (non instanci�) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom invalide (non instanci�)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("Championnat DeFrance2014", new DateFrancaise(27, 6, 2013, 20, 00), new String [] {new String("Lyon"), new String("Nantes"), new String("Lens"), new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", }, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un nom invalide (avec espace) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom invalide (avec espace)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finale|RG2012", new DateFrancaise(4, 8, 2011), new String [] {"Clijsters", "Zvonareva"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un nom invalide (caractere |) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom invalide (caractere |)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("RGA", new DateFrancaise(4, 8, 2011), new String [] {"Clijsters", "Zvonareva"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un nom invalide (moins de 4 caract�res) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2032", null, new String [] {"Clijsters", "Zvonareva"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec une date invalide (non instanci�e) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec une date invalide (non instanci�e) n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2044", new DateFrancaise(4, 8, 20441), null, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un tableau de comp�titeurs invalide (non instanci�) n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un tableau de comp�titeurs invalide (non instanci�)  n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}


			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2044", new DateFrancaise(4, 8, 20441), new String [] {"Clijsters"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un seul comp�titeur    n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un seul comp�titeur   n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}


			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2044", new DateFrancaise(4, 8, 20441), new String [] {"Clijsters", null}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur invalide (non instanci�) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur invalide (non instanci�)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2014", new DateFrancaise(4, 8, 2011), new String [] {"Clij sters", "Zvonareva"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur invalide (avec espace) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur invalide (avec espace)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2015", new DateFrancaise(4, 8, 2011), new String [] {"Clijters", "Zvo"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur invalide (moins de 4 caracteres) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur invalide (moins de 4 caracteres)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2016", new DateFrancaise(4, 8, 2011), new String [] {"Cler*s", "Zvonareva"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur invalide (caractere *) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur invalide (caractere *)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2017", new DateFrancaise(4, 8, 2011), new String [] {"Zvonareva", "Zvonareva"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec deux comp�titeurs de m�me nom  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec un nom de comp�titeur avec deux comp�titeurs de m�me nom n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.ajouterCompetition("finaleRG2018", new DateFrancaise(4, 8, 2009), new String [] {"Clijsters", "Zvonareva"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition avec date pass�e n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("l'ajout d'une comp�tition avec avec date pass�e n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			// ajout correct de comp�tition 

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2012, 15, 00), new String [] {new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"), new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"), new DateFrancaise(27, 6, 2013, 20, 00), new String [] {new String("Lyon"), new String("Nantes"), new String("Lens"), new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", }, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00), new String [] {new String("Tsonga"), new String("Nadal")}, new String("ilesCaimans"));


			try {
				siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2012, 15, 00), new String [] {new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
				System.out.println("l'ajout d'une comp�tition existante n'a pas lev� l'exception CompetitionExistanteException");
			}
			catch (CompetitionExistanteException e) { }


		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}
	}



   public static void testCrediterDebiterJoueur () {

		System.out.println("\n testCrediterDebiterJoueur");
		
		try {
			
			// construction correcte d'un site
			
			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));
			
			// inscription correcte de joueurs 
			
			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), new String("ilesCaimans"));			
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), new String("ilesCaimans"));			
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), new String("ilesCaimans"));
			

			
			// crediter un joueur de maniere incorrecte
			
			// si nom, prenom ou pseudo sont invalides
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Nado"), new String ("Sylvain"), new String ("zinzin"), 30, new String("ilesCaimans"));
				System.out.println("crediter un joueur avec un nom incorrect n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un nom incorrect n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.crediterJoueur(null, new String ("Sylvain"), new String ("zinzin"), 30, new String("ilesCaimans"));
				System.out.println("crediter un joueur avec un nom invalide n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un nom invalide n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.crediterJoueur(new String ("Nadou"), new String ("Silvain"), new String ("zinzin"), 30, new String("ilesCaimans"));
				System.out.println("crediter un joueur avec un prenom incorrect n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un prenom incorrect n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Nadou"), null, new String ("zinzin"), 30, new String("ilesCaimans"));
				System.out.println("crediter un joueur avec un prenom invalide n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un prenom invalide n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Nadou"), new String ("Sylvain"), new String (""), 30, new String("ilesCaimans"));
				System.out.println("crediter un joueur avec un pseudo invalide n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un pseudo invalide n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Nadou"), new String ("Sylvain"), null, 30, new String("ilesCaimans"));
				System.out.println("crediter un joueur avec un pseudo invalide n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un pseudo invalide n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			
			// Si il n'existe pas de joueur avec les memes nom, prenom et pseudo
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Nadine"), new String ("Sylvain"),new String ("pseudosyl"), 30, new String("ilesCaimans"));
				System.out.println("crediter un joueur inexistant n'a pas lev� l'exception JoueurInnexistantExeption");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur inexistant n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}
			
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Prou"), new String ("Bernard"), new String ("fanfan"), 30, new String("ilesCaimans"));
				System.out.println("crediter un joueur inexistant n'a pas lev� l'exception JoueurInnexistantExeption");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur inexistant n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}
			
	
			
			
			// Si le passwordGestionnaire est invalide
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Prou"), new String ("Bernard"), ("nanard"), 30, null);
				System.out.println("crediter un joueur avec un password gestionnaire invalide (non instanci�)  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un password gestionnaire invalide (non instanci�) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Prou"), new String ("Bernard"), ("nanard"), 30, new String("12aze"));
				System.out.println("crediter un joueur avec un password gestionnaire invalide (moins de 8 caract�res)  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un password gestionnaire invalide (moins de 8 caract�res) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
			// Si le passwordGestionnaire est incorrect
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Prou"), new String ("Bernard"), ("nanard"), 30, new String ("ilesXCaimans"));
				System.out.println("crediter un joueur avec un password gestionnaire incorrect  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec un password gestionnaire incorrect n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
			
			// Si la somme en jetons est negative

			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Prou"), new String ("Bernard"), new String ("nanard"), -30, new String ("ilesCaimans"));
				System.out.println("crediter un joueur avec une somme en jetons negative n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("crediter un joueur avec une somme en jetons negative n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			

			// crediter un joueur de maniere correcte
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Prou"), new String("Bernard"), new String("nanard"),300 ,new String ("ilesCaimans"));
			}
			catch (Exception e) {
				System.out.println("\n crediter un joueur de maniere correcte a lev� une exception ");
				e.printStackTrace();
			}
			
			
			try {
				siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"),300 ,new String ("ilesCaimans"));
			}
			catch (Exception e) {
				System.out.println("\n crediter un joueur de maniere correcte a lev� une exception ");
				e.printStackTrace();
			}
			// regarder si le soldeEnJetons du joueur est bien 300.

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 301, new String("ilesCaimans"));
				System.out.println("le credit de bernard devrait �tre inf�rieur a 301, et l'exception JoueurException aurait d� �tre lev�e");
			}
			catch (JoueurException e) { } 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre inf�rieur a 301, et l'exception JoueurException aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}
			
			
			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 300, new String("ilesCaimans"));
			}
			catch (JoueurException e) { 
				System.out.println("le credit de bernard devrait �tre �gal a 300, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre �gal a 300, et aucune exception n'aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 301, new String("ilesCaimans"));
				System.out.println("le credit de bernard devrait �tre inf�rieur a 301, et l'exception JoueurException aurait d� �tre lev�e");
			}
			catch (JoueurException e) { } 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre inf�rieur a 301, et l'exception JoueurException aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}
			
			
			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 300, new String("ilesCaimans"));
			}
			catch (JoueurException e) { 
				System.out.println("le credit de bernard devrait �tre �gal a 300, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre �gal a 300, et aucune exception n'aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}
			
			// debiter un joueur de maniere correcte
			
			
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Prou"), new String("Bernard"), new String("nanard"),400 ,new String ("ilesCaimans"));
			}
			catch (Exception e) {
				System.out.println("\n crediter un joueur de maniere correcte a lev� une exception ");
				e.printStackTrace();
			}
			
			
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Prou"), new String("Bernard") ,new String("nanard"),100 ,new String ("ilesCaimans") );
			}
			catch (Exception e) {
				System.out.println("\n debiter un joueur de maniere correcte a lev� une exception ");
				e.printStackTrace();
			}
			
			// il faut regarder si le soldeEnJetons du joueur est bien 300 .
			
			
			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 301, new String("ilesCaimans"));
				System.out.println("le credit de bernard devrait �tre inf�rieur a 301, et l'exception JoueurException aurait d� �tre lev�e");
			}
			catch (JoueurException e) { } 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre inf�rieur a 301, et l'exception JoueurException aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}
			
			
			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 300, new String("ilesCaimans"));
			}
			catch (JoueurException e) { 
				System.out.println("le credit de bernard devrait �tre �gal a 300, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre �gal a 300, et aucune exception n'aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}

			
			// debiter un joueur de maniere incorrecte
			
			try {
				siteDeParisMetier.crediterJoueur(new String ("Prou"), new String("Bernard"), new String("nanard"),400 ,new String ("ilesCaimans"));
			}
			catch (Exception e) {
				System.out.println("\n crediter un joueur de maniere correcte a lev� une exception ");
				e.printStackTrace();
			}
			
			
			// si nom, prenom ou pseudo sont invalides
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Nado"), new String ("Sylvain"), new String ("zinzin"), 30, new String("ilesCaimans"));
				System.out.println("debiter un joueur avec un nom incorrect n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un nom incorrect n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.debiterJoueur(null, new String ("Sylvain"), new String ("zinzin"), 30, new String("ilesCaimans"));
				System.out.println("debiter un joueur avec un nom invalide n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un nom invalide n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Nadou"), new String ("Silvain"), new String ("zinzin"), 30, new String("ilesCaimans"));
				System.out.println("debiter un joueur avec un prenom incorrect n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un prenom incorrect n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Nadou"), null, new String ("zinzin"), 30, new String("ilesCaimans"));
				System.out.println("debiter un joueur avec un prenom invalide n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un prenom invalide n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Nadou"), new String ("Sylvain"), new String (""), 30, new String("ilesCaimans"));
				System.out.println("debiter un joueur avec un pseudo invalide n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un pseudo invalide n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Nadou"), new String ("Sylvain"), null, 30, new String("ilesCaimans"));
				System.out.println("debiter un joueur avec un pseudo invalide n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un pseudo invalide n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			
			// Si il n'existe pas de joueur avec les memes nom, prenom et pseudo
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Nadine"), new String ("Sylvain"), ("passwordsyl"), 30, new String("ilesCaimans"));
				System.out.println("debiter un joueur innexistant n'a pas lev� l'exception JoueurInnexistantExeption");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur innexistant n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}
			
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Prou"), new String ("Bernard"), new String ("fanfan"), 30, new String("ilesCaimans"));
				System.out.println("debiter un joueur innexistant n'a pas lev� l'exception JoueurInnexistantExeption");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("debiter joueur innexistant n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}
			
			
			// Si le passwordGestionnaire est invalide
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Prou"), new String ("Bernard"), new String  ("fanfan"), 30, null);
				System.out.println("debiter un joueur avec un password gestionnaire invalide (non instanci�)  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un password gestionnaire invalide (non instanci�) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Prou"), new String ("Bernard"), new String ("fanfan"), 30, new String ("12aze"));
				System.out.println("debiter un joueur avec un password gestionnaire invalide (moins de 8 caract�res)  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un password gestionnaire invalide (moins de 8 caract�res) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
			// Si le passwordGestionnaire est incorrect
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Prou"), new String ("Bernard"), new String ("fanfan"), 30, new String ("ilesXCaimans"));
				System.out.println("debiter un joueur avec un password gestionnaire incorrect  n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec un password gestionnaire incorrect n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
			
			// Si la somme en jetons est negative
			
			
			try {
				String passwdAbc = siteDeParisMetier.inscrireJoueur(new String("abcd"), new String("Pascal"), new String("pascal1"), new String("ilesCaimans"));

				siteDeParisMetier.debiterJoueur(new String("abcd"), new String("Pascal"), new String("pascal1"), -30, new String ("ilesCaimans"));
				System.out.println("debiter un joueur avec une somme en jetons negative n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec une somme en jetons negative n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
	
			// si le compte en jetons du joueur est inssufisant
			
			
			try {
				siteDeParisMetier.debiterJoueur(new String ("Prou"), new String ("Bernard"), new String ("nanard"), 1000, new String("ilesCaimans"));
				System.out.println("debiter un joueur avec une somme en jetons insufisante n'a pas lev� l'exception JoueurException ");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("debiter un joueur avec une somme en jetons insufisante n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}


		}
		
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}

   }
   




	public static void testMiserVainqueur () {

		System.out.println("\n testMiserVainqueur");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs 

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), new String("ilesCaimans"));					
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), new String("ilesCaimans"));					
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), new String("ilesCaimans"));


			// cr�dit  de joueurs

			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), 1917, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 1848, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1123, new String("ilesCaimans"));

			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2012, 15, 00), new String [] {new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"), new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00), new String [] {new String("Tsonga"), new String("Nadal")}, new String("ilesCaimans"));
			
			// parier incorrectement sur un vainqueur
			
			// le pseudo invalide
			
			try {
				siteDeParisMetier.miserVainqueur(null, new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un pseudo invalide (non instanci�)  n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un pseudo invalide (non instanci�)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nan"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un pseudo invalide (moins de 4 caract�res)  n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un pseudo invalide (moins de 4 caract�res)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("na-nard"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un pseudo invalide (avec '-')  n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un pseudo invalide (avec '-')  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			// le pseudo incorrect (il n'existe pas le joueur avec le m�me pseudo)

			try {
				siteDeParisMetier.miserVainqueur(new String("nanarde"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un pseudo incorrect (non existant)  n'a pas lev� l'exception JoueurInexistantException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un pseudo incorrect (non existant)  n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}

			// le password du joueur invalide

			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), null, 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un password du joueur invalide (non instanci�)  n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un password du joueur invalide (non instanci�)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String("abcdef"), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un password du joueur invalide (moins de 8 caract�res)  n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un password du joueur invalide (moins de 8 caract�res)  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String("abcdef-ghik"), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un password du joueur invalide (avec '-')  n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un password du joueur invalide (avec '-')  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}
			
			// le password du joueur incorrect
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String("fjzhefiuzhi"), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un password du joueur incorrect  n'a pas lev� l'exception JoueurInexistantException");
			}
			catch (JoueurInexistantException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un password du joueur incorrect  n'a pas lev� l'exception JoueurInexistantException mais " + e.getClass().getName());
			}
			
			// le compte en jetons du joueur est insuffisant (la somme en jetons � miser (1790) �tre inf�rieur � le compte en jetons du joueur (1789))
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 1790, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec un miseEnJetons �tre inf�rieur � compteEnJetons du joueur  n'a pas lev� l'exception JoueurException");
			}
			catch (JoueurException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec un miseEnJetons �tre inf�rieur � compteEnJetons du joueur  n'a pas lev� l'exception JoueurException mais " + e.getClass().getName());
			}

			// la somme en jetons est n�gative
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), -40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
				System.out.println("parier sur un vainqueur avec une miseEnJetons n�gative  n'a pas lev� l'exception MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("parier sur un vainqueur avec une miseEnJetons n�gative  n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}
			
			// parier dans une comp�tition inexistante
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("ChampionnatDeRance2012"), new String("Lyon"));
				System.out.println("parier dans une comp�tition inexistante  n'a pas lev� l'exception CompetitionInexistanteException");
			}
			catch (CompetitionInexistanteException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition inexistante  n'a pas lev� l'exception CompetitionInexistanteException mais " + e.getClass().getName());
			}
			
			// le nom de la comp�tition invalide
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, null, new String("Lyon"));
				System.out.println("parier dans une comp�tition avec un nom invalide (non instanci�)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition avec un nom invalide (non instanci�)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("Championnat DeFrance2012"), new String("Lyon"));
				System.out.println("parier dans une comp�tition avec un nom invalide (avec espace)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition avec un nom invalide (avec espace)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("finale|RG2012"), new String("Lyon"));
				System.out.println("parier dans une comp�tition avec un nom invalide (caract�re |)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition avec un nom invalide (caract�re |)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("RGA"), new String("Lyon"));
				System.out.println("parier dans une comp�tition avec un nom invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition avec un nom invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			// le nom du vainqueur invalide
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), null);
				System.out.println("parier dans une comp�tition avec un nom du comp�titeur invalide (non instanci�)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition avec un nom du comp�titeur invalide (non instanci�)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyon Lyon"));
				System.out.println("parier dans une comp�tition avec un nom du comp�titeur invalide (avec espace)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition avec un nom du comp�titeur invalide (avec espace)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyo"));
				System.out.println("parier dans une comp�tition avec un nom du comp�titeur invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition avec un nom du comp�titeur invalide (moins de 4 caract�res)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyon*"));
				System.out.println("parier dans une comp�tition avec un nom du comp�titeur invalide (caract�re *)  n'a pas lev� l'exception CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition avec un nom du comp�titeur invalide (caract�re *)  n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}
			
			// parier sur un vainqueur de mani�re correct
			try {
				siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
			}
			catch (Exception e) { 
				System.out.println("parier dans une comp�tition correctement mais " + e.getClass().getName());
			}

			
		}
		
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}

	}




	public static void testSolderVainqueur () {

		System.out.println("\n testSolderVainqueur");

		// tests solder pour des competitions avec parieurs non  gagnants ou sans parieur 
		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs 

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), new String("ilesCaimans"));					
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), new String("ilesCaimans"));					
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), new String("ilesCaimans"));


			// cr�dit  de joueurs

			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), 1917, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 1848, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1123, new String("ilesCaimans"));

			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2012, 15, 00), new String [] {new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"), new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00), new String [] {new String("Tsonga"), new String("Nadal")}, new String("ilesCaimans"));


			// parier correctement sur un vainqueur 
			
			siteDeParisMetier.miserVainqueur(new String("nanard"), new String(passwdBernard), 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), new String(passwdFrancoise), 20, new String("ChampionnatDeFrance2012"), new String("Brest"));
			siteDeParisMetier.miserVainqueur(new String("zinzin"), new String(passwdSylvain), 40, new String("ChampionnatDeFrance2012"), new String("Lille"));
			siteDeParisMetier.miserVainqueur(new String("aure"), new String(passwdAureliane), 37, new String("ChampionnatDeFrance2012"), new String("Marseille"));

			// solder incorrectement un vainqueur 

			try {
				siteDeParisMetier.solderVainqueur(new String("finaleRG2012"),new String("Nadal"), new String("ilesCaimans"));
				System.out.println("une comp�tition non termin�e a �t� sold�e sans lever CompetitionException");
			} 
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("une comp�tition non termin�e a �t� sold�e sans lever CompetitionException mais " + e.getClass().getName());
			}

			DateFrancaise.setDate(27, 6, 2013, 20, 10);

			try {
				siteDeParisMetier.solderVainqueur(new String("finaleRG2012"),"Federer", new String("ilesCaimans"));
				System.out.println("une comp�tition avec un vainqueur inexistant a �t� sold�e sans lever CompetitionException");
			}
			catch (CompetitionException e) { }
			catch (Exception e) { 
				System.out.println("uune comp�tition avec un vainqueur inexistant a �t� sold�e sans lever CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.solderVainqueur(new String("finaleRG2012"),new String("Tsonga"), "ilesCimans");
				System.out.println("une comp�tition a �t� sold�e avec un password gestionnaire incorrect sans lever MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("uune comp�tition a �t� sold�e avec un password gestionnaire incorrect sans lever MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.solderVainqueur(new String("finaleRG2012"),new String("Tsonga"), "il*ns");
				System.out.println("une comp�tition a �t� sold�e avec un password gestionnaire invalide sans lever MetierException");
			}
			catch (MetierException e) { }
			catch (Exception e) { 
				System.out.println("une comp�tition a �t� sold�e avec un password gestionnaire invalide sans lever MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.solderVainqueur("ChampionnatDeRance2012",new String("Marseille"), new String("ilesCaimans"));
				System.out.println("une comp�tition inexistante est  sold�e sans lever CompetitionInexistanteException");
			}
			catch (CompetitionInexistanteException e) { }
			catch (Exception e) { 
				System.out.println("uune comp�tition inexistante est  sold�e sans lever CompetitionInexistanteException mais " + e.getClass().getName());
			}


			// solder correctement un vainqueur

			DateFrancaise.setDate(4, 6, 2012, 18, 10);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2012"),"Nancy", new String("ilesCaimans"));
			DateFrancaise.setDate(7, 6, 2012, 18, 30);
			siteDeParisMetier.solderVainqueur(new String("finaleRG2012"),new String("Tsonga"), new String("ilesCaimans"));

			// solder une competition d�ja sold�e
			try {
				siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2012"),"Nancy", new String("ilesCaimans"));
				System.out.println("une comp�tition d�ja sold�e est  sold�e sans lever CompetitionInexistanteException");
			}
			catch (CompetitionInexistanteException e) { }
			catch (Exception e) { 
				System.out.println("une comp�tition d�ja sold�e  sold�e sans lever CompetitionInexistanteException mais " + e.getClass().getName());
			}

			// on v�rifie deux cr�dits restants 

			//  nanard doit avoir une cr�dit de 1789

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1790, new String("ilesCaimans"));
				System.out.println("le credit de bernard devrait �tre inf�rieur � 1790, et l'exception JoueurException aurait d� �tre lev�e");
			}
			catch (JoueurException e) { } 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre inf�rieur � 1790, et l'exception JoueurException aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}


			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789, new String("ilesCaimans"));
			}
			catch (JoueurException e) { 
				System.out.println("le credit de bernard devrait �tre �gal � 1789, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre �gal � 1789, et aucune exception n'aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}

			//  aure doit avoir un cr�dit de 785

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 786, new String("ilesCaimans"));
				System.out.println("le credit d'aure devrait �tre inf�rieur � 786, et l'exception JoueurException aurait d� �tre lev�e");
			}
			catch (JoueurException e) { } 
			catch (Exception e) { 
				System.out.println("le credit d'aure devrait �tre inf�rieur � 786, et l'exception JoueurException aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785, new String("ilesCaimans"));
			}
			catch (JoueurException e) { 
				System.out.println("le credit d'aure devrait �tre �gal � 785, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} 
			catch (Exception e) { 
				System.out.println("le credit d'aure devrait �tre �gal � 785, et aucune exception n'aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}


		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}
		
		
		
		// tests solder pour des competitions avec parieurs, avec un gagnant, avec plusieurs gagnants
		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs 

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), new String("ilesCaimans"));					
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), new String("ilesCaimans"));					
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), new String("ilesCaimans"));


			// cr�dit  de joueurs

			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), 1917, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 1848, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1123, new String("ilesCaimans"));

			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2012, 15, 00), new String [] {new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"), new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"), new DateFrancaise(27, 6, 2013, 20, 00), new String [] {new String("Lyon"), new String("Nantes"), new String("Lens"), new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", }, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00), new String [] {new String("Tsonga"), new String("Nadal")}, new String("ilesCaimans"));


			// parier correctement sur un vainqueur 

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 50, new String("finaleRG2012"), new String("Tsonga"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 70, new String("finaleRG2012"), new String("Nadal"));
			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 200, new String("finaleRG2012"), new String("Tsonga"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 20, new String("finaleRG2012"), new String("Tsonga"));
			siteDeParisMetier.miserVainqueur(new String("zinzin"), passwdSylvain, 40, new String("finaleRG2012"), new String("Nadal"));

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 20, new String("ChampionnatDeFrance2012"), new String("Brest"));
			siteDeParisMetier.miserVainqueur(new String("zinzin"), passwdSylvain, 40, new String("ChampionnatDeFrance2012"), new String("Lille"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 37, new String("ChampionnatDeFrance2012"), new String("Marseille"));


			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 80, new String("ChampionnatDeFrance2013"), new String("Nantes"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 30, new String("ChampionnatDeFrance2013"), new String("Rennes"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 48, new String("ChampionnatDeFrance2013"), new String("Nantes"));


			// solder correctement les trois competitions

			DateFrancaise.setDate(4, 6, 2012, 18, 10);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2012"),new String("Marseille"), new String("ilesCaimans"));
			DateFrancaise.setDate(7, 6, 2012, 18, 30);
			siteDeParisMetier.solderVainqueur(new String("finaleRG2012"),new String("Tsonga"), new String("ilesCaimans"));
			DateFrancaise.setDate(27, 6, 2013, 23, 00);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2013"),new String("Nantes"), new String("ilesCaimans"));

			// on v�rifie trois cr�dits restants 

			//  nanard doit avoir une cr�dit de 1868

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1869, new String("ilesCaimans"));
				System.out.println("le credit de bernard devrait �tre inf�rieur � 1869, et l'exception JoueurException aurait d� �tre lev�e");
			}
			catch (JoueurException e) { } 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre inf�rieur � 1869, et l'exception JoueurException aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}


			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1868, new String("ilesCaimans"));
			}
			catch (JoueurException e) { 
				System.out.println("le credit de bernard devrait �tre �gal � 1868, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} 
			catch (Exception e) { 
				System.out.println("le credit de bernard devrait �tre �gal � 1868, et aucune exception n'aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}

			//  aure doit avoir un cr�dit de 904

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 905, new String("ilesCaimans"));
				System.out.println("le credit d'aure devrait �tre inf�rieur � 905, et l'exception JoueurException aurait d� �tre lev�e");
			}
			catch (JoueurException e) { } 
			catch (Exception e) { 
				System.out.println("le credit d'aure devrait �tre inf�rieur � 905, et l'exception JoueurException aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.debiterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 904, new String("ilesCaimans"));
			}
			catch (JoueurException e) { 
				System.out.println("le credit d'aure devrait �tre �gal � 904, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} 
			catch (Exception e) { 
				System.out.println("le credit d'aure devrait �tre �gal � 904, et aucune exception n'aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}

			//  zinzin doit avoir un cr�dit de 1043

			try {
				siteDeParisMetier.debiterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1044, new String("ilesCaimans"));
				System.out.println("le credit de zinzin devrait �tre inf�rieur � 1044, et l'exception JoueurException aurait d� �tre lev�e");
			}
			catch (JoueurException e) { } 
			catch (Exception e) { 
				System.out.println("le credit de zinzin devrait �tre inf�rieur � 1044, et l'exception JoueurException aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.debiterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1043, new String("ilesCaimans"));
			}
			catch (JoueurException e) { 
				System.out.println("le credit de zinzin devrait �tre �gal � 1043, et l'exception JoueurException n'aurait pas d� �tre lev�e");
			} 
			catch (Exception e) { 
				System.out.println("le credit de zinzin devrait �tre �gal � 1043, et aucune exception n'aurait d� �tre lev�e mais c'est : " + e.getClass().getName());
			}


		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}
		
	}




	public static void testConsulterCompetitions () {

		System.out.println("\n testConsulterCompetitions");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			DateFrancaise.setDate(1, 1, 2010);


			if (siteDeParisMetier.consulterCompetitions().size() != 0)
				System.out.println("consulterCompetitions  rend une  liste non vide alors que  le site  vient d'�tre cr�e et sans qu'il y ait eu d'ajout de competitions");


			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2012, 15, 00), new String [] {new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"), new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"), new DateFrancaise(27, 6, 2013, 20, 00), new String [] {new String("Lyon"), new String("Nantes"), new String("Lens"), new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", }, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00), new String [] {new String("Tsonga"), new String("Nadal")}, new String("ilesCaimans"));

			if (siteDeParisMetier.consulterCompetitions().size() != 3)
				System.out.println("consulterCompetitions ne rend pas la liste des trois comp�titions ajout�es");


			LinkedList <LinkedList <String>> competitions = siteDeParisMetier.consulterCompetitions();
			for (LinkedList <String> l : competitions) {
				if (l.get(0).equals(new String("ChampionnatDeFrance2012")) && (!l.get(1).equals(new DateFrancaise(4, 6, 2012, 15, 00).toString())))
					System.out.println("probleme sur affichage ChampionnatDeFrance2012 ");				
				if (l.get(0).equals(new String("ChampionnatDeFrance2013")) && (!l.get(1).equals(new DateFrancaise(27, 6, 2013, 20, 00).toString())))
					System.out.println("probleme sur affichage ChampionnatDeFrance2013 ");				
				if (l.get(0).equals(new String("finaleRG2012")) && (!l.get(1).equals(new DateFrancaise(7, 6, 2012, 15, 00).toString())))
					System.out.println("probleme sur affichage finaleRG2012 ");				
			}


			// solder correctement un vainqueur

			DateFrancaise.setDate(7, 6, 2012, 18, 30);
			siteDeParisMetier.solderVainqueur(new String("finaleRG2012"),new String("Tsonga"), new String("ilesCaimans"));

			if (siteDeParisMetier.consulterCompetitions().size() != 2)
				System.out.println("consulterCompetitions ne rend pas la liste des deux comp�titions restantes");


			competitions = siteDeParisMetier.consulterCompetitions();
			for (LinkedList <String> l : competitions) {
				if (l.get(0).equals(new String("ChampionnatDeFrance2012")) && (!l.get(1).equals(new DateFrancaise(4, 6, 2012, 15, 00).toString())))
					System.out.println("probleme sur affichage ChampionnatDeFrance2012 ");				
				if (l.get(0).equals(new String("ChampionnatDeFrance2013")) && (!l.get(1).equals(new DateFrancaise(27, 6, 2013, 20, 00).toString())))
					System.out.println("probleme sur affichage ChampionnatDeFrance2013 ");				
				if (l.get(0).equals(new String("finaleRG2012")))
					System.out.println("la finaleRG2012 a �t� sold�e et ne devrait pas �tre dans la liste");				
			}

		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}
	}



	public static void testConsulterCompetiteurs () {

		System.out.println("\n testConsulterCompetiteurs");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));

			try {
				siteDeParisMetier.consulterCompetiteurs(null);
				System.out.println("consulterCompetiteurs avec une competition invalide (non instanci�) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }	
			catch (Exception e) { 
				System.out.println("consulterCompetiteurs avec une competition invalide (non instanci�) n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.consulterCompetiteurs("i2");
				System.out.println("consulterCompetiteurs avec une competition invalide (moins de 4 caract�res) n'a pas lev� l'exception CompetitionException ");
			}
			catch (CompetitionException e) { }			
			catch (Exception e) { 
				System.out.println("consulterCompetiteurs avec une competition invalide (moins de 4 caract�res) n'a pas lev� l'exception CompetitionException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.consulterCompetiteurs("inconnu");
				System.out.println("consulterCompetiteurs avec une competition inexistante n'a pas lev� l'exception CompetitionInexistanteException ");
			}
			catch (CompetitionInexistanteException e) { }			
			catch (Exception e) { 
				System.out.println("consulterCompetiteurs avec une competition inexistante n'a pas lev� l'exception CompetitionInexistanteException mais " + e.getClass().getName());
			}



			DateFrancaise.setDate(1, 1, 2010);

			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2012, 15, 00), new String [] {new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"), new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"), new DateFrancaise(27, 6, 2013, 20, 00), new String [] {new String("Lyon"), new String("Nantes"), new String("Lens"), new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", }, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00), new String [] {new String("Tsonga"), new String("Nadal")}, new String("ilesCaimans"));




			LinkedList <String> competiteurs = siteDeParisMetier.consulterCompetiteurs(new String("ChampionnatDeFrance2012"));
			if (competiteurs.size()!= 10)
				System.out.println("consulterCompetiteurs ne rend pas une liste de deux comp�titeurs pour le  ChampionnatDeFrance2012");
			if (!competiteurs.contains(new String("Lyon")))
				System.out.println("consulterCompetiteurs ne rend pas pour le ChampionnatDeFrance2012 le comp�titeur Lyon");
			if (!competiteurs.contains(new String("Rennes")))
				System.out.println("consulterCompetiteurs ne rend pas pour le ChampionnatDeFrance2012 le comp�titeur Rennes");
			if (!competiteurs.contains("Auxerre"))
				System.out.println("consulterCompetiteurs ne rend pas pour le ChampionnatDeFrance2012 le comp�titeur Auxerre");


			competiteurs = siteDeParisMetier.consulterCompetiteurs(new String("finaleRG2012"));
			if (competiteurs.size()!= 2)
				System.out.println("consulterCompetiteurs ne rend pas une liste de deux comp�titeurs pour la  finaleRG2012");
			if (!competiteurs.contains(new String("Nadal")))
				System.out.println("consulterCompetiteurs ne rend pas pour la finaleRG2012 le comp�titeur Nadal");
			if (!competiteurs.contains(new String("Tsonga")))
				System.out.println("consulterCompetiteurs ne rend pas pour la finaleRG2012 le comp�titeur Tsonga");
		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}
	}



	public static void testConsulterJoueurs () {

		System.out.println("\n testConsulterJoueurs");

		try {
			// construction correcte d'un site

			SiteDeParisMetier siteDeParisMetier = new SiteDeParisMetier(new String("ilesCaimans"));


			try {
				siteDeParisMetier.consulterJoueurs(null);
				System.out.println("consulterJoueurs avec un password invalide (non instanci�) n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }	
			catch (Exception e) { 
				System.out.println("consulterJoueurs avec un password invalide (non instanci�) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.consulterJoueurs("i2");
				System.out.println("consulterCompetiteurs avec un password invalide (moins de 4 caract�res) n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }			
			catch (Exception e) { 
				System.out.println("consulterCompetiteurs avec un password invalide (moins de 4 caract�res) n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}

			try {
				siteDeParisMetier.consulterJoueurs("inconnu");
				System.out.println("consulterCompetiteurs avec un password incorrect n'a pas lev� l'exception MetierException ");
			}
			catch (MetierException e) { }			
			catch (Exception e) { 
				System.out.println("consulterCompetiteurs avec un password incorrect n'a pas lev� l'exception MetierException mais " + e.getClass().getName());
			}



			if (siteDeParisMetier.consulterJoueurs(new String("ilesCaimans")).size() != 0)
				System.out.println("consulterJoueurs  rend une  liste non vide alors que  le site  vient d'�tre cr�e et sans qu'il y ait eu d'inscription de joueurs");


			DateFrancaise.setDate(1, 1, 2010);

			// inscription de joueurs 

			String passwdBernard = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), new String("ilesCaimans"));					
			String passwdFrancoise = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), new String("ilesCaimans"));					
			String passwdPascal = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Pascal"), new String("pascal"), new String("ilesCaimans"));
			String passwdMorgane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Morgane"), new String("momo"), new String("ilesCaimans"));
			String passwdAureliane = siteDeParisMetier.inscrireJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), new String("ilesCaimans"));
			String passwdSylvain = siteDeParisMetier.inscrireJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), new String("ilesCaimans"));

			if (siteDeParisMetier.consulterJoueurs(new String("ilesCaimans")).size() != 6)
				System.out.println("consulterJoueurs  rend une  liste qui n'a pas 6 �l�ments alors qu'il y a eu inscription de 6 joueurs");

			// cr�dit  de joueurs

			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Bernard"), new String("nanard"), 1789, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Francoise"), new String("fanfan"), 1917, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Morgane"), new String("momo"), 1848, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Prou"), new String("Aureliane"), new String("aure"), 785, new String("ilesCaimans"));
			siteDeParisMetier.crediterJoueur(new String("Nadou"), new String("Sylvain"), new String("zinzin"), 1123, new String("ilesCaimans"));



			LinkedList <LinkedList <String>> joueurs = siteDeParisMetier.consulterJoueurs(new String("ilesCaimans"));
			for (LinkedList <String> l : joueurs) {
				if (l.get(2).equals(new String("momo")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Morgane")) || !l.get(3).equals("" + 1848) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur momo apr�s cr�dit");				
				if (l.get(2).equals(new String("nanard")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Bernard")) || !l.get(3).equals("" + 1789)|| !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur nanard apr�s cr�dit");				
				if (l.get(2).equals(new String("zinzin")) && (!l.get(0).equals(new String("Nadou")) || !l.get(1).equals(new String("Sylvain")) || !l.get(3).equals("" + 1123)|| !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur zinzin apr�s cr�dit");				
				if (l.get(2).equals(new String("aure")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Aureliane")) || !l.get(3).equals("" + 785) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur aure apr�s cr�dit");				
			}

			// ajout de comp�tions

			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2012"), new DateFrancaise(4, 6, 2012, 15, 00), new String [] {new String("Lyon"), new String("Marseille"), "Paris", new String("Rennes"), new String("Brest"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", "Auxerre"}, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("ChampionnatDeFrance2013"), new DateFrancaise(27, 6, 2013, 20, 00), new String [] {new String("Lyon"), new String("Nantes"), new String("Lens"), new String("Marseille"), "Paris", new String("Rennes"), "StEtienne", new String("Lille"), "Nancy", "Toulouse", }, new String("ilesCaimans"));
			siteDeParisMetier.ajouterCompetition(new String("finaleRG2012"), new DateFrancaise(7, 6, 2012, 15, 00), new String [] {new String("Tsonga"), new String("Nadal")}, new String("ilesCaimans"));

			// mises de joueurs

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 40, new String("ChampionnatDeFrance2012"), new String("Lyon"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 20, new String("ChampionnatDeFrance2012"), new String("Brest"));
			siteDeParisMetier.miserVainqueur(new String("zinzin"), passwdSylvain, 40, new String("ChampionnatDeFrance2012"), new String("Lille"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 37, new String("ChampionnatDeFrance2012"), new String("Marseille"));

			siteDeParisMetier.miserVainqueur(new String("nanard"), passwdBernard, 80, new String("ChampionnatDeFrance2013"), new String("Nantes"));
			siteDeParisMetier.miserVainqueur(new String("fanfan"), passwdFrancoise, 30, new String("ChampionnatDeFrance2013"), new String("Rennes"));
			siteDeParisMetier.miserVainqueur(new String("aure"), passwdAureliane, 48, new String("ChampionnatDeFrance2013"), new String("Nantes"));

			joueurs = siteDeParisMetier.consulterJoueurs(new String("ilesCaimans"));
			for (LinkedList <String> l : joueurs) {
				if (l.get(2).equals(new String("momo")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Morgane")) || !l.get(3).equals("" + 1848) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur momo apr�s paris");				
				if (l.get(2).equals(new String("nanard")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Bernard")) || !l.get(3).equals("" + 1669) || !l.get(4).equals("" + 120)))
					System.out.println("probleme sur affichage du joueur nanard apr�s paris");				
				if (l.get(2).equals(new String("zinzin")) && (!l.get(0).equals(new String("Nadou")) || !l.get(1).equals(new String("Sylvain")) || !l.get(3).equals("" + 1083) || !l.get(4).equals("" + 40)))
					System.out.println("probleme sur affichage du joueur zinzin apr�s paris");				
				if (l.get(2).equals(new String("aure")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Aureliane")) || !l.get(3).equals("" + 700) || !l.get(4).equals("" + 85)))
					System.out.println("probleme sur affichage du joueur aure apr�s paris");				
			}


			DateFrancaise.setDate(4, 6, 2012, 18, 10);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2012"),new String("Marseille"), new String("ilesCaimans"));

			joueurs = siteDeParisMetier.consulterJoueurs(new String("ilesCaimans"));
			for (LinkedList <String> l : joueurs) {
				if (l.get(2).equals(new String("momo")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Morgane")) || !l.get(3).equals("" + 1848) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur momo apr�s premier solder");				
				if (l.get(2).equals(new String("nanard")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Bernard")) || !l.get(3).equals("" + 1669) || !l.get(4).equals("" + 80)))
					System.out.println("probleme sur affichage du joueur nanard apr�s premier solder");				
				if (l.get(2).equals(new String("zinzin")) && (!l.get(0).equals(new String("Nadou")) || !l.get(1).equals(new String("Sylvain")) || !l.get(3).equals("" + 1083) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur zinzin apr�s premier solder");				
				if (l.get(2).equals(new String("aure")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Aureliane")) || !l.get(3).equals("" + 837) || !l.get(4).equals("" + 48)))
					System.out.println("probleme sur affichage du joueur aure apr�s premier solder");				
			}

			DateFrancaise.setDate(27, 6, 2013, 23, 00);
			siteDeParisMetier.solderVainqueur(new String("ChampionnatDeFrance2013"),new String("Nantes"), new String("ilesCaimans"));

			joueurs = siteDeParisMetier.consulterJoueurs(new String("ilesCaimans"));
			for (LinkedList <String> l : joueurs) {
				if (l.get(2).equals(new String("momo")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Morgane")) || !l.get(3).equals("" + 1848) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur momo apr�s deuxieme solder");				
				if (l.get(2).equals(new String("nanard")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Bernard")) || !l.get(3).equals("" + 1767) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur nanard apr�s deuxieme solder");				
				if (l.get(2).equals(new String("zinzin")) && (!l.get(0).equals(new String("Nadou")) || !l.get(1).equals(new String("Sylvain")) || !l.get(3).equals("" + 1083) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur zinzin apr�s deuxieme solder");				
				if (l.get(2).equals(new String("aure")) && (!l.get(0).equals(new String("Prou")) || !l.get(1).equals(new String("Aureliane")) || !l.get(3).equals("" + 896) || !l.get(4).equals("" + 0)))
					System.out.println("probleme sur affichage du joueur aure apr�s deuxieme solder");				
			}

		}
		catch (Exception e) {
			System.out.println("\n Exception impr�vue : " + e);
			e.printStackTrace();
		}
	}



	public static void main (String [] args) {

		testConstructeurSiteDeParisMetier();
		testValiditePasswordGestionnaire();
		testInscrireDesinscrireJoueur();
		testValiditePasswordJoueur();
		testCrediterDebiterJoueur();
		testAjouterCompetition();
		testMiserVainqueur();
		testSolderVainqueur();
		testConsulterCompetitions();
		testConsulterCompetiteurs();
		testConsulterJoueurs();		

	}



}




