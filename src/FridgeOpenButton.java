
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
