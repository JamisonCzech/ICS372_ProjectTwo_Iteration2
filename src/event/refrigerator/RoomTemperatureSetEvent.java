package event.refrigerator;

import java.util.EventObject;

import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

public class RoomTemperatureSetEvent extends EventObject {

	public RoomTemperatureSetEvent(Object source) {
		super(source);
	}

}
