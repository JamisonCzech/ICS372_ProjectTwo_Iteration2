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
	
	private EventListenerList listenerList = new EventListenerList();
	private static FreezerTemperatureSetManager instance;
	private static RefrigeratorDisplay display;
	
	private static FreezerSettings settings;
	/**
	 * Private to make it a singleton
	 */
	private  FreezerTemperatureSetManager() {
		settings = FreezerSettings.instance();
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
	
	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFreezerTemperatureSetListener(FreezerTemperatureSetListener listener) {
		listenerList.add(FreezerTemperatureSetListener.class, listener);
	}


	/**
	 * remove a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void removeFreezerTemperatureSetListener(FreezerTemperatureSetListener listener) {
		listenerList.remove(FreezerTemperatureSetListener.class, listener);
	}
	
	
	public void processEvent(FreezerTemperatureSetEvent event) {
		//settings.setDesiredRefrigeratorTemp(display.getFreezerTemp());
	//EventListener[] listeners = listenerList
				//.getListeners(FreezerTemperatureSetListener.class);
		//for (int index = 0; index < listeners.length; index++) {
			//((FreezerTemperatureSetListener) listeners[index]).freezerTemperatureSet(event);
			
			
	//}


	}	
}
