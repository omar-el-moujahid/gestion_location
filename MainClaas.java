package gestion_Vehicules;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MainClaas {

	public static void main(String[] args) {
		Gestion_Agence_Location G = new Gestion_Agence_Location();
		Vehicules e = new Vehicules("WM","2000",2000,1);
		Vehicules e1 = new Vehicules("MErcides","2000",2000,2);
		Vehicules e2 = new Vehicules("fiat","2000",2000,3);
		Vehicules e3 = new Vehicules("clio","2000",2000,4);
		Vehicules modi = new Vehicules("rono","2000",2000,5);
		Client c1 = new Client(1, "omar", "N147000524");
		Client c2 = new Client(2, "ayoub", "N147321524");
		Client c3 = new Client(3, "mohemed", "N147130524");
		Client c4 = new Client(4, "test", "test");
		Gestion_location g1 = new Gestion_location(1,c1.getId(),e.getId() );
		Gestion_location g2 = new Gestion_location(2,c2.getId(),e1.getId() );
		Gestion_location g3 = new Gestion_location(3,c3.getId(),e3.getId() );
		Gestion_location g4 = new Gestion_location(4,c3.getId(),e.getId() );
		Gestion_location g5 = new Gestion_location(5,c1.getId(),e3.getId() );
		Gestion_location g6 = new Gestion_location(6,c2.getId(),e2.getId() );
		Gestion_location g7 = new Gestion_location(7,c3.getId(),e1.getId() );
		Gestion_location g8 = new Gestion_location(8,c3.getId(),e2.getId() );
		Gestion_location g9 = new Gestion_location(9,c2.getId(),e2.getId() );
//		G.ajouter_vehicule(e);
//		G.ajouter_vehicule(e1);
//		G.ajouter_vehicule(e2);
//		G.ajouter_vehicule(e3);
//		c.ajouter_vehicule(e3);
//		c.suprrimer_vehicule(e.getId());
//		c.modifier_vehicule(2,modi);
//		c.chercher_vehicule("Dacia", "2000", 2000);
//		G.ajouter_client(c1);
//		G.ajouter_client(c2);
//		G.ajouter_client(c3);
//		G.ajouter_client(c4);
//		G.suprrimer_client(c4);
//		G.modifier_client(c4, c3);
//		G.chercher_client("omar", "N147000524", 1);
//		G.afficher_tous_client();
//		G.afficher_tous_vehicule();
//		G.ajouter_Location(g1);
//		G.ajouter_Location(g2);
//		G.ajouter_Location(g3);
//		G.ajouter_Location(g4);
//		G.ajouter_Location(g5);
//		G.ajouter_Location(g6);
//		G.ajouter_Location(g7);
//		G.ajouter_Location(g8);
//		G.ajouter_Location(g9);
//		G.suprimer_Location(g9);
//		G.modifier_Location(g9, g8);
//		G.chercher_Location_vehicule_emprunter(e.getId());
//		G.chercher_Location_vehicule_emprunter(c1.getId());
//		G.chercher_Location(g9.getId_gestion());
//		G.chercher_Location_client_emprunter_par_nome("omar");
//		G.chercher_Location_vehicule_emprunter_par_nome("clio");
//		G.afficher_vehicules_loues();
//		LocalDateTime date_retour = LocalDateTime.now();
		G.cloture_location(g9);
	}


}
