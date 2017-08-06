
import java.util.EventObject;

public class FreezerTimerRanOutEvent extends EventObject {
	/**
	 * The event is created with the identity of the
	 * 
	 * @param source
	 *            the object that created the event
	 */
	public FreezerTimerRanOutEvent(Object source) {
		super(source);
	}

}
