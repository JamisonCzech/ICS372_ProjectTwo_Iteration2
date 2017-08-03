package listener.refrigerator;

import java.util.EventListener;

import event.refrigerator.RoomTemperatureSetEvent;

public interface RoomTemperatureSetListener extends EventListener{
	
	/**
	 * Processes room temperature set button
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void roomTemperatureSet(RoomTemperatureSetEvent event);
	

}
