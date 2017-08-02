package event.refrigerator;
import java.util.EventObject;

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
