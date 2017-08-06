package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FreezerTemperatureSetEvent;
import event.refrigerator.FridgeTemperatureSetEvent;
import manager.refrigerator.FreezerTemperatureSetManager;
import manager.refrigerator.FridgeTemperatureSetManager;

//this class derives from the GUI button super class and handles set fridge temperature button events.
public class SetFridgeButton extends GUIButton {

	public SetFridgeButton(String string) {
		super(string);
		
	}

	/**
	 *
	 * @param source RefrigeratorDisplay source
	 *               setter for SetFridgeButton
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		FridgeTemperatureSetManager.instance()
		.processEvent(new FridgeTemperatureSetEvent(source));

	}

}
