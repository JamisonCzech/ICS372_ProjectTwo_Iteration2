//this class derives from the GUI button super class and handles set room temperature button events.
public class SetRoomButton extends GUIButton {
	
	//RoomTemperatureSetManager tempManager; 

	public SetRoomButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	/**
	 *
	 * @param source RefrigeratorDisplay source
	 *               setter for SetRoomButton
	 */
	@Override
	public void inform(RefrigeratorDisplay source) {
		RoomTemperatureSetManager.instance()
		.processEvent(new RoomTemperatureSetEvent(source));

	}

}
