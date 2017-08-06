//this class derives from the GUI button super class and handles Freezer open button events.
public class FreezerOpenButton extends GUIButton {

	public FreezerOpenButton(String string) {
		super(string);
		
	}

	/**
	 *
	 * @param source RefrigeratorDisplay source
     *               processes Freezer Door open
     *               button pushed.
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		FreezerOpenDoorRequestManager.instance()
		.processEvent(new FreezerDoorOpenRequestEvent(source));

	}

}
