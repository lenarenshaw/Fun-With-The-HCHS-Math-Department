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
* The Virus class holds the virus in the game.
* 
* @author Lena Renshaw 
* @version Version 1.0
*/

public class Virus implements ActionListener{

		
		private Timer timer = new Timer(25, this);
		private int x;
		private int y;
		private int size;
		private int directionX;
		private int directionY;
		private BufferedImage stephen;

		/**
	     * Constructor for objects of class Virus
	     */
		public Virus() {
			x = 400;
			y = 100;
			directionX = 3;
			directionY = 3;
			size = 50;
			
			try {
				stephen = ImageIO.read(new File("res/Stephen.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		/**
	     * The draw method draws virus
	     * 
	     * @param g a Graphics object
	     */
		public void draw(Graphics g) {
			g.setColor(Color.YELLOW);
			g.drawImage(stephen, x, y, size, size, null);
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
	     * The changeX method changes the x- coordinate location of virus
	     * @param n a new x- coordinate
	     */
		public void changeX(int n)
		{
			x += n;
		}
		
		/**
	     * The changeY method changes the y- coordinate location of virus
	     * @param n a new y- coordinate
	     */
		public void changeY(int n)
		{
			y += n;
		}
		
		/**
	     * The getUp method changes the top coordinate of virus
	     * @return the top coordinate of virus
	     */
		public int getUp()
		{
			return y;
		}
		
		/**
	     * The getDown method changes the top coordinate of virus
	     * @return the bottom coordinate of virus
	     */
		public int getDown()
		{
			return y + size;
		}
		
		/**
	     * The getLeft method changes the top coordinate of virus
	     * @return the left coordinate of virus
	     */
		public int getLeft() {
			return x;
		}
		
		/**
	     * The getRight method changes the right coordinate of virus
	     * @return the right coordinate of virus
	     */
		public int getRight() {
			return x + size;
		}
		
		/**
	     * The getX method changes the x- coordinate of virus
	     * @return the x- coordinate of virus
	     */
		public int getX() {
			return x;
		}
		
		/**
	     * The getY method changes the y- coordinate of virus
	     * @return the y- coordinate of virus
	     */
		public int getY() {
			return y;
		}
		
		/**
	     * The move method changes the x- and y- coordinates of virus
	     * @param a the new x- coordinate of virus
	     * @param b the new y- coordinate of virus
	     */
		public void move(int a, int b)
		{
			x = a;
			y = b; 
		}
		
		/**
	     * The getDirX method returns the x- direction of virus
	     * @return the x- direction of virus
	     */
		public int getDirX()
		{
			return directionX;
		}
		
		/**
	     * The getDirY method returns the y- direction of virus
	     * @return the y- direction of virus
	     */
		public int getDirY()
		{
			return directionY;
		}
		
		/**
	     * The getDirX method changes the x- direction of virus
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
	     * The getDirY method changes the y- direction of virus
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
	     * The getSize method returns the size of virus
	     * @return the size of virus
	     * 
	     */
		public int getSize()
		{
			return size;
		}

		/**
	     * The actionPerformed method moves virus
	     * @param e the action prompting the move
	     */
		public void actionPerformed(ActionEvent e) {
			x += directionX;
			y += directionY;
		}
		
		/**
	     * The reset method resets the size of the virus
	     * 
	     */
		public void reset() {
			size = 50;
		}
		
		/**
	     * The expand method expands the size of the virus to 70
	     * 
	     */
		public void expand1() {
			size = 70;
		}
		
		/**
	     * The expand method expands the size of the virus to 90
	     * 
	     */
		public void expand2() {
			size = 90;
		}
		
		/**
	     * The expand method expands the size of the virus to 110
	     * 
	     */
		public void expand3() {
			size = 110;
		}
		
		/**
	     * The expand method expands the size of the virus to 130
	     * 
	     */
		public void expand4() {
			size = 130;
		}
		
		/**
	     * The expand method expands the size of the virus to 150
	     * 
	     */
		public void expand5() {
			size = 150;
		}

	}

