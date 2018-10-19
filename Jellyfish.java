/* 
 * Zoe Barth and Gretchen Picklesimer
 * Gallatin - 1st period
 * CS III Honors
 * 5/23/2018
 */

import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.io.File;
import java.net.URL;
import java.awt.Image;
import javax.imageio.ImageIO;

/**
 * Creates a Jellyfish that can swim around 
 */
public class Jellyfish
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private int speed;
	private Image image;
	
	/**
	 * Creates a Jellyfish with specified coordinates, width, height, and speed
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param w the width 
	 * @param h the height
	 * @param s the speed
	 */
	public Jellyfish(int x, int y, int w, int h, int s)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		speed = s;
		try
		{
			URL url = getClass().getResource("jellyfish.png");
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
	 * Sets the speed
	 * @param s the speed
	 */
	public void setSpeed(int s)
	{
		speed = s;
	}
	
	/**
	 * Returns the X coordinate
	 * @return the x coordinate
	 */
	public int getX()
	{
		return xPos;
	}
	
	/**
	 * Returns the y coordinate
	 * @return the y coordinate
	 */
	public int getY()
	{
		return yPos;
	}
	
	/**
	 * Returns the speed
	 * @return the speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	
	/** 
	 * Moves Jellyfish in a specified direction
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
	 * Draws the Jellyfish
	 * @param g the graphics
	 */
	public void draw(Graphics g)
	{
		g.drawImage(image,xPos,yPos,width,height,null);
	}
	
	/**
	 * Returns the bounds of the Jellyfish in rectangle form
	 * @return the rectangle
	 */
	public Rectangle getBounds()
   {
   		return new Rectangle(xPos, yPos, width,height);
   } 
}