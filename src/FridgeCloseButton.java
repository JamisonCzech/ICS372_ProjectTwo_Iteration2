
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
