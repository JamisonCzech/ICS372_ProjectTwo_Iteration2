package manager.refrigerator;

import java.util.EventListener;

import javax.swing.event.EventListenerList;

import event.refrigerator.FreezerDoorCloseRequestEvent;
import listener.refrigerator.FreezerCloseDoorRequestListener;

public class FreezerCloseDoorRequestManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FreezerCloseDoorRequestManager instance;

	/**
	 * Private to make it a singleton
	 */
	private FreezerCloseDoorRequestManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FreezerCloseDoorRequestManager instance() {
		if (instance == null) {
			instance = new FreezerCloseDoorRequestManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            an object that wants to listen to the event
	 */
	public void addFreezerCloseDoorRequestListener(FreezerCloseDoorRequestListener listener) {
		listenerList.add(FreezerCloseDoorRequestListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the object to be removed
	 */
	public void removeFreezerCloseDoorRequestListener(FreezerCloseDoorRequestListener listener) {
		listenerList.remove(FreezerCloseDoorRequestListener.class, listener);
	}

	/**
	 * Handles the request to close doors.
	 * 
	 * @param event
	 *            the CookRequestEvent object
	 */
	public void processEvent(FreezerDoorCloseRequestEvent event) {
		EventListener[] listeners = listenerList.getListeners(FreezerCloseDoorRequestListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FreezerCloseDoorRequestListener) listeners[index]).closeDoorRequested(event);
		}
	}
}