

import java.util.EventListener;

import javax.swing.event.EventListenerList;

//This class handles the fridge open door event and request.
public class FridgeOpenDoorRequestManager {
    private EventListenerList listenerList = new EventListenerList();
    private static FridgeOpenDoorRequestManager instance;


    /**
     * Private to make it a singleton
     */
    private FridgeOpenDoorRequestManager() {
    }

    /**
     * Returns the only instance of the class
     *
     * @return the only instance of the class
     */
    public static FridgeOpenDoorRequestManager instance() {
        if (instance == null) {
            instance = new FridgeOpenDoorRequestManager();
        }
        return instance;
    }

    /**
     * Adds a listener
     *
     * @param listener an object that wants to listen to the event
     */
    public void addFridgeOpenDoorRequestListener(FridgeOpenDoorRequestListener listener) {
        listenerList.add(FridgeOpenDoorRequestListener.class, listener);
    }

    /**
     * Removes a listener
     *
     * @param listener the object to be removed
     */
    public void removeFridgeOpenDoorRequestListener(FridgeOpenDoorRequestListener listener) {
        listenerList.remove(FridgeOpenDoorRequestListener.class, listener);
    }


    /**
     * Handles the request to open Fridge door.
     *
     * @param event the CookRequestEvent object
     */
    public void processEvent(FridgeDoorOpenRequestEvent event) {
        EventListener[] listeners = listenerList
                .getListeners(FridgeOpenDoorRequestListener.class);
        for (int index = 0; index < listeners.length; index++) {
            ((FridgeOpenDoorRequestListener) listeners[index]).openDoorRequested(event);
        }
    }
}
