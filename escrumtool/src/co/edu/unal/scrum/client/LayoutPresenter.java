package co.edu.unal.scrum.client;

import co.edu.unal.scrum.client.header.HeaderPresenter;
import co.edu.unal.scrum.client.menu.MenuPresenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootContentEvent;

public class LayoutPresenter extends
		Presenter<LayoutPresenter.MyView, LayoutPresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyCodeSplit
	public interface MyProxy extends Proxy<LayoutPresenter> {
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_CENTER = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_WEST = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_EAST = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_SOUTH = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_HEADER = new Type<RevealContentHandler<?>>();

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_MENU = new Type<RevealContentHandler<?>>();

	// private HeaderPresenter headerPresenter;

	@Inject
	public LayoutPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final HeaderPresenter headerPresenter,
			final MenuPresenter menu) {
		super(eventBus, view, proxy);
		setInSlot(TYPE_HEADER, headerPresenter);
		setInSlot(TYPE_MENU, menu);
	}

	@Override
	protected void revealInParent() {
		RevealRootContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
	}
}
