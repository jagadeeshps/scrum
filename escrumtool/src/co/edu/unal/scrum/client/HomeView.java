package co.edu.unal.scrum.client;

import co.edu.unal.scrum.client.projects.ProjectsUiHandles;
import co.edu.unal.scrum.client.resources.Resources;

import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.extjs.gxt.ui.client.Style.ButtonArrowAlign;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.util.Margins;
import com.extjs.gxt.ui.client.widget.BoxComponent;
import com.extjs.gxt.ui.client.widget.Component;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.DatePicker;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;

public class HomeView extends ViewWithUiHandlers<ProjectsUiHandles> implements
		HomePresenter.MyView {

	private LayoutContainer panel;
	private LayoutContainer layoutContainer;

	@Inject
	public HomeView(final Resources resources) {
		panel = new LayoutContainer(new BorderLayout());
		panel.setBorders(true);
		panel.setId(HomeView.class.getName());
		
		ContentPanel panelP = new ContentPanel();
		panelP.setHeading("Projects");
		BorderLayoutData bld_panelP = new BorderLayoutData(LayoutRegion.WEST);
		bld_panelP.setCollapsible(true);
		bld_panelP.setSplit(true);

		ToolBar toolBar = new ToolBar();
		toolBar.setBorders(true);
		toolBar.setAutoWidth(true);
		toolBar.setAutoHeight(true);
		
		Button btnAdd = new Button("Add",AbstractImagePrototype.create(resources.iconAdd()));
		btnAdd.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				if (getUiHandlers() != null) {
					getUiHandlers().onAddButtonClicked();
				}
			}
		});
		toolBar.add(btnAdd);
		
		SeparatorToolItem separatorToolItem = new SeparatorToolItem();
		separatorToolItem.setBorders(true);
		toolBar.add(separatorToolItem);
		
		Button btnDelete = new Button("Delete",AbstractImagePrototype.create(resources.iconDelete()));
		toolBar.add(btnDelete);
		panelP.add(toolBar);
		
		layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FitLayout());
		layoutContainer.setBorders(true);

		panel.add(panelP, bld_panelP);
		panelP.setLayout(new FillLayout(Orientation.VERTICAL));
		panelP.setScrollMode(Scroll.AUTO);

		panel.add(layoutContainer, new BorderLayoutData(LayoutRegion.CENTER));
		
	}

	@Override
	public Widget asWidget() {
		return panel;
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		// TODO Auto-generated method stub
		if (slot == HomePresenter.TYPE_CENTER) {
			if (content != null) {
				layoutContainer.removeAll();
				layoutContainer.add(content);
			}
		
		} else {
			super.setInSlot(slot, content);
		}
	}

}
