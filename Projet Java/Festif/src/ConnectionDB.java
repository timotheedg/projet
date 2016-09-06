
import java.sql.*;

public class ConnectionDB {
		/**variable globale utilisée dans la méthode testIdBD pour ne pas avoir de clés primaires identiques
		dans la base de données*/
		private static int cpt = 0;
		
/**==================================================================================================================================
 * =================================================================================================================================
 * 																			
 * 					Classe utilisée pour toutes les connexions à la base de données, 
 * 					en lecture (l'affichage) et en écriture	(la sauvegarde et la suppression)		
 * 																
 *==================================================================================================================================		 *=================================================================================================================================  
 */	
	
		/** =============================================================================================
		 * ConnecterDB
		 * 
		 * Méthode de connexion à la base de données, utilisées dans chaque méthode de la
		 * classe ConnectionDB, que ce soit en lecture ou en écriture (sauvegarde et suppression)
		 * 
		 * =============================================================================================
		 */	
		public static Connection connecterDB(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("Driver ok");
				String url="jdbc:mysql://localhost:8889/javaproj";
				String user="root";
				String password="root";
				Connection cnx=DriverManager.getConnection(url,user,password);
				//System.out.println("Connexion établie");
				return cnx;   
				}catch(Exception e){    
					e.printStackTrace();
					return null;
				}
		}
    
    
    
