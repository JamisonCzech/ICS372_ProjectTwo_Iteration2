

import java.util.EventObject;

//This class derives from EventObject super class and constructs the Room temperature set request event.
public class RoomTemperatureSetEvent extends EventObject {

	public RoomTemperatureSetEvent(Object source) {
		super(source);
	}

}
