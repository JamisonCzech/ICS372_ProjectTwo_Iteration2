package state.refrigerator;

import event.refrigerator.FreezerDoorCloseRequestEvent;
import listener.refrigerator.FreezerCloseDoorRequestListener;
import manager.refrigerator.FreezerCloseDoorRequestManager;
import timer.refrigerator.FreezerTimer;
import timer.refrigerator.FreezerTimerRanOutEvent;
import timer.refrigerator.FreezerTimerRanOutListener;
import timer.refrigerator.FreezerTimerRanOutManager;
import timer.refrigerator.FreezerTimerTickedEvent;
import timer.refrigerator.FreezerTimerTickedListener;
import timer.refrigerator.FreezerTimerTickedManager;

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