package falfred.villes.shared;

import java.io.Serializable;

public class Ville implements Serializable {

	private int kp_ville;
	private String region;
	private String departement;
	private String ville;
	private String code_postal;
	private double lat;
	private double lng;
	private Ville supervisor;
	

	public Ville() {
		// TODO Auto-generated constructor stub
	}
	
	public int getkp_ville() {
		return this.kp_ville;
	}
	
	public void setkp_ville(int kp_ville) {
		this.kp_ville = kp_ville;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public Ville getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Ville supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public String toString() {
		return "Ville [kp_ville : " + kp_ville 
				+ ", region : " + region 
				+ ", département : " + departement 
				+ ", ville : " + ville 
				+ ", code postal : " + code_postal 
				+ ", latitude : " + lat 
				+ ", longitude : " + lng;
	}
	
}
