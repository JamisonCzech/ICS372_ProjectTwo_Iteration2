package timer.refrigerator;
import java.util.EventListener;

/**
 * To be implemented by any class that waits for timer ticks
 * 
 * @author Brahma Dathan
 *
 */
public interface TimerTickedListener extends EventListener {
	/**
	 * When the timer ticks, this method gets called
	 * 
	 * @param event
	 *            the event object
	 */
	public void timerTicked(TimerTickedEvent event);
}
