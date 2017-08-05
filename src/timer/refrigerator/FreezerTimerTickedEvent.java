package timer.refrigerator;
import java.util.EventObject;

/**
 * The class represents the ticking of a timer.
 * 
 * @author Brahma Dathan
 *
 */
public class FreezerTimerTickedEvent extends EventObject {
	/**
	 * Creates an instance. Does not store any info.
	 * 
	 * @param source
	 *            the creator
	 */
	public FreezerTimerTickedEvent(Object source) {
		super(source);
	}

}
