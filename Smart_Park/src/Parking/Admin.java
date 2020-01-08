package Parking;

import java.util.Date;
import java.util.LinkedList;

public class Admin extends Personne {
	private String id_admin;
	LinkedList<Agent> listeAgent;
	LinkedList<Parking> listeParking;
	LinkedList<Client> listeClient;
	

	public Admin(String login, String mot_de_passe, String nom, String prenom, String cin, String id_admin) {
		super(login, mot_de_passe, nom, prenom, cin);
		this.id_admin = id_admin;
		listeAgent = new LinkedList<Agent>();
		listeParking = new LinkedList<Parking>();
		listeClient = new LinkedList<Client>();
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
	
	public boolean ajouter_Agent(String login,String mot_de_passe,String nom,String prenom,String cin,Date date_recrutement,String id_agent,String id_parking) {
		Agent a= new Agent(login, mot_de_passe, nom, prenom, cin, date_recrutement, id_agent, id_parking);
		return listeAgent.add(a);
		
	}
	public boolean ajouter_Parking(Agent a) {
		Parking p=new Parking(a);
		return listeParking.add(p);
		
	}
	
	public boolean supprimer_Parking(Parking p) {
		for (Parking park : listeParking) {
			if(park.equals(p))
				return listeParking.remove(park);
		}	
		return false;
	}
	
	public boolean ajouter_Client(String login,String  mot_de_passe,String  nom,String  prenom,String  cin,String  id_client,String  num_telephone) {
		Client p=new Client(login, mot_de_passe, nom, prenom, cin, id_client, num_telephone);
		return listeClient.add(p);
	}
	
	public boolean supprimer_Client(Client c) {
		for (Client client : listeClient) {
			if(client.equals(c))
				return listeClient.remove(client);
		}
		return false;
	}
	
	public String consulter_Agent(Agent a) {
		return a.toString();
	}
	
	public boolean supprimer_Agent(Agent a) {
		for (Agent agent : listeAgent) {
			if(agent.equals(a))
				return listeAgent.remove(agent);
		}
		return false;
	}
	
}
