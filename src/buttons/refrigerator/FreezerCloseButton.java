package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FreezerDoorCloseRequestEvent;
import manager.refrigerator.FreezerCloseDoorRequestManager;

//Freezer close button
public class FreezerCloseButton extends GUIButton {

	public FreezerCloseButton(String string) {
		super(string);
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FreezerCloseDoorRequestManager.instance()
		.processEvent(new FreezerDoorCloseRequestEvent(source));

	}

}
