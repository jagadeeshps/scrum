package co.edu.unal.scrum.client.gxt;

import java.util.ArrayList;
import java.util.List;

import com.extjs.gxt.ui.client.widget.grid.ColumnConfig;
import com.extjs.gxt.ui.client.widget.grid.ColumnModel;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;

public class ColumnFactory {
	public static ColumnConfig manufactureColumn(String modelProperty,
			String label) {
		return new ColumnConfig(modelProperty, label, 50);
	}

	public static ColumnConfig manufactureDateColumn(String modelProperty,
			String label) {
		ColumnConfig dateColumn = new ColumnConfig(modelProperty, label, 50);
		dateColumn.setDateTimeFormat(DateTimeFormat
				.getFormat(PredefinedFormat.DATE_MEDIUM));
		return dateColumn;
	}

	public static ColumnModel manufactureColumnModel(
			ColumnConfig... columnConfigs) {
		List<ColumnConfig> columnModelConfigs = new ArrayList<ColumnConfig>();
		for (ColumnConfig columnConfig : columnConfigs) {
			if (columnConfig != null) {
				columnModelConfigs.add(columnConfig);
			}
		}
		return new ColumnModel(columnModelConfigs);
	}
}
