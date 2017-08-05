package timer.refrigerator;

import java.util.Observable;
import java.util.Observer;

public abstract class Timer implements Observer{
	
	protected static Timer instance;
	protected int timeValue;
	
	protected Timer() {
		instance = this;
	}
	
	/**
	 * Set the time for the timer
	 * 
	 * @param value
	 *            timer initial value
	 */
	public void setTimeValue(int value) {
		this.timeValue = value;
	}
	
	public void initialize() {
		Clock.instance().addObserver(this);
	}

	@Override
	public abstract void update(Observable o, Object arg);

}
