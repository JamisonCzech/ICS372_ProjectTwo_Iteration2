package event.refrigerator;

import java.util.EventObject;
import listener.refrigerator.FreezerTemperatureSetListener;
import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

//This class derives from EventObject super class and constructs the Freezer temperature set request event.
public class FreezerTemperatureSetEvent extends EventObject {

	public FreezerTemperatureSetEvent(Object source) {
		super(source);
	}
}
