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

public class FreezerCoolingState extends FreezerState implements FreezerTimerRanOutListener, FreezerTimerTickedListener, FreezerOpenDoorRequestListener{
	
private static FreezerCoolingState instance;
	
	private FreezerCoolingState() {
		
	}
	
	public static FreezerCoolingState instance() {
		if (instance == null) {
			instance = new FreezerCoolingState();
		}
		return instance;
	}
	
	
	@Override
	public void leave() {
		FreezerOpenDoorRequestManager.instance().removeFreezerOpenDoorRequestListener(this);
		FreezerTimerRanOutManager.instance().removeTimerRanOutListener(this);
		FreezerTimerTickedManager.instance().removeTimerTickedListener(this);
	}

	@Override
	public void run() {
		//Add to clock tick events
		FreezerOpenDoorRequestManager.instance().addFreezerOpenDoorRequestListener(instance);
		FreezerTimerRanOutManager.instance().addTimerRanOutListener(this);
		FreezerTimerTickedManager.instance().addTimerTickedListener(this);
		FreezerTimer.instance().setTimeValue(freezerSettings.getCoolRate());
		display.freezerDoorClosed();
		display.turnFreezerLightOff();
		display.freezerCooling();
		display.freezerTemp(freezerSettings.getCurrentTemp());
	}

	@Override
	public void timerTicked(FreezerTimerTickedEvent event) {
		// Immediately go to cooling state if desired temp is adjusted above current temp
		if (freezerSettings.getCurrentTemp() <= (freezerSettings.getDesiredRefrigeratorTemp())) {
			freezerContext.changeCurrentState(FreezerClosedState.instance());
		}
		else {
			display.freezerTemp(freezerSettings.getCurrentTemp());
		}
	}

	@Override
	public void timerRanOut(FreezerTimerRanOutEvent event) {
		int currentTemp = freezerSettings.getCurrentTemp();
		int newTemp = currentTemp - 1;
		freezerSettings.setCurrentTemp(newTemp);
		display.freezerTemp(freezerSettings.getCurrentTemp());
		if (freezerSettings.getCurrentTemp() <= (freezerSettings.getDesiredRefrigeratorTemp())) {
			freezerContext.changeCurrentState(FreezerClosedState.instance());
		}
		FreezerTimer.instance().setTimeValue(freezerSettings.getCoolRate());
	}

	@Override
	public void openDoorRequested(FreezerDoorOpenRequestEvent event) {
		freezerContext.changeCurrentState(FreezerOpenState.instance());
	}
}