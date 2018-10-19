/* 
 * Zoe Barth and Gretchen Picklesimer
 * Gallatin - 1st period
 * CS III Honors
 * 5/23/2018
 */

import java.awt.Color;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * Creates a Nemo that can swim around 
 */
public class Nemo
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int speed;
	private Image image;
	
	/**
	 * Creates a Nemo with specified coordinates, width, height, and speed
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param w the width 
	 * @param h the height
	 * @param s the speed
	 */
	public Nemo(int x, int y, int w, int h, int s)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		speed = s;
		try
		{
			URL url = getClass().getResource("nemopic.gif");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}
	}
	
	/**
	 * Sets the x coordinate
	 * @param x the x coordinate
	 */
	public void setX(int x)
	{
		xPos = x;
	}
	
	/**
	 * Sets the y coordinate
	 * @param y the y coordinate
	 */
	public void setY(int y)
	{
		yPos = y;
	}
	
	/**
	 * Sets Nemo's speed
	 * @param s the speed
	 */
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	/**
	 * Returns Nemo's X coordinate
	 * @return the x coordinate
	 */
	public int getX()
	{
		return xPos;
	}
	
	/**
	 * Returns Nemo's y coordinate
	 * @return the y coordinate
	 */
	public int getY()
	{
		return yPos;
	}
	
	/**
	 * Returns Nemo's speed
	 * @return the speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/** 
	 * Moves Nemo in a specified direction
	 * @param d the direction
	 */
	public void move(String d)
	{
		if(d.equals("u"))
		{
			yPos-=speed;
		}
		else if(d.equals("d"))
		{
			yPos+= speed;
		}
		else if (d.equals("l"))
		{
			xPos-=speed;
		}
		else if(d.equals("r"))
		{
			xPos+= speed;
		}
	}
	
	/**
	 * Returns the height of Nemo
	 * @return the height
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * Returns the width of Nemo
	 * @return the width
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Draws Nemo
	 * @param g the graphics
	 */
	public void draw(Graphics g)
	{
		g.drawImage(image,xPos,yPos,width,height,null);

	}
	
	/**
	 * Returns the bounds of Nemo in rectangle form
	 * @return the rectangle
	 */
	public Rectangle getBounds()
   {
   		return new Rectangle(xPos, yPos, width,height);
   } 

}