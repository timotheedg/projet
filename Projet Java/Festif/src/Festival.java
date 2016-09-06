import java.util.ArrayList;
import java.util.Scanner;

public class Festival {
	private ArrayList<Concert> arrconcert=new ArrayList<Concert>();
	private ArrayList<Spectateur> arrspectateur=new ArrayList<Spectateur>();
	private ArrayList<Personnel> arrpersonnel=new ArrayList<Personnel>();
	private ArrayList<Commerce> arrcommerce=new ArrayList<Commerce>();
	private ArrayList<Artiste> arrartiste=new ArrayList<Artiste>();
	
	// M�thode pour ajouter concert � l'arraylist Concert
	public void ajoutConcert(Concert c){
		arrconcert.add(c);
	}
	
	//M�thode pour supprimer concert � l'arraylist Concert
	public void suppConcert(Concert c){
	arrconcert.remove(c);
	}
	
	// M�thode pour ajouter spectateur � l'arraylist Spectateur
	public void ajoutSpect(Spectateur s){
		arrspectateur.add(s);
	}
	
	//M�thode pour supprimer spectateur � l'arraylist Spectateur
	public void suppSpect(Spectateur s){
	arrspectateur.remove(s);
	}
	
	// M�thode pour ajouter personnel � l'arraylist Personnel
	public void ajoutPerso(Personnel p){
		arrpersonnel.add(p);
	}
	
	//M�thode pour supprimer personnel � l'arraylist Personnel
	public void suppPerso(Personnel p){
	arrpersonnel.remove(p);
	}
	
	// M�thode pour ajouter commerce � l'arraylist Commerce
	public void ajoutCommerce(Commerce c){
		arrcommerce.add(c);
	}
	
	//M�thode pour supprimer commerce � l'arraylist commerce
	public void suppCommerce(Commerce c){
		arrcommerce.remove(c);
	}
	
	
	//Méthode pour ajouter artiste à l'arraylist artiste
	public void ajoutArtiste(Artiste a){
		arrartiste.add(a);
	}
	
	//Méthode pour supprimer artiste de l'arraylist artiste
		public void supArtiste(Artiste a){
			arrartiste.remove(a);
		}
		
		
	
	// M�thode Afficher le programme
	public String toString(){
		String s = new String();
		for(Concert c : arrconcert ){
				s= s+"\n"+c;
		}
		return s;
	}
	
	//string toString artiste
	public String arttoString(){
		String s = new String();
		for(Artiste a : arrartiste){
				s= s+"\n"+a;
		}
		return s;
	}
 
	// Methode Total Personnel
	public int totalPersonnel(){
		return arrpersonnel.size();
	}	
		
	// Methode calcul Frais    somme (calcul technicien*salaire, calcul S�curit�*salaire, calcul Staff*salaire, cachet)
	public int calculsFrais(){
		int t =0;
		for (Personnel p : arrpersonnel){
			t+= p.salaire;
		}
		int s = 0;
		for (Artiste a : arrartiste){
			s += a.cachet;
		}
		return t+s;
	}
	
	// Methode calcul Places vendues
	public int calcPlaceVendues(){
		return arrspectateur.size();
	}
		
	// Methode calcul Benefice
	public int calculBenefice(){
		int t =0,v= 0;
		for (Spectateur s : arrspectateur){
			t+= s.tarif;
		}
		for (Commerce c : arrcommerce){
			v+= c.frais_entree;
		}
		return t+v;
	}
	
	// Methode calcul Marge
	public int calculMarge(){
		return calculBenefice()-calculsFrais();
	}
}

