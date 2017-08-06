package listener.refrigerator;

import java.util.EventListener;

import event.refrigerator.RoomTemperatureSetEvent;

//This is an interface class for set room temperature event listener and is derived from the Event Listener class.
public interface RoomTemperatureSetListener extends EventListener{
	
	/**
	 * Processes room temperature set button
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void roomTemperatureSet(RoomTemperatureSetEvent event);
	}
