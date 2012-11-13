package co.edu.unal.scrum.client;

import co.edu.unal.scrum.client.resources.Resources;

import com.bramosystems.oss.player.core.client.PlayerUtil;
import com.bramosystems.oss.player.core.client.PluginNotFoundException;
import com.bramosystems.oss.player.core.client.PluginVersionException;
import com.bramosystems.oss.player.youtube.client.PlayerParameters;
import com.bramosystems.oss.player.youtube.client.YouTubePlayer;
import com.extjs.gxt.ui.client.Style.LayoutRegion;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.BorderLayout;
import com.extjs.gxt.ui.client.widget.layout.BorderLayoutData;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.bramosystems.oss.player.core.client.RepeatMode;

public class InicioView extends ViewImpl implements InicioPresenter.MyView {

	LayoutContainer panel;
	private SimplePanel simplePanel;
	private YouTubePlayer player;

	@Inject
	public InicioView(final Resources recursos) {
		panel = new LayoutContainer();
		panel.setLayout(new BorderLayout());

		ContentPanel cntntpnlScrumTool = new ContentPanel();
		cntntpnlScrumTool.setHeading("Scrum Tool");
		cntntpnlScrumTool.setLayout(new BorderLayout());
		Image im = new Image(recursos.scrum());
		cntntpnlScrumTool.add(im, new BorderLayoutData(LayoutRegion.CENTER));
		im.setSize("100%", "100%");
		simplePanel = new SimplePanel();
		simplePanel.setSize("100%", "100%");
		try {
			// create the player, specifing URL of media
			PlayerParameters p = new PlayerParameters();
			p.setAutoplay(true);
			player = new YouTubePlayer("http://www.youtube.com/v/XU0llRltyFM",
					p, "100%", "100%");
			player.setRepeatMode(RepeatMode.REPEAT_ALL);

			simplePanel.setWidget(player); // add player and custom control to
											// panel.
		} catch (PluginVersionException e) {
			// required Flash plugin version is not available,
			// alert user possibly providing a link to the plugin download page.
			simplePanel.setWidget(new HTML(".. some nice message telling the "
					+ "user to download plugin first .."));
		} catch (PluginNotFoundException e) {
			// required Flash plugin not found, display a friendly notice.
			simplePanel.setWidget(PlayerUtil.getMissingPluginNotice(e
					.getPlugin()));
		}
		panel.add(simplePanel, new BorderLayoutData(LayoutRegion.CENTER));
	}

	@Override
	public Widget asWidget() {
		return panel;
	}

}
