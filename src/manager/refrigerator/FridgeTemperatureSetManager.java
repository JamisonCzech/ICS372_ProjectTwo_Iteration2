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
	

	private EventListenerList listenerList = new EventListenerList();
	private static FridgeTemperatureSetManager instance;
	private static RefrigeratorDisplay display;
	
	private static FridgeSettings settings;
	/**
	 * Private to make it a singleton
	 */
	private  FridgeTemperatureSetManager() {
		settings = FridgeSettings.instance();
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
	
	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFridgeTemperatureSetListener(FridgeTemperatureSetListener listener) {
		listenerList.add(FridgeTemperatureSetListener.class, listener);
	}


	/**
	 * remove a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void removeFridgeTemperatureSetListener(FridgeTemperatureSetListener listener) {
		listenerList.remove(FridgeTemperatureSetListener.class, listener);
	}
	
	
	public void processEvent(FridgeTemperatureSetEvent event) {
		//settings.setDesiredRefrigeratorTemp(display.getFreezerTemp());
	//EventListener[] listeners = listenerList
				//.getListeners(FreezerTemperatureSetListener.class);
		//for (int index = 0; index < listeners.length; index++) {
			//((FreezerTemperatureSetListener) listeners[index]).freezerTemperatureSet(event);
			
			
	//}


	}	

}
