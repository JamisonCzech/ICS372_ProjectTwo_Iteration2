import java.util.EventListener;

public interface FridgeCloseDoorRequestListener  extends EventListener{

	/**
	 * Processes close door requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void closeDoorRequested(FridgeDoorCloseRequestEvent event);
}
