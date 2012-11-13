package co.edu.unal.scrum.client.projects;

import java.util.ArrayList;

import co.edu.unal.scrum.shared.util.VType;
import co.edu.unal.scrum.shared.util.VTypeValidator;

import com.extjs.gxt.ui.client.Style.ButtonScale;
import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.gwtplatform.mvp.client.PopupViewWithUiHandlers;

import co.edu.unal.scrum.client.resources.AppConstants;
import com.google.gwt.core.client.GWT;

public class TeamEditorView extends
		PopupViewWithUiHandlers<TeamEditorUiHandlers> implements
		TeamEditorPresenter.MyView {
	private static final AppConstants CONSTANTS = GWT
			.create(AppConstants.class);
	private PopupPanel window;
	private FormPanel form;
	private ArrayList<TextField<String>> team;
	private TextField<?> txtfldScrumMaster;
	private TextField<?> txtfldProductOwner_1;
	private int teamSize = 5;
	private Button saveButton;
	private Button cancelButton;
	private FormButtonBinding binding;
	private LayoutContainer left;

	@Inject
	public TeamEditorView(final EventBus eventBus) {
		super(eventBus);
		window = new PopupPanel();
		window.setAutoHideOnHistoryEventsEnabled(true);
		window.setAnimationEnabled(true);
		window.setWidth(CONSTANTS.window_width_1());
		team = new ArrayList<TextField<String>>();
		window.setModal(true);
		form = new FormPanel();
		form.setHeaderVisible(true);
		form.setHeading(CONSTANTS.form_heading_1());
		form.setSize(800, -1);
		form.setLabelAlign(LabelAlign.TOP);
		form.setButtonAlign(HorizontalAlignment.CENTER);
		LayoutContainer main = new LayoutContainer(new ColumnLayout());
		ColumnLayout columnLayout = (ColumnLayout) main.getLayout();
		columnLayout.setAdjustForScroll(true);
		main.setBorders(true);
		left = new LayoutContainer();
		left.setStyleAttribute("paddingRight", "10px");
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		left.setLayout(layout);

		txtfldScrumMaster = new TextField<String>();
		txtfldScrumMaster.setMessageTarget("tooltip");
		txtfldScrumMaster.setBorders(true);
		txtfldScrumMaster.setAllowBlank(false);
		txtfldScrumMaster.setValidator(new VTypeValidator(VType.EMAIL));
		left.add(txtfldScrumMaster, new FormData("60%"));

		txtfldScrumMaster.setFieldLabel(CONSTANTS
				.txtfldScrumMaster_fieldLabel_1());
		txtfldProductOwner_1 = new TextField<String>();
		txtfldProductOwner_1.setMessageTarget("tooltip");
		txtfldProductOwner_1.setBorders(true);
		txtfldProductOwner_1.setAllowBlank(false);
		txtfldProductOwner_1.setValidator(new VTypeValidator(VType.EMAIL));
		left.add(txtfldProductOwner_1, new FormData("60%"));
		txtfldProductOwner_1.setFieldLabel(CONSTANTS
				.txtfldProductOwner_1_fieldLabel());

		saveButton = new Button(CONSTANTS.saveButton_text_1());
		saveButton.setScale(ButtonScale.MEDIUM);
		cancelButton = new Button(CONSTANTS.cancelButton_text_1());
		cancelButton.setScale(ButtonScale.MEDIUM);
		for (int i = 0; i < teamSize; i++) {
			TextField<String> t = new TextField<String>();
			t.setFieldLabel("Pig " + (i + 1));
			t.setValidator(new VTypeValidator(VType.EMAIL));
			t.setBorders(true);
			t.setMessageTarget("tooltip");
			team.add(t);
		}
		for (TextField<String> txt : team) {
			left.add(txt, new FormData("60%"));
		}
		form.add(left, new FormData("100%"));

		binding = new FormButtonBinding(form);
		binding.addButton(saveButton);
		form.addButton(saveButton);
		form.addButton(cancelButton);
		window.add(form);
		saveButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				if (getUiHandlers() != null) {
					getUiHandlers().onSaveClicked();
				}
			}
		});
		cancelButton.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				if (getUiHandlers() != null) {
					getUiHandlers().onCancelClicked();
				}
			}
		});
	}

	@Override
	public Widget asWidget() {
		return window;
	}
}
