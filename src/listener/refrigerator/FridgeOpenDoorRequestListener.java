package listener.refrigerator;
import java.util.EventListener;

import event.refrigerator.FridgeDoorOpenRequestEvent;

public interface FridgeOpenDoorRequestListener extends EventListener{
	/**
	 * Processes cook requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void openDoorRequested(FridgeDoorOpenRequestEvent event);

}
