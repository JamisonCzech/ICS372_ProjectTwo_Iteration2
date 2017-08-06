

import java.util.EventListener;

//This is an interface class for set fridge temperature event listener and is derived from the Event Listener class.
public interface FridgeTemperatureSetListener extends EventListener {
	/**
	 * Processes room temperature set button
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void fridgeTemperatureSet(FridgeTemperatureSetEvent event);

}
