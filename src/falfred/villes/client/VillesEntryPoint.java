package falfred.villes.client;

import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import falfred.villes.shared.Ville;

public class VillesEntryPoint implements EntryPoint {

	private final VillesServiceAsync service = GWT.create(VillesService.class);
	private VerticalPanel vPanel = new VerticalPanel();
	
	
	@Override
	public void onModuleLoad() {
		Button showAllButton = new Button("All");
		RootPanel.get("menu").add(showAllButton);
		showAllButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showAll();				
			}
		});
		
		final TextBox cpBox = new TextBox();
		RootPanel.get("menu").add(cpBox);
		Button showByCPButton = new Button("Go");
		RootPanel.get("menu").add(showByCPButton);
		showByCPButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showByCP(cpBox.getText());				
			}
		});
		
		Button clearButton = new Button("Clear");
		RootPanel.get("menu").add(clearButton);
		clearButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				vPanel.clear();
			}
		});
	}
	
	public void showAll() {
		vPanel.clear();
		service.getAllVilles(new AsyncCallback<List<Ville>>() {
			@Override
			public void onSuccess(List<Ville> result) {
				for(Ville v : result) {
					HorizontalPanel hPanel = new HorizontalPanel();
					Label villeNom = new Label(v.getVille());
					hPanel.add(villeNom);
					vPanel.add(hPanel);
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				vPanel.add(new Label("ERROR"));
			}
		});
		RootPanel.get("display").add(vPanel);
	}
	
	public void showByCP(String cp) {
		vPanel.clear();
		service.getVillesByCodePostal(cp, new AsyncCallback<List<Ville>>() {
			@Override
			public void onSuccess(List<Ville> result) {
				for(Ville v : result) {
					HorizontalPanel hPanel = new HorizontalPanel();
//					Label villeCP = new Label(v.getCode_postal());
//					hPanel.add(villeCP);
//					Label villeNom = new Label(v.getVille());
//					hPanel.add(villeNom);
//					hPanel.setSpacing(10);
					Label ville = new Label(v.toString());
					hPanel.add(ville);
					vPanel.add(hPanel);
				}
			}
			@Override
			public void onFailure(Throwable caught) {
				vPanel.add(new Label("ERROR"));
			}
		});
		RootPanel.get("display").add(vPanel);
	}

}
