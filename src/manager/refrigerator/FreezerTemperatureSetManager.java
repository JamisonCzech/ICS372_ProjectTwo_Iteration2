package manager.refrigerator;

import java.util.EventListener;

import javax.swing.event.EventListenerList;

import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FreezerTemperatureSetEvent;
import event.refrigerator.RoomTemperatureSetEvent;
import listener.refrigerator.FreezerTemperatureSetListener;
import listener.refrigerator.RoomTemperatureSetListener;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

public class FreezerTemperatureSetManager {
	
	//private EventListenerList listenerList = new EventListenerList();
	private static FreezerTemperatureSetManager instance;
	private static RefrigeratorDisplay display;
	
	private static FreezerSettings freezerSettings;
	/**
	 * Private to make it a singleton
	 */
	private  FreezerTemperatureSetManager() {
	}
	
	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FreezerTemperatureSetManager instance() {
		if (instance == null) {
			instance = new FreezerTemperatureSetManager();
		}
		return instance;
	}
	
//	/**
//	 * Adds a listener
//	 * 
//	 * @param listener
//	 *            an object that wants to listen to the event
//	 */
//	public void addFreezerTemperatureSetListener(FreezerTemperatureSetListener listener) {
//		listenerList.add(FreezerTemperatureSetListener.class, listener);
//	}
//
//
//	/**
//	 * remove a listener
//	 * 
//	 * @param listener
//	 *            an object that wants to listen to the event
//	 */
//	public void removeFreezerTemperatureSetListener(FreezerTemperatureSetListener listener) {
//		listenerList.remove(FreezerTemperatureSetListener.class, listener);
//	}


	/**
	 *
	 * @param event FreezerTemperatureSetEvent event
	 *              error handling for values not entered
	 *              within the parameters of the min and max temps
	 *              for the freezer.
	 *
	 */
	public void processEvent(FreezerTemperatureSetEvent event) {
		freezerSettings = FreezerSettings.instance();
		display = RefrigeratorDisplay.instance();

		try {
			int desiredFreezerTemp = display.getFreezerTemp();
			int freezerHighTemp = freezerSettings.getHighTemp();
			int freezerLowTemp = freezerSettings.getLowTemp();
			display.clearWarning();
			if ((freezerHighTemp >= desiredFreezerTemp) && (freezerLowTemp <= desiredFreezerTemp)) {
				freezerSettings.setDesiredRefrigeratorTemp(display.getFreezerTemp());
			}
			else {
				display.setWarning("Temperature not changed. Fridge temperature must be between " + freezerLowTemp + " and " + freezerHighTemp);
			}

		} catch (NullPointerException npe) {
			display.clearWarning();
			display.setWarning("Invalid freezer temperature value");
		}
	}	
}
