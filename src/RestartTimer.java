
/**
* The RestartTimer class holds the game timer.
* 
* @author Lena Renshaw 
* @version Version 1.0
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class RestartTimer implements ActionListener{

	private Timer timer;
	private int time; 
	
	/**
	* Constructor for objects of class RestartTimer
	*/
	public RestartTimer() {
		timer = new Timer(1000, (ActionListener)this);
		time = 10;
	}
	
	/**
     * The actionPerformed method enables the timer to decrease by 1 every second
     * @param e the action prompting the restartTimer
     */
	public void actionPerformed(ActionEvent e) {
		time--;
	}
	
	/**
     * The getTime method returns the time
     * @return the current time
     */
	public int getTime() {
		return time;
	}
	
	/**
     * The start method starts the timer
     */
	public void start() {
		timer.start();
	}
	
	/**
     * The stop method stops the timer
     */
	public void stop() {
		timer.stop();
	}
	
	/**
     * The setTime method sets the time to a given number
     * @param n the number to set the time to
     */
	public void setTime(int n) {
		time = n;
	}
	
}
