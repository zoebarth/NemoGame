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
 * Creates a component to
 */
public class Level2Component extends JComponent implements Runnable
{	
	private LinkedList<Algae> alg;
	private int dx;
	private int dy;
	private Nemo nemo;
	private TreasureChest chest;
	private boolean done;
	private Level2 levelPart;
	
	/**
	 * Creates an Algae Component with a specified Algae, Nemo, change in x, and change in y
	 * @param a the Algae
	 * @param n the Nemo
	 * @param dx the change in x
	 * @param dy the change in y
	 */
	public Level2Component(Nemo n, TreasureChest ch, LinkedList<Algae> alge, Level2 lp)
	{
		alg = alge;
		setSize(800,600);
		this.dx=3;
		this.dy=3;
		nemo =n;
		chest=ch;
		done = false;
		levelPart=lp;
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
      for(Algae al:alg){
      	al.draw(g2);
      }
      nemo.draw(g2);
      chest.draw(g2);
   }
   
   
   /**
    * Runs the thread, making the algae move
    */
   public void run()
   {
   	while(!Thread.interrupted() && !done)
			{
				try{
					Thread.sleep(100);
					Lock lock = new ReentrantLock();
					lock.lock();
					for(Algae al:alg){
						al.move();
						if(nemo.getBounds().intersects(al.getBounds())){
							System.out.println("Intersection is working" + getX() + " " + getY()+" : "+nemo.getX()+nemo.getY());
							System.out.println (al.getBounds()+" "+nemo.getBounds());
							nemo.setX(0);
							nemo.setY(0);
						}
						if(al.getX()>750||al.getY()>500 ||al.getX()<0 ||al.getY()<0){
							al.flipDirection();
						}
						if(nemo.getBounds().intersects(chest.getBounds())){
   	   						
   	   						done = true;
   	   						if(levelPart instanceof Level2Part2){
   	   							//levelPart = new Level2Part3();
   	   						}
   	   						else{
   	   							levelPart = new Level2Part2();
   	   							levelPart.stop();
   	   						}
   	  					}
					}
					
					
					
					//System.out.println("AlgaeComponent Run ");
					repaint();
					lock.unlock();
				}catch (InterruptedException e){
					
				}

			}
   }
}