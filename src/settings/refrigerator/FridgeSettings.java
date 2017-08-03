package settings.refrigerator;

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

}
