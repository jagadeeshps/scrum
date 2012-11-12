package co.edu.unal.scrum.client.projects;

import java.util.ArrayList;

import com.extjs.gxt.ui.client.Style.HorizontalAlignment;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.form.FormPanel;
import com.extjs.gxt.ui.client.widget.form.FormPanel.LabelAlign;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.layout.ColumnLayout;
import com.extjs.gxt.ui.client.widget.layout.FormLayout;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.extjs.gxt.ui.client.widget.layout.FormData;
import com.google.gwt.core.client.GWT;

public class TeamEditorView extends PopupViewImpl implements
		TeamEditorPresenter.MyView {
	private PopupPanel panel;
	private FormPanel form;
	private TextField<String> nameField;
	private Button saveButton;
	private Button cancelButton;
	private TextField<String> txtfldProductOwner;
	private ArrayList<TextField<String>> team;

	@Inject
	public TeamEditorView(final EventBus eventBus) {
		super(eventBus);
		panel = new PopupPanel();
		team=new ArrayList<TextField<String>>();
		panel.setModal(true);
		panel.setAutoHideOnHistoryEventsEnabled(true);
		panel.setAutoHideEnabled(true);
		panel.setAnimationEnabled(true);
		form = new FormPanel();
		form.setSize(800, -1);
		form.setLabelAlign(LabelAlign.TOP);
		form.setButtonAlign(HorizontalAlignment.CENTER);
		
		
		LayoutContainer main = new LayoutContainer(new ColumnLayout());
		ColumnLayout columnLayout = (ColumnLayout) main.getLayout();
		columnLayout.setAdjustForScroll(true);
		main.setBorders(true);
		LayoutContainer left = new LayoutContainer();
		FormLayout layout = new FormLayout();
		layout.setLabelAlign(LabelAlign.TOP);
		left.setLayout(layout);
		panel.add(form);
	}

	@Override
	public Widget asWidget() {
		return panel;
	}
}
