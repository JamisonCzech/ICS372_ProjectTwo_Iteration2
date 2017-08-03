package state.refrigerator;

import event.refrigerator.FridgeDoorCloseRequestEvent;
import listener.refrigerator.FridgeCloseDoorRequestListener;
import manager.refrigerator.FridgeCloseDoorRequestManager;

public class FridgeOpenState extends FridgeState implements FridgeCloseDoorRequestListener {

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
		refrigeratorDisplay.fridgeDoorOpen();

		refrigeratorDisplay.fridgeTemp();

		refrigeratorDisplay.turnFridgeLightOn();
	}


	@Override
	public void leave() {
		FridgeCloseDoorRequestManager.instance().removeFridgeCloseDoorRequestListener(this);
	}

	
	@Override
	public void closeDoorRequested(FridgeDoorCloseRequestEvent event) {
		fridgeContext.changeCurrentState(FridgeClosedState.instance());
		
	}

}
