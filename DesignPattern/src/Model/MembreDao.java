package Model;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Membre.MemberBuilder;

public interface MembreDao {
	public int ajouter(String iD, String nomComplet, String specialite,int age ,String phone, String addresse,String dateDebut, String dateFin,InputStream fileImage) throws SQLException ;
	   public ResultSet getMembre(String id_etu) throws SQLException;
}
