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
 * Creates a component with a stationary picture of Nemo and his dad
 */
public class MarlinAnimation extends JComponent
{
	private Image image;
	private int xPos;
	private int yPos;

	/**
	 * Creates the component with the picture at a specified coordinate
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public MarlinAnimation(int x, int y)
	{
		setSize(800,600);
		xPos = x;
		yPos = y;
		try
		{
			URL url = getClass().getResource("marlin.gif");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}
	}
	
	/**
    * Draws the picture of Nemo and his dad
    * @param g the graphics object used to draw the picture
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      g2.drawImage(image,xPos,yPos,200,200,null);
   }
   
}