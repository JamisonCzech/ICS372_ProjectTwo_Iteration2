

// This class handles the settings of temperature for the room, freezer and current temperature of the freezer.
//This class is derived from the Settings base class. 
public class FreezerSettings extends Settings {

	private static FreezerSettings instance;


	/**
	 * Singleton functions FreezerSettings
	 */
	private FreezerSettings() {
		instance = this;
	}

	public static FreezerSettings instance() {
		if (instance == null) {
			instance = new FreezerSettings();
		}
		return instance;
	}

	/**
	 * Sets FreezerSettings instance desiredRoomTemp
	 * @param desiredRoomTemp desiredRoomTemp
	 */
	@Override
	public void setDesiredRoomTemp(int desiredRoomTemp) {
		this.desiredRoomTemp = desiredRoomTemp;
		
	}

	/**
	 * Sets FreezerSettings instance desiredRefrigeratorTemp
	 * @param desiredRefrigeratorTemp desiredRefrigeratorTemp
	 */
	@Override
	public void setDesiredRefrigeratorTemp(int desiredRefrigeratorTemp) {
		this.desiredRefrigeratorTemp = desiredRefrigeratorTemp;
		
	}

	/**
	 * Sets FreezerSettings instance currentTemperature
	 * @param currentTemperature currentTemperature
	 */
	@Override
	public void setCurrentTemp(int currentTemperature) {
		this.currentTemperature = currentTemperature;
	}
}
