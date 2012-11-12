package co.edu.unal.scrum.client;

import java.util.Arrays;

import co.edu.unal.scrum.client.resources.Resources;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Text;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class WallView extends ViewImpl implements WallPresenter.MyView {
	private LayoutContainer panel;
	private LayoutContainer layoutContainer;
	private SimpleComboBox<String> combo;

	@Inject
	public WallView(final Resources resources) {
		panel = new LayoutContainer(new BorderLayout());
		panel.setBorders(true);
		panel.setId(HomeView.class.getName());
		
		ContentPanel panelP = new ContentPanel();
		panelP.setHeading("Scrum Wall");
		BorderLayoutData bld_panelP = new BorderLayoutData(LayoutRegion.NORTH, 55.0f);
		bld_panelP.setCollapsible(true);
		bld_panelP.setSplit(true);
		panelP.setSize("100%", "100%");

		ToolBar toolBar = new ToolBar();
		toolBar.setBorders(true);
		toolBar.setAutoWidth(true);
		toolBar.setAutoHeight(true);
		
		Button btnAdd = new Button("Add task",AbstractImagePrototype.create(resources.iconAdd()));

	
		toolBar.add(btnAdd);
		
		SeparatorToolItem separatorToolItem = new SeparatorToolItem();
		separatorToolItem.setBorders(true);
		toolBar.add(separatorToolItem);
		
		Button btnDelete = new Button("Add Sprint",AbstractImagePrototype.create(resources.sprint()));
		toolBar.add(btnDelete);
 combo=new SimpleComboBox<String>();
		combo.setEmptyText("Select a Sprint");
		SeparatorToolItem separatorToolItem_1 = new SeparatorToolItem();
		separatorToolItem_1.setBorders(true);
		toolBar.add(separatorToolItem_1);
		
		Text txtSprint = new Text("Sprints  ");
		toolBar.add(txtSprint);
		toolBar.add(combo);

		panelP.add(toolBar);
		
		layoutContainer = new LayoutContainer();
		layoutContainer.setBorders(true);

		panel.add(panelP, bld_panelP);
		panelP.setLayout(new FillLayout(Orientation.VERTICAL));
		layoutContainer.setLayout(new FillLayout(Orientation.HORIZONTAL));
		
		ContentPanel cntntpnlNewContentpanel = new ContentPanel();
		cntntpnlNewContentpanel.setHeading("To Do");
		cntntpnlNewContentpanel.setCollapsible(true);
		cntntpnlNewContentpanel.setLayout(new FillLayout(Orientation.VERTICAL));
		layoutContainer.add(cntntpnlNewContentpanel);
		
		ContentPanel cntntpnlNewContentpanel_1 = new ContentPanel();
		cntntpnlNewContentpanel_1.setHeading("In Process");
		cntntpnlNewContentpanel_1.setCollapsible(true);
		cntntpnlNewContentpanel_1.setLayout(new FillLayout(Orientation.VERTICAL));
		layoutContainer.add(cntntpnlNewContentpanel_1);
		
		ContentPanel cntntpnlNewContentpanel_2 = new ContentPanel();
		cntntpnlNewContentpanel_2.setHeading("To Verify");
		cntntpnlNewContentpanel_2.setCollapsible(true);
		cntntpnlNewContentpanel_2.setLayout(new FillLayout(Orientation.VERTICAL));
		layoutContainer.add(cntntpnlNewContentpanel_2);
		
		ContentPanel cntntpnlNewContentpanel_3 = new ContentPanel();
		cntntpnlNewContentpanel_3.setHeading("Done");
		cntntpnlNewContentpanel_3.setCollapsible(true);
		cntntpnlNewContentpanel_3.setLayout(new FillLayout(Orientation.VERTICAL));
		layoutContainer.add(cntntpnlNewContentpanel_3);

		panel.add(layoutContainer, new BorderLayoutData(LayoutRegion.CENTER));
		}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
