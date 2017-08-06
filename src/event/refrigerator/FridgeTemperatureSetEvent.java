package event.refrigerator;

import java.util.EventObject;

import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

//This class derives from EventObject super class and constructs the Fridge temperature set request event.
public class FridgeTemperatureSetEvent extends EventObject {

	/**
	 * Constructs a prototypical Event.
	 *
	 * @param    source    The object on which the Event initially occurred.
	 * @exception  IllegalArgumentException  if source is null.
	 */
	public FridgeTemperatureSetEvent(Object source) {
		super(source);
	}
}
