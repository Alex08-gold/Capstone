package letsdothis.src;
import letsdothis.src.EndingListener;

import javax.swing.*;
import java.awt.*;

public class InputWindow extends JFrame {
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 300;
	private JButton submission;
	
	public InputWindow(Terrain terrain) {
		super();
		
		// Create structure of the frame
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Universe specifications");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 1));
		
		// Add instructions to the first panel
		String instructions = "Enter the required dimensions of the universe. "
//				+ "Default values will be used if no input is specified. "
				+ "Press OK when done or cancel to exit.";
		JTextArea instructionsTextArea = new JTextArea(3, 100);
		instructionsTextArea.setText(instructions);
		instructionsTextArea.setWrapStyleWord(true);
		instructionsTextArea.setLineWrap(true);
		instructionsTextArea.setEditable(false);
		add(instructionsTextArea);		
		
		// Create height input box and its label
		String heightInputInstruction = "Enter the desired terrain height below. ";
//				+ "The default is 500.";
		JTextArea heightInputInstructionText = new JTextArea(1, heightInputInstruction.length());
		heightInputInstructionText.setText(heightInputInstruction);
		heightInputInstructionText.setEditable(false);
		add(heightInputInstructionText);
		JTextField inputHeight = new JTextField(100);
		add(inputHeight);
		
		// Create width input box and its label
		String widthInputInstruction = "Enter the desired terrain width below. ";
//				+ "The default is 500.";
		JTextArea widthInputInstructionText = new JTextArea(3, widthInputInstruction.length());
		widthInputInstructionText.setText(widthInputInstruction);
		widthInputInstructionText.setEditable(false);
		add(widthInputInstructionText);
		JTextField inputWidth = new JTextField(100);
		add(inputWidth);
		
		// Create new grid layout for the OK and cancel buttons
		JPanel optionsPanel = new JPanel();
		optionsPanel.setLayout(new GridLayout(1, 2));
		
		// Add OK button
		submission = new JButton("Okay");
		submission.addActionListener(new InputListener(inputHeight, inputWidth, submission, terrain));
		optionsPanel.add(submission);
		
		// Add cancel button
		JButton endButton = new JButton("Cancel");
		endButton.addActionListener(new EndingListener());
		optionsPanel.add(endButton);
		
		// Add the OK/cancel options panel to main panel
		add(optionsPanel);
	}
}
