import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
* The Chaser class holds the user controlled chaser.
* 
* @author Lena Renshaw 
* @version Version 1.0
*/


public class Chaser implements KeyListener{
	private int x;
	private int y;
	private int size;
	private int speed;
	private BufferedImage lena;
	
	/**
     * Constructor for objects of class Chaser
     */	
	public Chaser() {
		x = 400;
		y = 100;
		
		size = 50;
		speed = 5;
		
		try {
			lena = ImageIO.read(new File("res/lena.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * The draw method draws the chaser
     * 
     * @param g a Graphics object
     */
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.drawImage(lena, x, y, size, size, null);
	}

	/**
	 * The keyTyped method is inherited from KeyListener but overridden in this class
     */
	public void keyTyped(KeyEvent e) {	}

	/**
	 * The keyPressed method takes user input from the keyboard to move the chaser
     */
	public void keyPressed(KeyEvent e) {

	switch(e.getKeyCode()) {	
		case KeyEvent.VK_UP:
			y -= speed;
			break;
		case KeyEvent.VK_DOWN: 
			y += speed;
			break;
		case KeyEvent.VK_LEFT: 
			x -= speed;
			break;
		case KeyEvent.VK_RIGHT: 
			x += speed;
			break;
		default: 
			y += 0;
			x += 0;
			break;
		}	
		
		
	}

	/**
	 * The keyReleased method is inherited from KeyListener but overridden in this class
     */
	public void keyReleased(KeyEvent e) {	}
	
	/**
     * The getUp method changes the top coordinate of the chaser
     * @return the top coordinate of the chaser
     */
	public int getUp()
	{
		return y;
	}
	
	/**
     * The getDown method changes the top coordinate of the chaser
     * @return the bottom coordinate of the chaser
     */
	public int getDown()
	{
		return y + size;
	}
	
	/**
     * The getLeft method changes the top coordinate of the chaser
     * @return the left coordinate of the chaser
     */
	public int getLeft() {
		return x;
	}
	
	/**
     * The getRight method changes the right coordinate of the chaser
     * @return the right coordinate of the chaser
     */
	public int getRight() {
		return x + size;
	}
	
	/**
     * The getX method changes the x- coordinate of the chaser
     * @return the x- coordinate of the chaser
     */
	public int getX() {
		return x;
	}
	
	/**
     * The getY method changes the y- coordinate of the chaser
     * @return the y- coordinate of the chaser
     */
	public int getY() {
		return y;
	}
	
	/**
     * The changeSize method changes the size of the chaser
     * @param the new size of the chaser
     */
	public void changeSize(int n) {
		size = n;
	}
	

}
