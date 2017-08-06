package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FridgeDoorOpenRequestEvent;
import manager.refrigerator.FridgeOpenDoorRequestManager;

//Fridge open button
public class FridgeOpenButton extends GUIButton {

	public FridgeOpenButton(String string) {
		super(string);
		
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FridgeOpenDoorRequestManager.instance()
		.processEvent(new FridgeDoorOpenRequestEvent(source));


	}

}
