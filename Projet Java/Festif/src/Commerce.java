
public class Commerce extends Lieu{
	String type;
	int frais_entree;

	public Commerce(String nom, String type, int frais_entree) {
		super(nom);
		this.type=type;
		this.frais_entree=frais_entree;
	}
	
	// Getters
	
	public String getType(){
		return this.type;
	}
	
	public int getFrais_entree(){
		return this.frais_entree;
	}
	
	// setters
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setFrais_entree(int frais_entree){
		this.frais_entree = frais_entree;
	}
}
