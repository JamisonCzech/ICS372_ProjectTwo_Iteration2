package state.refrigerator;
import event.refrigerator.FreezerDoorOpenRequestEvent;
import listener.refrigerator.FreezerOpenDoorRequestListener;
import manager.refrigerator.FreezerOpenDoorRequestManager;

public class FreezerClosedState extends FreezerState implements 
	FreezerOpenDoorRequestListener{
	
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
		refrigeratorDisplay.freezerDoorClosed();
		refrigeratorDisplay.freezerTemp();	
	}

	
	
	@Override
	public void leave() {
		FreezerOpenDoorRequestManager.instance().removeFreezerOpenDoorRequestListener(this);
		
	}

	
	
	
	@Override
	public void openDoorRequested(FreezerDoorOpenRequestEvent event) {
		
		freezerContext.changeCurrentState(FreezerOpenState.instance());
	}






}
