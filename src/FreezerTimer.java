
import java.util.Observable;
import java.util.Observer;

/**
 * The Timer for the freezer
 *
 */
public class FreezerTimer extends Timer {
	private static FreezerTimer instance;

	/**
	 * For singleton
	 */
	private FreezerTimer() {
	}

	/**
	 * For singleton pattern
	 * 
	 * @return the instance
	 */
	public static FreezerTimer instance() {
		if (instance == null) {
			instance = new FreezerTimer();
		}
		return instance;
	}

	/**
	 * Get the clock tick and process it
	 */
	@Override
	public void update(Observable clock, Object value) {
		if (--timeValue == 0) {
			FreezerTimerRanOutManager.instance().processEvent(
					new FreezerTimerRanOutEvent(instance));
		} else {
			FreezerTimerTickedManager.instance().processEvent(
					new FreezerTimerTickedEvent(instance));
		}

	}
}