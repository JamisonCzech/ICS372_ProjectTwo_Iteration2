package state.refrigerator;
import event.refrigerator.FreezerDoorCloseRequestEvent;
import listener.refrigerator.FreezerCloseDoorRequestListener;
import manager.refrigerator.FreezerCloseDoorRequestManager;

public class FreezerOpenState extends FreezerState implements
		FreezerCloseDoorRequestListener{

	private static FreezerOpenState instance;

	
	/**
	 * Private to make it a singleton
	 */
	private FreezerOpenState () {
		
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
		refrigeratorDisplay.freezerDoorOpen();
		refrigeratorDisplay.freezerTemp();
		refrigeratorDisplay.turnFreezerLightOn();
		
	}




	@Override
	public void leave() {
		FreezerCloseDoorRequestManager.instance().removeFreezerCloseDoorRequestListener(this);
		
	}








	@Override
	public void closeDoorRequested(FreezerDoorCloseRequestEvent event) {
		freezerContext.changeCurrentState(FreezerClosedState.instance());
		
	}
	

}
