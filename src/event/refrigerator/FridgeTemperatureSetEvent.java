package event.refrigerator;

import java.util.EventObject;

import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;
import settings.refrigerator.FridgeSettings;

public class FridgeTemperatureSetEvent extends EventObject{
	
	public FridgeTemperatureSetEvent(Object source) {
		super(source);
		FridgeSettings fridgeSettings = FridgeSettings.instance();
		RefrigeratorDisplay disp = RefrigeratorDisplay.instance();
		
		try {
			fridgeSettings.setDesiredRoomTemp(disp.getFridgeTemp());
			System.out.println("Fridge temp: " + fridgeSettings.getDesiredRefrigeratorTemp());
		}
		catch(NullPointerException npe) {
			System.out.println("Failed");
		}

 }
}
