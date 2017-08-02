import java.util.EventObject;

public class TimerRanOutEvent extends EventObject {
	/**
	 * The event is created with the identity of the
	 * 
	 * @param source
	 *            the object that created the event
	 */
	public TimerRanOutEvent(Object source) {
		super(source);
	}

}
