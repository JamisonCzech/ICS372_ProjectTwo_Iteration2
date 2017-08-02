import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * This class manages the listeners associated with states that must act when
 * the timer ticks.
 * 
 * @author Brahma Dathan
 *
 */
public class TimerTickedManager {
	private EventListenerList listenerList = new EventListenerList();
	private static TimerTickedManager instance;

	/**
	 * The constructor is private to ensure that it is a singleton
	 */
	private TimerTickedManager() {
	}

	/**
	 * Returns the only instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static TimerTickedManager instance() {
		if (instance == null) {
			instance = new TimerTickedManager();
		}
		return instance;
	}

	/**
	 * Adds a listener
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addTimerTickedListener(TimerTickedListener listener) {
		listenerList.add(TimerTickedListener.class, listener);
	}

	/**
	 * Removes a listener
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeTimerTickedListener(TimerTickedListener listener) {
		listenerList.remove(TimerTickedListener.class, listener);
	}

	/**
	 * Processes the event by calling the timerTicked method of each listener
	 * 
	 * @param event
	 */
	public void processEvent(TimerTickedEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(TimerTickedListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((TimerTickedListener) listeners[index]).timerTicked(event);
		}
	}
}
