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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Creates a component to draw the algae in
 */
public class AlgaeComponent extends JComponent implements Runnable
{	
	private Algae alg;
	private int dx;
	private int dy;
	private Nemo nemo;
	private boolean done;
	
	/**
	 * Creates an Algae Component with a specified Algae, Nemo, change in x, and change in y
	 * @param a the Algae
	 * @param n the Nemo
	 * @param dx the change in x
	 * @param dy the change in y
	 */
	public AlgaeComponent(Algae a, Nemo n, int dx, int dy)
	{
		setSize(800,600);
		alg= a;
		this.dx=dx;
		this.dy=dy;
		nemo =n;
		done = false;

	}
	
	/**
    * Draws the pictures, moves the algae, draws them again.
    * @param g the graphics
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
     	g2.setColor(Color.black);
      g2.draw(g2.getClipBounds());
      repaint();
      alg.draw(g2);
      //g2.drawRect(alg.getX()+15,alg.getY()+15,alg.getWidth()/2, alg.getWidth()/2);
     // System.out.println("AlgaeComponent Paint Component");
   }
   
   /**
    * Moves the algae
    * @param dx the change in x
    * @param dy the change in y
    */
   public void move(int dx, int dy)
   {
   	 alg.move(dx, dy);
   }
   
   /**
    * Gets the x Coordinate of the algae
    * @return the x coordinate
    */
   public int getX()
   {
   	 return alg.getX();
   }
   
   /**
    * Gets the y Coordinate of the algae
    * @return the y coordinate
    */
   public int getY()
   {
   	 return alg.getY();
   }
   
   /**
    * Runs the thread, making the algae move
    */
   public void run()
   {
   	while(!Thread.interrupted() && !done)
			{
				try{
					Thread.sleep(1000);
					Lock lock = new ReentrantLock();
					lock.lock();
					alg.move(dx,dy);
					if(nemo.getBounds().intersects(alg.getBounds())){
						System.out.println("Intersection is working" + getX() + " " + getY()+" : "+nemo.getX()+nemo.getY());
						System.out.println (getBounds()+" "+nemo.getBounds());
						//nemo.setX(0);
						//nemo.setY(0);
						
						repaint();
					}
					if(getX()>375||getY()>250 ||getX()<0 ||getY()<0){
						dx=0-dx;
						dy=0-dy;
					}
					//System.out.println("AlgaeComponent Run ");
					repaint();
					lock.unlock();
				}catch (InterruptedException e){
					
				}

			}
   }
   
   /**
    * Returns a rectangle representing the bounds of the algae used for collision detection
    * @return the rectangle
    */
   public Rectangle getBounds()
   {
   		return alg.getBounds();
   		//return alg.getBounds();
   }
}