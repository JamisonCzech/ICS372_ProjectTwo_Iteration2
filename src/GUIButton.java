import javax.swing.JButton;

public abstract class GUIButton extends JButton {
	
	public GUIButton(String string) {
		super(string);
	}
	
	public abstract void inform(RefrigeratorDisplay display);
}
