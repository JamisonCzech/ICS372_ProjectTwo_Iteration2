/**
 * The FridgeClosedState class handles the actual mechanism of the fridge when the fridge door is closed. This class is responsible for maintaining the temperature
 *of the fridge when the doors are closed and handles switches between Cooling and Idle state of the fridge.
 */
public class FridgeClosedState extends FridgeState
		implements FridgeOpenDoorRequestListener, FridgeTimerRanOutListener, FridgeTimerTickedListener {

	private static FridgeClosedState instance;

	/**
	 * Private to make it a singleton
	 */
	private FridgeClosedState() {
	}

	public static FridgeClosedState instance() {
		if (instance == null) {
			instance = new FridgeClosedState();
		}
		return instance;
	}


	/**
	 * Adds Request Listeners
	 */
	@Override
	public void run() {
		FridgeOpenDoorRequestManager.instance().addFridgeOpenDoorRequestListener(instance);
		FridgeTimerRanOutManager.instance().addTimerRanOutListener(this);
		FridgeTimerTickedManager.instance().addTimerTickedListener(this);
		FridgeTimer.instance().setTimeValue(fridgeSettings.getRateLossDoorClosed());
		
		display.fridgeDoorClosed();
		display.fridgeTemp(fridgeSettings.getCurrentTemp());
		display.turnFridgeLightOff();
		display.fridgeIdle();
	}

	/**
	 * Removes Request Listeners
	 */
	@Override
	public void leave() {
		FridgeOpenDoorRequestManager.instance().removeFridgeOpenDoorRequestListener(this);
		FridgeTimerRanOutManager.instance().removeTimerRanOutListener(this);
		FridgeTimerTickedManager.instance().removeTimerTickedListener(this);
	}

	@Override
	public void openDoorRequested(FridgeDoorOpenRequestEvent event) {
		fridgeContext.changeCurrentState(FridgeOpenState.instance());
	}

	/**
	 * Immediately go to cooling state if desired temp is adjusted below
	 * current temp
	 * @param event FridgeTimerTickedEvent event
	 */
	@Override
	public void timerTicked(FridgeTimerTickedEvent event) {

		if (fridgeSettings.getCurrentTemp() >= (fridgeSettings.getDesiredRefrigeratorTemp()
				+ fridgeSettings.getCompressorStartDiff())) {
			fridgeContext.changeCurrentState(FridgeCoolingState.instance());
		}
		else {
			display.fridgeTemp(fridgeSettings.getCurrentTemp());
		}
	}

	@Override
	public void timerRanOut(FridgeTimerRanOutEvent event) {
		int currentTemp = fridgeSettings.getCurrentTemp();
		int newTemp = currentTemp + 1;
		if (fridgeSettings.getDesiredRoomTemp() > currentTemp || fridgeSettings.getDesiredRefrigeratorTemp() > currentTemp ) {
			fridgeSettings.setCurrentTemp(newTemp);
		}
		
		display.fridgeTemp(fridgeSettings.getCurrentTemp());
		if (fridgeSettings.getCurrentTemp() >= (fridgeSettings.getDesiredRefrigeratorTemp()
				+ fridgeSettings.getCompressorStartDiff())) {
			fridgeContext.changeCurrentState(FridgeCoolingState.instance());
		}
		FridgeTimer.instance().setTimeValue(fridgeSettings.getRateLossDoorClosed());
	}
}