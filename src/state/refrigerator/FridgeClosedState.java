package state.refrigerator;

import event.refrigerator.FridgeDoorOpenRequestEvent;
import listener.refrigerator.FridgeOpenDoorRequestListener;
import manager.refrigerator.FridgeOpenDoorRequestManager;
import timer.refrigerator.FridgeTimer;
import timer.refrigerator.FridgeTimerRanOutEvent;
import timer.refrigerator.FridgeTimerRanOutListener;
import timer.refrigerator.FridgeTimerRanOutManager;
import timer.refrigerator.FridgeTimerTickedEvent;
import timer.refrigerator.FridgeTimerTickedListener;
import timer.refrigerator.FridgeTimerTickedManager;

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

	@Override
	public void timerTicked(FridgeTimerTickedEvent event) {
		System.out.println("Fridge Ticked");
		// Immediately go to cooling state if desired temp is adjusted below
		// current temp
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
		fridgeSettings.setCurrentTemp(newTemp);
		display.fridgeTemp(fridgeSettings.getCurrentTemp());
		if (fridgeSettings.getCurrentTemp() >= (fridgeSettings.getDesiredRefrigeratorTemp()
				+ fridgeSettings.getCompressorStartDiff())) {
			fridgeContext.changeCurrentState(FridgeCoolingState.instance());
		}
		FridgeTimer.instance().setTimeValue(fridgeSettings.getRateLossDoorClosed());
	}
}