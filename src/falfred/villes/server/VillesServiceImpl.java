package falfred.villes.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import falfred.villes.client.VillesService;
import falfred.villes.shared.Ville;

public class VillesServiceImpl extends RemoteServiceServlet implements VillesService {

	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	
	@Override
	public List<Ville> getAllVilles() {
		connect();
		List<Ville> villes = new ArrayList<>();
		String query = "SELECT * FROM villes";
		try {
			PreparedStatement pstat = this.conn.prepareStatement(query);
			ResultSet rs = pstat.executeQuery();
			villes = fillVillesList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
		return villes;		
	}
	
	@Override
	public List<Ville> getVillesByCodePostal(String cp) {
		connect();
		List<Ville> villes = new ArrayList<>();
		String query = "SELECT * FROM villes WHERE code_postal LIKE ? ORDER BY code_postal";
		try {
			PreparedStatement pstat = this.conn.prepareStatement(query);
			pstat.setString(1, cp+"%");
			ResultSet rs = pstat.executeQuery();
			villes = fillVillesList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
		return villes;
	}
	
	public List<Ville> fillVillesList(ResultSet rs) {
		List<Ville> villes = new ArrayList<>();
		try {
			while(rs.next()) {
				Ville v = new Ville();
				v.setkp_ville(rs.getInt(1));
				v.setRegion(rs.getString(2));
				v.setDepartement(rs.getString(3));
				v.setVille(rs.getString(4));
				v.setCode_postal(rs.getString(5));
				v.setLat(rs.getDouble(6));
				v.setLng(rs.getDouble(7));
				villes.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}
	
	public void connect() {
		this.conn = BDD.connect();
	}
	
	public void disconnect() {
		BDD.disconnect(this.conn);
	}
	
}
