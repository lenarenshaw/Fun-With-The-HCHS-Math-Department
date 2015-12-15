import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
* The Land class holds all of the graphics for the game.
* 
* @author Lena Renshaw 
* @version Version 1.0
*/

public class Land extends JPanel{
	
	static final int BOARD_WIDTH = 500;
	static final int BOARD_HEIGHT = 700;
	
	private int finalScore;
	
	Color backgroundColor;
	
	Chaser chaser; 
	Detchkov detchkov;
	Detchkov detchkov1;
	Detchkov detchkov2;
	Detchkov detchkov3;
	Detchkov detchkov4;
	Score score;
	Countdown countdown;
	RestartTimer restartTimer;
	Virus virus;
	Virus virus1;
	Virus virus2;
	Bao bao;
	Bao bao1;
	Krilov krilov;
	Krilov krilov1;
	Kuberska kuberska;
	Kuberska kuberska1;
	
	private BufferedImage background;
	
	/**
     * Constructor for objects of type Land
     */
	public Land() {
	
		chaser = new Chaser();
		detchkov = new Detchkov();
		detchkov1 = new Detchkov();
		detchkov2 = new Detchkov();
		detchkov3 = new Detchkov();
		detchkov4 = new Detchkov();
		bao = new Bao();
		bao1 = new Bao();
		krilov = new Krilov();
		krilov1 = new Krilov();
		kuberska = new Kuberska();
		kuberska1 = new Kuberska();
		score = new Score();
		countdown = new Countdown();
		restartTimer = new RestartTimer();
		virus = new Virus();
		virus1 = new Virus();
		virus2 = new Virus();

		try {
			background = ImageIO.read(new File("res/background.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setBackground(backgroundColor);
		
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setFocusable(true);
		addKeyListener(chaser);
		score.reset();
		repaint();
		
	}
	
	/**
     * The paint method draws all of the objects onto the JPanel
     * @param g is an object of the Graphics class to draw the objects of the game
     */
	public void paint(Graphics g) {	
		g.drawImage(background, 0, 40, BOARD_WIDTH, BOARD_HEIGHT - 40, null);
		Font h = new Font("Helvetica", Font.PLAIN, 15);
		g.setFont(h);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, BOARD_WIDTH, 40);
		
		countdown.start();
		
		if (countdown.getTime() > 60) {
			g.setColor(Color.WHITE);
			g.fillRect(20, 50, BOARD_WIDTH-40, BOARD_HEIGHT - 500);
			g.setColor(Color.BLUE);
			g.drawString("Welcome to Hunter College High School!", 50, 70);	
			if (countdown.getTime() < 72) {
				g.setColor(Color.BLUE);
				g.drawString("This is you. Move with the arrow keys.", 50, 100);
				chaser.draw(g);
			}
			if (countdown.getTime() < 70) {
				g.setColor(Color.BLUE);
				g.drawString("Try to find the math department in the hallway!", 50, 130);
			}
			if (countdown.getTime() < 68) {
				g.setColor(Color.BLUE);
				g.drawString("Remember, the smaller a teacher is, the more points they're worth.", 50, 160);
			}
			if (countdown.getTime() < 67) {
				g.setColor(Color.RED);
				g.drawString("(of course, that's not true in real life!)", 100, 190);
			}
			if (countdown.getTime() < 64) {
				g.setColor(Color.BLUE);
				g.drawString("AND REMEMBER: AVOID MR. YOUNG!", 50, 220);
			}
		}
		else
		{
			g.drawString("Time left: " + Integer.toString(countdown.getTime()), 100, 25);
			g.drawString("Score: " + Integer.toString(score.getScore()), 25, 25);
			detchkov.draw(g);
			detchkov1.draw(g);
			detchkov2.draw(g);
			detchkov3.draw(g);
			detchkov4.draw(g);
			virus.draw(g);
			virus1.draw(g);
			virus2.draw(g);
			bao.draw(g);
			bao1.draw(g);
			krilov.draw(g);
			krilov1.draw(g);
			kuberska.draw(g);
			kuberska1.draw(g);
			chaser.draw(g);
		}
		
		
			
		if (countdown.getTime() == 60) {
			score.reset();
		}
		
		if (countdown.getTime() == 50) {
			virus.expand1();
			virus1.expand1();
			virus2.expand1();
		}
		
		if (countdown.getTime() == 40) {
			virus.expand2();
			virus1.expand2();
			virus2.expand2();
		}
		
		if (countdown.getTime() == 30) {
			virus.expand3();
			virus1.expand3();
			virus2.expand3();
		}
		
		if (countdown.getTime() == 20) {
			virus.expand4();
			virus1.expand4();
			virus2.expand4();
		}
		
		if (countdown.getTime() == 10) {
			virus.expand5();
			virus1.expand5();
			virus2.expand5();
		}
		
		if (countdown.getTime() == 0)
		{
			finalScore = score.getScore();
		}
		
		if (countdown.getTime() < 0)
		{
			countdown.stop();
			chaser.changeSize(0);
			
			g.setColor(Color.RED);
			g.drawString("Final Score: " + Integer.toString(finalScore), 270, 25);
			removeKeyListener(chaser);
			
			restartTimer.start();
			g.drawString("Restart in: " + Integer.toString(restartTimer.getTime()), 390, 25);
			
			
		}
		if (restartTimer.getTime() < 1)
		{
			
			addKeyListener(chaser);
			score.reset();
			virus.reset();
			virus1.reset();
			virus2.reset();
			chaser.changeSize(50);
			restartTimer.stop();
			restartTimer.setTime(10);
			restartTimer.stop();
			countdown.setTime(60);
			countdown.start();
		}
			
		
		if (detchkov.getX() <= 0)
		{
			detchkov.changeDirX();
			detchkov.move(detchkov.getX() + 1, detchkov.getY());
		}
		if (detchkov.getX() >= (BOARD_WIDTH - detchkov.getSize()))
		{
			detchkov.changeDirX();
			detchkov.move(detchkov.getX() - 1, detchkov.getY());
		}
		if (detchkov.getY() <= 40)
		{
			detchkov.changeDirY();
			detchkov.move(detchkov.getX(), detchkov.getY() + 1);
		}
		if (detchkov.getY() >= (BOARD_HEIGHT - detchkov.getSize()))
		{
			detchkov.changeDirY();
			detchkov.move(detchkov.getX(), detchkov.getY() - 1);
		}
		if ((((detchkov.getRight() > chaser.getLeft() && chaser.getRight() > detchkov.getLeft()) 
				&& (detchkov.getUp() < chaser.getDown() && chaser.getUp() < detchkov.getDown())))) 		
				{
					detchkov.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					detchkov.changeDirX();
					detchkov.changeDirY();
					score.hitDetch();
				}
		
		if (detchkov1.getX() <= 0)
		{
			detchkov1.changeDirX();
			detchkov1.move(detchkov1.getX() + 1, detchkov1.getY());
		}
		if (detchkov1.getX() >= (BOARD_WIDTH - detchkov1.getSize()))
		{
			detchkov1.changeDirX();
			detchkov1.move(detchkov1.getX() - 1, detchkov1.getY());
		}
		if (detchkov1.getY() <= 40)
		{
			detchkov1.changeDirY();
			detchkov1.move(detchkov1.getX(), detchkov1.getY() + 1);
		}
		if (detchkov1.getY() >= (BOARD_HEIGHT - detchkov1.getSize()))
		{
			detchkov1.changeDirY();
			detchkov1.move(detchkov1.getX(), detchkov1.getY() - 1);
		}
		if ((((detchkov1.getRight() > chaser.getLeft() && chaser.getRight() > detchkov1.getLeft()) 
				&& (detchkov1.getUp() < chaser.getDown() && chaser.getUp() < detchkov1.getDown())))) 		
				{
					detchkov1.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					detchkov1.changeDirX();
					detchkov1.changeDirY();
					score.hitDetch();
				}
		
		
		if (detchkov2.getX() <= 0)
		{
			detchkov2.changeDirX();
			detchkov2.move(detchkov2.getX() + 1, detchkov2.getY());
		}
		if (detchkov2.getX() >= (BOARD_WIDTH - detchkov2.getSize()))
		{
			detchkov2.changeDirX();
			detchkov2.move(detchkov2.getX() - 1, detchkov2.getY());
		}
		if (detchkov2.getY() <= 40)
		{
			detchkov2.changeDirY();
			detchkov2.move(detchkov2.getX(), detchkov2.getY() + 1);
		}
		if (detchkov2.getY() >= (BOARD_HEIGHT - detchkov2.getSize()))
		{
			detchkov2.changeDirY();
			detchkov2.move(detchkov2.getX(), detchkov2.getY() - 1);
		}
		if ((((detchkov2.getRight() > chaser.getLeft() && chaser.getRight() > detchkov2.getLeft()) 
				&& (detchkov2.getUp() < chaser.getDown() && chaser.getUp() < detchkov2.getDown())))) 		
				{
					detchkov2.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					detchkov2.changeDirX();
					detchkov2.changeDirY();
					score.hitDetch();
				}
		
		if (detchkov3.getX() <= 0)
		{
			detchkov3.changeDirX();
			detchkov3.move(detchkov3.getX() + 1, detchkov3.getY());
		}
		if (detchkov3.getX() >= (BOARD_WIDTH - detchkov3.getSize()))
		{
			detchkov3.changeDirX();
			detchkov3.move(detchkov3.getX() - 1, detchkov3.getY());
		}
		if (detchkov3.getY() <= 40)
		{
			detchkov3.changeDirY();
			detchkov3.move(detchkov3.getX(), detchkov3.getY() + 1);
		}
		if (detchkov3.getY() >= (BOARD_HEIGHT - detchkov3.getSize()))
		{
			detchkov3.changeDirY();
			detchkov3.move(detchkov3.getX(), detchkov3.getY() - 1);
		}
		if ((((detchkov3.getRight() > chaser.getLeft() && chaser.getRight() > detchkov3.getLeft()) 
				&& (detchkov3.getUp() < chaser.getDown() && chaser.getUp() < detchkov3.getDown())))) 		
				{
					detchkov3.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					detchkov3.changeDirX();
					detchkov3.changeDirY();
					score.hitDetch();
				}
		
		if (detchkov4.getX() <= 0)
		{
			detchkov4.changeDirX();
			detchkov4.move(detchkov4.getX() + 1, detchkov4.getY());
		}
		if (detchkov4.getX() >= (BOARD_WIDTH - detchkov4.getSize()))
		{
			detchkov4.changeDirX();
			detchkov4.move(detchkov4.getX() - 1, detchkov4.getY());
		}
		if (detchkov4.getY() <= 40)
		{
			detchkov4.changeDirY();
			detchkov4.move(detchkov4.getX(), detchkov4.getY() + 1);
		}
		if (detchkov4.getY() >= (BOARD_HEIGHT - detchkov4.getSize()))
		{
			detchkov4.changeDirY();
			detchkov4.move(detchkov4.getX(), detchkov4.getY() - 1);
		}
		
		if ((((detchkov4.getRight() > chaser.getLeft() && chaser.getRight() > detchkov4.getLeft()) 
				&& (detchkov4.getUp() < chaser.getDown() && chaser.getUp() < detchkov4.getDown())))) 		
				{
					detchkov4.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					detchkov4.changeDirX();
					detchkov4.changeDirY();
					score.hitDetch();
				}
		
		if (virus.getX() <= 0)
		{
			virus.changeDirX();
			virus.move(virus.getX() + 1, virus.getY());
		}
		if (virus.getX() >= (BOARD_WIDTH - virus.getSize()))
		{
			virus.changeDirX();
			virus.move(virus.getX() - 1, virus.getY());
		}
		if (virus.getY() <= 40)
		{
			virus.changeDirY();
			virus.move(virus.getX(), virus.getY() + 1);
		}
		if (virus.getY() >= (BOARD_HEIGHT - virus.getSize()))
		{
			virus.changeDirY();
			virus.move(virus.getX(), virus.getY() - 1);
		}
		if ((((virus.getRight() > chaser.getLeft() && chaser.getRight() > virus.getLeft()) 
				&& (virus.getUp() < chaser.getDown() && chaser.getUp() < virus.getDown())))) 		
				{
					virus.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					virus.changeDirX();
					virus.changeDirY();
					score.unHit();
				}
		
		if (virus1.getX() <= 0)
		{
			virus1.changeDirX();
			virus1.move(virus1.getX() + 1, virus1.getY());
		}
		if (virus1.getX() >= (BOARD_WIDTH - virus1.getSize()))
		{
			virus1.changeDirX();
			virus1.move(virus1.getX() - 1, virus1.getY());
		}
		if (virus1.getY() <= 40)
		{
			virus1.changeDirY();
			virus1.move(virus1.getX(), virus1.getY() + 1);
		}
		if (virus1.getY() >= (BOARD_HEIGHT - virus1.getSize()))
		{
			virus1.changeDirY();
			virus1.move(virus1.getX(), virus1.getY() - 1);
		}
		if ((((virus1.getRight() > chaser.getLeft() && chaser.getRight() > virus1.getLeft()) 
				&& (virus1.getUp() < chaser.getDown() && chaser.getUp() < virus1.getDown())))) 		
				{
					virus1.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					virus1.changeDirX();
					virus1.changeDirY();
					score.unHit();
				}
		
		if (virus2.getX() <= 0)
		{
			virus2.changeDirX();
			virus2.move(virus2.getX() + 1, virus2.getY());
		}
		if (virus2.getX() >= (BOARD_WIDTH - virus2.getSize()))
		{
			virus2.changeDirX();
			virus2.move(virus2.getX() - 1, virus2.getY());
		}
		if (virus2.getY() <= 40)
		{
			virus2.changeDirY();
			virus2.move(virus2.getX(), virus2.getY() + 1);
		}
		if (virus2.getY() >= (BOARD_HEIGHT - virus2.getSize()))
		{
			virus2.changeDirY();
			virus2.move(virus2.getX(), virus2.getY() - 1);
		}
		if ((((virus2.getRight() > chaser.getLeft() && chaser.getRight() > virus2.getLeft()) 
				&& (virus2.getUp() < chaser.getDown() && chaser.getUp() < virus2.getDown())))) 		
				{
					virus2.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					virus2.changeDirX();
					virus2.changeDirY();
					score.unHit();
				}
		
		if (bao.getX() <= 0)
		{
			bao.changeDirX();
			bao.move(bao.getX() + 1, bao.getY());
		}
		if (bao.getX() >= (BOARD_WIDTH - bao.getSize()))
		{
			bao.changeDirX();
			bao.move(bao.getX() - 1, bao.getY());
		}
		if (bao.getY() <= 40)
		{
			bao.changeDirY();
			bao.move(bao.getX(), bao.getY() + 1);
		}
		if (bao.getY() >= (BOARD_HEIGHT - bao.getSize()))
		{
			bao.changeDirY();
			bao.move(bao.getX(), bao.getY() - 1);
		}
		if ((((bao.getRight() > chaser.getLeft() && chaser.getRight() > bao.getLeft()) 
				&& (bao.getUp() < chaser.getDown() && chaser.getUp() < bao.getDown())))) 		
				{
					bao.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					bao.changeDirX();
					bao.changeDirY();
					score.hitBao();
				}
		if (bao1.getX() <= 0)
		{
			bao1.changeDirX();
			bao1.move(bao1.getX() + 1, bao1.getY());
		}
		if (bao1.getX() >= (BOARD_WIDTH - bao1.getSize()))
		{
			bao1.changeDirX();
			bao1.move(bao1.getX() - 1, bao1.getY());
		}
		if (bao1.getY() <= 40)
		{
			bao1.changeDirY();
			bao1.move(bao1.getX(), bao1.getY() + 1);
		}
		if (bao1.getY() >= (BOARD_HEIGHT - bao1.getSize()))
		{
			bao1.changeDirY();
			bao1.move(bao1.getX(), bao1.getY() - 1);
		}
		if ((((bao1.getRight() > chaser.getLeft() && chaser.getRight() > bao1.getLeft()) 
				&& (bao1.getUp() < chaser.getDown() && chaser.getUp() < bao1.getDown())))) 		
				{
					bao1.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					bao1.changeDirX();
					bao1.changeDirY();
					score.hitBao();
				}
		if (krilov.getX() <= 0)
		{
			krilov.changeDirX();
			krilov.move(krilov.getX() + 1, krilov.getY());
		}
		if (krilov.getX() >= (BOARD_WIDTH - krilov.getSize()))
		{
			krilov.changeDirX();
			krilov.move(krilov.getX() - 1, krilov.getY());
		}
		if (krilov.getY() <= 40)
		{
			krilov.changeDirY();
			krilov.move(krilov.getX(), krilov.getY() + 1);
		}
		if (krilov.getY() >= (BOARD_HEIGHT - krilov.getSize()))
		{
			krilov.changeDirY();
			krilov.move(krilov.getX(), krilov.getY() - 1);
		}
		if ((((krilov.getRight() > chaser.getLeft() && chaser.getRight() > krilov.getLeft()) 
				&& (krilov.getUp() < chaser.getDown() && chaser.getUp() < krilov.getDown())))) 		
				{
					krilov.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					krilov.changeDirX();
					krilov.changeDirY();
					score.hitKrilov();
				}
		if (krilov1.getX() <= 0)
		{
			krilov1.changeDirX();
			krilov1.move(krilov1.getX() + 1, krilov1.getY());
		}
		if (krilov1.getX() >= (BOARD_WIDTH - krilov1.getSize()))
		{
			krilov1.changeDirX();
			krilov1.move(krilov1.getX() - 1, krilov1.getY());
		}
		if (krilov1.getY() <= 40)
		{
			krilov1.changeDirY();
			krilov1.move(krilov1.getX(), krilov1.getY() + 1);
		}
		if (krilov1.getY() >= (BOARD_HEIGHT - krilov1.getSize()))
		{
			krilov1.changeDirY();
			krilov1.move(krilov1.getX(), krilov1.getY() - 1);
		}
		if ((((krilov1.getRight() > chaser.getLeft() && chaser.getRight() > krilov1.getLeft()) 
				&& (krilov1.getUp() < chaser.getDown() && chaser.getUp() < krilov1.getDown())))) 		
				{
					krilov1.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					krilov1.changeDirX();
					krilov1.changeDirY();
					score.hitKrilov();
				}
		if (kuberska.getX() <= 0)
		{
			kuberska.changeDirX();
			kuberska.move(kuberska.getX() + 1, kuberska.getY());
		}
		if (kuberska.getX() >= (BOARD_WIDTH - kuberska.getSize()))
		{
			kuberska.changeDirX();
			kuberska.move(kuberska.getX() - 1, kuberska.getY());
		}
		if (kuberska.getY() <= 40)
		{
			kuberska.changeDirY();
			kuberska.move(kuberska.getX(), kuberska.getY() + 1);
		}
		if (kuberska.getY() >= (BOARD_HEIGHT - kuberska.getSize()))
		{
			kuberska.changeDirY();
			kuberska.move(kuberska.getX(), kuberska.getY() - 1);
		}
		if ((((kuberska.getRight() > chaser.getLeft() && chaser.getRight() > kuberska.getLeft()) 
				&& (kuberska.getUp() < chaser.getDown() && chaser.getUp() < kuberska.getDown())))) 		
				{
					kuberska.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					kuberska.changeDirX();
					kuberska.changeDirY();
					score.hitKuberska();
				}
		if (kuberska1.getX() <= 0)
		{
			kuberska1.changeDirX();
			kuberska1.move(kuberska1.getX() + 1, kuberska1.getY());
		}
		if (kuberska1.getX() >= (BOARD_WIDTH - kuberska1.getSize()))
		{
			kuberska1.changeDirX();
			kuberska1.move(kuberska1.getX() - 1, kuberska1.getY());
		}
		if (kuberska1.getY() <= 40)
		{
			kuberska1.changeDirY();
			kuberska1.move(kuberska1.getX(), kuberska1.getY() + 1);
		}
		if (kuberska1.getY() >= (BOARD_HEIGHT - kuberska1.getSize()))
		{
			kuberska1.changeDirY();
			kuberska1.move(kuberska1.getX(), kuberska1.getY() - 1);
		}
		if ((((kuberska1.getRight() > chaser.getLeft() && chaser.getRight() > kuberska1.getLeft()) 
				&& (kuberska1.getUp() < chaser.getDown() && chaser.getUp() < kuberska1.getDown())))) 		
				{
					kuberska1.move((int)(Math.random()*BOARD_WIDTH), ((int)(Math.random()*(BOARD_HEIGHT-40))+40));
					kuberska1.changeDirX();
					kuberska1.changeDirY();
					score.hitKuberska();
				}
		
		repaint();
		
		
	}
}