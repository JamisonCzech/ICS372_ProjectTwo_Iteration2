package state.refrigerator;
import context.refrigerator.FridgeContext;
import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FridgeSettings;

public abstract class FridgeState {

	protected static FridgeContext fridgeContext;
	protected static RefrigeratorDisplay display;
	protected static FridgeSettings fridgeSettings;
	
	protected FridgeState(){
		fridgeContext = FridgeContext.instance();
		display = fridgeContext.getDisplay();
		fridgeSettings = FridgeSettings.instance();
	}
	
	public abstract void leave();

	public abstract void run();

}
