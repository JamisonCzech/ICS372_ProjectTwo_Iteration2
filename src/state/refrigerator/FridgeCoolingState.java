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

public class FridgeCoolingState extends FridgeState implements FridgeTimerRanOutListener, FridgeTimerTickedListener, FridgeOpenDoorRequestListener{
	
	private static FridgeCoolingState instance;
	
	private FridgeCoolingState() {
		
	}
	
	public static FridgeCoolingState instance() {
		if (instance == null) {
			instance = new FridgeCoolingState();
		}
		return instance;
	}
	
	
	@Override
	public void leave() {
		FridgeOpenDoorRequestManager.instance().removeFridgeOpenDoorRequestListener(this);
		FridgeTimerRanOutManager.instance().removeTimerRanOutListener(this);
		FridgeTimerTickedManager.instance().removeTimerTickedListener(this);
	}

	@Override
	public void run() {
		//Add to clock tick events
		FridgeOpenDoorRequestManager.instance().addFridgeOpenDoorRequestListener(instance);
		FridgeTimerRanOutManager.instance().addTimerRanOutListener(this);
		FridgeTimerTickedManager.instance().addTimerTickedListener(this);
		FridgeTimer.instance().setTimeValue(fridgeSettings.getCoolRate());
		display.fridgeDoorClosed();
		display.turnFridgeLightOff();
		display.fridgeCooling();
		display.fridgeTemp(fridgeSettings.getCurrentTemp());
		
	}


	@Override
	public void timerTicked(FridgeTimerTickedEvent event) {
		// Immediately go to cooling state if desired temp is adjusted above current temp
		if (fridgeSettings.getCurrentTemp() <= (fridgeSettings.getDesiredRefrigeratorTemp())) {
			fridgeContext.changeCurrentState(FridgeClosedState.instance());
		}
		else {
			display.fridgeTemp(fridgeSettings.getCurrentTemp());
		}
		
	}


	@Override
	public void timerRanOut(FridgeTimerRanOutEvent event) {
		int currentTemp = fridgeSettings.getCurrentTemp();
		int newTemp = currentTemp - 1;
		fridgeSettings.setCurrentTemp(newTemp);
		display.fridgeTemp(fridgeSettings.getCurrentTemp());
		if (fridgeSettings.getCurrentTemp() <= (fridgeSettings.getDesiredRefrigeratorTemp())) {
			fridgeContext.changeCurrentState(FridgeClosedState.instance());
		}
		
		FridgeTimer.instance().setTimeValue(fridgeSettings.getCoolRate());
		
	}

	@Override
	public void openDoorRequested(FridgeDoorOpenRequestEvent event) {
		fridgeContext.changeCurrentState(FridgeOpenState.instance());
		
	}
	
}
