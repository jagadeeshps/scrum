package co.edu.unal.scrum.client.statics;

import com.extjs.gxt.charts.client.Chart;
import com.extjs.gxt.charts.client.model.ChartModel;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

public class StaticsView extends ViewImpl implements StaticsPresenter.MyView {
	private ContentPanel cp;

	@Inject
	public StaticsView() {
		cp = new ContentPanel();
		cp.setLayout(new FitLayout());
		cp.setHeading("Horizontal Bar chart");
		String url = "ExtGWT/chart/open-flash-chart.swf";
		final Chart chart = new Chart(url);
		chart.setChartModel(getHorizontalBarChartModel());
		cp.add(chart);

	}

	private ChartModel getHorizontalBarChartModel() {
		// TODO Auto-generated method stub
		// Create a ChartModel with the Chart Title and some style attributes
		ChartModel cm = new ChartModel("Products by month",
				"font-size: 14px; font-family:      Verdana; text-align: center;");

		return cm;
	}

	@Override
	public Widget asWidget() {
		return cp;
	}

}
