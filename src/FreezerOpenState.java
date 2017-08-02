
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
		
		
	}




	@Override
	public void leave() {
		
		
	}








	@Override
	public void closeDoorRequested(FreezerDoorCloseRequestEvent event) {
		freezerContext.changeCurrentState(FreezerClosedState.instance());
		
	}
	

}
