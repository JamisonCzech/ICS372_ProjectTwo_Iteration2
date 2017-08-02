package display.refrigerator;
import java.util.Observable;

import context.refrigerator.FreezerContext;
import context.refrigerator.FridgeContext;

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
		fridgeContext = FridgeContext.instance();
		freezerContext = FreezerContext.instance();
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
	
	public void freezerDoorClosed() {
		// TODO Auto-generated method stub
		
	}
	
	
}