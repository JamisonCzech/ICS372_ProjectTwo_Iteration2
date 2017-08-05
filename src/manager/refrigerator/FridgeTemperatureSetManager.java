package manager.refrigerator;

import javax.swing.event.EventListenerList;

import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FreezerTemperatureSetEvent;
import event.refrigerator.FridgeTemperatureSetEvent;
import listener.refrigerator.FreezerTemperatureSetListener;
import listener.refrigerator.FridgeTemperatureSetListener;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

public class FridgeTemperatureSetManager {
	

	//private EventListenerList listenerList = new EventListenerList();
	private static FridgeTemperatureSetManager instance;
	private static RefrigeratorDisplay display;
	
	private static FridgeSettings fridgeSettings;
	/**
	 * Private to make it a singleton
	 */
	private  FridgeTemperatureSetManager() {
		fridgeSettings = FridgeSettings.instance();
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
