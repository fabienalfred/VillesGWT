package falfred.villes.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import falfred.villes.shared.Ville;

@RemoteServiceRelativePath("VillesService")
public interface VillesService extends RemoteService {
	List<Ville> getAllVilles();
}
