import java.util.ArrayList;
import java.util.Scanner;


public class Artiste extends Personne{
	int cachet;

	public Artiste(){
		
	}
	
	public Artiste(String nom, String prenom, int cachet) {
		super(nom, prenom);
		this.cachet=cachet;
	
	}
	
	
		
	
	/*public Artiste(String nom, String prenom){
		super(nom,prenom);
		Scanner sca = new Scanner(System.in);
		System.out.print("Nom : ");
		String nomt = sca.nextLine();
		System.out.print("Prenom : ");
		String prenomt = sca.nextLine();
		System.out.print("Cachet : ");
		int cachett = sca.nextInt();
		Artiste a = new Artiste(nomt,prenomt,cachett);
		this.nom = nomt;
		this.prenom = prenomt;
		this.cachet = cachett;
	}*/
	
	/*public static Artiste nouvArtiste(){
		Scanner sca = new Scanner(System.in);
		System.out.print("Nom : ");
		String nomt = sca.nextLine();
		System.out.print("Prenom : ");
		String prenomt = sca.nextLine();
		System.out.print("Cachet : ");
		int cachett = sca.nextInt();
		Artiste a = new Artiste(id, nomt,prenomt,cachett);
		return a;
	}*/
	
	public String toString(){
		return super.toString()+", "+this.cachet;
	}
	
	// getters 
	public int getCachet(){
		return this.cachet;
	}
	
	//setters
	public void setCachet(int cachet){
		this.cachet = cachet;
	}
}
