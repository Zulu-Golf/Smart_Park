package Parking;

public class Place {
	private String id;

	public Place(String id) {
		// TODO Auto-generated constructor stub
		this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Place : [id= "+this.getId()+"]";
	}

}
