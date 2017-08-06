package listener.refrigerator;

import java.util.EventListener;

import event.refrigerator.FreezerTemperatureSetEvent;
import event.refrigerator.RoomTemperatureSetEvent;

//This is an interface class for freezer set temperature event listener and is derived from the Event Listener class.
public interface FreezerTemperatureSetListener extends EventListener {

	
	/**
	 * Processes room temperature set button
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void freezerTemperatureSet(FreezerTemperatureSetEvent event);
}
