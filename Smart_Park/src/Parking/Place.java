package Parking;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class Place {
	private String id;
	private boolean taken;
	public Place(String id) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.taken=false;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Place : [id= "+this.getId()+"]";
	}
	public DBObject createDBObject() {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("_id",this.getId());
		docBuilder.append("is_taken",this.isTaken());
	
		return docBuilder.get();
	}

}
