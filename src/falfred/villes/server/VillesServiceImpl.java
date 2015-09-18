package falfred.villes.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import falfred.villes.client.VillesService;
import falfred.villes.shared.Ville;

public class VillesServiceImpl extends RemoteServiceServlet implements VillesService {

	private VillesDAO dao = null;
	
	@Override
	public List<Ville> getAllVilles() {
		return dao.getAllVilles();
	}

}
