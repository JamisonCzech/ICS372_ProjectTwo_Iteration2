package settings.refrigerator;

//This class handles the settings of temperature for the room, fridge and current temperature of the fridge.
//This class is derived from the Settings base class. 
public class FridgeSettings extends Settings{

	private static FridgeSettings instance;

	private FridgeSettings() {
		instance = this;
	}

	public static FridgeSettings instance() {
		if (instance == null) {
			instance = new FridgeSettings();
		}
		return instance;
	}

	

	@Override
	public void setDesiredRoomTemp(int desiredRoomTemp) {
		this.desiredRoomTemp = desiredRoomTemp;
		
	}

	@Override
	public void setDesiredRefrigeratorTemp(int desiredRefrigeratorTemp) {
		this.desiredRefrigeratorTemp = desiredRefrigeratorTemp;
		
	}
	
	@Override
	public void setCurrentTemp(int currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

}
