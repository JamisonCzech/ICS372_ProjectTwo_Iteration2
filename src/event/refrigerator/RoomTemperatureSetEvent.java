package event.refrigerator;

import java.util.EventObject;

import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

public class RoomTemperatureSetEvent extends EventObject {
	
	public RoomTemperatureSetEvent(Object source) {
		super(source);
		FridgeSettings fridgeSettings = FridgeSettings.instance();
		FreezerSettings freezerSettings = FreezerSettings.instance();
		RefrigeratorDisplay disp = RefrigeratorDisplay.instance();
		
		try {
			fridgeSettings.setDesiredRoomTemp(disp.getInRoomTemp());
			freezerSettings.setDesiredRoomTemp(disp.getInRoomTemp());
			System.out.println("Test: " + fridgeSettings.getDesiredRoomTemp());
		}
		catch(NullPointerException npe) {
			System.out.println("Failed");
		}
		
	}

}
