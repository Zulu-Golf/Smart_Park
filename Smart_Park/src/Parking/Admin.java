package Parking;

public class Admin extends Personne {
	private String id_admin;

	public Admin(String login, String mot_de_passe, String nom, String prenom, String cin, String id_admin) {
		super(login, mot_de_passe, nom, prenom, cin);
		this.id_admin = id_admin;
	}

	public String getId_admin() {
		return id_admin;
	}

	public void setId_admin(String id_admin) {
		this.id_admin = id_admin;
	}

	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", Personne()=" + super.toString() + "]";
	}
	
	public boolean ajouter_Agent() {
		return true;
	}
	public boolean ajouter_Parking() {
		return true;
	}
	public String consulter_Agent(Agent a) {
		return a.toString();
	}
	public boolean supprimer_Agent(Agent a) {
		return true;
	}
	public boolean supprimer_Parking(Parking p) {
		return true;
	}
}
