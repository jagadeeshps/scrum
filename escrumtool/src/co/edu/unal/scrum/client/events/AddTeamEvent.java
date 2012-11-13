package co.edu.unal.scrum.client.events;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public class AddTeamEvent extends GwtEvent<AddTeamEvent.AddTeamHandler> {

	public static Type<AddTeamHandler> TYPE = new Type<AddTeamHandler>();
	private int teamSize;

	public interface AddTeamHandler extends EventHandler {
		void onAddTeam(AddTeamEvent event);
	}

	public interface AddTeamHasHandlers extends HasHandlers {
		HandlerRegistration addAddTeamHandler(AddTeamHandler handler);
	}

	public AddTeamEvent(int teamSize) {
		this.teamSize = teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}

	@Override
	protected void dispatch(AddTeamHandler handler) {
		handler.onAddTeam(this);
	}

	@Override
	public Type<AddTeamHandler> getAssociatedType() {
		return TYPE;
	}

	public static Type<AddTeamHandler> getType() {
		return TYPE;
	}

	public static void fire(HasHandlers source, int teamSize) {
		source.fireEvent(new AddTeamEvent(teamSize));
	}
}
