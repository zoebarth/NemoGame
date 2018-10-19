import java.awt.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TreasureChest
{
	private int x;
	private int y;
	private int height;
	private int width;
	private Image image;
	
	public TreasureChest(int x, int y, int h, int w)
	{
		this.x=x;
		this.y=y;
		width=w;
		height=h;
		
		try
		{
			URL url = getClass().getResource("treasurechest.jpg");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
		}

	}
	 /**
    * Draws the pictures, moves Nemo, draws them again.
    */
   
   	public void draw(Graphics window)
	{
		window.drawImage(image,x,y,height,width,null);
	}
   public void move(int dx, int dy)
   {
   	 x+=dx;
   	 y+=dy;
   }
   
   public int getX()
   {
   	 return x;
   }
   
   public int getY()
   {
   	 return y;
   }
   
   public Rectangle getBounds()
   {
   		return new Rectangle(x,y, height, width);
   }
}
