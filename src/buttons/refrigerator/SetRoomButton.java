package buttons.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.RoomTemperatureSetEvent;
import manager.refrigerator.RoomTemperatureSetManager;

public class SetRoomButton extends GUIButton {
	
	//RoomTemperatureSetManager tempManager; 

	public SetRoomButton(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inform(RefrigeratorDisplay source) {
		RoomTemperatureSetManager.instance()
		.processEvent(new RoomTemperatureSetEvent(source));

	}

}
