import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
* The Main class creates the frame and runs the game.
* 
* @author Lena Renshaw 
* @version Version 1.0
*/

public class Main extends JFrame{

	Land land;
	
	/**
     * Constructor for objects of class Main
     */
	public Main() {
		land = new Land();
		setPreferredSize(new Dimension(500,700));
		getContentPane().add(land);
		setVisible(true);
		pack();
		setResizable(true);
	}

	/**
     * The main method for the game
     */
	public static void main (String[] args) {
		Main game = new Main();
	}
	
}