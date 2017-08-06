package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FreezerTemperatureSetEvent;
import event.refrigerator.FridgeTemperatureSetEvent;
import manager.refrigerator.FreezerTemperatureSetManager;
import manager.refrigerator.FridgeTemperatureSetManager;

//Set fridge temperature button
public class SetFridgeButton extends GUIButton {

	public SetFridgeButton(String string) {
		super(string);
		
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FridgeTemperatureSetManager.instance()
		.processEvent(new FridgeTemperatureSetEvent(source));

	}

}
