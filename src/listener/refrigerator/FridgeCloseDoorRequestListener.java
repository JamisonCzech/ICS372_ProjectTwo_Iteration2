package listener.refrigerator;
import java.util.EventListener;

import event.refrigerator.FridgeDoorCloseRequestEvent;

public interface FridgeCloseDoorRequestListener  extends EventListener{

	/**
	 * Processes close door requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void closeDoorRequested(FridgeDoorCloseRequestEvent event);
}
