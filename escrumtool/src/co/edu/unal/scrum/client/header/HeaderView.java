package co.edu.unal.scrum.client.header;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.user.client.ui.Label;
import co.edu.unal.scrum.client.resources.AppConstants;
import com.google.gwt.core.client.GWT;

public class HeaderView extends ViewImpl implements HeaderPresenter.MyView {
	private static final AppConstants CONSTANTS = GWT.create(AppConstants.class);
	private final FlowPanel headerPanel;

	@Inject
	public HeaderView() {
		headerPanel = new FlowPanel();
		headerPanel.setStyleName("header");
		headerPanel.setSize("450", "300");

		FlowPanel headerTittle = new FlowPanel();
		headerTittle.setStyleName("headerT");
		headerPanel.add(headerTittle);
		headerTittle.setSize("450", "18");
		
		Label lblEscrumTool = new Label(CONSTANTS.lblEscrumTool_text());
		headerTittle.add(lblEscrumTool);
	}

	@Override
	public Widget asWidget() {
		return headerPanel;
	}
}
