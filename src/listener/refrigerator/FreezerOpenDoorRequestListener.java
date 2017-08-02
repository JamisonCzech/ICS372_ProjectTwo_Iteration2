package listener.refrigerator;
import java.util.EventListener;

import event.refrigerator.FreezerDoorOpenRequestEvent;

public interface FreezerOpenDoorRequestListener extends EventListener {

	
	/**
	 * Processes cook requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void openDoorRequested(FreezerDoorOpenRequestEvent event);
}
