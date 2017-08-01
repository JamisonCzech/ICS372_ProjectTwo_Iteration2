import java.util.Observable;

public abstract class RefrigeratorDisplay extends Observable{
	
	protected static FridgeContext fridgeContext;
	protected static FreezerContext freezerContext;
	protected static RefrigeratorDisplay instance;
	protected RefrigeratorDisplay() {
		instance = this;
		//context = RefrigeratorContext.instance();
	}
	public static RefrigeratorDisplay instance() {
		return instance;
	}
	public void initialize() {
		fridgeContext.initialize();
		freezerContext.initialize();
	}
	
	public abstract void turnFridgeLightOn();
	
	public abstract void turnFridgeLightOff();
	
	public abstract void turnFreezerLightOn();
	
	public abstract void turnFreezerLightOff();
	
	public abstract void fridgeCooling();
	
	public abstract void fridgeIdle();
	
	public abstract void freezerCooling();
	
	public abstract void freezerIdle();
	
	public abstract void fridgeTemp();
	
	public abstract void freezerTemp();
	
	
}
