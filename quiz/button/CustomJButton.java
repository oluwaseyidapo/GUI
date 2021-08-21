package quiz.button;

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CustomJButton extends JButton {

	public CustomJButton(String name) {
		super(name);
	}

	@Override
	public void addActionListener(ActionListener eve) {
		super.addActionListener(eve);
	}
}
