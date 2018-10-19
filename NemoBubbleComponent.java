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
import java.util.concurrent.locks.*;

/**
 * Makes a component where the bubbles are shot from Nemo's gills and move horizontally to the right
 */
public class NemoBubbleComponent extends JComponent implements Runnable
{
	
	LinkedList<Bubble> list;
	private NemoComponent nemo;
	private Jellyfish[][] jelly;
	
	/**
	 * Makes a NemoBubbleComponent with a specified NemoComponent as a parameter
	 * @param n the NemoComponent
	 */
	public NemoBubbleComponent(NemoComponent n)
	{
		setSize(800,600);
		list = new LinkedList<Bubble>();
		nemo=n;
		jelly = new Jellyfish[2][3];
		for(int r = 0; r< 2; r++)
		{
			for(int c = 0; c< 3; c++)
			{
				
				jelly[r][c] = new Jellyfish(r*150 + 500, c*150 + 50 + (80*r), 80, 80, 3);
			}
		}
		
	}
	
	/**
    * Draws all the bubbles in the bubble list
    * @param g the graphics object
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      for(Bubble b: list)
		{
			b.draw(g);
		}	
      for(Jellyfish[] row : jelly)
	    {
	      	for(Jellyfish j : row)
	      	{
	      		if(j!= null)
	      		j.draw(g);
	      	}
	    }
    
   }
   
   
   /**
    *Adds a bubble to the bubblelist in the component
    *@param bub the bubble
    */
   public void add(Bubble b)
   {
   	 Lock lock = new ReentrantLock();
	 lock.lock();
   	 list.add(b);
	 if(list.size()>25)
	 {
		list.remove(0);
	 }
	 lock.unlock();
   }
   
   /**
    * Tells if the 2d array of Jellyfish is empty
    * @return if it's empty
    */
   public boolean isEmpty()
   {
   	boolean empty = true;
   	for(Jellyfish[] row : jelly)
	    {
	      	for(Jellyfish j : row)
	      	{
	      		if(j!= null)
	      		empty = false;
	      	}
	    }
	 return empty;
   }
   
   public boolean youLose()
   {
   	    boolean lose = false;
   	  	for(Jellyfish[] row : jelly)
	    {
	      	for(Jellyfish j : row)
	      	{
	      		if(j!= null && j.getX()<=100)
	      		lose = true;
	      	}
	    }
	   return lose;
   }
   
   /**
    *Makes the bubbles move to the right every 100 miliseconds
    */
   public void run()
	{
		
		while(!Thread.interrupted())
		{
			Lock lock = new ReentrantLock();
			lock.lock();
			try
			{	
				Thread.sleep(80);
				for(Bubble b: list)
				{
					b.move();
				}
				for(Jellyfish[] row : jelly)
		    	{
		      		for(Jellyfish j : row)
		      		{
		      			if(j!= null)
		      			j.move("l");
		      		}
		    	}
				
				for(int r = 0; r< 2; r++)
				{
					for(int c = 0; c< 3; c++)
					{
						for(Bubble bub : list)
						{
							if(jelly[r][c]!= null && jelly[r][c].getBounds().intersects(bub.getBounds()))
							{
								jelly[r][c] = null;
							}
						}
					}
				}
				repaint();			
			}
			catch(InterruptedException e){
			}
			lock.unlock();
		}
	}
}

