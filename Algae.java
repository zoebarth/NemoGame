/* 
 * Zoe Barth and Gretchen Picklesimer
 * Gallatin - 1st period
 * CS III Honors
 * 5/23/2018
 */


import java.awt.*;
import java.awt.Graphics;
import java.io.File;
import java.net.URL;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * Algae are objects floating in the Ocean that Nemo must avoid in Level 2
 */
public class Algae
{
	private int x;
	private int y;
	private int speed;
	private int size;
	private Image image;
	private int dy;
	private int dx;
	/**
	 * Creates an Algae object with a specified coordinate, size, and speed
	 * @param xPos the x coordinate
	 * @param yPos the y coordinate
	 * @param s the size
	 * @param sp the speed
	 */
	public Algae(int xPos, int yPos, int s, int sp, int dx, int dy)
	{
		x = xPos;
		y = yPos;
		this.dx=dx;
		this.dy=dy;
		size =s;
		speed = sp;
		try
		{
			URL url = getClass().getResource("algae2.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}
	}
	
	/**
	 * Gets the width of the algae
	 * @return the width
	 */
	public int getWidth()
	{
		return size;
	}
	
	/**
	 * Sets the width of the algae
	 * @param s the width
	 */
	public void setWidth(int s)
	{
		size=s;
	}
	
	/**
	 * Sets the x coordinate
	 * @param xPos the x coordinate
	 */
	public void setX(int xPos)
	{
		x = xPos;
	}
	
	/**
	 * Sets the y coordinate
	 * @param yPos the y coordinate
	 */
	public void setY(int yPos)
	{
		y = yPos;
	}
	
	/**
	 * Sets the speed of the algae
	 * @param s the speed
	 */
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	/**
	 * Returns the x coordinate of the algae
	 * @return the x coordinate
	 */
	public int getX()
	{
		return x;
	}
	
	public void setDirection(int x, int y)
	{
		dx=x;
		dy=y;
	}
	
	public void flipDirection()
	{
		dy=0-dy;
		dx=0-dx;
	}
	public int getdy()
	{
		return dy;
	}
	
	public int getdx()
	{
		return dx;
	}
	/**
	 * Returns the y coordinate of the algae
	 * @return the y coordinate
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Returns the speed of the algae
	 * @return the speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/**
	 * Moves the algae
	 * @param dx the change in x coordinate
	 * @param dy the change in y coordinate
	 */
	public void move()
	{
		y+=dy;
		x+=dx;
	}
	
	/**
	 * Draws the algae in the window
	 * @param window the graphics
	 */
	public void draw(Graphics window)
	{
		window.drawImage(image,x,y,size,size,null);
		window.drawRect(x,y,size,size);
	}
	
	/**
	 * Returns a String representation of the algae
	 * @return the String
	 */
	public String toString()
	{
		return x + " " + y + " " + size  + " " + speed;
	}
	
	public Rectangle getBounds()
	{
		return new Rectangle(x,y,size, size);
	}
}