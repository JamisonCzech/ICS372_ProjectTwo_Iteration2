

import java.util.EventListener;

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
