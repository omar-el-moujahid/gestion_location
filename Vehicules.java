package gestion_Vehicules;

public class Vehicules {
	private String marque ;
	private String modele ;
	private int anee ;
	private int id_Vehicules ; 
	public Vehicules(String marque, String modele, int anee , int id) {
		this.marque = marque;
		this.modele = modele;
		this.anee = anee;
		this.id_Vehicules = id;
	}
	public Vehicules(String marque, String modele, int anee ) {
		this.marque = marque;
		this.modele = modele;
		this.anee = anee;
	}
	public String getMarque() {
		return marque;
	}
	public String getModele() {
		return modele;
	}
	public int getAnee() {
		return anee;
	}
	public int getId() {
		return id_Vehicules;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public void setAnee(int anee) {
		this.anee = anee;
	}
	public void setId(int id) {
		this.id_Vehicules = id;
	}
	@Override
	public String toString() {
		return "  \n Vehicules [marque=" + marque + ", modele=" + modele + ", anee=" + anee + ", id=" + id_Vehicules + "] \n ";
	}
	
	
	
	
}
