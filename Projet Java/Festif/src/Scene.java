
public class Scene extends Lieu{
	int capacite;

	public Scene(String nom, int capacite) {
		super(nom);
		this.capacite=capacite;
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return this.nom+", "+this.capacite;
	}
	// getter
	public int getCapacite(){
		return this.capacite;
	}
	
	//setter
	public void setCapacite(int capacite){
		this.capacite = capacite;
	}
}
