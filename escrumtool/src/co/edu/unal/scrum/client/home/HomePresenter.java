package co.edu.unal.scrum.client.home;

import java.util.ArrayList;

import co.edu.unal.scrum.client.LayoutPresenter;
import co.edu.unal.scrum.client.events.AddTeamEvent;
import co.edu.unal.scrum.client.events.AddTeamEvent.AddTeamHandler;
import co.edu.unal.scrum.client.events.ProjectAddedEvent;
import co.edu.unal.scrum.client.events.ProjectAddedEvent.ProjectAddedHandler;
import co.edu.unal.scrum.client.projects.ProjectEditorPresenter;
import co.edu.unal.scrum.client.projects.ProjectsUiHandles;
import co.edu.unal.scrum.client.projects.TeamEditorPresenter;
import co.edu.unal.scrum.client.projects.widgets.ProjectPresenter;
import co.edu.unal.scrum.shared.model.LoginInfo;
import co.edu.unal.scrum.shared.model.Project;

import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

public class HomePresenter extends
		Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements
		ProjectsUiHandles, ProjectAddedHandler, AddTeamHandler {

	public interface MyView extends View, HasUiHandlers<ProjectsUiHandles> {
		public LayoutContainer getPanel();

		public ContentPanel getPanelP();

		public SimpleComboBox<String> getSmplcmbxNewSimplecombobox();
	}

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<HomePresenter> {
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_WEST = new Type<RevealContentHandler<?>>();
	public static final Object List_Slot = new Object();
	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_CENTER = new Type<RevealContentHandler<?>>();
	private ProjectEditorPresenter editorPresenter;
	private final Provider<ProjectPresenter> list;
	private LoginInfo currentLogin;
	private TeamEditorPresenter teamEditor;

	@Inject
	public HomePresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, ProjectEditorPresenter editor,
			Provider<ProjectPresenter> list, final LoginInfo currentLogin,
			TeamEditorPresenter teamEditor) {
		super(eventBus, view, proxy);
		this.editorPresenter = editor;
		this.list = list;
		this.currentLogin = currentLogin;
		this.teamEditor = teamEditor;
		getView().setUiHandlers(this);
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, LayoutPresenter.TYPE_CENTER, this);
	}

	@Override
	protected void onReveal() {
		// TODO Auto-generated method stub
		super.onReveal();
	}

	@Override
	protected void onBind() {
		super.onBind();
		addRegisteredHandler(ProjectAddedEvent.TYPE, this);
		addRegisteredHandler(AddTeamEvent.TYPE, this);
	}

	@Override
	public void onEditButtonClicked() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onReset() {
		// TODO Auto-generated method stub
		super.onReset();
		if (currentLogin.getProjects() != null) {
			ArrayList<Project> projects = currentLogin.getProjects();
			setInSlot(List_Slot, null);
			getView().getSmplcmbxNewSimplecombobox().removeAll();

			for (Project project : projects) {
				ProjectPresenter result = list.get();
				result.setProject(project);
				addToSlot(List_Slot, result);
				getView().getSmplcmbxNewSimplecombobox().add(project.getName());

			}

			getView().getPanel().layout();
		}

	}

	@Override
	public void onAddButtonClicked() {
		// TODO Auto-generated method stub
		addToPopupSlot(editorPresenter);
	}

	@Override
	public void onProjectAdded(ProjectAddedEvent event) {
		ProjectPresenter result = list.get();
		currentLogin.getProjects().add(event.getProject());
		result.setProject(event.getProject());
		addToSlot(List_Slot, result);
		getView().getPanel().layout();
		getView().getSmplcmbxNewSimplecombobox().add(
				event.getProject().getName());

	}

	@Override
	public void onAddTeam(AddTeamEvent event) {
		// TODO Auto-generated method stub
		addToPopupSlot(teamEditor);
	}
}
