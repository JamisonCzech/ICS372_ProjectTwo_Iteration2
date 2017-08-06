package state.refrigerator;
import context.refrigerator.FreezerContext;
import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FreezerSettings;

//This is an abstract class that initialize different states of the freezer.
public abstract class FreezerState {

	protected static FreezerContext freezerContext;
	protected static RefrigeratorDisplay display;
	protected static FreezerSettings freezerSettings;
	
	protected FreezerState(){
		freezerContext = FreezerContext.instance();
		display = freezerContext.getDisplay();
		freezerSettings = FreezerSettings.instance();
	}
	
	public abstract void leave();

	public abstract void run();

	

}
