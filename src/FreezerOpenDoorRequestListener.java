import java.util.EventListener;

public interface FreezerOpenDoorRequestListener extends EventListener {

	
	/**
	 * Processes cook requests
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void openDoorRequested(FreezerDoorOpenRequestEvent event);
}

