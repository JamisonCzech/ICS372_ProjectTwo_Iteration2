

import java.util.Observable;
import java.util.Observer;

/**
 * The Timer for the fridge
 *
 */
public class FridgeTimer extends Timer{

	private static FridgeTimer instance;

		/**
		 * For singleton
		 */
		private FridgeTimer() {
		}

		/**
		 * For singleton pattern
		 * 
		 * @return the instance
		 */
		public static FridgeTimer instance() {
			if (instance == null) {
				instance = new FridgeTimer();
			}
			return instance;
		}

		/**
		 * Get the clock tick and process it
		 */
		@Override
		public void update(Observable clock, Object value) {
			if (--timeValue == 0) {
				FridgeTimerRanOutManager.instance().processEvent(
						new FridgeTimerRanOutEvent(instance));
			} else {
				FridgeTimerTickedManager.instance().processEvent(
						new FridgeTimerTickedEvent(instance));
			}
		}
}
