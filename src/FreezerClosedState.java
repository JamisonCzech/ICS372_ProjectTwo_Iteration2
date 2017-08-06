/**
 * The FreezerClosedState class handles the actual mechanism of the freezer when the freezer door is closed. This class is responsible for maintaining the temperature
 * of the freezer when the doors are closed and handles switches between Cooling and Idle state of the freezer.
 */
public class FreezerClosedState extends FreezerState
        implements FreezerOpenDoorRequestListener, FreezerTimerRanOutListener, FreezerTimerTickedListener {

    private static FreezerClosedState instance;

    /**
     * Private to make it a singleton class
     */
    private FreezerClosedState() {
    }

    public static FreezerClosedState instance() {
        if (instance == null) {
            instance = new FreezerClosedState();
        }
        return instance;
    }

    /**
     * Adds Request Listeners
     */
    @Override
    public void run() {
        FreezerOpenDoorRequestManager.instance().addFreezerOpenDoorRequestListener(this);
        FreezerTimerRanOutManager.instance().addTimerRanOutListener(this);
        FreezerTimerTickedManager.instance().addTimerTickedListener(this);
        FreezerTimer.instance().setTimeValue(freezerSettings.getRateLossDoorClosed());

        display.freezerDoorClosed();
        display.freezerTemp(freezerSettings.getCurrentTemp());
        display.turnFreezerLightOff();
        display.freezerIdle();
    }

    /**
     * Removes Request Listeners
     */
    @Override
    public void leave() {
        FreezerOpenDoorRequestManager.instance().removeFreezerOpenDoorRequestListener(this);
        FreezerTimerRanOutManager.instance().removeTimerRanOutListener(this);
        FreezerTimerTickedManager.instance().removeTimerTickedListener(this);
    }

    /**
     *
     * @param event FreezerDoorOpenRequestEvent event
     */
    @Override
    public void openDoorRequested(FreezerDoorOpenRequestEvent event) {
        freezerContext.changeCurrentState(FreezerOpenState.instance());
    }

    /**
     * Immediately go to cooling state if desired temp is adjusted below
     * current temp
     * @param event FreezerTimerTickedEvent event
     */
    @Override
    public void timerTicked(FreezerTimerTickedEvent event) {
        if (freezerSettings.getCurrentTemp() >= (freezerSettings.getDesiredRefrigeratorTemp()
                + freezerSettings.getCompressorStartDiff())) {
            freezerContext.changeCurrentState(FreezerCoolingState.instance());
        } else {
            display.freezerTemp(freezerSettings.getCurrentTemp());
        }
    }

    /**
     *
     * @param event FreezerTimerRanOutEvent event
     */
    @Override
    public void timerRanOut(FreezerTimerRanOutEvent event) {
        int currentTemp = freezerSettings.getCurrentTemp();
        int newTemp = currentTemp + 1;
        if (freezerSettings.getDesiredRoomTemp() > currentTemp || freezerSettings.getDesiredRefrigeratorTemp() > currentTemp) {
            freezerSettings.setCurrentTemp(newTemp);
        }
        display.freezerTemp(freezerSettings.getCurrentTemp());
        if (freezerSettings.getCurrentTemp() >= (freezerSettings.getDesiredRefrigeratorTemp()
                + freezerSettings.getCompressorStartDiff())) {
            freezerContext.changeCurrentState(FreezerCoolingState.instance());
        }
        FreezerTimer.instance().setTimeValue(freezerSettings.getRateLossDoorClosed());
    }
}