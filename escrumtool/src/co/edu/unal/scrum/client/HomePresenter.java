package co.edu.unal.scrum.client;

import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import co.edu.unal.scrum.client.LayoutPresenter;
import co.edu.unal.scrum.client.projects.ProjectEditorPresenter;
import co.edu.unal.scrum.client.projects.ProjectsUiHandles;
import co.edu.unal.scrum.client.projects.TeamEditorPresenter;

public class HomePresenter extends
		Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements
		ProjectsUiHandles {

	public interface MyView extends View, HasUiHandlers<ProjectsUiHandles> {
	}

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<HomePresenter> {
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_WEST = new Type<RevealContentHandler<?>>();
	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_CENTER = new Type<RevealContentHandler<?>>();
	private TeamEditorPresenter editorPresenter;
	private WallPresenter wall;

	@Inject
	public HomePresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, TeamEditorPresenter editor) {
		super(eventBus, view, proxy);
		this.editorPresenter = editor;
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
	}

	@Override
	public void onEditButtonClicked() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onReset() {
		// TODO Auto-generated method stub
		super.onReset();

	}

	@Override
	public void onAddButtonClicked() {
		// TODO Auto-generated method stub
		addToPopupSlot(editorPresenter);
	}
}
