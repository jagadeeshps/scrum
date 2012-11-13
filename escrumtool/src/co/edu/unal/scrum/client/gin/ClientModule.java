package co.edu.unal.scrum.client.gin;

import co.edu.unal.scrum.client.InicioPresenter;
import co.edu.unal.scrum.client.InicioView;
import co.edu.unal.scrum.client.LayoutPresenter;
import co.edu.unal.scrum.client.LayoutView;
import co.edu.unal.scrum.client.UserHistoryPresenter;
import co.edu.unal.scrum.client.UserHistoryView;
import co.edu.unal.scrum.client.header.HeaderPresenter;
import co.edu.unal.scrum.client.header.HeaderView;
import co.edu.unal.scrum.client.home.HomePresenter;
import co.edu.unal.scrum.client.home.HomeView;
import co.edu.unal.scrum.client.menu.MenuPresenter;
import co.edu.unal.scrum.client.menu.MenuView;
import co.edu.unal.scrum.client.place.ClientPlaceManager;
import co.edu.unal.scrum.client.place.DefaultPlace;
import co.edu.unal.scrum.client.place.LoggedInGatekeeper;
import co.edu.unal.scrum.client.place.NameTokens;
import co.edu.unal.scrum.client.productbacklog.ProductBackLogPresenter;
import co.edu.unal.scrum.client.productbacklog.ProductBackLogView;
import co.edu.unal.scrum.client.projects.ProjectEditorPresenter;
import co.edu.unal.scrum.client.projects.ProjectEditorView;
import co.edu.unal.scrum.client.projects.widgets.ProjectPresenter;
import co.edu.unal.scrum.client.projects.widgets.ProjectView;
import co.edu.unal.scrum.client.statics.StaticsPresenter;
import co.edu.unal.scrum.client.statics.StaticsView;
import co.edu.unal.scrum.client.wall.WallPresenter;
import co.edu.unal.scrum.client.wall.WallView;
import co.edu.unal.scrum.shared.model.LoginInfo;

import com.google.inject.Singleton;
import com.gwtplatform.dispatch.shared.SecurityCookie;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import co.edu.unal.scrum.client.projects.TeamEditorPresenter;
import co.edu.unal.scrum.client.projects.TeamEditorView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));
		bind(LoginInfo.class).in(Singleton.class);
		bind(LoggedInGatekeeper.class).in(Singleton.class);
		bindConstant().annotatedWith(SecurityCookie.class).to("123456");

		bindPresenter(LayoutPresenter.class, LayoutPresenter.MyView.class,
				LayoutView.class, LayoutPresenter.MyProxy.class);

		bindSingletonPresenterWidget(HeaderPresenter.class,
				HeaderPresenter.MyView.class, HeaderView.class);

		

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.inicio);

		bindSingletonPresenterWidget(MenuPresenter.class,
				MenuPresenter.MyView.class, MenuView.class);

		bindPresenterWidget(UserHistoryPresenter.class,
				UserHistoryPresenter.MyView.class, UserHistoryView.class);

		bindPresenter(ProductBackLogPresenter.class,
				ProductBackLogPresenter.MyView.class, ProductBackLogView.class,
				ProductBackLogPresenter.MyProxy.class);

		bindPresenterWidget(ProjectEditorPresenter.class,
				ProjectEditorPresenter.MyView.class, ProjectEditorView.class);

		bindPresenter(StaticsPresenter.class, StaticsPresenter.MyView.class,
				StaticsView.class, StaticsPresenter.MyProxy.class);

		bindPresenter(InicioPresenter.class, InicioPresenter.MyView.class,
				InicioView.class, InicioPresenter.MyProxy.class);

		bindPresenter(WallPresenter.class, WallPresenter.MyView.class,
				WallView.class, WallPresenter.MyProxy.class);

		bindPresenterWidget(ProjectPresenter.class,
				ProjectPresenter.MyView.class, ProjectView.class);

		bindPresenter(HomePresenter.class, HomePresenter.MyView.class,
				HomeView.class, HomePresenter.MyProxy.class);

		bindPresenterWidget(TeamEditorPresenter.class,
				TeamEditorPresenter.MyView.class, TeamEditorView.class);
	}
}
