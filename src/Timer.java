import java.util.Observable;
import java.util.Observer;

/**
 * The Timer for the microwave
 *
 */
public class Timer implements Observer {
	private static Timer instance;
	private int timeValue;

	/**
	 * For singleton
	 */
	private Timer() {
		instance = this;
		Clock.instance().addObserver(instance);
	}

	/**
	 * For singleton pattern
	 * 
	 * @return the instance
	 */
	public static Timer instance() {
		if (instance == null) {
			instance = new Timer();
		}
		return instance;
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
	 * Add to the time value
	 * 
	 * @param value
	 *            extra time for the time value
	 */
	public void addTimeValue(int value) {
		timeValue += value;
	}

	/**
	 * Get the remaining time
	 * 
	 * @return
	 */
	public int getTimeValue() {
		return timeValue;
	}

	/**
	 * Get the clock tick and process it
	 */
	@Override
	public void update(Observable clock, Object value) {
		if (--timeValue == 0) {
			TimerRanOutManager.instance().processEvent(
					new TimerRanOutEvent(instance));
		} else {
			TimerTickedManager.instance().processEvent(
					new TimerTickedEvent(instance));
		}

	}
}