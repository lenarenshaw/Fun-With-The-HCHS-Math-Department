/**
* The Score class holds the scores of the game.
* 
* @author Lena Renshaw 
* @version Version 1.0
*/
public class Score {

	private int hits;
	
	/**
     * Constructor for objects of class Score
     */
	public Score() {
		hits = 0;
		}
	
	/**
     * Constructor for objects of class Score
     * @param h value for hits
     */
	public Score(int h, String n) {
		hits = h;
	}
	
	/**
     * The hitBao method increases the score by 1
     */
	public void hitBao() {
		hits++;
	}
	
	/**
     * The hitDetch method increases the score by 2
     */
	public void hitDetch() {
		hits +=2;
	}
	
	/**
     * The hitKrilov method increases the score by 3
     */
	public void hitKrilov() {
		hits +=3;
	}
	
	/**
     * The hitKuberska method increases the score by 5
     */
	public void hitKuberska() {
		hits +=5;
	}
	
	/**
     * The hitBao method decreases the score by 7
     */
	public void unHit() {
		hits -= 7;
	}
	
	/**
     * The getScore method returns the score
     * @return the score of the game
     */
	public int getScore() {
		return hits;
	}
	
	/**
     * The reset method sets the score to 0
     */
	public void reset() {
		hits = 0;
	}
	
}
