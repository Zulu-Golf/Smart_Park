package Parking;

import java.util.Date;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Reservation {
private String id;
private Date dateEntrer;
private Date dateSortie;
private Client client;
private Place place;
MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
DB db = mongo.getDB("SmartParking");
DBCollection col1 = db.getCollection("Place");
DBCollection col2 = db.getCollection("Parking");
	public Reservation(String id,Date dateEntrer,Date dateSortie,Client client,Place place) {
		this.id=id;
		this.dateEntrer=dateEntrer;
		this.dateSortie=dateSortie;
		this.client=client;
		this.place=place;
	}
	
	public String getId() {
		return id;
	}
	public Date getDateEntrer() {
		return dateEntrer;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public Client getClient() {
		return client;
	}
	public Place getPlace() {
		return place;
	}
	public void setDateEntrer(Date dateEntrer) {
		this.dateEntrer = dateEntrer;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Rservation : [ Id : "+this.getId()+", Client : "+this.getClient().toString()+", Date entrée : "+this.getDateEntrer()+", Date sortie : "+this.getDateSortie()+" ]";
		}
	
	public DBObject createDBObject() {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id", this.getId());
		docBuilder.append("Date entrée",this.getDateEntrer());
		docBuilder.append("Client",this.getClient().createDBObject());
		docBuilder.append("Place",this.getPlace().createDBObject());
		docBuilder.append("Date sortie", this.getDateSortie());
		return docBuilder.get();
	}
	

}
