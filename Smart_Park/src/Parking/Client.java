package Parking;

import java.util.Date;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Client extends Personne {
	
	private String id_client,num_telephone;
	MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	DB db = mongo.getDB("SmartParking");
	DBCollection col1 = db.getCollection("Réservation");
	DBCollection col2 = db.getCollection("Client");
	DBCollection col3 = db.getCollection("Voiture");
	public Client(String login,String mot_de_passe,String nom,String prenom,String cin,String id_client, String num_telephone) {
		super(login, mot_de_passe, nom, prenom, cin);
		this.id_client=id_client;
		this.num_telephone=num_telephone;
		
	}
	public DBObject createDBObject() {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id",this.getId_client());
		docBuilder.append("login", this.getLogin());
		docBuilder.append("password", this.getMot_de_passe());
		docBuilder.append("nom", this.getNom());
		docBuilder.append("prénom", this.getPrenom());
		docBuilder.append("cin", this.getCin());
		docBuilder.append("Numéro téléphone", this.getNum_telephone());
		return docBuilder.get();
	}
	public boolean inscription() {
		col2.insert(this.createDBObject());
		return true;
	}
	public String consulter_Statestique() {
		return "";
	}
	
	public boolean reserver_Place(Reservation r) {
		col1.insert(r.createDBObject());
		return true;
	}
	public boolean ajouter_voiture(Voiture v) {
		col3.insert(v.createDBObject());
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
