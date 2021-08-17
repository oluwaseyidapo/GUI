package newproject;

import java.awt.event.ActionListener;
import javax.swing.JButton;
public class ButtonClass extends JButton {

	public ButtonClass(String name) {
		super(name);
	}

	@Override
	public void addActionListener(ActionListener eve) {
		super.addActionListener(eve);
	}
}
