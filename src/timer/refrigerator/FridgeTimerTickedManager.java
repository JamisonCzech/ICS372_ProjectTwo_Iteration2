package timer.refrigerator;
import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * This class manages the listeners associated with states that must act when
 * the timer ticks.
 * 
 * @author Brahma Dathan
 *
 */
public class FridgeTimerTickedManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FridgeTimerTickedManager instance;

	/**
	 * The constructor is private to ensure that it is a singleton
	 */
	private FridgeTimerTickedManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FridgeTimerTickedManager instance() {
		if (instance == null) {
			instance = new FridgeTimerTickedManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addTimerTickedListener(FridgeTimerTickedListener listener) {
		listenerList.add(FridgeTimerTickedListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeTimerTickedListener(FridgeTimerTickedListener listener) {
		listenerList.remove(FridgeTimerTickedListener.class, listener);
	}

	/**
	 * Processes the event by calling the timerTicked method of each listener
	 * 
	 * @param event
	 */
	public void processEvent(FridgeTimerTickedEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FridgeTimerTickedListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FridgeTimerTickedListener) listeners[index]).timerTicked(event);
		}
	}
}
