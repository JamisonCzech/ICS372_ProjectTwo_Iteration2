package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FridgeDoorCloseRequestEvent;
import manager.refrigerator.FridgeCloseDoorRequestManager;

//this class derives from the GUI button super class and handles Fridge close button events.
public class FridgeCloseButton extends GUIButton {

	public FridgeCloseButton(String string) {
		super(string);
		
	}

	/**
	 *
	 * @param source RefrigeratorDisplay source
	 *               processes Fridge Door Closed
	 *               button pushed.
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		FridgeCloseDoorRequestManager.instance()
		.processEvent(new FridgeDoorCloseRequestEvent(source));

	}

}
