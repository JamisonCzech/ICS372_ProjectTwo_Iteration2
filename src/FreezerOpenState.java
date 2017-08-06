//The FreezerOpenState class handles the actual mechanism of the freezer when the freezer door is opened. This class is responsible for maintaining the temperature 
//of the freezer when the doors are opened and handles switches between idle state of the freezer and lights.
public class FreezerOpenState extends FreezerState
		implements FreezerCloseDoorRequestListener, FreezerTimerRanOutListener, FreezerTimerTickedListener {

	private static FreezerOpenState instance;

	/**
	 * Private to make it a singleton
	 */
	private FreezerOpenState() {
	}

	public static FreezerOpenState instance() {
		if (instance == null) {
			instance = new FreezerOpenState();
		}
		return instance;
	}

	@Override
	public void run() {
		FreezerCloseDoorRequestManager.instance().addFreezerCloseDoorRequestListener(this);
		FreezerTimerRanOutManager.instance().addTimerRanOutListener(this);
		FreezerTimerTickedManager.instance().addTimerTickedListener(this);
		FreezerTimer.instance().setTimeValue(freezerSettings.getRateLossDoorOpen());

		display.freezerDoorOpen();
		display.freezerTemp(freezerSettings.getCurrentTemp());
		display.turnFreezerLightOn();
		display.freezerIdle();
	}

	@Override
	public void leave() {
		FreezerCloseDoorRequestManager.instance().removeFreezerCloseDoorRequestListener(this);
		FreezerTimerRanOutManager.instance().removeTimerRanOutListener(this);
		FreezerTimerTickedManager.instance().removeTimerTickedListener(this);
	}

	@Override
	public void closeDoorRequested(FreezerDoorCloseRequestEvent event) {
		freezerContext.changeCurrentState(FreezerClosedState.instance());
	}

	@Override
	public void timerTicked(FreezerTimerTickedEvent event) {
		display.freezerTemp(freezerSettings.getCurrentTemp());
	}

	@Override
	public void timerRanOut(FreezerTimerRanOutEvent event) {
		int currentTemp = freezerSettings.getCurrentTemp();
		int newTemp = currentTemp + 1;
		if (freezerSettings.getDesiredRoomTemp() > currentTemp) {
			freezerSettings.setCurrentTemp(newTemp);
		}
		display.freezerTemp(freezerSettings.getCurrentTemp());

		FreezerTimer.instance().setTimeValue(freezerSettings.getRateLossDoorOpen());
	}
}