/**==================================================================================================================================
 * =================================================================================================================================
 * 																			
 * 					Lecture des données de la base de données			
 * 	
 * Connection à la base de données pour la lecture des informations qui y sont contenues
 * et l'affichage de ces dernières dans l'application															
 *==================================================================================================================================		 *=================================================================================================================================  
 */	   
		
		/** =============================================================================================
		 * lectureArtiste
		 * 
		 * Méthode de lecture des données de la table artiste depuis la BDD
		 * pour l'affichage dans l'application
		 *
		 * =============================================================================================
		 */	
		public static void lectureArtiste(){
			try {
    		String query = "SELECT id, nom, prenom, cachet FROM artiste";
    		Connection cnx = connecterDB();
    		Statement st = cnx.createStatement();
    		ResultSet  rs = st.executeQuery(query);
    		int cpt = 0; 
       	   	while(rs.next()){
       	   		String nom = rs.getString("nom");
       	   		nom = convertString(nom);
       	   		String prenom = rs.getString("prenom");
       	   		prenom = convertString(prenom);
       	   		int cachet = rs.getInt("cachet");
       	   		Artiste a = new Artiste(nom,prenom,cachet);
       	   		Festival f = new Festival();
       	   		f.ajoutArtiste(a);
       	   		System.out.println(prenom+", "+nom+", cachet : "+cachet+" euros."); 
       	   		cpt +=1;
       	   	}
       	   	if(cpt == 0){
       	   		System.out.println("Il n'y a pas d'artiste dans la base de données.");
       	   	}
    	
       	   	//fermeture de la connection
       	   	rs.close();
       	   	st.close();
       	   	cnx.close();	
    		
    		}catch (SQLException e){
    			System.out.println(e.getMessage());
    		}
		}
		
		/** =============================================================================================
		 * lectureCommerce
		 * 
		 * Méthode de lecture des données de la table commerce depuis la BDD
		 * pour l'affichage dans l'application
		 *
		 * =============================================================================================
		 */
		public static void lectureCommerce(){
		try{
			String query ="SELECT id, nom, type, frais FROM commerce";
			Connection cnx = connecterDB();
			Statement st = cnx.createStatement();
			ResultSet rs = st.executeQuery(query);
			int cpt = 0; //compteur pour vérifier si la table est vide
			while(rs.next()){
				String nom = rs.getString("nom");
				nom = convertString(nom);
				String type = rs.getString("type");
				type = convertString(type);
				int frais =rs.getInt("frais");
				Commerce c = new Commerce(nom,type,frais);
				Festival f = new Festival();
				f.ajoutCommerce(c);
				System.out.println(nom+", "+type+", frais : "+frais+" euros.");
				cpt += 1;
			}
			
			//test si la table est vide
			if(cpt == 0){
       	   		System.out.println("Il n'y a pas de commerce dans la base de données.");
       	   	}
			
			//fermeture de la connection
       	   	rs.close();
       	   	st.close();
       	   	cnx.close();	
    		
			}catch (SQLException e){
    			System.out.println(e.getMessage());
    		}
		}
						
		/** =============================================================================================
		 * lectureConcert
		 * 
		 * Méthode de lecture des données de la table commerce depuis la BDD
		 * pour l'affichage dans l'application
		 *
		 * =============================================================================================
		 */
		public static void lectureConcert(){
		   	try {
		   		String query = "SELECT id, date, heure_debut, endroit, scene FROM concert";
		   		Connection cnx = connecterDB();
		   		Statement st = cnx.createStatement();
		   		ResultSet  rs = st.executeQuery(query);
		   		int cpt = 0;
		   	   	while(rs.next()){
		   	   		String date = rs.getString("date");
		   	   		String heuredebut = rs.getString("heure_debut");
		   	   		String endroit = rs.getString("endroit");
		   	   		String scene = rs.getString("scene");
		   	   		Concert c = new Concert(date,heuredebut,endroit,scene);
		       		Festival f = new Festival();
		      		f.ajoutConcert(c);
		        	System.out.println(date+", "+heuredebut+", "+endroit+", "+scene+".");      
		        	cpt += 1;
		       	}
		    	
				//test si la table est vide
		   	   	if(cpt == 0){
	       	   		System.out.println("Il n'y a pas de concert dans la base de données.");
	       	   	}
		    	
		       	   	//fermeture de la connection
		       	   	rs.close();
		       	   	st.close();
		       	   	cnx.close();	
		    		
		    		}catch (SQLException e){
		    			System.out.println(e.getMessage());
		    		}
		}
	
		/** =============================================================================================
		 * lectureConcert
		 * 
		 * Méthode de lecture des données de la table concert depuis la BDD
		 * pour l'affichage dans l'application
		 *
		 * =============================================================================================
		 */
		public static void lectureScene(){
		try {
			String query = "SELECT id, nom, prenom, cachet FROM artiste";
		    Connection cnx = connecterDB();
		    Statement st = cnx.createStatement();
		    ResultSet  rs = st.executeQuery(query);
		    int cpt = 0;
		    while(rs.next()){
		    	String nom = rs.getString("nom");
		       	nom = convertString(nom);
		       	String prenom = rs.getString("prenom");
		       	prenom = convertString(prenom);
		       	int cachet = rs.getInt("cachet");
		       	Artiste a = new Artiste(nom,prenom,cachet);
		       	Festival f = new Festival();
		       	f.ajoutArtiste(a);
		       	System.out.println(prenom+", "+nom+", cachet : "+cachet+" euros.");
		       	cpt += 1;
		    }
		    	

	   	   		if(cpt == 0){
	   	   			System.out.println("Il n'y a pas de scène dans la base de données.");
	   	   		}
		    	
		       	   	//fermeture de la connection
		       	   	rs.close();
		       	   	st.close();
		       	   	cnx.close();	
		    		
		    		}catch (SQLException e){
		    			System.out.println(e.getMessage());
		    		}
				}		
		
		/** =============================================================================================
		 * lectureSecurite
		 * 
		 * Méthode de lecture des données de la table securite depuis la BDD
		 * pour l'affichage dans l'application
		 *
		 * =============================================================================================
		 */
		public static void lectureSecurite(){
    	try {
    		String query = "SELECT id, nom, prenom, salaire FROM securite";
    		Connection cnx = connecterDB();
    		Statement st = cnx.createStatement();
    		ResultSet  rs = st.executeQuery(query);
    		int cpt = 0;
       	   	while(rs.next()){
       	   		String nom = rs.getString("nom");
       	   		nom = convertString(nom);
       	   		String prenom = rs.getString("prenom");
       	   		prenom = convertString(prenom);
       	   		int salaire = rs.getInt("salaire");
       	   		Securite s = new Securite(nom,prenom,salaire);
       	   		Festival f = new Festival();
       	   		f.ajoutPerso(s);
       	   		System.out.println(prenom+", "+nom+", salaire : "+salaire+" euros."); 
       	   		cpt += 1;
       	   	}
    	
       	   	//test si la table est vide
	   	   	if(cpt == 0){
       	   		System.out.println("Il n'y a pas de membre de la sécurité dans la base de données.");
       	   	}
	   	   	
       	   	//fermeture de la connection
       	   	rs.close();
       	   	st.close();
       	   	cnx.close();	
    		
    		}catch (SQLException e){
    			System.out.println(e.getMessage());
    		}
		}
		
		/** =============================================================================================
		 * lectureSpectateur
		 * 
		 * Méthode de lecture des données de la table spectateur depuis la BDD
		 * pour l'affichage dans l'application
		 *
		 * =============================================================================================
		 */
		public static void lectureSpectateur(){
    	try {
    		String query = "SELECT id, nom, prenom, age, tarif FROM spectateur";
    		Connection cnx = connecterDB();
    		Statement st = cnx.createStatement();
    		ResultSet  rs = st.executeQuery(query);
    		int cpt = 0;
       	   	while(rs.next()){
       	   		String nom = rs.getString("nom");
       	   		nom = convertString(nom);
       	   		String prenom = rs.getString("prenom");
       	   		prenom = convertString(prenom);
       	   		int age = rs.getInt("age");
       	   		int tarif = rs.getInt("tarif");
       	   		Spectateur s = new Spectateur(nom,prenom,age,tarif);
       	   		Festival f = new Festival();
       	   		f.ajoutSpect(s);
       	   		System.out.println(prenom+", "+nom+", "+age+", "+tarif+" euros.");      	    	
       	   		cpt += 1;
       	   	}
    	
       	   	//test si la table est vide
	   	   	if(cpt == 0){
       	   		System.out.println("Il n'y a pas de spectateurs dans la base de données.");
       	   	}
	   	   	
       	   	//fermeture de la connection
       	   	rs.close();
       	   	st.close();
       	   	cnx.close();	
    		
    		}catch (SQLException e){
    			System.out.println(e.getMessage());
    		}
		}
		
		/** =============================================================================================
		 * lectureStaff
		 * 
		 * Méthode de lecture des données de la table staff depuis la BDD
		 * pour l'affichage dans l'application
		 *
		 * =============================================================================================
		 */
		public static void lectureStaff(){
    	try {
    		String query = "SELECT id, nom, prenom, salaire FROM staff";
    		Connection cnx = connecterDB();
    		Statement st = cnx.createStatement();
    		ResultSet  rs = st.executeQuery(query);
    		int cpt = 0;
       	   	while(rs.next()){
       	   		String nom = rs.getString("nom");
       	   		nom = convertString(nom);
       	   		String prenom = rs.getString("prenom");
       	   		prenom = convertString(prenom);
       	   		int salaire = rs.getInt("salaire");
       	   		Staff s = new Staff(nom,prenom,salaire);
       	   		Festival f = new Festival();
       	   		f.ajoutPerso(s);
       	   		System.out.println(prenom+", "+nom+", salaire : "+salaire+" euros."); 
       	   		cpt += 1;
       	   	}
       	   	
       	   	//test si la base est vide
	   	   	if(cpt == 0){
       	   		System.out.println("Il n'y a pas de membre du Staff dans la base de données.");
       	   	}
    	
       	   	//fermeture de la connection
       	   	rs.close();
       	   	st.close();
       	   	cnx.close();	
    		
    		}catch (SQLException e){
    			System.out.println(e.getMessage());
    		}
		}
		
		/** =============================================================================================
		 * lectureTechnicien
		 * 
		 * Méthode de lecture des données de la table technicien depuis la BDD
		 * pour l'affichage dans l'application
		 *
		 * =============================================================================================
		 */
		public static void lectureTechnicien(){
	    	try {
	    		String query = "SELECT id, nom, prenom, salaire FROM technicien";
	    		Connection cnx = connecterDB();
	    		Statement st = cnx.createStatement();
	    		ResultSet  rs = st.executeQuery(query);
	    		int cpt = 0;
	       	   	while(rs.next()){
	       	   		String nom = rs.getString("nom");
	       	   		nom = convertString(nom);
	       	   		String prenom = rs.getString("prenom");
	       	   		prenom = convertString(prenom);
	       	   		int salaire = rs.getInt("salaire");
	       	   		Technicien t = new Technicien(nom,prenom,salaire);
	       	   		Festival f = new Festival();
	       	   		f.ajoutPerso(t);
	       	   		System.out.println(prenom+", "+nom+", salaire : "+salaire+" euros.");      
	       	   		cpt += 1;
	       	   	}
	       	   	
	       	   	// test si la base est vide
		   	   	if(cpt == 0){
	       	   		System.out.println("Il n'y a pas de technicien dans la base de données.");
	       	   	}
	    	
	       	   	//fermeture de la connection
	       	   	rs.close();
	       	   	st.close();
	       	   	cnx.close();	
	    		
	    		}catch (SQLException e){
	    			System.out.println(e.getMessage());
	    		}
			}
		
   

		/** =============================================================================================
		 * lectureGlobale
		 * 
		 * Méthode de lecture des données depuis la BDD pour l'affichage dans l'application
		 * La méthode fait appel aux différentes méthodes de lecture dans les différentes tables
		 * de la base de données
		 *
		 * =============================================================================================
		 */	
		public static void lectureGlobale(){
			System.out.println("Les artistes présents dans la base sont les suivants : ");
			lectureArtiste();
			System.out.println("\nLes membres de la sécurité présents dans la base sont les suivants : ");
	    	lectureSecurite();
	    	System.out.println("\nLes membres du staff présents dans la base sont les suivants : ");
	    	lectureStaff();
	    	System.out.println("\nLes techniciens présents dans la base sont les suivants : ");
	    	lectureTechnicien();	
		}
		
		
		/** =============================================================================================
		 * convertString
		 * 
		 * Méthode de conversion des String depuis la BDD pour l'affichage
		 * Dans la base, les données sont en majuscules
		 * dans l'application en lecture, seule la première lettre est en majuscule
		 *
		 * =============================================================================================
		 */		
		public static String convertString(String majmin){
			majmin = majmin.toLowerCase();
			majmin = majmin.substring(0, 1).toUpperCase()+majmin.substring(1);
			return majmin;
		}
		
		
