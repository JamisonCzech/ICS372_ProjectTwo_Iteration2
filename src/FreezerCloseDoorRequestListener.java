import java.util.EventListener;

public interface FreezerCloseDoorRequestListener extends EventListener {

	/**
	 * Processes close door requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void closeDoorRequested(FreezerDoorCloseRequestEvent event);
}
