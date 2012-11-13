package co.edu.unal.scrum.client.projects;

import java.util.Date;

import co.edu.unal.scrum.client.events.AddTeamEvent;
import co.edu.unal.scrum.client.events.ProjectAddedEvent;
import co.edu.unal.scrum.shared.actions.CreateProject;
import co.edu.unal.scrum.shared.actions.CreateProjectResult;
import co.edu.unal.scrum.shared.model.LoginInfo;
import co.edu.unal.scrum.shared.model.Project;

import com.extjs.gxt.ui.client.widget.Info;
import com.extjs.gxt.ui.client.widget.MessageBox;
import com.extjs.gxt.ui.client.widget.form.DateField;
import com.extjs.gxt.ui.client.widget.form.HtmlEditor;
import com.extjs.gxt.ui.client.widget.form.NumberField;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;

public class ProjectEditorPresenter extends
		PresenterWidget<ProjectEditorPresenter.MyView> implements HasHandlers,
		ProjectEditorUiHandlers {

	public interface MyView extends PopupView,
			HasUiHandlers<ProjectEditorUiHandlers> {
		public TextField<String> getTxtfldProjectname();

		public HtmlEditor getDescriptionField();

		public DateField getDtfldStartdate();

		public DateField getDtfldEndDate();

		public NumberField getNmbrfldTeamSize();

	}

	private TeamEditorPresenter teamEditor;
	private DispatchAsync dispatcher;
	private LoginInfo currentLogin;

	@Inject
	public ProjectEditorPresenter(final EventBus eventBus, final MyView view,
			TeamEditorPresenter teameditor, DispatchAsync dispacther,
			final LoginInfo currentLogin) {
		super(eventBus, view);
		this.teamEditor = teameditor;
		this.dispatcher = dispacther;
		this.currentLogin = currentLogin;
		getView().setUiHandlers(this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	public void onSaveButtonClicked() {
		// TODO Auto-generated method stub
		getView().hide();
		String name = getView().getTxtfldProjectname().getValue();
		Date startDate = getView().getDtfldStartdate().getValue();
		Date endDate = getView().getDtfldEndDate().getValue();
		int teamSize = getView().getNmbrfldTeamSize().getValue().intValue();
		String description = getView().getDescriptionField().getValue();
		dispatcher.execute(new CreateProject(name, startDate, endDate,
				teamSize, description, currentLogin.getEmail()),
				new AsyncCallback<CreateProjectResult>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(CreateProjectResult result) {
						// TODO Auto-generated method stub
						if (!result.isError()) {
							Info.display("Project creation",
									"The project with id ="
											+ result.getProject()
													.getIdProject()
											+ " was created");
							manageResult(result);

						} else {
							MessageBox.prompt("Error", result.getErrorMessage());
						}
					}

				});

	}

	@Override
	public void onCancelButtonClicked() {
		// TODO Auto-generated method stub
		getView().hide();
	}

	public void reset() {
		// TODO Auto-generated method stub

	}

	public void setProjectData(Project p) {

	}

	private void manageResult(CreateProjectResult result) {
		// TODO Auto-generated method stub
		ProjectAddedEvent.fire(this, result.getProject());
		AddTeamEvent.fire(this, 5);
		getView().hide();
	}
}
