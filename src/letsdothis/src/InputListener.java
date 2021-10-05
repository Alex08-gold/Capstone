package letsdothis.src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputListener implements ActionListener {
	private JTextField heightInput;
	private JTextField widthInput;
	private JButton button;
	Terrain terrain;
	
	public InputListener(JTextField heightInput, JTextField widthInput, JButton button, Terrain terrain) {
		this.heightInput = heightInput;
		this.widthInput = widthInput;
		this.button = button;
		this.terrain = terrain;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			int height = stringToInt(heightInput);	
			int width = stringToInt(widthInput);
			terrain.setDimensions(height, width);
			String message = "Creating terrain of height " + terrain.getTerrainHeight() +  
					" and width " + terrain.getTerrainWidth();
			JOptionPane.showMessageDialog(button, message);
			
			// Create terrain GUI 
			Universe.getUniverse(terrain);
		} catch (NumberFormatException numberError) {
			JOptionPane.showMessageDialog(button, "Invalid input. Only whole numbers are allowed.");
			heightInput.setText("");
			widthInput.setText("");
		}
	}
	
	private static Integer stringToInt(JTextField inputValue) {
		// TODO move this logic to Terrain class
		String stringInputValue = inputValue.getText();
		return Integer.parseInt(stringInputValue.trim());
	}
	
}
