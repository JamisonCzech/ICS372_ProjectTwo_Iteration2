
import java.util.EventListener;

//This is an interface class for fridge close door event listener and is derived from the Event Listener class.
public interface FridgeCloseDoorRequestListener  extends EventListener{

	/**
	 * Processes close door requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void closeDoorRequested(FridgeDoorCloseRequestEvent event);
}
