package listener.refrigerator;

import java.util.EventListener;

import event.refrigerator.FreezerTemperatureSetEvent;
import event.refrigerator.FridgeTemperatureSetEvent;

public interface FridgeTemperatureSetListener extends EventListener {
	/**
	 * Processes room temperature set button
	 * 
	 * @param event
	 *            the object that represents the event
	 */
	public void fridgeTemperatureSet(FridgeTemperatureSetEvent event);

}
