package state.refrigerator;

import event.refrigerator.FridgeDoorCloseRequestEvent;
import listener.refrigerator.FridgeCloseDoorRequestListener;
import manager.refrigerator.FridgeCloseDoorRequestManager;
import timer.refrigerator.FridgeTimer;
import timer.refrigerator.FridgeTimerRanOutEvent;
import timer.refrigerator.FridgeTimerRanOutListener;
import timer.refrigerator.FridgeTimerRanOutManager;
import timer.refrigerator.FridgeTimerTickedEvent;
import timer.refrigerator.FridgeTimerTickedListener;
import timer.refrigerator.FridgeTimerTickedManager;

public class FridgeOpenState extends FridgeState
		implements FridgeCloseDoorRequestListener, FridgeTimerRanOutListener, FridgeTimerTickedListener {

	private static FridgeOpenState instance;

	/**
	 * Private to make it a singleton
	 */
	private FridgeOpenState() {
	}

	public static FridgeOpenState instance() {
		if (instance == null) {
			instance = new FridgeOpenState();
		}
		return instance;
	}

	@Override
	public void run() {
		FridgeCloseDoorRequestManager.instance().addFridgeCloseDoorRequestListener(this);
		FridgeTimerRanOutManager.instance().addTimerRanOutListener(this);
		FridgeTimerTickedManager.instance().addTimerTickedListener(this);
		FridgeTimer.instance().setTimeValue(fridgeSettings.getRateLossDoorOpen());

		display.fridgeDoorOpen();
		display.fridgeTemp(fridgeSettings.getCurrentTemp());
		display.turnFridgeLightOn();
		display.fridgeIdle();
	}

	@Override
	public void leave() {
		FridgeCloseDoorRequestManager.instance().removeFridgeCloseDoorRequestListener(this);
		FridgeTimerRanOutManager.instance().removeTimerRanOutListener(this);
		FridgeTimerTickedManager.instance().removeTimerTickedListener(this);
	}

	@Override
	public void closeDoorRequested(FridgeDoorCloseRequestEvent event) {
		fridgeContext.changeCurrentState(FridgeClosedState.instance());
	}

	@Override
	public void timerTicked(FridgeTimerTickedEvent event) {
		display.fridgeTemp(fridgeSettings.getCurrentTemp());
	}

	@Override
	public void timerRanOut(FridgeTimerRanOutEvent event) {
		int currentTemp = fridgeSettings.getCurrentTemp();
		int newTemp = currentTemp + 1;
		
		if (fridgeSettings.getDesiredRoomTemp() > currentTemp) {
			fridgeSettings.setCurrentTemp(newTemp);
		}
		
		display.fridgeTemp(fridgeSettings.getCurrentTemp());

		FridgeTimer.instance().setTimeValue(fridgeSettings.getRateLossDoorOpen());
	}
}