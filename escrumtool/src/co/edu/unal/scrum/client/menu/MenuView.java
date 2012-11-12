package co.edu.unal.scrum.client.menu;

import co.edu.unal.scrum.client.resources.Resources;
import co.edu.unal.scrum.shared.model.LoginInfo;

import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.ButtonBar;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

public class MenuView extends ViewWithUiHandlers<MenuUiHandlres> implements
		MenuPresenter.MyView {

	private ToolBar menu;
	private Resources recursos;
	private LoginInfo currentLoginInfo;
	private Button btnProducts;
	private Button btnProductBacklog;
	private Button btnSprints;
	private Button btnCharts;
	private Button btnLogin;
	private Button btnUser;
	private Button btnLogout;

	@Inject
	public MenuView(final Resources recursos, final LoginInfo currentLoginInfo) {
		this.recursos = recursos;
		this.currentLoginInfo = currentLoginInfo;
		menu = new ToolBar();

	}

	@Override
	public Widget asWidget() {
		return menu;
	}

	@Override
	public void renderUserMenus() {
		// TODO Auto-generated method stub
		btnLogout = new Button("Logout", AbstractImagePrototype.create(recursos
				.iconKeyGo()));

		ButtonBar buttonBar = new ButtonBar();
		btnUser = new Button(currentLoginInfo.getEmail(),
				AbstractImagePrototype.create(recursos.iconUserSuit()));

		btnProducts = new Button("Products",
				AbstractImagePrototype.create(recursos.iconLayoutContent()));
		buttonBar.add(btnProducts);
		btnProducts.setEnabled(false);
		SeparatorToolItem separatorToolItem = new SeparatorToolItem();
		buttonBar.add(separatorToolItem);

		btnProductBacklog = new Button("Product Backlog",
				AbstractImagePrototype.create(recursos.products()));
		buttonBar.add(btnProductBacklog);

		SeparatorToolItem separatorToolItem_3 = new SeparatorToolItem();
		buttonBar.add(separatorToolItem_3);

		btnSprints = new Button("Sprints",
				AbstractImagePrototype.create(recursos.sprint()));
		buttonBar.add(btnSprints);

		SeparatorToolItem separatorToolItem_2 = new SeparatorToolItem();
		buttonBar.add(separatorToolItem_2);

		btnCharts = new Button("Charts", AbstractImagePrototype.create(recursos
				.iconChartPie()));
		buttonBar.add(btnCharts);
		menu.add(buttonBar);
		menu.add(new FillToolItem());
		btnLogin = new Button("Sign in", AbstractImagePrototype.create(recursos
				.login()));
		btnLogin.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				System.out.println(currentLoginInfo);
				Window.Location.replace(currentLoginInfo.getLoginUrl());
			}
		});
		menu.add(btnLogin);

		SeparatorToolItem separatorToolItem_1 = new SeparatorToolItem();
		menu.add(separatorToolItem_1);

		btnProducts.setEnabled(false);
		btnProductBacklog.setEnabled(false);
		btnSprints.setEnabled(false);
		btnCharts.setEnabled(false);

		btnLogout.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				String logout = currentLoginInfo.getLogoutUrl();
				currentLoginInfo.reset();
				Window.Location.replace(logout);

			}
		});
		bindCustomUserUiHandlers();

	}

	private void bindCustomUserUiHandlers() {
		// TODO Auto-generated method stub
		btnProducts.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				if (getUiHandlers() != null) {
					getUiHandlers().onProductClicked();
				}
			}
		});
		btnProductBacklog
				.addSelectionListener(new SelectionListener<ButtonEvent>() {

					@Override
					public void componentSelected(ButtonEvent ce) {
						// TODO Auto-generated method stub
						if (getUiHandlers() != null) {
							getUiHandlers().onProductBacklogClicked();
						}
					}
				});
		btnCharts.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				if (getUiHandlers() != null) {
					getUiHandlers().onChartclicked();

				}
			}
		});
	}

	@Override
	public void enabledActions() {
		// TODO Auto-generated method stub
		menu.remove(btnLogin);
		btnProducts.setEnabled(true);
		btnProductBacklog.setEnabled(true);
		btnSprints.setEnabled(true);
		btnCharts.setEnabled(true);
		menu.add(btnUser);
		menu.add(btnLogout);
	}

}
