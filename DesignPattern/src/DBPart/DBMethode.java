package DBPart;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Model.Membre;
import Model.MembreDao;

public class DBMethode implements MembreDao{

	static Connection con = SingeletonDBConnection.getConnection();

	@Override
	public int ajouter(String iD, String nomComplet, String specialite,int age ,String phone, String addresse,String dateDebut, String dateFin,InputStream fileImage) throws SQLException {
		String query = "INSERT INTO `membre`(`ID_Etudiant`, `nomComplet`, `specialite`, `age`, `phone`, `addresse`, `dateDebut`, `dateFin`, `image`) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
    PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);

    ps.setString(1, iD);
    ps.setString(2, nomComplet);
    ps.setString(3, specialite);
    ps.setInt(4, age);
    ps.setString(5, phone);
    ps.setString(6, addresse);
    ps.setString(7, dateDebut);
    ps.setString(8, dateFin);
    ps.setBlob(9, fileImage);
    int n = ps.executeUpdate();
    return n;
	}

	@Override
	public ResultSet getMembre(String id_Etud) throws SQLException {
		ResultSet rs = null ;

		String query = "SELECT * FROM `membre` WHERE `ID_Etudiant`";
    PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);

    ps.setString(1, id_Etud);
    rs = ps.executeQuery(query);
	if(rs.next()) {
	    return rs;
	} else {
		rs =null;
	}
        return rs;
	}
}
