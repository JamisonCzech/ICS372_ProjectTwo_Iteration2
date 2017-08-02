
public abstract class RefrigeratorUnitState {
	protected static FridgeContext fridgeContext;
	protected static FreezerContext freezerContext;
	
	protected static RefrigeratorDisplay displayFridge;
	protected static RefrigeratorDisplay displayFreezer;
	
	/**
	 * Initialzies the context and display
	 */
	protected RefrigeratorUnitState() {
		fridgeContext = FridgeContext.instance();
		displayFridge = fridgeContext.getDisplay();
		freezerContext = FreezerContext.instance();
		displayFreezer = freezerContext.getDisplay();
		
	}

	/**
	 * Initializes the state
	 */
	public abstract void run();

	/**
	 * When the Microwave leaves from this state, this method is called to
	 * remove the state as a listener for the appropriate events.
	 */
	public abstract void leave();
}

	
	

