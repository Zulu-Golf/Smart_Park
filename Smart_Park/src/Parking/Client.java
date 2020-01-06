package Parking;

public class Client extends Personne {
	
	private String id_client,num_telephone;
	
	public Client(String login,String mot_de_passe,String nom,String prenom,String cin,String id_client, String num_telephone) {
		super(login, mot_de_passe, nom, prenom, cin);
		this.id_client=id_client;
		this.num_telephone=num_telephone;
		
	}
	
	public String consulter_Statestique() {
		return "";
	}
	public boolean reserver_Place() {
		return true;
	}

	@Override
	public String toString() {
		return "Client [id_client=" + id_client + ", num_telephone=" + num_telephone + ", personne="
				+ super.toString() + "]";
	}

	public String getId_client() {
		return id_client;
	}

	public void setId_client(String id_client) {
		this.id_client = id_client;
	}

	public String getNum_telephone() {
		return num_telephone;
	}

	public void setNum_telephone(String num_telephone) {
		this.num_telephone = num_telephone;
	}

}
