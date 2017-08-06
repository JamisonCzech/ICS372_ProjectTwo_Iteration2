//The FreezerCoolingState class handles the actual mechanism of the freezer when the freezer is cooling. This class is responsible for decreasing the temperature 
//of the freezer when the doors are closed until it reaches the desired temperature.
public class FreezerCoolingState extends FreezerState implements FreezerTimerRanOutListener, FreezerTimerTickedListener, FreezerOpenDoorRequestListener {

    private static FreezerCoolingState instance;

    /**
     * Private to make it a singleton class
     */
    private FreezerCoolingState() {
    }

    public static FreezerCoolingState instance() {
        if (instance == null) {
            instance = new FreezerCoolingState();
        }
        return instance;
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
     * Removes Request Listeners
     */
    @Override
    public void run() {
        //Add to clock tick events
        FreezerOpenDoorRequestManager.instance().addFreezerOpenDoorRequestListener(instance);
        FreezerTimerRanOutManager.instance().addTimerRanOutListener(this);
        FreezerTimerTickedManager.instance().addTimerTickedListener(this);
        FreezerTimer.instance().setTimeValue(freezerSettings.getCoolRate());
        display.freezerDoorClosed();
        display.turnFreezerLightOff();
        display.freezerCooling();
        display.freezerTemp(freezerSettings.getCurrentTemp());
    }

    /**
     * Adds Request Listeners
     */
    @Override
    public void timerTicked(FreezerTimerTickedEvent event) {
        // Immediately go to cooling state if desired temp is adjusted above current temp
        if (freezerSettings.getCurrentTemp() <= (freezerSettings.getDesiredRefrigeratorTemp())) {
            freezerContext.changeCurrentState(FreezerClosedState.instance());
        } else {
            display.freezerTemp(freezerSettings.getCurrentTemp());
        }
    }

    @Override
    public void timerRanOut(FreezerTimerRanOutEvent event) {
        int currentTemp = freezerSettings.getCurrentTemp();
        int newTemp = currentTemp - 1;
        freezerSettings.setCurrentTemp(newTemp);
        display.freezerTemp(freezerSettings.getCurrentTemp());
        if (freezerSettings.getCurrentTemp() <= (freezerSettings.getDesiredRefrigeratorTemp())) {
            freezerContext.changeCurrentState(FreezerClosedState.instance());
        }
        FreezerTimer.instance().setTimeValue(freezerSettings.getCoolRate());
    }

    /**
     *
     * @param event FreezerDoorOpenRequestEvent event
     */
    @Override
    public void openDoorRequested(FreezerDoorOpenRequestEvent event) {
        freezerContext.changeCurrentState(FreezerOpenState.instance());
    }
}