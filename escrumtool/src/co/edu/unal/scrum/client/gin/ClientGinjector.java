package co.edu.unal.scrum.client.gin;

import co.edu.unal.scrum.client.HomePresenter;
import co.edu.unal.scrum.client.InicioPresenter;
import co.edu.unal.scrum.client.LayoutPresenter;
import co.edu.unal.scrum.client.WallPresenter;
import co.edu.unal.scrum.client.place.LoggedInGatekeeper;
import co.edu.unal.scrum.client.productbacklog.ProductBackLogPresenter;
import co.edu.unal.scrum.client.statics.StaticsPresenter;
import co.edu.unal.scrum.shared.model.LoginInfo;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.gwtplatform.dispatch.shared.DispatchAsync;
import com.gwtplatform.mvp.client.proxy.PlaceManager;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	DispatchAsync getDispatcher();

	LoginInfo getLoginInfo();

	LoggedInGatekeeper getLoggedInGatekeeper();

	AsyncProvider<LayoutPresenter> getMainPresenter();


	AsyncProvider<ProductBackLogPresenter> getProductPresenter();

	AsyncProvider<StaticsPresenter> getStaticsPresenter();

	AsyncProvider<InicioPresenter> getInicioPresenter();

	AsyncProvider<WallPresenter> getWallPresenter();

	AsyncProvider<HomePresenter> getHomePresenter();

}