/**==================================================================================================================================
 * =================================================================================================================================
 * 																			
 * 					Sauvegarde des données dans la base de données			
 * 	
 * Connection à la base de données pour la sauvegarde des informations saisies par l'utilisateur, 
 * des données. 
 *  								
 *==================================================================================================================================		 *=================================================================================================================================  
 *==================================================================================================================================		 *=================================================================================================================================  
 */	       
		
	
		
		/**=============================================================================================
		 * artisteSauvegarder
		 * 
		 * Méthode d'ajout d'artiste dans la table artiste de la base de données 
		 *
		 * =============================================================================================
		 */	
	    public static void artisteSauvegarder (String nom, String prenom, float cachet){
	    	try{
	    	int id;
		    id = cpt+1;	
		    cpt = cpt+1;
		    cpt = testIdBD("artiste");
		    id = cpt;
	    	String query = "INSERT INTO artiste VALUES ("+id+", '"+ nom +"','"+ prenom +"', "+ cachet +")";
	    	Connection cnx = connecterDB();
	    	Statement st = cnx.createStatement();
	    	st.executeUpdate(query);
	    	System.out.println("artiste ajouté");
	    	
	    	//fermeture de la connection
	    	st.close();
	    	cnx.close();
	    	
	    	} catch (SQLException e){
	    		System.out.println(e.getMessage());
	    	}
	    }
    
	
	    
	    /** =============================================================================================
		 * commerceSauvegarder
		 * 
		 * Méthode d'ajout de commerce dans la table commerce de la base de données 
		 *
		 * =============================================================================================
		 */	
	    public static void CommerceSauvegarder (String nom, String type, int entree ){
	    	
	    	try{
	    	int id;
	    	id = cpt+1;	
			cpt = cpt+1;
			cpt = testIdBD("commerce");
			id = cpt;
	    	String query = "INSERT INTO commerce VALUES ("+id+", '"+ nom +"','"+ type +"', "+ entree +")";
	    	Connection cnx = connecterDB();
	    	Statement st = cnx.createStatement();
	    	st.executeUpdate(query);
	    	System.out.println("commerce ajouté");
	    	
	  
	    	//fermeture de la connection
	      	st.close();
	    	cnx.close();
	    	
	    	} catch (SQLException e){
	    		System.out.println(e.getMessage());
	    	}
	    }
	    
	    
	    
	    /** =============================================================================================
		 * technicienSauvegarder
		 * 
		 * Méthode d'ajout de technicien dans la table technicien de la base de données 
		 *
		 * =============================================================================================
		 */	
	    public static void technicienSauvegarder (String nom, String prenom, float salaire){
	    	
	    	try{
	    		int id;
	    		id = cpt+1;	
	 		    cpt = cpt+1;
	 		    cpt = testIdBD("technicien");
	 		    id = cpt;
	 		    String query = "INSERT INTO technicien VALUES ("+id+", '"+ nom +"','"+ prenom +"', "+ salaire +")";
	 		    Connection cnx = connecterDB();
	 		    Statement st = cnx.createStatement();
	 		    st.executeUpdate(query);
	 		    System.out.println("technicien ajouté");
	    	
	    	//fermeture de la connection
	    	st.close();
	    	cnx.close();
	    	
	    	} catch (SQLException e){
	    		System.out.println(e.getMessage());
	    	}
	    }
	    
	
	    
	    /** =============================================================================================
		 * spectateurSauvegarder
		 * 
		 * Méthode d'ajout de spectateur dans la table spectateur de la base de données 
		 *
		 * =============================================================================================
		 */	
	    public static void SpectateurSauvegarder (String nom, String prenom,int age, float tarif){
	    	try{
	    		int id;
	    		id = cpt+1;	
	    		cpt = cpt+1;
	    		cpt = testIdBD("spectateur");
	    		id = cpt;
	    		String query = "INSERT INTO spectateur VALUES ("+id+",'"+ nom +"','"+ prenom +"',"+age+", "+ tarif +")";
	    		Connection cnx = connecterDB();
	    		Statement st = cnx.createStatement();
	    		st.executeUpdate(query);
	    		System.out.println("spectateur ajouté");
	    
	   	
	   			//fermeture de la connection
	   			st.close();
	   			cnx.close();
	    	
	   			} catch (SQLException e){
	   				System.out.println(e.getMessage());
	   			}
	    }
 
    
	  
    
	    
	    /**=============================================================================================
		 * securiteSauvegarder
		 * 
		 * Méthode d'ajout de securite dans la table securite de la base de données 
		 *
		 * =============================================================================================
		 */	
	    public static void securiteSauvegarder (String nom, String prenom,float salaire){
    	try{
    		int id;
    		id = cpt+1;	
 		    cpt = cpt+1;
 		    cpt = testIdBD("securite");
 		    id = cpt;
 		    String query = "INSERT INTO securite VALUES ("+id+",'"+ nom +"','"+ prenom +"', "+ salaire +")";;
 		    Connection cnx = connecterDB();
 		    Statement st = cnx.createStatement();
 		    st.executeUpdate(query);
 		    System.out.println("securite ajouté");
    	
 		    //fermeture de la connection
 		    st.close();
 		    cnx.close();	
    		} catch (SQLException e){
    			System.out.println(e.getMessage());
    		}
	    }
    
	  
    
    
	    /** =============================================================================================
		 * concertSauvegarder
		 * 
		 * Méthode d'ajout de concert dans la table concert de la base de données 
		 *
		 * =============================================================================================
		 */	
	    public static void concertSauvegarder (String nom, String date, String heure_debut, String endroit, String scene){	
    	try{
    		int id;
    		id = cpt+1;	
 		    cpt = cpt+1;
 		    cpt = testIdBD("concert");
 		    id = cpt;
    		String query = "INSERT INTO concert VALUES ("+id+",'"+ nom +"', '"+ date +"','"+ heure_debut +"', '"+ endroit +"', '"+scene+"')";
    		Connection cnx = connecterDB();
    		Statement st = cnx.createStatement();
    		st.executeUpdate(query);
    		System.out.println("concert ajouté");
    	
    		//fermeture de la connection
    		st.close();
    		cnx.close();	
    		} catch (SQLException e){
    			System.out.println(e.getMessage());
    		}
	    }
    
    
	    /**=============================================================================================
		 * sceneSauvegarder
		 * 
		 * Méthode d'ajout de scene dans la table scene de la base de données 
		 *
		 * =============================================================================================
		 */	
	    public static void SceneSauvegarder (String nom, int capacite){ 	
	    try{
	    	int id;
	    	id = cpt+1;	
	    	cpt = cpt+1;
			cpt = testIdBD("scene");
			id = cpt;
	    	String query = "INSERT INTO scene VALUES ('"+ nom +"','"+capacite+")";
	    	Connection cnx = connecterDB();
	    	Statement st = cnx.createStatement();
	    	st.executeUpdate(query);
	    	System.out.println("scene ajoutée");
 	
	    	//fermeture de la connection
	    	st.close();
	    	cnx.close();
	    	} catch (SQLException e){
	    		System.out.println(e.getMessage());
	    	}
	    }
 
	  
	    /** =============================================================================================
		 * staffSauvegarder
		 * 
		 * Méthode d'ajout de staff dans la table staff de la base de données 
		 *
		 * =============================================================================================
		 */	
	    public static void staffSauvegarder (String nom, String prenom, int salaire){	
	    try{
	    	int id; 
	    	id = cpt+1;	
			cpt = cpt+1;
			cpt = testIdBD("staff");
			id = cpt;
			String query = "INSERT INTO staff VALUES ("+ id +", '"+ nom +"','"+prenom+"',"+salaire+")";
			Connection cnx = connecterDB();
			Statement st = cnx.createStatement();
			st.executeUpdate(query);
			System.out.println("Staff ajouté");
 	
			//fermeture de la connection
			st.close();
			cnx.close();
			} catch (SQLException e){
				System.out.println(e.getMessage());
			}
	    }
 
	    
	   
	    
	    
	    
	    /** =============================================================================================
		 * testIdBD
		 * 
		 * Méthode de tests permettant d'éviter les doublons dans la génération de l'ID, clé primaire 
		 * des différentes tables en vérifiant que la valeur ne figure pas déjà dans la base de données
		 * avant d'effectuer la requête d'ajout. 
		 *
		 * =============================================================================================
		 */	
		public static int testIdBD(String perso){
			try{
				Connection cnx = connecterDB();
				String query = "SELECT id FROM "+perso;
				Statement st = cnx.createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()){
					int cp = rs.getInt("id");
    			/* Si la valeur de cpt, variable gobale utilisée pour les id de tout le personnel et 
    			 * toutes les personnes, est déjà présente dans la base de données, on l'incrémente
    			 * jusqu'à obtenir une valeur non utilisée. 
    			 */
					if( cp == cpt){
						cpt +=1;
					}
				}
    		
				//fermeture de la connection
				rs.close();
				st.close();
				cnx.close();
				return cpt;
				}catch (SQLException e){
					System.out.println(e.getMessage());   
				return cpt;
				}
		}
	    
	    
