package buttons.refrigerator;

import display.refrigerator.RefrigeratorDisplay;
import event.refrigerator.FreezerDoorCloseRequestEvent;
import manager.refrigerator.FreezerCloseDoorRequestManager;

// this class derives from the GUI button super class and handles Freezer close button events.
public class FreezerCloseButton extends GUIButton {

    public FreezerCloseButton(String string) {
        super(string);
    }

    /**
     * @param source RefrigeratorDisplay source
     *               processes Freezer Door Closed
     *               button pushed.
     */
    @Override
    public void inform(RefrigeratorDisplay source) {
        FreezerCloseDoorRequestManager.instance()
                .processEvent(new FreezerDoorCloseRequestEvent(source));

    }

}
