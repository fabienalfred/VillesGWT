package falfred.villes.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import falfred.villes.shared.Ville;

public interface VillesServiceAsync {
	void getAllVilles(AsyncCallback<List<Ville>> callback);
	void getVillesByCodePostal(String cp, AsyncCallback<List<Ville>> callback);
}