/**==================================================================================================================================
 * =================================================================================================================================
 * 
 * 					Suppression des données de la base de données
 * 
 *==================================================================================================================================
 *=================================================================================================================================  
 */	    
	    
	    /** =============================================================================================
	     * suppresOptim
	     * 
	     * Méthode d'optimisation du code pour ne pas avoir une méthode par table.
	     * La table est appelée en paramètre (String genre),
	     * la requête sql est générée selon les arguments de la méthode pour appeler la bonne table
	     *
	     * =============================================================================================
	     */
	    public static void suppressOptim(String nom, String genre){
	    	try{
	    		Connection cnx = connecterDB()											;
	    		boolean bulle = false													;
	    		boolean bulle2 = false													;
	    		bulle = verifSup(nom,genre)												;
	    		bulle2 = testDuplicata(nom,genre)										;
	    		if (bulle == true){
	    			if (bulle2 == true){
	    				//System.out.println("Duplicata !");
	    				
	    			}
	    			else{
	    				String sql = "DELETE FROM `"+genre+"` WHERE `nom`='"+nom+"'"		;
		    			Statement sts = cnx.createStatement()								;
		    			sts.executeUpdate(sql)												;
		    			nom = convertString(nom)											;
		    			System.out.println(genre+" "+nom+" supprimé.")						;
	    				}
	    		}
	    		else{
	    			nom = convertString(nom)											;
	    			System.out.println("L'entrée "+nom+" n'existe pas dans la base.")	;
	    			
	    			//fermeture de la connection
	    	    	cnx.close()															;
	    	    	
	    		}
	    		} catch (SQLException e){
	    			System.out.println(e.getMessage())									;
	    		}
	    }
	    
	    
	    /** =============================================================================================
		 * verifSup
		 * 
		 * Méthode appelée par la fonction de suppression (supressOptim)  de la classe ConnectionBD
		 * elle prend en argument le nom à supprimer, et la table dans laquelle effectuer
		 * la vérification avec l'argument String genre
		 * =============================================================================================
		 */	 
	    public static boolean verifSup(String nomt, String genre){
	    	boolean bulle = false;
	    	try{
	    		String query = "SELECT nom FROM "+genre;
	    		Connection cnx = connecterDB();
	    		Statement st = cnx.createStatement();
	    		ResultSet rs = st.executeQuery(query);
	    		while (rs.next()){
	    			String nom = rs.getString("nom");
	    			if (nomt.equals(nom)){
	    				bulle = true;
	    			}
	    		}
	    	}catch(SQLException e){
	    		System.out.println(e.getMessage());
	    	}
	    	return bulle;
	    }
	    
	    
	    /** =============================================================================================
		 * testDuplicata
		 * 
		 * Méthode appelée par la fonction de suppression (supressOptim) de la classe ConnectionBD
		 * elle prend en argument le nom à supprimer, et la table dans laquelle effectuer
		 * la vérification avec l'argument String genre
		 * elle retourne un booléen True si le nom passé en argument a plusieurs occurences
		 * =============================================================================================
		 */	
	    public static boolean testDuplicata(String nomt, String genre){
	    	boolean bulledup = false;
	    	int duplicata = 0;
	    	try{
	    		String query = "SELECT nom FROM "+genre;
	    		Connection cnx = connecterDB();
	    		Statement st = cnx.createStatement();
	    		ResultSet  rs = st.executeQuery(query);
	      	   	while(rs.next()){
	    		    String nom = rs.getString("nom");
	    		    if (nomt.equals(nom)){
	    		       	duplicata +=1;
	    		       	   		}      	   		
	    		       	   	}
	      	   		if (duplicata > 1){
	      	   			bulledup = true;
	      	   		}
	    		} catch (SQLException e){
	        		System.out.println(e.getMessage());
	    		}
	    	return bulledup;
	    }
	    
	    
	  
	    
	    /** =============================================================================================
		 * verifSupDup
		 * 
		 * Méthode appelée par la fonction de suppression en cas de duplicata (supDuplicata)
		 * de la classe ConnectionBD.
		 * Elle prend en argument le prenom à supprimer, et la table dans laquelle effectuer
		 * la vérification avec l'argument String genre, pour vérifier que pour le nom et le prenom
		 * saisis par l'utilisateur, il existe une occurence à supprimer 
		 * =============================================================================================
		 */	 
	    public static boolean verifSupDup(String prenomB, String genre){
	    	boolean pren = false;
	    	try{
	    		String query = "SELECT prenom FROM "+genre;
	    		Connection cnx = connecterDB();
	    		Statement st = cnx.createStatement();
	    		ResultSet rs = st.executeQuery(query);
	    		while (rs.next()){
	    			String prenom = rs.getString("prenom");			
	    			if (prenomB.equals(prenom)){
	    				pren = true;
	    			}
	    		}
	    	}catch(SQLException e){
	    		System.out.println(e.getMessage());
	    	}
	    	return pren;
	    }

	    
	   
	    
	    /** =============================================================================================
		 * supDuplicata
		 * 
		 * Méthode appelée  avec les argument String nom, String prénom et String genre,
		 * dans le cas d'une entrée de nom ayant plusieurs occurences.
		 * Elle permet d'identifier, à l'aide du prénom saisi par l'utilisateur, l'entrée de la table
		 * à supprimer.
		 * =============================================================================================
		 */
	    public static void supDuplicata(String nom, String prenom, String genre){
	    	  try{
    		Connection cnx = connecterDB()											;
    		boolean bulle = false													;
    		boolean bulle2 = false													;
    		bulle = verifSupDup(prenom, genre)												;
    		bulle2 = testDuplicata(nom,genre)										;
    		if (bulle == true){
    			if (bulle2 == true){
    				//System.out.println("Duplicata !");
    				String sql = "DELETE FROM `"+genre+"` WHERE `nom`='"+nom+"'and `prenom`='"+prenom+"'"			;
	    			Statement sts = cnx.createStatement()								;
	    			sts.executeUpdate(sql)												;
	    			nom = convertString(nom)											;
	    			prenom = convertString(prenom)														;
	    			System.out.println(genre+" "+nom+", "+prenom+" supprimé.")						;
    			}
    		}
    		else{
    			nom = convertString(nom)											;
    			prenom = convertString(prenom)														;
    			System.out.println("L'entrée "+prenom+" n'existe pas dans la base, associé à "+nom)	;
    			
    			//fermeture de la connection
    	    	cnx.close()															;
    	    	
    		}
    		} catch (SQLException e){
    			System.out.println(e.getMessage())									;
    		}
	    }
	    
	    	
	    
