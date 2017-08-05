package timer.refrigerator;
import java.util.EventObject;

public class FridgeTimerRanOutEvent extends EventObject {
	/**
	 * The event is created with the identity of the
	 * 
	 * @param source
	 *            the object that created the event
	 */
	public FridgeTimerRanOutEvent(Object source) {
		super(source);
	}

}
