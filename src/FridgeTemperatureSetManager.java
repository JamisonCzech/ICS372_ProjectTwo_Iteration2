

import javax.swing.event.EventListenerList;

public class FridgeTemperatureSetManager {
	

	//private EventListenerList listenerList = new EventListenerList();
	private static FridgeTemperatureSetManager instance;
	private static RefrigeratorDisplay display;
	
	private static FridgeSettings fridgeSettings;
	/**
	 * Private to make it a singleton
	 */
	private  FridgeTemperatureSetManager() {
	}
	
	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FridgeTemperatureSetManager instance() {
		if (instance == null) {
			instance = new FridgeTemperatureSetManager();
		}
		return instance;
	}
	
//	/**
//	 * Adds a listener
//	 * 
//	 * @param listener
//	 *            an object that wants to listen to the event
//	 */
//	public void addFridgeTemperatureSetListener(FridgeTemperatureSetListener listener) {
//		listenerList.add(FridgeTemperatureSetListener.class, listener);
//	}
//
//
//	/**
//	 * remove a listener
//	 * 
//	 * @param listener
//	 *            an object that wants to listen to the event
//	 */
//	public void removeFridgeTemperatureSetListener(FridgeTemperatureSetListener listener) {
//		listenerList.remove(FridgeTemperatureSetListener.class, listener);
//	}


	/**
	 *
	 * @param event FridgeTemperatureSetEvent event
	 *              error handling for values not entered
	 *              within the parameters of the min and max temps
	 *              for the Fridge.
	 *
	 */
	public void processEvent(FridgeTemperatureSetEvent event) {
		
		 fridgeSettings = FridgeSettings.instance();
		 display = RefrigeratorDisplay.instance();

		try {
			int desiredFridgeTemp = display.getFridgeTemp();
			int fridgeHighTemp = fridgeSettings.getHighTemp();
			int fridgeLowTemp = fridgeSettings.getLowTemp();
			display.clearWarning();
			if ((fridgeHighTemp >= desiredFridgeTemp) && (fridgeLowTemp <= desiredFridgeTemp)) {
				fridgeSettings.setDesiredRefrigeratorTemp(desiredFridgeTemp);
			} else {
				display.setWarning("Temperature not changed. Fridge temperature must be between " + fridgeLowTemp + " and " + fridgeHighTemp);
			}
		} catch (NullPointerException npe) {
			display.clearWarning();
			display.setWarning("Invalid fridge temperature value");
		}
	}	
}
