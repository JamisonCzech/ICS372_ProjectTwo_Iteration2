package timer.refrigerator;

import java.util.Observable;
import java.util.Observer;

/**
 * Abstract class for Time that also implants the Observer class
 *
 * The Observer is:
 *
 * This method is called whenever the observed object is changed. An
 * application calls an <tt>Observable</tt> object's
 * <code>notifyObservers</code> method to have all the object's
 * observers notified of the change.
 *
 */

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

	/**
	 * Adds observer for CLock instance
	 */
	public void initialize() {
		Clock.instance().addObserver(this);
	}

    /**
     *  Abstract method for updating Observable, arg.
     * @param o o
     * @param arg arg
     */
	@Override
	public abstract void update(Observable o, Object arg);

}
