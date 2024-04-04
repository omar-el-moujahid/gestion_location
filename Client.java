package gestion_Vehicules;

public class Client {
	private int id_client ;
	private String nome ;
	private String cne ;
	public Client(int id_client, String nome ,String cne ) {
		this.id_client = id_client;
		this.nome = nome;
		this.cne=cne;
	}
	public int getId() {
		return id_client;
	}
	
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getNome() {
		return nome;
	}
	public void setId(int id) {
		this.id_client = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return " \n Client [id_client =" + id_client + ", nome=" + nome +" cne "+ cne +  "] \n ";
	}
	
	

}
