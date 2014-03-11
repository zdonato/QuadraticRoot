package calculator; 

/**
 * @author Zachary Donato
 * This will be the calculator class that will hold all of the methods for computation.
 * Date: 3.9.14
 * Revisions: 
 */

public class Calculator{
	// Initialize data members.
	private double root1; 
	private double root2;
	private double disc; 
	
	// Constructor. 
	public Calculator(){
		
	}
	
	/**
	 * Method getRoot1 to calculate the quadratic root of a given functions coefficients.
	 * @param a Double a, coefficient of the quadratic term.
	 * @param b Double b, coefficient of the linear term.
	 * @param c Double c, the constant of the function.
	 * @return Returns true if the root was found, false otherwise.
	 */
	public String getRoot1(double a, double b, double c){
		// Calculate discriminant.
		disc = (b * b) - (4 * a * c);
		
		// Negative discriminant means imaginary roots.
		if (disc < 0){
			return "No real roots."; 
		}
		
		// If the quadratic term is missing, return only one root.
		if (a == 0){
			root1 = -(c/b); 
			return Double.toString(root1); 
		} else {
			root1 = (-b + Math.sqrt(disc))/(2 * a);  
			return Double.toString(root1);
		} // End else. 
	} // End getRoots. 
	
	/**
	 * Method getRoot1 to calculate the quadratic root of a given functions coefficients.
	 * @param a Double a, coefficient of the quadratic term.
	 * @param b Double b, coefficient of the linear term.
	 * @param c Double c, the constant of the function.
	 * @return Returns the root found or null. 
	 */
	public String getRoot2(double a, double b, double c){
		// Calculate discriminant.
		disc = (b * b) - (4 * a * c);
		
		// Negative discriminant means imaginary roots.
		if (disc < 0){
			return "No real roots."; 
		}
		
		// If the quadratic term is missing, return only one root. 
		if (a == 0){
			root2 = -(c/b); 
			return Double.toString(root2); 
		} else {
			root2 = (-b - Math.sqrt(disc))/(2 * a); 
			return Double.toString(root2); 
		} // End else. 
	} // End getRoots. 
	
}
