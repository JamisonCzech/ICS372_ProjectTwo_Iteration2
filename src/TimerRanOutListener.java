import java.util.EventListener;

/**
 * Any class that wants to listen to timer going off should implement this
 * interface.
 * 
 * @author Brahma Dathan
 *
 */
public interface TimerRanOutListener extends EventListener {
	/**
	 * This method should implement the functionality to handle the situation of
	 * the timer running out.
	 * 
	 * @param event
	 *            the description of the event
	 */
	public void timerRanOut(TimerRanOutEvent event);
}
