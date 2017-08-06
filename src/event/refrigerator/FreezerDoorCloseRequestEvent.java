package event.refrigerator;
import java.util.EventObject;

// This class derives from EventObject super class and constructs the Freezer door close request event.
public class FreezerDoorCloseRequestEvent extends EventObject{
	/**
	 * Constructor simply calls the super class's constructor
	 * with the supplied source
	 * @param source whatever we get
	 */
	public FreezerDoorCloseRequestEvent(Object source) {
		super(source);
	}

}
