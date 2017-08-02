
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
