package state.refrigerator;

import event.refrigerator.FridgeDoorCloseRequestEvent;
import manager.refrigerator.FridgeCloseDoorRequestManager;
import listener.refrigerator.FridgeCloseDoorRequestListener;

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
	}


	@Override
	public void leave() {
		
	}

	
	@Override
	public void closeDoorRequested(FridgeDoorCloseRequestEvent event) {
		fridgeContext.changeCurrentState(FridgeClosedState.instance());
		
	}

}
