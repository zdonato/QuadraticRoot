package calculator; 

import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Window class to contain the GUI for the calculator.
 * @author Zachary Donato
 * Date: 3.10.14
 * Revisions: 
 */

public class Window extends JFrame{
	// Initialize data members. 
	private static final long serialVersionUID = 1L;
	private JLabel root1, root2; 
	private JButton submit;
	private JTextField a, b, c; 
	private Calculator calc = new Calculator(); 
	
	// Set up the constructor for the window. 
	public Window(){
		root1 = new JLabel(""); 
		root2 = new JLabel(""); 
		submit = new JButton("Submit"); 
		setLayout(new FlowLayout()); 
		
		// Add text fields for the coefficients.
		a = new JTextField("a", 10); 
		b = new JTextField("b", 10); 
		c = new JTextField("c", 10); 
		add(a); 
		add(b); 
		add(c);
		// Add the submit button.
		add(submit); 
		
		// Add the labels for roots but keep them empty for now. 
		add(root1); 
		add(root2);
		
		// Create an event to listen for submit click. 
		Event e = new Event(); 
		submit.addActionListener(e); 
	}
	
	public class Event implements ActionListener {
		// Initialize variables. 
		String r1, r2; 
		
		// Calculate the roots when submit is pressed.
		public void actionPerformed(ActionEvent e){
			// Set the roots to empty from any previous submissions. 
			root1.setText(""); 
			root2.setText(""); 
			
			try {
				// Calculate root1.
				r1 = calc.getRoot1(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()), Double.parseDouble(c.getText())); 
				// Calculate root2.
				r2 = calc.getRoot2(Double.parseDouble(a.getText()), Double.parseDouble(b.getText()), Double.parseDouble(c.getText())); 
			} catch (Exception e1){
				root1.setText("Enter a valid number."); 
			}
			
			try { 
				// If the roots exist, check for equality.
				if (r1.equals(r2)){
					root1.setText("One root: " + r1);
				} else {
					root1.setText("Root 1: " + r1.substring(0,7));
					root2.setText("Root 2: " + r2.substring(0,7)); 
				}
			} catch (NullPointerException n){
				root1.setText("Enter a valid number.");
			}
			
			
		} // End actionPerformed.
	} // End Event class.

	
	public static void main(String args[]){
		Window window = new Window(); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setSize(140, 300); 
		window.setTitle("Quadratic Root Finder"); 
	}
	
}
