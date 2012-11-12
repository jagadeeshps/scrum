package co.edu.unal.scrum.client.header;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class HeaderView extends ViewImpl implements HeaderPresenter.MyView {
	private final FlowPanel headerPanel;

	@Inject
	public HeaderView() {
		headerPanel = new FlowPanel();
		headerPanel.setStyleName("header");
		headerPanel.setSize("450", "300");

		FlowPanel headerTittle = new FlowPanel();
		headerTittle.setStyleName("headerT");
		headerTittle.getElement().setInnerText("e-Scrum Tool");
		headerPanel.add(headerTittle);
		headerTittle.setSize("450", "18");
	}

	@Override
	public Widget asWidget() {
		return headerPanel;
	}
}
