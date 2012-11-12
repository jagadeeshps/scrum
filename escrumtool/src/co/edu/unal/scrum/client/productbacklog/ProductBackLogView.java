package co.edu.unal.scrum.client.productbacklog;

import co.edu.unal.scrum.client.resources.Resources;
import co.edu.unal.scrum.shared.model.Product;

import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.data.BeanModel;
import com.extjs.gxt.ui.client.data.BeanModelFactory;
import com.extjs.gxt.ui.client.data.BeanModelLookup;
import com.extjs.gxt.ui.client.event.ButtonEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.extjs.gxt.ui.client.widget.table.Table;
import com.extjs.gxt.ui.client.widget.table.TableColumnModel;
import com.extjs.gxt.ui.client.widget.table.TableColumn;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FillLayout;
import com.extjs.gxt.ui.client.Style.Orientation;
import co.edu.unal.scrum.client.resources.AppConstants;
import com.google.gwt.core.client.GWT;

public class ProductBackLogView extends
		ViewWithUiHandlers<ProductBackLogUiHandlres> implements
		ProductBackLogPresenter.MyView {
	private static final AppConstants CONSTANTS = GWT.create(AppConstants.class);
	private static final BeanModelFactory factory = BeanModelLookup.get()
			.getFactory(Product.class);

	private LayoutContainer layoutContainer;
	private ContentPanel gridPanel;

	private Grid<BeanModel> grid;
	private ColumnModel columnModel;
	private ListStore<BeanModel> store;

	private Button add;
	private Button delete;

	private ToolBar actionToolBar;

	private ColumnConfig idColumn;

	private ColumnConfig statusColumn;

	private ColumnConfig userHistory;

	private ColumnConfig storyPoints;

	private ColumnConfig editColumn;

	@Inject
	public ProductBackLogView(final Resources resources) {
		layoutContainer = new LayoutContainer();
		layoutContainer.setId(ProductBackLogView.class.getName());
		layoutContainer.setLayout(new BorderLayout());
		gridPanel = new ContentPanel();
		gridPanel.setHeading(CONSTANTS.gridPanel_heading());
		add = new Button(CONSTANTS.add_text(), AbstractImagePrototype.create(resources //$NON-NLS-1$
				.iconAdd()));
		add.addSelectionListener(new SelectionListener<ButtonEvent>() {

			@Override
			public void componentSelected(ButtonEvent ce) {
				// TODO Auto-generated method stub
				if (getUiHandlers() != null) {
					getUiHandlers().addUserHistory();
				}
			}
		});
		gridPanel.setLayout(new FillLayout(Orientation.VERTICAL));
		delete = new Button(CONSTANTS.delete_text(), AbstractImagePrototype.create(resources
				.iconDelete()));

		actionToolBar = new ToolBar();
		actionToolBar.add(add);
		actionToolBar.add(new SeparatorToolItem());
		actionToolBar.add(delete);

		gridPanel.setTopComponent(actionToolBar);

		layoutContainer.add(gridPanel,
				new BorderLayoutData(LayoutRegion.CENTER));
	}

	@Override
	public Widget asWidget() {
		return layoutContainer;
	}
}
