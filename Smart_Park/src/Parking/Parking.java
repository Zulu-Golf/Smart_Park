package Parking;

import java.util.*;

public class Parking {
private LinkedList<Place> lesPlaces ;
private Agent a;
private String id;
	public Parking(Agent a,String id) {
		this.lesPlaces = new LinkedList<Place>();
		this.a = a;
		this.id=id;
	}
	public LinkedList<Place> getLesPlaces() {
		return lesPlaces;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Agent getA() {
		return a;
	}
	public void setLesPlaces(LinkedList<Place> lesPlaces) {
		this.lesPlaces = lesPlaces;
	}
	public void setA(Agent a) {
		this.a = a;
	}
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			String pl = "";
			for(Place p : this.getLesPlaces()) {
				pl += p.toString()+"\n";
			}
			pl += this.getA().toString();
			return pl;
		}
	public LinkedList<Place> getPlacesById(String id){
		LinkedList<Place> list = new LinkedList<Place>();
		for(Place p : this.getLesPlaces()) {
			if(p.getId().equals(id)) {
				list.add(p);
			}
		}
		return list;
	}
	public boolean updateAgent(Agent ag) {
		this.setA(ag);
		return true;
	}
	public boolean ajouterPlace(Place p) {
		this.getLesPlaces().add(p);
		return true;
	}
	public boolean supprimerPlace(Place p) {
		for(Place pl : this.getLesPlaces()) {
			if(pl.equals(p)) {
				this.getLesPlaces().remove(pl);
				return true;
				}
		}
		return false;
	}
	

}
