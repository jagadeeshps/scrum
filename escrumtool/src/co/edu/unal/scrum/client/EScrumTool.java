package co.edu.unal.scrum.client;

import co.edu.unal.scrum.client.gin.ClientGinjector;
import co.edu.unal.scrum.shared.actions.LoginAction;
import co.edu.unal.scrum.shared.actions.LoginActionResult;

import com.extjs.gxt.ui.client.GXT;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.DelayedBindRegistry;

public class EScrumTool implements EntryPoint {

	private final ClientGinjector ginjector = GWT.create(ClientGinjector.class);

	@Override
	public void onModuleLoad() {
		// This is required for Gwt-Platform proxy's generator
		DelayedBindRegistry.bind(ginjector);
		ginjector.getDispatcher().execute(
				new LoginAction(Window.Location.getHref()),
				new AsyncCallback<LoginActionResult>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(LoginActionResult result) {
						// TODO Auto-generated method stub
						ginjector.getLoginInfo().initialize(
								result.getLoginInfo());

						ginjector.getPlaceManager().revealCurrentPlace();
						GXT.hideLoadingPanel("loading");
					}
				});

	}
}
