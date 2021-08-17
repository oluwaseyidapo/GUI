package newproject;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Testing extends JFrame implements ActionListener,ItemListener{
	public static final int X= 300;
	public static final int Y=250;
	public static final int X_ORIGIN= 150;
	public static final int Y_ORIGIN= 250;
	public static Scanner scan;
	JRadioButton[] check;
	JButton okbutton,nextbutton,reset;
	JTextField input;
	JLabel finalanswer;
	JLabel quest;
	Container contentPane;
	String question,type,option1,option2,option3,option4,answer;
	JPanel radioPanel, okpanel;
	ButtonGroup lang;
	public static void main(String [] args) {
		Testing test= new Testing();
		test.setVisible(true);
	}
	public Testing() {
		contentPane=getContentPane();
		setSize(X,Y);
		setTitle("Gui Games");
		String[] option= {"option1","option2","option3","option4"};
		setLocation(X_ORIGIN,Y_ORIGIN);
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(new BorderLayout());
		 radioPanel= new JPanel(new GridLayout(0,1));
		 radioPanel.setBorder(BorderFactory.createTitledBorder("Choose the correct option"));
		 lang= new ButtonGroup();
		 quest= new JLabel();
		  quest.setText("how are you?");
		  radioPanel.add(quest);
		 check= new JRadioButton[option.length];
		  for(int i=0; i<check.length;i++) { 
			  check[i]= new JRadioButton(option[i]);
			  radioPanel.add(check[i]);
			  lang.add(check[i]);
			  check[i].addItemListener(this);
		  }
		  okbutton= new JButton("OK");
			reset= new JButton("ResetButton");
			input =new JTextField();
			input.setColumns(10);
			
		finalanswer= new JLabel("Correct/Incorrect");
		nextbutton= new JButton("Next");
		 okpanel= new JPanel(new FlowLayout()); 
		  okpanel.add(okbutton);
		  okpanel.add(reset);
		  okpanel.add(nextbutton);
		  okpanel.add(finalanswer);
		contentPane.add(radioPanel, BorderLayout.CENTER); 
		contentPane.add(okpanel, BorderLayout.SOUTH);
		reset.addActionListener(this);
		okbutton.addActionListener(this);
		nextbutton.addActionListener(this);
		input.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	@Override
	public void actionPerformed(ActionEvent event) {
		String favourite=null;
		int i=0;
		while(favourite==null) {
			if(check[i].isSelected()) {
				favourite=check[i].getText();
			}
			i++;
		}
		JOptionPane.showMessageDialog(this, "your favourite answer is" + favourite);
		
	}
	@Override
	public void itemStateChanged(ItemEvent eve) {
	JRadioButton source= (JRadioButton) eve.getSource();
	String state;
	if(eve.getStateChange()== ItemEvent.SELECTED) {
		state = "is Selected";
	} else {
		state= "is deselected";
	}
//JOptionPane.showMessageDialog(this, "JCheckBox" + source.getText() + " " + state);
	}
		
	}
	
	
