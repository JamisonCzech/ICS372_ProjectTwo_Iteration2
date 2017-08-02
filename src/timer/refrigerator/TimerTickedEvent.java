package timer.refrigerator;
import java.util.EventObject;

/**
 * The class represents the ticking of a timer.
 * 
 * @author Brahma Dathan
 *
 */
public class TimerTickedEvent extends EventObject {
	/**
	 * Creates an instance. Does not store any info.
	 * 
	 * @param source
	 *            the creator
	 */
	public TimerTickedEvent(Object source) {
		super(source);
	}

}
