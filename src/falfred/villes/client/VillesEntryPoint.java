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
import com.google.gwt.user.client.ui.VerticalPanel;

import falfred.villes.shared.Ville;

public class VillesEntryPoint implements EntryPoint {

	private final VillesServiceAsync service = GWT.create(VillesService.class);
	private VerticalPanel vPanel = new VerticalPanel();
	
	
	@Override
	public void onModuleLoad() {
		Button showAllButton = new Button("All");
		RootPanel.get("container").add(showAllButton);
		showAllButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				showAll();				
			}
		});
		Button clearButton = new Button("Clear");
		RootPanel.get("display").add(clearButton);
		clearButton.addClickHandler(new ClickHandler() {			
			@Override
			public void onClick(ClickEvent event) {
				vPanel.clear();
			}
		});
	}
	
	public void showAll() {
		service.getAllVilles(new AsyncCallback<List<Ville>>() {
			
			@Override
			public void onSuccess(List<Ville> result) {
				vPanel.clear();
				for(Ville v : result) {
					HorizontalPanel hPanel = new HorizontalPanel();
					Label region = new Label(v.getRegion());
					hPanel.add(region);
					vPanel.add(hPanel);
				}
				RootPanel.get("display").add(vPanel);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				RootPanel.get("display").add(new Label("ERROR"));
			}
		});
	}

}
