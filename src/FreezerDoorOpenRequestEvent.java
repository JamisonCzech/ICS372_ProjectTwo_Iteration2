
import java.util.EventObject;

//This class derives from EventObject super class and constructs the Freezer door open request event.
public class FreezerDoorOpenRequestEvent extends EventObject  {
	
	/**
	 * Constructor simply calls the super class's constructor
	 * with the supplied source
	 * @param source whatever we get
	 */
	public FreezerDoorOpenRequestEvent(Object source) {
		super(source);
	}
}
