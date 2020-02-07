package Parking;
import com.mongodb.client.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.mongodb.*; 

public class Admin extends Personne {
	private String id_admin;
	MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	DB db = mongo.getDB("SmartParking");
	DBCollection col = db.getCollection("Administrateur");
	DBCollection col1 = db.getCollection("Parking");
	DBCollection col2 = db.getCollection("Agent");

	public Admin(String login, String mot_de_passe, String nom, String prenom, String cin, String id_admin) {
		super(login, mot_de_passe, nom, prenom, cin);
		this.id_admin = id_admin;
	}
	private  Agent createAgent() {
		Date time = new Date();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Donner le login :");
		String login = sc.next();
		System.out.println("Saisie le mot de passe : ");
		String password = sc.next();
		System.out.println("saisie votre nom : ");
		String nom = sc.next();
		System.out.println("saisie votre prénom : ");
		String prenom = sc.next();
		System.out.println("Saisie votre cin : ");
		String cin = sc.next();
		String id =  ObjectId(time, cin);
		Agent u = new Agent(login,password,nom,prenom,cin,new Date(),id);
		
		return u;
	}

	private String ObjectId(Date time,String cin) {
		// TODO Auto-generated method stub
		return time+"_"+cin;
	}
	public String getId_admin() {
		return id_admin;
	}

	public void setId_admin(String id_admin) {
		this.id_admin = id_admin;
	}
	@Override
	public String getLogin() {
		// TODO Auto-generated method stub
		return super.getLogin();
	}
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return super.getNom();
	}
	@Override
	public String getCin() {
		// TODO Auto-generated method stub
		return super.getCin();
	}
	@Override
	public String getMot_de_passe() {
		// TODO Auto-generated method stub
		return super.getMot_de_passe();
	}
	@Override
	public String getPrenom() {
		// TODO Auto-generated method stub
		return super.getPrenom();
	}
	@Override
	public void setCin(String cin) {
		// TODO Auto-generated method stub
		super.setCin(cin);
	}
	@Override
	public void setLogin(String login) {
		// TODO Auto-generated method stub
		super.setLogin(login);
	}
	@Override
	public void setMot_de_passe(String mot_de_passe) {
		// TODO Auto-generated method stub
		super.setMot_de_passe(mot_de_passe);
	}
	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		super.setNom(nom);
	}
	@Override
	public void setPrenom(String prenom) {
		// TODO Auto-generated method stub
		super.setPrenom(prenom);
	}

	@Override
	public String toString() {
		return "Admin [id_admin=" + id_admin + ", Personne()=" + super.toString() + "]";
	}
	public  DBObject createDBObject(Agent ad) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("_id", ad.getId_agent());
		docBuilder.append("login", ad.getLogin());
		docBuilder.append("password", ad.getMot_de_passe());
		docBuilder.append("nom", ad.getNom());
		docBuilder.append("prénom", ad.getPrenom());
		docBuilder.append("cin", ad.getCin());
		docBuilder.append("Date de récrutement", ad.getDate_recrutement());
		return docBuilder.get();
	}
	public DBObject createDBObject(Parking p) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		List<Place> places = new LinkedList<Place>();
		docBuilder.append("_id", p.getId());
		docBuilder.append("Agent",this.createDBObject(p.getA()));
		docBuilder.append("Places", places);
		return docBuilder.get();
	}

	public Agent ajouter_Agent() {
		Agent ad = this.createAgent();
		col2.insert(this.createDBObject(ad));
		return ad;
	}
	public boolean ajouter_Parking(Agent a) {
		Parking p = new Parking(a,a.getId_agent());
		col1.insert(this.createDBObject(p));
		return true;
	}
	public void consulter_Agent(Agent a) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", a.getId_agent()).get();
		DBCursor cursor = col2.find(query);
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		} 
	}
	public boolean supprimer_Agent(Agent a) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", a.getId_agent()).get();
		col2.remove(query);
		return true;
	}
	public boolean changeAgent(Agent a,Agent b) {
		BasicDBObject searchQuery = new BasicDBObject().append("Agent",this.createDBObject(a));
		col1.update(searchQuery, this.createDBObject(b));
		return true;
	}
	public boolean supprimer_Parking(Parking p) {
		DBObject query = BasicDBObjectBuilder.start().add("_id", p.getId()).get();
		col1.remove(query);
		return true;
	}
}
