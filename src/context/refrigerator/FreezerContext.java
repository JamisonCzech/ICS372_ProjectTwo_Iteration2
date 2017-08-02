package context.refrigerator;
import display.refrigerator.RefrigeratorDisplay;
import state.refrigerator.FreezerClosedState;
import state.refrigerator.FreezerState;

public class FreezerContext {
	private static RefrigeratorDisplay refrigeratorDisplay;
	private FreezerState currentState;
	private static FreezerContext instance;
	
	private FreezerContext() {
		instance = this;
		refrigeratorDisplay.instance();
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
		return refrigeratorDisplay;
	}

}