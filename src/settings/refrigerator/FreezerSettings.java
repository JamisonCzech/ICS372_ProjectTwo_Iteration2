package settings.refrigerator;

public class FreezerSettings extends Settings{

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
}
