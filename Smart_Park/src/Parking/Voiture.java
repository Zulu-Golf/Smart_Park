package Parking;

public class Voiture {
private String matriculeID;
private Client client;
private String rfID;
	public Voiture(String matriculeID,Client client,String rfID) {
		// TODO Auto-generated constructor stub
		this.matriculeID = matriculeID;
		this.client = client;
		this.rfID = rfID;
	}
	public Client getClient() {
		return client;
	}
	public String getMatriculeID() {
		return matriculeID;
	}
	public String getRfID() {
		return rfID;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setMatriculeID(String matriculeID) {
		this.matriculeID = matriculeID;
	}
	public void setRfID(String rfID) {
		this.rfID = rfID;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Voiture : [ matricule : "+this.getMatriculeID()+", rfID : "+this.getRfID()+", client : "+this.getClient().toString()+" ]";
		}

}
