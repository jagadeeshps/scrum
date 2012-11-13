package co.edu.unal.scrum.client.projects.widgets;

import co.edu.unal.scrum.client.resources.AppConstants;
import co.edu.unal.scrum.client.resources.Resources;
import co.edu.unal.scrum.shared.model.Project;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;

public class ProjectView extends ViewWithUiHandlers<ProjectViewUiHandlers>
		implements ProjectPresenter.MyView {
	private static final AppConstants CONSTANTS = GWT
			.create(AppConstants.class);

	private Project p;
	private ContentPanel panelP;
	private ToolBar toolBar;
	private LayoutContainer layoutContainer;
	private Button btnSelect;
	private SeparatorToolItem separatorToolItem_2;
	private FormPanel formPanel;
	private TextField<String> txtfldProjectName;
	private DateField dtfldNewDatefield;
	private DateField dtfldEndDate;
	private TextField<String> txtfldProjectStatus;

	@Inject
	public ProjectView(final Resources resource) {

		panelP = new ContentPanel();
		panelP.setSize("285px", "250px");
		panelP.setHeaderVisible(false);
		panelP.setBorders(true);

		toolBar = new ToolBar();
		toolBar.setSpacing(1);

		Button btnAdd = new Button(CONSTANTS.btnAdd_text(),
				AbstractImagePrototype.create(resource.detailsIcon()));
		btnAdd.setBorders(true);
		btnAdd.setMenuAlign("b-b?");

		SeparatorToolItem separatorToolItem = new SeparatorToolItem();
		separatorToolItem.setBorders(true);

		Button btnDelete = new Button(CONSTANTS.btnDelete_text(),
				AbstractImagePrototype.create(resource.iconDelete()));
		btnDelete.setMenuAlign("b-b?");
		btnDelete.setBorders(true);

		separatorToolItem_2 = new SeparatorToolItem();
		separatorToolItem_2.setBorders(true);
		toolBar.add(separatorToolItem_2);

		btnSelect = new Button(CONSTANTS.btnSelect_text(),
				AbstractImagePrototype.create(resource.iconAccept()));
		btnSelect.setMenuAlign("b-b?");
		btnSelect.setBorders(true);
		BorderLayoutData bld_toolBar = new BorderLayoutData(LayoutRegion.SOUTH,
				30.0f);
		bld_toolBar.setSplit(true);
		panelP.setLayout(new BorderLayout());
		panelP.addButton(btnAdd);
		panelP.addButton(btnDelete);
		panelP.addButton(btnSelect);
		panelP.setButtonAlign(HorizontalAlignment.LEFT);

		formPanel = new FormPanel();
		formPanel.setReadOnly(true);
		formPanel.setLabelAlign(LabelAlign.TOP);
		formPanel.setBorders(true);
		FormLayout formLayout = new FormLayout();
		formLayout.setLabelAlign(LabelAlign.TOP);

		txtfldProjectName = new TextField<String>();
		txtfldProjectName.setReadOnly(true);
		formPanel.add(txtfldProjectName,
				new FormData(CONSTANTS.other_anchorSpec_3()));
		txtfldProjectName.setFieldLabel(CONSTANTS
				.txtfldProjectName_fieldLabel_2());

		dtfldNewDatefield = new DateField();
		dtfldNewDatefield.setReadOnly(true);
		formPanel.add(dtfldNewDatefield,
				new FormData(CONSTANTS.other_anchorSpec_4()));
		dtfldNewDatefield.setFieldLabel(CONSTANTS
				.dtfldNewDatefield_fieldLabel());

		dtfldEndDate = new DateField();
		dtfldEndDate.setReadOnly(true);
		formPanel.add(dtfldEndDate,
				new FormData(CONSTANTS.other_anchorSpec_5()));
		dtfldEndDate.setFieldLabel(CONSTANTS.dtfldEndDate_fieldLabel_1());

		txtfldProjectStatus = new TextField<String>();
		txtfldProjectStatus.setReadOnly(true);
		formPanel.add(txtfldProjectStatus,
				new FormData(CONSTANTS.other_anchorSpec_6()));
		txtfldProjectStatus.setFieldLabel(CONSTANTS
				.txtfldProjectStatus_fieldLabel());
		panelP.add(formPanel, new BorderLayoutData(LayoutRegion.CENTER));
		formPanel.setSize("100%", "100%");
		formPanel.setHeaderVisible(false);

		layoutContainer = new LayoutContainer();
		layoutContainer.setLayout(new FitLayout());
		layoutContainer.setBorders(true);

	}

	@Override
	public Widget asWidget() {
		return panelP;
	}

	private void loadData() {
		txtfldProjectName.setValue(p.getName());
		txtfldProjectStatus.setValue(p.getStatus());
		dtfldEndDate.setValue(p.getDateEnd());
		dtfldNewDatefield.setValue(p.getDateStart());
	}

	@Override
	public void setProject(Project project) {
		// TODO Auto-generated method stub
		this.p = project;
		loadData();
	}

}
