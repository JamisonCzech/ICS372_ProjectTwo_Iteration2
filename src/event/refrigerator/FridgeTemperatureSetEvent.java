package event.refrigerator;

import java.util.EventObject;

import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

public class FridgeTemperatureSetEvent extends EventObject {

	public FridgeTemperatureSetEvent(Object source) {
		super(source);
	}
}
