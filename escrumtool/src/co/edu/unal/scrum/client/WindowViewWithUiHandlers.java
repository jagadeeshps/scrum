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

import com.extjs.gxt.ui.client.widget.Window;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.UiHandlers;

/**
 * A simple implementation of {@link PopupView} that can be used when the widget
 * returned by {@link #asWidget()} inherits from {@link Window}.
 * 
 * @author Florian Sauter
 */
public abstract class WindowViewWithUiHandlers<C extends UiHandlers> extends
		WindowViewImpl implements HasUiHandlers<C> {

	private C uiHandlers;

	protected WindowViewWithUiHandlers(EventBus eventBus) {
		super(eventBus);
	}

	protected C getUiHandlers() {
		return uiHandlers;
	}

	@Override
	public void setUiHandlers(C uiHandlers) {
		this.uiHandlers = uiHandlers;
	}
}
