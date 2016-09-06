
public class Spectateur extends Personne {
	int age;
	float tarif;

	public Spectateur(String nom, String prenom, int age, float tarif) {
		super(nom,prenom);
		this.age=age;
		this.tarif=tarif;
	}
	
	
	
	//getters
	public int age(){
		return this.age;
	}
	
		public float getTarif(){
		return this.getTarif();
	}
	
	
	//setter
	public void setAge(int age){
		this.age = age;
	}
	public void setTarif(float Tarif){
		this.tarif = tarif;
	}
}
