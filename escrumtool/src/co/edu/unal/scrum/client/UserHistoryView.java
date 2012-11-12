package co.edu.unal.scrum.client;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.Window;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormButtonBinding;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextArea;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

public class UserHistoryView extends WindowViewImpl implements
		UserHistoryPresenter.MyView {

	private Window window;
	private FormPanel form;

	private Button saveButton;
	private Button cancelButton;

	private FormButtonBinding binding;
	private TextField<String> nameField;
	private TextArea descriptionField;
	private TextArea aceptanceField;
	private NumberField nmbrfldStoryPoints;
	private NumberField nmbrfldPriority;

	@Inject
	public UserHistoryView(final EventBus eventBus) {
		super(eventBus);

		window = new Window();
		window.setId(UserHistoryView.class.getName());
		window.setHeading("user History editor");
		window.setLayout(new FitLayout());
		window.setWidth(347);
		window.setHeight(599);
		window.setModal(true);

		form = new FormPanel();
		form.setHeaderVisible(false);
		form.setBodyBorder(false);
		form.setBorders(false);
		form.setButtonAlign(HorizontalAlignment.CENTER);

		nameField = new TextField<String>();
		nameField.setFieldLabel("Tittle");
		nameField.setAllowBlank(false);
		nameField.setMinLength(4);

		descriptionField = new TextArea();
		descriptionField
				.setToolTip("As a [user role] I want to [goal] so I can [reason].  ");
		descriptionField.setAllowBlank(false);
		descriptionField.setFieldLabel("Description");
		aceptanceField = new TextArea();
		aceptanceField
				.setToolTip("Scenario 1: Title\r\nGiven [context]\r\nAnd [some more context]\u2026\r\nWhen [event]\r\nThen [outcome]\r\nAnd [another outcome]\u2026");
		aceptanceField.setFieldLabel("Aceptance criteria");
		saveButton = new Button("Submit");
		cancelButton = new Button("Cancel");

		form.add(nameField);

		form.add(descriptionField);
		descriptionField.setSize("370", "200");
		form.add(aceptanceField);
		aceptanceField.setSize("370", "200");

		nmbrfldPriority = new NumberField();
		nmbrfldPriority.setAllowNegative(false);
		nmbrfldPriority.setAllowDecimals(false);
		nmbrfldPriority.setSelectOnFocus(true);
		form.add(nmbrfldPriority);
		nmbrfldPriority.setFieldLabel("Priority");
		nmbrfldStoryPoints = new NumberField();
		nmbrfldStoryPoints.setAllowNegative(false);
		nmbrfldStoryPoints.setFieldLabel("Story Points");
		form.add(nmbrfldStoryPoints);
		form.addButton(saveButton);
		form.addButton(cancelButton);

		binding = new FormButtonBinding(form);
		binding.addButton(saveButton);

		window.add(form);
		form.setHeight("569px");
	}

	@Override
	public Widget asWidget() {
		return window;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		nameField.setValue("");
		descriptionField.setValue("");
		aceptanceField.setValue("");
		nmbrfldPriority.setValue(null);
		nmbrfldStoryPoints.setValue(null);
	}
}
