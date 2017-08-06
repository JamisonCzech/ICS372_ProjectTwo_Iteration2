package context.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import state.refrigerator.FreezerClosedState;
import state.refrigerator.FreezerState;

// This class initializes and handles the state of the freezer
public class FreezerContext {
	private static RefrigeratorDisplay display;
	private FreezerState currentState;
	private static FreezerContext instance;
	
	private FreezerContext() {
		instance = this;
		display = display.instance();
		currentState = FreezerClosedState.instance();
	}
	
	public static FreezerContext instance() {
		if (instance == null) {
			instance = new FreezerContext();
		}
		return instance;
	}
	
	public void initialize() {
		instance.changeCurrentState(FreezerClosedState.instance());
	}
	
	
	public void changeCurrentState(FreezerState nextState) {
		currentState.leave();
		currentState = nextState;
		nextState.run();
	}
	
	public RefrigeratorDisplay getDisplay() {
		return display;
	}

}