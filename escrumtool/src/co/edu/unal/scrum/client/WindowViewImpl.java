/*
 * Copyright 2010 Florian Sauter
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package co.edu.unal.scrum.client;

import com.extjs.gxt.ui.client.event.WindowEvent;
import com.extjs.gxt.ui.client.event.WindowListener;
import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.PopupPanel;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PopupViewCloseHandler;
import com.gwtplatform.mvp.client.PopupViewImpl;

/**
 * A simple implementation of {@link PopupView} that can be used when the widget
 * returned by {@link #asWidget()} inherits from {@link Window}.
 * 
 * @author Florian Sauter
 */
public abstract class WindowViewImpl extends PopupViewImpl {

	private WindowListener windowListener;

	/**
	 * The {@link WindowViewImpl} class is only a wrapper class for
	 * {@link PopupViewImpl} in order to deal with Ext GWT Windows.
	 * 
	 * @param eventBus
	 *            The {@link EventBus}.
	 */
	protected WindowViewImpl(final EventBus eventBus) {
		super(eventBus);
	}

	@Override
	public void show() {
		asWindow().show();
	}

	@Override
	public void hide() {
		asWindow().hide();
	}

	@Override
	public void center() {
		boolean wasVisible = asWindow().isVisible();
		if (wasVisible) {
			asWindow().center();
		} else {
			asWindow().hide();
		}
	}

	@Override
	public void setPosition(int left, int top) {
		asWindow().setPosition(left, top);
	}

	@Override
	public void setCloseHandler(
			final PopupViewCloseHandler windowViewCloseHandler) {
		if (windowViewCloseHandler == null && windowListener != null) {
			asWindow().removeWindowListener(windowListener);
		} else {
			windowListener = new WindowListener() {
				public void windowHide(WindowEvent we) {
					windowViewCloseHandler.onClose();
				};
			};
			asWindow().addWindowListener(windowListener);
		}
	}

	/**
	 * Retrieves this view as a {@link Window}. See {@link #asWidget()}.
	 * 
	 * @return This view as a {@link Window} object.
	 */
	protected Window asWindow() {
		return (Window) asWidget();
	}

	/**
	 * This method only returns null. Use {@link WindowViewImpl#asWindow()}
	 * instead.
	 * 
	 * @deprecated
	 * @return null
	 */
	@Override
	@Deprecated
	protected PopupPanel asPopupPanel() {
		return null;
	}
}
