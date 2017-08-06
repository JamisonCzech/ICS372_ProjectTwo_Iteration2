package settings.refrigerator;

// This class handles the settings of temperature for the room, freezer and current temperature of the freezer.
//This class is derived from the Settings base class. 
public class FreezerSettings extends Settings {

	private static FreezerSettings instance;

	private FreezerSettings() {
		instance = this;
	}

	public static FreezerSettings instance() {
		if (instance == null) {
			instance = new FreezerSettings();
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
