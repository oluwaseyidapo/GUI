package newproject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import newproject.Question.QType;

public class NewGame extends JFrame implements ActionListener,ItemListener { 
	// majority if this code is not in use
	private final static String SINGLE_PLAYER= "S";
	private final static String END="end";
	private static String inputLine;
	static ArrayList<Question> list=new ArrayList<Question>();
	Question play;
	String[] seperate;
	public static final int X= 300;
	public static final int Y=250;
	public static final int X_ORIGIN= 150;
	public static final int Y_ORIGIN= 250;
	public static Scanner scan;
	JRadioButton[] check;
	JButton okbutton,nextbutton,reset;
	JTextField input;
	JLabel finalanswer;
	private List<Question> questions;
	JLabel quest;
	Container contentPane;
	String question,type,option1,option2,option3,option4,answer;
	JPanel radioPanel, okpanel;
	ButtonGroup lang;
	static File infile;
	static FileReader reader;
	static BufferedReader bufrea;
	static StringTokenizer token;
	static String line;
	static String tok;
	
	public static void main(String [] args) throws Exception {
		NewGame game= new NewGame();
		//getData();
		//game.split() ;
		game.setVisible(true);
		for(Question play:list) {
			System.out.println(play);
		}
	}
	//Method to read the  file
	public List<Question> reader() throws Exception{
		infile= new File("/Users/samson/eclipse-workspace/test/Book1.csv"); //What if the file doesnt exist and why is infile a class variable?
		reader= new FileReader(infile);//why is reader a class variable?
		bufrea= new BufferedReader(reader); //why is buffer a class variable?
		
		List<Question> collection = new ArrayList<>();
		
		List<String> x = bufrea.lines().collect(Collectors.toList());
		
		for (int i = 0; i < x.size(); i++) {
			String[] content = x.get(i).split(",");
			if(i != 0) {
				
				if(QType.INPUT.getValue().equals(content[1])) {
					collection.add(new InputQuestion(content[0], QType.INPUT, content[6]));
				} else if(QType.MULTI.getValue().equals(content[1])) {
					collection.add(new MultipleChoiceQuestion(content[0], QType.MULTI, content[6],content[2],content[3],content[4],content[5]));
				} else {
					throw new Exception("Wrong question type");
				}
			}
		}
		
		return collection;
	}
// is this in use?
	//method to get tokens
	public  static void getData()throws IOException{
		token = new StringTokenizer(line);
		while(token.hasMoreTokens()) {
			tok = token.nextToken();
			if (tok.equals("end")) {
				System.exit(0);
			}
		}
	}
	
	//You need to clean up ur code all this things in comment is not needed
//	//Seperation of each words, generated from the csv file
//	public  SinglePlayer split() {		
//		seperate=tok.split(" ,;,//");
//		question=seperate[0];
//		type=seperate[1];
//		option1= seperate[2];
//		option2=seperate[3];
//		option3=seperate[4];
//		option4=seperate[5];
//		answer=seperate[6];
//		play= new SinglePlayer(question,type,option1,option2,option3,option4,answer);
//		list.add(play);
//		return play;
//	}
	public NewGame() throws Exception {
		this.questions = reader();
		
		if(this.questions.isEmpty()) {
			throw new Exception("U need questions to play the game");
		}
		
		//contentPane=getContentPane();
		//setSize(X,Y);
		//setTitle("Gui Games");
//		String[] option= {seperate[2],seperate[3],seperate[4],seperate[5]};
//		setLocation(X_ORIGIN,Y_ORIGIN);
//		contentPane.setBackground(Color.WHITE);
//		contentPane.setLayout(new BorderLayout());
//		radioPanel= new JPanel(new GridLayout(0,1));
//		radioPanel.setBorder(BorderFactory.createTitledBorder("Choose the correct option"));
//		lang= new ButtonGroup();
//		check= new JRadioButton[option.length];
//		quest= new JLabel();
//		quest.setText("how are you?");
//		radioPanel.add(quest);
//		for(int i=0; i<check.length;i++) { 
//			check[i]= new JRadioButton(option[i]);
//			radioPanel.add(check[i]);
//			lang.add(check[i]);
//			check[i].addItemListener(this);
//		}
//		okbutton= new JButton("OK");
//		reset= new JButton("ResetButton");
//		input =new JTextField();
//		input.setColumns(10);
//		finalanswer= new JLabel("Correct/Incorrect");
//		nextbutton= new JButton("Next");
//		okpanel= new JPanel(new FlowLayout()); 
//		okpanel.add(okbutton);
//		okpanel.add(reset);
//		okpanel.add(nextbutton);
//		okpanel.add(finalanswer);
//		contentPane.add(radioPanel, BorderLayout.CENTER); 
//		contentPane.add(okpanel, BorderLayout.SOUTH);
//		reset.addActionListener(this);
//		okbutton.addActionListener(this);
//		nextbutton.addActionListener(this);
//		input.addActionListener(this);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	//is this in use
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
	
	//is this in use
	@Override
	public void itemStateChanged(ItemEvent eve) {
		JRadioButton source= (JRadioButton) eve.getSource();
		String state;
		if(eve.getStateChange()== ItemEvent.SELECTED) {
			state = "is Selected";
		} else {
			state= "is deselected";
		}
	}

}


