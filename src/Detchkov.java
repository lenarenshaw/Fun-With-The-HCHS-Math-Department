import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;


/**
* The Detchkov class holds the Mr. Detchkov objects in the game.
* 
* @author Lena Renshaw 
* @version Version 1.0
*/
public class Detchkov implements ActionListener{
	
	static final int BOARD_WIDTH = 500;
	static final int BOARD_HEIGHT = 700;
	
	private Timer timer = new Timer(25, this);
	private int x;
	private int y;
	private int size;
	private int directionX;
	private int directionY;
	private BufferedImage detch;
	
	/**
     * Constructor for objects of class Detchkov
     */
	public Detchkov() {
		x = 40;
		y = 40;
		directionX = 3;
		directionY = 3;
		size = 40;
		
		try {
			detch = ImageIO.read(new File("res/detch.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * The draw method draws Mr. Detchkov
     * 
     * @param g a Graphics object
     */
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawImage(detch, x, y, size, size, null);
		timer.start();
	}
	
	/**
     * The stop method stops the timer
     */
	public void stop()
	{
		timer.stop();
	}
	
	/**
     * The start method starts the timer
     */
	public void start() {
		timer.start();
	}
	
	/**
     * The changeX method changes the x- coordinate location of Mr. Detchkov
     * @param n a new x- coordinate
     */
	public void changeX(int n)
	{
		x += n;
	}
	
	/**
     * The changeY method changes the y- coordinate location of Mr. Detchkov
     * @param n a new y- coordinate
     */
	public void changeY(int n)
	{
		y += n;
	}
	
	/**
     * The getUp method changes the top coordinate of Mr. Detchkov
     * @return the top coordinate of Mr. Detchkov
     */
	public int getUp()
	{
		return y;
	}
	
	/**
     * The getDown method changes the top coordinate of Mr. Detchkov
     * @return the bottom coordinate of Mr. Detchkov
     */
	public int getDown()
	{
		return y + size;
	}
	
	/**
     * The getLeft method changes the top coordinate of Mr. Detchkov
     * @return the left coordinate of Mr. Detchkov
     */
	public int getLeft() {
		return x;
	}
	
	/**
     * The getRight method changes the right coordinate of Mr. Detchkov
     * @return the right coordinate of Mr. Detchkov
     */
	public int getRight() {
		return x + size;
	}
	
	/**
     * The getX method changes the x- coordinate of Mr. Detchkov
     * @return the x- coordinate of Mr. Detchkov
     */
	public int getX() {
		return x;
	}
	
	/**
     * The getY method changes the y- coordinate of Mr. Detchkov
     * @return the y- coordinate of Mr. Detchkov
     */
	public int getY() {
		return y;
	}
	
	/**
     * The move method changes the x- and y- coordinates of Mr. Detchkov
     * @param a the new x- coordinate of Mr. Detchkov
     * @param b the new y- coordinate of Mr. Detchkov
     */
	public void move(int a, int b)
	{
		x = a;
		y = b; 
	}
	
	/**
     * The getDirX method returns the x- direction of Mr. Detchkov
     * @return the x- direction of Mr. Detchkov
     */
	public int getDirX()
	{
		return directionX;
	}
	
	/**
     * The getDirY method returns the y- direction of Mr. Detchkov
     * @return the y- direction of Mr. Detchkov
     */
	public int getDirY()
	{
		return directionY;
	}
	
	/**
     * The getDirX method changes the x- direction of Mr. Detchkov
     * 
     */
	public void changeDirX()
	{
		if (getDirX() < 0)
		{
			directionX = 1;
			directionX *= ((int)(Math.random()*5)+1);
		}
		else
		{
			directionX = -1;
			directionX *= ((int)(Math.random()*5)+1);
		}
		
	}
	
	/**
     * The getDirY method changes the y- direction of Mr. Detchkov
     * 
     */
	public void changeDirY()
	{
		if (getDirY() < 0)
		{
			directionY = 1;
			directionY *= ((int)(Math.random()*5)+1);
		}
		else
		{
			directionY = -1;
			directionY *= ((int)(Math.random()*5)+1);
		}
	}
	
	/**
     * The getSize method returns the size of Mr. Detchkov
     * @return the size of Mr. Detchkov
     * 
     */
	public int getSize()
	{
		return size;
	}

	/**
     * The actionPerformed method moves Mr. Detchkov
     * @param e the action prompting the move
     */
	public void actionPerformed(ActionEvent e) {
		x += directionX;
		y += directionY;
	}

}