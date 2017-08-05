package state.refrigerator;
import context.refrigerator.FreezerContext;
import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;

public abstract class FreezerState {

	protected static FreezerContext freezerContext;
	protected static RefrigeratorDisplay refrigeratorDisplay;
	protected static FreezerSettings freezerSettings;
	
	protected FreezerState(){
		freezerContext = FreezerContext.instance();
		refrigeratorDisplay = freezerContext.getDisplay();
		freezerSettings = FreezerSettings.instance();
	}
	
	public abstract void leave();

	public abstract void run();

	

}
