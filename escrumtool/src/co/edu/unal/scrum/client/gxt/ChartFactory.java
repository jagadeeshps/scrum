package co.edu.unal.scrum.client.gxt;

import com.extjs.gxt.charts.client.Chart;

public class ChartFactory {

	public static final String PATH_OPEN_FLASH_CHART = "ExtGWT/chart/open-flash-chart.swf";

	/**
	 * Creates a chart with the correct path to the open flash chart file.
	 * 
	 * @return the new Chart.
	 */
	public static Chart manufatureChart() {
		return new Chart(PATH_OPEN_FLASH_CHART);
	}

}
