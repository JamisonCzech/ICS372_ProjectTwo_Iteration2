package state.refrigerator;
import context.refrigerator.FridgeContext;
import display.refrigerator.RefrigeratorDisplay;

public abstract class FridgeState {

	protected static FridgeContext fridgeContext;
	protected static RefrigeratorDisplay refrigeratorDisplay;
	
	protected FridgeState(){
		fridgeContext = FridgeContext.instance();
		refrigeratorDisplay = fridgeContext.getDisplay();
	}
	
	public abstract void leave();

	public abstract void run();

}
