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
	private JLabel root1, root2, aLabel, bLabel, cLabel, title; 
	private JButton submit;
	private JTextField a, b, c; 
	private Calculator calc = new Calculator(); 
	
	// Set up the constructor for the window. 
	public Window(){
		// Initialize the variables.
		setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		Event e = new Event(); 
		
		title = new JLabel("Calculate Quadratic Root"); 
		g.fill = GridBagConstraints.HORIZONTAL;
		g.gridx = 1;
		g.gridy = 0;
		add(title, g); 
		
		aLabel = new JLabel("A:"); 
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 0; 
		g.gridy = 1; 
		add(aLabel, g); 
		
		a = new JTextField(5); 
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 1; 
		g.gridy = 1; 
		
		add(a, g); 
		
		bLabel = new JLabel("B:");
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 0; 
		g.gridy = 2; 
		
		add(bLabel, g);
		
		b = new JTextField(5); 
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 1;
		g.gridy = 2;
		
		add(b, g); 
		
		cLabel = new JLabel("C:"); 
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 0; 
		g.gridy = 3;
		add(cLabel, g); 
		
		c = new JTextField(5); 
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 1; 
		g.gridy = 3; 
		add(c, g); 
		
		submit = new JButton("Submit"); 
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 1; 
		g.gridy = 4;
		add(submit, g); 
		
		root1 = new JLabel(""); 
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 2; 
		g.gridy = 1;
		add(root1, g); 
		
		root2 = new JLabel(""); 
		g.fill = GridBagConstraints.HORIZONTAL; 
		g.gridx = 2; 
		g.gridy = 2; 
		add(root2, g); 
		
		
		// Create an event to listen for submit click. 
		submit.addActionListener(e); 
		getRootPane().setDefaultButton(submit); 
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
				if (r1.equals("none") || r2.equals("none"))
					root1.setText("No real roots."); 
				else if (r1.equals(r2))
					root1.setText("One root: " + r1);
				else {
					root1.setText("Root 1: " + r1);
					root2.setText("Root 2: " + r2);
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
		window.setSize(500, 200); 
		window.setTitle("Quadratic Root Finder"); 
	}
	
}
