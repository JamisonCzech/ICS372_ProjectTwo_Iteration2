
import java.util.EventListener;

import javax.swing.event.EventListenerList;

/**
 * This class manages the listeners associated with states that must act when
 * the timer runs out.
 * 
 * @author mh6624pa
 *
 */
public class FridgeTimerRanOutManager {
	private EventListenerList listenerList = new EventListenerList();
	private static FridgeTimerRanOutManager instance;

	/**
	 * Private for making the class a singleton
	 */
	private FridgeTimerRanOutManager() {
	}

	/**
	 * Returns the instance of the class
	 * 
	 * @return the only instance of the class
	 */
	public static FridgeTimerRanOutManager instance() {
		if (instance == null) {
			instance = new FridgeTimerRanOutManager();
		}
		return instance;
	}

	/**
	 * Add a listener
	 * 
	 * @param listener
	 *            the listener to be added
	 */
	public void addTimerRanOutListener(FridgeTimerRanOutListener listener) {
		listenerList.add(FridgeTimerRanOutListener.class, listener);
	}

	/**
	 * Remove a listener
	 * 
	 * @param listener
	 *            the listener to be removed
	 */
	public void removeTimerRanOutListener(FridgeTimerRanOutListener listener) {
		listenerList.remove(FridgeTimerRanOutListener.class, listener);
	}

	/**
	 * Process the event by calling the timeRanOut method of the listener
	 * 
	 * @param event
	 *            the TimerRanoutEvent object
	 */
	public void processEvent(FridgeTimerRanOutEvent event) {
		EventListener[] listeners = listenerList
				.getListeners(FridgeTimerRanOutListener.class);
		for (int index = 0; index < listeners.length; index++) {
			((FridgeTimerRanOutListener) listeners[index]).timerRanOut(event);
		}
	}
}
