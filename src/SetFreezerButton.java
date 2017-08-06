//this class derives from the GUI button super class and handles set Freezer temperature button events.
public class SetFreezerButton extends GUIButton {

	public SetFreezerButton(String string) {
		super(string);
		
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		FreezerTemperatureSetManager.instance()
		.processEvent(new FreezerTemperatureSetEvent(source));
	}
}
