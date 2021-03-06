
import java.util.Observable;

import javax.swing.JTextField;

/**
 * Abstract class for Observer pattern
 */
public abstract class RefrigeratorDisplay extends Observable{
	
	protected static FridgeContext fridgeContext;
	protected static FreezerContext freezerContext;
	protected static RefrigeratorDisplay instance;
	
	protected RefrigeratorDisplay() {
		instance = this;
		fridgeContext = FridgeContext.instance();
		freezerContext = FreezerContext.instance();
		
	}
	public static RefrigeratorDisplay instance() {
		return instance;
	}
	public void initialize() {
		fridgeContext.initialize();
		freezerContext.initialize();
		FridgeTimer.instance().initialize();
		FreezerTimer.instance().initialize();
	}
	
	public abstract Integer getInRoomTemp();
	
	public abstract Integer getFreezerTemp();
	
	public abstract Integer getFridgeTemp();
	
	public abstract void turnFridgeLightOn();
	
	public abstract void turnFridgeLightOff();
	
	public abstract void turnFreezerLightOn();
	
	public abstract void turnFreezerLightOff();
	
	public abstract void fridgeCooling();
	
	public abstract void fridgeIdle();
	
	public abstract void freezerCooling();
	
	public abstract void freezerIdle();
	
	public abstract void fridgeTemp(int fridgeTemperature);
	
	public abstract void freezerTemp(int freezerTemperature);
	
	public abstract void fridgeDoorClosed();
	
	public abstract void freezerDoorClosed();
	
	public abstract void fridgeDoorOpen();
	
	public abstract void freezerDoorOpen();
	
	public abstract void clearWarning();
	
	public abstract void setWarning(String warningMessage);
	

	
	
}