/**==================================================================================================================================
 * =================================================================================================================================
 * 																			
 * 					Calcul des Frais, Gains et Bénéfices à partir des données dans la base de données			
 * 	
 * Connection à la base de données pour effectuer des calculs de frais, gains et bénéfices
 *  								
 *==================================================================================================================================		 *=================================================================================================================================  
 *==================================================================================================================================		 *=================================================================================================================================  
 */	
	
	    
	    
	    /** =============================================================================================
	     * calculFrais
	     * 
	     * Méthode de calcul des frais au sein d'une table.
	     * La méthode est unique mais par les arguments qu'elle prend, fait appel à la table 
	     * sélectionée par l'utilisateur et aux attributs correspondants.
	     *
	     * =============================================================================================
	     */
	    public static float calculFrais(String genre){
	    	int frais = 0;
	    	try{
	    		boolean t = false;
	    		String query = "SELECT salaire FROM  `"+genre+"`";
	    		if (genre.equalsIgnoreCase("artiste")){
	    			query = "SELECT cachet FROM  `"+genre+"`";
	    			t = true;
	    		}
	    		Connection cnx = connecterDB();
	    		Statement st = cnx.createStatement();
	    		ResultSet  rs = st.executeQuery(query);
	    		int somme = 0;
	    		float som = 0;
	    		if (genre.equalsIgnoreCase("technicien")){
	    			while(rs.next()){
		       	   		som = rs.getFloat("salaire");
		       	   		frais += som;
	    			}
	    		}
	    		else if(t){
	    			while(rs.next()){
		       	   		som = rs.getFloat("cachet");
		       	   		frais += som;
	    			}
	    		}
	    		else{
	    			while(rs.next()){
	    				somme = rs.getInt("salaire");
	       	   			frais += somme;
	    			}
	       	   	}
		   	   
	       	   	//fermeture de la connection
	       	   	rs.close();
	       	   	st.close();
	       	   	cnx.close();	
	    		
	    		}catch (SQLException e){
	    			System.out.println(e.getMessage());
	    		}
	    	return frais;
			}
	    
	    
	    
	    
	    /** =============================================================================================
	     * calculFraisTotal
	     * 
	     * Méthode de calcul des frais totaux.
	     * La méthode fait appel à la méthode calculFrais et effectue la somme des données récoltées
	     * dans les différentes tables de la base de données
	     *
	     * =============================================================================================
	     */
	    public static float calculFraisTotal(){
	    	float total = 0;
	    	total = ConnectionDB.calculFrais("artiste")+ConnectionDB.calculFrais("securite")+ConnectionDB.calculFrais("staff")+ConnectionDB.calculFrais("technicien");
	    	return total;
	    }
	   
	    
	    
	    /** =============================================================================================
	     * calculGains
	     * 
	     * Méthode de calcul des gains au sein d'une table.
	     * La méthode est unique mais par les arguments qu'elle prend, fait appel à la table 
	     * sélectionée par l'utilisateur et aux attributs correspondants.
	     *
	     * =============================================================================================
	     */
	    public static float calculGains(String genre){
	    	float total = 0;
	    	try{
	    		boolean t = false;
	    		String query = "SELECT frais FROM  `"+genre+"`";
	    		if (genre.equalsIgnoreCase("spectateur")){
	    			query = "SELECT tarif FROM  `"+genre+"`";
	    			t = true;
	    		}
	    		Connection cnx = connecterDB();
	    		Statement st = cnx.createStatement();
	    		ResultSet  rs = st.executeQuery(query);
	    		int somme = 0;
	    		float som = 0;
	    		if (t){
	    			while(rs.next()){
	    				som = rs.getFloat("tarif");
		       	   		total+= som;
	    			}
	    		}
	    		else{
	    			while(rs.next()){
	    				somme = rs.getInt("frais");
	       	   			total += somme;
	    			}
	       	   	}
		   	   
	       	   	//fermeture de la connection
	       	   	rs.close();
	       	   	st.close();
	       	   	cnx.close();	
	    		
	    		}catch (SQLException e){
	    			System.out.println(e.getMessage());
	    		}
	    	return total;
	    }
	    
	    
	    
	    /** =============================================================================================
	     * calculGainsTotal
	     * 
	     * Méthode de calcul des gains totaux.
	     * La méthode fait appel à la méthode calculGains et effectue la somme des données récoltées
	     * dans les différentes tables de la base de données
	     *
	     * =============================================================================================
	     */
	    public static float calculGainsTotal(){
	    	float total = 0;
	    	total = ConnectionDB.calculGains("spectateur")+ConnectionDB.calculGains("commerce");
	    	return total;
	    }
	    
	    /** =============================================================================================
	     * calculBenefices
	     * 
	     * Méthode de calcul des bénéfices.
	     * La méthode fait appel aux méthodes calculGainsTotal et calculFraisTotal
	     * et effectue la différence des données récoltées par les méthodes associées
	     * dans les différentes tables de la base de données
	     *
	     * =============================================================================================
	     */
	    public static float calculBenefices(){
	    	float ben = 0;
	    	ben = ConnectionDB.calculGainsTotal()-ConnectionDB.calculFraisTotal();
	    	return ben;
	    }

}

 
    
	  

	

