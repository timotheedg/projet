
public class Personnel extends Personne{
	int salaire;

	public Personnel(String nom, String prenom, int salaire) {
		super(nom, prenom);
		this.salaire=salaire;

	}
	
	
	public String toString(){
		return super.toString()+", "+this.salaire;
	}
	
	//getters
		public int getSalaire(){
			return this.salaire;
		}
		
	//setters
		public void setSalaire(int salaire){
			this.salaire = salaire;
		}
}
