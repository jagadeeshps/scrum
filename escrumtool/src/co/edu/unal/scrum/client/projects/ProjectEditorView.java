package co.edu.unal.scrum.client.projects;

import co.edu.unal.scrum.client.WindowViewWithUiHandlers;
import co.edu.unal.scrum.client.resources.AppConstants;

import com.extjs.gxt.ui.client.Style.ButtonScale;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;
import com.google.gwt.core.client.GWT;

public class ProjectEditorView extends

WindowViewWithUiHandlers<ProjectEditorUiHandlers> implements
		ProjectEditorPresenter.MyView {
	private static final AppConstants CONSTANTS = GWT
			.create(AppConstants.class);

	private Window wndwP;
	private FormPanel form;
	private TextField<String> txtfldProjectname;
	private HtmlEditor descriptionField;
	private Button saveButton;
	private FormButtonBinding binding;
	private Button cancelButton;
	private DateField dtfldStartdate;
	private DateField dtfldEndDate;
	private NumberField nmbrfldTeamSize;

	@Inject
	public ProjectEditorView(EventBus eventBus) {
		super(eventBus);
		wndwP = new Window();
		wndwP.setActive(true);
		wndwP.setHeading(CONSTANTS.wndwP_heading());
		wndwP.setBlinkModal(true);
		wndwP.setWidth(CONSTANTS.window_width());

		wndwP.setModal(true);
		// window.setAutoHideEnabled(true);
		form = new FormPanel();
		form.setHeaderVisible(false);
		form.setHeading(CONSTANTS.form_heading());
		form.setSize(800, -1);
		form.setLabelAlign(LabelAlign.TOP);
		form.setButtonAlign(HorizontalAlignment.CENTER);
		LayoutContainer main = new LayoutContainer(new ColumnLayout());
		ColumnLayout columnLayout = (ColumnLayout) main.getLayout();
		columnLayout.setAdjustForScroll(true);
		main.setBorders(true);
		LayoutContainer left = new LayoutContainer();
		left.setStyleAttribute("paddingRight", "10px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		left.setLayout(layout);

		txtfldProjectname = new TextField<String>();
		txtfldProjectname.setMaxLength(500);
		txtfldProjectname.setMessageTarget("tooltip");
		txtfldProjectname.setBorders(true);
		txtfldProjectname.setMinLength(4);
		txtfldProjectname.setAllowBlank(false);
		left.add(txtfldProjectname, new FormData("60%"));

		dtfldStartdate = new DateField();
		dtfldStartdate.setMessageTarget("tooltip");
		dtfldStartdate.setAllowBlank(false);
		left.add(dtfldStartdate, new FormData("60%"));
		dtfldStartdate.setFieldLabel(CONSTANTS.dtfldStartdate_fieldLabel());

		dtfldEndDate = new DateField();
		dtfldEndDate.setAllowBlank(false);
		dtfldEndDate.setMessageTarget("tooltip");
		left.add(dtfldEndDate, new FormData("60%"));
		dtfldEndDate.setFieldLabel(CONSTANTS.dtfldEndDate_fieldLabel());

		nmbrfldTeamSize = new NumberField();
		nmbrfldTeamSize.setMessageTarget("tooltip");
		nmbrfldTeamSize.setMinValue(1);
		nmbrfldTeamSize.setMaxValue(10);
		nmbrfldTeamSize.setAllowNegative(false);
		nmbrfldTeamSize.setAllowDecimals(false);
		nmbrfldTeamSize.setAllowBlank(false);
		nmbrfldTeamSize.setValue(5);
		nmbrfldTeamSize.setEditable(false);
		left.add(nmbrfldTeamSize, new FormData("60%"));
		nmbrfldTeamSize.setFieldLabel(CONSTANTS.nmbrfldTeamSize_fieldLabel());
		form.add(left, new FormData("100%"));
		txtfldProjectname.setFieldLabel(CONSTANTS
				.txtfldProjectname_fieldLabel());

		descriptionField = new HtmlEditor();
		descriptionField.setFieldLabel(CONSTANTS.descriptionField_fieldLabel());
		descriptionField.setHeight(200);
		form.add(descriptionField, new FormData("100%"));
		saveButton = new Button(CONSTANTS.saveButton_text());
		saveButton.setScale(ButtonScale.MEDIUM);
		cancelButton = new Button(CONSTANTS.cancelButton_text());
		cancelButton.setScale(ButtonScale.MEDIUM);

		binding = new FormButtonBinding(form);
		binding.addButton(saveButton);
		form.addButton(saveButton);
		form.addButton(cancelButton);
		wndwP.add(form);
		saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				if (getUiHandlers() != null) {
					getUiHandlers().onSaveButtonClicked();
				}
			}
		});

	}

	public TextField<String> getTxtfldProjectname() {
		return txtfldProjectname;
	}

	public void setTxtfldProjectname(TextField<String> txtfldProjectname) {
		this.txtfldProjectname = txtfldProjectname;
	}

	public HtmlEditor getDescriptionField() {
		return descriptionField;
	}

	public void setDescriptionField(HtmlEditor descriptionField) {
		this.descriptionField = descriptionField;
	}

	public DateField getDtfldStartdate() {
		return dtfldStartdate;
	}

	public void setDtfldStartdate(DateField dtfldStartdate) {
		this.dtfldStartdate = dtfldStartdate;
	}

	public DateField getDtfldEndDate() {
		return dtfldEndDate;
	}

	public void setDtfldEndDate(DateField dtfldEndDate) {
		this.dtfldEndDate = dtfldEndDate;
	}

	public NumberField getNmbrfldTeamSize() {
		return nmbrfldTeamSize;
	}

	public void setNmbrfldTeamSize(NumberField nmbrfldTeamSize) {
		this.nmbrfldTeamSize = nmbrfldTeamSize;
	}

	@Override
	public Widget asWidget() {
		return wndwP;
	}

}
