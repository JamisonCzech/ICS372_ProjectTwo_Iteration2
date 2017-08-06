
import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * This class manages the listeners associated with states that must act when
 * the timer ticks.
 * 
 * @author Brahma Dathan
 *
 */
public class FreezerTimerTickedManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FreezerTimerTickedManager instance;

	/**
	 * The constructor is private to ensure that it is a singleton
	 */
	private FreezerTimerTickedManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FreezerTimerTickedManager instance() {
		if (instance == null) {
			instance = new FreezerTimerTickedManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addTimerTickedListener(FreezerTimerTickedListener listener) {
		listenerList.add(FreezerTimerTickedListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeTimerTickedListener(FreezerTimerTickedListener listener) {
		listenerList.remove(FreezerTimerTickedListener.class, listener);
	}

	/**
	 * Processes the event by calling the timerTicked method of each listener
	 * 
	 * @param event
	 */
	public void processEvent(FreezerTimerTickedEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FreezerTimerTickedListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FreezerTimerTickedListener) listeners[index]).timerTicked(event);
		}
	}
}
