package context.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import settings.refrigerator.FridgeSettings;
import state.refrigerator.FridgeClosedState;
import state.refrigerator.FridgeState;

//This class initializes and handles the state of the fridge.
public class FridgeContext {
	
	private static RefrigeratorDisplay display;
	private FridgeState currentState;
	private static FridgeContext instance;
	private static FridgeSettings settings;
	
	private FridgeContext() {
		instance = this;
		display = RefrigeratorDisplay.instance();
		currentState = FridgeClosedState.instance();
		settings = FridgeSettings.instance();
	}
	
	public static FridgeContext instance() {
		if (instance == null) {
			instance = new FridgeContext();
		}
		return instance;
	}
	
	
	public void initialize() {
		instance.changeCurrentState(FridgeClosedState.instance());
	}
	
	public void changeCurrentState(FridgeState nextState) {
		currentState.leave();
		currentState = nextState;
		nextState.run();
	}
	
	public RefrigeratorDisplay getDisplay() {
		return display;
	}

}
