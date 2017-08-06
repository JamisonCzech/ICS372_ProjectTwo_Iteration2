package listener.refrigerator;
import java.util.EventListener;

import event.refrigerator.FreezerDoorOpenRequestEvent;

//This is an interface class for freezer open door event listener and is derived from the Event Listener class.
public interface FreezerOpenDoorRequestListener extends EventListener {

	
	/**
	 * Processes open door requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void openDoorRequested(FreezerDoorOpenRequestEvent event);
}

