package siteParis;
   import java.util.*;



/**
 * 
 * @author prou
 *
 */
    public class DateFrancaise  extends GregorianCalendar {
   
   
   /**
 * @uml.property  name="dateSimulee"
 * @uml.associationEnd  
 */
      private static DateFrancaise dateSimulee = null;
   
   
   /**
   * pour passer ou repasser en mode "temps simul�" 
   * @param jour  (de 1 � 31)
   * @param mois  (de 1 � 12)
   * @param an    (de 1 � ...)
   * @param heure  (de 0 � 23)
   * @param minute    (de 0 � 59)
   */
       public static void setDate(int jour, int mois, int an, int heure, int minute) throws DateFrancaiseException {
         dateSimulee = new DateFrancaise(jour, mois, an, heure, minute);
      }
   
   /**
   * pour passer ou repasser en mode "temps simul�" 
   * @param jour  (de 1 � 31)
   * @param mois  (de 1 � 12)
   * @param an    (de 1 � ...)
   */
       public static void setDate(int jour, int mois, int an) throws DateFrancaiseException {
         dateSimulee = new DateFrancaise(jour, mois, an, 0, 0);
      }
 
       
       /**
       * pour passer ou repasser en mode "temps simul�" 
       * @param date  la date simul�e 
       */
           public static void setDate(DateFrancaise date) throws DateFrancaiseException {
             dateSimulee = new DateFrancaise(date.get(Calendar.DAY_OF_MONTH), date.get(Calendar.MONTH)+1, date.get(Calendar.YEAR), date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE));
          }
           
           
 
   /**
   * pour passer ou repasser en mode "temps r�el de la machine"
   */
       public static void setDate() throws DateFrancaiseException {
         dateSimulee = null;
      }
   
   
   /**
   * Pour obtenir un nouvel objet de type DateFrancaise  � la valeur de la date simul�e ou r�elle
   * @return  une DateFrancaise  � la m�me date que la date simul�e.
   * 
   */
       public static DateFrancaise getDate(){
         if (dateSimulee == null) {
            return new DateFrancaise(new GregorianCalendar());
         }
         else {
             return new DateFrancaise(dateSimulee);
         }
      }
   
   
   
   
   /**
   * construit une DateFrancaise avec les valeurs pass�es en param�tre
   * @param jour  (de 1 � 31)
   * @param mois  (de 1 � 12)
   * @param an    (de 1 � ...)
   * @param heure  (de 0 � 23)
   * @param minute    (de 0 � 59)
   */
       public DateFrancaise(int jour, int mois, int an, int heure, int minute) throws DateFrancaiseException {
         super(an, mois-1, jour, heure, minute);
         if (get(Calendar.YEAR) != an) throw new DateFrancaiseException();
         if (get(Calendar.MONTH) != (mois-1)) throw new DateFrancaiseException();
         if (get(Calendar.DAY_OF_MONTH) != jour) throw new DateFrancaiseException();
         if (get(Calendar.HOUR_OF_DAY) != heure) throw new DateFrancaiseException();
         if (get(Calendar.MINUTE) != minute) throw new DateFrancaiseException();
      }
   
   /** 
   * construit une DateFrancaise avec les valeurs pass�es en param�tre  
   * @param jour  (de 1 � 31)
   * @param mois  (de 1 � 12)
   * @param an    (de 1 � ...)
   */
       public DateFrancaise(int jour, int mois, int an) throws DateFrancaiseException {
         this(jour, mois, an, 0, 0);
      }
   
   /**
   * Construction d'une DateFrancaise clone de la DateFrancaise pass�e en param�tre
   * @param date : la date � cloner
   */
       public DateFrancaise(DateFrancaise date){
         super( date.get(Calendar.YEAR), 
            date.get(Calendar.MONTH), 
            date.get(Calendar.DAY_OF_MONTH),
            date.get(Calendar.HOUR_OF_DAY),
            date.get(Calendar.MINUTE), 
            date.get(Calendar.SECOND)); 
      }
   
   /**
   * Construction d'une DateFrancaise clone de la GregorianCalendar pass�e en param�tre
   * @param date : la date � cloner
   */
       private DateFrancaise(GregorianCalendar date){
         super(date.get(Calendar.YEAR), 
            date.get(Calendar.MONTH), 
            date.get(Calendar.DAY_OF_MONTH), 
            date.get(Calendar.HOUR_OF_DAY),
            date.get(Calendar.MINUTE), 
            date.get(Calendar.SECOND)); 
      }
   
   
   
   /**
   * renvoie true si la DateFrancaise  est dans le pass� par rapport � la DateFrancaise du moment  simul� 
   */
       public boolean estDansLePasse() {
       return this.before(getDate()); 
      }
   
   
   /**
   */
       public String toString(){
         String s =  "" + get(Calendar.DAY_OF_MONTH) + "/" ;
         s += (get(Calendar.MONTH)+1) + "/" ;
         s += get(Calendar.YEAR) + "   " ;
         s += get(Calendar.HOUR_OF_DAY) + " h " ;
         s += get(Calendar.MINUTE) + " mn  " ; 
         s += get(Calendar.SECOND) + " sec"; 
         return s;
      }
   
   

   
   
   
   
   
   
   
   
   /**
   * @param args
   */
       public static void main(String[] args) {
         try {
            DateFrancaise uneDate = new DateFrancaise (13, 07, 1963, 12, 23);
            DateFrancaise autreDate = new DateFrancaise (9, 7, 1961);
            DateFrancaise aujourdhui = new DateFrancaise(new GregorianCalendar());
            DateFrancaise cloneUneDate = new DateFrancaise(uneDate);
            System.out.println ("\nTest de la classe DateFrancaise");
            System.out.println ("------------------------");
            System.out.println ("13, 07, 1963, 12, 23 : " + uneDate);
            System.out.println ("9, 7, 1961 : " + autreDate);
            System.out.println ("Aujourd'hui : " + aujourdhui);
            System.out.println ("clone de  13/07/63 12h 23mn : " + cloneUneDate);
            System.out.println ("date simul�e : " + getDate());
            setDate(25, 10, 1917);
            System.out.println ("apr�s modification de la date simul�e avec  25, 10, 1917");
            System.out.println ("date simul�e : " + getDate());
            System.out.println ("" + uneDate  + " estDansLePasse : " + uneDate.estDansLePasse());
            setDate(4, 8, 2034);
            System.out.println ("apr�s modification de la date simul�e avec  4, 8, 2034");
            System.out.println ("date simul�e : " + getDate());
            System.out.println ("" + uneDate  + " estDansLePasse : " + uneDate.estDansLePasse());
         
         }
             catch (Exception e) {
               System.out.println("\n Exception impr�vue : " + e);
               e.printStackTrace();
            }
      
      /* Cas d'erreur */
         System.out.println ("\nTentatives de cr�ations de dates inexistantes :");
         System.out.println ("----------------------------------------------");
         DateFrancaise dateInexistante;
         try {
            dateInexistante =  new DateFrancaise(29, 02, 2007); /* 2007 n'est pas bisextile */
            System.out.println ("29,02,2007  : " + dateInexistante);
         } 
             catch (DateFrancaiseException e) { }
         try {
            dateInexistante =  new DateFrancaise(31, 04, 2007, 8, 49); /* seulement 30 jours en avril */
            System.out.println ("31,04,2007 : " + dateInexistante);
         } 
             catch (DateFrancaiseException e) { }
         try {
            dateInexistante =  new DateFrancaise(2, 14, 2007);  /* pas de mois 14 */
            System.out.println ("2,14,2007 : " + dateInexistante);
         } 
             catch (DateFrancaiseException e) { }
         try {
            dateInexistante =  new DateFrancaise(03, 07, 1956, 21, 67); /* 60 mn dans une heure */
            System.out.println ("03, 07, 1956, 21, 67 : " + dateInexistante);
         } 
             catch (DateFrancaiseException e) { }
      
         System.out.println ("\nFin test de la classe DateFrancaise");
      
      }











/** 
 * @uml.property name="competition"
 * @uml.associationEnd inverse="dateCloture:siteParis.Competition"
 */
private Competition competition;
   
   
   
   
   }

