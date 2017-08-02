
public class FreezerOpenButton extends GUIButton {

	public FreezerOpenButton(String string) {
		super(string);
		
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FreezerOpenDoorRequestManager.instance()
		.processEvent(new FreezerDoorOpenRequestEvent(source));

	}

}
