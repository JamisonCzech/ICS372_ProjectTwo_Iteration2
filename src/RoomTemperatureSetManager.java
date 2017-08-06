

import javax.swing.event.EventListenerList;

public class RoomTemperatureSetManager {
	
	//private EventListenerList listenerList = new EventListenerList();
	private static RoomTemperatureSetManager instance;
	private static RefrigeratorDisplay display;
	
	private static FridgeSettings fridgeSettings;
	private static FreezerSettings freezerSettings;
	
	/**
	 * Private to make it a singleton
	 */
	private RoomTemperatureSetManager() {
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
//	/**
//	 * Adds a listener
//	 * 
//	 * @param listener
//	 *            an object that wants to listen to the event
//	 */
//	public void addRoomTemperatureSetListener(RoomTemperatureSetListener listener) {
//		listenerList.add(RoomTemperatureSetListener.class, listener);
//	}
//
//
//	/**
//	 * Removes a listener
//	 * 
//	 * @param listener
//	 *            the object to be removed
//	 */
//	public void removeRoomTemperatureSetListener(RoomTemperatureSetListener listener) {
//		listenerList.remove(RoomTemperatureSetListener.class, listener);
//	}


	/**
	 *
	 * @param event RoomTemperatureSetEvent event
	 *              error handling for values not entered
	 *              within the parameters of the min and max temps
	 *              for the Room.
	 */
	public void processEvent(RoomTemperatureSetEvent event) {
		
		fridgeSettings = FridgeSettings.instance();
		freezerSettings = FreezerSettings.instance();
		display = RefrigeratorDisplay.instance();

		try {
			int roomTemp = display.getInRoomTemp();
			int roomHigh = fridgeSettings.getRoomHigh();
			int roomLow = fridgeSettings.getRoomLow();
			display.clearWarning();
			if ((roomLow <= roomTemp) && (roomHigh >= roomTemp)) {
				fridgeSettings.setDesiredRoomTemp(roomTemp);
				freezerSettings.setDesiredRoomTemp(roomTemp);
			} else {
				display.setWarning("Temperature not changed. Room temperature must be between " + roomLow + " and " + roomHigh);
			}

		} catch (NullPointerException npe) {
			display.clearWarning();
			display.setWarning("Invalid room temperature value");
		}
	}
}
