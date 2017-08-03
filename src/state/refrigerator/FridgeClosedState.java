package state.refrigerator;

import event.refrigerator.FridgeDoorOpenRequestEvent;
import listener.refrigerator.FridgeOpenDoorRequestListener;
import manager.refrigerator.FridgeOpenDoorRequestManager;

public class FridgeClosedState extends FridgeState implements FridgeOpenDoorRequestListener{

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
		refrigeratorDisplay.fridgeDoorClosed();
		refrigeratorDisplay.fridgeTemp();
		refrigeratorDisplay.turnFridgeLightOff();
	}

	@Override
	public void leave() {
		FridgeOpenDoorRequestManager.instance().removeFridgeOpenDoorRequestListener(this);
	}

	@Override
	public void openDoorRequested(FridgeDoorOpenRequestEvent event) {
		fridgeContext.changeCurrentState(FridgeOpenState.instance());

	}


	

}
