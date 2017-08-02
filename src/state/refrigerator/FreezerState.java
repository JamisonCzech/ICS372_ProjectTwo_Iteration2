package state.refrigerator;
import context.refrigerator.FreezerContext;
import display.refrigerator.RefrigeratorDisplay;

public abstract class FreezerState {

	protected static FreezerContext freezerContext;
	protected static RefrigeratorDisplay refrigeratorDisplay;
	
	protected FreezerState(){
		freezerContext = FreezerContext.instance();
		refrigeratorDisplay = freezerContext.getDisplay();
	}
	
	public abstract void leave();

	public abstract void run();

	

}
