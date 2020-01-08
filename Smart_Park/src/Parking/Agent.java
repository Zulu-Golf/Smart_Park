package Parking;

import java.util.Date;

public class Agent extends Personne{

	private Date date_recrutement;
	private String id_agent,id_parking;
	
	public Agent(String login, String mot_de_passe, String nom, String prenom, String cin, Date date_recrutement,
			String id_agent, String id_parking) {
		super(login, mot_de_passe, nom, prenom, cin);
		this.date_recrutement = date_recrutement;
		this.id_agent = id_agent;
		this.id_parking = id_parking;
	}

	public Date getDate_recrutement() {
		return date_recrutement;
	}

	public void setDate_recrutement(Date date_recrutement) {
		this.date_recrutement = date_recrutement;
	}

	public String getId_agent() {
		return id_agent;
	}

	public void setId_agent(String id_agent) {
		this.id_agent = id_agent;
	}

	public String getId_parking() {
		return id_parking;
	}

	public void setId_parking(String id_parking) {
		this.id_parking = id_parking;
	}
	
	@Override
	public boolean equals(Object p){
		if(p==null){
			return false;
		}
		if(p.getClass()!=this.getClass()){
			return false;
		}
		
		Agent o= (Agent)p;
		
		return this.id_agent.equals(o.id_agent);
	}


	@Override
	public String toString() {
		return "Agent [date_recrutement=" + date_recrutement + ", id_agent=" + id_agent + ", id_parking=" + id_parking
				+ ", Personne=" + super.toString() + "]";
	}
	
	
	public String consulter_Place(Place p) {
		return p.toString();
	}
	
	
	


}
