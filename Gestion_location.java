package gestion_Vehicules;
import java.util.Date;
public class Gestion_location {
	
	private int id_gestion ;
	private int id_Client;
	private int id_Vecule;
	private int Kelometragereture;
	private String etatVheculeretouur;
	private Date datelocation;
	private Date datederetour;
	
	
	public Gestion_location(int id_gestion, int id_Client, int id_Vecule, int kelometragereture,
			String etatVheculeretouur, Date datelocation, Date datederetour) {
		super();
		this.id_gestion = id_gestion;
		this.id_Client = id_Client;
		this.id_Vecule = id_Vecule;
		Kelometragereture = kelometragereture;
		this.etatVheculeretouur = etatVheculeretouur;
		this.datelocation = datelocation;
		this.datederetour = datederetour;
	}
	
	public Gestion_location(int id_gestion, int id_Client, int id_Vecule) {
		super();
		this.id_gestion = id_gestion;
		this.id_Client = id_Client;
		this.id_Vecule = id_Vecule;
	}

	public int getId_gestion() {
		return id_gestion;
	}

	public int getId_Client() {
		return id_Client;
	}

	public int getId_Vecule() {
		return id_Vecule;
	}

	public int getKelometragereture() {
		return Kelometragereture;
	}

	public String getEtatVheculeretouur() {
		return etatVheculeretouur;
	}

	public Date getDatelocation() {
		return datelocation;
	}

	public Date getDatederetour() {
		return datederetour;
	}

	public void setId_gestion(int id_gestion) {
		this.id_gestion = id_gestion;
	}

	public void setId_Client(int id_Client) {
		this.id_Client = id_Client;
	}

	public void setId_Vecule(int id_Vecule) {
		this.id_Vecule = id_Vecule;
	}

	public void setKelometragereture(int kelometragereture) {
		Kelometragereture = kelometragereture;
	}

	public void setEtatVheculeretouur(String etatVheculeretouur) {
		this.etatVheculeretouur = etatVheculeretouur;
	}

	public void setDatelocation(Date datelocation) {
		this.datelocation = datelocation;
	}

	public void setDatederetour(Date datederetour) {
		this.datederetour = datederetour;
	}

	@Override
	public String toString() {
		return " \n Gestion_location [id_gestion=" + id_gestion + ", id_Client=" + id_Client + ", id_Vecule=" + id_Vecule
				+ ", Kelometragereture=" + Kelometragereture + ", etatVheculeretouur=" + etatVheculeretouur
				+ ", datelocation=" + datelocation + ", datederetour=" + datederetour + "] \n ";
	}
	
	 
}
