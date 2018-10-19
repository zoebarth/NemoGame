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
 * Level1 is the tutorial level in which Nemo learns how to swim toward a blue arrow
 */
public class Level1F extends JFrame implements KeyListener
{
	
	private Image background;
	private NemoComponent comp;
	private boolean[] keys;
	
	/**
	 * Creates Level1
	 */
	public Level1F()
	{
		setSize(800,600);
		setResizable(false);
		setTitle("Level 1");
		keys = new boolean[4];
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try
		{
			URL url = getClass().getResource("level1.jpg");
			background = ImageIO.read(url);
			setContentPane(new JPanel(new BorderLayout()) 
			{
        		@Override public void paintComponent(Graphics g) {
            g.drawImage(background, 0, 0, null);
        }
			});
		
		}
		catch(Exception e)
		{
		}
		comp = new NemoComponent(100,100);
		add(comp);
		addKeyListener(this);
		setVisible(true);
	}
	
	/**
    *Invoked when a key has been pressed.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void keyPressed(KeyEvent e)
   {
	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
   		{
   				keys[1]=true;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_UP)
   		{
   			keys[0]=true;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
   		{
			keys[3]=true;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
   		{
			keys[2]=true;
   		}
   		if(comp.getNemo().getX()> 680 && comp.getNemo().getY()> 430)
   		{
   				close();
   				StartingAnimation3 an = new StartingAnimation3();
   		}
   		if(keys[0] && comp.getNemo().getY()>0){
   			comp.move("u");
   		}
   		if(keys[1]&& comp.getNemo().getX()<710){

   				comp.move("r");
   			}
   	 if(keys[2]&& comp.getNemo().getY()<490){
   			comp.move("d");
   		}
   		if(keys[3]&& comp.getNemo().getX()>0){
   			comp.move("l");
   		}

   	   comp.repaint();
   }

   /**
    *Invoked when a key has been released.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void	keyReleased(KeyEvent e)
   {
   	if (e.getKeyCode() == KeyEvent.VK_RIGHT)
   		{
   				keys[1]=false;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_UP)
   		{
   			keys[0]=false;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
   		{
			keys[3]=false;
   		}
   		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
   		{
			keys[2]=false;
   		}
   }
   
   /**
    *Invoked when a key has been typed.
    *@param e the keyEvent which is triggered by the key beging clicked
    */
   public void keyTyped(KeyEvent e)
   {
   }
   
   /**
    *Closes the window
    */
   public void close()
	{
		setVisible(false);
	}

}

/**
 * Creates a NemoComponent where Nemo can move
 */
class NemoComponent extends JComponent
{
	
	private Nemo nemo;

	/**
	 * Makes a NemoComponent with Nemo at a specified index
	 * @param x Nemo's x coordinate
	 * @param y Nemo's y coordinate
	 */
	public NemoComponent(int x, int y)
	{
		setSize(800,600);
		nemo = new Nemo(x,y,80,80,10);

	}
	
	public NemoComponent(Nemo n)
	{
		nemo =n;
	}
	
	/**
    * Draws the pictures, moves Nemo, draws them again.
    * @param g the graphics object
    */
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;
      nemo.draw(g2);
   }
   
   /**
    * Moves Nemo in a spcified direction
    * @param s the string of the direction
    */
   public void move(String s)
   {
   	 nemo.move(s);
   }
   
   /**
    * Returns the Nemo Object
    * @return the Nemo
    */
   public Nemo getNemo()
   {
   	 return nemo;
   }
   
   public Rectangle getBounds()
   {
   		return new Rectangle(nemo.getX(), nemo.getY(), nemo.getWidth(),nemo.getHeight());
   } 
//   /**
//    * Returns the x coordinate of Nemo
//    * @return the x coordinate 
//    */
//   public int getX()
//   {
//   	 return nemo.getX();
//   }
//   
//   /**
//    * Returns the y coordinate of Nemo
//    * @return the y coordinate
//    */
//   public int getY()
//   {
//   	 return nemo.getY();
//   }
}