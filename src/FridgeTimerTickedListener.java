
import java.util.EventListener;

/**
 * To be implemented by any class that waits for timer ticks
 * 
 * @author Brahma Dathan
 *
 */
public interface FridgeTimerTickedListener extends EventListener {
	/**
	 * When the timer ticks, this method gets called
	 * 
	 * @param event
	 *            the event object
	 */
	public void timerTicked(FridgeTimerTickedEvent event);
}
