package Parking;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.model.Updates;

public class Agent extends Personne{

	private Date date_recrutement;
	private String id_agent;
	MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	DB db = mongo.getDB("SmartParking");
	DBCollection col1 = db.getCollection("Place");
	DBCollection col2 = db.getCollection("Parking");
	
	public Agent(String login, String mot_de_passe, String nom, String prenom, String cin, Date date_recrutement,
			String id_agent) {
		super(login, mot_de_passe, nom, prenom, cin);
		this.date_recrutement = date_recrutement;
		this.id_agent = id_agent;
	
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

	

	@Override
	public String toString() {
		return "Agent [date_recrutement=" + date_recrutement + ", id_agent=" + id_agent + ", Personne=" + super.toString() + "]";
	}
	public DBObject createDBObject(Place p) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id", p.getId());
		docBuilder.append("taken", p.isTaken());
		return docBuilder.get();
	}
	
	public boolean ajouter_Place(Place p) {
		col1.insert(this.createDBObject(p));
		DBObject query = BasicDBObjectBuilder.start().add("_id",this.getId_agent()).get();
		col2.findAndModify(query, (DBObject) Updates.addToSet("places",this.createDBObject(p)));
		return true;
	}
	public void consulter_Place(Place p) {
		DBObject query = BasicDBObjectBuilder.start().add("places",this.createDBObject(p)).get();
		DBCursor cursor = col2.find(query);
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		} 
	}
	public boolean supprimer_Place(Place p) {
		DBObject query = BasicDBObjectBuilder.start().add("_id",this.id_agent).append("place",this.createDBObject(p)).get();
		col2.findAndRemove(query);
		return true;
	}
	
	


}
