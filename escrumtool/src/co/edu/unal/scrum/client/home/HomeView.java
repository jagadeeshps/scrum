package co.edu.unal.scrum.client.home;

import co.edu.unal.scrum.client.projects.ProjectsUiHandles;
import co.edu.unal.scrum.client.resources.Resources;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillData;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class HomeView extends ViewWithUiHandlers<ProjectsUiHandles> implements
		HomePresenter.MyView {

	private LayoutContainer panel;
	private LayoutContainer layoutContainer;
	private ContentPanel panelP;
	private SimpleComboBox<String> smplcmbxNewSimplecombobox;

	@Inject
	public HomeView(final Resources resources) {
		panel = new LayoutContainer(new BorderLayout());
		panel.setBorders(true);
		panel.setId(HomeView.class.getName());

		panelP = new ContentPanel();
		panelP.setScrollMode(Scroll.AUTO);
		panelP.setHeading("Projects");
		BorderLayoutData bld_panelP = new BorderLayoutData(LayoutRegion.WEST,
				305.0f);
		bld_panelP.setCollapsible(true);

		Button btnAdd = new Button("New Project",
				AbstractImagePrototype.create(resources.iconAdd()));
		btnAdd.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				if (getUiHandlers() != null) {
					getUiHandlers().onAddButtonClicked();
				}
			}
		});
		panelP.addButton(btnAdd);
		layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FitLayout());
		layoutContainer.setBorders(true);

		panel.add(panelP, bld_panelP);

		smplcmbxNewSimplecombobox = new SimpleComboBox<String>();
		smplcmbxNewSimplecombobox.setEmptyText("Search by Project Name");
		panelP.getButtonBar().add(smplcmbxNewSimplecombobox);
		smplcmbxNewSimplecombobox.setFieldLabel("New SimpleComboBox");
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

		} else if (slot == HomePresenter.List_Slot) {
			panelP.removeAll();
			if (content != null) {

				panelP.add(content);
			}
		} else {
			super.setInSlot(slot, content);
		}
	}

	@Override
	public void addToSlot(Object slot, Widget content) {
		if (slot == HomePresenter.List_Slot) {

			if (content != null) {

				panelP.add(content, new FillData());

			}
		}

		else {
			super.addToSlot(slot, content);
		}
	}

	public LayoutContainer getPanel() {
		return panel;
	}

	public ContentPanel getPanelP() {
		return panelP;
	}
	public SimpleComboBox<String> getSmplcmbxNewSimplecombobox() {
		return smplcmbxNewSimplecombobox;
	}
}
