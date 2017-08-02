import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * This class manages the listeners associated with states that must act when
 * the timer runs out.
 * 
 * @author mh6624pa
 *
 */
public class TimerRanOutManager {
	private EventListenerList listenerList = new EventListenerList();
	private static TimerRanOutManager instance;

	/**
	 * Private for making the class a singleton
	 */
	private TimerRanOutManager() {
	}

	/**
	 * Returns the instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static TimerRanOutManager instance() {
		if (instance == null) {
			instance = new TimerRanOutManager();
		}
		return instance;
	}

	/**
	 * Add a listener
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addTimerRanOutListener(TimerRanOutListener listener) {
		listenerList.add(TimerRanOutListener.class, listener);
	}

	/**
	 * Remove a listener
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeTimerRanOutListener(TimerRanOutListener listener) {
		listenerList.remove(TimerRanOutListener.class, listener);
	}

	/**
	 * Process the event by calling the timeRanOut method of the listener
	 * 
	 * @param event
	 *            the TimerRanoutEvent object
	 */
	public void processEvent(TimerRanOutEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(TimerRanOutListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((TimerRanOutListener) listeners[index]).timerRanOut(event);
		}
	}
}
