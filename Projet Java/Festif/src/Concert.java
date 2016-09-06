
public class Concert {
	String date;
	String heure_debut;
	String endroit;
	String scen;
	Scene scene;
	
	public Concert (String date, String heure_debut, String endroit, Scene scene){
		this.date=date;
		this.heure_debut=heure_debut;
		this.endroit = endroit;
		this.scene=scene;
	}
	
	
	public Concert (String date, String heure_debut, String endroit, String scen){
		this.date=date;
		this.heure_debut=heure_debut;
		this.endroit = endroit;
		this.scen=scene.nom;
	}
	
	public String toString(){
		return this.date+", "+this.heure_debut+", "+this.endroit+", "+this.scene;
		
	}
	
	// Getters
		public String getDate(){
			return this.date;
		}
		
		public String getHeure_debut(){
			return this.heure_debut;
		}
		
		public String getEndroit(){
			return this.endroit;
		}
		
		public Lieu getScene(){
			return this.scene;
		}
		
	
	//setters
		public void setDate(String date){
			this.date = date;
		}
		
		public void setHeure_debut(String heure_debut){
			this.heure_debut = heure_debut;
		}
		
		public void setEndroit(String endroit){
			this.endroit = endroit;
		}
		
		public void setScene(Scene scene){
			this.scene = scene;
		}
		
	// M�thodes
		//calcul Technicien
	public int CalcTechnicien(){
		return this.scene.getCapacite()/100;
	}
		//calcul S�curit�
	public int CalcSecu(){
		return this.scene.getCapacite()/30;
	}
		//calcul Staff
	public int CalcStaff(){
		return this.scene.getCapacite()/20;
	}
		// calcul Personnel Concert
	public int CalculPersonnel(){
		return CalcTechnicien()+CalcSecu()+CalcStaff();
	}
}
