package newproject;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * why did u have this clas if u are not using them
 * @author samson
 *
 */
public class ButtonClass extends JButton {

	public ButtonClass(String name) {
		super(name);
	}

	@Override
	public void addActionListener(ActionListener eve) {
		super.addActionListener(eve);
	}
}
