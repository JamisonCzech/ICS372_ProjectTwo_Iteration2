package state.refrigerator;

import event.refrigerator.FreezerDoorOpenRequestEvent;
import listener.refrigerator.FreezerOpenDoorRequestListener;
import manager.refrigerator.FreezerOpenDoorRequestManager;
import timer.refrigerator.FreezerTimer;
import timer.refrigerator.FreezerTimerRanOutEvent;
import timer.refrigerator.FreezerTimerRanOutListener;
import timer.refrigerator.FreezerTimerRanOutManager;
import timer.refrigerator.FreezerTimerTickedEvent;
import timer.refrigerator.FreezerTimerTickedListener;
import timer.refrigerator.FreezerTimerTickedManager;

public class FreezerClosedState extends FreezerState
		implements FreezerOpenDoorRequestListener, FreezerTimerRanOutListener, FreezerTimerTickedListener {

	private static FreezerClosedState instance;

	/**
	 * Private to make it a singleton
	 */
	private FreezerClosedState() {
	}

	public static FreezerClosedState instance() {
		if (instance == null) {
			instance = new FreezerClosedState();
		}
		return instance;
	}

	@Override
	public void run() {
		FreezerOpenDoorRequestManager.instance().addFreezerOpenDoorRequestListener(this);
		FreezerTimerRanOutManager.instance().addTimerRanOutListener(this);
		FreezerTimerTickedManager.instance().addTimerTickedListener(this);
		FreezerTimer.instance().setTimeValue(freezerSettings.getRateLossDoorClosed());

		display.freezerDoorClosed();
		display.freezerTemp(freezerSettings.getCurrentTemp());
		display.turnFreezerLightOff();
		display.freezerIdle();
		System.out.println("Enter Freezer Run");
	}

	@Override
	public void leave() {
		FreezerOpenDoorRequestManager.instance().removeFreezerOpenDoorRequestListener(this);
		FreezerTimerRanOutManager.instance().removeTimerRanOutListener(this);
		FreezerTimerTickedManager.instance().removeTimerTickedListener(this);
	}

	@Override
	public void openDoorRequested(FreezerDoorOpenRequestEvent event) {
		freezerContext.changeCurrentState(FreezerOpenState.instance());
	}

	@Override
	public void timerTicked(FreezerTimerTickedEvent event) {
		// Immediately go to cooling state if desired temp is adjusted below
		// current temp
		System.out.println("Freezer Ticked");
		if (freezerSettings.getCurrentTemp() >= (freezerSettings.getDesiredRefrigeratorTemp()
				+ freezerSettings.getCompressorStartDiff())) {
			freezerContext.changeCurrentState(FreezerCoolingState.instance());
		} 
		else {
			display.freezerTemp(freezerSettings.getCurrentTemp());
		}
	}

	@Override
	public void timerRanOut(FreezerTimerRanOutEvent event) {
		int currentTemp = freezerSettings.getCurrentTemp();
		int newTemp = currentTemp + 1;
		freezerSettings.setCurrentTemp(newTemp);
		display.freezerTemp(freezerSettings.getCurrentTemp());
		if (freezerSettings.getCurrentTemp() >= (freezerSettings.getDesiredRefrigeratorTemp()
				+ freezerSettings.getCompressorStartDiff())) {
			freezerContext.changeCurrentState(FreezerCoolingState.instance());
		}
		FreezerTimer.instance().setTimeValue(freezerSettings.getRateLossDoorClosed());
	}
}