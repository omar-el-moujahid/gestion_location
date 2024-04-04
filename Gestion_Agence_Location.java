package gestion_Vehicules;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Gestion_Agence_Location {
	private String user ="root";
	private String password ="root";
	private String url ="jdbc:mysql://localhost:8889/Gestion_Vehicule";
	Connection Myconnection ;
	
	
	public Gestion_Agence_Location() {
//        try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			try {
//				Myconnection = DriverManager.getConnection(url, user, password);
//			} catch (SQLException e) {
//				System.out.println("p1");
//				e.printStackTrace();
//			}
//			System.out.println("connection secsufly");
//			
//		} catch (ClassNotFoundException e) {
//			System.out.println("p2");
//			e.printStackTrace();
//		}
		
		try {
			Myconnection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("p1");
			e.printStackTrace();
		}
	}	
	
	public void ajouter_vehicule(Vehicules vehicules) {
		String requet="INSERT INTO Vehicules (marque , modele , anee , id_Vehicules) VALUES (?,?,?,?) " ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setString(1,vehicules.getMarque() );
			pr.setString(2,vehicules.getModele() );
			pr.setInt(3,vehicules.getAnee() );
			pr.setInt(4,vehicules.getId() );
			pr.executeUpdate();
			System.out.println("added to the databasse successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void ajouter_client(Client c) {
		String requet="INSERT INTO client (id_client , nome , cne ) VALUES (?,?,?) " ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setInt(1,c.getId() );
			pr.setString(2,c.getNome() );
			pr.setString(3,c.getCne() );
			pr.executeUpdate();
			System.out.println("added to the databasse successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void ajouter_Location( Gestion_location g ) {
		String requet="INSERT INTO Gestion_location (id_gestion	 , id_Client , id_Vecule ) VALUES (?,?,?) " ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setInt(1,g.getId_gestion() );
			pr.setInt(2, g.getId_Client());
			pr.setInt(3, g.getId_Vecule());
			pr.executeUpdate();
			System.out.println("added to the databasse successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void suprrimer_vehicule( int id) {
		String requet="DELETE FROM Vehicules WHERE id_Vehicules=?" ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setInt(1,id);
			pr.executeUpdate();
			System.out.println("Dleted from the databasse successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void suprrimer_client( Client c ) {
		String requet="DELETE FROM client WHERE id_client=?" ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setInt(1,c.getId());
			pr.executeUpdate();
			System.out.println("Dleted from the databasse successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void suprimer_Location( Gestion_location g ) {
		String requet="DELETE FROM Gestion_location  WHERE id_gestion = ? " ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setInt(1,g.getId_gestion() );
			pr.executeUpdate();
			System.out.println("DELETE From the databasse successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modifier_vehicule( int id , Vehicules neww) {
		String requet="UPDATE Vehicules SET marque =? , modele=? , anee=?  WHERE id_Vehicules=?" ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setString(1,neww.getMarque() );
			pr.setString(2,neww.getModele() );
			pr.setInt(3,neww.getAnee() );
			pr.setInt(4,id);
			pr.executeUpdate();
			System.out.println("Modifie from the databasse successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void modifier_client( Client prev , Client next) {
		String requet="UPDATE client SET nome =? , cne=?  WHERE id_client=?" ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setString(1,next.getNome() );
			pr.setString(2,next.getCne() );
			pr.setInt(3,prev.getId());
			pr.executeUpdate();
			System.out.println("Modifie from the databasse successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void modifier_Location( Gestion_location prev , Gestion_location next) {
		String requet="UPDATE Gestion_location SET id_Client =? , id_Vecule=?  WHERE id_gestion=?" ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setInt(1,next.getId_Client() );
			pr.setInt(2,next.getId_Vecule() );
			pr.setInt(3,prev.getId_gestion());
			pr.executeUpdate();
			System.out.println("Modifie from the databasse successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void chercher_vehicule( String marque , String modele , int anee) {
		
		String requet="SELECT * From  Vehicules  WHERE marque=? AND modele=? AND anee=?  " ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setString(1,marque );
			pr.setString(2, modele);
			pr.setInt(3,anee );			
			ResultSet r = pr.executeQuery();
			while(r.next()) {
				Vehicules v = new Vehicules(r.getString("marque"), r.getString("modele"), r.getInt("anee"), r.getInt("anee"));
				System.out.println(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void chercher_client( String nome , String cne , int id) {
			
			String requet="SELECT * From  client  WHERE id_client=? AND nome=? AND cne=?  " ;
			try {
				PreparedStatement pr = Myconnection.prepareStatement(requet);
				pr.setString(2,nome );
				pr.setString(3, cne);
				pr.setInt(1,id );			
				ResultSet r = pr.executeQuery();
				while(r.next()) {
					Client v = new Client(r.getInt("id_client"), r.getString("nome"), r.getString("cne"));
					System.out.println(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	public void chercher_Location_vehicule_emprunter(  int id_vehicule) {
			
			String requet="SELECT * From  Gestion_location  WHERE id_Vecule=? ";
			try {
				PreparedStatement pr = Myconnection.prepareStatement(requet);
				pr.setInt(1,id_vehicule );			
				ResultSet r = pr.executeQuery();
				while(r.next()) {
					Gestion_location v = new Gestion_location(r.getInt("id_gestion"), r.getInt("id_Client"), r.getInt("id_Vecule"), r.getInt("Kelometragereture")
							, r.getString("etatVheculeretouur") , r.getDate("datelocation") , r.getDate("datederetour") );
					System.out.println(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	public void chercher_Location_client_emprunter(  int id_client) {
		
		String requet="SELECT * From  Gestion_location  WHERE id_Client=? ";
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);
			pr.setInt(1,id_client );			
			ResultSet r = pr.executeQuery();
			while(r.next()) {
				Gestion_location v = new Gestion_location(r.getInt("id_gestion"), r.getInt("id_Client"), r.getInt("id_Vecule"), r.getInt("Kelometragereture")
						, r.getString("etatVheculeretouur") , r.getDate("datelocation") , r.getDate("datederetour") );
				System.out.println(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//public void chercher_Location_client_emprunter_by_name( String name ) {
//		
//		String requet="SELECT * From Gestion_location WHERE id_Client in ( SELECT id_client From client WHERE nome=? );" ;
//		try {
//			PreparedStatement pr = Myconnection.prepareStatement(requet);
//			pr.setString(1,name );			
//			ResultSet r = pr.executeQuery();
//			while(r.next()) {
//				Gestion_location v = new Gestion_location(r.getInt("id_gestion"), r.getInt("id_Client"), r.getInt("id_Vecule"), r.getInt("Kelometragereture")
//						, r.getString("etatVheculeretouur") , r.getDate("datelocation") , r.getDate("datederetour") );
//				String requet_clent=" SELECT id_client From client WHERE id_Client=? ;" ;
//				
//				try {
//					 pr = Myconnection.prepareStatement(requet_clent);
//					pr.setInt(1,v.getId_Client() );			
//					ResultSet r2 = pr.executeQuery();
//					while(r.next()) {
//						Client v2 = new Client(r2.getInt("id_client"), r2.getString("nome"), r2.getString("cne"));
//						System.out.println(v2);
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				 
//				
//				System.out.println( "emprunte ");
//				
//				
//				
//				String requet_vehicule="SELECT * From  Vehicules  WHERE id_Vehicules=?  " ;
//				try {
//					 pr = Myconnection.prepareStatement(requet_vehicule);
//					pr.setInt(1,v.getId_Vecule() );			
//					ResultSet r3 = pr.executeQuery();
//					while(r.next()) {
//						Vehicules v3 = new Vehicules(r3.getString("marque"), r3.getString("modele"), r3.getInt("anee"), r3.getInt("id_Vehicules"));
//						System.out.println(v3);
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//
//				System.out.println(v);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void chercher_Location_client_emprunter_par_nome(String name) {
	    String requet = "SELECT * FROM Gestion_location WHERE id_Client IN (SELECT id_client FROM client WHERE nome = ?)";
	    try {
	        PreparedStatement pr = Myconnection.prepareStatement(requet);
	        pr.setString(1, name);
	        ResultSet r = pr.executeQuery();
	        while (r.next()) {
	            Gestion_location v = new Gestion_location(r.getInt("id_gestion"), r.getInt("id_Client"), r.getInt("id_Vecule"), r.getInt("Kelometragereture"),
	                    r.getString("etatVheculeretouur"), r.getDate("datelocation"), r.getDate("datederetour"));

	            // Affichage des informations sur le client
	            String requet_client = "SELECT * FROM client WHERE id_client = ?";
	            try {
	                pr = Myconnection.prepareStatement(requet_client);
	                pr.setInt(1, v.getId_Client());
	                ResultSet r2 = pr.executeQuery();
	                while (r2.next()) {
	                    Client client = new Client(r2.getInt("id_client"), r2.getString("nome"), r2.getString("cne"));
	                    System.out.println("Client: " + client);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            // Affichage des informations sur le véhicule
	            String requet_vehicule = "SELECT * FROM Vehicules WHERE id_Vehicules = ?";
	            try {
	                pr = Myconnection.prepareStatement(requet_vehicule);
	                pr.setInt(1, v.getId_Vecule());
	                ResultSet r3 = pr.executeQuery();
	                while (r3.next()) {
	                    Vehicules vehicule = new Vehicules(r3.getString("marque"), r3.getString("modele"), r3.getInt("anee"), r3.getInt("id_Vehicules"));
	                    System.out.println("Véhicule: " + vehicule);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            // Affichage des informations sur la location
	            System.out.println("Location: " + v);
	            System.out.println("----------");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void chercher_Location_vehicule_emprunter_par_nome(String marque) {
	    String requet = "SELECT * FROM Gestion_location WHERE id_Vecule IN (SELECT id_Vehicules FROM Vehicules WHERE marque = ?)";
	    try {
	        PreparedStatement pr = Myconnection.prepareStatement(requet);
	        pr.setString(1, marque);
	        ResultSet r = pr.executeQuery();
	        while (r.next()) {
	            Gestion_location v = new Gestion_location(r.getInt("id_gestion"), r.getInt("id_Client"), r.getInt("id_Vecule"), r.getInt("Kelometragereture"),
	                    r.getString("etatVheculeretouur"), r.getDate("datelocation"), r.getDate("datederetour"));

	            // Affichage des informations sur le client
	            String requet_client = "SELECT * FROM client WHERE id_client = ?";
	            try {
	                pr = Myconnection.prepareStatement(requet_client);
	                pr.setInt(1, v.getId_Client());
	                ResultSet r2 = pr.executeQuery();
	                while (r2.next()) {
	                    Client client = new Client(r2.getInt("id_client"), r2.getString("nome"), r2.getString("cne"));
	                    System.out.println("Client: " + client);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            // Affichage des informations sur le véhicule
	            String requet_vehicule = "SELECT * FROM Vehicules WHERE id_Vehicules = ?";
	            try {
	                pr = Myconnection.prepareStatement(requet_vehicule);
	                pr.setInt(1, v.getId_Vecule());
	                ResultSet r3 = pr.executeQuery();
	                while (r3.next()) {
	                    Vehicules vehicule = new Vehicules(r3.getString("marque"), r3.getString("modele"), r3.getInt("anee"), r3.getInt("id_Vehicules"));
	                    System.out.println("Véhicule: " + vehicule);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            // Affichage des informations sur la location
	            System.out.println("Location: " + v);
	            System.out.println("----------");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public void chercher_Location(  int id_gestion) {
			
			String requet="SELECT * From  Gestion_location  WHERE id_gestion=? ";
			try {
				PreparedStatement pr = Myconnection.prepareStatement(requet);
				pr.setInt(1,id_gestion );			
				ResultSet r = pr.executeQuery();
				while(r.next()) {
					Gestion_location v = new Gestion_location(r.getInt("id_gestion"), r.getInt("id_Client"), r.getInt("id_Vecule"), r.getInt("Kelometragereture")
							, r.getString("etatVheculeretouur") , r.getDate("datelocation") , r.getDate("datederetour") );
					System.out.println(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	public void afficher_tous_client() {
		
		String requet="SELECT * From  client " ;
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requet);		
			ResultSet r = pr.executeQuery();
			while(r.next()) {
				Client v = new Client(r.getInt("id_client"), r.getString("nome"), r.getString("cne"));
				System.out.println(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void afficher_tous_vehicule() {
			
			String requet="SELECT * From  Vehicules " ;
			try {
				PreparedStatement pr = Myconnection.prepareStatement(requet);		
				ResultSet r = pr.executeQuery();
				while(r.next()) {
					Vehicules v = new Vehicules(r.getString("marque"), r.getString("modele"), r.getInt("anee"), r.getInt("id_Vehicules"));
					System.out.println(v);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	public void afficher_vehicules_loues( ) {
	    String requet = "SELECT * FROM Gestion_location ;";
	    try {
	        PreparedStatement pr = Myconnection.prepareStatement(requet);
	        ResultSet r = pr.executeQuery();
	        while (r.next()) {
	            Gestion_location v = new Gestion_location(r.getInt("id_gestion"), r.getInt("id_Client"), r.getInt("id_Vecule"), r.getInt("Kelometragereture"),
	                    r.getString("etatVheculeretouur"), r.getDate("datelocation"), r.getDate("datederetour"));

	            // Affichage des informations sur le client
	            String requet_client = "SELECT * FROM client WHERE id_client = ?";
	            try {
	                pr = Myconnection.prepareStatement(requet_client);
	                pr.setInt(1, v.getId_Client());
	                ResultSet r2 = pr.executeQuery();
	                while (r2.next()) {
	                    Client client = new Client(r2.getInt("id_client"), r2.getString("nome"), r2.getString("cne"));
	                    System.out.println("Client: " + client);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            // Affichage des informations sur le véhicule
	            String requet_vehicule = "SELECT * FROM Vehicules WHERE id_Vehicules = ?";
	            try {
	                pr = Myconnection.prepareStatement(requet_vehicule);
	                pr.setInt(1, v.getId_Vecule());
	                ResultSet r3 = pr.executeQuery();
	                while (r3.next()) {
	                    Vehicules vehicule = new Vehicules(r3.getString("marque"), r3.getString("modele"), r3.getInt("anee"), r3.getInt("id_Vehicules"));
	                    System.out.println("Véhicule: " + vehicule);
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }

	            // Affichage des informations sur la location
	            System.out.println("Location: " + v);
	            System.out.println("----------");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void cloture_location(Gestion_location g) {
		Scanner sc = new Scanner( System.in);
		System.out.println("entrez l etat de vehicule ");
		String etatvehicole = sc.nextLine() ;
		Date date_reture = new Date();
		System.out.println("entrez Kelometragereture de vehicule ");
		int Kelometragereture = sc.nextInt() ;
		String requist = "UPDATE Gestion_location SET Kelometragereture = ? , etatVheculeretouur=? , datederetour=? WHERE id_gestion =? ";
		try {
			PreparedStatement pr = Myconnection.prepareStatement(requist);
			pr.setInt(1, Kelometragereture);
			pr.setString(2, etatvehicole);
			pr.setDate(3, new java.sql.Date(date_reture.getTime()));
			pr.setInt(4, g.getId_gestion());
			int rowsAffected = pr.executeUpdate(); // Utiliser executeUpdate() pour les requêtes de mise à jour
	        System.out.println(rowsAffected + " lignes mises à jour");
		}catch(SQLException e) {
	        e.printStackTrace();
		}
	}
}
