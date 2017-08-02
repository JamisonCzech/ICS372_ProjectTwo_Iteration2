package manager.refrigerator;
import java.util.EventListener;

import javax.swing.event.EventListenerList;

import event.refrigerator.FreezerDoorOpenRequestEvent;
import listener.refrigerator.FreezerOpenDoorRequestListener;

public class FreezerOpenDoorRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FreezerOpenDoorRequestManager instance;
	
	
	/**
	 * Private to make it a singleton
	 */
	private FreezerOpenDoorRequestManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FreezerOpenDoorRequestManager instance() {
		if (instance == null) {
			instance = new FreezerOpenDoorRequestManager();
		}
		return instance;
	}
	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFreezerOpenDoorRequestListener(FreezerOpenDoorRequestListener listener) {
		listenerList.add(FreezerOpenDoorRequestListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeFreezerOpenDoorRequestListener(FreezerOpenDoorRequestListener listener) {
		listenerList.remove(FreezerOpenDoorRequestListener.class, listener);
	}
	
	
	/**
	 * Handles the request to open door.
	 * 
	 * @param event
	 *            the CookRequestEvent object
	 */
	public void processEvent(FreezerDoorOpenRequestEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FreezerOpenDoorRequestListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FreezerOpenDoorRequestListener) listeners[index]).openDoorRequested(event);
		}
	}

}
