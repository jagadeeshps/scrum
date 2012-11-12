package co.edu.unal.scrum.client;

import co.edu.unal.scrum.client.resources.Resources;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class InicioView extends ViewImpl implements InicioPresenter.MyView {

	LayoutContainer panel;

	@Inject
	public InicioView(final Resources recursos) {
		panel = new LayoutContainer();
		panel.setLayout(new BorderLayout());

		ContentPanel cntntpnlScrumTool = new ContentPanel();
		cntntpnlScrumTool.setHeading("Scrum Tool");
		cntntpnlScrumTool.setLayout(new BorderLayout());
		Image im = new Image(recursos.scrum());
		cntntpnlScrumTool.add(im, new BorderLayoutData(LayoutRegion.CENTER));
		im.setSize("100%", "100%");
		panel.add(cntntpnlScrumTool, new BorderLayoutData(LayoutRegion.CENTER));
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
