package manager.refrigerator;

import javax.swing.event.EventListenerList;

import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.RoomTemperatureSetEvent;
import listener.refrigerator.RoomTemperatureSetListener;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

public class RoomTemperatureSetManager {
	
	private EventListenerList listenerList = new EventListenerList();
	private static RoomTemperatureSetManager instance;
	private static RefrigeratorDisplay display;
	
	private static FridgeSettings fridgeSettings;
	private static FreezerSettings freezergeSettings;
	
	/**
	 * Private to make it a singleton
	 */
	private RoomTemperatureSetManager() {
		fridgeSettings = FridgeSettings.instance();
		
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static RoomTemperatureSetManager instance() {
		if (instance == null) {
			instance = new RoomTemperatureSetManager();
		}
		return instance;
	}
	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addRoomTemperatureSetListener(RoomTemperatureSetListener listener) {
		listenerList.add(RoomTemperatureSetListener.class, listener);
	}


	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeRoomTemperatureSetListener(RoomTemperatureSetListener listener) {
		listenerList.remove(RoomTemperatureSetListener.class, listener);
	}
	
	
	/**
	 * Handles the request to set temperature.
	 * 
	 * @param event
	 *            the Temperature Event object
	 */
	public void processEvent(RoomTemperatureSetEvent event) {
		//fridgeSettings.setDesiredRefrigeratorTemp(display.getInRoomTemp());
		//freezergeSettings.setDesiredRefrigeratorTemp(display.getInRoomTemp());
//		EventListener[] listeners = listenerList
//				.getListeners(RoomTemperatureSetListener.class);
//		for (int index = 0; index < listeners.length; index++) {
//			((RoomTemperatureSetListener) listeners[index]).roomTemperatureSet(event);
//			
//			
//		}
	}

	
}
