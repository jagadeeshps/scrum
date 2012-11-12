package co.edu.unal.scrum.client.projects.widgets;

import co.edu.unal.scrum.client.projects.ProjectsUiHandles;
import co.edu.unal.scrum.client.resources.Resources;
import co.edu.unal.scrum.shared.model.Project;

import com.extjs.gxt.ui.client.Style.Orientation;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.VerticalPanel;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.layout.RowLayout;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class ProjectView extends ViewWithUiHandlers<ProjectsUiHandles> implements ProjectPresenter.MyView {

	ContentPanel panel;
	private Project p;
	private Label label;
	private DateLabel dateLabel;
	private DateLabel dateLabel_1;
	private Label label_1;
	private Button btnDetails;
	private Button btnDelete;

	@Inject
	public ProjectView(final Resources resource) {
		panel = new ContentPanel();
		panel.setAutoHeight(true);
		panel.setHeaderVisible(false);
		panel.setLayout(new RowLayout(Orientation.VERTICAL));

		VerticalPanel verticalPanel = new VerticalPanel();

		label = new Label("");

		verticalPanel.add(label);

		dateLabel = new DateLabel();
		verticalPanel.add(dateLabel);

		dateLabel_1 = new DateLabel();
		verticalPanel.add(dateLabel_1);

		label_1 = new Label("");
		verticalPanel.add(label_1);
		panel.add(verticalPanel);

		ToolBar toolBar = new ToolBar();

		btnDetails = new Button("Details");
		toolBar.add(btnDetails);

		SeparatorToolItem separatorToolItem = new SeparatorToolItem();
		separatorToolItem.setBorders(true);
		toolBar.add(separatorToolItem);

		btnDelete = new Button("Delete", AbstractImagePrototype.create(resource
				.iconDelete()));
		toolBar.add(btnDelete);
		panel.add(toolBar);

	}

	@Override
	public Widget asWidget() {
		return panel;
	}

	public void setP(Project p) {
		this.p = p;
		loadData();
	}

	private void loadData() {
		// TODO Auto-generated method stub
		/*
		label.setText(p.getName());
		dateLabel.setValue(p.getDateStart());
		dateLabel_1.setValue(p.getDateEnd());
		label_1.setText(p.getStatus());
		*/
	}

}
