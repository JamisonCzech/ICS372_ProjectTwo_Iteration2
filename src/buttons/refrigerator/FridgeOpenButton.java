package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FridgeDoorOpenRequestEvent;
import manager.refrigerator.FridgeOpenDoorRequestManager;

//this class derives from the GUI button super class and handles Fridge open button events.
public class FridgeOpenButton extends GUIButton {

	public FridgeOpenButton(String string) {
		super(string);
		
	}

	/**
	 *
	 * @param source RefrigeratorDisplay source
	 *               processes Fridge Door open
	 *               button pushed.
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		FridgeOpenDoorRequestManager.instance()
		.processEvent(new FridgeDoorOpenRequestEvent(source));


	}

}
