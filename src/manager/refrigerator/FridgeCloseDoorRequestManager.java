package manager.refrigerator;
import java.util.EventListener;

import javax.swing.event.EventListenerList;

import event.refrigerator.FridgeDoorCloseRequestEvent;
import listener.refrigerator.FridgeCloseDoorRequestListener;

public class FridgeCloseDoorRequestManager {

	private EventListenerList listenerList = new EventListenerList();
	private static FridgeCloseDoorRequestManager instance;
	
	
	/**
	 * Private to make it a singleton
	 */
	private FridgeCloseDoorRequestManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FridgeCloseDoorRequestManager instance() {
		if (instance == null) {
			instance = new FridgeCloseDoorRequestManager();
		}
		return instance;
	}
	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFridgeCloseDoorRequestListener(FridgeCloseDoorRequestListener listener) {
		listenerList.add(FridgeCloseDoorRequestListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeFridgeCloseDoorRequestListener(FridgeCloseDoorRequestListener listener) {
		listenerList.remove(FridgeCloseDoorRequestListener.class, listener);
	}
	
	
	/**
	 * Handles the request to close doors.
	 * 
	 * @param event
	 *            the CookRequestEvent object
	 */
	public void processEvent(FridgeDoorCloseRequestEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FridgeCloseDoorRequestListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FridgeCloseDoorRequestListener) listeners[index]).closeDoorRequested(event);
		}
	}

}
