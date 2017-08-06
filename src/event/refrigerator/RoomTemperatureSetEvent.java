package event.refrigerator;

import java.util.EventObject;

import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

//This class derives from EventObject super class and constructs the Room temperature set request event.
public class RoomTemperatureSetEvent extends EventObject {

	public RoomTemperatureSetEvent(Object source) {
		super(source);
	}

}
