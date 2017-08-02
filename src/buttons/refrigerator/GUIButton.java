package buttons.refrigerator;
import javax.swing.JButton;

import display.refrigerator.RefrigeratorDisplay;

public abstract class GUIButton extends JButton {
	
	public GUIButton(String string) {
		super(string);
	}
	
	public abstract void inform(RefrigeratorDisplay display);
}
