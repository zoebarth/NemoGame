/* 
 * Zoe Barth and Gretchen Picklesimer
 * Gallatin - 1st period
 * CS III Honors
 * 5/23/2018
 */

import java.awt.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * Creates a Bubble object
 */
public class Bubble
{
	int xPos;
	int yPos;
	int size;
	int speed;
	
	/**
	 * Creates a bubble at a specified coordinate, with a specified size and speed
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @param s the size
	 * @param sp the speed
	 */
	public Bubble(int x, int y, int s, int sp)
	{
		xPos =x;
		yPos = y;
		size =s;
		speed = sp;
	}
	
	/**
	 * Draws the bubble
	 * @param g the graphics
	 */
	public void draw(Graphics g)
	{
		g.setColor(Color.white);
		g.drawOval(xPos, yPos, size, size);	
	}
	
	/**
	 * Moves the bubble to the right
	 */
	public void move()
	{
		xPos+= speed;
	}
	
	/**
	 * Returns the x coordinate of the bubble
	 * @return the x coordinate
	 */
	public int getX()
	{
		return xPos;
	}
	
		/**
	 * Returns the bounds of the bubble in rectangle form
	 * @return the rectangle
	 */
	public Rectangle getBounds()
   {
   		return new Rectangle(xPos, yPos,size,size);
   } 
}