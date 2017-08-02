package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FridgeDoorCloseRequestEvent;
import manager.refrigerator.FridgeCloseDoorRequestManager;

public class FridgeCloseButton extends GUIButton {

	public FridgeCloseButton(String string) {
		super(string);
		
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FridgeCloseDoorRequestManager.instance()
		.processEvent(new FridgeDoorCloseRequestEvent(source));

	}

}
