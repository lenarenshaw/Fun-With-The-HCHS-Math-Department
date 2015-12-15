import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.Timer;

/**
* The Bao class holds the Ms. Bao objects in the game.
* 
* @author Lena Renshaw 
* @version Version 1.0
*/
public class Bao implements ActionListener{
	
	static final int BOARD_WIDTH = 500;
	static final int BOARD_HEIGHT = 700;
	
	private Timer timer = new Timer(25, this);
	private int x;
	private int y;
	private int size;
	private int directionX;
	private int directionY;
	private BufferedImage bao;
	
	/**
     * Constructor for objects of class Bao
     */
	public Bao() {
		x = 40;
		y = 40;
		directionX = 3;
		directionY = 3;
		size = 50;
		
		try {
			bao = ImageIO.read(new File("res/bao.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
     * The draw method draws Ms. Bao
     * 
     * @param g a Graphics object
     */
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.drawImage(bao, x, y, size, size, null);
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
     * The changeX method changes the x- coordinate location of Ms. Bao
     * @param n a new x- coordinate
     */
	public void changeX(int n)
	{
		x += n;
	}
	
	/**
     * The changeY method changes the y- coordinate location of Ms. Bao
     * @param n a new y- coordinate
     */
	public void changeY(int n)
	{
		y += n;
	}
	
	/**
     * The getUp method changes the top coordinate of Ms. Bao
     * @return the top coordinate of Ms. Bao
     */
	public int getUp()
	{
		return y;
	}
	
	/**
     * The getDown method changes the top coordinate of Ms. Bao
     * @return the bottom coordinate of Ms. Bao
     */
	public int getDown()
	{
		return y + size;
	}
	
	/**
     * The getLeft method changes the top coordinate of Ms. Bao
     * @return the left coordinate of Ms. Bao
     */
	public int getLeft() {
		return x;
	}
	
	/**
     * The getRight method changes the right coordinate of Ms. Bao
     * @return the right coordinate of Ms. Bao
     */
	public int getRight() {
		return x + size;
	}
	
	/**
     * The getX method changes the x- coordinate of Ms. Bao
     * @return the x- coordinate of Ms. Bao
     */
	public int getX() {
		return x;
	}
	
	/**
     * The getY method changes the y- coordinate of Ms. Bao
     * @return the y- coordinate of Ms. Bao
     */
	public int getY() {
		return y;
	}
	
	/**
     * The move method changes the x- and y- coordinates of Ms. Bao
     * @param a the new x- coordinate of Ms. Bao
     * @param b the new y- coordinate of Ms. Bao
     */
	public void move(int a, int b)
	{
		x = a;
		y = b; 
	}
	
	/**
     * The getDirX method returns the x- direction of Ms. Bao
     * @return the x- direction of Ms. Bao
     */
	public int getDirX()
	{
		return directionX;
	}
	
	/**
     * The getDirY method returns the y- direction of Ms. Bao
     * @return the y- direction of Ms. Bao
     */
	public int getDirY()
	{
		return directionY;
	}
	
	/**
     * The getDirX method changes the x- direction of Ms. Bao
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
     * The getDirY method changes the y- direction of Ms. Bao
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
     * The getSize method returns the size of Ms. Bao
     * @return the size of Ms. Bao
     * 
     */
	public int getSize()
	{
		return size;
	}

	/**
     * The actionPerformed method moves Ms. Bao
     * @param e the action prompting the move
     */
	public void actionPerformed(ActionEvent e) {
		x += directionX;
		y += directionY;
	}

}