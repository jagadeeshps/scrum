package co.edu.unal.scrum.client;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Viewport;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class LayoutView extends ViewImpl implements LayoutPresenter.MyView {

	public static final String VIEWPORT = "app-viewport";

	private Viewport viewport;

	private LayoutContainer layoutContainer;
	private BorderLayout layout;

	private ContentPanel northLayoutWidget;

	private Widget centerWidget;
	private Widget eastWidget;
	private Widget menuWidget;
	private Widget headerWidget;
	private Widget westWidget;
	private Widget southWidget;

	@Inject
	public LayoutView() {
		viewport = new Viewport();
		viewport.setId(VIEWPORT);
		viewport.setLayout(new FitLayout());

		layout = new BorderLayout();
		layoutContainer = new LayoutContainer();
		layoutContainer.setId("page-layout");
		layoutContainer.setLayout(layout);

		northLayoutWidget = new ContentPanel();
		northLayoutWidget.setId("page-layout-north");
		northLayoutWidget.setHeaderVisible(false);
		northLayoutWidget.setStyleAttribute("border-left", "0px");
		northLayoutWidget.setStyleAttribute("border-top", "0px");
		northLayoutWidget.setStyleAttribute("border-right", "0px");

		layoutContainer.add(northLayoutWidget, new BorderLayoutData(
				LayoutRegion.NORTH, 62));

		viewport.add(layoutContainer);
	}

	@Override
	public Widget asWidget() {
		return viewport;
	}

	@Override
	public void setInSlot(Object slot, Widget newContentWidget) {
		if (LayoutPresenter.TYPE_CENTER.equals(slot)) {
			setInSlotCenter(slot, newContentWidget);
		} else if (LayoutPresenter.TYPE_HEADER.equals(slot)) {
			setInSlotHeader(slot, newContentWidget);
		} else if (LayoutPresenter.TYPE_MENU.equals(slot)) {
			setInSlotMenu(slot, newContentWidget);
		} else if (LayoutPresenter.TYPE_SOUTH.equals(slot)) {
			setInSlotSouth(slot, newContentWidget);
		} else if (LayoutPresenter.TYPE_WEST.equals(slot)) {
			setInSlotWest(slot, newContentWidget);
		} else if (LayoutPresenter.TYPE_EAST.equals(slot)) {
			setInSlotEast(slot, newContentWidget);
		} else {
			super.setInSlot(slot, newContentWidget);
		}
		layoutContainer.layout();
	}

	protected void setInSlotCenter(Object slot, Widget newContentWidget) {
		BorderLayoutData centerLayoutData = new BorderLayoutData(
				LayoutRegion.CENTER);
		centerLayoutData.setMargins(new Margins(5));
		centerLayoutData.setSplit(true);
		centerLayoutData.setCollapsible(true);
		layoutContainer.remove(centerWidget);
		layoutContainer.add(newContentWidget, centerLayoutData);
		centerWidget = newContentWidget;
	}

	protected void setInSlotHeader(Object slot, Widget newContentWidget) {
		northLayoutWidget.remove(headerWidget);
		northLayoutWidget.add(newContentWidget);
		headerWidget = newContentWidget;
	}

	protected void setInSlotMenu(Object slot, Widget newContentWidget) {
		if (northLayoutWidget.isRendered() == false
				&& newContentWidget instanceof Component) {
			northLayoutWidget.remove(menuWidget);
			northLayoutWidget.setBottomComponent((Component) newContentWidget);
			menuWidget = newContentWidget;
		}
	}

	protected void setInSlotSouth(Object slot, Widget newContentWidget) {
		layoutContainer.remove(southWidget);
		layoutContainer.add(newContentWidget, new BorderLayoutData(
				LayoutRegion.SOUTH, 28));
		southWidget = newContentWidget;
	}

	protected void setInSlotWest(Object slot, Widget newContentWidget) {
		BorderLayoutData westLayoutData = new BorderLayoutData(
				LayoutRegion.WEST, 220);
		westLayoutData.setMargins(new Margins(5));
		westLayoutData.setSplit(true);
		westLayoutData.setCollapsible(true);
		layoutContainer.remove(westWidget);
		layoutContainer.add(newContentWidget, westLayoutData);
		westWidget = newContentWidget;
	}

	protected void setInSlotEast(Object slot, Widget newContentWidget) {
		layoutContainer.remove(eastWidget);
		BorderLayoutData eastLayoutData = new BorderLayoutData(
				LayoutRegion.EAST, 300);
		eastLayoutData.setMargins(new Margins(5));
		eastLayoutData.setSplit(true);
		eastLayoutData.setCollapsible(true);
		layoutContainer.add(newContentWidget, eastLayoutData);
		eastWidget = newContentWidget;
	}

}
