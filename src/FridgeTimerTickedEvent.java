
import java.util.EventObject;

/**
 * The class represents the ticking of a timer.
 * 
 * @author Brahma Dathan
 *
 */
public class FridgeTimerTickedEvent extends EventObject {
	/**
	 * Creates an instance. Does not store any info.
	 * 
	 * @param source
	 *            the creator
	 */
	public FridgeTimerTickedEvent(Object source) {
		super(source);
	}

}
