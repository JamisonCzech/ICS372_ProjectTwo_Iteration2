import java.util.EventObject;

public class FridgeDoorOpenRequestEvent extends EventObject{

	/**
	 * Constructor simply calls the super class's constructor
	 * with the supplied source
	 * @param source whatever we get
	 */
	public FridgeDoorOpenRequestEvent(Object source) {
		super(source);
	}
}
