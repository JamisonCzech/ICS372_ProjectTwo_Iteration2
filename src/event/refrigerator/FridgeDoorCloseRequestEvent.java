package event.refrigerator;
import java.util.EventObject;

public class FridgeDoorCloseRequestEvent extends EventObject {
	/**
	 * Constructor simply calls the super class's constructor
	 * with the supplied source
	 * @param source whatever we get
	 */
	public FridgeDoorCloseRequestEvent(Object source) {
		super(source);
	}
}
