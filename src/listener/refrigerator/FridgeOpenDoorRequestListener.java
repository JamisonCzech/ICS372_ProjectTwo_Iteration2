package listener.refrigerator;
import java.util.EventListener;

import event.refrigerator.FridgeDoorOpenRequestEvent;

//This is an interface class for fridge open door event listener and is derived from the Event Listener class.
public interface FridgeOpenDoorRequestListener extends EventListener{
	/**
	 * Processes door open requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void openDoorRequested(FridgeDoorOpenRequestEvent event);

}
