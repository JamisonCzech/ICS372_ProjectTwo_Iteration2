

import javax.swing.JButton;

public abstract class GUIButton extends JButton {

    /**
     * @param string string
     */

    public GUIButton(String string) {
        super(string);
    }

    /**
     * @param display display, Abstract method that
     *                informs the buttons of changes
     *                made.
     */
    public abstract void inform(RefrigeratorDisplay display);
}
