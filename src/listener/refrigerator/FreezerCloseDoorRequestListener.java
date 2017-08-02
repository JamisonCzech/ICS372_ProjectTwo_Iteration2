package listener.refrigerator;
import java.util.EventListener;

import event.refrigerator.FreezerDoorCloseRequestEvent;

public interface FreezerCloseDoorRequestListener extends EventListener {

	/**
	 * Processes close door requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void closeDoorRequested(FreezerDoorCloseRequestEvent event);
}
