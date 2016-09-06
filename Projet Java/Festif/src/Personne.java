
public class Personne {
	String nom;
	String prenom;
	
	public Personne (String nom, String prenom){
		this.nom=nom;
		this.prenom=prenom;
	}
	
	public Personne(){
		
	}
	
	public String toString(){
		return this.nom+", "+this.prenom;
	}
	//getters
		public String getNom(){
			return this.nom;
		}
		
		public String getPrenom(){
			return this.prenom;
		}

	//setters
		public void setNom(String nom){
			this.nom = nom;
		}
		
		public void setPrenom(String prenom){
			this.prenom = nom;
		}
}