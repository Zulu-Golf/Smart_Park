package Parking;


public abstract class Personne {
	private String login,mot_de_passe,nom,prenom,cin;
	public Personne(String login,String mot_de_passe,String nom,String prenom,String cin) {
		this.login=login;
		this.mot_de_passe=mot_de_passe;
		this.nom=nom;
		this.prenom=prenom;
		this.cin=cin;
	}
	@Override
	public String toString() {
		return "Personne [login=" + login + ", mot_de_passe=" + mot_de_passe + ", nom=" + nom + ", prenom=" + prenom
				+ ", cin=" + cin + "]";
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	
	@Override
	public boolean equals(Object p){
		if(p==null){
			return false;
		}
		if(p.getClass()!=this.getClass()){
			return false;
		}
		
		Personne o= (Personne)p;
		
		return this.cin.equals(o.cin);
	}



}
